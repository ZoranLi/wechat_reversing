package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import com.tencent.mm.app.g.AnonymousClass1;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

public class MMApplicationLike extends DefaultApplicationLike {
    private static final String NO_SPACE_FOR_DEX_PROCESS = ":nospace";
    private static final String TAG = "MicroMsg.MMApplication";
    public static MMApplicationLike applicationLike;
    public static String hash = "";
    public static long sAppStartTime;
    public long mGetRevTime;
    public String mNewVersionCode;
    public String mOldVersionCode;
    public long mSetRevTime;
    private ApplicationLifeCycle wrapper;

    public static ApplicationLike getTinkerApplicationLike() {
        return applicationLike;
    }

    public MMApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
    }

    private void setPatchRev(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike == null || applicationLike.getApplication() == null) {
                throw new TinkerRuntimeException("tinkerApplication is null");
            }
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            HashMap at = (tinkerResultIntent == null || ShareIntentUtil.an(tinkerResultIntent) != 0) ? null : ShareIntentUtil.at(tinkerResultIntent);
            if (at != null) {
                BaseBuildInfo.PATCH_REV = (String) at.get("patch.rev");
                w.w(TAG, "application set patch rev:%s", BaseBuildInfo.PATCH_REV);
            }
        }
    }

    public void onBaseContextAttached(Context context) {
        super.onBaseContextAttached(context);
        sAppStartTime = getApplicationStartMillisTime();
        applicationLike = this;
        setPatchRev(applicationLike);
        hash += "/" + hashCode();
        ab.jR(false);
        ab.setContext(getApplication());
        String q = d.q(context, Process.myPid());
        w.yu(0);
        Application application = getApplication();
        if (!"com.tencent.mm:cuploader".equals(q)) {
            ai.a(new AnonymousClass1(application, q));
            ai.a(new a() {
                public final void oi() {
                    String str = BaseBuildInfo.PATCH_REV;
                }
            });
        }
        boolean endsWith = q.endsWith(NO_SPACE_FOR_DEX_PROCESS);
        clearOldDirIfNewVersion();
        if (!endsWith) {
            com.tencent.mm.d.a.b(getApplication(), false);
        }
        try {
            this.wrapper = (ApplicationLifeCycle) Class.forName(ab.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[]{MMApplicationLike.class, String.class}).newInstance(new Object[]{this, q});
            this.wrapper.onBaseContextAttached(context);
        } catch (Throwable e) {
            w.printErrStackTrace(TAG, e, "failed to create application wrapper class", new Object[0]);
            throw new RuntimeException("failed to create application wrapper class", e);
        }
    }

    private void clearOldDirIfNewVersion() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.e.a aVar = new com.tencent.mm.sdk.e.a(com.tencent.mm.loader.stub.a.hgq + "NowRev.ini");
        this.mOldVersionCode = aVar.getValue("NowRev");
        this.mNewVersionCode = BaseBuildInfo.baseRevision();
        long currentTimeMillis2 = System.currentTimeMillis();
        this.mGetRevTime = currentTimeMillis2 - currentTimeMillis;
        this.mSetRevTime = 0;
        if (!this.mNewVersionCode.equals(this.mOldVersionCode)) {
            ab.usY = true;
            b.e(getApplication().getDir("lib", 0));
            b.e(getApplication().getDir("dex", 0));
            b.e(getApplication().getDir("cache", 0));
            b.e(getApplication().getDir("recover_lib", 0));
            com.tencent.tinker.lib.d.b.d(applicationLike);
            aVar.eC("NowRev", this.mNewVersionCode);
            this.mSetRevTime = System.currentTimeMillis() - currentTimeMillis2;
            w.w(TAG, "application hash:%s, %s", hash, new ah().toString());
        }
        w.i(TAG, "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", this.mOldVersionCode, this.mNewVersionCode, Long.valueOf(this.mGetRevTime), Long.valueOf(this.mSetRevTime));
    }

    public void onCreate() {
        if (this.wrapper != null) {
            this.wrapper.onCreate();
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (this.wrapper != null) {
            this.wrapper.onTerminate();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        w.d(TAG, "configuration changed");
        super.onConfigurationChanged(configuration);
        if (this.wrapper != null) {
            this.wrapper.onConfigurationChanged(configuration);
        }
    }

    public Resources getResources(Resources resources) {
        return ab.getResources() == null ? resources : ab.getResources();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.wrapper != null) {
            this.wrapper.onLowMemory();
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.wrapper != null) {
            this.wrapper.onTrimMemory(i);
        }
    }
}
