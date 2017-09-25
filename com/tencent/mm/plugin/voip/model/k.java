package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class k {
    public static k riz;
    public aj riA = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ k riB;

        {
            this.riB = r1;
        }

        public final boolean oQ() {
            if (!this.riB.riv) {
                return false;
            }
            int i;
            byte[] bArr = new byte[4];
            if (this.riB.rir.setAppCmd(10, bArr, 4) < 0) {
                w.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
                i = -1;
            } else {
                i = bg.aE(bArr);
                w.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d", new Object[]{Integer.valueOf(i)});
            }
            if (i != -1) {
                this.riB.riu = i;
                this.riB.rix = this.riB.riu + this.riB.rix;
                k kVar = this.riB;
                kVar.riy++;
                kVar = this.riB;
                if (kVar.riu < 5) {
                    kVar.riw = 0;
                    if (!kVar.ris) {
                        kVar.ris = true;
                        w.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                        if (kVar.rit != null) {
                            kVar.rit.aDF();
                        }
                    }
                } else if (kVar.ris) {
                    if (kVar.riw <= 0) {
                        w.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                        kVar.riw++;
                    } else {
                        kVar.ris = false;
                        w.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
                        if (kVar.rit != null) {
                            kVar.rit.aDG();
                        }
                    }
                }
            }
            return true;
        }
    }, true);
    v2protocal rir = new v2protocal(new ae(Looper.getMainLooper()));
    boolean ris = false;
    public a rit;
    public int riu = -1;
    public boolean riv = false;
    int riw = 0;
    public int rix;
    public int riy;

    public interface a {
        void aDF();

        void aDG();
    }

    public static k bpZ() {
        if (riz == null) {
            riz = new k();
        }
        return riz;
    }

    private k() {
    }

    public final void bqa() {
        w.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.riu = -1;
        this.riv = true;
        this.riy = 0;
        this.rix = 0;
        af.f(new Runnable(this) {
            final /* synthetic */ k riB;

            {
                this.riB = r1;
            }

            public final void run() {
                this.riB.riA.v(2000, 2000);
            }
        }, 3000);
    }

    public final void bqb() {
        w.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.riu = -1;
        this.ris = false;
        this.riv = false;
        this.riy = 0;
        this.rix = 0;
        af.v(new Runnable(this) {
            final /* synthetic */ k riB;

            {
                this.riB = r1;
            }

            public final void run() {
                this.riB.riA.KH();
            }
        });
    }
}
