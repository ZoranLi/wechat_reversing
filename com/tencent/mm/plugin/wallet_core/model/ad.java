package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.wcdb.FileUtils;

public final class ad {
    public int rIi = 0;

    public ad(int i) {
        ap.yY();
        c.vr().set(196660, Integer.valueOf(i));
        this.rIi = i;
        w.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i);
    }

    public ad() {
        ap.yY();
        this.rIi = ((Integer) c.vr().get(196660, Integer.valueOf(0))).intValue();
        w.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.rIi);
    }

    public final boolean buf() {
        boolean z;
        if ((this.rIi & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.rIi)});
        return z;
    }

    public final boolean bug() {
        boolean z;
        if ((this.rIi & FileUtils.S_IWUSR) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.rIi)});
        return z;
    }

    public final boolean buh() {
        boolean z;
        if ((this.rIi & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.rIi)});
        return z;
    }

    public final boolean bui() {
        boolean z;
        if ((this.rIi & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.rIi)});
        return z;
    }
}
