package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.remittance.c.d;
import com.tencent.mm.plugin.remittance.c.k;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.x.n;

@a(7)
public class RemittanceOSRedirect extends WalletBaseUI {
    public String gLD = "";
    private int hPi;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zg(8);
        this.hPi = getIntent().getIntExtra("scene", 0);
        this.gLD = getIntent().getStringExtra("receiver_name");
        if (this.hPi == 0) {
            w.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[]{Integer.valueOf(this.hPi)});
            finish();
        } else if (this.hPi == 5) {
            this.wFr.hn(1574);
            k(new k(m.xS()));
        } else if (this.hPi == 6) {
            this.wFr.hn(1301);
            b(new d(this.gLD), true);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        return true;
    }

    public final void b(int i, int i2, String str, com.tencent.mm.y.k kVar, boolean z) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof k) {
                k kVar2 = (k) kVar;
                w.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[]{kVar2.oQT});
                Intent intent = getIntent();
                if (kVar2.kAM == 1) {
                    e.a(this, 2, this.gLD, 11, null);
                } else {
                    intent.setClass(this, RemittanceOSUI.class);
                    intent.putExtra("os_currency", kVar2.kAM);
                    intent.putExtra("os_currencyuint", kVar2.oQT);
                    intent.putExtra("os_currencywording", kVar2.oQU);
                    intent.putExtra("os_notice", kVar2.kAO);
                    intent.putExtra("os_notice_url", kVar2.kAP);
                    startActivity(intent);
                }
                finish();
            } else if (kVar instanceof d) {
                d dVar = (d) kVar;
                final Intent intent2 = new Intent();
                intent2.setClass(this, RemittanceHKUI.class);
                this.gLD = dVar.oQl;
                if (bg.mA(this.gLD)) {
                    w.e("MicroMsg.RemittanceOSRedirect", "empty username");
                    finish();
                }
                intent2.putExtra("scene", this.hPi);
                intent2.putExtra("fee", ((double) dVar.fZT) / 100.0d);
                intent2.putExtra("desc", dVar.desc);
                intent2.putExtra("scan_remittance_id", dVar.oQn);
                intent2.putExtra("receiver_name", dVar.oQl);
                intent2.putExtra("receiver_true_name", dVar.kAQ);
                intent2.putExtra("receiver_nick_name", dVar.oQm);
                intent2.putExtra("hk_currency", dVar.kAM);
                intent2.putExtra("hk_currencyuint", dVar.kAN);
                intent2.putExtra("hk_notice", dVar.kAO);
                intent2.putExtra("hk_notice_url", dVar.kAP);
                int i3 = 32;
                w.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[]{Integer.valueOf(dVar.kAR)});
                if (dVar.kAR == 1) {
                    i3 = 33;
                }
                intent2.putExtra("pay_scene", i3);
                ap.yY();
                if (c.wR().Rb(this.gLD) != null) {
                    startActivity(intent2);
                    finish();
                    return;
                }
                w.d("MicroMsg.RemittanceOSRedirect", "Receiver in contactStg and try to get contact");
                final long Nz = bg.Nz();
                ag.a.hlS.a(this.gLD, "", new b.a(this) {
                    final /* synthetic */ RemittanceOSRedirect oSz;

                    public final void p(String str, boolean z) {
                        if (z) {
                            w.v("MicroMsg.RemittanceOSRedirect", "getContact suc; cost=" + (bg.Nz() - Nz) + " ms");
                            com.tencent.mm.x.b.u(str, 3);
                            n.Bz().hf(str);
                        } else {
                            w.w("MicroMsg.RemittanceOSRedirect", "getContact failed");
                        }
                        this.oSz.startActivity(intent2);
                        this.oSz.finish();
                    }
                });
            }
        } else if (kVar instanceof k) {
            w.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[]{str});
            g.a(this, str, "", new OnClickListener(this) {
                final /* synthetic */ RemittanceOSRedirect oSz;

                {
                    this.oSz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oSz.finish();
                }
            });
        } else if (kVar instanceof d) {
            g.a(this, str, "", new OnClickListener(this) {
                final /* synthetic */ RemittanceOSRedirect oSz;

                {
                    this.oSz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oSz.finish();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.hPi == 5) {
            ho(1574);
        } else if (this.hPi == 6) {
            ho(1301);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }
}
