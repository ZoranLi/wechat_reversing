package com.tencent.mm.plugin.appbrand.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;

public abstract class e {
    public final BroadcastReceiver iAD = new BroadcastReceiver(this) {
        final /* synthetic */ e iAE;

        {
            this.iAE = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                d.vL().D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iAF;

                    {
                        this.iAF = r1;
                    }

                    public final void run() {
                        e eVar = this.iAF.iAE;
                        Activity activity = (Activity) eVar.iAz.get();
                        if (activity != null) {
                            PackageManager packageManager = activity.getPackageManager();
                            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                            RunningTaskInfo aa = bg.aa(activity, activity.getTaskId());
                            if (aa != null) {
                                try {
                                    ComponentName componentName = aa.topActivity;
                                    if (componentName != null && activityManager != null && packageManager != null) {
                                        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, FileUtils.S_IWUSR);
                                        if (activityInfo != null) {
                                            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                                if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == ck.CTRL_INDEX) && ((componentName.equals(runningAppProcessInfo.importanceReasonComponent) || runningAppProcessInfo.importanceReasonCode == 0) && runningAppProcessInfo.processName.equals(activityInfo.processName))) {
                                                    eVar.QH();
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    w.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "ScreenOff try confirm task top ui status, e = " + e);
                                }
                            }
                        }
                    }
                });
            }
        }
    };
    final WeakReference<Activity> iAz;

    public abstract void QH();

    public e(Activity activity) {
        this.iAz = new WeakReference(activity);
    }
}
