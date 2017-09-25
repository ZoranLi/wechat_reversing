package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.n;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;

@a(3)
public class WalletOrderInfoUI extends WalletBaseUI {
    private String ocu;
    protected b.a rMs = new b.a(this) {
        final /* synthetic */ WalletOrderInfoUI rMR;

        {
            this.rMR = r1;
        }

        public final void p(String str, boolean z) {
            ap.yY();
            x Rc = c.wR().Rc(str);
            w.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
            this.rMR.K(Rc);
        }
    };
    private Orders ryM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (aXw()) {
            this.ryM = buY();
            this.ocu = this.uT.getString("key_trans_id");
            int i = this.uT.getInt("key_pay_type", -1);
            w.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[]{this.ocu});
            if (this.ocu != null) {
                if (i == -1) {
                    Io(this.ocu);
                } else {
                    bX(this.ocu, i);
                }
            } else if (this.ryM != null) {
                d(this.ryM);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.ryM != null && !bg.mA(this.ryM.username)) {
            ag.a.hlS.gc(this.ryM.username);
        }
    }

    protected boolean aXw() {
        return true;
    }

    protected Orders buY() {
        return (Orders) this.uT.getParcelable("key_orders");
    }

    protected int getLayoutId() {
        return R.i.dpj;
    }

    public void Io(String str) {
        k(new n(str));
    }

    protected void bX(String str, int i) {
        k(new n(str, i));
    }

    private void d(Orders orders) {
        w.j("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[]{Integer.valueOf(orders.rGo)});
        if (orders.rGo == 1) {
            ccE().b(this, WalletOrderInfoNewUI.class, this.uT);
        } else {
            ccE().b(this, WalletOrderInfoOldUI.class, this.uT);
        }
        finish();
    }

    protected void K(x xVar) {
        if (xVar != null && ((int) xVar.gTQ) != 0) {
            String tK = xVar.tK();
            w.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + tK + " username: " + xVar.field_username);
            if (this.ryM.rGe != null && this.ryM.rGe.size() > 0) {
                for (Commodity commodity : this.ryM.rGe) {
                    commodity.ogb = tK;
                }
            }
        }
    }

    protected static String d(String str, String str2, String str3, String str4, String str5) {
        try {
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str5, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.indexOf("%7Breqkey%7D") > 0 || str.indexOf("%7Btransid%7D") > 0 || str.indexOf("%7Bphone%7D") > 0 || str.indexOf("%7Bremark%7D") > 0) {
                w.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
                return str.replace("%7Breqkey%7D", str2).replace("%7Btransid%7D", str3).replace("%7Bphone%7D", str4).replace("%7Bremark%7D", encode);
            } else if (str.indexOf("{reqkey}") > 0 || str.indexOf("{transid}") > 0 || str.indexOf("{phone}") > 0 || str.indexOf("{remark}") > 0) {
                w.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
                return str.replace("{reqkey}", str2).replace("{transid}", str3).replace("{phone}", str4).replace("{remark}", encode);
            } else {
                w.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
                return str + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[]{str2, str3, str4, encode});
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WalletOrderInfoUI", e, "", new Object[0]);
            return str;
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof n) || i != 0 || i2 != 0) {
            return false;
        }
        this.ryM = ((n) kVar).rCc;
        if (this.ryM != null) {
            if (!(this.ryM.rGe == null || this.ryM.rGe.size() == 0)) {
                Commodity commodity = (Commodity) this.ryM.rGe.get(0);
                this.ocu = commodity.fTA;
                w.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                ap.yY();
                com.tencent.mm.j.a Rc = c.wR().Rc(commodity.ogb);
                if (Rc == null || ((int) Rc.gTQ) == 0) {
                    ag.a.hlS.a(commodity.ogb, "", this.rMs);
                } else {
                    K(Rc);
                }
            }
            d(this.ryM);
        } else {
            w.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
            g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                final /* synthetic */ WalletOrderInfoUI rMR;

                {
                    this.rMR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rMR.finish();
                }
            });
        }
        return true;
    }
}
