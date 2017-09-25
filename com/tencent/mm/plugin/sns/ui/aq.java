package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aq {
    public static int[] qDM = new int[]{0, 0, 1, 3, 6, 9};
    public static int[] qDN = new int[]{f.pBq};
    public static int[] qDO = new int[]{f.pBq, f.pBr, f.pBs};
    public static int[] qDP = new int[]{f.pBq, f.pBr, f.pBs, f.pBt, f.pBu, f.pBv};
    public static int[] qDQ = new int[]{f.pBq, f.pBr, f.pBs, f.pBt, f.pBu, f.pBv, f.pBw, f.pBx, f.pBy};
    static double qDR = -1.0d;
    static double qDS = -1.0d;
    static double qDT = -1.0d;
    static double qDU = -1.0d;
    static double qDV = -1.0d;
    private Context context;
    private LinkedList<LinearLayout> qDW = new LinkedList();

    public aq(Context context) {
        this.context = context;
    }

    public aq(Context context, byte b) {
        this.context = context;
    }

    public final void a(PhotosContent photosContent, bfc com_tencent_mm_protocal_c_bfc, String str, int i, int i2, int i3, boolean z, an anVar, boolean z2) {
        int[] iArr = qDQ;
        if (i2 == 2 || i2 == 11) {
            iArr = qDN;
        } else if (i2 == 3) {
            iArr = qDO;
        } else if (i2 == 4) {
            iArr = qDP;
        } else if (i2 == 5) {
            iArr = qDQ;
        }
        List list = com_tencent_mm_protocal_c_bfc.ufB.tsO;
        if (qDR < 0.0d) {
            qDR = (double) b.a(this.context, 160.0f);
            qDS = (double) b.a(this.context, 200.0f);
            qDT = (double) b.a(this.context, 44.0f);
            qDU = (double) b.a(this.context, 66.0f);
            qDV = (double) b.a(this.context, 300.0f);
        }
        int size = list.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ae.beI().cn(photosContent.tR(size));
                photosContent.tR(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                View tR = photosContent.tR(size);
                tR.setVisibility(8);
                ae.beI().cn(tR);
                photosContent.tR(size).position = i3;
            }
            photosContent.tR(0).setVisibility(0);
            a((alh) list.get(0), photosContent.tR(0), str, i, i3, z, anVar, i2, z2);
        }
    }

    public final void a(PhotosContent photosContent, bfc com_tencent_mm_protocal_c_bfc, String str, int i, int i2, int i3, boolean z, an anVar, List<alj> list) {
        int[] iArr = qDQ;
        if (i2 == 2 || i2 == 11) {
            iArr = qDN;
        } else if (i2 == 3) {
            iArr = qDO;
        } else if (i2 == 4) {
            iArr = qDP;
        } else if (i2 == 5) {
            iArr = qDQ;
        }
        List list2 = com_tencent_mm_protocal_c_bfc.ufB.tsO;
        if (qDR < 0.0d) {
            qDR = (double) b.a(this.context, 160.0f);
            qDS = (double) b.a(this.context, 200.0f);
            qDT = (double) b.a(this.context, 44.0f);
            qDU = (double) b.a(this.context, 66.0f);
            qDV = (double) b.a(this.context, 300.0f);
        }
        int size = list2.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ae.beI().cn(photosContent.tR(size));
                photosContent.tR(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.tQ(ae.beS());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                View tR = photosContent.tR(size);
                tR.setVisibility(8);
                ae.beI().cn(tR);
                photosContent.tR(size).position = i3;
            }
            photosContent.tR(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                a((alh) list2.get(0), photosContent.tR(0), str, i, i3, z, anVar, i2, false);
                return;
            }
            a((alh) list2.get(0), photosContent.tR(0), str, i, i3, z, anVar, i2, false, (alj) list.get(0));
        } else if (size == 4) {
            List arrayList = new ArrayList();
            int length = iArr.length - 1;
            int i4 = 3;
            while (length >= 0) {
                View tR2 = photosContent.tR(length);
                tR2.position = i3;
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    tR2.setVisibility(0);
                    arrayList.add(tR2);
                    ao aoVar = new ao();
                    aoVar.fJz = str;
                    size = i4 - 1;
                    aoVar.index = i4;
                    aoVar.qBO = arrayList;
                    aoVar.qze = z;
                    aoVar.position = i3;
                    tR2.setTag(aoVar);
                    a((alh) list2.get(aoVar.index), tR2, i, anVar);
                    i4 = size;
                } else {
                    tR2.setVisibility(8);
                    ae.beI().cn(tR2);
                }
                length--;
            }
        } else {
            List arrayList2 = new ArrayList();
            for (size = iArr.length - 1; size >= 0; size--) {
                View tR3 = photosContent.tR(size);
                tR3.position = i3;
                if (size < list2.size()) {
                    tR3.setVisibility(0);
                    arrayList2.add(tR3);
                    ao aoVar2 = new ao();
                    aoVar2.fJz = str;
                    aoVar2.index = size;
                    aoVar2.qBO = arrayList2;
                    aoVar2.qze = z;
                    aoVar2.position = i3;
                    tR3.setTag(aoVar2);
                    a((alh) list2.get(aoVar2.index), tR3, i, anVar);
                } else {
                    tR3.setVisibility(8);
                    ae.beI().cn(tR3);
                }
            }
        }
    }

    private static void a(alh com_tencent_mm_protocal_c_alh, QFadeImageView qFadeImageView, int i, an anVar) {
        ae.beI().b(com_tencent_mm_protocal_c_alh, qFadeImageView, i, anVar);
    }

    private static void a(alh com_tencent_mm_protocal_c_alh, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, an anVar, int i3, boolean z2, alj com_tencent_mm_protocal_c_alj) {
        if (qFadeImageView == null) {
            w.e("MicroMsg.SnsMultiLineImageLineMgr", "");
            return;
        }
        double min;
        ao aoVar = new ao();
        aoVar.fJz = str;
        aoVar.index = 0;
        List arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        aoVar.qBO = arrayList;
        aoVar.qze = z;
        aoVar.position = i2;
        qFadeImageView.setTag(aoVar);
        double d = 0.0d;
        double d2 = 0.0d;
        if (i3 == 11 && z2) {
            ae.beI().d(com_tencent_mm_protocal_c_alh, qFadeImageView, i, anVar);
        } else {
            ae.beI().a(com_tencent_mm_protocal_c_alh, (View) qFadeImageView, i, anVar);
        }
        if (com_tencent_mm_protocal_c_alh.tPl != null) {
            d = (double) com_tencent_mm_protocal_c_alh.tPl.tPY;
            d2 = (double) com_tencent_mm_protocal_c_alh.tPl.tPZ;
        }
        if (d <= 0.0d || d2 <= 0.0d) {
            d = qDR;
            d2 = qDR;
        } else {
            min = Math.min(qDS / d, qDS / d2);
            d *= min;
            d2 *= min;
            if (d < qDT) {
                min = (1.0d * qDT) / d;
                d *= min;
                d2 *= min;
            }
            if (d2 < qDT) {
                min = (1.0d * qDT) / d2;
                d *= min;
                d2 *= min;
            }
            if (d > qDS) {
                d = qDS;
            }
            if (d2 > qDS) {
                d2 = qDS;
            }
        }
        if (d < 1.0d) {
            d = 1.0d;
        }
        if (d2 < 1.0d) {
            d2 = 1.0d;
        }
        if (com_tencent_mm_protocal_c_alj == null || com_tencent_mm_protocal_c_alj.tPY <= 0.0f || com_tencent_mm_protocal_c_alj.tPZ <= 0.0f) {
            min = d;
            d = d2;
        } else {
            min = (double) com_tencent_mm_protocal_c_alj.tPY;
            d = (double) com_tencent_mm_protocal_c_alj.tPZ;
        }
        if (qFadeImageView.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) qFadeImageView.getLayoutParams();
            if (((double) layoutParams.width) != min || ((double) layoutParams.height) != d) {
                qFadeImageView.setLayoutParams(new LayoutParams((int) min, (int) d));
            }
        }
    }

    private static void a(alh com_tencent_mm_protocal_c_alh, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, an anVar, int i3, boolean z2) {
        a(com_tencent_mm_protocal_c_alh, qFadeImageView, str, i, i2, z, anVar, i3, z2, new alj());
    }
}
