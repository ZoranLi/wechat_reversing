package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements com.tencent.mm.y.d {
    public final b b(a aVar) {
        int i = 1;
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
        } else if (buVar.mtd != 56) {
            w.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(buVar.mtd)});
        } else {
            String a = n.a(buVar.tfd);
            String a2 = n.a(buVar.tfe);
            ap.yY();
            if (!((String) c.vr().get(2, null)).equals(a)) {
                a2 = a;
            }
            ap.yY();
            com.tencent.mm.j.a Rc = c.wR().Rc(a2);
            if (Rc == null || ((int) Rc.gTQ) == 0) {
                ap.yY();
                c.wR().R(new x(a2));
            }
            String a3 = n.a(buVar.tff);
            w.d("MicroMsg.TalkRoomExtension", "talkroom xml:" + a3);
            Map q = bh.q(a3, "talkroominfo");
            if (q != null) {
                try {
                    int i2;
                    String str;
                    String aM;
                    if (Hq((String) q.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        Hq((String) q.get(".talkroominfo.sysmsgtype"));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    Object linkedList = new LinkedList();
                    Hq((String) q.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        str = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        a3 = (String) q.get(str + ".username");
                        if (bg.mA(a3)) {
                            break;
                        }
                        int Hq = Hq((String) q.get(str + ".memberid"));
                        beu com_tencent_mm_protocal_c_beu = new beu();
                        com_tencent_mm_protocal_c_beu.jNj = a3;
                        com_tencent_mm_protocal_c_beu.ufr = Hq;
                        linkedList.add(com_tencent_mm_protocal_c_beu);
                        i3++;
                    }
                    if (a2.equals(b.bnB().qYD)) {
                        str = aL(linkedList);
                        aM = bg.mA(str) ? aM(linkedList) : null;
                    } else {
                        aM = null;
                        str = null;
                    }
                    e bnC = b.bnC();
                    if (i2 != 0) {
                        i = 0;
                    }
                    bnC.a(a2, linkedList, str, aM, i);
                } catch (Throwable e) {
                    w.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    w.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }

    private static int Hq(String str) {
        int i = 0;
        if (!bg.mA(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[i]);
            }
        }
        return i;
    }

    private static String aL(List<beu> list) {
        List<beu> aGm = b.bnB().aGm();
        List linkedList = new LinkedList();
        for (beu com_tencent_mm_protocal_c_beu : list) {
            Object obj;
            for (beu com_tencent_mm_protocal_c_beu2 : aGm) {
                if (com_tencent_mm_protocal_c_beu2.jNj.equals(com_tencent_mm_protocal_c_beu.jNj)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(com_tencent_mm_protocal_c_beu.jNj);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(m.xL())) {
                return str;
            }
        }
        return null;
    }

    private static String aM(List<beu> list) {
        List<beu> aGm = b.bnB().aGm();
        List linkedList = new LinkedList();
        for (beu com_tencent_mm_protocal_c_beu : aGm) {
            Object obj;
            for (beu com_tencent_mm_protocal_c_beu2 : list) {
                if (com_tencent_mm_protocal_c_beu2.jNj.equals(com_tencent_mm_protocal_c_beu.jNj)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(com_tencent_mm_protocal_c_beu.jNj);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(m.xL())) {
                return str;
            }
        }
        return null;
    }
}
