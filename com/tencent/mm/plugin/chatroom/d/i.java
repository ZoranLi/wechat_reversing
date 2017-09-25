package com.tencent.mm.plugin.chatroom.d;

import android.util.Pair;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class i extends k implements j {
    private final String chatroomName;
    private final b gUA;
    private e gUD = null;

    public i(String str, int i) {
        int i2;
        a aVar = new a();
        aVar.hsm = new wv();
        aVar.hsn = new ww();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        aVar.hsl = 551;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.chatroomName = str;
        ap.yY();
        int bKS = c.xa().fW(str).bKS();
        ((wv) this.gUA.hsj.hsr).tDB = str;
        wv wvVar = (wv) this.gUA.hsj.hsr;
        if (bKS < i) {
            i2 = i;
        } else {
            i2 = bKS;
        }
        wvVar.tiC = i2;
        w.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(bKS), bg.bJZ()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 551;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
            ww wwVar = (ww) this.gUA.hsk.hsr;
            ap.yY();
            com.tencent.mm.sdk.e.c fW = c.xa().fW(this.chatroomName);
            long bKS = (long) fW.bKS();
            long j = 4294967295L & ((long) wwVar.jNa);
            String str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str3 = "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(wwVar.jNa);
            objArr[1] = Integer.valueOf(wwVar.tDC == null ? 0 : wwVar.tDC.ksW);
            objArr[2] = Long.valueOf(bKS);
            w.i(str2, str3, objArr);
            if (bKS >= j) {
                w.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[]{Long.valueOf(bKS), Long.valueOf(j)});
                this.gUD.a(i2, i3, str, this);
                return;
            }
            int i4 = wwVar.jNa;
            if (fW.b(fW.uyW)) {
                fW.bKR();
            }
            fW.uyW.fPC = i4;
            try {
                fW.field_roomdata = fW.uyW.toByteArray();
            } catch (Throwable e) {
                w.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[]{bg.g(e)});
            }
            q.bKU();
            String xL = m.xL();
            List<jz> list = wwVar.tDC.tpX;
            if (fW.b(fW.uyW)) {
                fW.bKR();
            }
            for (jz jzVar : list) {
                if (fW.hwI.containsKey(jzVar.jNj)) {
                    com.tencent.mm.g.a.a.b bVar = (com.tencent.mm.g.a.a.b) fW.hwI.get(jzVar.jNj);
                    bVar.gMX = jzVar.tqa;
                    bVar.gMY = jzVar.tqd;
                    bVar.gMZ = jzVar.tqe;
                }
            }
            fW.uyW.gMT.clear();
            for (String str4 : fW.hwI.keySet()) {
                fW.uyW.gMT.add(fW.hwI.get(str4));
            }
            fW.a(xL, fW.uyW, false);
            ap.yY();
            c.xa().a(fW);
            ap.yY();
            final ar wR = c.wR();
            final com.tencent.mm.x.i Bm = n.Bm();
            final LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            list = wwVar.tDC.tpX;
            str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str5 = "summerChatRoom memInfoList size[%d]";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(list == null ? -1 : list.size());
            w.i(str2, str5, objArr2);
            for (jz jzVar2 : list) {
                if (!(bg.mA(jzVar2.tqc) || bg.mA(jzVar2.jNj))) {
                    h hs = Bm.hs(jzVar2.jNj);
                    if (hs == null) {
                        hs = new h();
                        hs.username = jzVar2.jNj;
                    } else {
                        hs.Bt().equals(jzVar2.tqc);
                    }
                    hs.hrB = jzVar2.tqb;
                    hs.hrA = jzVar2.tqc;
                    hs.gkq = 3;
                    hs.aV(!bg.mA(jzVar2.tqb));
                    linkedList2.add(hs);
                }
                x Rc = wR.Rc(jzVar2.jNj);
                if (Rc == null) {
                    w.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (Rc.tz()) {
                    Rc.bR(jzVar2.jOp);
                    linkedList.add(new Pair(jzVar2.jNj, Rc));
                }
            }
            w.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList.size())});
            if (!linkedList2.isEmpty()) {
                new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
                    final /* synthetic */ i ksT;

                    public final boolean oQ() {
                        int size = linkedList2.size() < 25 ? linkedList2.size() : 25;
                        w.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            w.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
                            return false;
                        } else if (linkedList2.isEmpty()) {
                            w.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ap.yY();
                            long cs = c.wO().cs(Thread.currentThread().getId());
                            for (int i = 0; i < size; i++) {
                                Bm.a((h) linkedList2.poll());
                            }
                            ap.yY();
                            c.wO().aD(cs);
                            w.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (!linkedList2.isEmpty()) {
                                return true;
                            }
                            w.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        }
                    }
                }, true).v(100, 100);
            }
            if (!linkedList.isEmpty()) {
                new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
                    final /* synthetic */ i ksT;

                    public final boolean oQ() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        w.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            w.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        ap.yY();
                        long cs = c.wO().cs(Thread.currentThread().getId());
                        for (int i = 0; i < size; i++) {
                            Pair pair = (Pair) linkedList.poll();
                            wR.a((String) pair.first, (x) pair.second);
                        }
                        ap.yY();
                        c.wO().aD(cs);
                        w.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (!linkedList.isEmpty()) {
                            return true;
                        }
                        w.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
                        return false;
                    }
                }, true).v(100, 100);
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }
}
