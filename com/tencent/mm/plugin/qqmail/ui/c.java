package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.e.a.jd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c implements e {
    static long oFa = 0;
    private Activity fPi;
    public a oFb;

    public static abstract class a {
        public abstract void aUC();

        public abstract void aUD();
    }

    public c(Activity activity) {
        ap.vd().a(138, this);
        this.fPi = activity;
    }

    public final void a(a aVar) {
        this.oFb = aVar;
        final b jdVar = new jd();
        jdVar.fPg.fPi = this.fPi;
        jdVar.fPg.fPj = new Runnable(this) {
            final /* synthetic */ c oFc;

            public final void run() {
                if (jdVar.fPh.fFj) {
                    c cVar = this.oFc;
                    if (System.currentTimeMillis() - c.oFa > 600000) {
                        if (ap.zb()) {
                            ap.vd().a(new bb(new com.tencent.mm.u.bb.a(cVar) {
                                final /* synthetic */ c oFc;

                                {
                                    this.oFc = r1;
                                }

                                public final void a(com.tencent.mm.network.e eVar) {
                                    if (eVar != null) {
                                        eVar.Cc().i(new byte[0], eVar.Cc().uH());
                                        com.tencent.mm.plugin.qqmail.a.a.imw.ou();
                                    }
                                }
                            }), 0);
                        }
                    } else if (cVar.oFb != null) {
                        cVar.oFb.aUD();
                    }
                } else if (this.oFc.oFb != null) {
                    this.oFc.oFb.aUD();
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.a(jdVar, Looper.myLooper());
    }

    public final void release() {
        ap.vd().b(138, this);
    }

    protected final void finalize() {
        release();
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (this.oFb != null) {
                this.oFb.aUC();
                this.oFb = null;
            }
        } else if (this.oFb != null) {
            this.oFb.aUD();
            this.oFb = null;
        }
        oFa = System.currentTimeMillis();
    }
}
