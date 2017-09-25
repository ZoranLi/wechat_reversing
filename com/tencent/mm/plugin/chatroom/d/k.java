package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.agc;
import com.tencent.mm.protocal.c.agd;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.y.k implements j {
    public au fTk;
    private final b gUA;
    private e gUD;
    public int ksW;

    public k(String str, List<String> list) {
        a aVar = new a();
        aVar.hsm = new agc();
        aVar.hsn = new agd();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.gUA = aVar.BE();
        agc com_tencent_mm_protocal_c_agc = (agc) this.gUA.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            all com_tencent_mm_protocal_c_all = new all();
            com_tencent_mm_protocal_c_all.ttv = n.mw(str2);
            linkedList.add(com_tencent_mm_protocal_c_all);
        }
        com_tencent_mm_protocal_c_agc.teK = linkedList;
        com_tencent_mm_protocal_c_agc.ksW = linkedList.size();
        com_tencent_mm_protocal_c_agc.teL = n.mw(str);
        com_tencent_mm_protocal_c_agc.tLh = 0;
    }

    public k(String str, List<String> list, String str2, au auVar) {
        this.fTk = auVar;
        a aVar = new a();
        aVar.hsm = new agc();
        aVar.hsn = new agd();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.gUA = aVar.BE();
        agc com_tencent_mm_protocal_c_agc = (agc) this.gUA.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            all com_tencent_mm_protocal_c_all = new all();
            com_tencent_mm_protocal_c_all.ttv = n.mw(str3);
            linkedList.add(com_tencent_mm_protocal_c_all);
        }
        this.ksW = linkedList.size();
        com_tencent_mm_protocal_c_agc.teK = linkedList;
        com_tencent_mm_protocal_c_agc.ksW = linkedList.size();
        com_tencent_mm_protocal_c_agc.teL = n.mw(str);
        com_tencent_mm_protocal_c_agc.tLh = 2;
        com_tencent_mm_protocal_c_agc.tLi = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 610;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gUD.a(i2, i3, str, this);
    }
}
