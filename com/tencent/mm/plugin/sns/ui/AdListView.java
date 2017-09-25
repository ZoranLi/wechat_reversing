package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.modelstat.o.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.a.b;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;

public class AdListView extends ListView {
    b qoI;
    f qoJ;
    e qoK;
    private boolean qoL = true;
    private HashSet<String> qoM = new HashSet();

    public AdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void layoutChildren() {
        super.layoutChildren();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void detachViewFromParent(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.fGN;
        }
        if (r.ijw) {
            w.d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
    }

    protected void detachViewFromParent(int i) {
        if (r.ijw) {
            w.d("MicroMsg.AdListView", "2childview  onRemoved " + i + " count:" + getChildCount());
        }
        super.detachViewFromParent(i);
    }

    protected void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        super.attachViewToParent(view, i, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.fGN;
            d.qdx.FT(cVar.qMR.mQY);
            if (this.qoI != null && cVar.pQJ) {
                this.qoI.a(cVar.position, cVar.fGN, cVar.iHN, cVar.moR, view, cVar.qLP, cVar.pQK, cVar.pOp, cVar.knu, 1);
            }
            if (!this.qoM.contains(cVar.fVJ) && ((cVar.pQJ && cVar.qMR.ufB.tsN == 15) || cVar.qMR.ufB.tsN == 18)) {
                boolean z = false;
                if (cVar.qMR.ufB.tsN == 15 && (cVar.qMQ.pwp instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.qMQ.pwp).pvc.bbZ();
                }
                j.a(ae.beL().Gf(cVar.fVJ), false, z);
                this.qoM.add(cVar.fVJ);
            }
            if (this.qoJ != null) {
                this.qoJ.a(cVar.fGN, cVar.qMR);
            }
            if (this.qoK != null) {
                this.qoK.a(cVar.position, cVar.fGN, cVar.qLP, cVar.iHN, cVar.qMR, cVar.pQJ, cVar.pQK);
            }
            str = str2;
        }
        if (r.ijw) {
            w.d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewAdded(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.fGN;
            d.qdx.FT(cVar.qMR.mQY);
            if (this.qoI != null && cVar.pQJ) {
                this.qoI.a(cVar.position, cVar.fGN, cVar.iHN, cVar.moR, view, cVar.qLP, cVar.pQK, cVar.pOp, cVar.knu, 1);
            }
            if (!this.qoM.contains(cVar.fVJ) && ((cVar.pQJ && cVar.qMR.ufB.tsN == 15) || cVar.qMR.ufB.tsN == 18)) {
                boolean z = false;
                if (cVar.qMR.ufB.tsN == 15 && (cVar.qMQ.pwp instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.qMQ.pwp).pvc.bbZ();
                }
                j.a(ae.beL().Gf(cVar.fVJ), false, z);
                this.qoM.add(cVar.fVJ);
            }
            if (this.qoJ != null) {
                this.qoJ.a(cVar.fGN, cVar.qMR);
            }
            if (this.qoK != null) {
                this.qoK.a(cVar.position, cVar.fGN, cVar.qLP, cVar.iHN, cVar.qMR, cVar.pQJ, cVar.pQK);
            }
            str = str2;
        }
        if (r.ijw) {
            w.d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewRemoved(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.fGN;
            if (this.qoI != null && cVar.pQJ) {
                this.qoI.q(cVar.position, cVar.fGN, cVar.iHN);
            }
            if (this.qoJ != null) {
                this.qoJ.EY(cVar.fGN);
            }
            if (this.qoK != null) {
                this.qoK.a(cVar.position, cVar.fGN, cVar.qLP, cVar.iHN, cVar.qMR, cVar.pQJ);
            }
            if (cVar.qMR.ufB.tsN == 3) {
                a aVar = a.Sns;
                str = cVar.qMR.qui;
                if (!bg.mA(str)) {
                    byte[] decode = Base64.decode(str, 0);
                    bdi com_tencent_mm_protocal_c_bdi = new bdi();
                    try {
                        com_tencent_mm_protocal_c_bdi.aD(decode);
                        if (com_tencent_mm_protocal_c_bdi.ueA == null) {
                            str = str2;
                        } else {
                            w.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[]{Integer.valueOf(aVar.value), str, com_tencent_mm_protocal_c_bdi.ueA.ueD, com_tencent_mm_protocal_c_bdi.ueA.ueE});
                            g.oUh.i(13235, new Object[]{aVar.value, com_tencent_mm_protocal_c_bdi.ueA.ueD, com_tencent_mm_protocal_c_bdi.ueA.ueE});
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (r.ijw) {
            w.d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    public void removeViewInLayout(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.fGN;
        }
        if (r.ijw) {
            w.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
    }

    public void removeView(View view) {
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.fGN;
        }
        if (r.ijw) {
            w.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    protected void detachViewsFromParent(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            View childAt = getChildAt(i3);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof c)) {
                c cVar = (c) childAt.getTag();
                if (this.qoI != null && cVar.pQJ) {
                    this.qoI.q(cVar.position, cVar.fGN, cVar.iHN);
                }
                if (this.qoJ != null) {
                    this.qoJ.EY(cVar.fGN);
                }
                if (this.qoK != null) {
                    this.qoK.a(cVar.position, cVar.fGN, cVar.qLP, cVar.iHN, cVar.qMR, cVar.pQJ);
                }
                str = cVar.position + " " + cVar.fGN;
            }
            if (r.ijw) {
                w.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i, i2);
    }
}
