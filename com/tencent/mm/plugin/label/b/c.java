package com.tencent.mm.plugin.label.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    private final b gUA;
    private e gUD;

    public c() {
        a aVar = new a();
        aVar.hsm = new xb();
        aVar.hsn = new xc();
        aVar.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        aVar.hsl = 639;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        int i4 = 0;
        w.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(209408, Long.valueOf(System.currentTimeMillis()));
            xc xcVar = (xc) this.gUA.hsk.hsr;
            if (!(xcVar == null || xcVar.teP == null)) {
                LinkedList linkedList = xcVar.teP;
                List arrayList = new ArrayList();
                int size = linkedList.size();
                while (i4 < size) {
                    aim com_tencent_mm_protocal_c_aim = (aim) linkedList.get(i4);
                    z zVar = new z();
                    zVar.field_labelID = com_tencent_mm_protocal_c_aim.tMv;
                    zVar.field_labelName = com_tencent_mm_protocal_c_aim.tMu;
                    zVar.field_labelPYFull = com.tencent.mm.platformtools.c.mp(com_tencent_mm_protocal_c_aim.tMu);
                    zVar.field_labelPYShort = com.tencent.mm.platformtools.c.mq(com_tencent_mm_protocal_c_aim.tMu);
                    arrayList.add(zVar);
                    i4++;
                }
                com.tencent.mm.plugin.label.e.aFF().bZ(arrayList);
                com.tencent.mm.plugin.label.e.aFF().ca(com.tencent.mm.plugin.label.e.aFF().cb(arrayList));
            }
        } else {
            w.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 639;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
