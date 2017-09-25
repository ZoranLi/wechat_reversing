package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private b gUA = null;
    private e gUD = null;
    public arr mPU = null;
    public ars mPV = null;

    public i(String str, String str2, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hsm = new arr();
        aVar.hsn = new ars();
        aVar.hsl = 991;
        aVar.uri = "/cgi-bin/micromsg-bin/pstninvite";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        long currentTimeMillis = System.currentTimeMillis();
        int aFx = c.aFx();
        arr com_tencent_mm_protocal_c_arr = (arr) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_arr.mvV = m.xL();
        com_tencent_mm_protocal_c_arr.tVY = str2;
        com_tencent_mm_protocal_c_arr.mvU = str;
        com_tencent_mm_protocal_c_arr.tVX = i;
        com_tencent_mm_protocal_c_arr.trD = aFx;
        com_tencent_mm_protocal_c_arr.tWg = 1;
        com_tencent_mm_protocal_c_arr.tVW = currentTimeMillis;
        com_tencent_mm_protocal_c_arr.tWf = i2;
        com_tencent_mm_protocal_c_arr.tWh = i3;
        this.mPU = com_tencent_mm_protocal_c_arr;
        w.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(aFx), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int getType() {
        return 991;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPV = (ars) ((b) pVar).hsk.hsr;
        if (i2 == 0 || i3 == 0) {
            if (this.gUD != null) {
                this.gUD.a(i2, i3, str, this);
            }
        } else if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
