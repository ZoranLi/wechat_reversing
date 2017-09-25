package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class d {
    c nmd;

    public d() {
        init();
    }

    private void init() {
        this.nmd = new c();
        ap.yY();
        String str = (String) c.vr().get(356355, null);
        if (bg.mA(str)) {
            this.nmd.nlU = 2000.0d;
            this.nmd.nlT = 100;
            this.nmd.nlY = 200.0d;
            this.nmd.nlZ = 0.01d;
            this.nmd.nlX = 200.0d;
        } else {
            try {
                this.nmd.aD(str.getBytes("ISO-8859-1"));
            } catch (Exception e) {
                w.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
                this.nmd.nlU = 2000.0d;
                this.nmd.nlT = 100;
                this.nmd.nlY = 200.0d;
                this.nmd.nlZ = 0.01d;
                this.nmd.nlX = 200.0d;
            }
        }
        w.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.nmd.nlU + " maxTotalNum:" + this.nmd.nlT + " perGroupMaxValue:" + this.nmd.nlY + " perMinValue:" + this.nmd.nlZ + " perPersonMaxValue:" + this.nmd.nlX);
    }

    public final c aHS() {
        if (this.nmd == null) {
            init();
        }
        return this.nmd;
    }
}
