package com.tencent.mm.plugin.scanner.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;

public final class b {
    public String oVX;
    public e oVY;
    public a oVZ;
    public e.a oWa = new e.a(this) {
        final /* synthetic */ b oWd;

        {
            this.oWd = r1;
        }

        public final void k(int i, Bundle bundle) {
            w.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.sdk.b.b jpVar = new jp();
            jpVar.fQb.fPZ = i;
            jpVar.fQb.activity = this.oWd.qb;
            jpVar.fQb.fDK = this.oWd.oVX;
            jpVar.fQb.fQc = bundle;
            com.tencent.mm.sdk.b.a.urY.m(jpVar);
        }
    };
    public c oWb = new c<bx>(this) {
        final /* synthetic */ b oWd;

        {
            this.oWd = r2;
            this.usg = bx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = 2;
            bx bxVar = (bx) bVar;
            if (bxVar == null || !(bxVar instanceof bx)) {
                w.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
            } else {
                this.oWd.aXY();
                this.oWd.oVX = bxVar.fFn.fDK;
                this.oWd.qb = bxVar.fFn.activity;
                w.i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType: %s, codeVersion: %s, from : %d", new Object[]{this.oWd.qb, this.oWd.oVX, Integer.valueOf(bxVar.fFn.fFo), Integer.valueOf(bxVar.fFn.fFp), Integer.valueOf(bxVar.fFn.fFr)});
                if (bxVar.fFn.fFo == 19 || bxVar.fFn.fFo == 22) {
                    this.oWd.oVY = new e();
                    this.oWd.oVY.fFq = bxVar.fFn.fFq;
                    this.oWd.oVY.imagePath = bxVar.fFn.imagePath;
                    this.oWd.oVY.fFt = bxVar.fFn.fFt;
                    this.oWd.oVY.aJE = bxVar.fFn.aJE;
                    if (bxVar.fFn.fFr >= 0) {
                        i = 3;
                    }
                    if (bxVar.fFn.scene > 0) {
                        this.oWd.oVY.pdv = bxVar.fFn.scene;
                    }
                    if (i == 3) {
                        this.oWd.oVY.appId = bxVar.fFn.fFs;
                    }
                    this.oWd.oVY.a(this.oWd.qb, this.oWd.oVX, i, bxVar.fFn.fFo, bxVar.fFn.fFp, this.oWd.oWa, bxVar.fFn.fFu);
                } else {
                    this.oWd.oVZ = new a();
                    a aVar = this.oWd.oVZ;
                    Context context = this.oWd.qb;
                    String str = this.oWd.oVX;
                    int i2 = bxVar.fFn.fFo;
                    int i3 = bxVar.fFn.fFp;
                    Bundle bundle = bxVar.fFn.fFu;
                    if (!bg.mA(str)) {
                        String[] split = str.split(",");
                        if (split == null || split.length < 2) {
                            w.e("MicroMsg.BarcodeStringHandler", "wrong zbar format");
                        } else {
                            aVar.fPi = context;
                            aVar.fFu = bundle;
                            k fVar = new f(p.DR(split[0]), split[1], i2, i3);
                            ap.vd().a(1061, aVar);
                            ap.vd().a(fVar, 0);
                            context.getString(R.l.dIO);
                            aVar.isv = g.a(context, context.getString(R.l.eHv), true, new com.tencent.mm.plugin.scanner.util.a.AnonymousClass1(aVar, fVar));
                        }
                    }
                }
            }
            return false;
        }
    };
    public c oWc = new c<aj>(this) {
        final /* synthetic */ b oWd;

        {
            this.oWd = r2;
            this.usg = aj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            aj ajVar = (aj) bVar;
            if (ajVar == null || !(ajVar instanceof aj)) {
                w.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
            } else {
                w.i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", new Object[]{this.oWd.qb, this.oWd.oVX});
                if (ajVar.fDJ.activity == this.oWd.qb && ajVar.fDJ.fDK.equals(this.oWd.oVX)) {
                    this.oWd.aXY();
                } else {
                    w.e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
                }
            }
            return false;
        }
    };
    public Activity qb;

    public final void aXY() {
        if (this.oVY != null) {
            this.oVY.aZa();
            this.oVY = null;
        }
        this.qb = null;
        this.oVX = null;
    }
}
