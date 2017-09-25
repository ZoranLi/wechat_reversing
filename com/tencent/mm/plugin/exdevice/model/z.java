package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class z extends k implements j {
    private e gWW = null;
    private String ldI = "";
    b ldw = null;

    public z(LinkedList<yp> linkedList, String str, String str2) {
        this.ldI = str2;
        a aVar = new a();
        aVar.hsm = new yq();
        aVar.hsn = new yr();
        aVar.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        aVar.hsl = 543;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        yq yqVar = (yq) this.ldw.hsj.hsr;
        if (!bg.mA(str)) {
            yo yoVar = new yo();
            yoVar.tiT = str;
            yqVar.tEY = yoVar;
        }
        yqVar.tEX = linkedList;
    }

    public final int getType() {
        return 543;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
    }
}
