package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x extends i {
    MMActivity kdb;
    private boolean kqC = false;
    private View kqD;
    private View kqE;
    private ImageView kqF;
    private TextView kqG;
    private TextView kqH;
    private ImageView kqI;
    public View kqJ;
    private LinearLayout kqK;
    private OnClickListener kqL = new OnClickListener(this) {
        final /* synthetic */ x kqM;

        {
            this.kqM = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                b ahj = this.kqM.kqe.ahj();
                this.kqM.kqe.ahl();
                r rVar = (r) view.getTag();
                if (rVar != null && rVar.khs != null && !rVar.khs.isEmpty()) {
                    if (rVar.khr != null && rVar.khr.equals(ahj.afo())) {
                        this.kqM.kqJ.setVisibility(8);
                        this.kqM.kqe.agB();
                    } else if (TextUtils.isEmpty(rVar.khr) && TextUtils.isEmpty(ahj.afo())) {
                        this.kqM.kqJ.setVisibility(8);
                        this.kqM.kqe.agB();
                    } else {
                        boolean z;
                        ArrayList sA = com.tencent.mm.plugin.card.sharecard.a.b.sA(rVar.kdE);
                        if (sA == null || sA.size() <= 0) {
                            z = false;
                        } else {
                            z = false;
                            for (int i = 0; i < sA.size(); i++) {
                                r rVar2 = (r) sA.get(i);
                                if ((rVar2.khr == null || !rVar2.khr.equals(rVar.khr)) && !(TextUtils.isEmpty(rVar2.khr) && TextUtils.isEmpty(rVar.khr))) {
                                    rVar2.kht = false;
                                    sA.set(i, rVar2);
                                } else {
                                    rVar2.kht = true;
                                    if (!rVar2.khu) {
                                        rVar2.khu = true;
                                        z = true;
                                    }
                                    sA.set(i, rVar2);
                                }
                            }
                        }
                        b sH = al.agi().sH((String) rVar.khs.get(0));
                        if (sH != null) {
                            this.kqM.kqe.d(sH);
                        }
                        if (z && this.kqM.kqe.ahp() != null) {
                            this.kqM.kqe.ahp().ahc();
                        }
                        this.kqM.kqJ.setVisibility(8);
                    }
                }
            }
        }
    };

    public final void KC() {
        this.kqD = findViewById(R.h.cET);
        this.kqE = findViewById(R.h.cEU);
        this.kqF = (ImageView) findViewById(R.h.cEN);
        this.kqG = (TextView) findViewById(R.h.cEO);
        this.kqH = (TextView) findViewById(R.h.cEQ);
        this.kqI = (ImageView) findViewById(R.h.cEP);
        this.kqD.setVisibility(8);
        this.kqJ = findViewById(R.h.cER);
        this.kqK = (LinearLayout) findViewById(R.h.cES);
        this.kqJ.setVisibility(8);
        this.kdb = this.kqe.ahm();
    }

    public final void update() {
        b ahj = this.kqe.ahj();
        ArrayList sA = com.tencent.mm.plugin.card.sharecard.a.b.sA(ahj.afn());
        g aho = this.kqe.aho();
        String str;
        if (aho.aii()) {
            this.kqD.setVisibility(0);
            if (com.tencent.mm.plugin.card.sharecard.a.b.sz(ahj.afn()) > 1) {
                this.kqE.setOnClickListener(this.kqe.ahn());
            } else {
                this.kqI.setVisibility(8);
                this.kqJ.setVisibility(8);
                this.kqK.removeAllViews();
                this.kqe.ahl();
            }
            b ahj2 = this.kqe.ahj();
            if (this.kqe.ahk()) {
                this.kqF.setVisibility(8);
                this.kqG.setVisibility(8);
                this.kqH.setVisibility(0);
                this.kqI.setImageResource(R.g.bdv);
                this.kqH.setText(this.kdb.getString(R.l.dRR));
            } else {
                this.kqF.setVisibility(0);
                this.kqG.setVisibility(0);
                this.kqH.setVisibility(8);
                if (com.tencent.mm.plugin.card.sharecard.a.b.sz(ahj2.afn()) <= 1) {
                    this.kqI.setVisibility(8);
                } else {
                    this.kqI.setVisibility(0);
                    this.kqI.setImageResource(R.g.bdu);
                }
                String str2 = "";
                if (sA != null && sA.size() > 0) {
                    for (int i = 0; i < sA.size(); i++) {
                        r rVar = (r) sA.get(i);
                        if (rVar.kht) {
                            str = rVar.khr;
                            break;
                        }
                    }
                }
                str = str2;
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(ahj2.afo())) {
                    str = ahj2.afo();
                }
                if (!TextUtils.isEmpty(str)) {
                    a.b.a(this.kqF, str);
                    this.kqG.setText(h.g(this.kdb, this.kdb.getString(R.l.dRV, new Object[]{l.td(str)}), this.kdb.getResources().getDimensionPixelOffset(R.f.aXI)));
                }
            }
            if (this.kqe.ahk()) {
                this.kqJ.setVisibility(0);
                r rVar2;
                ImageView imageView;
                if (this.kqK.getChildCount() != 0 || sA == null) {
                    for (int i2 = 0; i2 < this.kqK.getChildCount(); i2++) {
                        View childAt = this.kqK.getChildAt(i2);
                        rVar2 = sA.size() >= this.kqK.getChildCount() ? (r) sA.get(i2) : null;
                        ImageView imageView2 = (ImageView) childAt.findViewById(R.h.cLd);
                        imageView = (ImageView) childAt.findViewById(R.h.cLc);
                        if (rVar2 == null || !rVar2.kht) {
                            imageView2.setVisibility(8);
                            imageView.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            imageView.setVisibility(0);
                        }
                    }
                    this.kqK.invalidate();
                } else {
                    LayoutInflater layoutInflater = (LayoutInflater) this.kdb.getSystemService("layout_inflater");
                    Iterator it = sA.iterator();
                    while (it.hasNext()) {
                        rVar2 = (r) it.next();
                        View inflate = layoutInflater.inflate(R.i.dow, this.kqK, false);
                        ImageView imageView3 = (ImageView) inflate.findViewById(R.h.cLb);
                        TextView textView = (TextView) inflate.findViewById(R.h.cLg);
                        TextView textView2 = (TextView) inflate.findViewById(R.h.cEG);
                        if (!TextUtils.isEmpty(rVar2.khr)) {
                            a.b.a(imageView3, rVar2.khr);
                            CharSequence td = l.td(rVar2.khr);
                            if (TextUtils.isEmpty(td)) {
                                textView.setText("");
                            } else {
                                textView.setText(h.g(this.kdb, td, this.kdb.getResources().getDimensionPixelOffset(R.f.aXW)));
                            }
                        }
                        textView2.setText("x " + rVar2.cEG);
                        inflate.setTag(rVar2);
                        inflate.setOnClickListener(this.kqL);
                        imageView = (ImageView) inflate.findViewById(R.h.cLd);
                        imageView3 = (ImageView) inflate.findViewById(R.h.cLc);
                        if (rVar2.kht) {
                            imageView.setVisibility(0);
                            imageView3.setVisibility(0);
                        } else {
                            imageView.setVisibility(8);
                            imageView3.setVisibility(8);
                        }
                        this.kqK.addView(inflate);
                    }
                    this.kqK.invalidate();
                }
            } else {
                this.kqJ.setVisibility(8);
                this.kqK.removeAllViews();
            }
            this.kqC = true;
        } else if (!aho.aii()) {
            this.kqD.setVisibility(0);
            this.kqF.setVisibility(0);
            this.kqG.setVisibility(0);
            this.kqH.setVisibility(8);
            this.kqI.setVisibility(8);
            str = "";
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(ahj.afo())) {
                str = ahj.afo();
            }
            if (!TextUtils.isEmpty(str)) {
                a.b.a(this.kqF, str);
                this.kqG.setText(h.g(this.kdb, this.kdb.getString(R.l.dRV, new Object[]{l.td(str)}), this.kdb.getResources().getDimensionPixelOffset(R.f.aXI)));
            }
            this.kqC = true;
        }
    }

    public final void aiz() {
        this.kqD.setVisibility(8);
    }
}
