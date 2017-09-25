package com.tencent.mm.plugin.sns.ui.a;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.am.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.an;

public final class c extends a {
    public final void d(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar.qLZ != null) {
            cVar.qLZ.setLayoutResource(g.pHL);
            cVar.qMJ = (ViewStub) cVar.mil.findViewById(f.pCK);
            if (!(cVar.qMK || cVar.qMJ == null)) {
                cVar.qML = cVar.qMJ.inflate();
                cVar.qMK = true;
            }
        } else {
            cVar.qML = cVar.mil.findViewById(f.pDm);
            cVar.qMK = true;
        }
        cVar.qFp = cVar.qML;
        cVar.qFp.findViewById(f.state).setOnTouchListener(this.pZQ.qtw);
        cVar.qMc = (TagImageView) cVar.qFp.findViewById(f.pCJ);
        cVar.qpP = (ImageView) cVar.qFp.findViewById(f.state);
        cVar.qMd = (TextView) cVar.qFp.findViewById(f.pDD);
        cVar.ioX = (TextView) cVar.qFp.findViewById(f.pGi);
        cVar.ioX.setTextColor(this.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
        cVar.ioX.setMaxLines(1);
        i.b(cVar.qMc, this.qb);
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, int i, ax axVar, bfc com_tencent_mm_protocal_c_bfc, int i2, au auVar) {
        String str = axVar.qtl;
        if (com_tencent_mm_protocal_c_bfc.ufB.tsO.isEmpty()) {
            cVar.qFp.setVisibility(8);
            return;
        }
        Object obj;
        CharSequence charSequence;
        cVar.qMc.position = i;
        cVar.qFp.setVisibility(0);
        alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
        com.tencent.mm.plugin.sns.model.g beI = ae.beI();
        View view = cVar.qMc;
        int i3 = com.tencent.mm.plugin.sns.i.i.dtg;
        int hashCode = this.qb.hashCode();
        an bLR = an.bLR();
        bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
        beI.b(com_tencent_mm_protocal_c_alh, view, i3, hashCode, bLR);
        cVar.qpP.setPressed(false);
        String str2 = com_tencent_mm_protocal_c_bfc.mQY;
        if (b.HJ()) {
            anf HL = b.HL();
            if (HL != null && b.d(HL) && str2.equals(HL.tqY)) {
                obj = 1;
                if (obj == null) {
                    cVar.qpP.setImageResource(e.bho);
                } else {
                    cVar.qpP.setImageResource(e.bhp);
                }
                cVar.qMc.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                cVar.qMc.setOnClickListener(auVar.qzR.qKO);
                cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                auVar.kaU.c(cVar.qFp, auVar.pZk.qNE, auVar.pZk.qNp);
                cVar.qFp.setOnClickListener(auVar.qzR.qFc);
                charSequence = com_tencent_mm_protocal_c_alh.msk;
                if (bg.mA(charSequence)) {
                    cVar.qMd.setVisibility(0);
                    cVar.qMd.setText(charSequence);
                } else {
                    cVar.qMd.setVisibility(4);
                }
                charSequence = com_tencent_mm_protocal_c_alh.fDC;
                if (bg.mA(charSequence)) {
                    cVar.ioX.setVisibility(0);
                    cVar.ioX.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                }
                cVar.ioX.setVisibility(8);
                return;
            }
        }
        obj = null;
        if (obj == null) {
            cVar.qpP.setImageResource(e.bhp);
        } else {
            cVar.qpP.setImageResource(e.bho);
        }
        cVar.qMc.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
        cVar.qMc.setOnClickListener(auVar.qzR.qKO);
        cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
        auVar.kaU.c(cVar.qFp, auVar.pZk.qNE, auVar.pZk.qNp);
        cVar.qFp.setOnClickListener(auVar.qzR.qFc);
        charSequence = com_tencent_mm_protocal_c_alh.msk;
        if (bg.mA(charSequence)) {
            cVar.qMd.setVisibility(4);
        } else {
            cVar.qMd.setVisibility(0);
            cVar.qMd.setText(charSequence);
        }
        charSequence = com_tencent_mm_protocal_c_alh.fDC;
        if (bg.mA(charSequence)) {
            cVar.ioX.setVisibility(8);
            return;
        }
        cVar.ioX.setVisibility(0);
        cVar.ioX.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
    }
}
