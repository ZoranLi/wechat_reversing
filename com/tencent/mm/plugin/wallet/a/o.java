package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class o implements am {
    public int kCS = 0;
    public int ryl = 0;
    private n rym = new n();
    private t ryn = new t();
    private i ryo = new i();
    private b ryp = new b(this) {
        final /* synthetic */ o ryr;

        {
            this.ryr = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            int intValue;
            if (bg.n(obj, 0) == 339975) {
                ap.yY();
                intValue = ((Integer) c.vr().get(339975, Integer.valueOf(0))).intValue();
                if (intValue != this.ryr.ryl) {
                    ao.bDn().reset();
                    this.ryr.ryl = intValue;
                }
            } else if (a.uDY.equals(obj)) {
                ap.yY();
                intValue = ((Integer) c.vr().get(a.uDY, Integer.valueOf(0))).intValue();
                if (intValue != this.ryr.kCS) {
                    ao.bDn().reset();
                    this.ryr.kCS = intValue;
                }
            }
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.m ryq = new com.tencent.mm.plugin.messenger.foundation.a.m(this) {
        final /* synthetic */ o ryr;

        {
            this.ryr = r1;
        }

        public final void b(String str, Map<String, String> map) {
            if ("paymsg".equals(str) && PayuSecureEncrypt.ENCRYPT_VERSION_HASH.equals(map.get(".sysmsg.paymsg.PayMsgType"))) {
                Object obj = (String) map.get(".sysmsg.paymsg.NewTagBankSerial");
                String str2 = (String) map.get(".sysmsg.paymsg.WalletRedDotWording");
                w.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[]{Integer.valueOf(bg.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0)), Integer.valueOf(bg.getInt((String) map.get(".sysmsg.paymsg.BankCardRedDot"), 0)), obj});
                if (bg.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0) == 1) {
                    com.tencent.mm.q.c.uk().b(a.uIr, true);
                } else {
                    com.tencent.mm.q.c.uk().b(a.uIr, false);
                }
                if (r3 == 1) {
                    com.tencent.mm.q.c.uk().b(a.uIs, true);
                } else {
                    com.tencent.mm.q.c.uk().b(a.uIs, false);
                }
                if (!bg.mA(str2)) {
                    ap.yY();
                    c.vr().a(a.uIu, str2);
                }
                if (!bg.mA(obj)) {
                    ap.yY();
                    str2 = (String) c.vr().get(a.uIv, "");
                    if (!bg.mA(str2)) {
                        obj = str2 + "," + obj;
                    }
                    ap.yY();
                    c.vr().a(a.uIv, obj);
                }
            }
        }
    };

    static {
        com.tencent.mm.wallet_core.a.g("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
        com.tencent.mm.wallet_core.a.g("BindCardProcess", com.tencent.mm.plugin.wallet_core.a.b.class);
    }

    public o() {
        File file = new File(com.tencent.mm.plugin.wallet_core.c.b.buI());
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static o bsC() {
        o oVar = (o) ap.yR().gs("plugin.wallet");
        if (oVar != null) {
            return oVar;
        }
        w.w("MicroMsg.SubCoreMMWallet", "not found in MMCore, new one");
        Object oVar2 = new o();
        ap.yR().a("plugin.wallet", oVar2);
        return oVar2;
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        ap.yY();
        this.ryl = ((Integer) c.vr().get(339975, Integer.valueOf(0))).intValue();
        ap.yY();
        this.kCS = ((Integer) c.vr().get(a.uDY, Integer.valueOf(0))).intValue();
        ap.getSysCmdMsgExtension().a("paymsg", this.ryq);
        com.tencent.mm.sdk.b.a.urY.b(this.rym);
        com.tencent.mm.sdk.b.a.urY.b(this.ryn);
        com.tencent.mm.sdk.b.a.urY.b(this.ryo);
        ap.yY();
        c.vr().a(this.ryp);
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("paymsg", this.ryq);
        com.tencent.mm.sdk.b.a.urY.c(this.rym);
        com.tencent.mm.sdk.b.a.urY.c(this.ryn);
        com.tencent.mm.sdk.b.a.urY.c(this.ryo);
        ap.yY();
        c.vr().b(this.ryp);
    }

    public static af bsD() {
        return com.tencent.mm.plugin.wallet_core.model.m.btS();
    }

    public static String Fw() {
        ap.yY();
        String str = (String) c.vr().get(6, null);
        String yU = an.yU(str);
        if (bg.mA(str)) {
            return "";
        }
        return str.substring(yU.length() + 1);
    }

    public static String bsE() {
        ap.yY();
        String str = (String) c.vr().get(6, null);
        if (bg.mA(str)) {
            str = "";
        } else {
            str = an.yU(str.replace("+", ""));
        }
        if (!bg.mA(str)) {
            return str;
        }
        if (com.tencent.mm.u.m.xY()) {
            return "27";
        }
        return "86";
    }
}
