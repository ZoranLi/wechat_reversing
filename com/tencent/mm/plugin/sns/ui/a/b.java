package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    private int qzU = 103;

    public final void d(c cVar) {
        cVar.qMk.setImageResource(e.pzL);
        cVar.qLR.setTextColor(-2730427);
        if (cVar.qLZ != null) {
            cVar.qLZ.setLayoutResource(g.pHB);
            if (!cVar.qMa) {
                cVar.qMr = (PhotosContent) cVar.qLZ.inflate();
                cVar.qMa = true;
            }
        } else {
            cVar.qMr = (PhotosContent) cVar.mil.findViewById(f.pCG);
            cVar.qMa = true;
        }
        w.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.knu);
        TagImageView tagImageView = (TagImageView) cVar.qMr.findViewById(aq.qDQ[0]);
        cVar.qMr.a(tagImageView);
        tagImageView.setOnClickListener(this.pZQ.pZk.que);
    }

    public final void a(c cVar, int i, ax axVar, bfc com_tencent_mm_protocal_c_bfc, int i2, au auVar) {
        String str = axVar.qtl;
        if (cVar.qMY != null) {
            if (!axVar.qID || cVar.pOp.ucB == null || cVar.pOp.ucB.udd <= 0) {
                cVar.qMY.setBackgroundResource(e.pzB);
            } else {
                cVar.qMY.setBackgroundResource(e.pzC);
            }
        }
        TagImageView tR = cVar.qMr.tR(0);
        List arrayList = new ArrayList();
        arrayList.add(tR);
        ao aoVar = new ao();
        aoVar.fJz = str;
        aoVar.index = 0;
        aoVar.qBO = arrayList;
        aoVar.qze = this.qze;
        if (tR != null) {
            tR.setTag(aoVar);
        }
        ali com_tencent_mm_protocal_c_ali = axVar.qJd;
        cVar.qnv = com_tencent_mm_protocal_c_ali;
        if (com_tencent_mm_protocal_c_ali == null) {
            w.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + axVar.qtl);
        } else if (m.xL().equals(com_tencent_mm_protocal_c_bfc.jNj)) {
            cVar.qMr.setVisibility(0);
            r1 = auVar.qzJ;
            r2 = cVar.qMr;
            r4 = axVar.qtl;
            r5 = this.qb.hashCode();
            r8 = this.qze;
            r9 = an.bLR();
            r9.cIm = com_tencent_mm_protocal_c_bfc.ogM;
            r1.a(r2, com_tencent_mm_protocal_c_bfc, r4, r5, i2, i, r8, r9, true);
        } else if (axVar.qIG) {
            cVar.qMr.setVisibility(0);
            r1 = auVar.qzJ;
            r2 = cVar.qMr;
            r4 = axVar.qtl;
            r5 = this.qb.hashCode();
            r8 = this.qze;
            r9 = an.bLR();
            r9.cIm = com_tencent_mm_protocal_c_bfc.ogM;
            r1.a(r2, com_tencent_mm_protocal_c_bfc, r4, r5, i2, i, r8, r9, false);
        } else if (com_tencent_mm_protocal_c_ali.fZG == 0) {
            cVar.qMr.setVisibility(0);
            r1 = auVar.qzJ;
            r2 = cVar.qMr;
            r4 = axVar.qtl;
            r5 = this.qb.hashCode();
            r8 = this.qze;
            r9 = an.bLR();
            r9.cIm = com_tencent_mm_protocal_c_bfc.ogM;
            r1.a(r2, com_tencent_mm_protocal_c_bfc, r4, r5, i2, i, r8, r9, true);
        } else {
            w.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + com_tencent_mm_protocal_c_ali.fZG);
        }
    }
}
