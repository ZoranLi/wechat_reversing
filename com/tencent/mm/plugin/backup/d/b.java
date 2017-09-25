package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.ee;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b extends k implements j {
    public com.tencent.mm.y.b gUA;
    protected e gUD;

    public b(LinkedList<me> linkedList, String str) {
        a aVar = new a();
        aVar.hsm = new ee();
        aVar.hsn = new eg();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        aVar.hsl = 704;
        this.gUA = aVar.BE();
        ee eeVar = (ee) this.gUA.hsj.hsr;
        eeVar.thR = linkedList.size();
        eeVar.thS = linkedList;
        eeVar.thU = m.xL();
        eeVar.thT = p.getDeviceID(ab.getContext());
        eeVar.thV = str;
        eeVar.jNx = 0;
        eeVar.tdM = 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[]{((eg) this.gUA.hsk.hsr).thZ});
            com.tencent.mm.plugin.backup.a.e.N(r0.thF.tZp.sYA);
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 704;
    }
}
