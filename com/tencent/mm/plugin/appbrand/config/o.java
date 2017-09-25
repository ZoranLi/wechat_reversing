package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import com.tencent.mm.bd.b;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.bqi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.x.n;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class o extends i<WxaAttributes> {
    public final g hnH;

    public final /* synthetic */ boolean a(c cVar, boolean z) {
        WxaAttributes wxaAttributes = (WxaAttributes) cVar;
        wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
        super.a(wxaAttributes, z);
        return d("username", "appId") != null;
    }

    public final /* synthetic */ boolean a(c cVar, boolean z, String[] strArr) {
        WxaAttributes wxaAttributes = (WxaAttributes) cVar;
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.a(wxaAttributes, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((WxaAttributes) cVar, strArr);
    }

    public o(g gVar) {
        super(gVar, WxaAttributes.iFJ, "WxaAttributesTable", WxaAttributes.gaK);
        this.hnH = gVar;
    }

    final long RF() {
        return this.hnH.cs(Thread.currentThread().getId());
    }

    final int aD(long j) {
        return this.hnH.aD(j);
    }

    public final WxaAttributes d(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bg.mA(str) && str.endsWith("@app")) {
            Cursor a = this.hnH.a("WxaAttributesTable", bg.D(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"usernameHash"}), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.b(a);
                    wxaAttributes.field_username = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    public final WxaAttributes e(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bg.mA(str)) {
            Cursor a = this.hnH.a("WxaAttributesTable", bg.D(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"appId"}), new String[]{str}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.b(a);
                    wxaAttributes.field_appId = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    final long oi(String str) {
        WxaAttributes d = d(str, "appInfo");
        if (d == null || d.RH() == null) {
            return 0;
        }
        return d.RH().iCb;
    }

    final boolean a(String str, b bVar, List<bqi> list) {
        if (bg.bV(list)) {
            return false;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        if (a(wxaAttributes, "username")) {
            boolean z = false;
        } else {
            int i = 1;
        }
        int i2 = 0;
        for (bqi com_tencent_mm_protocal_c_bqi : list) {
            if (com_tencent_mm_protocal_c_bqi != null) {
                i2 = a(wxaAttributes, com_tencent_mm_protocal_c_bqi) | i2;
            }
        }
        if (i2 != 0) {
            if (i != 0) {
                b(wxaAttributes);
            } else {
                c(wxaAttributes, new String[]{"username"});
            }
            try {
                if (h.vG().uV()) {
                    com.tencent.mm.x.h hVar;
                    int i3;
                    boolean z2;
                    af xVar;
                    String str2 = wxaAttributes.field_username;
                    String str3 = wxaAttributes.field_nickname;
                    String str4 = wxaAttributes.field_bigHeadURL;
                    String str5 = wxaAttributes.field_smallHeadURL;
                    com.tencent.mm.x.h hs = n.Bm().hs(str2);
                    if (hs == null) {
                        hVar = new com.tencent.mm.x.h();
                        i3 = 1;
                    } else {
                        hVar = hs;
                        z2 = false;
                    }
                    if (!bg.mz(str5).equals(hVar.Bt())) {
                        hVar.hrA = str5;
                        i3 = 1;
                    }
                    if (!bg.mz(str4).equals(hVar.Bs())) {
                        hVar.hrB = str4;
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        hVar.username = str2;
                        hVar.aV(true);
                        hVar.fRW = 31;
                        n.Bm().a(hVar);
                    }
                    af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str2);
                    if (Rc == null) {
                        xVar = new x();
                    } else {
                        xVar = Rc;
                    }
                    if (((int) xVar.gTQ) == 0) {
                        xVar.setUsername(str2);
                        i3 = 1;
                    } else {
                        z2 = false;
                    }
                    if (!str3.equals(xVar.field_nickname)) {
                        xVar.bR(str3);
                        xVar.bS(com.tencent.mm.platformtools.c.mq(str3));
                        xVar.bT(com.tencent.mm.platformtools.c.mp(str3));
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().P(xVar);
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WxaAttrStorage", e, "flushContactInMainDB", new Object[0]);
            }
        }
        com.tencent.mm.plugin.appbrand.app.c.PY().a(wxaAttributes.field_appId, wxaAttributes.RJ());
        wxaAttributes.field_syncTimeSecond = bg.Ny();
        wxaAttributes.field_syncVersion = bg.bo(bVar.sYA);
        c(wxaAttributes, new String[]{"username"});
        return i2;
    }

    private static boolean a(WxaAttributes wxaAttributes, bqi com_tencent_mm_protocal_c_bqi) {
        if ("NickName".equals(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_nickname)) {
            wxaAttributes.field_nickname = com_tencent_mm_protocal_c_bqi.oTN;
            return true;
        } else if ("BrandIconURL".equals(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_brandIconURL)) {
            wxaAttributes.field_brandIconURL = com_tencent_mm_protocal_c_bqi.oTN;
            return true;
        } else if ("BigHeadImgUrl".equals(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_bigHeadURL)) {
            wxaAttributes.field_bigHeadURL = com_tencent_mm_protocal_c_bqi.oTN;
            return true;
        } else if ("SmallHeadImgUrl".equals(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_smallHeadURL)) {
            wxaAttributes.field_smallHeadURL = com_tencent_mm_protocal_c_bqi.oTN;
            return true;
        } else if (!"Signature".equals(com_tencent_mm_protocal_c_bqi.tkE) || aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_signature)) {
            if ("WxAppOpt".equals(com_tencent_mm_protocal_c_bqi.tkE)) {
                int i = bg.getInt(com_tencent_mm_protocal_c_bqi.oTN, 0);
                if (i != wxaAttributes.field_appOpt) {
                    wxaAttributes.field_appOpt = i;
                    return true;
                }
            }
            if ("RegisterSource".equals(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_registerSource)) {
                wxaAttributes.field_registerSource = com_tencent_mm_protocal_c_bqi.oTN;
                return true;
            } else if ("WxaAppInfo".equals(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_appInfo)) {
                wxaAttributes.field_appInfo = com_tencent_mm_protocal_c_bqi.oTN;
                try {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_bqi.oTN);
                    wxaAttributes.field_appId = jSONObject.getString("Appid");
                    k.a(wxaAttributes.field_appId, SysConfigUtil.e(jSONObject).tfK);
                    return true;
                } catch (Exception e) {
                    return true;
                }
            } else if ("WxaAppVersionInfo".equalsIgnoreCase(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_versionInfo)) {
                wxaAttributes.field_versionInfo = com_tencent_mm_protocal_c_bqi.oTN;
                return true;
            } else if ("BindWxaInfo".equals(com_tencent_mm_protocal_c_bqi.tkE) && !aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_bindWxaInfo)) {
                wxaAttributes.field_bindWxaInfo = com_tencent_mm_protocal_c_bqi.oTN;
                return true;
            } else if (!"WxaAppDynamic".equals(com_tencent_mm_protocal_c_bqi.tkE) || aM(com_tencent_mm_protocal_c_bqi.oTN, wxaAttributes.field_dynamicInfo)) {
                return false;
            } else {
                wxaAttributes.field_dynamicInfo = com_tencent_mm_protocal_c_bqi.oTN;
                return true;
            }
        } else {
            wxaAttributes.field_signature = com_tencent_mm_protocal_c_bqi.oTN;
            return true;
        }
    }

    private static boolean aM(String str, String str2) {
        return bg.mz(str).equals(bg.mz(str2));
    }

    private boolean a(WxaAttributes wxaAttributes, String... strArr) {
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.b(wxaAttributes, strArr);
    }
}
