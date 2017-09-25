package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    private static final d jgM = new d(true);
    public String appId;
    public int fCM;
    public String fCN;
    public String fCO;
    public String fFF;
    public int fWL;
    public String fWM;
    public int jfY;
    private final boolean jgh;
    public String jgo;
    public int jgt;
    private boolean jgv = true;
    public int scene;

    private d(boolean z) {
        this.jgh = z;
    }

    public static d Wx() {
        return jgM;
    }

    public static d a(h hVar, String str, String str2) {
        d dVar = new d(false);
        dVar.fFF = str;
        dVar.appId = hVar.ivH;
        AppBrandStatObject mZ = b.mZ(hVar.ivH);
        dVar.scene = mZ.scene;
        dVar.fCN = mZ.fCN;
        dVar.fWL = mZ.fWL;
        dVar.fWM = mZ.fWM;
        dVar.jfY = mZ.jfY;
        dVar.fCM = hVar.iwo.iFk.izV + 1;
        dVar.jgo = str2;
        return dVar;
    }

    public final void e(m mVar) {
        if (mVar != null) {
            this.jgo = mVar.jde.jdU;
        }
    }

    public final void qg() {
        int i = 1;
        if (!this.jgh) {
            bqe com_tencent_mm_protocal_c_bqe = new bqe();
            com_tencent_mm_protocal_c_bqe.jOc = 1;
            com_tencent_mm_protocal_c_bqe.mtb = this.appId;
            com_tencent_mm_protocal_c_bqe.uoo = this.fCO;
            com_tencent_mm_protocal_c_bqe.oTD = 0;
            com_tencent_mm_protocal_c_bqe.lfd = (int) bg.Ny();
            com_tencent_mm_protocal_c_bqe.oTE = 1;
            com_tencent_mm_protocal_c_bqe.uop = "";
            com_tencent_mm_protocal_c_bqe.uod = this.fCM;
            com_tencent_mm_protocal_c_bqe.uoq = this.fFF;
            com_tencent_mm_protocal_c_bqe.uor = a.bz(ab.getContext());
            com_tencent_mm_protocal_c_bqe.rVD = this.scene;
            com_tencent_mm_protocal_c_bqe.uos = this.jfY;
            com_tencent_mm_protocal_c_bqe.uot = this.fCN;
            com_tencent_mm_protocal_c_bqe.jgo = this.jgo;
            com_tencent_mm_protocal_c_bqe.fWL = this.fWL;
            com_tencent_mm_protocal_c_bqe.fWM = this.fWM;
            if (!this.jgv) {
                i = 0;
            }
            this.jgt = i;
            com_tencent_mm_protocal_c_bqe.jgt = i;
            AppBrandIDKeyBatchReport.a(com_tencent_mm_protocal_c_bqe);
            this.jgv = false;
            w.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
        }
    }

    public final String toString() {
        return "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.fFF + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.fCN + '\'' + ", preScene=" + this.fWL + ", preSceneNote='" + this.fWM + '\'' + ", pagePath='" + this.fCO + '\'' + ", usedState=" + this.jfY + ", appState=" + this.fCM + ", referPagePath='" + this.jgo + '\'' + ", isEntrance=" + this.jgt + '}';
    }
}
