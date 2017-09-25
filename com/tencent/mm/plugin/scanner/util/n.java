package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.LinkedList;
import java.util.Map;

public final class n {

    public static class a {
        public String field_certification;
        public String field_certificationurl;
        public String field_detailurl;
        public String field_exposeurl;
        public String field_extinfo;
        public String field_feedbackurl;
        public int field_functionType;
        public int field_getaction;
        public String field_headerbackgroundurl;
        public String field_headermask;
        public String field_introlink;
        public String field_introtitle;
        public String field_playurl;
        public String field_productid;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public int field_type;
        public String field_xml;
        public int field_xmlType;
        public LinkedList<com.tencent.mm.plugin.scanner.a.a> per;
        public a pes;

        public static class a {
            public LinkedList<a> pet;
            public LinkedList<b> peu;

            public static class a {
                public String hSX;
            }

            public static class b {
                public String desc;
                public String title;
            }
        }

        public final void l(java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r6 = this;
            r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r1 = 0;
            if (r7 == 0) goto L_0x0108;
        L_0x0005:
            r0 = new com.tencent.mm.plugin.scanner.util.n$a$a;
            r0.<init>();
            r6.pes = r0;
            r0 = r6.pes;
            r2 = new java.util.LinkedList;
            r2.<init>();
            r0.pet = r2;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0 = r0.append(r8);
            r2 = ".bannerlist.banner";
            r0 = r0.append(r2);
            r3 = r0.toString();
            r2 = r1;
        L_0x002a:
            if (r2 >= r5) goto L_0x0079;
        L_0x002c:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r4 = r0.append(r3);
            if (r2 <= 0) goto L_0x0075;
        L_0x0037:
            r0 = java.lang.Integer.valueOf(r2);
        L_0x003b:
            r0 = r4.append(r0);
            r0 = r0.toString();
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r0 = r4.append(r0);
            r4 = ".link";
            r0 = r0.append(r4);
            r0 = r0.toString();
            r0 = r7.get(r0);
            r0 = (java.lang.String) r0;
            r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r4 != 0) goto L_0x0079;
        L_0x0063:
            r4 = new com.tencent.mm.plugin.scanner.util.n$a$a$a;
            r4.<init>();
            r4.hSX = r0;
            r0 = r6.pes;
            r0 = r0.pet;
            r0.add(r4);
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x002a;
        L_0x0075:
            r0 = "";
            goto L_0x003b;
        L_0x0079:
            r0 = r6.pes;
            r2 = new java.util.LinkedList;
            r2.<init>();
            r0.peu = r2;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0 = r0.append(r8);
            r2 = ".detaillist.detail";
            r0 = r0.append(r2);
            r3 = r0.toString();
            r2 = r1;
        L_0x0097:
            if (r2 >= r5) goto L_0x0108;
        L_0x0099:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = r0.append(r3);
            if (r2 <= 0) goto L_0x0104;
        L_0x00a4:
            r0 = java.lang.Integer.valueOf(r2);
        L_0x00a8:
            r0 = r1.append(r0);
            r1 = r0.toString();
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0 = r0.append(r1);
            r4 = ".title";
            r0 = r0.append(r4);
            r0 = r0.toString();
            r0 = r7.get(r0);
            r0 = (java.lang.String) r0;
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r1 = r4.append(r1);
            r4 = ".desc";
            r1 = r1.append(r4);
            r1 = r1.toString();
            r1 = r7.get(r1);
            r1 = (java.lang.String) r1;
            r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r4 == 0) goto L_0x00f0;
        L_0x00ea:
            r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
            if (r4 != 0) goto L_0x0108;
        L_0x00f0:
            r4 = new com.tencent.mm.plugin.scanner.util.n$a$a$b;
            r4.<init>();
            r4.title = r0;
            r4.desc = r1;
            r0 = r6.pes;
            r0 = r0.peu;
            r0.add(r4);
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x0097;
        L_0x0104:
            r0 = "";
            goto L_0x00a8;
        L_0x0108:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.util.n.a.l(java.util.Map, java.lang.String):void");
        }
    }

    public static class b {
        public String hSX;

        public b(String str) {
            this.hSX = str;
        }
    }

    public static class c {
        public String fFa;
        public String username;

        public c(String str, String str2) {
            this.username = str;
            this.fFa = str2;
        }
    }

    public static String D(Context context, int i) {
        if (context == null || i < 0) {
            return "";
        }
        if (i == 0) {
            context.getString(R.l.ePn);
        } else if (i == 1) {
            context.getString(R.l.ePg);
        } else if (i == 2) {
            context.getString(R.l.ePm);
        } else if (i == 3) {
            context.getString(R.l.ePh);
        }
        return context.getString(R.l.ePn);
    }

    public static int DO(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (trim.startsWith("<user")) {
            return 1;
        }
        if (trim.startsWith("<url")) {
            return 2;
        }
        if (trim.startsWith("<product")) {
            return 3;
        }
        if (trim.startsWith("<search")) {
            return 4;
        }
        return 0;
    }

    public static c DP(String str) {
        if (str == null) {
            return null;
        }
        Map q = bh.q(str, "user");
        if (q != null) {
            return new c(bg.mz((String) q.get(".user.username")), bg.mz((String) q.get(".user.nickname")));
        }
        return null;
    }

    public static b DQ(String str) {
        if (str == null) {
            return null;
        }
        Map q = bh.q(str, SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (q != null) {
            return new b(bg.mz((String) q.get(".url.link")));
        }
        return null;
    }

    public static String c(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!bg.mA(aVar.field_productid)) {
            stringBuilder.append("<productInfo><product type=\"" + aVar.field_type + "\">");
            stringBuilder.append("<id>" + bg.PW(aVar.field_productid) + "</id>");
            stringBuilder.append("<title>" + bg.PW(aVar.field_title) + "</title>");
            stringBuilder.append("<subtitle>" + bg.PW(aVar.field_subtitle) + "</subtitle>");
            stringBuilder.append("<thumburl>" + bg.PW(aVar.field_thumburl) + "</thumburl>");
            stringBuilder.append("<source>" + bg.PW(aVar.field_source) + "</source>");
            stringBuilder.append("<shareurl>" + bg.PW(aVar.field_shareurl) + "</shareurl>");
            stringBuilder.append("<playurl>" + bg.PW(aVar.field_playurl) + "</playurl>");
            stringBuilder.append("<extinfo>" + bg.PW(aVar.field_extinfo) + "</extinfo>");
            stringBuilder.append("<getaction>" + bg.PW(aVar.field_getaction) + "</getaction>");
            stringBuilder.append("<certification>" + bg.PW(aVar.field_certification) + "</certification>");
            stringBuilder.append("<headerbackgroundurl>" + bg.PW(aVar.field_headerbackgroundurl) + "</headerbackgroundurl>");
            stringBuilder.append("<headermask>" + bg.PW(aVar.field_headermask) + "</headermask>");
            stringBuilder.append("<detailurl>" + bg.PW(aVar.field_detailurl) + "</detailurl>");
            stringBuilder.append("<certificationurl>" + bg.PW(aVar.field_certificationurl) + "</certificationurl>");
            stringBuilder.append("</product>");
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        } else if (aVar.field_xml == null) {
            w.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
            return "";
        } else if (aVar.field_xml.startsWith("<productInfo")) {
            return aVar.field_xml;
        } else {
            stringBuilder.append("<productInfo>");
            stringBuilder.append(aVar.field_xml);
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        }
        return stringBuilder.toString();
    }

    public static int a(int i, String str, i iVar, int i2, com.tencent.mm.plugin.scanner.util.e.a aVar, int i3, int i4, boolean z) {
        if (iVar == null || str == null || iVar.aYM() == null || iVar.aYM().aYD() == null) {
            String str2 = "MicroMsg.Scanner.ScanXmlHelper";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(str == null);
            w.e(str2, str3, objArr);
            return 2;
        }
        int DO = DO(str);
        w.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(DO)});
        if (DO == 1) {
            c DP = DP(str);
            if (DP == null || bg.mA(DP.username)) {
                w.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                return 2;
            }
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(DP.username);
            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                iVar.aYM().a(DP.username, 1, i3, i4, aVar);
                return 1;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", Rc.field_username);
            intent.setFlags(65536);
            com.tencent.mm.plugin.scanner.b.imv.d(intent, iVar.aYM().aYD());
            return 0;
        } else if (DO == 2) {
            b DQ = DQ(str);
            if (DQ == null || bg.mA(DQ.hSX)) {
                w.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                return 2;
            }
            w.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{DQ.hSX});
            if (i == 5) {
                ((d) h.h(d.class)).b(iVar.aYM().aYD(), DQ.hSX, z ? 1032 : 1025, null);
                return 0;
            }
            r0 = new Intent();
            r0.putExtra("rawUrl", DQ.hSX);
            r0.setFlags(65536);
            com.tencent.mm.plugin.scanner.b.imv.j(r0, iVar.aYM().aYD());
            return 0;
        } else if (DO == 3 || DO == 4) {
            w.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(i2), Boolean.valueOf(true)});
            r0 = new Intent();
            r0.setClass(iVar.aYM().aYD(), ProductUI.class);
            r0.setFlags(65536);
            r0.putExtra("key_Product_xml", str);
            r0.putExtra("key_Product_funcType", i2);
            r0.putExtra("key_ProductUI_addToDB", true);
            r0.putExtra("key_need_add_to_history", true);
            r0.putExtra("key_is_from_barcode", true);
            iVar.aYM().aYD().startActivity(r0);
            return 0;
        } else {
            w.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
            w.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str});
            return 2;
        }
    }
}
