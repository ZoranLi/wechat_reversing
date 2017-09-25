package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.bn.a;
import com.tencent.mm.booter.c;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public final class f extends e {
    public c gKC;
    public MMApplicationLike gZA;
    public a<ApplicationLifeCycle> gZB = new a();
    public e mProfileCompat;

    class AnonymousClass3 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ f gZC;
        final /* synthetic */ int gZD;

        public AnonymousClass3(f fVar, int i) {
            this.gZC = fVar;
            this.gZD = i;
        }

        public final /* synthetic */ void ao(Object obj) {
            ((ApplicationLifeCycle) obj).onTrimMemory(this.gZD);
        }
    }

    class AnonymousClass5 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ f gZC;
        final /* synthetic */ Configuration gZE;

        public AnonymousClass5(f fVar, Configuration configuration) {
            this.gZC = fVar;
            this.gZE = configuration;
        }

        public final /* synthetic */ void ao(Object obj) {
            ((ApplicationLifeCycle) obj).onConfigurationChanged(this.gZE);
        }
    }

    class AnonymousClass6 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ f gZC;
        final /* synthetic */ Context val$context;

        public AnonymousClass6(f fVar, Context context) {
            this.gZC = fVar;
            this.val$context = context;
        }

        public final /* synthetic */ void ao(Object obj) {
            ((ApplicationLifeCycle) obj).onBaseContextAttached(this.val$context);
        }
    }

    public final String getPackageName() {
        return ab.getPackageName();
    }

    public f(String str, Application application, MMApplicationLike mMApplicationLike) {
        super(str, application);
        ab.Pr(str);
        this.gZA = mMApplicationLike;
    }
}
