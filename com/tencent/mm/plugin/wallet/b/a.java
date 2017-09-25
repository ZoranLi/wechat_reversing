package com.tencent.mm.plugin.wallet.b;

import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static boolean bts() {
        boolean z;
        d dVar = com.tencent.mm.pluginsdk.l.a.sBC;
        w.i("MicroMsg.WalletUtil", "mgr==null?" + (dVar == null));
        if (dVar != null) {
            w.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + dVar.avd());
        }
        o.bsC();
        af bsD = o.bsD();
        ad buq = bsD.buq();
        String str = "MicroMsg.WalletUtil";
        StringBuilder stringBuilder = new StringBuilder("config==null?");
        if (buq == null) {
            z = true;
        } else {
            z = false;
        }
        w.i(str, stringBuilder.append(z).toString());
        if (buq != null) {
            w.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + buq.buh());
        }
        w.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + bsD.bum());
        if (dVar != null && dVar.avd() && buq != null && buq.buh() && bsD.bum()) {
            return true;
        }
        return false;
    }
}
