package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.co;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog kIa;

    public class a extends a {
        final /* synthetic */ c kIb;

        public a(c cVar, Context context, View view) {
            this.kIb = cVar;
            super(context, view);
        }

        protected final void akV() {
            this.kHC.setVisibility(8);
            ala();
            this.kHF.setVisibility(8);
            this.kHJ.setVisibility(8);
            this.kHK.setVisibility(8);
            this.kHB.setVisibility(0);
            this.jhl.setVisibility(0);
            this.kHH.setVisibility(0);
            this.kHG.setVisibility(0);
            this.kHI.setVisibility(0);
        }

        protected final boolean a(com.tencent.mm.plugin.emoji.model.g.a aVar, View view) {
            alc();
            return super.a(aVar, view);
        }

        protected final void b(com.tencent.mm.plugin.emoji.model.g.a aVar, View view) {
            super.b(aVar, view);
            if (com.tencent.mm.plugin.emoji.h.a.uR(alb())) {
                b coVar = new co();
                coVar.fFZ.fGa = alb();
                coVar.fFZ.status = com.tencent.mm.plugin.emoji.h.a.anw() ? 7 : 3;
                coVar.fFZ.progress = getProgress();
                coVar.fFZ.fGb = this.kHz.kJe;
                com.tencent.mm.sdk.b.a.urY.m(coVar);
            }
        }

        protected final int[] akW() {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aWC);
            return new int[]{dimensionPixelSize, dimensionPixelSize};
        }

        protected final int akX() {
            return -1;
        }

        protected final boolean ale() {
            return true;
        }

        public final void alh() {
            if (this.kHz != null) {
                switch (alc()) {
                    case 0:
                    case 3:
                        this.kHF.setVisibility(8);
                        this.kHG.setBackgroundResource(R.g.bda);
                        this.kHG.setVisibility(0);
                        this.kHI.setVisibility(0);
                        this.kHI.setText(R.l.edi);
                        this.kHI.setTextColor(this.mContext.getResources().getColorStateList(R.e.aWx));
                        this.kHJ.setVisibility(4);
                        this.kHJ.setImageResource(R.g.beJ);
                        this.kHK.setVisibility(4);
                        return;
                    case 6:
                        alf();
                        return;
                    default:
                        this.kHF.setVisibility(8);
                        this.kHG.setBackgroundResource(R.g.bdd);
                        this.kHG.setVisibility(0);
                        this.kHI.setVisibility(0);
                        this.kHI.setText(R.l.edV);
                        this.kHI.setTextColor(this.mContext.getResources().getColorStateList(R.e.aSW));
                        this.kHJ.setVisibility(4);
                        this.kHJ.setImageResource(R.g.beJ);
                        this.kHK.setVisibility(4);
                        return;
                }
            }
        }
    }

    public c(Context context) {
        super(context);
    }

    public final void notifyDataSetChanged() {
        if (this.kIP == null) {
            this.kIP = a(null);
        }
        super.notifyDataSetChanged();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f lj = lj(i);
        if (!(aVar == null || lj == null)) {
            pn pnVar = lj.kJb;
            if (pnVar != null) {
                if (com.tencent.mm.plugin.emoji.h.a.d(pnVar)) {
                    aVar.setTitle(R.l.edU);
                    aVar.lc(R.g.bfN);
                } else {
                    if (bg.mA(pnVar.tuV)) {
                        aVar.setTitle(pnVar.tgW);
                    } else {
                        aVar.setTitle(pnVar.tuV);
                    }
                    if (bg.mA(pnVar.muU)) {
                        w.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                    } else {
                        n.GW().a(pnVar.muU, aVar.akY(), com.tencent.mm.plugin.emoji.e.f.bL(pnVar.tgW, pnVar.muU));
                    }
                }
                if (i + 1 == getCount()) {
                    aVar.kHA.setBackgroundResource(R.g.bep);
                } else {
                    aVar.kHA.setBackgroundResource(R.g.beo);
                }
            }
        }
        return view;
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.kIQ);
        return aVar;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.c a(e eVar) {
        return new d(eVar);
    }

    public final void aH(String str, int i) {
        if (i == 7) {
            super.aH(str, i);
        }
    }

    public final void clear() {
        if (this.kIa != null) {
            this.kIa.cancel();
        }
        super.clear();
    }

    protected final void all() {
        super.all();
    }

    public final int alm() {
        return 0;
    }

    public final void lg(int i) {
    }

    public final int aln() {
        return 0;
    }

    public final void lh(int i) {
    }

    public final int alo() {
        return 0;
    }

    public final void li(int i) {
    }
}
