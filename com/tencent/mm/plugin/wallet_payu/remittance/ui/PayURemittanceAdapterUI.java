package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.x.n;
import com.tencent.mm.y.k;

@a(7)
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    protected final void aXf() {
        b(new e(this.gLD), false);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar instanceof e) {
            this.oQZ = false;
        }
        if (i != 0 || i2 != 0 || !(kVar instanceof e)) {
            return false;
        }
        final e eVar = (e) kVar;
        this.gLD = eVar.username;
        if (bg.mA(this.gLD)) {
            w.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.hPi);
            finish();
            return true;
        }
        final Intent intent = new Intent();
        intent.putExtra("fee", eVar.kBc);
        intent.putExtra("desc", eVar.desc);
        intent.putExtra("scan_remittance_id", eVar.oQG);
        intent.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.UJ(eVar.oQF));
        ap.yY();
        if (c.wR().Rb(this.gLD) != null) {
            b(this.gLD, eVar.scene, intent);
        } else {
            w.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
            final long Nz = bg.Nz();
            ag.a.hlS.a(this.gLD, "", new b.a(this) {
                final /* synthetic */ PayURemittanceAdapterUI rSN;

                public final void p(String str, boolean z) {
                    if (z) {
                        w.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bg.Nz() - Nz) + " ms");
                        com.tencent.mm.x.b.u(str, 3);
                        n.Bz().hf(str);
                    } else {
                        w.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
                    }
                    this.rSN.b(this.rSN.gLD, eVar.scene, intent);
                }
            });
        }
        return true;
    }

    protected final void b(String str, int i, Intent intent) {
        Intent intent2;
        w.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.hPi + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.setClass(this, PayURemittanceUI.class);
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.hPi);
        intent2.putExtra("pay_scene", i);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
