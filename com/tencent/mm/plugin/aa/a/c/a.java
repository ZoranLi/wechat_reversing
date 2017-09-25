package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.x;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.b;

public final class a extends com.tencent.mm.vending.app.a {
    public int iok = 0;
    public String iol;
    public int iom;
    public int ion;
    public String ioo;
    public boolean iop = false;
    int ioq;

    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<x>> {
        final /* synthetic */ b ior;
        final /* synthetic */ a ios;

        AnonymousClass1(a aVar, b bVar) {
            this.ios = aVar;
            this.ior = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                x xVar = (x) aVar.fYb;
                w.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(xVar.kAC), xVar.kAD});
                if (xVar.kAC == 0) {
                    w.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish get success, return record size: %s", new Object[]{Integer.valueOf(xVar.tbY.size())});
                    this.ios.iok += xVar.tbY.size();
                    this.ios.iol = xVar.tbU;
                    this.ios.iom = xVar.tbV;
                    this.ios.ion = xVar.tbW;
                    this.ios.ioo = xVar.tbX;
                    if (bg.mA(this.ios.iol) || bg.mA(this.ios.ioo)) {
                        this.ios.iop = false;
                    } else {
                        this.ios.iop = true;
                    }
                    w.d("MicroMsg.AAQueryListInteractor", "bill_id: %s, trans_id %s", new Object[]{this.ios.iol, this.ios.ioo});
                    this.ior.s(new Object[]{xVar.tbY, xVar.tbZ, Boolean.valueOf(this.ios.iop)});
                    g.oUh.a(407, 30, 1, false);
                } else if (xVar.kAC <= 0 || !bg.mA(xVar.kAD)) {
                    this.ior.bJ(Boolean.valueOf(false));
                    g.oUh.a(407, 32, 1, false);
                } else {
                    this.ior.bJ(xVar.kAD);
                    g.oUh.a(407, 32, 1, false);
                }
            } else {
                this.ior.bJ(Boolean.valueOf(false));
                g.oUh.a(407, 31, 1, false);
            }
            return wCE;
        }
    }

    protected final void onCreate() {
        super.onCreate();
    }
}
