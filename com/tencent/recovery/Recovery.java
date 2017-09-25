package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.f.i;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.util.Util;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class Recovery {
    private static Application application;
    public static Context context;
    public static RecoveryMessageHandler wPT;
    public static long wPU;
    private static CommonOptions wPV;
    public static String wPW;
    private static boolean wPX = false;
    public static boolean wPY = false;
    public static int wPZ = 0;
    private static ActivityLifecycleCallbacks wQa = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (!Recovery.wPY && !Recovery.wPT.hasMessages(3)) {
                Recovery.wPT.removeCallbacksAndMessages(null);
                String ft = Util.ft(Recovery.context);
                Editor edit = Recovery.context.getSharedPreferences(Recovery.wPW, 0).edit();
                edit.putInt("KeyComponentOnCreateForeground", 1);
                edit.putInt("KeyComponentOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
                edit.apply();
                Recovery.wPT.sendEmptyMessageDelayed(3, (long) OptionFactory.dh(ft, 1).jbJ);
                RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", ft, Long.valueOf(System.currentTimeMillis() - Recovery.wPU));
            }
        }

        public final void onActivityStarted(Activity activity) {
            Recovery.wPZ++;
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            int i = Recovery.wPZ - 1;
            Recovery.wPZ = i;
            if (i == 0) {
                RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", Util.ft(Recovery.context));
                Recovery.CQ(16);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };

    public static void eF() {
        RecoveryLog.i("Recovery", "initStatic Run", new Object[0]);
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
        try {
            System.loadLibrary("recovery");
        } catch (Throwable e) {
            RecoveryLog.printErrStackTrace("Recovery", e, "load recovery library", new Object[0]);
        }
        wPU = System.currentTimeMillis();
        wPT = new RecoveryMessageHandler();
    }

    public static void a(Application application, Context context) {
        application = application;
        context = context;
        wPV = OptionFactory.fq(context);
        if (application != null) {
            application.registerActivityLifecycleCallbacks(wQa);
        }
        String ft = Util.ft(context);
        if (RecoveryLogic.fp(context)) {
            if (wPV.wQw) {
                RecoveryLog.Ie();
            }
            RecoveryLog.a(new RecoveryFileLog(context));
            cdv();
            RecoveryLog.i("Recovery", "recovery process, no need to do any thing", new Object[0]);
            return;
        }
        int i;
        RecoveryLog.i("Recovery", "%s attachBaseContext start ============================== %d", ft, Long.valueOf(System.currentTimeMillis() - wPU));
        wPW = "recovery-" + ft;
        SharedPreferences sharedPreferences = context.getSharedPreferences(wPW, 0);
        String string = sharedPreferences.getString("KeyRecoveryVersion", "");
        Editor edit = sharedPreferences.edit();
        if (!string.equals(wPV.clientVersion)) {
            edit.clear();
            edit.putString("KeyRecoveryVersion", wPV.clientVersion);
            edit.apply();
            RecoveryLog.i("Recovery", "recovery sp version not equal lastVersion %s currentVersion %s", string, wPV.clientVersion);
            edit = sharedPreferences.edit();
        }
        RecoveryContext recoveryContext = new RecoveryContext();
        recoveryContext.f(sharedPreferences);
        RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
        recoveryStatusItem.processName = ft;
        recoveryStatusItem.clientVersion = wPV.clientVersion;
        recoveryStatusItem.mry = wPV.mry;
        recoveryStatusItem.timestamp = System.currentTimeMillis();
        if (sharedPreferences.contains("KeyAppOnCreateExceptionType")) {
            RecoveryLog.i("Recovery", "contains KeyAppOnCreateExceptionType", new Object[0]);
            recoveryStatusItem.wQd = sharedPreferences.getInt("KeyAppOnCreateForeground", 17);
            recoveryStatusItem.wQg = sharedPreferences.getInt("KeyAppOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
            recoveryStatusItem.wQf = 1;
        } else if (sharedPreferences.contains("KeyComponentOnCreateExceptionType")) {
            RecoveryLog.i("Recovery", "contains KeyComponentOnCreateExceptionType", new Object[0]);
            recoveryStatusItem.wQd = sharedPreferences.getInt("KeyAppOnCreateForeground", 17);
            recoveryStatusItem.wQg = sharedPreferences.getInt("KeyComponentOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
            recoveryStatusItem.wQf = 16;
        } else {
            recoveryContext.clear();
            if (!sharedPreferences.contains("KeyAppOnCreateNormalType")) {
                RecoveryLog.i("Recovery", "DefaultNormal", new Object[0]);
                recoveryStatusItem.wQd = 17;
                recoveryStatusItem.wQg = i.CTRL_INDEX;
                recoveryStatusItem.wQf = 1;
            } else if (sharedPreferences.contains("KeyComponentOnCreateNormalType")) {
                RecoveryLog.i("Recovery", "contains KeyComponentOnCreateNormalType", new Object[0]);
                recoveryStatusItem.wQd = sharedPreferences.getInt("KeyAppOnCreateForeground", 17);
                recoveryStatusItem.wQg = sharedPreferences.getInt("KeyComponentOnCreateNormalType", i.CTRL_INDEX);
                recoveryStatusItem.wQf = 16;
            } else {
                RecoveryLog.i("Recovery", "contains KeyAppOnCreateNormalType", new Object[0]);
                recoveryStatusItem.wQd = sharedPreferences.getInt("KeyAppOnCreateForeground", 17);
                recoveryStatusItem.wQg = sharedPreferences.getInt("KeyAppOnCreateNormalType", i.CTRL_INDEX);
                recoveryStatusItem.wQf = 1;
            }
        }
        switch (recoveryStatusItem.wQg) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
            case 65536:
            case 1048576:
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        if (i != 0) {
            if (recoveryContext.wQb.size() > 15) {
                recoveryContext.wQb.remove(0);
            }
            recoveryContext.wQb.add(recoveryStatusItem);
            RecoveryLogic.a(context, recoveryStatusItem, RecoveryReportService.class.getName());
        }
        edit.remove("KeyAppOnCreateForeground");
        edit.remove("KeyAppOnCreateExceptionType");
        edit.remove("KeyAppOnCreateNormalType");
        edit.remove("KeyComponentOnCreateForeground");
        edit.remove("KeyComponentOnCreateExceptionType");
        edit.remove("KeyComponentOnCreateNormalType");
        i = RecoveryLogic.bq(context, ft);
        RecoveryLog.i("Recovery", "processStartFlag %s %s", ft, Integer.toHexString(i));
        if (OptionFactory.dh(ft, i).wQA.cY(recoveryContext.wQb)) {
            RecoveryLogic.a(context, wPV, recoveryContext);
            recoveryContext.clear();
            cdv();
        } else {
            edit.putInt("KeyAppOnCreateForeground", i);
            edit.putInt("KeyComponentOnCreateForeground", i);
            edit.putInt("KeyAppOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
        }
        recoveryContext.a(edit);
        edit.apply();
        RecoveryLog.i("Recovery", "%s attachBaseContext end ============================== %d", ft, Long.valueOf(System.currentTimeMillis() - wPU));
    }

    public static void cds() {
        if (!wPY && !wPX) {
            wPX = true;
            String ft = Util.ft(context);
            int bq = RecoveryLogic.bq(context, ft);
            RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", ft, Long.valueOf(System.currentTimeMillis() - wPU));
            Editor edit = context.getSharedPreferences(wPW, 0).edit();
            edit.remove("KeyAppOnCreateExceptionType");
            edit.putInt("KeyAppOnCreateNormalType", 256);
            if (RecoveryLogic.bq(context, ft) == 16) {
                edit.putInt("KeyComponentOnCreateForeground", bq);
                edit.putInt("KeyComponentOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
                wPT.sendEmptyMessageDelayed(2, (long) OptionFactory.dh(ft, bq).jbJ);
            }
            edit.apply();
        }
    }

    private static void destroy() {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(wQa);
        }
    }

    public static void cdt() {
        if (context != null && !wPY) {
            cdv();
            RecoveryLog.i("Recovery", "%s Recovery.crash %d", Util.ft(context), Long.valueOf(System.currentTimeMillis() - wPU));
            Editor edit = context.getSharedPreferences(wPW, 0).edit();
            if (wPX) {
                edit.putInt("KeyComponentOnCreateExceptionType", 65536);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 65536);
            }
            edit.apply();
            destroy();
        }
    }

    public static void cdu() {
        if (context != null && !wPY) {
            cdv();
            RecoveryLog.i("Recovery", "%s Recovery.anr %d", Util.ft(context), Long.valueOf(System.currentTimeMillis() - wPU));
            Editor edit = context.getSharedPreferences(wPW, 0).edit();
            if (wPX) {
                edit.putInt("KeyComponentOnCreateExceptionType", 1048576);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 1048576);
            }
            edit.apply();
            destroy();
        }
    }

    public static void CQ(int i) {
        if (context != null && !wPY) {
            cdv();
            String ft = Util.ft(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(wPW, 0);
            RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", ft, Integer.toHexString(i), Long.valueOf(System.currentTimeMillis() - wPU));
            wPT.removeCallbacksAndMessages(null);
            Editor edit = sharedPreferences.edit();
            edit.remove("KeyComponentOnCreateExceptionType");
            edit.putInt("KeyComponentOnCreateNormalType", i);
            edit.apply();
            destroy();
        }
    }

    public static Context getContext() {
        return context;
    }

    private static void cdv() {
        if (context != null && !wPY) {
            RecoveryLog.i("Recovery", "%s markFinalStatus", Util.ft(context));
            wPY = true;
        }
    }
}
