package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import com.tencent.mm.bn.f;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.s;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.y.n;
import java.io.File;

public class PluginZero extends d implements com.tencent.mm.plugin.zero.a.d {
    private a sAP = new a();
    private b sAQ = new b();
    public final com.tencent.mm.app.d sAR = new com.tencent.mm.app.d();
    public com.tencent.mm.plugin.zero.a.b sAS;
    public b sAT = new b();
    public a sAU = new a();

    public static final class a extends com.tencent.mm.bn.a<com.tencent.mm.plugin.zero.a.a> implements com.tencent.mm.plugin.zero.a.a {
        public final void a(final Service service) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.plugin.zero.a.a>(this) {
                final /* synthetic */ a sAX;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.plugin.zero.a.a) obj).a(service);
                }
            });
        }

        public final void b(final Service service) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.plugin.zero.a.a>(this) {
                final /* synthetic */ a sAX;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.plugin.zero.a.a) obj).b(service);
                }
            });
        }
    }

    public static final class b extends com.tencent.mm.bn.a<c> implements c {
        public final void a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
            final NotifyService notifyService2 = notifyService;
            final int i2 = i;
            final byte[] bArr3 = bArr;
            final byte[] bArr4 = bArr2;
            final long j2 = j;
            a(new com.tencent.mm.bn.a.a<c>(this) {
                final /* synthetic */ b sBd;

                public final /* synthetic */ void ao(Object obj) {
                    ((c) obj).a(notifyService2, i2, bArr3, bArr4, j2);
                }
            });
        }
    }

    public String toString() {
        return "plugin-zero";
    }

    public void installed() {
        alias(com.tencent.mm.plugin.zero.a.d.class);
    }

    public void dependency() {
        dependsOnRoot();
    }

    public void configure(final e eVar) {
        try {
            initSDRoot();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.PluginZero", e, "what happened?", new Object[0]);
        }
        ab.Pr(eVar.gWO);
        com.tencent.mm.kernel.a.a.a("configure [%s], setup broken library handler...", this);
        k.setupBrokenLibraryHandler();
        setupVendingLog();
        if (eVar.ej("")) {
            com.tencent.mm.kernel.a.a.a("configure [%s], for process[%s]...", this, eVar.gWO);
            h.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.c(this.sAP));
            h.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.c(this.sAQ));
            com.tencent.mm.kernel.a.a.a("configure [%s], make worker core...", this);
            h vJ = h.vJ();
            if (!vJ.gYT) {
                vJ.gYT = true;
                vJ.gYM = new com.tencent.mm.kernel.e(vJ.gYc, vJ.gXZ, vJ.gYR, vJ.gXX, vJ.gXY);
                vJ.gYN = new com.tencent.mm.kernel.a(vJ.gYP);
                vJ.gYO = new com.tencent.mm.kernel.b(vJ.gYQ, vJ.gXB);
            }
            h.vJ().a(new com.tencent.mm.kernel.api.h(this) {
                final /* synthetic */ PluginZero sAV;

                public final void oh() {
                    com.tencent.mm.kernel.a.a.a("onStartupDone", new Object[0]);
                }

                public final void ak(boolean z) {
                    if (z) {
                        com.tencent.mm.kernel.k.e(eVar.gZz, true);
                        com.tencent.mm.kernel.k.f(eVar.gZz, true);
                    }
                    w.bIP();
                }
            });
            h.vJ();
            f.wGi = new com.tencent.mm.vending.h.h(com.tencent.mm.bn.c.c(h.vL().bJl()), "WeChat.WORKER");
            g.a("WeChat.WORKER", f.wGi);
            new com.tencent.mm.plugin.zero.tasks.a().before(this);
            eVar.gZy.a(new com.tencent.mm.kernel.a.d(this) {
                final /* synthetic */ PluginZero sAV;

                {
                    this.sAV = r1;
                }

                public final void execute(e eVar) {
                    com.tencent.mm.kernel.a.a.a("startup final step, account initialize...", new Object[0]);
                    if (!com.tencent.mm.kernel.a.uP()) {
                        h.vG().initialize();
                    }
                }

                public final String name() {
                    return "final-task-account-initialize";
                }
            });
        }
        if (eVar.ej("") || eVar.ej(":push")) {
            new LoadProtocolJNITask().before(this);
        }
        com.tencent.mm.kernel.b.f fVar = (com.tencent.mm.kernel.b.f) eVar;
        w.i("MicroMsg.PluginZero", "oldversion:%s, newversion:%s, gettime:%d, settime:%d", fVar.gZA.mOldVersionCode, fVar.gZA.mNewVersionCode, Long.valueOf(fVar.gZA.mGetRevTime), Long.valueOf(fVar.gZA.mSetRevTime));
    }

    private void initSDRoot() {
        if (new File(com.tencent.mm.storage.w.hgq + "SdcardInfo.cfg").exists()) {
            String str;
            String str2 = com.tencent.mm.compatible.util.e.hgs;
            s sVar = new s(com.tencent.mm.storage.w.hgq + "SdcardInfo.cfg");
            String str3 = (String) sVar.get(1, "");
            int intValue = ((Integer) sVar.get(2, Integer.valueOf(0))).intValue();
            int i = VERSION.SDK_INT;
            if (bg.mA(str3)) {
                sVar.set(1, str2);
                sVar.set(2, Integer.valueOf(i));
                str = str2;
            } else {
                str = str3;
            }
            w.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", str3, str, str2, Integer.valueOf(intValue), Integer.valueOf(i));
            com.tencent.mm.compatible.util.e.dw(str);
            if (intValue != i && !com.tencent.mm.compatible.util.f.rZ()) {
                if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted") && new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    sVar.set(1, str2);
                    sVar.set(2, Integer.valueOf(i));
                    com.tencent.mm.compatible.util.e.dw(str2);
                    w.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", com.tencent.mm.compatible.util.e.hgs, Boolean.valueOf(com.tencent.mm.compatible.util.f.rZ()));
                    return;
                }
                w.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", com.tencent.mm.compatible.util.e.hgs, Boolean.valueOf(com.tencent.mm.compatible.util.f.rZ()), str2);
                return;
            }
            return;
        }
        com.tencent.mm.compatible.util.e.dw(com.tencent.mm.compatible.util.e.hgs);
        w.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", com.tencent.mm.compatible.util.e.hgs);
    }

    public void execute(final e eVar) {
        if (eVar.ej("")) {
            h.vJ().gYQ.bI(new com.tencent.mm.y.n.a(this) {
                final /* synthetic */ PluginZero sAV;

                public final void a(n nVar, boolean z) {
                }

                public final void a(n nVar) {
                    this.sAV.sAR.ad(eVar.gZz);
                }
            });
            NotifyReceiver.pX();
        }
    }

    private void setupVendingLog() {
        com.tencent.mm.vending.f.a.a(new com.tencent.mm.vending.f.a.a(this) {
            final /* synthetic */ PluginZero sAV;

            {
                this.sAV = r1;
            }

            public final void e(String str, String str2, Object... objArr) {
                w.e(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                w.w(str, str2, objArr);
            }

            public final void i(String str, String str2, Object... objArr) {
                w.i(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                w.d(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                w.printErrStackTrace(str, th, str2, objArr);
            }
        });
    }

    public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b bVar) {
        this.sAS = bVar;
    }

    public com.tencent.mm.vending.b.b addNotifyReceiverCallback(c cVar) {
        w.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", this, cVar);
        return this.sAT.bI(cVar);
    }

    public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a aVar) {
        return this.sAU.bI(aVar);
    }
}
