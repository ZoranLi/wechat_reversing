package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ai extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;
    public com.tencent.mm.bd.b kge;
    public boolean kgf;

    public ai(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, com.tencent.mm.bd.b bVar) {
        a aVar = new a();
        aVar.hsm = new um();
        aVar.hsn = new un();
        aVar.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        aVar.hsl = 664;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        um umVar = (um) this.gUA.hsj.hsr;
        umVar.kdK = str;
        umVar.knM = i;
        umVar.knN = str2;
        umVar.knO = str3;
        umVar.time_stamp = i2;
        umVar.knP = str4;
        umVar.kdE = str5;
        umVar.knQ = str6;
        umVar.kge = bVar;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            umVar.tCp = 1;
        } else {
            umVar.tCp = 0;
        }
    }

    public final int getType() {
        return 664;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            un unVar = (un) this.gUA.hsk.hsr;
            this.kfG = unVar.kfG;
            this.kge = unVar.kge;
            this.kgf = unVar.tCq != 0;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
