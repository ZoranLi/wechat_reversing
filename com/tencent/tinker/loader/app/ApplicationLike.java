package com.tencent.tinker.loader.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;

public abstract class ApplicationLike implements ApplicationLifeCycle {
    private final Application application;
    private final long applicationStartElapsedTime;
    private final long applicationStartMillisTime;
    private final int tinkerFlags;
    private final boolean tinkerLoadVerifyFlag;
    private final Intent tinkerResultIntent;

    public ApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        this.application = application;
        this.tinkerFlags = i;
        this.tinkerLoadVerifyFlag = z;
        this.applicationStartElapsedTime = j;
        this.applicationStartMillisTime = j2;
        this.tinkerResultIntent = intent;
    }

    public Application getApplication() {
        return this.application;
    }

    public final Intent getTinkerResultIntent() {
        return this.tinkerResultIntent;
    }

    public final int getTinkerFlags() {
        return this.tinkerFlags;
    }

    public final boolean getTinkerLoadVerifyFlag() {
        return this.tinkerLoadVerifyFlag;
    }

    public long getApplicationStartElapsedTime() {
        return this.applicationStartElapsedTime;
    }

    public long getApplicationStartMillisTime() {
        return this.applicationStartMillisTime;
    }

    public void onCreate() {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
    }

    public void onTerminate() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onBaseContextAttached(Context context) {
    }

    public Resources getResources(Resources resources) {
        return resources;
    }

    public ClassLoader getClassLoader(ClassLoader classLoader) {
        return classLoader;
    }

    public AssetManager getAssets(AssetManager assetManager) {
        return assetManager;
    }

    public Object getSystemService(String str, Object obj) {
        return obj;
    }

    public Context getBaseContext(Context context) {
        return context;
    }
}
