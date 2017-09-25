package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aws;
import com.tencent.mm.protocal.c.awt;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private String fDs;
    private e gUD;
    private String iGy;
    private b jZk;
    private awt jZl;
    private long jZm;
    private int offset;
    private int scene;

    public h(String str, long j, int i, int i2, String str2) {
        this.fDs = str;
        this.jZm = j;
        this.offset = i;
        this.scene = i2;
        this.iGy = str2;
        w.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[]{str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.jZk != null) {
            this.jZl = (awt) this.jZk.hsk.hsr;
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1071;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (bg.mA(this.fDs)) {
            w.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
            return -1;
        }
        a aVar = new a();
        aVar.hsl = 1071;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
        aVar.hsm = new aws();
        aVar.hsn = new awt();
        aVar.hso = 0;
        aVar.hsp = 0;
        this.jZk = aVar.BE();
        aws com_tencent_mm_protocal_c_aws = (aws) this.jZk.hsj.hsr;
        com_tencent_mm_protocal_c_aws.tOl = c.AU();
        com_tencent_mm_protocal_c_aws.tDX = this.fDs;
        com_tencent_mm_protocal_c_aws.tlY = this.jZm;
        com_tencent_mm_protocal_c_aws.tll = this.offset;
        com_tencent_mm_protocal_c_aws.tZJ = this.scene;
        com_tencent_mm_protocal_c_aws.tmb = this.iGy;
        return a(eVar, this.jZk, this);
    }

    public final hv aec() {
        return this.jZl == null ? null : this.jZl.tZL;
    }
}
