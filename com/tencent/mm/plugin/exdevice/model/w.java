package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aer;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.axs;
import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class w extends k implements j {
    private e gWW = null;
    String ldF;
    public b ldw = null;

    public w(long j, String str, String str2, long j2, long j3, byte[] bArr, int i) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(bArr.length), Integer.valueOf(i)});
        this.ldF = str2;
        a aVar = new a();
        aVar.hsm = new axs();
        aVar.hsn = new axt();
        aVar.hsl = 538;
        aVar.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        axs com_tencent_mm_protocal_c_axs = (axs) this.ldw.hsj.hsr;
        aen com_tencent_mm_protocal_c_aen = new aen();
        com_tencent_mm_protocal_c_aen.thD = str;
        com_tencent_mm_protocal_c_aen.jNm = str2;
        com_tencent_mm_protocal_c_axs.tjo = com_tencent_mm_protocal_c_aen;
        aer com_tencent_mm_protocal_c_aer = new aer();
        com_tencent_mm_protocal_c_aer.tJW = j2;
        com_tencent_mm_protocal_c_aer.ogM = (int) j3;
        com_tencent_mm_protocal_c_aer.tij = new avw().bb(bArr);
        com_tencent_mm_protocal_c_aer.jOc = i;
        com_tencent_mm_protocal_c_axs.uak = com_tencent_mm_protocal_c_aer;
        if (j != 0) {
            com_tencent_mm_protocal_c_axs.tJR = new avw().bb(u.apU().l(j, 2));
            return;
        }
        com.tencent.mm.plugin.exdevice.h.b vj = ad.apt().vj(str2);
        if (vj != null) {
            com_tencent_mm_protocal_c_axs.tJR = new avw().bb(vj.field_sessionBuf);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 538;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.ldw, this);
    }
}
