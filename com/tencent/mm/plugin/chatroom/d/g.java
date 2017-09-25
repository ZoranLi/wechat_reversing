package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class g extends k implements j {
    public List<String> fPq;
    private b gUA;
    private e gUD;

    public g(String str, List<String> list) {
        this(str, list, 0);
    }

    public g(String str, List<String> list, int i) {
        a aVar = new a();
        aVar.hsm = new nc();
        aVar.hsn = new nd();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        aVar.hsl = 179;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        nc ncVar = (nc) this.gUA.hsj.hsr;
        ncVar.ttq = str;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            nl nlVar = new nl();
            nlVar.ttv = n.mw(str2);
            linkedList.add(nlVar);
        }
        ncVar.teK = linkedList;
        ncVar.ksW = linkedList.size();
        ncVar.tdM = i;
        this.fPq = list;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 179;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        nc ncVar = (nc) this.gUA.hsj.hsr;
        nd ndVar = (nd) this.gUA.hsk.hsr;
        if (this.gUA.hsk.sZC != 0) {
            this.gUD.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.u.j.a(ncVar.ttq, ndVar);
        this.gUD.a(i2, i3, str, this);
    }
}
