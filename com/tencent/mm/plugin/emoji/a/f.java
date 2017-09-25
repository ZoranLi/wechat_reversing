package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.bg;

public class f extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean kIj = false;
    public boolean kIk = true;
    public boolean kIl = false;
    public boolean kIm = true;

    public class a extends a {
        final /* synthetic */ f kIn;

        public a(f fVar, Context context, View view) {
            this.kIn = fVar;
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

        protected final int[] akW() {
            int T = com.tencent.mm.bg.a.T(this.mContext, R.f.aZG);
            return new int[]{T, T};
        }

        protected final int akX() {
            return com.tencent.mm.bg.a.T(this.mContext, R.f.aZF);
        }

        protected final boolean ale() {
            return this.kIn.kIk;
        }
    }

    public f(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.kIQ);
        return aVar;
    }

    public final void clear() {
        super.clear();
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        a aVar = (a) view.getTag();
        com.tencent.mm.plugin.emoji.a.a.f lj = lj(i);
        if (this.kIl) {
            lj.kJh = true;
            lj.kJf = false;
            lj.kJg = false;
        }
        if (!(aVar == null || lj == null)) {
            lj.kJg = this.kIm;
            pe peVar = lj.kJc;
            if (peVar == null) {
                aVar.lf(0);
                z = false;
            } else {
                aVar.setTitle(peVar.fDC);
                aVar.tS(peVar.msk);
                if (!bg.mA(peVar.muU)) {
                    n.GW().a(peVar.muU, aVar.akY(), com.tencent.mm.plugin.emoji.e.f.bL("", peVar.muU));
                }
                if (bg.mA(peVar.tuP)) {
                    aVar.ld(8);
                } else {
                    n.GW().a(peVar.tuP, aVar.akZ(), com.tencent.mm.plugin.emoji.e.f.bL("", peVar.tuP));
                    aVar.ld(0);
                }
                aVar.lf(8);
            }
            if (!z) {
                pn pnVar = lj.kJb;
                if (pnVar != null) {
                    aVar.setTitle(pnVar.tuV);
                    if (com.tencent.mm.plugin.emoji.h.a.d(pnVar)) {
                        n.GW().a("", aVar.akY());
                        aVar.lc(R.g.bfN);
                    } else {
                        n.GW().a(pnVar.muU, aVar.akY(), com.tencent.mm.plugin.emoji.e.f.bL(pnVar.tgW, pnVar.muU));
                    }
                    boolean bO = e.bO(pnVar.tuZ, 2);
                    if (!TextUtils.isEmpty(pnVar.tvG)) {
                        aVar.akZ().setImageDrawable(null);
                        aVar.akZ().setVisibility(0);
                        n.GW().a(pnVar.tvG, aVar.akZ(), com.tencent.mm.plugin.emoji.e.f.bL("", pnVar.tvG));
                    } else if (bO) {
                        aVar.ld(0);
                        aVar.le(R.g.beW);
                    } else {
                        aVar.ld(8);
                    }
                    aVar.tS(pnVar.tvF);
                    if (this.kIj && aVar.kHA != null) {
                        aVar.kHA.setBackgroundResource(R.g.bep);
                    }
                }
            }
        }
        return view;
    }

    public int alm() {
        return 0;
    }

    public void lg(int i) {
    }

    public int aln() {
        return 0;
    }

    public void lh(int i) {
    }

    public int alo() {
        return 0;
    }

    public void li(int i) {
    }
}
