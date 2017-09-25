package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.plugin.remittance.c.g;
import com.tencent.mm.plugin.wallet_core.b.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class RemittanceUI extends RemittanceBaseUI {
    public final void aXg() {
        if (aXp()) {
            ap.yY();
            this.oRz = (String) c.vr().get(a.uFF, "");
            ap.yY();
            this.oRA = (String) c.vr().get(a.uFJ, "");
            ap.yY();
            this.oRB = ((Integer) c.vr().get(a.uFK, Integer.valueOf(0))).intValue();
            if (bg.mA(this.oRz) || bg.mA(this.oRA)) {
                r.a(true, null);
            } else {
                r.a(false, null);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void dj(String str, String str2) {
        if (this.oRe != null) {
            this.oRe.j(3, new Object[]{Integer.valueOf(this.oRh), Double.valueOf(this.oRf)});
        }
        w.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[]{Integer.valueOf(getIntent().getIntExtra("pay_channel", -1))});
        k gVar = new g(this.oRf, "1", this.gLD, this.oRh, this.hPi, str, str2, this.oRi, r11);
        gVar.gWO = "RemittanceProcess";
        k(gVar);
    }

    public final void aXj() {
        s.makeText(this.uSU.uTo, R.l.eKt, 0).show();
    }

    public final void aXm() {
        final b ruVar = new ru();
        ruVar.fYM.fYO = "7";
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ RemittanceUI oSZ;

            public final void run() {
                if (bg.mA(ruVar.fYN.fYP)) {
                    w.i("MicroMsg.RemittanceUI", "no bulletin data");
                } else {
                    e.a((TextView) this.oSZ.findViewById(R.h.bsx), ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
    }
}
