package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ay.a;
import junit.framework.Assert;

public final class g {
    public static void eq(String str) {
        Assert.assertTrue(!bg.mA(str));
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc != null && !bg.mA(Rc.field_username)) {
            Rc.setType(Rc.field_type | 2048);
            o.t(Rc);
            if (((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm(str) == null && Rc.bLe()) {
                if (e.hY(str)) {
                    ae aeVar;
                    if (((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm("officialaccounts") == null) {
                        aeVar = new ae("officialaccounts");
                        aeVar.bLB();
                        ((h) com.tencent.mm.kernel.h.h(h.class)).wW().d(aeVar);
                    }
                    aeVar = new ae(str);
                    aeVar.s(System.currentTimeMillis());
                    aeVar.cw("officialaccounts");
                    ((h) com.tencent.mm.kernel.h.h(h.class)).wW().d(aeVar);
                } else if (e.ia(str) && !e.dr(str)) {
                    ae aeVar2;
                    BizInfo hW = e.hW(str);
                    if (((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm(hW.field_enterpriseFather) == null) {
                        aeVar2 = new ae(hW.field_enterpriseFather);
                        aeVar2.bLB();
                        ((h) com.tencent.mm.kernel.h.h(h.class)).wW().d(aeVar2);
                    }
                    aeVar2 = new ae(str);
                    aeVar2.s(System.currentTimeMillis());
                    aeVar2.cw(hW.CO());
                    ((h) com.tencent.mm.kernel.h.h(h.class)).wW().d(aeVar2);
                }
                w.i("MicroMsg.BizConversationLogic", "setPlacedTop username = " + str);
            }
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rr(str);
        }
    }

    public static int a(final String str, final long j, final a aVar) {
        w.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", Long.valueOf(j));
        com.tencent.mm.kernel.h.vL().D(new Runnable() {
            public final void run() {
                Cursor af = ((n) com.tencent.mm.kernel.h.h(n.class)).wU().af(str, j);
                if (af.moveToFirst()) {
                    while (!af.isAfterLast() && (aVar == null || !aVar.zs())) {
                        au auVar = new au();
                        auVar.b(af);
                        ay.j(auVar);
                        af.moveToNext();
                    }
                }
                af.close();
                ((n) com.tencent.mm.kernel.h.h(n.class)).wU().ae(str, j);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 hlm;

                    {
                        this.hlm = r1;
                    }

                    public final void run() {
                        if (aVar != null) {
                            aVar.zr();
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|deleteMsgByTalker";
            }
        });
        return 0;
    }
}
