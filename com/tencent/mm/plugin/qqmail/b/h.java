package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class h {
    protected static String host = "";
    protected static int jbJ = 0;
    protected static String lRl = "weixin/android";
    protected static String ozC = "";

    public interface a {
        void aUn();
    }

    public static class b {
        int ozD;
        Map<String, String> ozE;
        Map<String, String> ozF;
        d ozG;

        public b(int i, Map<String, String> map, Map<String, String> map2, d dVar) {
            this.ozD = i;
            this.ozE = map;
            this.ozF = map2;
            this.ozG = dVar;
        }

        public final String toString() {
            return "Request method:" + this.ozD + ", params:" + (this.ozE != null ? this.ozE : "") + ", cookie:" + (this.ozF != null ? this.ozF : "");
        }
    }

    public static class c {
        String content;
        Map<String, String> ozF;
        int status = 0;

        public c(int i, Map<String, String> map, String str) {
            this.status = i;
            this.ozF = map;
            this.content = str;
        }

        public final String toString() {
            return "Response status:" + this.status + ", cookie:" + (this.ozF != null ? this.ozF : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
        }
    }

    public static class d {
        String fLE;
        String filePath;

        public d(String str, String str2) {
            this.fLE = str;
            this.filePath = str2;
        }
    }

    public abstract c a(String str, String str2, b bVar, a aVar);

    public abstract void cancel();

    public static void setHost(String str) {
        x.host = str;
    }

    public static void setUserAgent(String str) {
        x.lRl = str;
    }

    public static void CN(String str) {
        ozC = str;
    }

    protected static String c(String str, String str2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(str2.startsWith("http://") || str2.startsWith("https://"))) {
            stringBuilder.append(str + host);
        }
        stringBuilder.append(str2);
        if (map == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        for (String str3 : map.keySet()) {
            stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bg.mz((String) map.get(str3)), ProtocolPackage.ServerEncoding));
            obj = null;
        }
        return stringBuilder.toString();
    }

    protected static String G(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            stringBuilder.append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) map.get(str), ProtocolPackage.ServerEncoding));
            int i2 = i + 1;
            if (map.size() > i2) {
                stringBuilder.append("; ");
            }
            i = i2;
        }
        return stringBuilder.toString();
    }

    protected static Map<String, String> CO(String str) {
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
