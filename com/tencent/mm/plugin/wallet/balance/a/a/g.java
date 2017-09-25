package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class g extends a {

    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<asq>> {
        final /* synthetic */ b rtD;
        final /* synthetic */ g rtE;

        AnonymousClass1(g gVar, b bVar) {
            this.rtE = gVar;
            this.rtD = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                asq com_tencent_mm_protocal_c_asq = (asq) aVar.fYb;
                w.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asq.kfH), com_tencent_mm_protocal_c_asq.kfI});
                if (com_tencent_mm_protocal_c_asq.kfH == 0) {
                    this.rtD.s(new Object[]{com_tencent_mm_protocal_c_asq});
                    com.tencent.mm.plugin.report.service.g.oUh.a(663, 0, 1, false);
                } else {
                    this.rtD.bJ(com_tencent_mm_protocal_c_asq.kfI);
                    com.tencent.mm.plugin.report.service.g.oUh.a(663, 1, 1, false);
                }
            } else {
                this.rtD.bJ(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.oUh.a(663, 2, 1, false);
            }
            return wCE;
        }
    }

    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<ls>> {
        final /* synthetic */ b rtD;
        final /* synthetic */ g rtE;

        AnonymousClass2(g gVar, b bVar) {
            this.rtE = gVar;
            this.rtD = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.LqtDetailInteractor", "on close lqt account finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            g.bsg();
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ls lsVar = (ls) aVar.fYb;
                w.i("MicroMsg.LqtDetailInteractor", "on close lqt account finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(lsVar.kfH), lsVar.kfI});
                if (lsVar.kfH == 0) {
                    this.rtD.s(new Object[]{lsVar});
                    com.tencent.mm.plugin.report.service.g.oUh.a(663, 15, 1, false);
                } else {
                    this.rtD.bJ(lsVar.kfI);
                    com.tencent.mm.plugin.report.service.g.oUh.a(663, 16, 1, false);
                }
            } else {
                this.rtD.bJ(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.oUh.a(663, 17, 1, false);
            }
            return wCE;
        }
    }

    protected final void onCreate() {
        super.onCreate();
    }

    public static void bsg() {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uID, Integer.valueOf(-1));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uIE, null);
    }
}
