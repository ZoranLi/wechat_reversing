package com.tencent.mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class PluginSecInfoReport extends d implements a {
    private static HandlerThread phA = null;
    private static ae phB = null;

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
        dependsOn(a.class);
        dependsOn(com.tencent.mm.plugin.normsg.a.class);
    }

    public void configure(e eVar) {
        b.a(b.phE);
    }

    public void execute(e eVar) {
        if (phA == null) {
            try {
                HandlerThread Qu = com.tencent.mm.sdk.f.e.Qu("SIRWorker");
                phA = Qu;
                Qu.start();
                phB = new ae(phA.getLooper());
            } catch (Throwable th) {
                w.printErrStackTrace("MicroMsg.PSIR", th, "[tomys] unexpected exception.", new Object[0]);
            }
        }
        com.tencent.mm.sdk.b.a.urY.a(new c<lc>(this) {
            final /* synthetic */ PluginSecInfoReport phC;

            {
                this.phC = r2;
                this.usg = lc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                this.phC.reportSecurityInfoAsync(0);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.urY.a(new c<com.tencent.mm.e.a.e>(this) {
            final /* synthetic */ PluginSecInfoReport phC;

            {
                this.phC = r2;
                this.usg = com.tencent.mm.e.a.e.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (!((com.tencent.mm.e.a.e) bVar).fCm.fCn) {
                    this.phC.reportSecurityInfoAsync(0);
                }
                return false;
            }
        });
        ((com.tencent.mm.plugin.auth.a.b) h.j(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a(this) {
            final /* synthetic */ PluginSecInfoReport phC;

            {
                this.phC = r1;
            }

            public final void a(f fVar, g gVar, boolean z) {
                this.phC.reportSecurityInfoAsync(z ? 0 : 540999680);
            }

            public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
                this.phC.reportSecurityInfoAsync(540999681);
            }
        });
    }

    public void reportSecurityInfoAsync(final int i) {
        if (phB == null) {
            w.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
        } else {
            phB.post(new Runnable(this) {
                final /* synthetic */ PluginSecInfoReport phC;

                public final void run() {
                    try {
                        if (b.phI.aZL()) {
                            boolean z;
                            int i = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("DisableRiskScanSdkProb", 0);
                            int i2 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("DisableInstalledPkgInfoReportProb", 0);
                            h.vG();
                            int aw = com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH(), 101);
                            i = (i <= 0 || aw < 0 || aw > i) ? 0 : 1;
                            if (i2 <= 0 || aw < 0 || aw > i2) {
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            com.tencent.mm.plugin.normsg.a.d dVar = com.tencent.mm.plugin.normsg.a.d.nZC;
                            if (i == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            String l = dVar.l(z, i2 == 0);
                            b.phI.Ea(l);
                            b.phI.bC(l, i);
                        }
                    } catch (Throwable th) {
                        w.printErrStackTrace("MicroMsg.PSIR", th, "unexpected exception was thrown.", new Object[0]);
                    }
                }
            });
        }
    }
}
