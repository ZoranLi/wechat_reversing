package com.tencent.mm.av;

import com.tencent.mm.e.a.fg;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.e;
import com.tencent.mm.x.h;

public final class d extends e {
    protected final au a(bu buVar, String str, String str2, String str3) {
        String a = n.a(buVar.tff);
        if (a == null || a.length() <= 0) {
            w.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
        } else {
            a RF = a.RF(a);
            if (!(RF.uJX == null && RF.uJY == null) && (RF.scene == 10 || RF.scene == 11)) {
                b fgVar = new fg();
                fgVar.fJM.fJO = RF.uJX;
                fgVar.fJM.fJP = RF.uJY;
                com.tencent.mm.sdk.b.a.urY.m(fgVar);
                if (fgVar.fJN.fJQ) {
                    w.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
                }
            }
            if (RF.ovb > 0) {
                com.tencent.mm.x.b.d(RF.ovb, RF.uJW);
            }
            if (bg.mz(RF.rUK).length() > 0) {
                h hVar = new h();
                hVar.username = RF.rUK;
                hVar.gkq = 3;
                hVar.aV(true);
                hVar.fRW = -1;
                hVar.hrB = RF.uJZ;
                hVar.hrA = RF.uKa;
                hVar.fRW = -1;
                w.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", RF.rUK, hVar.Bs(), hVar.Bt());
                com.tencent.mm.x.n.Bm().a(hVar);
            }
            f fVar = new f();
            fVar.field_createTime = e.i(str, (long) buVar.ogM);
            fVar.field_isSend = 0;
            fVar.field_msgContent = n.a(buVar.tff);
            fVar.field_svrId = buVar.tfk;
            fVar.field_talker = RF.rUK;
            fVar.field_type = 0;
            b kY = l.Ky().kY(fVar.field_talker);
            if (kY != null) {
                w.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + fVar.field_talker + " , real talker = " + kY.field_talker);
                fVar.field_encryptTalker = fVar.field_talker;
                fVar.field_talker = kY.field_talker;
            }
            ap.yY();
            af Rc = c.wR().Rc(fVar.field_talker);
            if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type) || Rc.gTQ <= 0) {
                l.Kx().a(fVar);
            } else {
                w.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + fVar.field_talker + " has already been in user's contact list");
            }
        }
        return null;
    }
}
