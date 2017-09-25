package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class b {
    protected final String lRl = "weixin/android";

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ae jWW;
        final /* synthetic */ b usi;
        final /* synthetic */ c usj;
        final /* synthetic */ b usk;

        public AnonymousClass1(b bVar, b bVar2, c cVar, ae aeVar) {
            this.usk = bVar;
            this.usi = bVar2;
            this.usj = cVar;
            this.jWW = aeVar;
        }

        public final void run() {
            this.usk.a(this.usi, this.usj);
            if (this.jWW != null) {
                this.jWW.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 usl;

                    {
                        this.usl = r1;
                    }

                    public final void run() {
                        this.usl.usj.onComplete();
                    }
                });
            } else {
                this.usj.onComplete();
            }
        }
    }

    public static class a {
        public String filePath;
    }

    public static class b {
        public String host;
        public int jbJ;
        public int ozD = 0;
        public Map<String, String> ozE = null;
        public Map<String, String> ozF = null;
        public String uri;
        public String usm;
        public a usn = null;

        public final String getUrl() {
            StringBuilder stringBuilder = new StringBuilder();
            if (!(this.uri.startsWith("http://") || this.uri.startsWith("https://"))) {
                stringBuilder.append(this.usm + this.host);
            }
            stringBuilder.append(this.uri);
            if (this.ozE == null) {
                return stringBuilder.toString();
            }
            stringBuilder.append('?');
            Object obj = 1;
            for (String str : this.ozE.keySet()) {
                stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bg.mz((String) this.ozE.get(str)), ProtocolPackage.ServerEncoding));
                obj = null;
            }
            return stringBuilder.toString();
        }

        public final String toString() {
            try {
                return getUrl();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.HttpWrapperBase", e, "", new Object[0]);
                return "";
            }
        }
    }

    public static class c {
        public String content;
        public Map<String, String> ozF;
        public int status;
        public a usn;

        public c(int i, Map<String, String> map, String str) {
            this.status = 0;
            this.status = 0;
            this.ozF = null;
            this.content = str;
        }

        public String toString() {
            return "Response status:" + this.status + ", cookie:" + (this.ozF != null ? this.ozF : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
        }

        public void onComplete() {
        }
    }

    public abstract void a(b bVar, c cVar);

    public static Map<String, String> CO(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
