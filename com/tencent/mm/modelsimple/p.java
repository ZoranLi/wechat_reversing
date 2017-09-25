package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class p extends k implements j {
    public final b gUA;
    private e gUD;

    public p(int i) {
        a aVar = new a();
        aVar.hsm = new anl();
        aVar.hsn = new anm();
        aVar.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        aVar.hsl = com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX;
        aVar.hso = 23;
        aVar.hsp = 1000000023;
        this.gUA = aVar.BE();
        ((anl) this.gUA.hsj.hsr).tLk = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        anm com_tencent_mm_protocal_c_anm = (anm) this.gUA.hsk.hsr;
        w.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + com_tencent_mm_protocal_c_anm.msI.size() + " group:" + com_tencent_mm_protocal_c_anm.tfz.size());
        Set hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_anm.tSo; i4++) {
            if (!hashSet.contains(((anp) com_tencent_mm_protocal_c_anm.msI.get(i4)).jNj)) {
                linkedList.add(com_tencent_mm_protocal_c_anm.msI.get(i4));
                hashSet.add(((anp) com_tencent_mm_protocal_c_anm.msI.get(i4)).jNj);
            }
        }
        com_tencent_mm_protocal_c_anm.msI = linkedList;
        com_tencent_mm_protocal_c_anm.tSo = linkedList.size();
        this.gUD.a(i2, i3, str, this);
    }
}
