package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.ss;
import com.tencent.mm.plugin.game.model.q.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class t {

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String izs;
        final /* synthetic */ t mqU;

        AnonymousClass1(t tVar, String str) {
            this.mqU = tVar;
            this.izs = str;
        }

        public final void run() {
            if (bg.mA(this.izs)) {
                w.e("MicroMsg.GameMessageService", "msg content is null");
                return;
            }
            Map q = bh.q(this.izs, "sysmsg");
            if (q == null || q.size() == 0) {
                w.e("MicroMsg.GameMessageService", "Parse failed");
                return;
            }
            String ap = bg.ap((String) q.get(".sysmsg.wepkg.$pkg_id"), "");
            w.i("MicroMsg.GameMessageService", "MicroMsg.Wepkg message pkgid:%s", new Object[]{ap});
            if (!bg.mA(ap)) {
                b ssVar = new ss();
                ssVar.gaE.fEG = 1;
                ssVar.gaE.gaF = ap;
                a.urY.m(ssVar);
            }
        }
    }

    static boolean a(q qVar, q qVar2) {
        if (qVar.field_weight.compareTo(qVar2.field_weight) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(lj ljVar) {
        q aAO = aAO();
        if (aAO != null) {
            aAO.aAN();
            ai.xT(aAO.mqz);
            ljVar.fSk.showType = aAO.mpR.mqG;
            ljVar.fSk.appId = aAO.field_appId;
            ljVar.fSk.appName = aAO.mpR.jqT;
            ljVar.fSk.fSl = aAO.mpR.mqE;
            ljVar.fSk.msgType = aAO.field_msgType;
            if (aAO.field_msgType == 100) {
                ljVar.fSk.msgType = aAO.mqy;
            }
            ljVar.fSk.fSm = aAO.field_gameMsgId;
            ljVar.fSk.fDE = aAO.mqz;
        }
    }

    public static q aAO() {
        q cn;
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0))).longValue();
        if (longValue != 0) {
            cn = SubCoreGameCenter.aBB().cn(longValue);
        } else {
            cn = null;
        }
        if (cn != null && !cn.field_isHidden && !d(cn)) {
            return cn;
        }
        ai.xT("");
        return null;
    }

    public static void aAP() {
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0))).longValue();
        q qVar = null;
        if (longValue != 0) {
            qVar = SubCoreGameCenter.aBB().cn(longValue);
        }
        if (qVar != null && !qVar.field_isHidden) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0));
        }
    }

    public static q aAQ() {
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uCl, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        q cn = SubCoreGameCenter.aBB().cn(longValue);
        if (cn == null || cn.field_isHidden || d(cn)) {
            return null;
        }
        return cn;
    }

    public static void aAR() {
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uCl, Long.valueOf(0))).longValue();
        q qVar = null;
        if (longValue != 0) {
            qVar = SubCoreGameCenter.aBB().cn(longValue);
        }
        if (qVar != null && !qVar.field_isHidden) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uCl, Long.valueOf(0));
        }
    }

    public static q aAS() {
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uCi, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        q cn = SubCoreGameCenter.aBB().cn(longValue);
        if (cn == null || cn.field_isHidden || d(cn)) {
            return null;
        }
        return cn;
    }

    public static void aAT() {
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uCi, Long.valueOf(0))).longValue();
        q qVar = null;
        if (longValue != 0) {
            qVar = SubCoreGameCenter.aBB().cn(longValue);
        }
        if (qVar != null && !qVar.field_isHidden) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uCi, Long.valueOf(0));
        }
    }

    public static q aAU() {
        ap.yY();
        return SubCoreGameCenter.aBB().cn(((Long) c.vr().get(com.tencent.mm.storage.w.a.uCk, Long.valueOf(0))).longValue());
    }

    private static boolean d(q qVar) {
        return qVar.field_expireTime < System.currentTimeMillis() / 1000;
    }

    static void e(q qVar) {
        if (!bg.mA(qVar.field_mergerId)) {
            com.tencent.mm.sdk.e.c cVar;
            u aBB = SubCoreGameCenter.aBB();
            String str = "select * from GameRawMessage where msgType=" + qVar.field_msgType + " and mergerId= \"" + qVar.field_mergerId + "\" order by createTime desc limit 1";
            com.tencent.mm.sdk.e.c qVar2 = new q();
            Cursor rawQuery = aBB.rawQuery(str, new String[0]);
            if (rawQuery == null) {
                cVar = null;
            } else {
                if (rawQuery.moveToFirst()) {
                    qVar2.b(rawQuery);
                }
                rawQuery.close();
                cVar = qVar2;
            }
            if (cVar != null) {
                cVar.aAN();
                if (!bg.bV(cVar.mpP)) {
                    qVar.aAN();
                    Object linkedList = new LinkedList(cVar.mpP);
                    if (!bg.bV(qVar.mpP)) {
                        String str2 = ((h) qVar.mpP.get(0)).userName;
                        if (!bg.mA(str2)) {
                            Iterator it = cVar.mpP.iterator();
                            while (it.hasNext()) {
                                h hVar = (h) it.next();
                                if (hVar.userName.equals(str2)) {
                                    linkedList.remove(hVar);
                                    break;
                                }
                            }
                        }
                    }
                    if (!bg.bV(linkedList)) {
                        qVar.field_rawXML = aj.a(qVar.field_rawXML, linkedList, cVar.mpU);
                    }
                    SubCoreGameCenter.aBB().a(cVar, new String[0]);
                }
            }
        }
    }
}
