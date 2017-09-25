package com.tencent.mm.modelfriend;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.ayc;
import com.tencent.mm.protocal.c.ayd;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class z extends k implements j {
    private final b gUA;
    private e gUD = null;

    public z(String str, List<String> list) {
        a aVar = new a();
        aVar.hsm = new ayc();
        aVar.hsn = new ayd();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
        aVar.hsl = 432;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ayc com_tencent_mm_protocal_c_ayc = (ayc) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ayc.tuo = str;
        com_tencent_mm_protocal_c_ayc.tNl = new LinkedList();
        com_tencent_mm_protocal_c_ayc.tNk = list.size();
        for (String str2 : list) {
            if (!bg.mA(str2)) {
                com_tencent_mm_protocal_c_ayc.tNl.add(new avx().OV(str2));
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 432;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
