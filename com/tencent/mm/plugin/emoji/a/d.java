package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.pn;

public final class d extends com.tencent.mm.plugin.emoji.a.a.a {

    public class a extends a {
        final /* synthetic */ d kIc;

        public a(d dVar, Context context, View view) {
            this.kIc = dVar;
            super(context, view);
        }

        protected final void akV() {
            this.kHC.setVisibility(8);
            this.kHE.setVisibility(8);
            this.kHD.setVisibility(0);
            this.kHF.setVisibility(8);
            this.kHJ.setVisibility(8);
            this.kHK.setVisibility(8);
            this.kHB.setVisibility(0);
            this.jhl.setVisibility(0);
            this.kHH.setVisibility(0);
            this.kHG.setVisibility(0);
            this.kHG.setBackgroundDrawable(null);
            this.kHI.setVisibility(0);
        }

        protected final int[] akW() {
            int T = com.tencent.mm.bg.a.T(this.mContext, R.f.aZI);
            return new int[]{T, T};
        }

        protected final int akX() {
            return com.tencent.mm.bg.a.T(this.mContext, R.f.aZJ);
        }

        protected final boolean ale() {
            return true;
        }
    }

    public d(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.kIQ);
        return aVar;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f lj = lj(i);
        if (!(aVar == null || lj == null)) {
            lj.kJf = false;
            lj.kJg = false;
            pn pnVar = lj.kJb;
            if (pnVar != null) {
                aVar.setTitle(pnVar.tuV);
                n.GW().a(pnVar.muU, aVar.akY(), com.tencent.mm.plugin.emoji.e.f.bL(pnVar.tgW, pnVar.muU));
                aVar.tR(o.aa("yyyy-MM-dd", ((long) pnVar.tvD) * 1000));
            }
        }
        return view;
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
