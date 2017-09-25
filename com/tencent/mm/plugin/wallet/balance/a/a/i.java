package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class i extends a {

    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<asf>> {
        final /* synthetic */ b rtD;
        final /* synthetic */ i rtJ;

        AnonymousClass1(i iVar, b bVar) {
            this.rtJ = iVar;
            this.rtD = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                asf com_tencent_mm_protocal_c_asf = (asf) aVar.fYb;
                w.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asf.kfH), com_tencent_mm_protocal_c_asf.kfI});
                if (com_tencent_mm_protocal_c_asf.kfH == 0) {
                    this.rtD.s(new Object[]{aVar.fYb});
                    g.oUh.a(663, 3, 1, false);
                } else {
                    this.rtD.bJ(com_tencent_mm_protocal_c_asf.kfI);
                    g.oUh.a(664, 4, 1, false);
                }
            } else {
                this.rtD.bJ(Boolean.valueOf(false));
                g.oUh.a(664, 5, 1, false);
            }
            return wCE;
        }
    }

    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<aso>> {
        final /* synthetic */ b rtD;
        final /* synthetic */ i rtJ;

        AnonymousClass2(i iVar, b bVar) {
            this.rtJ = iVar;
            this.rtD = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                aso com_tencent_mm_protocal_c_aso = (aso) aVar.fYb;
                w.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aso.kfH), com_tencent_mm_protocal_c_aso.kfI});
                if (com_tencent_mm_protocal_c_aso.kfH == 0) {
                    this.rtD.s(new Object[]{com_tencent_mm_protocal_c_aso});
                    g.oUh.a(663, 6, 1, false);
                } else {
                    this.rtD.bJ(com_tencent_mm_protocal_c_aso.kfI);
                    g.oUh.a(663, 7, 1, false);
                }
            } else {
                this.rtD.bJ(Boolean.valueOf(false));
                g.oUh.a(663, 8, 1, false);
            }
            return wCE;
        }
    }

    class AnonymousClass3 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<aui>> {
        final /* synthetic */ b rtD;
        final /* synthetic */ i rtJ;

        AnonymousClass3(i iVar, b bVar) {
            this.rtJ = iVar;
            this.rtD = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                aui com_tencent_mm_protocal_c_aui = (aui) aVar.fYb;
                w.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aui.kfH), com_tencent_mm_protocal_c_aui.kfI});
                if (com_tencent_mm_protocal_c_aui.kfH == 0) {
                    this.rtD.s(new Object[]{com_tencent_mm_protocal_c_aui});
                    g.oUh.a(663, 12, 1, false);
                } else {
                    this.rtD.bJ(com_tencent_mm_protocal_c_aui.kfI);
                    g.oUh.a(663, 13, 1, false);
                }
            } else {
                this.rtD.bJ(Boolean.valueOf(false));
                g.oUh.a(663, 14, 1, false);
            }
            return wCE;
        }
    }

    class AnonymousClass4 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<arc>> {
        final /* synthetic */ b rtD;
        final /* synthetic */ i rtJ;

        AnonymousClass4(i iVar, b bVar) {
            this.rtJ = iVar;
            this.rtD = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                arc com_tencent_mm_protocal_c_arc = (arc) aVar.fYb;
                w.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_arc.kfH), com_tencent_mm_protocal_c_arc.kfI});
                if (com_tencent_mm_protocal_c_arc.kfH == 0) {
                    this.rtD.s(new Object[]{com_tencent_mm_protocal_c_arc});
                    g.oUh.a(663, 9, 1, false);
                } else {
                    this.rtD.bJ(com_tencent_mm_protocal_c_arc.kfI);
                    g.oUh.a(663, 10, 1, false);
                }
            } else {
                this.rtD.bJ(Boolean.valueOf(false));
                g.oUh.a(663, 11, 1, false);
            }
            return wCE;
        }
    }

    protected final void onCreate() {
        super.onCreate();
    }
}
