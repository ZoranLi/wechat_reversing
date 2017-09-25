package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.ayp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.y.k implements j {
    private final b gUA;
    private e gUD;

    public k(List<b> list) {
        a aVar = new a();
        aVar.hsm = new ayo();
        aVar.hsn = new ayp();
        aVar.uri = "/cgi-bin/micromsg-bin/setapplist";
        aVar.hsl = 386;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ayo com_tencent_mm_protocal_c_ayo = (ayo) this.gUA.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        for (b bVar : list) {
            ag agVar = new ag();
            agVar.jNj = bVar.userName;
            linkedList.add(agVar);
        }
        com_tencent_mm_protocal_c_ayo.jNd = linkedList.size();
        com_tencent_mm_protocal_c_ayo.jNe = linkedList;
        w.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[]{Integer.valueOf(((ayp) this.gUA.hsk.hsr).tCa)});
            com.tencent.mm.plugin.brandservice.a.d(196610, Integer.valueOf(r0.tCa));
            com.tencent.mm.plugin.brandservice.a.d(196611, Boolean.valueOf(false));
        } else {
            com.tencent.mm.plugin.brandservice.a.d(196611, Boolean.valueOf(true));
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 386;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        return a(eVar, this.gUA, this);
    }
}
