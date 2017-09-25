package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class b extends l {
    private b rSq;
    private int rSr = 0;
    private boolean rSs = false;
    private a rSt;

    private class a {
        public com.tencent.mm.plugin.wallet_core.ui.l.a rNo;
        public OnCancelListener rSA;
        final /* synthetic */ b rSB;
        public String rSv;
        public Bankcard rSw;
        public FavorPayInfo rSx;
        public boolean rSy;
        public b rSz;

        public a(b bVar, String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, OnCancelListener onCancelListener, com.tencent.mm.plugin.wallet_core.ui.l.a aVar, b bVar2) {
            this.rSB = bVar;
            this.rSv = str;
            this.rSw = bankcard;
            this.rSx = favorPayInfo;
            this.rSy = z;
            this.rSA = onCancelListener;
            this.rNo = aVar;
            this.rSz = bVar2;
        }
    }

    public interface b {
        void a(String str, String str2, FavorPayInfo favorPayInfo);
    }

    static class AnonymousClass1 extends b {
        final /* synthetic */ a rSu;

        AnonymousClass1(Context context, int i, a aVar) {
            this.rSu = aVar;
            super(context);
        }

        public final int bvh() {
            int i = 3;
            if (this.rSu.rSw != null && this.rSu.rSw.field_bankcardClientType == 1) {
                w.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.rSu.rSw).rJb;
            }
            if (i != 4) {
                return R.i.dkv;
            }
            w.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
            return R.i.dku;
        }
    }

    public b(Context context) {
        super(context);
    }

    protected final void bV(Context context) {
        da(context);
        super.db(context);
        if (this.rNt != null) {
            this.rNt.setVisibility(8);
        }
    }

    protected final void db(Context context) {
        super.db(context);
    }

    public static b a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, b bVar, OnClickListener onClickListener, OnCancelListener onCancelListener, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        String av;
        List buM;
        String str;
        String str2;
        String str3;
        CharSequence charSequence;
        boolean z2;
        com.tencent.mm.plugin.wallet_core.ui.a a = com.tencent.mm.plugin.wallet_core.ui.b.rJj.a(orders);
        if (a != null) {
            if (favorPayInfo != null) {
                if (!(bankcard == null || bankcard.field_bankcardType.equals(favorPayInfo.rFo))) {
                    av = a.av(favorPayInfo.rFm, false);
                    com.tencent.mm.plugin.wallet_core.ui.a.a aVar = (com.tencent.mm.plugin.wallet_core.ui.a.a) a.au(av, true).get(bankcard.field_bankcardType);
                    if (aVar == null || aVar.rJg == null || bg.mA(aVar.rJg.ryd)) {
                        favorPayInfo.rFm = av;
                    } else {
                        favorPayInfo.rFm = aVar.rJg.ryd;
                    }
                }
            } else if (orders.rGf != null) {
                favorPayInfo = a.Il(a.Im(orders.rGf.rxP));
            }
            buM = a.buM();
        } else {
            w.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            buM = null;
        }
        Commodity commodity = (Commodity) orders.rGe.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (bg.mA(commodity.ofP)) {
            str = "";
        } else {
            str = commodity.ofP + "\n";
        }
        String stringBuilder2 = stringBuilder.append(str).append(((Commodity) orders.rGe.get(0)).desc).toString();
        if (a == null || favorPayInfo == null) {
            str2 = null;
            str3 = null;
            charSequence = null;
            z2 = false;
        } else {
            h Ii = a.Ii(favorPayInfo.rFm);
            if (Ii != null && Ii.rye > 0.0d) {
                String d = e.d(orders.rFM, orders.oga);
                String d2 = e.d(Ii.rxO, orders.oga);
                av = context.getString(R.l.fiA, new Object[]{e.n(Ii.rye)});
                str3 = d2;
                str2 = d;
                z2 = true;
                charSequence = av;
            } else if (buM == null || buM.size() <= 0) {
                charSequence = null;
                str2 = null;
                str3 = e.d(orders.rFM, orders.oga);
                z2 = false;
            } else {
                z2 = true;
                str2 = null;
                str3 = null;
                Object string = context.getString(R.l.fjf);
            }
        }
        if (bankcard == null) {
            str = "";
        } else {
            str = bankcard.field_desc;
        }
        Dialog bVar2 = new b(context);
        bVar2.rNs = bankcard;
        bVar2.a(context, orders, favorPayInfo, bankcard);
        bVar2.bvi();
        bVar2.b(onCancelListener);
        bVar2.setOnCancelListener(onCancelListener);
        bVar2.setCancelable(true);
        bVar2.Ip(stringBuilder2);
        bVar2.Iq(str3);
        bVar2.Is(str2);
        bVar2.a(str, onClickListener, z2);
        if (TextUtils.isEmpty(charSequence)) {
            bVar2.rNd.setVisibility(8);
        } else {
            bVar2.rNd.setVisibility(0);
            bVar2.rNd.setText(charSequence);
        }
        bVar2.rSs = z;
        bVar2.rNe.wFS = -10;
        bVar2.rSq = bVar;
        bVar2.show();
        g.a(context, bVar2);
        return bVar2;
    }

    protected final void bvj() {
        if (this.rNp != null) {
            this.rNp.onClick(this, 0);
        }
        dismiss();
        if (this.rSq == null) {
            return;
        }
        if (!this.rSs) {
            this.rSq.a(this.rNe.getText(), "", this.rzg);
        } else if (this.rSr == 0) {
            Context context = getContext();
            a aVar = new a(this, this.rNe.getText(), this.rNs, this.rzg, this.rNq, this.FU, this.rNo, this.rSq);
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                Dialog anonymousClass1 = new AnonymousClass1(context, R.m.foO, aVar);
                anonymousClass1.rSr = 1;
                anonymousClass1.rSs = true;
                anonymousClass1.rSt = aVar;
                if (anonymousClass1.rSt != null) {
                    anonymousClass1.bvi();
                    anonymousClass1.b(anonymousClass1.rSt.rSA);
                    anonymousClass1.setOnCancelListener(anonymousClass1.rSt.rSA);
                    anonymousClass1.setCancelable(true);
                    anonymousClass1.Iq(anonymousClass1.rSt.rSw == null ? "" : anonymousClass1.rSt.rSw.field_desc);
                    anonymousClass1.iH(false);
                    anonymousClass1.rNo = anonymousClass1.rSt.rNo;
                    anonymousClass1.rSq = anonymousClass1.rSt.rSz;
                    anonymousClass1.rNe.wFS = 30;
                    anonymousClass1.show();
                    g.a(context, anonymousClass1);
                }
            }
        } else if (this.rSr == 1) {
            this.rSq.a(this.rSt.rSv, this.rNe.getText(), this.rSt.rSx);
        } else {
            w.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        }
    }
}
