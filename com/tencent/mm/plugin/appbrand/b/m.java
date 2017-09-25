package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public final class m extends a<bgy> {
    private final bgx iCC;
    private final b iCD;
    public volatile u.a iCE;

    protected final /* synthetic */ void a(int i, int i2, String str, avp com_tencent_mm_protocal_c_avp, k kVar) {
        bgy com_tencent_mm_protocal_c_bgy = (bgy) com_tencent_mm_protocal_c_avp;
        w.i("MicroMsg.AppBrand.CgiUpdateWxaUsageRecord", "onCgiBack, req [scene %d, background %b, versionType %d, recordType %d, op %d, username %s]resp [errType %d, errCode %d, errMsg %s, resp %s]", new Object[]{Integer.valueOf(this.iCC.scene), Integer.valueOf(this.iCC.ugH), Integer.valueOf(this.iCC.tlI), Integer.valueOf(this.iCC.ugI), Integer.valueOf(this.iCC.ugJ), this.iCC.username, Integer.valueOf(i), Integer.valueOf(i2), str, com_tencent_mm_protocal_c_bgy});
        if (this.iCE != null) {
            this.iCE.a(i, i2, str, this.iCD, kVar);
        }
    }

    public m(int i, boolean z, int i2, int i3, int i4, String str, int i5) {
        b.a aVar = new b.a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_bgx = new bgx();
        if (i == 0) {
            i = 1000;
        }
        com_tencent_mm_protocal_c_bgx.scene = i;
        com_tencent_mm_protocal_c_bgx.ugH = z ? 1 : 0;
        com_tencent_mm_protocal_c_bgx.tlI = i2;
        com_tencent_mm_protocal_c_bgx.ugI = i3;
        com_tencent_mm_protocal_c_bgx.ugJ = i4;
        com_tencent_mm_protocal_c_bgx.username = str;
        com_tencent_mm_protocal_c_bgx.fOl = i5;
        this.iCC = com_tencent_mm_protocal_c_bgx;
        aVar.hsm = com_tencent_mm_protocal_c_bgx;
        aVar.hsn = new bgy();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
        aVar.hsl = 1149;
        b BE = aVar.BE();
        this.iCD = BE;
        this.gUA = BE;
    }
}
