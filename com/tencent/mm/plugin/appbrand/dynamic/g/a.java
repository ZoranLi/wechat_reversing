package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.config.SysConfigUtil;
import com.tencent.mm.plugin.appbrand.dynamic.i.e;
import com.tencent.mm.plugin.appbrand.dynamic.i.f;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;

public final class a extends com.tencent.mm.y.a<aiu> {
    private int fKL;
    public final b gUA;
    private int iIb;
    public f iIh;

    protected final /* bridge */ /* synthetic */ void a(int i, int i2, String str, avp com_tencent_mm_protocal_c_avp, k kVar) {
        a(i, i2, str, (aiu) com_tencent_mm_protocal_c_avp);
    }

    public a(String str, boolean z, bqw com_tencent_mm_protocal_c_bqw) {
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ait = new ait();
        com_tencent_mm_protocal_c_ait.mtb = str;
        com_tencent_mm_protocal_c_ait.tML = com_tencent_mm_protocal_c_bqw;
        com_tencent_mm_protocal_c_ait.tHa = z ? 1 : 2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 1181;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
        aVar.hsm = com_tencent_mm_protocal_c_ait;
        aVar.hsn = new aiu();
        b BE = aVar.BE();
        this.gUA = BE;
        this.gUA = BE;
        this.iIb = com_tencent_mm_protocal_c_bqw.uoR;
        this.fKL = com.tencent.mm.plugin.appbrand.dynamic.j.a.bn(this.iIb, com_tencent_mm_protocal_c_bqw.tLJ);
    }

    private String getAppId() {
        return ((ait) this.gUA.hsj.hsr).mtb;
    }

    public void a(int i, int i2, String str, aiu com_tencent_mm_protocal_c_aiu) {
        f fVar = null;
        w.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, getAppId()});
        String appId;
        int i3;
        if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_aiu != null) {
            appId = getAppId();
            e PT = c.PT();
            int i4 = this.fKL;
            i3 = this.iIb;
            if (!(bg.mA(appId) || com_tencent_mm_protocal_c_aiu == null)) {
                int i5;
                f fVar2 = new f();
                fVar2.field_appIdHash = appId.hashCode();
                fVar2.field_appId = appId;
                fVar2.field_pkgType = i4;
                fVar2.field_widgetType = i3;
                if (PT.a(fVar2, "appId", "pkgType", "widgetType")) {
                    boolean z = false;
                } else {
                    i5 = 1;
                }
                if (SysConfigUtil.a(fVar2.field_launchAction, com_tencent_mm_protocal_c_aiu.tMM)) {
                    boolean z2 = false;
                } else {
                    fVar2.field_launchAction = com_tencent_mm_protocal_c_aiu.tMM;
                    i4 = 1;
                }
                if (!SysConfigUtil.a(fVar2.field_jsApiInfo, com_tencent_mm_protocal_c_aiu.tMH)) {
                    fVar2.field_jsApiInfo = com_tencent_mm_protocal_c_aiu.tMH;
                    i4 = 1;
                }
                if (!SysConfigUtil.a(fVar2.field_versionInfo, com_tencent_mm_protocal_c_aiu.tMN)) {
                    fVar2.field_versionInfo = com_tencent_mm_protocal_c_aiu.tMN;
                    i4 = 1;
                }
                if (i4 != 0) {
                    if (i5 != 0) {
                        PT.a(fVar2, false);
                    } else {
                        PT.a(fVar2, false, "appId", "pkgType", "widgetType");
                    }
                }
                if (i4 != 0) {
                    PT.a(fVar2, "appId", "pkgType", "widgetType");
                }
                fVar = fVar2;
            }
            this.iIh = fVar;
            if (com_tencent_mm_protocal_c_aiu.tMN != null) {
                String P = c.PY().P(appId, this.fKL);
                bqg com_tencent_mm_protocal_c_bqg = new bqg();
                com_tencent_mm_protocal_c_bqg.uoy = P;
                com_tencent_mm_protocal_c_bqg.tkv = com_tencent_mm_protocal_c_aiu.tMN.tkv;
                if (this.fKL == 10102) {
                    com_tencent_mm_protocal_c_bqg.uox = com_tencent_mm_protocal_c_aiu.tMN.unP;
                    c.PY().a(appId, com_tencent_mm_protocal_c_bqg, this.fKL);
                    return;
                } else if (this.fKL == CdnLogic.MediaType_FAVORITE_VIDEO) {
                    com_tencent_mm_protocal_c_bqg.uox = com_tencent_mm_protocal_c_aiu.tMN.unO;
                    c.PY().a(appId, com_tencent_mm_protocal_c_bqg, this.fKL);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        e PT2 = c.PT();
        appId = getAppId();
        int i6 = this.fKL;
        i3 = this.iIb;
        if (!bg.mA(appId)) {
            f fVar3 = new f();
            fVar3.field_appIdHash = appId.hashCode();
            fVar3.field_appId = appId;
            fVar3.field_pkgType = i6;
            fVar3.field_widgetType = i3;
            if (PT2.a(fVar3, "appId", "pkgType", "widgetType")) {
                fVar = fVar3;
            }
        }
        this.iIh = fVar;
    }
}
