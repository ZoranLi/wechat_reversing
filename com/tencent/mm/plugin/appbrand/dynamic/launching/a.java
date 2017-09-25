package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.dynamic.i.e;
import com.tencent.mm.plugin.appbrand.dynamic.i.f;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.protocal.c.bqw;
import java.util.concurrent.Callable;

public final class a implements Callable<f> {
    final String appId;
    final int fKL;
    final int fWF;
    final int iIb;
    final int scene;

    public final /* synthetic */ Object call() {
        return Sf();
    }

    public a(String str, int i, int i2, int i3, int i4) {
        this.appId = str;
        this.fKL = i;
        this.fWF = i2;
        this.scene = i3;
        this.iIb = i4;
    }

    public final f Sf() {
        f fVar = new f();
        fVar.field_appId = this.appId;
        e PT = c.PT();
        if (PT == null) {
            return null;
        }
        bqw com_tencent_mm_protocal_c_bqw = new bqw();
        com_tencent_mm_protocal_c_bqw.tLJ = com.tencent.mm.plugin.appbrand.dynamic.j.a.hF(this.fKL);
        com_tencent_mm_protocal_c_bqw.tkv = this.fWF;
        com_tencent_mm_protocal_c_bqw.uoR = this.iIb;
        com_tencent_mm_protocal_c_bqw.tdM = this.scene;
        com_tencent_mm_protocal_c_bqw.uoS = 0;
        if (PT.a(fVar, "appId", "pkgType", "widgetType")) {
            if ((fVar.field_jsApiInfo != null) && fVar.field_launchAction != null && 1 == fVar.field_launchAction.tcm && fVar.field_versionInfo != null && fVar.field_versionInfo.tkv >= this.fWF) {
                d.vL().D(new Runnable(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, com_tencent_mm_protocal_c_bqw)) {
                    final /* synthetic */ a iIi;

                    {
                        this.iIi = r1;
                    }

                    public final void run() {
                        this.iIi.BC();
                    }
                });
                return fVar;
            }
        }
        com.tencent.mm.plugin.appbrand.dynamic.g.a aVar = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, com_tencent_mm_protocal_c_bqw);
        com.tencent.mm.y.a.a b = com.tencent.mm.plugin.appbrand.e.c.b(aVar.gUA);
        aVar.a(b.errType, b.errCode, b.fPf, (aiu) b.fYb);
        return aVar.iIh;
    }
}
