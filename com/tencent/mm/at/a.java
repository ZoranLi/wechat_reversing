package com.tencent.mm.at;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private final b gUA;
    private e gUD;
    String hQt;

    public a(float f, float f2, int i, int i2, String str, String str2, int i3, int i4, String str3) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ayk();
        aVar.hsn = new ayl();
        aVar.uri = "/cgi-bin/micromsg-bin/sensewhere";
        this.gUA = aVar.BE();
        aiy com_tencent_mm_protocal_c_aiy = new aiy();
        com_tencent_mm_protocal_c_aiy.twS = str2;
        com_tencent_mm_protocal_c_aiy.twT = i2;
        com_tencent_mm_protocal_c_aiy.tna = f2;
        com_tencent_mm_protocal_c_aiy.tmZ = f;
        com_tencent_mm_protocal_c_aiy.twR = str;
        com_tencent_mm_protocal_c_aiy.twQ = i;
        ayk com_tencent_mm_protocal_c_ayk = (ayk) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ayk.ttj = com_tencent_mm_protocal_c_aiy;
        com_tencent_mm_protocal_c_ayk.uav = i3;
        com_tencent_mm_protocal_c_ayk.tdM = i4;
        com_tencent_mm_protocal_c_ayk.opI = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.hQt = ((ayl) ((b) pVar).hsk.hsr).opI;
        } else {
            w.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 752;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
