package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.remittance.c.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.x.n;
import com.tencent.mm.y.k;

@a(7)
public class RemittanceAdapterUI extends WalletBaseUI {
    public String gLD = null;
    public int hPi;
    protected int npX;
    public boolean oQZ = false;
    protected com.tencent.mm.plugin.wallet.a oRa = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(8);
        this.hPi = getIntent().getIntExtra("scene", 0);
        this.gLD = getIntent().getStringExtra("receiver_name");
        this.npX = getIntent().getIntExtra("pay_channel", -1);
        this.oRa = com.tencent.mm.plugin.wallet.a.S(getIntent());
        if (this.npX == -1) {
            b ccE = ccE();
            if (ccE != null) {
                this.npX = ccE.lHw.getInt("pay_channel", -1);
            }
        }
        if (this.hPi == 1) {
            this.oQZ = true;
            aXf();
        } else if (this.hPi == 3) {
            hn(580);
            if (getIntent() == null) {
                w.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                return;
            }
            k aVar = new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 3);
            aVar.gWO = "RemittanceProcess";
            q(aVar);
        } else if (this.hPi == 2) {
            if (bg.mA(this.gLD)) {
                w.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.hPi);
                finish();
                return;
            }
            b(this.gLD, 31, null);
        } else if (this.hPi != 5 && this.hPi != 6) {
            b(null, 31, null);
        } else if (bg.mA(this.gLD)) {
            w.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.hPi);
            finish();
        } else {
            String str = this.gLD;
            w.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.hPi + ", name=" + str);
            Intent intent = new Intent();
            com.tencent.mm.plugin.wallet.a.a(this.oRa, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.hPi);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.npX);
            startActivity(intent);
            setResult(-1);
            finish();
        }
    }

    public void aXf() {
        k hVar = new h(this.gLD, this.npX);
        hVar.gWO = "RemittanceProcess";
        b(hVar, false);
    }

    public void onDestroy() {
        if (this.hPi == 3) {
            ho(580);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.oQZ) {
            w.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
            return;
        }
        w.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
        finish();
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof h) {
            this.oQZ = false;
        }
        if (i != 0 || i2 != 0) {
            setResult(0);
            g.bl(this, str);
            finish();
            return true;
        } else if (kVar instanceof h) {
            final h hVar = (h) kVar;
            this.gLD = hVar.username;
            if (bg.mA(this.gLD)) {
                w.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.hPi);
                finish();
                return true;
            }
            if (this.hPi == 1) {
                if (hVar.scene == 33) {
                    this.oRa = com.tencent.mm.plugin.wallet.a.bV(this.gLD, 2);
                    this.oRa.au(20, getIntent().getStringExtra("receiver_name"));
                } else {
                    this.oRa = com.tencent.mm.plugin.wallet.a.bV(this.gLD, 3);
                    this.oRa.au(10, getIntent().getStringExtra("receiver_name"));
                }
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", hVar.kBc);
            intent.putExtra("desc", hVar.desc);
            intent.putExtra("scan_remittance_id", hVar.oQG);
            intent.putExtra("receiver_true_name", e.UJ(hVar.oQF));
            intent.putExtra("receiver_tips", hVar.oQH);
            intent.putExtra("rcvr_new_desc", hVar.oQI);
            intent.putExtra("payer_desc", hVar.oQJ);
            ap.yY();
            if (c.wR().Rb(this.gLD) != null) {
                b(this.gLD, hVar.scene, intent);
            } else {
                w.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long Nz = bg.Nz();
                ag.a.hlS.a(this.gLD, "", new ag.b.a(this) {
                    final /* synthetic */ RemittanceAdapterUI oRd;

                    public final void p(String str, boolean z) {
                        if (z) {
                            w.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bg.Nz() - Nz) + " ms");
                            com.tencent.mm.x.b.u(str, 3);
                            n.Bz().hf(str);
                        } else {
                            w.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
                        }
                        this.oRd.b(this.oRd.gLD, hVar.scene, intent);
                    }
                });
            }
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a)) {
            return false;
        } else {
            b(null, 31, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void b(String str, int i, Intent intent) {
        Intent intent2;
        w.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.hPi + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        com.tencent.mm.plugin.wallet.a.a(this.oRa, intent2);
        intent2.setClass(this, RemittanceUI.class);
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.hPi);
        intent2.putExtra("pay_scene", i);
        intent2.putExtra("pay_channel", this.npX);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
