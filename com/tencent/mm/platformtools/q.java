package com.tencent.mm.platformtools;

import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class q {
    public static boolean a(final String str, final String str2, final boolean z, boolean z2, int i, final int i2) {
        if (!z2) {
            return a(str, str2, z, i2);
        }
        e.b(new Runnable() {
            public final void run() {
                q.a(str, str2, z, i2);
            }
        }, "StackReportUploader_uploadFileDirect", i);
        return true;
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        return a(str, str2, z, z2, 1, 20003);
    }

    public static boolean a(String str, String str2, boolean z, int i) {
        FileInputStream fileInputStream;
        Throwable e;
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.StackReportUploader", "uploadFile param err file:%s  user:%s", str, str2);
            return false;
        }
        int aN = com.tencent.mm.a.e.aN(str);
        if (aN <= 0) {
            w.e("MicroMsg.StackReportUploader", "uploadFile err len file:%s len:%d", str, Integer.valueOf(aN));
            return false;
        } else if (aN <= 128000) {
            r2 = com.tencent.mm.a.e.d(str, 0, -1);
            boolean a = a(r2, str, str2, i);
            String str3 = "MicroMsg.StackReportUploader";
            String str4 = "uploadFile ret:%b size:%d file:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a);
            objArr[1] = Integer.valueOf(r2 != null ? r2.length : -1);
            objArr[2] = str;
            w.d(str3, str4, objArr);
            if (a && z) {
                com.tencent.mm.a.e.d(new File(str));
            }
            return a;
        } else {
            int i2 = (aN / 127988) + 1;
            byte[] bArr = new byte[128000];
            int Nz = (int) bg.Nz();
            try {
                fileInputStream = new FileInputStream(str);
                int i3 = 0;
                while (i3 < i2) {
                    try {
                        int read = fileInputStream.read(bArr, 12, 127988);
                        if (read < 0) {
                            w.e("MicroMsg.StackReportUploader", "uploadFile read failed file:%s", str);
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                            return false;
                        }
                        boolean a2;
                        a(Nz, bArr, 0);
                        a(i3, bArr, 4);
                        a(read, bArr, 8);
                        if (read < 127988) {
                            r2 = new byte[(read + 12)];
                            System.arraycopy(bArr, 0, r2, 0, r2.length);
                            a2 = a(r2, str, str2, i);
                        } else {
                            a2 = a(bArr, str, str2, i);
                        }
                        w.d("MicroMsg.StackReportUploader", "uploadFile idx:%d(%d) read:%d ret:%b size:%d file:%s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(read), Boolean.valueOf(a2), Integer.valueOf(aN), str);
                        i3++;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                if (z) {
                    com.tencent.mm.a.e.d(new File(str));
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                try {
                    w.e("MicroMsg.StackReportUploader", "exception:%s", bg.g(e));
                    w.e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", str);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
    }

    private static boolean a(int i, byte[] bArr, int i2) {
        if (128000 < i2 + 4) {
            return false;
        }
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        return true;
    }

    private static boolean a(byte[] bArr, String str, String str2, int i) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.StackReportUploader", "read file failed:%s", str);
            return false;
        } else if (bArr.length > 128000) {
            w.e("MicroMsg.StackReportUploader", "file :%s data len error:%d", str, Integer.valueOf(bArr.length));
            return false;
        } else {
            String toLowerCase = g.n(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.sYN), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
            byte[] l = com.tencent.mm.a.q.l(bArr);
            if (bg.bm(l)) {
                w.e("MicroMsg.StackReportUploader", "zip data failed file:%s", str);
                return false;
            }
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, l, toLowerCase.getBytes());
            l = pByteArray.value;
            if (bg.bm(l)) {
                w.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", str);
            }
            String str3 = "http://" + ab.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str3 + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(d.sYN));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(d.DEVICE_TYPE);
            stringBuffer.append("&filelength=");
            stringBuffer.append(r2);
            stringBuffer.append("&sum=");
            stringBuffer.append(toLowerCase);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(i);
            stringBuffer.append("&reportvalue=");
            stringBuffer.append(bg.Nz() + ".0.1");
            if (!(str2 == null || str2.equals(""))) {
                stringBuffer.append("&username=");
                stringBuffer.append(str2);
            }
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpPost = new HttpPost(stringBuffer.toString());
            try {
                HttpEntity byteArrayEntity = new ByteArrayEntity(l);
                byteArrayEntity.setContentType("binary/octet-stream");
                httpPost.setEntity(byteArrayEntity);
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                if (execute == null || execute.getStatusLine() == null) {
                    w.e("MicroMsg.StackReportUploader", "execute http failed resp null");
                    return false;
                } else if (execute.getStatusLine().getStatusCode() == m.CTRL_INDEX) {
                    return true;
                } else {
                    w.e("MicroMsg.StackReportUploader", "error response code:%d ", Integer.valueOf(execute.getStatusLine().getStatusCode()));
                    return false;
                }
            } catch (Throwable e) {
                w.e("MicroMsg.StackReportUploader", "exception:%s", bg.g(e));
                w.d("MicroMsg.StackReportUploader", "execute post failed msg:%s", e.getMessage());
                return false;
            }
        }
    }
}
