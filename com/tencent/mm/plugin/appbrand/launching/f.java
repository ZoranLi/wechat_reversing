package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.config.SysConfigUtil;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bpp;
import com.tencent.mm.protocal.c.bpx;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.protocal.c.bqv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import java.util.Locale;

final class f extends a<ais> {
    final b gUA;
    volatile h iZD;
    public volatile boolean iZE;

    protected final /* bridge */ /* synthetic */ void a(int i, int i2, String str, avp com_tencent_mm_protocal_c_avp, k kVar) {
        a(i, i2, str, (ais) com_tencent_mm_protocal_c_avp);
    }

    f(String str, boolean z, bpp com_tencent_mm_protocal_c_bpp, bqv com_tencent_mm_protocal_c_bqv, bqp com_tencent_mm_protocal_c_bqp) {
        this.iZE = false;
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_air = new air();
        com_tencent_mm_protocal_c_air.mtb = str;
        com_tencent_mm_protocal_c_air.tMB = com_tencent_mm_protocal_c_bpp;
        com_tencent_mm_protocal_c_air.tHa = z ? 1 : 2;
        com_tencent_mm_protocal_c_air.tME = com_tencent_mm_protocal_c_bqv;
        com_tencent_mm_protocal_c_air.tMF = com_tencent_mm_protocal_c_bqp;
        b.a aVar = new b.a();
        aVar.hsl = 1122;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
        aVar.hsm = com_tencent_mm_protocal_c_air;
        aVar.hsn = new ais();
        b BE = aVar.BE();
        this.gUA = BE;
        this.gUA = BE;
    }

    f(String str, bpp com_tencent_mm_protocal_c_bpp) {
        this(str, false, com_tencent_mm_protocal_c_bpp, null, null);
    }

    private String getAppId() {
        return ((air) this.gUA.hsj.hsr).mtb;
    }

    private int UX() {
        return ((air) this.gUA.hsj.hsr).tMB.tLJ;
    }

    private boolean UY() {
        return ((air) this.gUA.hsj.hsr).tMB.tOf > 0;
    }

    final void UZ() {
        d.vL().D(new Runnable(this) {
            final /* synthetic */ f iZF;

            {
                this.iZF = r1;
            }

            public final void run() {
                this.iZF.iZE = false;
                this.iZF.BC();
            }
        });
    }

    void a(int i, int i2, String str, ais com_tencent_mm_protocal_c_ais) {
        String str2;
        if (com_tencent_mm_protocal_c_ais == null) {
            str2 = "NULL";
        } else {
            if (com_tencent_mm_protocal_c_ais.tMH == null) {
                str2 = "NULL_API_INFO";
            } else {
                Object obj;
                StringBuilder stringBuilder = new StringBuilder("api_info fg:");
                if (com_tencent_mm_protocal_c_ais.tMH.tqU == null) {
                    obj = "NULL";
                } else {
                    obj = Integer.valueOf(com_tencent_mm_protocal_c_ais.tMH.tqU.sYA.length);
                }
                str2 = stringBuilder.append(obj).toString();
                if (com_tencent_mm_protocal_c_ais.tMH.tqV != null) {
                    if (com_tencent_mm_protocal_c_ais.tMH.tqV.size() > 0) {
                        str2 = str2 + " | bg:" + ((com.tencent.mm.bd.b) com_tencent_mm_protocal_c_ais.tMH.tqV.get(0)).sYA.length;
                    }
                    if (com_tencent_mm_protocal_c_ais.tMH.tqV.size() > 1) {
                        str2 = str2 + " | suspend:" + ((com.tencent.mm.bd.b) com_tencent_mm_protocal_c_ais.tMH.tqV.get(1)).sYA.length;
                    }
                }
            }
            if (com_tencent_mm_protocal_c_ais.tMG == null) {
                str2 = str2 + " || NULL_LAUNCH";
            } else {
                str2 = str2 + " || launch " + com_tencent_mm_protocal_c_ais.tMG.tcm;
            }
        }
        w.i("MicroMsg.CgiLaunchWxaApp", "onCgiBack, errType %d, errCode %d, errMsg %s, req[appId %s, bg %B, sync %B], resp[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, getAppId(), Boolean.valueOf(UY()), Boolean.valueOf(this.iZE), str2});
        if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_ais != null) {
            h hVar;
            g PS = c.PS();
            String appId = getAppId();
            if (bg.mA(appId) || com_tencent_mm_protocal_c_ais == null) {
                hVar = null;
            } else {
                boolean z;
                h hVar2 = new h();
                hVar2.field_appId = appId;
                boolean z2 = !PS.a(hVar2, "appId");
                if (SysConfigUtil.a(hVar2.field_launchAction, com_tencent_mm_protocal_c_ais.tMG)) {
                    z = false;
                } else {
                    hVar2.field_launchAction = com_tencent_mm_protocal_c_ais.tMG;
                    z = true;
                }
                if (!SysConfigUtil.a(hVar2.field_jsapiInfo, com_tencent_mm_protocal_c_ais.tMH)) {
                    hVar2.field_jsapiInfo = com_tencent_mm_protocal_c_ais.tMH;
                    z = true;
                }
                com_tencent_mm_protocal_c_ais.tMI = com_tencent_mm_protocal_c_ais.tMI == null ? new bpx() : com_tencent_mm_protocal_c_ais.tMI;
                if (!SysConfigUtil.a(hVar2.field_hostInfo, com_tencent_mm_protocal_c_ais.tMI)) {
                    hVar2.field_hostInfo = com_tencent_mm_protocal_c_ais.tMI;
                    z = true;
                }
                if (!(com_tencent_mm_protocal_c_ais.tMK == null || SysConfigUtil.a(hVar2.field_actionsheetInfo, com_tencent_mm_protocal_c_ais.tMK))) {
                    hVar2.field_actionsheetInfo = com_tencent_mm_protocal_c_ais.tMK;
                    z = true;
                }
                w.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[]{appId, Boolean.valueOf(z), Boolean.valueOf(z2)});
                if (z) {
                    if (z2) {
                        PS.a(hVar2, false);
                    } else {
                        PS.b(hVar2, false, "appId");
                    }
                }
                com.tencent.mm.plugin.appbrand.appcache.d.a(com_tencent_mm_protocal_c_ais.tMJ);
                if (z) {
                    PS.a(hVar2, "appId");
                }
                hVar = hVar2;
            }
            this.iZD = hVar;
            if (com_tencent_mm_protocal_c_ais.tMG != null) {
                if (com_tencent_mm_protocal_c_ais.tMG.tMz) {
                    c.PW().a(p.op(getAppId()), UX(), UY(), ((air) this.gUA.hsj.hsr).tMB.tdM, 1);
                }
                if (!this.iZE) {
                    a aVar = AppBrandLaunchErrorAction.CREATOR;
                    com.tencent.mm.plugin.appbrand.ipc.d.a(a.a(getAppId(), UX(), this.iZD));
                }
            }
        } else if (!UY()) {
            int i3 = R.l.dFI;
            Object[] objArr = new Object[1];
            objArr[0] = String.format(Locale.US, " (%d,%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            l.pK(l.e(i3, objArr));
        }
    }
}
