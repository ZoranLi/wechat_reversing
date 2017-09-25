package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class x extends k implements j {
    private e gUD;
    public final b hKp;

    public x(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new biu();
        aVar.hsn = new biv();
        aVar.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        aVar.hsl = 1702;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hKp = aVar.BE();
        biu com_tencent_mm_protocal_c_biu = (biu) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_biu.msN = str;
        com_tencent_mm_protocal_c_biu.fTO = str2;
        com_tencent_mm_protocal_c_biu.fGV = str3;
    }

    public final int getType() {
        return 1702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            w.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.gUD.a(i2, i3, str, this);
    }
}
