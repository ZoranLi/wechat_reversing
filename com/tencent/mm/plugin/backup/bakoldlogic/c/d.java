package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private final b gUA;
    private e gUD;
    private final String id;
    public byte[] jMp;

    public d(String str) {
        a aVar = new a();
        aVar.hsm = new uq();
        aVar.hsn = new ur();
        aVar.uri = "/cgi-bin/micromsg-bin/getbakchatkey";
        aVar.hso = 0;
        aVar.hsp = 0;
        aVar.hsl = 596;
        this.gUA = aVar.BE();
        uq uqVar = (uq) this.gUA.hsj.hsr;
        uqVar.ID = str;
        uqVar.tCs = ac.bHu().ver;
        this.id = str;
        w.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[]{uqVar.ID, Integer.valueOf(uqVar.tCs)});
    }

    public final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 596;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.jMp = ((ur) this.gUA.hsk.hsr).thF.tZp.sYA;
            String str2 = "MicroMsg.NetSceneGetBakchatkey";
            String str3 = "id:%s,  key len:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.id;
            objArr[1] = Integer.valueOf(this.jMp == null ? 0 : this.jMp.length);
            w.i(str2, str3, objArr);
            if (this.jMp != null) {
                str2 = "";
                for (byte b : this.jMp) {
                    str2 = str2 + Integer.toHexString(b & 255) + " ";
                }
                w.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", new Object[]{str2});
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
