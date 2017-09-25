package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.t.f;
import java.util.Map;

public final class i {
    public static String a(Context context, a aVar) {
        f.a aVar2 = new f.a();
        aVar2.appId = sc(aVar.field_functionType);
        aVar2.title = aVar.field_title;
        aVar2.description = aVar.field_source;
        aVar2.type = 10;
        aVar2.url = aVar.field_shareurl;
        aVar2.action = "";
        aVar2.appName = n.D(context, aVar.field_type);
        aVar2.thumburl = aVar.field_thumburl;
        aVar2.hhL = aVar.field_type;
        aVar2.hhM = n.c(aVar);
        return f.a.a(aVar2, null, null);
    }

    public static String sc(int i) {
        if (i == 4) {
            return "wxfbc915ff7c30e335";
        }
        if (i == 3) {
            return "wx482a4001c37e2b74";
        }
        return "wxfbc915ff7c30e335";
    }

    public static a bA(String str, int i) {
        if (bg.mA(str)) {
            return null;
        }
        int DO = n.DO(str);
        if (DO == 3) {
            if (str == null) {
                return null;
            }
            Map q;
            int i2;
            String str2;
            String str3 = "";
            if (str.startsWith("<productInfo")) {
                q = bh.q(str, "productInfo");
                i2 = 1;
                str2 = ".productInfo";
            } else {
                i2 = 0;
                q = bh.q(str, "product");
                str2 = str3;
            }
            if (q == null) {
                return null;
            }
            a aVar = new a();
            if (bg.mA((String) q.get(str2 + ".product.$type"))) {
                aVar.field_type = 0;
            } else {
                aVar.field_type = Integer.valueOf((String) q.get(str2 + ".product.$type")).intValue();
            }
            aVar.field_productid = bg.mz((String) q.get(str2 + ".product.id"));
            aVar.field_subtitle = bg.mz((String) q.get(str2 + ".product.subtitle"));
            aVar.field_shareurl = bg.mz((String) q.get(str2 + ".product.shareurl"));
            aVar.field_playurl = bg.mz((String) q.get(str2 + ".product.playurl"));
            aVar.field_xmlType = 3;
            aVar.field_title = bg.mz((String) q.get(str2 + ".product.title"));
            aVar.field_thumburl = bg.mz((String) q.get(str2 + ".product.thumburl"));
            aVar.field_source = bg.mz((String) q.get(str2 + ".product.source"));
            aVar.field_feedbackurl = bg.mz((String) q.get(str2 + ".product.feedbackurl"));
            aVar.field_extinfo = bg.mz((String) q.get(str2 + ".product.extinfo"));
            aVar.field_introtitle = bg.mz((String) q.get(str2 + ".product.introtitle"));
            aVar.field_introlink = bg.mz((String) q.get(str2 + ".product.introlink"));
            aVar.field_getaction = bg.getInt((String) q.get(str2 + ".product.getaction"), 0);
            aVar.field_certification = bg.mz((String) q.get(str2 + ".product.certification"));
            aVar.field_headerbackgroundurl = bg.mz((String) q.get(str2 + ".product.headerbackgroundurl"));
            aVar.field_headermask = bg.mz((String) q.get(str2 + ".product.headermask"));
            aVar.field_detailurl = bg.mz((String) q.get(str2 + ".product.detailurl"));
            aVar.field_certificationurl = bg.mz((String) q.get(str2 + ".product.certificationurl"));
            aVar.field_exposeurl = bg.mz((String) q.get(str2 + ".product.exposeurl"));
            aVar.per = a.j(q, str2 + ".product");
            aVar.l(q, str2 + ".product");
            String str4 = (String) q.get(str2 + ".functionType");
            if (bg.mA(str4)) {
                aVar.field_functionType = i;
            } else {
                aVar.field_functionType = Integer.valueOf(str4).intValue();
            }
            if (i2 != 0) {
                aVar.field_xml = str;
            } else {
                StringBuilder stringBuilder = new StringBuilder(256);
                stringBuilder.append("<productInfo>");
                stringBuilder.append(str);
                stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
                stringBuilder.append("</productInfo>");
                aVar.field_xml = stringBuilder.toString();
            }
            return aVar;
        } else if (DO != 4 || str == null) {
            return null;
        } else {
            Map q2 = bh.q(str, "search");
            if (q2 == null) {
                return null;
            }
            a aVar2 = new a();
            aVar2.field_xmlType = 4;
            aVar2.field_xml = str;
            aVar2.per = a.j(q2, ".search");
            return aVar2;
        }
    }
}
