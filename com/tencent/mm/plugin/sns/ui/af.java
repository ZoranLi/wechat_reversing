package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;

public final class af {
    public static int a(Context context, as asVar) {
        if (asVar == null) {
            return 0;
        }
        if (asVar.jOc != 6) {
            return asVar.tdM;
        }
        if (asVar.tdS == null) {
            return 0;
        }
        if (a.imw.n(context, asVar.tdQ.mtb)) {
            return asVar.tdS.tfE;
        }
        return asVar.tdS.tfF;
    }

    public static void a(Context context, ax axVar, as asVar) {
        if (!(asVar == null || asVar.tdQ == null)) {
            boolean z;
            String str = asVar.tdQ.mtb;
            if (bg.mA(str)) {
                z = false;
            } else {
                f aJ = g.aJ(str, true);
                if (aJ == null || bg.mA(aJ.field_appId)) {
                    z = false;
                } else {
                    z = (aJ.field_appInfoFlag & 32) > 0;
                    w.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[]{aJ.field_appId, Boolean.valueOf(z)});
                }
            }
            if (z) {
                axVar.qJb = false;
                String str2 = "";
                if (asVar.tdU == null || asVar.tdV == null) {
                    str = asVar == null ? "" : asVar.jOc == 6 ? asVar.tdT == null ? "" : a.imw.n(context, asVar.tdQ.mtb) ? asVar.tdT.tfR : asVar.tdT.tfS : asVar.tdR;
                    try {
                        if (!bg.mA(str)) {
                            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                            if (identifier > 0) {
                                str = context.getString(identifier);
                            }
                        }
                    } catch (Exception e) {
                    }
                    str = str2;
                } else {
                    cs csVar;
                    if (a.imw.n(context, asVar.tdQ.mtb)) {
                        csVar = asVar.tdU;
                    } else {
                        csVar = asVar.tdV;
                    }
                    str2 = v.bIN();
                    if (str2.equals("zh_CN")) {
                        str = csVar.tfP;
                    } else if (str2.equals("zh_TW") || str2.equals("zh_HK")) {
                        str = csVar.tfQ;
                    } else {
                        str = csVar.tfO;
                    }
                }
                switch (asVar.jOc) {
                    case 4:
                        axVar.qJc = str;
                        axVar.qJb = true;
                        break;
                    case 5:
                        if (asVar.tdM == 1) {
                            axVar.qJc = str;
                            axVar.qJb = true;
                            break;
                        }
                        break;
                    case 6:
                        axVar.qJc = str;
                        axVar.qJb = true;
                        break;
                    default:
                        axVar.qJb = false;
                        break;
                }
                if (bg.mA(str)) {
                    w.e("MicroMsg.OpenActionContent", "text can not load ?");
                    axVar.qJb = false;
                    return;
                }
                return;
            }
        }
        axVar.qJb = false;
    }
}
