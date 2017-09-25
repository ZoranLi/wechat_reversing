package com.tencent.mm.app;

import android.content.ComponentName;
import android.os.Process;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.booter.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;

public class f extends e implements h {
    private static boolean fvY = false;
    public boolean fvZ = false;
    private b fwa = null;

    public final void od() {
        super.od();
        k.b("stlport_shared", f.class.getClassLoader());
        ab.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        com.tencent.mm.kernel.b.f fVar = (com.tencent.mm.kernel.b.f) h.vF().vj();
        k.b(a.urP, f.class.getClassLoader());
        fVar.gKC = c.ao(fVar.gZz);
        c cVar = fVar.gKC;
        if (fVar.ej("")) {
            cVar.cR("MM");
        } else if (fVar.ej(":push")) {
            cVar.cR("PUSH");
        } else if (fVar.ej(":tools")) {
            cVar.cR("TOOL");
        } else if (fVar.ej(":sandbox")) {
            cVar.cR("SANDBOX");
        } else if (fVar.ej(":exdevice")) {
            cVar.cR("EXDEVICE");
        } else if (fVar.ej(":patch")) {
            cVar.cR("PATCH");
        } else if (fVar.ej(":appbrand")) {
            cVar.cR("APPBRAND");
        } else if (fVar.ej(":TMAssistantDownloadSDKService")) {
            cVar.cR("TMSDK");
        }
        com.tencent.mm.kernel.a.a.a("Hello WeChat, DefaultBootStep load debugger and init xlog...", new Object[0]);
        k.bi(((com.tencent.mm.kernel.b.f) h.vF().vj()).gWO);
        m.d(com.tencent.mm.boot.a.a.class);
        m.bl("com.tencent.mm.boot");
    }

    public final void oe() {
        h.vE().gXT = n.class;
        e.f(PluginZero.class);
        e.f(PluginMessengerFoundation.class);
        e.f(PluginReport.class);
        e.f(PluginAuth.class);
        e.f(PluginBigBallOfMud.class);
        e.f(PluginRecovery.class);
        ei("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
        ei("com.tencent.mm.plugin.performance.PluginPerformance");
        ei("com.tencent.mm.plugin.comm.PluginComm");
        ei("com.tencent.mm.plugin.chatroom.PluginChatroom");
        ei("com.tencent.mm.plugin.audio.PluginVoice");
        ei("com.tencent.mm.plugin.biz.PluginBiz");
        ei("com.tencent.mm.plugin.notification.PluginNotification");
        ei("com.tencent.mm.plugin.messenger.PluginMessenger");
        ei("com.tencent.mm.plugin.welab.PluginWelab");
        ei("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
        ei("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
        ei("com.tencent.mm.plugin.uishow.PluginUIShow");
        ei("com.tencent.mm.plugin.emoji.PluginEmoji");
        ei("com.tencent.mm.plugin.video.PluginVideo");
        ei("com.tencent.mm.plugin.sport.PluginSport");
        ei("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
        ei("com.tencent.mm.plugin.fts.PluginFTS");
        ei("com.tencent.mm.plugin.sns.PluginSns");
        ei("com.tencent.mm.plugin.downloader.PluginDownloader");
        ei("com.tencent.mm.plugin.fav.PluginFavorite");
        ei("com.tencent.mm.plugin.music.PluginMusic");
        ei("com.tencent.mm.plugin.facedetect.PluginFace");
        ei("com.tencent.mm.plugin.soter.PluginSoter");
        ei("com.tencent.mm.plugin.mmsight.PluginMMSight");
        ei("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
        ei("com.tencent.mm.plugin.normsg.PluginNormsg");
    }

    protected final boolean of() {
        com.tencent.mm.kernel.b.e vj = h.vF().vj();
        if (vj.ej(":sandbox") || vj.ej(":nospace")) {
            return false;
        }
        return true;
    }

    protected final void a(final com.tencent.mm.kernel.b.e eVar, com.tencent.mm.vending.g.c<Void> cVar, d dVar) {
        super.a(eVar, (com.tencent.mm.vending.g.c) cVar, dVar);
        if (of()) {
            cVar.a(dVar).a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                final /* synthetic */ f fwc;

                public final /* synthetic */ Object call(Object obj) {
                    com.tencent.mm.kernel.a.a.a(new com.tencent.mm.plugin.zero.tasks.c(), eVar);
                    return wCE;
                }
            });
        }
    }

    public final boolean og() {
        if (!fvY) {
            w.w("MicroMsg.DefaultBootStep", "--- not executeTasksDelay, why go here?");
            return false;
        } else if (this.fvZ) {
            w.w("MicroMsg.DefaultBootStep", "--- mTaskExecuted = true, why go here again?");
            return false;
        } else {
            this.fvZ = true;
            w.i("MicroMsg.DefaultBootStep", "--- executeTasksDelay");
            com.tencent.mm.kernel.b.e vj = h.vF().vj();
            if (j.fww == null) {
                j.fww = new j("initThread");
            }
            final j jVar = j.fww;
            if (jVar.fwx == null || !jVar.fwx.isAlive()) {
                w.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            } else {
                int threadId = jVar.fwx.getThreadId();
                try {
                    if (-8 == Process.getThreadPriority(threadId)) {
                        w.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                    } else {
                        Process.setThreadPriority(threadId, -8);
                        w.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
                    }
                } catch (Throwable e) {
                    w.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
                    w.printErrStackTrace("MicroMsg.InitThreadController", e, "", new Object[0]);
                }
            }
            h.vJ().a(new com.tencent.mm.kernel.api.h(this) {
                final /* synthetic */ f fwc;

                public final void oh() {
                    jVar.fwx.quit();
                    h.vJ().b(this);
                }

                public final void ak(boolean z) {
                }
            });
            super.a(vj, jVar.fwy, this.fwa);
            return true;
        }
    }

    public final void a(com.tencent.mm.kernel.b.e eVar, d dVar, b bVar) {
        fvY = false;
        if (eVar.ej("")) {
            Object[] objArr;
            String str;
            String str2;
            Object[] objArr2;
            String str3;
            Object[] objArr3;
            String str4;
            ComponentName er = bg.er(ab.getContext());
            if (er != null && er.getPackageName().equals(ab.getPackageName()) && er.getClassName().equals(ab.bIV())) {
                fvY = true;
                WorkerProfile.fvY = true;
                objArr = new Object[1];
                str = "MicroMsg.DefaultBootStep";
                str2 = "summerboot executeTasks sStartupOnInitThread true currentActivity[%s]";
                objArr2 = objArr;
            } else {
                str2 = "MicroMsg.DefaultBootStep";
                String str5 = "summerboot executeTasks sStartupOnInitThread false currentActivity[%s]";
                objArr = new Object[1];
                if (er == null) {
                    str3 = str2;
                    objArr3 = objArr;
                    Object[] objArr4 = objArr;
                    str4 = "NULL";
                    str = str5;
                    objArr2 = objArr4;
                    objArr2[0] = str4;
                    w.i(str3, str, objArr3);
                } else {
                    str = str2;
                    str2 = str5;
                    objArr2 = objArr;
                }
            }
            String className = er.getClassName();
            str3 = str;
            str = str2;
            objArr3 = objArr2;
            objArr2 = objArr;
            str4 = className;
            objArr2[0] = str4;
            w.i(str3, str, objArr3);
        }
        if (fvY) {
            w.i("MicroMsg.DefaultBootStep", "summerboot executeTasks sStartupOnInitThread but -- Skip execute mTaskExecuted[%b]", Boolean.valueOf(this.fvZ));
            this.fwa = bVar;
            if (!this.fvZ) {
                af.f(new Runnable(this) {
                    final /* synthetic */ f fwc;

                    {
                        this.fwc = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.DefaultBootStep", "summerboot executeTasks sStartupOnInitThread executeTasksDelay 2s mTaskExecuted[%b]", Boolean.valueOf(this.fwc.fvZ));
                        if (this.fwc.fvZ) {
                            w.i("MicroMsg.DefaultBootStep", "summerboot executeTasks sStartupOnInitThread executeTasksDelay but has executed -- Skip");
                        } else {
                            this.fwc.og();
                        }
                    }
                }, 2000);
                return;
            }
            return;
        }
        this.fvZ = true;
        super.a(eVar, dVar, bVar);
    }
}
