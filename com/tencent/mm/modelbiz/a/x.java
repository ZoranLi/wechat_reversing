package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.protocal.c.bgh;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class x extends k implements j {
    Object data;
    public b gUA;
    private e gUD;

    public x(String str, String str2, gt gtVar, gt gtVar2, Object obj) {
        a aVar = new a();
        aVar.hsm = new bgg();
        aVar.hsn = new bgh();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
        this.gUA = aVar.BE();
        bgg com_tencent_mm_protocal_c_bgg = (bgg) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgg.tkL = str;
        com_tencent_mm_protocal_c_bgg.tkF = str2;
        com_tencent_mm_protocal_c_bgg.ugB = gtVar;
        com_tencent_mm_protocal_c_bgg.ugC = gtVar2;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1357;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
        return a(eVar, this.gUA, this);
    }
}
