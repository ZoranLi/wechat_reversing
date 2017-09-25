package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.y.k;

public class WalletIbgOrderInfoUI extends WalletOrderInfoOldUI {
    private String ivH = null;
    private String mTimeStamp = null;
    private String rOG = null;
    private String rOH = null;
    private String rOI = null;
    private String rOJ = null;
    private String rxz = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.wFr.hn(1565);
    }

    public final void done() {
        w.i("MicroMsg.WalletIbgOrderInfoUI", "hy: result is not set manly. set to OK");
        for (String str : this.rLq) {
            if (!bg.mA(str)) {
                w.d("MicroMsg.WalletIbgOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                ap.vd().a(new h(str), 0);
            }
        }
        setResult(-1);
        finish();
    }

    protected final void Oe() {
        this.ivH = getIntent().getStringExtra("appId");
        this.rOG = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.rxz = getIntent().getStringExtra("packageExt");
        this.rOH = getIntent().getStringExtra("paySignature");
        this.rOI = getIntent().getStringExtra("signtype");
        this.rOJ = getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        q(new b(this.ivH, this.rOG, this.mTimeStamp, this.rxz, this.rOH, this.rOI, this.rOJ));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof b)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            this.ryM = ((b) kVar).rCc;
            if (this.ryM != null) {
                this.rLr = this.ryM.rGe;
            }
            c(this.ryM);
            w.d("MicroMsg.WalletIbgOrderInfoUI", "Coomdity:" + this.rLr);
            if (!(this.rLr == null || this.rLr.size() == 0)) {
                Commodity commodity = (Commodity) this.rLr.get(0);
                w.d("MicroMsg.WalletIbgOrderInfoUI", "Coomdity:" + commodity.toString());
                ap.yY();
                a Rc = c.wR().Rc(commodity.ogb);
                if (Rc == null || ((int) Rc.gTQ) == 0) {
                    ag.a.hlS.a(commodity.ogb, "", this.rMs);
                } else {
                    K(Rc);
                }
            }
            this.rMl.notifyDataSetChanged();
            bva();
            return true;
        }
        setResult(0);
        return false;
    }
}
