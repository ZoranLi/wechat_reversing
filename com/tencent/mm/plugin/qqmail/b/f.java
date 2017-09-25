package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public final class f extends h {
    public static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private HttpPost ozu;

    private class a implements HttpEntity {
        private File file;
        private int length;
        private String ozv;
        private String ozw;
        final /* synthetic */ f ozx;

        public a(f fVar, String str, String str2, String str3) {
            this.ozx = fVar;
            this.ozv = str;
            this.file = new File(str2);
            this.ozw = str3;
            this.length = (str.length() + ((int) this.file.length())) + str3.length();
        }

        public final boolean isRepeatable() {
            return true;
        }

        public final boolean isChunked() {
            return !isRepeatable();
        }

        public final boolean isStreaming() {
            return !isRepeatable();
        }

        public final long getContentLength() {
            return (long) this.length;
        }

        public final Header getContentType() {
            return new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + f.BOUNDARY);
        }

        public final Header getContentEncoding() {
            return null;
        }

        public final InputStream getContent() {
            throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
        }

        public final void writeTo(OutputStream outputStream) {
            Throwable th;
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(this.ozv);
            FileInputStream fileInputStream;
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                fileInputStream = new FileInputStream(this.file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            dataOutputStream.write(bArr, 0, read);
                        } else {
                            dataOutputStream.flush();
                            fileInputStream.close();
                            dataOutputStream.writeBytes(this.ozw);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }

        public final void consumeContent() {
            if (isStreaming()) {
                throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
            }
        }
    }

    public final c a(String str, String str2, b bVar, com.tencent.mm.plugin.qqmail.b.h.a aVar) {
        c cVar;
        int i = 0;
        w.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + bVar);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            String a = a(bVar);
            String str3 = bVar.ozG.filePath;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\r\n");
            stringBuilder.append("------" + BOUNDARY + "--\r\n");
            HttpEntity aVar2 = new a(this, a, str3, stringBuilder.toString());
            this.ozu = new HttpPost(h.c(str, str2, bVar.ozE));
            this.ozu.setHeader("User-Agent", lRl);
            this.ozu.setHeader("Host", host);
            this.ozu.setHeader("Connection", "Keep-Alive");
            this.ozu.setHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.ozu.setHeader("Cookie", h.G(bVar.ozF));
            this.ozu.setEntity(aVar2);
            HttpResponse execute = defaultHttpClient.execute(this.ozu);
            i = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            str3 = execute.getFirstHeader("set-cookie").getValue();
            cVar = new c(i, h.CO(str3), EntityUtils.toString(entity));
            w.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + cVar);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.HttpClientUtil", e, "", new Object[0]);
            if (i == 0) {
                i = 503;
            }
            cVar = new c(i, null, null);
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
        return cVar;
    }

    public final void cancel() {
        w.d("MicroMsg.HttpClientUtil", "cancel conection.");
        if (this.ozu != null && !this.ozu.isAborted()) {
            this.ozu.abort();
        }
    }

    private static String a(b bVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bVar.ozE.keySet()) {
            String str2;
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append((String) bVar.ozE.get(str2));
            stringBuilder.append("\r\n");
        }
        File file = new File(bVar.ozG.filePath);
        if (file.isFile()) {
            str2 = file.getName();
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + bVar.ozG.fLE + "\"; filename=\"" + str2 + "\"\r\n");
            stringBuilder.append("\r\n");
            return stringBuilder.toString();
        }
        throw new InvalidParameterException("The path to upload isnot a file.");
    }
}
