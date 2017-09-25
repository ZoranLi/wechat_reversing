package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.protocal.c.kl;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class r {
    private final String appId;
    private final String fFW;
    private final String iZN;
    private final boolean iZx;

    public enum a {
        Ok,
        Fail,
        Timeout,
        CgiFail,
        ResponseInvalid,
        AwaitFail;

        public static a hW(int i) {
            if (i < 0) {
                return null;
            }
            for (a aVar : values()) {
                if (aVar.ordinal() == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public r(String str, String str2, String str3, boolean z) {
        this.appId = str;
        this.fFW = str2;
        this.iZN = str3;
        this.iZx = z;
    }

    public r(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    private void h(int i, String str, String str2) {
        if (c.PY().a(this.appId, i, str, str2, 0, 0) && this.iZx) {
            b.an(this.appId, 2);
        }
    }

    public final int Ve() {
        String str = this.appId;
        String str2 = this.fFW;
        String str3 = this.iZN;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        com.tencent.mm.bd.a klVar = new kl();
        klVar.fTO = str;
        klVar.tqB = str2;
        klVar.tqC = str3;
        aVar.hsm = klVar;
        aVar.hsn = new km();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.hsl = 1124;
        com.tencent.mm.y.a.a b = com.tencent.mm.plugin.appbrand.e.c.b(aVar.BE());
        if (b.errType == 0 && b.errCode == 0) {
            try {
                km kmVar = (km) b.fYb;
                if (kmVar.tqD == null) {
                    w.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[]{this.appId});
                    return a.ResponseInvalid.ordinal();
                }
                w.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[]{this.appId, Integer.valueOf(kmVar.tqD.leR), Boolean.valueOf(kmVar.tqE), kmVar.tqF, kmVar.tqG});
                if (kmVar.tqD.leR != 0) {
                    return kmVar.tqD.leR;
                }
                if (!(!kmVar.tqE || bg.mA(kmVar.tqG) || bg.mA(kmVar.tqF))) {
                    h(2, kmVar.tqF, kmVar.tqG);
                }
                if (!(!kmVar.tqH || bg.mA(kmVar.tqJ) || bg.mA(kmVar.tqI))) {
                    h(CdnLogic.MediaType_FAVORITE_FILE, kmVar.tqI, kmVar.tqJ);
                }
                return a.Ok.ordinal();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[]{this.appId});
                return a.ResponseInvalid.ordinal();
            }
        }
        w.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[]{this.appId, Integer.valueOf(b.errType), Integer.valueOf(b.errCode), b.fPf});
        return a.CgiFail.ordinal();
    }
}
