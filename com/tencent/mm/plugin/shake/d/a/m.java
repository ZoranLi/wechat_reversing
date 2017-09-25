package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class m {

    public static class a {
        public String path;
        public String thumbUrl;
        public String title;
        public String username;
        public int version;

        private a() {
        }

        public static a Eg(String str) {
            Map q = bh.q(str, "program");
            if (q == null) {
                return null;
            }
            try {
                a aVar = new a();
                aVar.title = bg.mz((String) q.get(".program.title"));
                aVar.thumbUrl = bg.mz((String) q.get(".program.thumburl"));
                aVar.username = bg.mz((String) q.get(".program.username"));
                aVar.path = bg.mz((String) q.get(".program.path"));
                aVar.version = bg.getInt((String) q.get(".program.version"), 0);
                return aVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class b {
        public String oho;
        public String pqA;
        public String thumbUrl;
        public String title;

        private b() {
        }

        public static b Eh(String str) {
            Map q = bh.q(str, "nativepay");
            if (q == null) {
                return null;
            }
            try {
                b bVar = new b();
                bVar.title = bg.mz((String) q.get(".nativepay.title"));
                bVar.thumbUrl = bg.mz((String) q.get(".nativepay.thumburl"));
                bVar.pqA = bg.mz((String) q.get(".nativepay.wx_pay_url"));
                bVar.oho = bg.mz((String) q.get(".nativepay.price"));
                return bVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class c {
        public String id;
        public String thumbUrl;
        public String title;

        private c() {
        }

        public static c Ei(String str) {
            Map q = bh.q(str, "product");
            if (q == null) {
                return null;
            }
            try {
                c cVar = new c();
                cVar.title = bg.mz((String) q.get(".product.title"));
                cVar.thumbUrl = bg.mz((String) q.get(".product.thumburl"));
                cVar.id = bg.mz((String) q.get(".product.product_id"));
                return cVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class d {
        public String pqB;
        public String thumbUrl;
        public String title;
        public String username;

        private d() {
        }

        public static d Ej(String str) {
            Map q = bh.q(str, "tempsession");
            if (q == null) {
                return null;
            }
            try {
                d dVar = new d();
                dVar.title = bg.mz((String) q.get(".tempsession.title"));
                dVar.thumbUrl = bg.mz((String) q.get(".tempsession.thumburl"));
                dVar.username = bg.mz((String) q.get(".tempsession.username"));
                dVar.pqB = bg.mz((String) q.get(".tempsession.deeplinkjumpurl"));
                return dVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class e {
        public String fRu;
        public String hSX;
        public String thumbUrl;
        public String title;

        private e() {
        }

        public static e Ek(String str) {
            Map q = bh.q(str, "h5url");
            if (q == null) {
                return null;
            }
            try {
                e eVar = new e();
                eVar.title = bg.mz((String) q.get(".h5url.title"));
                eVar.thumbUrl = bg.mz((String) q.get(".h5url.thumburl"));
                eVar.hSX = bg.mz((String) q.get(".h5url.link"));
                eVar.fRu = bg.mz((String) q.get(".h5url.username"));
                return eVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class f {
        public String aIO;
        public String pqC;
        public String userName;

        private f() {
        }

        public static f El(String str) {
            Map q = bh.q(str, "bizprofile");
            if (q == null) {
                return null;
            }
            try {
                f fVar = new f();
                fVar.aIO = bg.mz((String) q.get(".bizprofile.nickname"));
                fVar.userName = bg.mz((String) q.get(".bizprofile.username"));
                fVar.pqC = bg.mz((String) q.get(".bizprofile.showchat"));
                return fVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }
}
