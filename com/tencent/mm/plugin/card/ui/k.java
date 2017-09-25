package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.pb.common.c.i;
import java.util.LinkedList;

public final class k implements c {
    private BaseAdapter kjh;
    private int kjl;
    protected LinkedList<CardTagTextView> kjp = new LinkedList();
    private int kpg;
    int kph;
    int kpi;
    private Context mContext;

    public class a {
        public RelativeLayout kjt;
        public ImageView kju;
        public TextView kjv;
        public TextView kjw;
        public TextView kjz;
        public View kox;
        public ImageView koy;
        public ImageView kpj;
        public LinearLayout kpk;
        public ImageView kpl;
        public ImageView kpm;
        public ImageView kpn;
        final /* synthetic */ k kpo;

        public a(k kVar) {
            this.kpo = kVar;
        }
    }

    public k(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.kjh = baseAdapter;
        this.kpg = this.mContext.getResources().getDimensionPixelSize(R.f.aXV);
        this.kjl = this.mContext.getResources().getDimensionPixelSize(R.f.aXz);
        this.kph = this.mContext.getResources().getDimensionPixelOffset(R.f.aYG);
        this.kpi = this.mContext.getResources().getDimensionPixelOffset(R.f.aYH);
    }

    public final void release() {
        this.mContext = null;
        this.kjh = null;
        if (this.kjp != null) {
            this.kjp.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        String string;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.cWG, null);
            a aVar2 = new a(this);
            aVar2.kjt = (RelativeLayout) view.findViewById(R.h.bwF);
            aVar2.kju = (ImageView) view.findViewById(R.h.bxt);
            aVar2.kox = view.findViewById(R.h.byJ);
            aVar2.koy = (ImageView) view.findViewById(R.h.byI);
            aVar2.kjv = (TextView) view.findViewById(R.h.bwl);
            aVar2.kjw = (TextView) view.findViewById(R.h.bxN);
            aVar2.kjz = (TextView) view.findViewById(R.h.bxP);
            aVar2.kpj = (ImageView) view.findViewById(R.h.bvZ);
            aVar2.kpl = (ImageView) view.findViewById(R.h.bwg);
            aVar2.kpm = (ImageView) view.findViewById(R.h.bwi);
            aVar2.kpn = (ImageView) view.findViewById(R.h.bwh);
            aVar2.kpk = (LinearLayout) view.findViewById(R.h.byi);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.kjh.getItem(i) instanceof CardInfo) {
            CharSequence charSequence;
            boolean z;
            CardInfo cardInfo = (CardInfo) this.kjh.getItem(i);
            if (cardInfo.field_stickyIndex % 10 != 0) {
                if (cardInfo.field_stickyIndex > 0) {
                    Context context = this.mContext;
                    switch (cardInfo.field_stickyIndex % 10) {
                        case 0:
                            string = context.getString(R.l.dSn);
                            break;
                        case 1:
                            string = context.getString(R.l.dSm);
                            break;
                        case 2:
                            string = context.getString(R.l.dSl);
                            break;
                        case 3:
                            string = context.getString(R.l.dSk);
                            break;
                        default:
                            string = null;
                            break;
                    }
                    charSequence = string;
                    z = true;
                }
                charSequence = null;
                z = false;
            } else {
                if (!i.wx(cardInfo.field_label_wording)) {
                    Object obj = cardInfo.field_label_wording;
                    z = true;
                }
                charSequence = null;
                z = false;
            }
            if (z) {
                View cardTagTextView;
                for (int i2 = 0; i2 < aVar.kpk.getChildCount(); i2++) {
                    this.kjp.add((CardTagTextView) aVar.kpk.getChildAt(i2));
                }
                aVar.kpk.removeAllViews();
                aVar.kpk.setVisibility(0);
                if (this.kjp.size() == 0) {
                    cardTagTextView = new CardTagTextView(this.mContext);
                } else {
                    CardTagTextView cardTagTextView2 = (CardTagTextView) this.kjp.removeFirst();
                }
                cardTagTextView.setPadding(this.kjl, this.kpg, this.kjl, this.kpg);
                cardTagTextView.setGravity(17);
                cardTagTextView.setMinWidth(this.mContext.getResources().getDimensionPixelSize(R.f.aYJ));
                cardTagTextView.setMinHeight(this.mContext.getResources().getDimensionPixelSize(R.f.aYI));
                if (cardInfo.aeP()) {
                    cardTagTextView.setTextColor(com.tencent.mm.bg.a.b(this.mContext, R.e.white));
                    cardTagTextView.fillColor = com.tencent.mm.bg.a.b(this.mContext, R.e.aTn);
                } else {
                    cardTagTextView.setTextColor(com.tencent.mm.bg.a.b(this.mContext, R.e.aUA));
                    cardTagTextView.fillColor = 0;
                }
                cardTagTextView.setText(charSequence);
                cardTagTextView.setTextSize(1, 10.0f);
                aVar.kpk.addView(cardTagTextView);
            } else {
                aVar.kpk.setVisibility(8);
            }
        }
        if (bVar.aeU()) {
            aVar.kju.setVisibility(0);
            aVar.kjw.setVisibility(0);
            aVar.kjz.setVisibility(8);
            aVar.kjv.setVisibility(0);
            aVar.kjv.setText(bVar.afi().keT);
            aVar.kjw.setText(bVar.afi().title);
            if (bVar.aeR()) {
                aVar.kox.setVisibility(0);
                aVar.kju.setVisibility(4);
                ImageView imageView = aVar.koy;
                if (TextUtils.isEmpty(bVar.afi().tos)) {
                    m.a(imageView, R.g.bdy, l.ta(bVar.afi().hib));
                } else {
                    m.a(this.mContext, imageView, bVar.afi().tos, this.mContext.getResources().getDimensionPixelSize(R.f.aYK), R.g.bdy, l.ta(bVar.afi().hib));
                }
            } else {
                aVar.kox.setVisibility(8);
                aVar.kju.setVisibility(0);
                m.a(aVar.kju, bVar.afi().kdG, this.mContext.getResources().getDimensionPixelSize(R.f.aYK), R.g.bhq, true);
            }
            if (bVar.aeP()) {
                if (bg.mA(bVar.afj().tnR)) {
                    aVar.kjt.setBackgroundDrawable(l.bJ(l.ta(bVar.afi().hib), this.kph));
                    aVar.kpl.setVisibility(8);
                    aVar.kpm.setVisibility(8);
                    aVar.kpn.setVisibility(0);
                } else {
                    aVar.kjt.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bdq));
                    aVar.kpl.setVisibility(0);
                    aVar.kpm.setVisibility(0);
                    ImageView imageView2 = aVar.kpl;
                    string = bVar.afj().tnR;
                    com.tencent.mm.ah.a.a.c.a aVar3 = new com.tencent.mm.ah.a.a.c.a();
                    aVar3.hIO = e.hgu;
                    n.GX();
                    aVar3.hJg = null;
                    aVar3.hIN = com.tencent.mm.plugin.card.model.m.sw(string);
                    aVar3.hIL = true;
                    aVar3.hJk = true;
                    aVar3.hIJ = true;
                    aVar3.hJa = R.g.bdq;
                    n.GW().a(string, imageView2, aVar3.Hg());
                    imageView2.setImageMatrix(new Matrix());
                    aVar.kpn.setVisibility(8);
                }
                aVar.kjv.setTextColor(this.mContext.getResources().getColor(R.e.white));
                aVar.kjw.setTextColor(this.mContext.getResources().getColor(R.e.white));
            } else {
                aVar.kpn.setVisibility(8);
                aVar.kpl.setVisibility(8);
                aVar.kpm.setVisibility(8);
                aVar.kjt.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bdq));
                aVar.kjw.setTextColor(this.mContext.getResources().getColor(R.e.aTh));
                aVar.kjv.setTextColor(this.mContext.getResources().getColor(R.e.aTh));
            }
        } else {
            aVar.kju.setVisibility(8);
            aVar.kjw.setVisibility(8);
            aVar.kjv.setVisibility(8);
            aVar.kpk.setVisibility(8);
            aVar.kjz.setVisibility(0);
            aVar.kjt.setBackgroundDrawable(l.bJ(this.mContext.getResources().getColor(R.e.aTm), this.kph));
            aVar.kjz.setText(this.mContext.getResources().getString(R.l.dRx));
        }
        int i3 = bVar.afi().kdF;
        LayoutParams layoutParams;
        if (i != this.kjh.getCount() - 1 || aVar.kjt == null) {
            layoutParams = (LayoutParams) aVar.kjt.getLayoutParams();
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                aVar.kjt.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams = (LayoutParams) aVar.kjt.getLayoutParams();
            if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.f.aXx)) {
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.aXx);
                aVar.kjt.setLayoutParams(layoutParams);
            }
        }
        return view;
    }

    public final void t(View view, int i) {
        ((a) view.getTag()).kpj.setImageResource(i);
    }

    public final void u(View view, int i) {
        ((a) view.getTag()).kpj.setVisibility(i);
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
        a aVar = (a) view.getTag();
        aVar.kpj.setTag(Integer.valueOf(i));
        aVar.kpj.setOnClickListener(onClickListener);
    }
}
