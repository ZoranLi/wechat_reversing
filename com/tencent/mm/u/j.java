package com.tencent.mm.u;

import com.tencent.mm.a.f;
import com.tencent.mm.e.a.ao;
import com.tencent.mm.e.a.ap;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.chatroom.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.x.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class j {
    public static f<String, String> hln = new f(100);

    public static boolean es(String str) {
        q fV = ((a) h.h(a.class)).xa().fV(str);
        return fV == null ? false : fV.bKX();
    }

    public static boolean a(String str, Map<String, String> map) {
        q fV = ((a) h.h(a.class)).xa().fV(str);
        if (fV == null) {
            return false;
        }
        for (String str2 : fV.DU()) {
            map.put(str2, fV.eK(str2));
        }
        return true;
    }

    public static boolean et(String str) {
        String fX = ((a) h.h(a.class)).xa().fX(str);
        String xL = m.xL();
        if (bg.mA(fX) || bg.mA(xL) || !fX.equals(xL)) {
            return false;
        }
        return true;
    }

    public static void a(String str, q qVar, boolean z) {
        qVar.jX(z);
        ((a) h.h(a.class)).xa().c(qVar, new String[0]);
        String xL = m.xL();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amb = new amb();
        com_tencent_mm_protocal_c_amb.ttq = str;
        com_tencent_mm_protocal_c_amb.jNj = xL;
        com_tencent_mm_protocal_c_amb.tQD = 1;
        com_tencent_mm_protocal_c_amb.oTE = z ? 1 : 2;
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(49, com_tencent_mm_protocal_c_amb));
    }

    public static String s(List<String> list) {
        return b(list, -1);
    }

    public static String b(List<String> list, int i) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < list.size()) {
            String str2 = (String) list.get(i3);
            if (str2.length() > 0) {
                str2 = str + ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str2).tL();
                if (i3 == i2 && i3 < list.size()) {
                    return str2 + "...";
                }
                if (i3 < list.size() - 1) {
                    str2 = str2 + ab.getContext().getString(c.a.dTc);
                }
            } else {
                str2 = str;
            }
            i3++;
            str = str2;
        }
        return str;
    }

    public static boolean eu(String str) {
        String str2 = (String) h.vI().vr().get(2, null);
        List eA = eA(str);
        if (eA == null) {
            w.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
            return false;
        } else if (eA.size() != 0 && eA.contains(str2)) {
            return true;
        } else {
            w.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + eA.size() + " ");
            return false;
        }
    }

    public static boolean ev(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        if (((a) h.h(a.class)).xa().ga(str)) {
            List fZ = ((a) h.h(a.class)).xa().fZ(str);
            if (fZ == null || fZ.size() == 0) {
                return true;
            }
            return false;
        }
        w.d("MicroMsg.ChatroomMembersLogic", "state is die");
        return true;
    }

    public static boolean ew(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        w.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", str);
        aa xa = ((a) h.h(a.class)).xa();
        com.tencent.mm.sdk.e.c fV = xa.fV(str);
        if (fV == null) {
            return false;
        }
        fV.field_roomflag = 1;
        return xa.a(fV);
    }

    public static boolean a(String str, String str2, jy jyVar, String str3, com.tencent.mm.g.a.a.a aVar, b bVar) {
        if ((str.toLowerCase().endsWith("@chatroom") || str.toLowerCase().endsWith("@groupcard") || str.toLowerCase().endsWith("@talkroom")) && jyVar.ksW != 0) {
            ar wR = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
            q fV = ((a) h.h(a.class)).xa().fV(str);
            if (fV != null) {
                aVar.fPC = fV.bKS();
            }
            List arrayList = new ArrayList();
            w.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] memCnt:" + jyVar.ksW);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            for (int i = 0; i < jyVar.ksW; i++) {
                jz jzVar = (jz) jyVar.tpX.get(i);
                af Rc = wR.Rc(jzVar.jNj);
                if (Rc == null) {
                    w.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
                } else {
                    com.tencent.mm.g.a.a.b bVar2 = new com.tencent.mm.g.a.a.b();
                    bVar2.userName = jzVar.jNj;
                    bVar2.gMZ = jzVar.tqe;
                    if (jyVar.tpY == 0) {
                        bVar2.gMX = jzVar.tqa;
                        bVar2.gMY = jzVar.tqd;
                        if (!bg.mA(jzVar.tqc)) {
                            com.tencent.mm.x.h hs = n.Bm().hs(jzVar.jNj);
                            if (hs == null) {
                                hs = new com.tencent.mm.x.h();
                                hs.username = jzVar.jNj;
                            }
                            hs.hrB = jzVar.tqb;
                            hs.hrA = jzVar.tqc;
                            hs.gkq = 3;
                            hs.aV(!bg.mA(jzVar.tqb));
                            n.Bm().a(hs);
                        }
                    }
                    if (fV != null) {
                        com.tencent.mm.g.a.a.b QI = fV.QI(jzVar.jNj);
                        if (QI != null) {
                            bVar2.gMX = QI.gMX;
                            bVar2.gMY = QI.gMY;
                            bVar2.gMZ = QI.gMZ;
                        }
                    }
                    aVar.gMT.add(bVar2);
                    if (((int) Rc.gTQ) == 0) {
                        Rc.setUsername(jzVar.jNj);
                        if (jzVar.jOp != null) {
                            Rc.bR(jzVar.jOp);
                        }
                        Rc.tb();
                        wR.R(Rc);
                        z = true;
                    }
                    arrayList.add(Rc.field_username);
                }
            }
            w.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + arrayList.size() + " event: " + bVar + " publish: " + z + " take[" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
            if (z) {
                com.tencent.mm.sdk.b.a.urY.m(bVar);
            } else if (fV != null) {
                q.bKU();
            } else {
                w.i("MicroMsg.ChatroomMembersLogic", "ChatroomId:%s is Need Update All InviteerInfo ", str);
                ((jh) bVar).fPB.fPC = 0;
                com.tencent.mm.sdk.b.a.urY.m(bVar);
            }
            q fV2 = ((a) h.h(a.class)).xa().fV(str);
            if (fV2 == null) {
                fV2 = new q();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            fV2.field_chatroomname = str;
            fV2.field_roomowner = str2;
            q bX = fV2.bX(arrayList);
            bX.field_displayname = s(arrayList);
            bX.a(str3, aVar, jyVar.tpY != 0);
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            w.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s", Boolean.valueOf(a(fV2)), Long.valueOf(currentTimeMillis2));
            if (fV2.bKT()) {
                w.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", Integer.valueOf(fV2.bKS()));
                b aoVar = new ao();
                aoVar.fDW.username = str;
                com.tencent.mm.sdk.b.a.urY.m(aoVar);
            }
            return r3;
        }
        w.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] listCnt:" + jyVar.ksW);
        return false;
    }

    public static boolean a(String str, jy jyVar) {
        if (jyVar == null) {
            w.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
            return false;
        } else if (bg.mA(str)) {
            w.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
            return false;
        } else if (o.dH(str)) {
            w.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", str);
            return false;
        } else {
            String a = com.tencent.mm.platformtools.n.a(jyVar.tpZ);
            if (bg.mA(a)) {
                w.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
                return false;
            }
            w.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", a, Integer.valueOf(jyVar.tpX.size()));
            q fV = ((a) h.h(a.class)).xa().fV(a);
            if (fV != null && jyVar.tpX.size() > 0 && fV.DU().contains(((jz) jyVar.tpX.get(0)).jNj)) {
                com.tencent.mm.g.a.a.b QI = fV.QI(((jz) jyVar.tpX.get(0)).jNj);
                if (QI != null) {
                    w.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", r0, QI.gMX);
                    QI.gMZ = ((jz) jyVar.tpX.get(0)).tqe;
                    a(fV);
                } else {
                    w.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", r0);
                }
                return true;
            } else if (fV == null || jyVar.tpX.size() <= 0) {
                if (jyVar.tpX.size() <= 0) {
                    w.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
                }
                if (fV != null) {
                    w.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
                }
                return false;
            } else {
                b apVar = new ap();
                apVar.fDX.username = ((jz) jyVar.tpX.get(0)).jNj;
                apVar.fDX.fDY = ((jz) jyVar.tpX.get(0)).tqe;
                hln.put(a + "#" + apVar.fDX.username, apVar.fDX.fDY);
                com.tencent.mm.sdk.b.a.urY.m(apVar);
                return false;
            }
        }
    }

    public static String C(String str, String str2) {
        String str3 = str2 + "#" + str;
        if (hln.bu(str3)) {
            return (String) hln.get(str3);
        }
        return "";
    }

    public static boolean a(q qVar) {
        if (qVar == null) {
            w.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
            return false;
        }
        boolean a = ((a) h.h(a.class)).xa().a(qVar);
        if (a) {
            String str = qVar.field_chatroomname;
            String str2 = qVar.field_roomowner;
            w.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", Integer.valueOf(1));
            ar wR = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
            com.tencent.mm.j.a Rc = wR.Rc(str);
            if (!(((int) Rc.gTQ) == 0 || bg.mA(str2) || bg.mA(m.xL()))) {
                if (str2.equals(m.xL())) {
                    Rc.eA(1);
                } else {
                    Rc.eA(0);
                }
                wR.a(str, Rc);
            }
        }
        return a;
    }

    public static boolean a(String str, nd ndVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || ndVar.ksW == 0) {
            w.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + str + "] listCnt:" + ndVar.ksW);
            return false;
        }
        aa xa = ((a) h.h(a.class)).xa();
        com.tencent.mm.sdk.e.c fV = xa.fV(str);
        List QK = q.QK(fV.field_memberlist);
        w.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + QK.size());
        Iterator it = ndVar.teK.iterator();
        while (it.hasNext()) {
            QK.remove(com.tencent.mm.platformtools.n.a(((nm) it.next()).ttv));
        }
        w.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + QK.size());
        fV.bX(QK).field_displayname = s(QK);
        boolean a = xa.a(fV);
        w.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember " + a);
        return a;
    }

    public static boolean a(String str, bk bkVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || bkVar.ksW == 0) {
            w.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + str + "] listCnt:" + bkVar.ksW);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ar wR = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
        for (int i = 0; i < bkVar.ksW; i++) {
            String a = com.tencent.mm.platformtools.n.a(((alm) bkVar.teK.get(i)).ttv);
            if (((alm) bkVar.teK.get(i)).tQk == 0) {
                if (bg.mA(a)) {
                    w.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", str);
                } else {
                    af afVar;
                    x Rc = wR.Rc(a);
                    if (((int) Rc.gTQ) != 0) {
                        Rc.tb();
                        wR.a(Rc.field_username, Rc);
                        afVar = Rc;
                    } else {
                        afVar = a(Rc, (alm) bkVar.teK.get(i));
                        wR.R(afVar);
                    }
                    arrayList.add(afVar.field_username);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return a(str, arrayList, null);
    }

    public static boolean ex(String str) {
        if (str.toLowerCase().endsWith("@groupcard")) {
            ar wR = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
            if (wR.Re(str)) {
                wR.Ri(str);
            } else {
                w.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + str + "]");
            }
            return ez(str);
        }
        w.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + str + "]");
        return false;
    }

    public static boolean ey(String str) {
        if (str.toLowerCase().endsWith("@chatroom")) {
            ar wR = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
            if (wR.Re(str)) {
                wR.Ri(str);
            } else {
                w.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + str + "]");
            }
            return ez(str);
        }
        w.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + str + "]");
        return false;
    }

    public static boolean a(String str, ArrayList<String> arrayList, String str2) {
        List eA;
        int i = 0;
        aa xa = ((a) h.h(a.class)).xa();
        com.tencent.mm.sdk.e.c fW = xa.fW(str);
        if (str.endsWith("@chatroom")) {
            eA = eA(str);
        } else {
            eA = new LinkedList();
        }
        List linkedList = new LinkedList();
        if (eA != null) {
            for (int i2 = 0; i2 < eA.size(); i2++) {
                linkedList.add(eA.get(i2));
            }
            while (i < arrayList.size()) {
                if (!eA.contains(arrayList.get(i))) {
                    linkedList.add(arrayList.get(i));
                }
                i++;
            }
            if (!bg.mA(str2)) {
                fW.field_roomowner = str2;
            }
            fW.bX(linkedList).field_displayname = s(linkedList);
            return xa.a(fW);
        }
        while (i < arrayList.size()) {
            linkedList.add(arrayList.get(i));
            i++;
        }
        if (!bg.mA(str2)) {
            fW.field_roomowner = str2;
        }
        fW.bX(linkedList).field_displayname = s(linkedList);
        fW.field_roomowner = str2;
        boolean a = xa.a(fW);
        w.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName " + a);
        return a;
    }

    private static boolean ez(String str) {
        return ((a) h.h(a.class)).xa().gb(str);
    }

    public static List<String> eA(String str) {
        if (str == null) {
            w.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
            return null;
        } else if (str.toLowerCase().endsWith("@chatroom")) {
            return ((a) h.h(a.class)).xa().fZ(str);
        } else {
            w.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + str + "]");
            return null;
        }
    }

    public static List<String> eB(String str) {
        if (str.toLowerCase().endsWith("@chatroom")) {
            return ((a) h.h(a.class)).xa().fZ(str);
        }
        w.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static int eC(String str) {
        List eA = eA(str);
        if (eA != null) {
            return eA.size();
        }
        w.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: get room:[" + str + "] members count fail");
        return 0;
    }

    public static List<String> eD(String str) {
        int i = 0;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List<String> eA = eA(str);
            if (eA == null || eA.size() <= 0) {
                return null;
            }
            String str2 = (String) h.vI().vr().get(2, null);
            boolean z = str2 != null && str2.length() > 0;
            Assert.assertTrue(z);
            while (i < eA.size()) {
                if (((String) eA.get(i)).equals(str2)) {
                    eA.remove(i);
                    break;
                }
                i++;
            }
            if (eA.size() <= 0) {
                return null;
            }
            return eA;
        }
        w.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static x a(x xVar, alm com_tencent_mm_protocal_c_alm) {
        xVar.setUsername(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_alm.ttv));
        xVar.bR(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_alm.ttv));
        xVar.bS(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_alm.ttv));
        xVar.bT(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_alm.ttg));
        xVar.di(com_tencent_mm_protocal_c_alm.hAD);
        xVar.bP(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_alm.tQl));
        xVar.bW(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_alm.tQm));
        xVar.bV(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_alm.ttg));
        xVar.dl(com_tencent_mm_protocal_c_alm.tsD);
        xVar.dn(com_tencent_mm_protocal_c_alm.hAH);
        xVar.ck(RegionCodeDecoder.ab(com_tencent_mm_protocal_c_alm.hAM, com_tencent_mm_protocal_c_alm.hAE, com_tencent_mm_protocal_c_alm.hAF));
        xVar.ce(com_tencent_mm_protocal_c_alm.hAG);
        return xVar;
    }

    public static String D(String str, String str2) {
        q fV = ((a) h.h(a.class)).xa().fV(str2);
        if (fV == null) {
            return null;
        }
        return fV.eK(str);
    }

    public static String eE(String str) {
        q fV = ((a) h.h(a.class)).xa().fV(str);
        if (fV == null) {
            return null;
        }
        return fV.field_chatroomnotice;
    }

    public static boolean q(String str, int i) {
        q fV = ((a) h.h(a.class)).xa().fV(str);
        if (fV == null) {
            return false;
        }
        return fV.field_chatroomVersion < i;
    }

    public static String eF(String str) {
        q fV = ((a) h.h(a.class)).xa().fV(str);
        if (fV == null) {
            return null;
        }
        return fV.field_chatroomnoticeEditor;
    }

    public static long eG(String str) {
        q fV = ((a) h.h(a.class)).xa().fV(str);
        if (fV == null) {
            return -1;
        }
        return fV.field_chatroomnoticePublishTime;
    }

    public static void a(String str, String str2, String str3, long j, int i) {
        aa xa = ((a) h.h(a.class)).xa();
        com.tencent.mm.sdk.e.c fV = xa.fV(str);
        if (fV != null) {
            fV.field_chatroomVersion = i;
            fV.field_chatroomnoticePublishTime = j;
            fV.field_chatroomnoticeEditor = str3;
            fV.field_chatroomnotice = str2;
            xa.a(fV);
        }
    }

    public static void r(String str, int i) {
        aa xa = ((a) h.h(a.class)).xa();
        com.tencent.mm.sdk.e.c fV = xa.fV(str);
        if (fV != null) {
            com.tencent.mm.g.a.a.a bKY = fV.bKY();
            bKY.type = i;
            fV.a(str, bKY, false);
            xa.a(fV);
        }
    }
}
