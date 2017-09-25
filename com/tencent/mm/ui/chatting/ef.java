package com.tencent.mm.ui.chatting;

import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.mx;
import com.tencent.mm.e.a.my;
import com.tencent.mm.e.a.nu;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.rj;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;

public final class ef {
    public static void aM(au auVar) {
        w.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
        if (o.fq(auVar.field_talker)) {
            b myVar = new my();
            myVar.fUh.fCZ = auVar;
            a.urY.m(myVar);
            return;
        }
        myVar = new mx();
        myVar.fUg.fCZ = auVar;
        a.urY.m(myVar);
    }

    public static void aN(au auVar) {
        b nuVar = new nu();
        long gk = ay.gk(auVar.field_talker);
        w.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_createTime), Long.valueOf(gk));
        if (gk == auVar.field_createTime) {
            gk++;
        }
        auVar.z(gk);
        ap.yY();
        c.wT().a(auVar.field_msgId, auVar);
        nuVar.fUZ.fCZ = auVar;
        a.urY.m(nuVar);
    }

    public static void aB(au auVar) {
        w.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", Long.valueOf(auVar.field_msgId));
        b rjVar = new rj();
        rjVar.fYu.fCZ = auVar;
        a.urY.m(rjVar);
    }

    public static void aE(au auVar) {
        w.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", Long.valueOf(auVar.field_msgId));
        long gk = ay.gk(auVar.field_talker);
        if (gk == auVar.field_createTime) {
            gk++;
        }
        auVar.z(gk);
        ap.yY();
        c.wT().a(auVar.field_msgId, auVar);
        com.tencent.mm.sdk.e.c eb = an.abL().eb(auVar.field_msgId);
        if (eb == null || eb.field_msgInfoId != auVar.field_msgId) {
            w.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            an.bDm();
            am.a.eg(auVar.field_msgId);
            return;
        }
        w.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        eb.field_status = 101;
        eb.field_offset = 0;
        eb.field_lastModifyTime = System.currentTimeMillis() / 1000;
        an.abL().c(eb, new String[0]);
        an.bDm().run();
    }

    public static void V(au auVar) {
        w.i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
        long gk = ay.gk(auVar.field_talker);
        if (gk == auVar.field_createTime) {
            gk++;
        }
        auVar.z(gk);
        ap.yY();
        c.wT().a(auVar.field_msgId, auVar);
        String str = auVar.field_content;
        int i = auVar.field_isSend;
        String str2 = auVar.field_talker;
        int i2 = (o.eQ(str2) || j.eu(str2)) ? 1 : 0;
        if (!(i2 == 0 || str == null || i != 0)) {
            str = ay.gj(str);
        }
        f.a ek = f.a.ek(str);
        if ((ek == null || 19 != ek.type) && (ek == null || 24 != ek.type)) {
            l.V(auVar);
        } else {
            b lzVar = new lz();
            lzVar.fTf.type = 4;
            lzVar.fTf.fTk = auVar;
            lzVar.fTf.toUser = auVar.field_talker;
            a.urY.m(lzVar);
        }
        ay.L(auVar.field_msgId);
    }

    public static void aC(au auVar) {
        w.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
        aP(auVar);
    }

    public static void aO(au auVar) {
        w.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", Long.valueOf(auVar.field_msgId));
        aP(auVar);
    }

    public static void aD(au auVar) {
        w.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
        aP(auVar);
    }

    private static void aP(au auVar) {
        long j = auVar.field_msgId;
        if (j == -1) {
            w.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId " + j);
        } else if (!auVar.field_talker.equals("medianote") || (m.xP() & 16384) != 0) {
            w.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", Long.valueOf(j));
            if (!ap.vd().a(new com.tencent.mm.modelmulti.j(j), 0)) {
                w.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
                auVar.dv(5);
                ap.yY();
                c.wT().a(auVar.field_msgId, auVar);
                b nwVar = new nw();
                nwVar.fVc.fCZ = auVar;
                a.urY.m(nwVar);
            }
        }
    }
}
