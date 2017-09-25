package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.f.AnonymousClass3;
import com.tencent.mm.kernel.b.f.AnonymousClass5;
import com.tencent.mm.kernel.b.f.AnonymousClass6;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.i;
import com.tencent.mm.vending.h.d;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import junit.framework.Assert;

public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final MMApplicationLike lifeCycle;
    private f profile = null;
    private String thisProcess = "";

    public MMApplicationWrapper(MMApplicationLike mMApplicationLike, String str) {
        this.app = mMApplicationLike.getApplication();
        this.lifeCycle = mMApplicationLike;
        this.thisProcess = str;
    }

    public void onBaseContextAttached(Context context) {
        h.a(this.thisProcess, this.app, this.lifeCycle);
        h.vJ();
        this.profile = (f) h.vF().vj();
        f fVar = this.profile;
        fVar.gZB.a(new AnonymousClass6(fVar, context));
    }

    public void onCreate() {
        try {
            f fVar = this.profile;
            fVar.gZB.a(new a<ApplicationLifeCycle>(fVar) {
                final /* synthetic */ f gZC;

                {
                    this.gZC = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((ApplicationLifeCycle) obj).onCreate();
                }
            });
            com.tencent.mm.kernel.a.a aVar = this.profile.gZy;
            b fVar2 = new f();
            Assert.assertNotNull(fVar2);
            i.vN().vF().vj();
            aVar.gZq = fVar2;
            i iVar = h.vJ().gYJ;
            synchronized (iVar.gZe) {
                if (iVar.gZf) {
                    com.tencent.mm.kernel.a.a.a("warning, mmskeleton has started up already.", new Object[0]);
                    return;
                }
                e vj = iVar.vF().vj();
                long timestamp = com.tencent.mm.kernel.a.a.timestamp();
                com.tencent.mm.kernel.a.a.a("mmskeleton boot startup for process [%s]...", vj.gWO);
                com.tencent.mm.kernel.a.a aVar2 = vj.gZy;
                Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", aVar2.gZq);
                com.tencent.mm.kernel.a.a.a("hello WeChat.", new Object[0]);
                aVar2.gZq.od();
                long timestamp2 = com.tencent.mm.kernel.a.a.timestamp();
                com.tencent.mm.kernel.a.a.a("boot install plugins...", new Object[0]);
                aVar2.gZq.oe();
                Object[] objArr = new Object[1];
                i.vN();
                objArr[0] = i.vE().gXN;
                com.tencent.mm.kernel.a.a.a("boot all installed plugins : %s...", objArr);
                com.tencent.mm.kernel.a.a.a("boot install plugins done in [%s].", com.tencent.mm.kernel.a.a.H(timestamp2));
                timestamp2 = com.tencent.mm.kernel.a.a.timestamp();
                com.tencent.mm.kernel.a.a.a("boot make dependency of plugins...", new Object[0]);
                aVar2.gZq.vO();
                com.tencent.mm.kernel.a.a.a("boot make dependency of done in [%s].", com.tencent.mm.kernel.a.a.H(timestamp2));
                timestamp2 = com.tencent.mm.kernel.a.a.timestamp();
                com.tencent.mm.kernel.a.a.a("boot configure plugins...", new Object[0]);
                aVar2.gZq.c(vj);
                com.tencent.mm.kernel.a.a.a("boot configure plugins done in [%s].", com.tencent.mm.kernel.a.a.H(timestamp2));
                d dVar = d.wDA;
                com.tencent.mm.vending.g.d.b anonymousClass1 = new com.tencent.mm.kernel.i.AnonymousClass1(iVar, timestamp);
                com.tencent.mm.kernel.a.a.a("boot execute tasks...", new Object[0]);
                aVar2.gZq.a(vj, dVar, anonymousClass1);
            }
        } catch (final Throwable th) {
            new Handler().postAtFrontOfQueue(new Runnable(this) {
                final /* synthetic */ MMApplicationWrapper fwA;

                public final void run() {
                    throw th;
                }
            });
        }
    }

    public void onTerminate() {
        if (this.profile != null) {
            f fVar = this.profile;
            fVar.gZB.a(new a<ApplicationLifeCycle>(fVar) {
                final /* synthetic */ f gZC;

                {
                    this.gZC = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((ApplicationLifeCycle) obj).onTerminate();
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.profile != null) {
            f fVar = this.profile;
            fVar.gZB.a(new AnonymousClass5(fVar, configuration));
        }
    }

    public void onLowMemory() {
        if (this.profile != null) {
            f fVar = this.profile;
            fVar.gZB.a(new a<ApplicationLifeCycle>(fVar) {
                final /* synthetic */ f gZC;

                {
                    this.gZC = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((ApplicationLifeCycle) obj).onLowMemory();
                }
            });
        }
    }

    public void onTrimMemory(int i) {
        if (this.profile != null) {
            f fVar = this.profile;
            fVar.gZB.a(new AnonymousClass3(fVar, i));
        }
    }
}
