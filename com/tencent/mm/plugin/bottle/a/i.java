package com.tencent.mm.plugin.bottle.a;

import android.database.Cursor;
import com.tencent.mm.ao.d;
import com.tencent.mm.ao.f;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import java.util.HashMap;

public final class i implements am {
    private static HashMap<Integer, c> gJr;
    private a hmk = new a(this) {
        final /* synthetic */ i jVo;

        {
            this.jVo = r1;
        }

        public final void a(ae aeVar, as asVar) {
            if (aeVar != null) {
                if ("_USER_FOR_THROWBOTTLE_".equals(aeVar.field_username)) {
                    aeVar.setUsername("");
                } else if (1 != aeVar.field_isSend && x.eO(aeVar.field_username) && !asVar.wV(aeVar.field_username)) {
                    c.rY(aeVar.field_username);
                }
            }
        }
    };
    private b jVn;

    private static i adv() {
        i iVar = (i) ap.yR().gs("plugin.bottle");
        if (iVar != null) {
            return iVar;
        }
        Object iVar2 = new i();
        ap.yR().a("plugin.bottle", iVar2);
        return iVar2;
    }

    public static b adw() {
        h.vG().uQ();
        if (adv().jVn == null) {
            i adv = adv();
            ap.yY();
            adv.jVn = new b(com.tencent.mm.u.c.wO());
        }
        return adv().jVn;
    }

    public final void onAccountRelease() {
        ap.yY();
        com.tencent.mm.u.c.wW().c(this.hmk);
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
        if ((i & 64) != 0) {
            adx();
        }
    }

    public static void adx() {
        ap.yY();
        Cursor bLJ = com.tencent.mm.u.c.wW().bLJ();
        for (int i = 0; i < bLJ.getCount(); i++) {
            bLJ.moveToPosition(i);
            aj aeVar = new ae();
            aeVar.b(bLJ);
            ap.yY();
            ce Ah = com.tencent.mm.u.c.wT().Ah(aeVar.field_username);
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new d(aeVar.field_username, Ah.field_msgSvrId));
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new f(aeVar.field_username, 0));
            ap.yY();
            com.tencent.mm.u.c.wR().Ri(aeVar.field_username);
        }
        bLJ.close();
        ap.yY();
        com.tencent.mm.u.c.wT().Ap("@bottle");
        ap.yY();
        com.tencent.mm.u.c.wW().bLD();
        ap.yY();
        com.tencent.mm.u.c.wW().Ap("floatbottle");
        ay.zo();
        adw().hnH.delete("bottleinfo1", null, null);
    }

    public final void aM(boolean z) {
        c.adr();
        ap.yY();
        com.tencent.mm.u.c.wW().b(this.hmk);
    }

    public final void aN(boolean z) {
    }
}
