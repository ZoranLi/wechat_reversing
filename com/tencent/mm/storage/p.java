package com.tencent.mm.storage;

import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.o;
import java.util.Iterator;

public final class p implements d, e {
    private as uyU;

    public p(as asVar) {
        w.DT();
        this.uyU = asVar;
        this.uyU.a((e) this);
        this.uyU.a((d) this);
    }

    public final void a(au auVar, ae aeVar) {
        String str = null;
        if (aeVar != null && auVar != null && auVar.field_bizChatId != -1 && aeVar.eC(8388608)) {
            c aa = w.DJ().aa(auVar.field_bizChatId);
            String str2 = aeVar.field_digest;
            if (bg.mA(auVar.field_bizChatUserId)) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", aa.field_bizChatServId, aa.field_chatName);
                return;
            }
            String str3;
            j iD = w.DL().iD(auVar.field_bizChatUserId);
            if (iD != null) {
                str3 = iD.field_userName;
            } else {
                str3 = null;
            }
            boolean equals = auVar.field_bizChatUserId.equals(w.DL().iF(auVar.field_talker));
            if (iD != null && equals) {
                aeVar.cu(ab.getContext().getString(b.dHC) + ":" + str2);
            } else if (!(iD == null || bg.mA(iD.field_userName))) {
                aeVar.cu(iD.field_userName + ":" + str2);
            }
            if (!aa.DV()) {
                if (equals || str3 == null || str3.length() <= 0 || str3.equals(aa.field_chatName)) {
                    j iD2 = w.DL().iD(aa.field_bizChatServId);
                    if (iD2 != null) {
                        str = iD2.field_userName;
                    }
                    if (str != null && str.length() > 0 && !str.equals(aa.field_chatName)) {
                        aa.field_chatName = str;
                        w.DJ().b(aa);
                        return;
                    }
                    return;
                }
                aa.field_chatName = str3;
                w.DJ().b(aa);
            }
        }
    }

    public final void a(au auVar, ae aeVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        if (cVar == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
            return;
        }
        String str = cVar.fJL;
        if (z) {
            if (!(auVar == null || auVar.field_isSend == 1 || (ba.k(auVar) & 1) == 0)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                aeVar.eB(4194304);
            }
            if (auVar != null && com.tencent.mm.modelbiz.e.dr(str)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                aeVar.eB(8388608);
            }
        } else {
            af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
            if (!(Rc == null || !Rc.bLe() || a.ez(Rc.field_type) || auVar == null || auVar.field_isSend == 1 || aeVar.eC(4194304) || (aeVar.field_conversationTime >= w.DT() && (ba.k(auVar) & 1) == 0))) {
                aeVar.eB(4194304);
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", str);
            }
            if (auVar != null && com.tencent.mm.modelbiz.e.dr(str)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", str);
                aeVar.eB(8388608);
            }
        }
        if (cVar != null && !cVar.nyP.isEmpty() && cVar.nyP.get(0) != null) {
            aeVar.dw(((au) cVar.nyP.get(0)).field_isSend);
            if (cVar.nyO.equals("insert")) {
                aeVar.uIU = (au) cVar.nyP.get(cVar.nyP.size() - 1);
            }
        }
    }

    public final void b(au auVar, ae aeVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        int i;
        int i2;
        as wW = ((h) com.tencent.mm.kernel.h.h(h.class)).wW();
        String str = cVar.fJL;
        if (cVar == null || !cVar.nyO.equals("delete") || cVar.nyS <= 0) {
            i = 0;
        } else {
            i = cVar.nyS;
        }
        if (cVar == null || !cVar.nyO.equals("insert") || cVar.nyR <= 0) {
            i2 = 0;
        } else {
            i2 = cVar.nyR;
        }
        if (!bg.mA(aeVar.field_parentRef)) {
            ae Rm = wW.Rm(aeVar.field_parentRef);
            if (Rm != null && Rm.eC(2097152)) {
                if (i2 > 0) {
                    if ((cVar.nyO.equals("insert") && cVar.nyQ > 0) || (cVar.nyO.equals("update") && Rm.field_unReadCount + cVar.nyQ >= 0)) {
                        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
                        if (Rc == null || !Rc.tD()) {
                            Rm.dt(Rm.field_unReadCount + i2);
                        } else {
                            Rm.dA(Rm.field_unReadMuteCount + i2);
                        }
                    }
                    wW.a(aeVar, i, i2);
                }
                au Ai = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ai(((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rx(aeVar.field_parentRef));
                if (Ai == null || Ai.field_msgId <= 0) {
                    Rm.bLB();
                } else {
                    Rm.W(Ai);
                    Rm.setContent(Ai.field_talker + ":" + Ai.field_content);
                    Rm.ct(Integer.toString(Ai.field_type));
                    if (wW.oG() != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Ai.cH(aeVar.field_parentRef);
                        Ai.setContent(Rm.field_content);
                        wW.oG().a(Ai, pString, pString2, pInt, true);
                        String aA = wW.aA(Ai.field_type, Ai.field_content);
                        Rm.cu(bg.mz(pString.value).concat(bg.mA(aA) ? "" : " " + bg.mz(aA)));
                        Rm.cv(pString2.value);
                        Rm.dx(pInt.value);
                    }
                }
                if (wW.a(Rm, aeVar.field_parentRef) > 0) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", aeVar.field_parentRef, Integer.valueOf(Rm.field_unReadCount + i2));
                    wW.b(3, (m) wW, aeVar.field_parentRef);
                }
            } else if (Rm == null || !"officialaccounts".equals(Rm.field_username)) {
                if (Rm != null && "appbrandcustomerservicemsg".equals(Rm.field_username) && i2 > 0) {
                    if ((cVar.nyO.equals("insert") && cVar.nyQ > 0) || (cVar.nyO.equals("update") && Rm.field_unReadCount + cVar.nyQ >= 0)) {
                        Rm.dt(Rm.field_unReadCount + i2);
                    }
                    wW.a(aeVar, i, i2);
                    wW.a(Rm, aeVar.field_parentRef);
                }
            } else if (i2 > 0 && ((cVar.nyO.equals("insert") && cVar.nyQ > 0) || (cVar.nyO.equals("update") && Rm.field_unReadCount + cVar.nyQ >= 0))) {
                Rm.dt(Rm.field_unReadCount + i2);
                wW.a(Rm, aeVar.field_parentRef);
            }
        }
        a(str, aeVar, i2, i, cVar);
    }

    private void a(String str, ae aeVar, int i, int i2, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        if (aeVar != null && cVar != null && cVar.kbc != -1 && aeVar.eC(8388608)) {
            au ac = ((n) com.tencent.mm.kernel.h.h(n.class)).wU().ac(str, cVar.kbc);
            com.tencent.mm.modelbiz.a.a U = w.DK().U(cVar.kbc);
            c aa = w.DJ().aa(cVar.kbc);
            if (aa.field_bizChatServId == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
            } else if (ac == null || ac.field_msgId == 0) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker " + str);
                U.field_status = 0;
                U.field_isSend = 0;
                U.field_content = "";
                U.field_msgType = "0";
                U.field_unReadCount = 0;
                U.field_digest = "";
                U.field_digestUser = "";
                w.DK();
                com.tencent.mm.modelbiz.a.b.a(U, i2, i);
                w.DK().b(U);
            } else {
                com.tencent.mm.modelbiz.a.a aVar;
                long j;
                Object obj;
                int i3;
                String iF;
                Iterator it;
                Object obj2;
                au auVar;
                boolean DV = aa.DV();
                U.field_brandUserName = str;
                if (ac.bMg()) {
                    U.field_content = ac.bMC();
                } else {
                    U.field_content = ac.field_content;
                }
                PString pString = new PString();
                this.uyU.oG().a(ac, pString, new PString(), new PInt(), false);
                String str2 = pString.value;
                j iD = w.DL().iD(ac.field_bizChatUserId);
                if (!DV) {
                    U.field_digest = str2;
                    str2 = null;
                } else if (ac.field_isSend == 1 && iD != null) {
                    U.field_digest = ab.getContext().getString(b.dHC) + ":" + str2;
                    iD.field_userName = ab.getContext().getString(b.dHC);
                    str2 = null;
                } else if (iD == null || bg.mA(iD.field_userName)) {
                    U.field_digest = str2;
                    str2 = null;
                } else {
                    U.field_digest = iD.field_userName + ":" + str2;
                    str2 = iD.field_userName;
                }
                String aA = this.uyU.aA(ac.field_type, ac.field_content);
                U.field_digest = bg.mz(U.field_digest).concat(bg.mA(aA) ? "" : " " + bg.mz(aA));
                U.field_digestUser = "";
                U.field_chatType = aa.field_chatType;
                U.field_lastMsgID = ac.field_msgId;
                if (ac.bMm()) {
                    aVar = U;
                } else if (ac.field_status == 1) {
                    j = Long.MAX_VALUE;
                    aVar = U;
                    aVar.field_lastMsgTime = j;
                    U.field_status = ac.field_status;
                    U.field_isSend = ac.field_isSend;
                    U.field_msgType = Integer.toString(ac.field_type);
                    U.field_flag = com.tencent.mm.modelbiz.a.b.a(U, 1, ac.field_createTime);
                    obj = null;
                    if ((cVar.nyO.equals("insert") && cVar.nyQ > 0) || (cVar.nyO.equals("update") && U.field_unReadCount + cVar.nyQ >= 0)) {
                        U.field_unReadCount += cVar.nyQ;
                        U.field_newUnReadCount += cVar.nyQ;
                        if (cVar.nyQ > 0 && aa.fu(1)) {
                            i3 = aeVar.field_unReadCount - cVar.nyQ;
                            if (i3 > 0) {
                                aeVar.dt(0);
                            } else {
                                aeVar.dt(i3);
                            }
                            aeVar.dA(aeVar.field_unReadMuteCount + cVar.nyQ);
                            obj = 1;
                        }
                    }
                    if (cVar.nyO.equals("insert") && cVar.nyP.size() > 0 && aa.DV()) {
                        iF = w.DL().iF(ac.field_talker);
                        it = cVar.nyP.iterator();
                        obj2 = obj;
                        while (it.hasNext()) {
                            auVar = (au) it.next();
                            if (iF == null && auVar.field_isSend != 1 && auVar.bMk() && auVar.RE(iF)) {
                                U.field_atCount++;
                                aeVar.dz(aeVar.field_atCount + 1);
                                obj = 1;
                            } else {
                                obj = obj2;
                            }
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    w.DK();
                    com.tencent.mm.modelbiz.a.b.a(U, i2, i);
                    if (bg.mA(str2)) {
                        str2 = aa.eK(ac.field_bizChatUserId);
                    }
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, aa.field_bizChatServId, ac.field_bizChatUserId, str2);
                    w.DK().b(U);
                    if (obj != null) {
                        this.uyU.a(aeVar, str);
                    }
                } else {
                    aVar = U;
                }
                j = ac.field_createTime;
                aVar.field_lastMsgTime = j;
                U.field_status = ac.field_status;
                U.field_isSend = ac.field_isSend;
                U.field_msgType = Integer.toString(ac.field_type);
                U.field_flag = com.tencent.mm.modelbiz.a.b.a(U, 1, ac.field_createTime);
                obj = null;
                U.field_unReadCount += cVar.nyQ;
                U.field_newUnReadCount += cVar.nyQ;
                i3 = aeVar.field_unReadCount - cVar.nyQ;
                if (i3 > 0) {
                    aeVar.dt(i3);
                } else {
                    aeVar.dt(0);
                }
                aeVar.dA(aeVar.field_unReadMuteCount + cVar.nyQ);
                obj = 1;
                iF = w.DL().iF(ac.field_talker);
                it = cVar.nyP.iterator();
                obj2 = obj;
                while (it.hasNext()) {
                    auVar = (au) it.next();
                    if (iF == null) {
                    }
                    obj = obj2;
                    obj2 = obj;
                }
                obj = obj2;
                w.DK();
                com.tencent.mm.modelbiz.a.b.a(U, i2, i);
                if (bg.mA(str2)) {
                    str2 = aa.eK(ac.field_bizChatUserId);
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, aa.field_bizChatServId, ac.field_bizChatUserId, str2);
                w.DK().b(U);
                if (obj != null) {
                    this.uyU.a(aeVar, str);
                }
            }
        }
    }

    public final void QH(String str) {
        if (str != null && o.eV(str) && com.tencent.mm.modelbiz.e.ib(str)) {
            ae Rm = this.uyU.Rm(str);
            if (Rm != null) {
                au Ai = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ai(((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rx(str));
                if (Ai != null && Ai.field_msgId > 0) {
                    Rm.W(Ai);
                    Rm.setContent(Ai.field_talker + ":" + Ai.field_content);
                    Rm.ct(Integer.toString(Ai.field_type));
                    as.b oG = this.uyU.oG();
                    if (oG != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Ai.cH(str);
                        Ai.setContent(Rm.field_content);
                        oG.a(Ai, pString, pString2, pInt, true);
                        Rm.cu(pString.value);
                        Rm.cv(pString2.value);
                        Rm.dx(pInt.value);
                    } else {
                        Rm.bLB();
                    }
                    this.uyU.a(Rm, Rm.field_username);
                }
            }
        }
    }
}
