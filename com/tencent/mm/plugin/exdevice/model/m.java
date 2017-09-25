package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.protocal.c.gi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends k implements j {
    private b gUA;
    private e gUD;
    private String ldA;
    private long ldB;
    private String ldy;
    private long ldz;

    public m(long j, String str, String str2, long j2) {
        this.ldz = j;
        this.ldA = str;
        this.ldy = str2;
        this.ldB = j2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            Object obj;
            gi giVar = (this.gUA == null || this.gUA.hsk.hsr == null) ? null : (gi) this.gUA.hsk.hsr;
            aen com_tencent_mm_protocal_c_aen = giVar.tjo;
            String str2 = null;
            String str3 = null;
            if (com_tencent_mm_protocal_c_aen != null) {
                str2 = com_tencent_mm_protocal_c_aen.jNm;
                str3 = com_tencent_mm_protocal_c_aen.thD;
            }
            w.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[]{str2, str3});
            if (ad.apt().bU(str3, str2) != null) {
                w.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{str3, Boolean.valueOf(ad.apt().bV(str2, str3))});
                if (ad.apt().bV(str2, str3)) {
                    obj = 1;
                } else {
                    obj = null;
                }
            } else {
                obj = 1;
            }
            c bVar = new com.tencent.mm.plugin.exdevice.h.b();
            bVar.field_connProto = this.ldy;
            bVar.field_connStrategy = 1;
            bVar.field_closeStrategy = 1;
            bVar.field_url = "";
            f.a(bVar, com_tencent_mm_protocal_c_aen, giVar.tjp);
            if (bVar.field_mac == 0) {
                w.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
                bVar.field_mac = this.ldz;
            }
            if (obj != null) {
                ad.apt().b(bVar);
            } else {
                ad.apt().e(bVar);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1262;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new gh();
        aVar.hsn = new gi();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
        aVar.hsl = 1262;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        gh ghVar = (gh) this.gUA.hsj.hsr;
        ghVar.mac = com.tencent.mm.plugin.exdevice.j.b.bH(this.ldz);
        ghVar.tkf = this.ldA;
        ghVar.tke = this.ldy;
        ghVar.tkg = this.ldB;
        return a(eVar, this.gUA, this);
    }
}
