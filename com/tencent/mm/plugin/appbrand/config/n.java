package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.i.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;

public final class n implements b {

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String hqR;
        final /* synthetic */ a iFA = null;
        final /* synthetic */ n iFB;
        final /* synthetic */ af iFC;

        AnonymousClass2(n nVar, String str, a aVar, af afVar) {
            this.iFB = nVar;
            this.hqR = str;
            this.iFC = afVar;
        }

        public final void run() {
            if (q.os(this.hqR)) {
                q.a(this.hqR, new q.b<WxaAttributes>(this) {
                    final /* synthetic */ AnonymousClass2 iFD;

                    {
                        this.iFD = r1;
                    }

                    public final /* synthetic */ void aG(Object obj) {
                        WxaAttributes wxaAttributes = (WxaAttributes) obj;
                        if (this.iFD.iFA != null) {
                            this.iFD.iFA.c(wxaAttributes);
                        }
                    }
                });
            } else if (this.iFA != null) {
                this.iFA.c(this.iFB.og(this.hqR));
            }
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ AnonymousClass2 iFD;

                {
                    this.iFD = r1;
                }

                public final boolean queueIdle() {
                    this.iFD.iFC.nJF.quit();
                    return false;
                }
            });
        }
    }

    public final WxaAttributes og(String str) {
        return c.PR().d(str, new String[0]);
    }

    public final void a(String str, final a aVar) {
        q.a(str, new q.b<WxaAttributes>(this) {
            final /* synthetic */ n iFB;

            public final /* synthetic */ void aG(Object obj) {
                WxaAttributes wxaAttributes = (WxaAttributes) obj;
                if (aVar != null) {
                    aVar.c(wxaAttributes);
                }
            }
        });
    }

    public final void oh(String str) {
        if (!bg.mA(str)) {
            af afVar = new af();
            new ae(afVar.nJF.getLooper()).post(new AnonymousClass2(this, str, null, afVar));
        }
    }
}
