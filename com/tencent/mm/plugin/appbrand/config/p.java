package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.mm.e.a.kj;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public final class p extends j {
    private static volatile p iFE;

    public static p RG() {
        if (iFE == null) {
            synchronized (p.class) {
                if (iFE == null) {
                    iFE = new p();
                }
            }
        }
        return iFE;
    }

    public static void release() {
        synchronized (p.class) {
            iFE = null;
        }
    }

    private p() {
    }

    public final void c(a aVar) {
        super.a(aVar, d.vL().nJF.getLooper());
    }

    public static boolean i(String str, int i, boolean z) {
        boolean z2 = false;
        o PR = c.PR();
        if (bg.mA(str)) {
            return false;
        }
        WxaAttributes d = PR.d(str, "appOpt");
        if (d == null) {
            return false;
        }
        int i2 = d.field_appOpt;
        i2 = !z ? i2 & (i ^ -1) : i2 | i;
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("appOpt", Integer.valueOf(i2));
        if (PR.hnH.update("WxaAttributesTable", contentValues, String.format("%s=?", new Object[]{"username"}), new String[]{str}) > 0) {
            z2 = true;
        }
        if (z2) {
            b kjVar = new kj();
            kjVar.fQM.fCJ = str;
            kjVar.fQM.fQN = i2;
            com.tencent.mm.sdk.b.a.urY.m(kjVar);
        }
        return z2;
    }

    public static s oj(String str) {
        if (bg.mA(str)) {
            return null;
        }
        WxaAttributes d = c.PR().d(str, "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "registerSource", "bindWxaInfo");
        if (d == null) {
            return null;
        }
        s sVar = new s();
        sVar.username = str;
        sVar.appId = d.field_appId;
        sVar.fFa = d.field_nickname;
        sVar.signature = d.field_signature;
        sVar.iGg = d.field_brandIconURL;
        sVar.iFX = d.RI().iFX;
        sVar.iGc = d.RJ() == null ? -1 : d.RJ().iGc;
        sVar.iFN = d.RK();
        try {
            sVar.hvv = bg.mA(d.field_registerSource) ? "" : new JSONObject(d.field_registerSource).optString("RegisterBody", "");
        } catch (Exception e) {
        }
        return sVar;
    }

    public static e a(String str, String str2, int i, long j) {
        WxaAttributes d = c.PR().d(str2, "appId", "nickname", "brandIconURL");
        return new e(String.valueOf(str), str2, d == null ? "" : d.field_appId, d == null ? "" : d.field_nickname, d == null ? "" : d.field_brandIconURL, i, c.PR().oi(str2), c.PX().U(str2, i), j);
    }

    public static AppBrandSysConfig ok(String str) {
        WxaAttributes e = c.PR().e(str, new String[0]);
        if (e != null) {
            return a(e);
        }
        return null;
    }

    public static AppBrandSysConfig ol(String str) {
        if (bg.mA(str) || !str.endsWith("@app")) {
            return null;
        }
        WxaAttributes d = c.PR().d(str, new String[0]);
        if (d != null) {
            return a(d);
        }
        return null;
    }

    private static AppBrandSysConfig a(WxaAttributes wxaAttributes) {
        AppBrandSysConfig appBrandSysConfig;
        boolean z = false;
        if (wxaAttributes != null) {
            appBrandSysConfig = new AppBrandSysConfig();
            appBrandSysConfig.fCJ = wxaAttributes.field_username;
            appBrandSysConfig.fGs = wxaAttributes.field_nickname;
            appBrandSysConfig.iEP = wxaAttributes.field_brandIconURL;
            appBrandSysConfig.appId = wxaAttributes.field_appId;
            appBrandSysConfig.iEQ = wxaAttributes.RH().iFU;
            appBrandSysConfig.iEU = wxaAttributes.RI().iFW.iEU;
            appBrandSysConfig.iEV = wxaAttributes.RI().iFW.iEV;
            appBrandSysConfig.iEY = wxaAttributes.RI().iFW.iEY;
            appBrandSysConfig.iEX = wxaAttributes.RI().iFW.iEX;
            appBrandSysConfig.iEW = wxaAttributes.RI().iFW.iEW;
            appBrandSysConfig.iEZ = (long) wxaAttributes.RI().iFW.iGa;
            appBrandSysConfig.iFa = wxaAttributes.RI().iFW.iGb;
            appBrandSysConfig.iFd = (ArrayList) SysConfigUtil.e(new ArrayList(), wxaAttributes.RH().iFQ);
            appBrandSysConfig.iFe = (ArrayList) SysConfigUtil.e(new ArrayList(), wxaAttributes.RH().iFR);
            appBrandSysConfig.iFg = (ArrayList) SysConfigUtil.e(new ArrayList(), wxaAttributes.RH().iFT);
            appBrandSysConfig.iFf = (ArrayList) SysConfigUtil.e(new ArrayList(), wxaAttributes.RH().iFS);
            appBrandSysConfig.iFn = new cw();
            appBrandSysConfig.iFn.tgd = wxaAttributes.RH().iCb;
            appBrandSysConfig.iFn.tgk = wxaAttributes.RH().iFO;
            appBrandSysConfig.iFh = wxaAttributes.RI().iFW.iFh;
            appBrandSysConfig.iFi = wxaAttributes.RI().iFW.iFi;
            appBrandSysConfig.iFj = wxaAttributes.RI().iFW.iFj;
            if (wxaAttributes.RJ() != null) {
                appBrandSysConfig.iFo = wxaAttributes.RJ().iGc;
            } else {
                appBrandSysConfig.iFo = -1;
            }
            appBrandSysConfig.iFp = wxaAttributes.field_syncVersion;
        } else {
            appBrandSysConfig = null;
        }
        if (appBrandSysConfig != null) {
            String str = appBrandSysConfig.appId;
            boolean parseBoolean = (bg.mA(str) || c.PV() == null) ? false : Boolean.parseBoolean(c.PV().get(str + "_AppDebugEnabled", "false"));
            appBrandSysConfig.iER = parseBoolean;
            i a = c.PY().a(appBrandSysConfig.appId, 0, "version", "downloadURL", "versionState");
            if (a != null) {
                appBrandSysConfig.iFk.izW = a.field_version;
                appBrandSysConfig.iFk.iAa = a.field_downloadURL;
            }
            com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100216");
            if (dX.isValid() && "1".equals(dX.bKK().get("isOpenJSCore"))) {
                z = true;
            }
            appBrandSysConfig.iFb = z;
            appBrandSysConfig.iES = "1".equals(c.PV().get(appBrandSysConfig.appId + "_PerformancePanelEnabled", "0"));
        }
        return appBrandSysConfig;
    }

    public static long oi(String str) {
        return c.PR().oi(str);
    }

    public static String[] om(String str) {
        if (bg.mA(str) || c.PR().d(str, "roundedSquareIconURL", "bigHeadURL") == null) {
            return null;
        }
        return new String[]{c.PR().d(str, "roundedSquareIconURL", "bigHeadURL").field_roundedSquareIconURL, c.PR().d(str, "roundedSquareIconURL", "bigHeadURL").field_bigHeadURL};
    }

    public static String on(String str) {
        if (bg.mA(str)) {
            return null;
        }
        WxaAttributes d = c.PR().d(str, "appId");
        if (d != null) {
            return d.field_appId;
        }
        return null;
    }

    public static String oo(String str) {
        if (bg.mA(str)) {
            return null;
        }
        WxaAttributes e = c.PR().e(str, "nickname");
        if (e != null) {
            return e.field_nickname;
        }
        return null;
    }

    public static String op(String str) {
        if (bg.mA(str)) {
            return null;
        }
        WxaAttributes e = c.PR().e(str, "username");
        if (e != null) {
            return e.field_username;
        }
        return null;
    }

    public static void oq(String str) {
        if (!bg.mA(str)) {
            o PR = c.PR();
            if (!bg.mA(str)) {
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("syncVersion", "");
                contentValues.put("syncTimeSecond", Long.valueOf(0));
                PR.hnH.update("WxaAttributesTable", contentValues, String.format(Locale.US, "%s=?", new Object[]{"username"}), new String[]{str});
            }
        }
    }

    public static void or(String str) {
        if (!bg.mA(str)) {
            com.tencent.mm.sdk.e.c wxaAttributes = new WxaAttributes();
            wxaAttributes.field_username = str;
            c.PR().a(wxaAttributes, new String[]{"username"});
        }
    }
}
