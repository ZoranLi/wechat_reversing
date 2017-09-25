package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axu;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class ac extends k implements j {
    private final b gUA;
    private e gUD;

    public ac(int[] iArr) {
        a aVar = new a();
        aVar.hsm = new axu();
        aVar.hsn = new axv();
        aVar.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        this.gUA = aVar.BE();
        LinkedList linkedList = new LinkedList();
        for (int valueOf : iArr) {
            linkedList.add(Integer.valueOf(valueOf));
        }
        ((axu) this.gUA.hsj.hsr).uam = linkedList;
        ((axu) this.gUA.hsj.hsr).ual = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 116;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
