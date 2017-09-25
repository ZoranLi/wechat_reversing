package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.an;

public final class d extends a {
    public final void d(c cVar) {
        if (cVar.qLZ == null || cVar.qLZ.getParent() == null) {
            cVar.qML = cVar.mil.findViewById(f.pDm);
            cVar.qMK = true;
        } else {
            cVar.qLZ.setLayoutResource(g.pHL);
            if (!cVar.qMK) {
                cVar.qML = cVar.qLZ.inflate();
                cVar.qMK = true;
            }
        }
        cVar.qFp = cVar.qML;
        cVar.qMc = (TagImageView) cVar.qFp.findViewById(f.pCJ);
        cVar.qpP = (ImageView) cVar.qFp.findViewById(f.state);
        cVar.qMd = (TextView) cVar.qFp.findViewById(f.pDD);
        cVar.ioX = (TextView) cVar.qFp.findViewById(f.pGi);
        cVar.ioX.setTextColor(this.qb.getResources().getColor(i.c.black));
        com.tencent.mm.plugin.sns.data.i.b(cVar.qMc, this.qb);
    }

    public final void a(c cVar, int i, ax axVar, bfc com_tencent_mm_protocal_c_bfc, int i2, au auVar) {
        Object obj;
        Object obj2;
        String Hd;
        cVar.qMc.position = i;
        String str = axVar.qtl;
        m mVar = axVar.pyJ;
        Object obj3 = null;
        if (axVar.qpL) {
            if (mVar.bha().qeJ == 2) {
                obj3 = 1;
                cVar.qFp.setTag(cVar);
                cVar.qFp.setOnClickListener(auVar.pZk.qNW);
            }
            obj = null;
            obj2 = obj3;
        } else {
            if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 9) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKI);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 10) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKK);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 17) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKL);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 22) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKM);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 23) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKN);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 14) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKJ);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 12) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKR);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 13) {
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                    cVar.qFp.setOnClickListener(auVar.qzR.qKS);
                    obj = null;
                    obj2 = null;
                } else {
                    cVar.qFp.setOnClickListener(null);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN != 15) {
                cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                cVar.qFp.setOnClickListener(auVar.qzR.qFc);
                if ((com_tencent_mm_protocal_c_bfc.hhv & 1) > 0) {
                    int i3 = 1;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                cVar.qFp.setTag(new q(com_tencent_mm_protocal_c_bfc, str));
                cVar.qFp.setOnClickListener(auVar.pZk.qNN);
                obj = null;
                obj2 = null;
            }
            obj = null;
            obj2 = null;
        }
        if (obj2 != null) {
            auVar.kaU.c(cVar.qFp, auVar.pZk.qNH, auVar.pZk.qNp);
        } else {
            auVar.kaU.c(cVar.qFp, auVar.pZk.qNE, auVar.pZk.qNp);
        }
        obj3 = com_tencent_mm_protocal_c_bfc.ufB.tsN == 9 ? 1 : (a.bfk() & 1) <= 0 ? 1 : null;
        if (obj3 != null) {
            Hd = au.Hd(com_tencent_mm_protocal_c_bfc.ufB.msN);
        } else {
            Hd = "";
        }
        if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 9 || com_tencent_mm_protocal_c_bfc.ufB.tsN == 14 || com_tencent_mm_protocal_c_bfc.ufB.tsN == 12 || com_tencent_mm_protocal_c_bfc.ufB.tsN == 13 || obj2 != null) {
            CharSequence charSequence = com_tencent_mm_protocal_c_bfc.ufB.msk;
        } else {
            Object obj4 = Hd;
        }
        Hd = com_tencent_mm_protocal_c_bfc.ufB.fDC;
        if (Hd == null || Hd.length() <= 40) {
            Object obj5 = Hd;
        } else {
            CharSequence charSequence2 = Hd.substring(0, 40) + "...";
        }
        cVar.qpP.setVisibility(8);
        if (!com_tencent_mm_protocal_c_bfc.ufB.tsO.isEmpty()) {
            cVar.qMc.setVisibility(0);
            alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
            com.tencent.mm.plugin.sns.model.g beI;
            View view;
            int i4;
            int hashCode;
            an bLR;
            if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 15) {
                cVar.qpP.setImageResource(e.bhp);
                cVar.qpP.setVisibility(0);
                beI = ae.beI();
                view = cVar.qMc;
                i4 = i.i.dtr;
                hashCode = this.qb.hashCode();
                bLR = an.bLR();
                bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                beI.b(com_tencent_mm_protocal_c_alh, view, i4, hashCode, bLR);
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 5) {
                charSequence2 = com_tencent_mm_protocal_c_alh.fDC;
                cVar.qpP.setImageResource(e.bkX);
                cVar.qpP.setVisibility(0);
                beI = ae.beI();
                view = cVar.qMc;
                i4 = i.i.dtr;
                hashCode = this.qb.hashCode();
                bLR = an.bLR();
                bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                beI.b(com_tencent_mm_protocal_c_alh, view, i4, hashCode, bLR);
            } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 18) {
                cVar.qpP.setVisibility(0);
                cVar.qpP.setImageResource(e.bkX);
                cVar.qMc.setVisibility(0);
                beI = ae.beI();
                view = cVar.qMc;
                i4 = i.i.dtr;
                hashCode = this.qb.hashCode();
                bLR = an.bLR();
                bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                beI.b(com_tencent_mm_protocal_c_alh, view, i4, hashCode, bLR);
            } else {
                beI = ae.beI();
                view = cVar.qMc;
                i4 = this.qb.hashCode();
                an bLR2 = an.bLR();
                bLR2.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                beI.b(com_tencent_mm_protocal_c_alh, view, i4, bLR2);
            }
        } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 18) {
            cVar.qpP.setVisibility(0);
            cVar.qpP.setImageResource(e.bkX);
            cVar.qMc.setVisibility(0);
            ae.beI().a(cVar.qMc, -1, i.i.dtr, this.qb.hashCode());
        } else {
            cVar.qMc.setVisibility(0);
            ae.beI().a(cVar.qMc, -1, i.i.dtu, this.qb.hashCode());
        }
        if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 15) {
            charSequence = "";
            charSequence2 = this.qb.getString(j.pKY);
        }
        if (bg.mA(charSequence)) {
            cVar.qMd.setVisibility(8);
        } else {
            cVar.qMd.setVisibility(0);
            cVar.qMd.setText(charSequence);
        }
        if (!bg.mA(charSequence2)) {
            if (cVar.qMd.getVisibility() == 8) {
                if (cVar.qMe != 2) {
                    cVar.ioX.setMaxLines(2);
                }
                cVar.qMe = 2;
            } else {
                if (cVar.qMe != 1) {
                    cVar.ioX.setMaxLines(1);
                }
                cVar.qMe = 1;
            }
            cVar.ioX.setVisibility(0);
            if (obj != null) {
                cVar.ioX.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence2, this.qb, cVar.ioX));
            } else {
                cVar.ioX.setText(charSequence2);
            }
        } else if (i2 == 1) {
            cVar.ioX.setText(au.Hd(com_tencent_mm_protocal_c_bfc.ufB.msN));
            cVar.ioX.setVisibility(0);
        } else {
            cVar.ioX.setVisibility(8);
        }
    }
}
