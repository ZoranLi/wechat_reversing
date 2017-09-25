package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.bpp;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.protocal.c.bqv;

final class n extends k<h> {
    final String appId;
    final int fWF;
    final int fWL;
    final String iEI;
    final AppBrandLaunchReferrer iEK;
    final int iPk;
    final int iZz;

    public final /* synthetic */ Object call() {
        int i = 0;
        h hVar = new h();
        hVar.field_appId = this.appId;
        g PS = c.PS();
        if (PS == null) {
            return null;
        }
        boolean z;
        bqp com_tencent_mm_protocal_c_bqp;
        bqv com_tencent_mm_protocal_c_bqv;
        bpp com_tencent_mm_protocal_c_bpp = new bpp();
        com_tencent_mm_protocal_c_bpp.tLJ = this.iPk;
        com_tencent_mm_protocal_c_bpp.tkv = this.fWF;
        com_tencent_mm_protocal_c_bpp.tdM = this.iZz;
        com_tencent_mm_protocal_c_bpp.tOg = this.iEI;
        com_tencent_mm_protocal_c_bpp.tOf = 0;
        com_tencent_mm_protocal_c_bpp.tOe = this.fWL;
        if (1055 == this.iZz) {
            z = true;
        } else if (1037 == this.iZz) {
            z = true;
        } else {
            int[] iArr = AppBrandGlobalSystemConfig.Rz().iEu;
            z = iArr != null && a.b(iArr, this.iZz);
        }
        if (!z) {
            if (PS.a(hVar, "appId")) {
                if (hVar.field_jsapiInfo != null) {
                    i = 1;
                }
                if (!(i == 0 || hVar.field_launchAction == null || 1 != hVar.field_launchAction.tcm)) {
                    new f(this.appId, com_tencent_mm_protocal_c_bpp).UZ();
                    return hVar;
                }
            }
        }
        if (this.iEK == null || 1 != this.iEK.iEL) {
            com_tencent_mm_protocal_c_bqp = null;
        } else {
            com_tencent_mm_protocal_c_bqp = new bqp();
            com_tencent_mm_protocal_c_bqp.tLD = this.iEK.appId;
        }
        if (this.iEK == null || 2 != this.iEK.iEL) {
            com_tencent_mm_protocal_c_bqv = null;
        } else {
            bqv com_tencent_mm_protocal_c_bqv2 = new bqv();
            com_tencent_mm_protocal_c_bqv2.teQ = this.iEK.appId;
            com_tencent_mm_protocal_c_bqv2.msN = this.iEK.url;
            com_tencent_mm_protocal_c_bqv = com_tencent_mm_protocal_c_bqv2;
        }
        f fVar = new f(this.appId, true, com_tencent_mm_protocal_c_bpp, com_tencent_mm_protocal_c_bqv, com_tencent_mm_protocal_c_bqp);
        fVar.iZE = true;
        com.tencent.mm.y.a.a b = com.tencent.mm.plugin.appbrand.e.c.b(fVar.gUA);
        fVar.a(b.errType, b.errCode, b.fPf, (ais) b.fYb);
        return fVar.iZD;
    }

    n(String str, int i, int i2, int i3, int i4, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer) {
        this.appId = str;
        this.iPk = i;
        this.fWF = i2;
        this.fWL = i3;
        this.iZz = i4;
        this.iEI = str2;
        this.iEK = appBrandLaunchReferrer;
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
    }
}
