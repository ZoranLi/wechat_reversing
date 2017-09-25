package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.tt;
import com.tencent.mm.protocal.c.tu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends k implements j {
    private final b gUA;
    private e gUD;
    LinkedList<String> jZi;

    public f() {
        a aVar = new a();
        aVar.hsm = new tt();
        aVar.hsn = new tu();
        aVar.uri = "/cgi-bin/micromsg-bin/getapplist";
        aVar.hsl = 387;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.jZi = new LinkedList();
        tt ttVar = (tt) this.gUA.hsj.hsr;
        ap.yY();
        Object obj = c.vr().get(196610, null);
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "get config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(196610);
        objArr[1] = obj == null ? "null" : obj.toString();
        w.i(str, str2, objArr);
        ttVar.tCa = bg.a((Integer) obj, 0);
        w.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[]{Integer.valueOf(ttVar.tCa)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            tu tuVar = (tu) this.gUA.hsk.hsr;
            w.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[]{Integer.valueOf(tuVar.tCa), Integer.valueOf(tuVar.jNd)});
            w.i("MicroMsg.BrandService.NetSceneGetAppList", "result list is %s", new Object[]{tuVar.jNe.toString()});
            com.tencent.mm.plugin.brandservice.a.d(196610, Integer.valueOf(tuVar.tCa));
            Iterator it = tuVar.jNe.iterator();
            while (it.hasNext()) {
                this.jZi.add(((ag) it.next()).jNj);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 387;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        return a(eVar, this.gUA, this);
    }
}
