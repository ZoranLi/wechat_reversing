package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.dn;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.text.DecimalFormat;

public final class b extends k implements j {
    public static int kMF = 6;
    public static int kMG = 7;
    public static int kMH = 10;
    private final com.tencent.mm.y.b gUA;
    private e gWW;
    private String kMI;
    private pl kMJ;

    public b(String str, pl plVar) {
        a aVar = new a();
        aVar.hsm = new dn();
        aVar.hsn = new do();
        aVar.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        aVar.hsl = 830;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kMI = str;
        this.kMJ = plVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 830;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        dn dnVar = (dn) this.gUA.hsj.hsr;
        dnVar.tgW = this.kMI;
        pl plVar = new pl();
        plVar.mvE = this.kMJ.mvE;
        plVar.tvt = this.kMJ.tvt;
        plVar.tvs = new DecimalFormat("0.00").format(Float.valueOf(this.kMJ.tvs));
        dnVar.tgX = plVar;
        return a(eVar, this.gUA, this);
    }

    public final do aml() {
        return (do) this.gUA.hsk.hsr;
    }
}
