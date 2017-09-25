package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tenpay.cert.CertUtil;

public final class a {
    static boolean isInit = false;
    private static a wDP = null;
    private boolean wDQ = false;

    public static a cbV() {
        if (wDP == null) {
            wDP = new a();
        }
        return wDP;
    }

    public static void init(Context context) {
        if (!isInit) {
            w.d("MicroMsg.CertUtilWx", "init  %s", new Object[]{bg.bJZ().toString()});
            CertUtil.getInstance().init(context);
            isInit = true;
        }
    }

    public final String getCertApplyCSR(String str) {
        String str2;
        w.d("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s", new Object[]{bg.bJZ().toString()});
        synchronized (this) {
            if (this.wDQ) {
                w.i("MicroMsg.CertUtilWx", "isCert_Wating");
                str2 = "";
            } else {
                this.wDQ = true;
                str2 = CertUtil.getInstance().getCertApplyCSR(str);
            }
        }
        return str2;
    }

    public final boolean importCert(String str, String str2) {
        boolean importCert;
        w.d("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", new Object[]{str, str2, bg.bJZ().toString()});
        synchronized (this) {
            this.wDQ = false;
            importCert = CertUtil.getInstance().importCert(str, str2);
        }
        return importCert;
    }

    public final boolean cbW() {
        w.d("MicroMsg.CertUtilWx", "importCertNone");
        synchronized (this) {
            this.wDQ = false;
        }
        return false;
    }

    public static boolean isCertExist(String str) {
        w.d("MicroMsg.CertUtilWx", "isCertExist stack %s", new Object[]{bg.bJZ().toString()});
        g.oUh.a(414, 5, 1, true);
        boolean isCertExist = CertUtil.getInstance().isCertExist(str);
        g.oUh.a(414, 6, 1, true);
        return isCertExist;
    }

    public static String genUserSig(String str, String str2) {
        w.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[]{bg.bJZ().toString()});
        return CertUtil.getInstance().genUserSig(str, str2);
    }

    public static boolean setTokens(String str, String str2) {
        w.d("MicroMsg.CertUtilWx", "setTokens stack %s", new Object[]{bg.bJZ().toString()});
        return CertUtil.getInstance().setTokens(str, str2);
    }

    public static String getToken(String str) {
        w.d("MicroMsg.CertUtilWx", "getToken stack %s", new Object[]{bg.bJZ().toString()});
        return CertUtil.getInstance().getToken(str);
    }

    public static void clearToken(String str) {
        w.d("MicroMsg.CertUtilWx", "clearToken stack %s", new Object[]{bg.bJZ().toString()});
        CertUtil.getInstance().clearToken(str);
    }

    public static int getTokenCount(String str, boolean z) {
        w.d("MicroMsg.CertUtilWx", "getTokenCount stack %s", new Object[]{bg.bJZ().toString()});
        return CertUtil.getInstance().getTokenCount(str, true);
    }

    public static int getLastError() {
        w.d("MicroMsg.CertUtilWx", "getLastError stack %s", new Object[]{bg.bJZ().toString()});
        return CertUtil.getInstance().getLastError();
    }

    public static void clearCert(String str) {
        w.d("MicroMsg.CertUtilWx", "clearCert stack %s", new Object[]{bg.bJZ().toString()});
        CertUtil.getInstance().clearCert(str);
    }

    public static void clean() {
        w.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", new Object[]{bg.bJZ().toString()});
        CertUtil.getInstance().clearAllCert();
    }
}
