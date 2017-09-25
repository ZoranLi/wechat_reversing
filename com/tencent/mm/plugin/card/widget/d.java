package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class d extends a {
    private View krI;
    private TextView krJ;
    private TextView krK;
    private View krL;
    private TextView krM;
    private TextView krN;
    private View krO;
    private View krP;
    private View krQ;

    public d(Context context) {
        super(context);
    }

    protected final void aiS() {
        this.krI = this.krv.findViewById(R.h.cqR);
        this.krJ = (TextView) this.krv.findViewById(R.h.cqT);
        this.krK = (TextView) this.krv.findViewById(R.h.cqS);
        this.krL = this.krv.findViewById(R.h.bsK);
        this.krM = (TextView) this.krv.findViewById(R.h.bsM);
        this.krN = (TextView) this.krv.findViewById(R.h.bsL);
        this.krP = this.krv.findViewById(R.h.byN);
        this.krQ = this.krv.findViewById(R.h.bwk);
    }

    protected final void aiT() {
        lz lzVar;
        if (this.kcX.afi().toj == null || this.kcX.afi().toj.size() <= 0) {
            w.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList linkedList = this.kcX.afi().toj;
            lz lzVar2 = null;
            if (linkedList.size() == 1) {
                lzVar = (lz) linkedList.get(0);
            } else {
                lzVar = (lz) linkedList.get(0);
                lzVar2 = (lz) linkedList.get(1);
            }
            if (lzVar != null) {
                this.krI.setVisibility(0);
                this.krJ.setText(lzVar.title);
                this.krK.setText(lzVar.kdH);
                if (!TextUtils.isEmpty(lzVar.tpm)) {
                    this.krJ.setTextColor(l.ta(lzVar.tpm));
                }
                if (!TextUtils.isEmpty(lzVar.tpn)) {
                    this.krK.setTextColor(l.ta(lzVar.tpn));
                }
            }
            if (lzVar2 != null) {
                this.krL.setVisibility(0);
                this.krM.setText(lzVar2.title);
                this.krN.setText(lzVar2.kdH);
                if (!TextUtils.isEmpty(lzVar2.tpm)) {
                    this.krM.setTextColor(l.ta(lzVar2.tpm));
                }
                if (!TextUtils.isEmpty(lzVar2.tpn)) {
                    this.krN.setTextColor(l.ta(lzVar2.tpn));
                }
            }
        }
        if (this.kcX.aeN() && !this.kcX.aeT()) {
            w.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.kcX.afj().tnH == null || this.kcX.afj().tnH.size() <= 0) {
            if (this.krO != null) {
                this.krO.setVisibility(8);
            }
            this.krv.findViewById(R.h.bwk).setVisibility(8);
        } else {
            if (this.krO == null) {
                this.krO = ((ViewStub) this.krv.findViewById(R.h.byj)).inflate();
            }
            this.krv.findViewById(R.h.bwk).setVisibility(8);
            View view = this.krO;
            b bVar = this.kcX;
            OnClickListener onClickListener = this.iuW;
            LinkedList linkedList2 = bVar.afj().tnH;
            if (linkedList2.size() == 1) {
                view.findViewById(R.h.byn).setVisibility(0);
                lzVar = (lz) linkedList2.get(0);
                ((TextView) view.findViewById(R.h.cBn)).setText(lzVar.title);
                ((TextView) view.findViewById(R.h.cBk)).setText(lzVar.kdH);
                view.findViewById(R.h.byn).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(lzVar.tpm)) {
                    ((TextView) view.findViewById(R.h.cBn)).setTextColor(l.ta(lzVar.tpm));
                }
                if (!TextUtils.isEmpty(lzVar.tpn)) {
                    ((TextView) view.findViewById(R.h.cBk)).setTextColor(l.ta(lzVar.tpn));
                }
                view.findViewById(R.h.byo).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                lzVar = (lz) linkedList2.get(0);
                ((TextView) view.findViewById(R.h.cBn)).setText(lzVar.title);
                ((TextView) view.findViewById(R.h.cBk)).setText(lzVar.kdH);
                if (!TextUtils.isEmpty(lzVar.tpm)) {
                    ((TextView) view.findViewById(R.h.cBn)).setTextColor(l.ta(lzVar.tpm));
                }
                if (!TextUtils.isEmpty(lzVar.tpn)) {
                    ((TextView) view.findViewById(R.h.cBk)).setTextColor(l.ta(lzVar.tpn));
                }
                lzVar = (lz) linkedList2.get(1);
                ((TextView) view.findViewById(R.h.cBo)).setText(lzVar.title);
                ((TextView) view.findViewById(R.h.cBl)).setText(lzVar.kdH);
                if (!TextUtils.isEmpty(lzVar.tpm)) {
                    ((TextView) view.findViewById(R.h.cBo)).setTextColor(l.ta(lzVar.tpm));
                }
                if (!TextUtils.isEmpty(lzVar.tpn)) {
                    ((TextView) view.findViewById(R.h.cBl)).setTextColor(l.ta(lzVar.tpn));
                }
                view.findViewById(R.h.byn).setOnClickListener(onClickListener);
                view.findViewById(R.h.byo).setOnClickListener(onClickListener);
            }
        }
        if (this.kcX.afe()) {
            this.krP.setVisibility(8);
        } else {
            this.krP.setVisibility(0);
            TextView textView = (TextView) this.krP.findViewById(R.h.byw);
            if (TextUtils.isEmpty(this.kcX.afi().toI)) {
                m.b(textView, this.kcX.afj().status);
            } else {
                textView.setText(this.kcX.afi().toI);
            }
        }
        if (this.kcX.afj().tnQ == null && this.kcX.afe()) {
            this.krQ.setVisibility(0);
        } else {
            this.krQ.setVisibility(8);
        }
    }
}
