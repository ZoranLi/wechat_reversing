package com.tencent.mm.plugin.sns.ui.a;

import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class g extends a {
    private int mScreenHeight;
    private int mScreenWidth;
    private e qNg = new e(this) {
        final /* synthetic */ g qNh;

        {
            this.qNh = r1;
        }

        public final void a(b bVar, int i) {
        }
    };

    public final void d(c cVar) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.qb.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (cVar.qLZ != null) {
            cVar.qLZ.setLayoutResource(com.tencent.mm.plugin.sns.i.g.pFd);
            cVar.qMO = (ViewStub) cVar.mil.findViewById(f.pCK);
            if (!cVar.qMP) {
                cVar.qMQ.qxC = cVar.qMO.inflate();
                cVar.qMP = true;
            }
        } else {
            cVar.qMQ.qxC = cVar.mil.findViewById(f.pFd);
            cVar.qMP = true;
        }
        cVar.qMQ.qxD = cVar.qMQ.qxC.findViewById(f.bAe);
        cVar.qMQ.pwp = (a) cVar.qMQ.qxC.findViewById(f.Kd);
        cVar.qMQ.qxD.setOnClickListener(this.pZQ.pZk.qNM);
        cVar.qMQ.qjB = (ImageView) cVar.qMQ.qxC.findViewById(f.cGq);
        cVar.qMQ.qxE = (MMPinProgressBtn) cVar.qMQ.qxC.findViewById(f.progress);
        cVar.qMQ.qxF = (TextView) cVar.qMQ.qxC.findViewById(f.pCu);
        cVar.qMQ.qjE = (TextView) cVar.qMQ.qxC.findViewById(f.pCv);
        h.vJ();
        if (((Boolean) h.vI().vr().get(344065, Boolean.valueOf(false))).booleanValue()) {
            cVar.qMQ.pwp.h((TextView) ((ViewStub) cVar.qMQ.qxC.findViewById(f.pDP)).inflate());
        }
    }

    public final void a(c cVar, int i, ax axVar, bfc com_tencent_mm_protocal_c_bfc, int i2, au auVar) {
        alh com_tencent_mm_protocal_c_alh;
        if (com_tencent_mm_protocal_c_bfc.ufB == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() <= 0) {
            com_tencent_mm_protocal_c_alh = null;
        } else {
            com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
        }
        w.v("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[]{Integer.valueOf(i)});
        m Gf = ae.beL().Gf(cVar.fVJ);
        if (!axVar.qpL || com_tencent_mm_protocal_c_alh == null) {
            cVar.qMQ.qxF.setVisibility(8);
            cVar.qMQ.pwp.bbX();
            cVar.qMQ.pwp.a(null);
            cVar.qMQ.pwp.a(null);
        } else {
            final long j = axVar.qIn;
            final au auVar2 = auVar;
            cVar.qMQ.pwp.a(new e(this) {
                final /* synthetic */ g qNh;

                public final void a(b bVar, int i) {
                    if (i != -1 && auVar2 != null && auVar2.qHw != null && auVar2.qHw.qpY != null) {
                        auVar2.qHw.qpY.da(j);
                    }
                }
            });
            if (!auVar.qHw.qpY.db(j)) {
                final au auVar3 = auVar;
                final c cVar2 = cVar;
                cVar.qMQ.pwp.a(new b.f(this) {
                    final /* synthetic */ g qNh;

                    public final void a(b bVar, long j) {
                        if (auVar3 != null && auVar3.qHw != null && auVar3.qHw.qpY != null) {
                            int bce = (int) bVar.bce();
                            auVar3.qHw.qpY.q(j, bg.NA());
                            auVar3.qHw.qpY.u(j, bce);
                            auVar3.qHw.qpY.p(j, j);
                            cVar2.qMQ.pwp.a(null);
                        }
                    }
                });
            }
        }
        cVar.qMQ.a(com_tencent_mm_protocal_c_bfc, i, axVar.qtl, axVar.qpL);
        cVar.qMQ.qjE.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g beI = ae.beI();
        Object obj;
        if (com_tencent_mm_protocal_c_bfc.ufB == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() <= 0) {
            obj = cVar.qMQ.pwp;
            beI.a(obj, "", -1, this.qb.hashCode());
            obj.y(null);
            obj.ak(null, false);
        } else {
            int fromDPToPix;
            Pair create;
            int intValue;
            LayoutParams layoutParams;
            a aVar;
            int hashCode;
            an bLR;
            boolean z;
            long nanoTime = System.nanoTime() - System.nanoTime();
            w.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_alh)), Long.valueOf(nanoTime)});
            if (com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_alh)) {
                if (beI.u(com_tencent_mm_protocal_c_alh)) {
                    cVar.qMQ.qjB.setVisibility(0);
                    cVar.qMQ.qxE.setVisibility(8);
                    cVar.qMQ.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this.qb, i.dzz));
                    cVar.qMQ.qjB.setContentDescription(this.qb.getString(j.pJU));
                } else if (beI.v(com_tencent_mm_protocal_c_alh)) {
                    cVar.qMQ.qjB.setVisibility(8);
                    cVar.qMQ.qxE.setVisibility(8);
                } else if (!axVar.qpL || beI.b(Gf, null) > 5) {
                    beI.x(com_tencent_mm_protocal_c_alh);
                    cVar.qMQ.qjB.setVisibility(0);
                    cVar.qMQ.qxE.setVisibility(8);
                    cVar.qMQ.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this.qb, i.dzz));
                    cVar.qMQ.qjB.setContentDescription(this.qb.getString(j.pJU));
                } else {
                    cVar.qMQ.qjB.setVisibility(8);
                    cVar.qMQ.qxE.setVisibility(8);
                }
                if (cVar.qMQ.pwp.bbV()) {
                    w.d("MicroMsg.VideoTimeLineItem", "play video error " + com_tencent_mm_protocal_c_alh.mQY + " " + com_tencent_mm_protocal_c_alh.msN + " " + com_tencent_mm_protocal_c_alh.tPi + " " + i);
                    beI.x(com_tencent_mm_protocal_c_alh);
                    cVar.qMQ.qjB.setVisibility(0);
                    cVar.qMQ.qxE.setVisibility(8);
                    cVar.qMQ.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this.qb, i.dzz));
                    cVar.qMQ.qjB.setContentDescription(this.qb.getString(j.pJU));
                }
            } else if (beI.w(com_tencent_mm_protocal_c_alh)) {
                cVar.qMQ.qjB.setVisibility(8);
                cVar.qMQ.qxE.setVisibility(0);
                cVar.qMQ.qxE.caB();
            } else if (axVar.qpL && beI.b(Gf, null) == 5) {
                beI.z(com_tencent_mm_protocal_c_alh);
                cVar.qMQ.qjB.setVisibility(8);
                cVar.qMQ.qxE.setVisibility(0);
                cVar.qMQ.qxE.caB();
            } else {
                obj = (beI.pSY.containsKey(com_tencent_mm_protocal_c_alh.mQY) && ((Integer) beI.pSY.get(com_tencent_mm_protocal_c_alh.mQY)).intValue() == 4) ? 1 : null;
                if (obj != null) {
                    cVar.qMQ.qxE.setVisibility(8);
                    cVar.qMQ.qjB.setImageResource(com.tencent.mm.plugin.sns.i.e.bjR);
                    cVar.qMQ.qjB.setVisibility(0);
                } else {
                    beI.x(com_tencent_mm_protocal_c_alh);
                    cVar.qMQ.qjB.setVisibility(0);
                    cVar.qMQ.qxE.setVisibility(8);
                    cVar.qMQ.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this.qb, i.dzz));
                    cVar.qMQ.qjB.setContentDescription(this.qb.getString(j.pJU));
                    if (!axVar.qpL && beI.a(Gf, null) == 4) {
                        cVar.qMQ.qjE.setVisibility(0);
                    } else if (axVar.qpL && beI.b(Gf, null) == 4) {
                        cVar.qMQ.qjE.setVisibility(0);
                    }
                }
            }
            Pair a = com.tencent.mm.modelsns.e.a(cVar.qMR, cVar.qMQ.pwp.bbU(), axVar.qpL);
            if (axVar.qpL) {
                com.tencent.mm.plugin.sns.storage.b bha = axVar.pyJ.bha();
                int width = ((WindowManager) this.qb.getSystemService("window")).getDefaultDisplay().getWidth();
                if (bha != null && bha.qeJ == 1 && cVar.qMP) {
                    fromDPToPix = (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 28);
                    create = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * com_tencent_mm_protocal_c_alh.tPl.tPZ) / com_tencent_mm_protocal_c_alh.tPl.tPY)));
                    intValue = ((Integer) create.first).intValue();
                    fromDPToPix = ((Integer) create.second).intValue();
                    cVar.qMQ.pwp.cR(intValue, fromDPToPix);
                    layoutParams = cVar.qMQ.qxF.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = fromDPToPix;
                    cVar.qMQ.qxF.setLayoutParams(layoutParams);
                    cVar.qMQ.pwp.bi(cVar.qMQ);
                    aVar = cVar.qMQ.pwp;
                    hashCode = this.qb.hashCode();
                    bLR = an.bLR();
                    bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                    beI.a(Gf, com_tencent_mm_protocal_c_alh, aVar, hashCode, i, bLR, axVar.qpL);
                    cVar.qMQ.qxD.setTag(cVar.qMQ);
                    cVar.qNc.setTag(cVar.qMQ);
                    cVar.qNd.setTag(cVar.qMQ);
                    if (FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_alh))) {
                        auVar.qHw.qpY.e(axVar.qIn, 0, false);
                    } else {
                        auVar.qHw.qpY.e(axVar.qIn, 0, true);
                    }
                    if (axVar.qpL) {
                        if (ae.beI().a(Gf, null) == 5) {
                        }
                    }
                    auVar.qHw.qpY.l(axVar.qIn, z);
                } else if (bha != null && bha.qez > 0.0f && bha.qeA > 0.0f) {
                    float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qez, 1, bha.qeB, bha.qeC);
                    float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeA, 1, bha.qeB, bha.qeC);
                    if (bha.qey == 0) {
                        if (a2 >= ((float) (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)))) {
                            a2 = (float) (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12));
                            a3 = (float) ((int) ((bha.qeA * a2) / bha.qez));
                        }
                        create = Pair.create(Integer.valueOf((int) a2), Integer.valueOf((int) a3));
                    } else if (bha.qey == 1) {
                        r4 = (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12);
                        r3 = Pair.create(Integer.valueOf(r4), Integer.valueOf((int) ((((float) r4) * bha.qeA) / bha.qez)));
                        cVar.qLU.setLayoutParams(new LinearLayout.LayoutParams(r4, -2));
                        create = r3;
                    } else if (bha.qey == 2) {
                        r4 = ((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12);
                        r3 = Pair.create(Integer.valueOf(r4), Integer.valueOf((int) ((((float) r4) * bha.qeA) / bha.qez)));
                        cVar.qLU.setLayoutParams(new LinearLayout.LayoutParams(r4, -2));
                        create = r3;
                    }
                    intValue = ((Integer) create.first).intValue();
                    fromDPToPix = ((Integer) create.second).intValue();
                    cVar.qMQ.pwp.cR(intValue, fromDPToPix);
                    layoutParams = cVar.qMQ.qxF.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = fromDPToPix;
                    cVar.qMQ.qxF.setLayoutParams(layoutParams);
                    cVar.qMQ.pwp.bi(cVar.qMQ);
                    aVar = cVar.qMQ.pwp;
                    hashCode = this.qb.hashCode();
                    bLR = an.bLR();
                    bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                    beI.a(Gf, com_tencent_mm_protocal_c_alh, aVar, hashCode, i, bLR, axVar.qpL);
                    cVar.qMQ.qxD.setTag(cVar.qMQ);
                    cVar.qNc.setTag(cVar.qMQ);
                    cVar.qNd.setTag(cVar.qMQ);
                    if (FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_alh))) {
                        auVar.qHw.qpY.e(axVar.qIn, 0, true);
                    } else {
                        auVar.qHw.qpY.e(axVar.qIn, 0, false);
                    }
                    z = axVar.qpL ? ae.beI().b(Gf, null) == 5 : ae.beI().a(Gf, null) == 5;
                    auVar.qHw.qpY.l(axVar.qIn, z);
                }
            }
            create = a;
            intValue = ((Integer) create.first).intValue();
            fromDPToPix = ((Integer) create.second).intValue();
            cVar.qMQ.pwp.cR(intValue, fromDPToPix);
            layoutParams = cVar.qMQ.qxF.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = fromDPToPix;
            cVar.qMQ.qxF.setLayoutParams(layoutParams);
            cVar.qMQ.pwp.bi(cVar.qMQ);
            aVar = cVar.qMQ.pwp;
            hashCode = this.qb.hashCode();
            bLR = an.bLR();
            bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
            beI.a(Gf, com_tencent_mm_protocal_c_alh, aVar, hashCode, i, bLR, axVar.qpL);
            cVar.qMQ.qxD.setTag(cVar.qMQ);
            cVar.qNc.setTag(cVar.qMQ);
            cVar.qNd.setTag(cVar.qMQ);
            if (FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_alh))) {
                auVar.qHw.qpY.e(axVar.qIn, 0, true);
            } else {
                auVar.qHw.qpY.e(axVar.qIn, 0, false);
            }
            if (axVar.qpL) {
                if (ae.beI().b(Gf, null) == 5) {
                }
            }
            auVar.qHw.qpY.l(axVar.qIn, z);
        }
        if (Gf == null || Gf.bfJ()) {
            auVar.kaU.c(cVar.qMQ.qxD, auVar.pZk.qNG, auVar.pZk.qNp);
        } else {
            auVar.kaU.c(cVar.qMQ.qxD, auVar.pZk.qNF, auVar.pZk.qNp);
        }
    }
}
