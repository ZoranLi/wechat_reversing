package com.tencent.mm.plugin.sns.a.a;

import android.view.View;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    long hTn = 0;
    public String hTo = "";
    private String iHN = "";
    boolean kgf = false;
    public int lon = 0;
    public int nXW = 1;
    int pOA = -10086;
    private int pOB = -10086;
    long pOC = 0;
    long pOD = 0;
    private int pOE = -10086;
    private int pOF = -10086;
    long pOG = 0;
    private int pOH = -10086;
    private int pOI = -10086;
    long pOJ = 0;
    private int pOK = -10086;
    private int pOL = -10086;
    long pOM = 0;
    private int pON = -10086;
    private int pOO = -10086;
    long pOP = 0;
    int pOQ = 0;
    int pOR = -1;
    int pOS = -1;
    int pOT = 0;
    int pOU = 0;
    public boolean pOo = false;
    public bbk pOp;
    public View pOq;
    public View pOr;
    public int pOs = 0;
    public int pOt = 0;
    public int pOu;
    private View pOv;
    private int pOw = 0;
    private com.tencent.mm.plugin.sns.storage.a pOx = null;
    int pOy = -10086;
    private int pOz = -10086;
    int position = 0;

    public a(com.tencent.mm.plugin.sns.storage.a aVar, long j, View view, int i, View view2, int i2, int i3, bbk com_tencent_mm_protocal_c_bbk, int i4) {
        this.position = i4;
        this.pOq = view;
        this.pOp = com_tencent_mm_protocal_c_bbk;
        this.pOx = aVar;
        this.nXW = i3;
        this.iHN = aVar == null ? "" : bg.ap(aVar.iHN, "");
        this.hTo = aVar == null ? "" : bg.ap(aVar.pZI, "");
        this.hTn = j;
        this.pOu = i;
        this.pOv = view2;
        this.pOw = i2;
        if (this.pOq != null) {
            this.pOr = this.pOq.findViewById(f.pBE);
        }
        KC();
    }

    private void KC() {
        if (this.lon == 0) {
            b.a(this.pOq.getContext(), 50.0f);
            this.lon = this.pOq.getHeight();
            if (this.pOr != null) {
                this.pOs = this.pOr.getHeight();
            }
            if (this.lon != 0) {
                int i = 0;
                if (this.pOv != null) {
                    i = this.pOv.getBottom();
                }
                this.lon -= this.pOs;
                this.pOt = this.lon / 2;
                this.pOu = (this.pOu - i) - this.pOw;
                w.i("MicroMsg.AdViewStatic", "viewHeight " + this.lon + " SCREEN_HEIGHT: " + this.pOu + " abottom: " + i + " stHeight: " + this.pOw + " commentViewHeight:" + this.pOs);
            }
        }
    }

    public final void bdm() {
        boolean z = true;
        if (this.pOq != null) {
            KC();
            if (!this.kgf && this.lon > 0) {
                int i;
                int i2;
                this.pOo = true;
                int top = this.pOq.getTop();
                int bottom = this.pOq.getBottom() - this.pOs;
                if (this.pOy == -10086 && this.pOz == -10086) {
                    this.pOy = top;
                    this.pOz = bottom;
                }
                this.pOA = top;
                this.pOB = bottom;
                if (top < 0) {
                    i = top + this.lon;
                    int i3 = this.lon - i;
                    if (i < this.pOt || this.pOE != -10086) {
                        boolean z2 = true;
                    } else {
                        this.pOE = top;
                        this.pOF = bottom;
                        this.pOG = System.currentTimeMillis();
                        w.i("MicroMsg.AdViewStatic", "up first touch half" + i + " top " + top + " viewhieght " + this.lon + " inscreenval: " + i + " outscreenval: " + i3);
                        i2 = 0;
                    }
                    if (i3 >= this.pOt && this.pOH == -10086 && r0 != 0 && this.pOG > 0) {
                        this.pOH = top;
                        this.pOI = bottom;
                        this.pOJ = System.currentTimeMillis();
                        w.i("MicroMsg.AdViewStatic", "down first touch half" + i + " bottom " + bottom + " viewhieght " + this.lon + " inscreenval: " + i + " outscreenval: " + i3);
                    }
                }
                if (bottom > this.pOu) {
                    i2 = bottom - this.pOu;
                    i = this.lon - i2;
                    if (i >= this.pOt && this.pOE == -10086) {
                        this.pOE = top;
                        this.pOF = bottom;
                        this.pOG = System.currentTimeMillis();
                        w.i("MicroMsg.AdViewStatic", "up first touch half" + i2 + " top " + top + " viewhieght " + this.lon + " inscreenval: " + i + " outscreenval: " + i2);
                        z = false;
                    }
                    if (i2 >= this.pOt && this.pOH == -10086 && r2 && this.pOG > 0) {
                        this.pOH = top;
                        this.pOI = bottom;
                        this.pOJ = System.currentTimeMillis();
                        w.i("MicroMsg.AdViewStatic", "down first touch half" + i2 + " bottom " + bottom + " viewhieght " + this.lon + " inscreenval: " + i + " outscreenval: " + i2);
                    }
                }
                if (top < 0 || bottom > this.pOu) {
                    if (this.pOP == 0 && this.pOM != 0) {
                        this.pON = top;
                        this.pOO = bottom;
                        this.pOP = System.currentTimeMillis();
                    }
                } else if (this.pOM == 0) {
                    this.pOK = top;
                    this.pOL = bottom;
                    this.pOM = System.currentTimeMillis();
                }
                if (top < 0) {
                    i2 = -top;
                    if (this.pOR == -1 || this.pOR > i2) {
                        this.pOR = i2;
                    }
                } else {
                    this.pOR = 0;
                }
                if (bottom > this.pOu) {
                    i2 = bottom - this.pOu;
                    if (this.pOS == -1 || this.pOS > i2) {
                        this.pOS = i2;
                    }
                } else {
                    this.pOS = 0;
                }
                i2 = this.lon;
                if (top < 0) {
                    i2 += top;
                }
                if (bottom > this.pOu) {
                    i2 -= bottom - this.pOu;
                }
                if (this.pOQ == -1 || this.pOQ < i2) {
                    this.pOQ = i2;
                }
            }
        }
    }

    public final be bdn() {
        be beVar = new be();
        if (this.pOp == null) {
            return null;
        }
        beVar.teC = this.pOp.uco;
        beVar.cbl = this.pOp.ucl;
        return beVar;
    }
}
