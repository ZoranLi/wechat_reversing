package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> qdp = new ConcurrentHashMap();
    private static volatile long qdq = 0;

    private static class a {
        public int RQ = -1;
        public int aar = -1;
        public String mMimeType = "";
        public String qdr = "";
        public int qds = 0;
        public int qdt = -1;
        public long qdu = -1;
        public long qdv = -1;
        public long qdw = -1;
    }

    private static class b {
        public int RQ = -1;
        public int aar = -1;
        public String mMimeType = "";
        public String qdr = "";
        public int qdt = -1;
        public long qdu = -1;
    }

    private static void bfF() {
        synchronized (qdp) {
            if (bg.aB(qdq) <= 120000) {
                return;
            }
            qdq = bg.NA();
            qdp.clear();
        }
    }

    private static String FS(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static void a(String str, String str2, int i, int i2, int i3, long j) {
        try {
            b bVar = new b();
            bVar.qdr = FS(str);
            bVar.mMimeType = str2;
            bVar.aar = i;
            bVar.RQ = i2;
            bVar.qdt = i3;
            bVar.qdu = j;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append(bVar.qdr).append(',').append(bVar.mMimeType).append(',').append(bVar.aar).append(',').append(bVar.RQ).append(',').append(bVar.qdt).append(',').append(bVar.qdu);
            String stringBuilder2 = stringBuilder.toString();
            w.i("MicroMsg.SnsImgStats", "report up: " + stringBuilder2);
            g.oUh.A(13512, stringBuilder2);
        } catch (Exception e) {
        }
    }

    public static void a(String str, String str2, int i, String str3, int i2, int i3, int i4, long j, long j2) {
        try {
            a aVar = new a();
            aVar.qdr = FS(str2);
            aVar.qds = i;
            aVar.mMimeType = str3;
            aVar.aar = i2;
            aVar.RQ = i3;
            aVar.qdt = i4;
            aVar.qdu = j;
            aVar.qdv = j2;
            qdp.put(str, aVar);
        } catch (Exception e) {
        }
    }

    public static void R(String str, long j) {
        try {
            a aVar = (a) qdp.remove(str);
            if (aVar != null) {
                aVar.qdw = j;
                StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                stringBuilder.append(aVar.qdr).append(',').append(aVar.qds).append(',').append(aVar.mMimeType).append(',').append(aVar.aar).append(',').append(aVar.RQ).append(',').append(aVar.qdt).append(',').append(aVar.qdu).append(',').append(aVar.qdv).append(',').append(aVar.qdw);
                String stringBuilder2 = stringBuilder.toString();
                w.i("MicroMsg.SnsImgStats", "report dl: " + stringBuilder2);
                g.oUh.A(13513, stringBuilder2);
                bfF();
            }
        } catch (Exception e) {
        } finally {
            bfF();
        }
    }
}
