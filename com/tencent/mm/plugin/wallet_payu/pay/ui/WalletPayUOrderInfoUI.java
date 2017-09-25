package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.plugin.wallet_payu.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class WalletPayUOrderInfoUI extends WalletOrderInfoOldUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hn(1554);
    }

    protected final void buZ() {
        k(new a());
    }

    protected final void Io(String str) {
        k(new c(str, 1));
    }

    public void onDestroy() {
        ho(1554);
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
            return true;
        }
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (cVar.oSJ.rGe == null || cVar.oSJ.rGe.size() <= 0) {
                w.w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
                g.a(this, R.l.fiS, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ WalletPayUOrderInfoUI rSo;

                    {
                        this.rSo = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.c(this.rSo, this.rSo.uT, 0);
                    }
                });
            } else {
                Commodity commodity = (Commodity) cVar.oSJ.rGe.get(0);
                w.d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:" + commodity);
                d.bvC().rRK = null;
                if (commodity != null) {
                    this.rLr = new ArrayList();
                    this.rLr.add(commodity);
                    ap.yY();
                    com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(commodity.ogb);
                    if (Rc == null || ((int) Rc.gTQ) == 0) {
                        ag.a.hlS.a(commodity.ogb, "", this.rMs);
                    } else {
                        K(Rc);
                    }
                    this.rMl.notifyDataSetChanged();
                    bva();
                }
            }
        }
        return super.d(i, i2, str, kVar);
    }

    public final void done() {
        buX();
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.uT.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.uT.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.uT.getBoolean("intent_pay_end"));
        w.i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + this.uT.getInt("intent_pay_end_errcode"));
        for (String str : this.rLq) {
            String str2;
            if (!bg.mA(str2)) {
                w.d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str2});
                b(new h(str2), false);
            }
        }
        com.tencent.mm.wallet_core.a.k(this, bundle);
        if (this.ryM != null && !bg.mA(this.ryM.lfx)) {
            str2 = this.ryM.rGe.size() > 0 ? ((Commodity) this.ryM.rGe.get(0)).fTA : "";
            str2 = String.format("%sreqkey=%s&transid=%s", new Object[]{this.ryM.lfx, this.ryM.fJH, str2});
            w.d("MicroMsg.WalletPayUOrderInfoUI", "url = " + str2);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", m.xL());
            com.tencent.mm.bb.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
