package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements j {
    public String chatroomName = null;
    public int fOw = 0;
    public final List<String> fPq;
    public final List<String> fPt;
    public final List<String> fPv;
    public final List<String> fPw;
    private final b gUA;
    private e gUD = null;
    public final List<String> ksL;
    public final List<String> ksM;
    public final List<String> ksN;

    public d(String str, List<String> list, String str2) {
        a aVar = new a();
        aVar.hsm = new bj();
        aVar.hsn = new bk();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroommember";
        aVar.hsl = 120;
        aVar.hso = 36;
        aVar.hsp = 1000000036;
        this.gUA = aVar.BE();
        bj bjVar = (bj) this.gUA.hsj.hsr;
        bjVar.teL = n.mw(str);
        this.chatroomName = str;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            all com_tencent_mm_protocal_c_all = new all();
            com_tencent_mm_protocal_c_all.ttv = n.mw(str3);
            linkedList.add(com_tencent_mm_protocal_c_all);
        }
        bjVar.teK = linkedList;
        bjVar.ksW = linkedList.size();
        this.ksL = new ArrayList();
        this.fPt = new LinkedList();
        this.ksM = new LinkedList();
        this.fPv = new LinkedList();
        this.fPw = new LinkedList();
        this.ksN = new ArrayList();
        this.fPq = list;
        bjVar.teN = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 120;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bj bjVar = (bj) this.gUA.hsj.hsr;
        bk bkVar = (bk) this.gUA.hsk.hsr;
        this.fOw = bkVar.ksW;
        List list = bkVar.teK;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int i5 = ((alm) list.get(i4)).tQk;
            if (i5 == 0) {
                this.ksL.add(n.a(((alm) list.get(i4)).ttv));
            } else if (i5 == 3) {
                w.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((alm) list.get(i4)).ttv);
                this.ksM.add(n.a(((alm) list.get(i4)).ttv));
            } else if (i5 == 1) {
                w.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((alm) list.get(i4)).ttv);
                this.fPv.add(n.a(((alm) list.get(i4)).ttv));
            } else if (i5 == 2) {
                w.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((alm) list.get(i4)).ttv);
                this.fPt.add(n.a(((alm) list.get(i4)).ttv));
            } else if (i5 == 4) {
                w.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((alm) list.get(i4)).ttv);
                this.fPw.add(n.a(((alm) list.get(i4)).ttv));
            } else if (i5 != 5) {
                if (i5 == 6) {
                    this.ksN.add(n.a(((alm) list.get(i4)).ttv));
                } else {
                    w.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = " + i5);
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.u.j.a(n.a(bjVar.teL), bkVar);
        }
    }
}
