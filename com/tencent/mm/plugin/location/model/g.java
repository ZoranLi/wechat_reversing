package com.tencent.mm.plugin.location.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    public final b gUA;
    private e gUD;
    private byte[] nbb;
    String nbc;

    public g(float f, float f2, int i, int i2, int i3, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new zh();
        aVar.hsn = new zi();
        aVar.uri = "/cgi-bin/micromsg-bin/getlocimg";
        aVar.hsl = 648;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        zh zhVar = (zh) this.gUA.hsj.hsr;
        zhVar.leO = str2;
        if (bg.Hp()) {
            zhVar.tFI = 1;
        } else {
            zhVar.tFI = 0;
        }
        zhVar.tna = f;
        zhVar.tmZ = f2;
        zhVar.tFJ = i;
        w.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        while (i2 * i3 > 270000) {
            i2 = (int) (((double) i2) / 1.2d);
            i3 = (int) (((double) i3) / 1.2d);
        }
        w.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), zhVar.leO});
        zhVar.Height = i3;
        zhVar.Width = i2;
        this.nbc = str;
    }

    public final int getType() {
        return 648;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        try {
            this.nbb = ((zi) ((b) pVar).hsk.hsr).tfh.tZp.sYA;
            com.tencent.mm.a.e.b(this.nbc, this.nbb, this.nbb.length);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneGetLocImg", e, "", new Object[0]);
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
