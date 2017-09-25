package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import java.util.LinkedList;
import java.util.List;

public final class e extends a {
    public MaskImageView qNe;
    private int qzT;
    private int qzU = 103;

    public static class a extends c {
    }

    public final void d(c cVar) {
        this.qb.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        w.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.knu);
        this.qzT = ae.beS();
        if (cVar.qLZ != null) {
            if (this.knu == 2) {
                cVar.qLZ.setLayoutResource(g.pIp);
            } else if (this.knu == 3) {
                cVar.qLZ.setLayoutResource(g.pIm);
            } else if (this.knu == 4) {
                cVar.qLZ.setLayoutResource(g.pIn);
            } else if (this.knu == 5) {
                cVar.qLZ.setLayoutResource(g.pIo);
            } else {
                w.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.knu);
            }
            if (!cVar.qMa) {
                cVar.qMr = (PhotosContent) cVar.qLZ.inflate();
                cVar.qMa = true;
            }
        } else {
            cVar.qMr = (PhotosContent) cVar.mil.findViewById(f.pDr);
            cVar.qMa = true;
        }
        cVar.qMr.qwg.clear();
        for (int i = 0; i < aq.qDM[this.knu]; i++) {
            TagImageView tagImageView = (TagImageView) cVar.qMr.findViewById(aq.qDQ[i]);
            cVar.qMr.a(tagImageView);
            tagImageView.setOnClickListener(this.pZQ.pZk.que);
            this.pZQ.kaU.c(tagImageView, this.pZQ.pZk.qND, this.pZQ.pZk.qNp);
        }
        cVar.qMr.tQ(this.qzT);
    }

    @TargetApi(16)
    public final void a(c cVar, int i, ax axVar, bfc com_tencent_mm_protocal_c_bfc, int i2, au auVar) {
        cVar.qMr.setVisibility(0);
        String str = com_tencent_mm_protocal_c_bfc.ufA == null ? null : com_tencent_mm_protocal_c_bfc.ufA.mQY;
        if (!bg.mA(str)) {
            boolean booleanValue;
            if (auVar.qHI.containsKey(str)) {
                booleanValue = ((Boolean) auVar.qHI.get(str)).booleanValue();
            } else {
                auVar.qHI.put(str, Boolean.valueOf(com.tencent.mm.plugin.sns.c.a.imw.bo(str)));
                booleanValue = true;
            }
            if (booleanValue) {
                com.tencent.mm.plugin.sns.c.a.imw.a(this.qb, str, com_tencent_mm_protocal_c_bfc.jNj, com_tencent_mm_protocal_c_bfc.ufF, axVar.qIn);
            }
        }
        List linkedList = new LinkedList();
        int width = ((WindowManager) this.qb.getSystemService("window")).getDefaultDisplay().getWidth();
        if (axVar.qpL && i2 == 2) {
            final b bha = axVar.pyJ.bha();
            if (bha != null && bha.qeJ == 1 && cVar.qMr.tR(0) != null) {
                alh com_tencent_mm_protocal_c_alh;
                if (com_tencent_mm_protocal_c_bfc.ufB == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() <= 0) {
                    com_tencent_mm_protocal_c_alh = null;
                } else {
                    com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
                }
                width = (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 28);
                int i3 = (int) ((com_tencent_mm_protocal_c_alh.tPl.tPZ * ((float) width)) / com_tencent_mm_protocal_c_alh.tPl.tPY);
                alj com_tencent_mm_protocal_c_alj = new alj();
                com_tencent_mm_protocal_c_alj.tPY = (float) width;
                com_tencent_mm_protocal_c_alj.tPZ = (float) i3;
                com_tencent_mm_protocal_c_alj.tQa = com_tencent_mm_protocal_c_alj.tPY * com_tencent_mm_protocal_c_alj.tPZ;
                linkedList.add(com_tencent_mm_protocal_c_alj);
                for (int i4 = 0; i4 < aq.qDM[i2]; i4++) {
                    auVar.kaU.c((TagImageView) cVar.qMr.findViewById(aq.qDQ[i4]), auVar.pZk.qNG, auVar.pZk.qNp);
                }
            } else if (bha != null && bha.qez > 0.0f && bha.qeA > 0.0f) {
                float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qez, 1, bha.qeB, bha.qeC);
                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeA, 1, bha.qeB, bha.qeC);
                if (bha.qey == 0) {
                    alj com_tencent_mm_protocal_c_alj2 = new alj();
                    com_tencent_mm_protocal_c_alj2.tPY = a;
                    com_tencent_mm_protocal_c_alj2.tPZ = a2;
                    if (a >= ((float) (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)))) {
                        com_tencent_mm_protocal_c_alj2.tPY = (float) (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12));
                        com_tencent_mm_protocal_c_alj2.tPZ = (float) ((int) ((com_tencent_mm_protocal_c_alj2.tPY * bha.qeA) / bha.qez));
                    }
                    com_tencent_mm_protocal_c_alj2.tQa = com_tencent_mm_protocal_c_alj2.tPY * com_tencent_mm_protocal_c_alj2.tPZ;
                    linkedList.add(com_tencent_mm_protocal_c_alj2);
                } else if (bha.qey == 1) {
                    width = (((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12);
                    r5 = (int) ((((float) width) * bha.qeA) / bha.qez);
                    r6 = new alj();
                    if (width > 0) {
                        a = (float) width;
                    }
                    r6.tPY = a;
                    if (r5 > 0) {
                        a = (float) r5;
                    } else {
                        a = a2;
                    }
                    r6.tPZ = a;
                    r6.tQa = r6.tPY * r6.tPZ;
                    linkedList.add(r6);
                } else if (bha.qey == 2) {
                    width = ((width - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12);
                    r5 = (int) ((((float) width) * bha.qeA) / bha.qez);
                    r6 = new alj();
                    if (width > 0) {
                        a = (float) width;
                    }
                    r6.tPY = a;
                    if (r5 > 0) {
                        a2 = (float) r5;
                    }
                    r6.tPZ = a2;
                    r6.tQa = r6.tPY * r6.tPZ;
                    linkedList.add(r6);
                }
            }
            if (!bg.mA(bha.qeE)) {
                final PhotosContent photosContent = cVar.qMr;
                final TagImageView tR = cVar.qMr.tR(0);
                d.a("adId", bha.qeE, false, 41, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                    final /* synthetic */ e qNf;

                    public final void bgn() {
                    }

                    public final void bgo() {
                    }

                    public final void FW(String str) {
                        this.qNf.qNe = (MaskImageView) photosContent.findViewById(f.pDn);
                        if (this.qNf.qNe != null) {
                            this.qNf.qNe.setVisibility(0);
                            this.qNf.qNe.setImageBitmap(BitmapFactory.decodeFile(str));
                            float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeF, 1, bha.qeB, bha.qeC);
                            float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeG, 1, bha.qeB, bha.qeC);
                            float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeH, 1, bha.qeB, bha.qeC);
                            float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeI, 1, bha.qeB, bha.qeC);
                            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                            layoutParams.setMargins((int) ((((float) tR.getRight()) - a3) - a), (int) ((((float) tR.getBottom()) - a4) - a2), 0, 0);
                            this.qNf.qNe.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }
        aq aqVar = auVar.qzJ;
        PhotosContent photosContent2 = cVar.qMr;
        str = axVar.qtl;
        int hashCode = this.qb.hashCode();
        boolean z = this.qze;
        an bLR = an.bLR();
        bLR.cIm = com_tencent_mm_protocal_c_bfc.ogM;
        aqVar.a(photosContent2, com_tencent_mm_protocal_c_bfc, str, hashCode, i2, i, z, bLR, linkedList);
        cVar.qNc.setTag(cVar.qMr.tR(0));
        cVar.qNd.setTag(cVar.qMr.tR(0));
    }
}
