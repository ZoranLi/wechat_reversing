package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.d;
import com.tencent.mm.sdk.platformtools.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class g {

    static class AnonymousClass1 implements d {
        final /* synthetic */ Application fwf;
        final /* synthetic */ String fwg;

        AnonymousClass1(Application application, String str) {
            this.fwf = application;
            this.fwg = str;
        }

        public final void a(ai aiVar, String str, Throwable th) {
            Context context = this.fwf;
            String str2 = this.fwg;
            try {
                StringBuilder stringBuilder = new StringBuilder(2560);
                StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
                stringBuilderPrinter.println("#client.version=" + BaseBuildInfo.CLIENT_VERSION);
                stringBuilderPrinter.println("#accinfo.revision=" + BaseBuildInfo.codeRevision());
                String A = c.hgw.A("last_login_uin", "0");
                if (A == null || A.equals("0")) {
                    A = Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode());
                }
                stringBuilderPrinter.println("#accinfo.uin=" + A);
                StringBuilder append = new StringBuilder("#accinfo.runtime=").append(System.currentTimeMillis() - MMApplicationLike.sAppStartTime).append("(");
                if (str2 == null) {
                    str2 = "";
                }
                stringBuilderPrinter.println(append.append(str2).append(") by cup").toString());
                stringBuilderPrinter.println("#accinfo.build=" + BaseBuildInfo.TIME + ":" + BaseBuildInfo.HOSTNAME + ":0");
                A = "";
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    StatFs statFs2 = new StatFs(a.hgs);
                    int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
                    int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
                    str2 = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), a.hgs, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
                } catch (Exception e) {
                    str2 = A;
                }
                n.c(th);
                stringBuilderPrinter.println("#accinfo.data=" + str2);
                Date date = new Date();
                stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
                stringBuilderPrinter.println("#crashContent=");
                if (e.ae(ab.getContext()) == 1) {
                    str = str.substring(0, e.af(ab.getContext()));
                }
                e.d(ab.getContext(), ab.um(), "first");
                stringBuilderPrinter.println(str);
                w.e("MicroMsg.FirstCrashCatcher", "cpu catch crash:" + str);
                Intent intent = new Intent();
                intent.setAction("INTENT_ACTION_UNCATCH");
                intent.putExtra("INTENT_EXTRA_USER_NAME", c.hgw.A("login_user_name", "never_login_crash"));
                intent.putExtra("INTENT_EXTRA_EXCEPTION_MSG", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                intent.putExtra("INTENT_EXTRA_DATA_PATH", a.hgq + "crash/");
                intent.putExtra("INTENT_EXTRA_SDCARD_PATH", a.hgv);
                intent.putExtra("INTENT_EXTRA_UIN", c.hgw.A("last_login_uin", "0"));
                intent.putExtra("INTENT_EXTRA_CLIENT_VERSION", BaseBuildInfo.CLIENT_VERSION);
                intent.putExtra("INTENT_EXTRA_DEVICE_TYPE", BaseBuildInfo.DEVICE_TYPE);
                intent.putExtra("INTENT_EXTRA_TAG", "exception");
                String str3 = "INTENT_EXTRA_HOST";
                intent.putExtra(str3, "http://" + context.getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com"));
                intent.setClassName(context, context.getPackageName() + ".crash.CrashUploaderService");
                ab.getContext().startService(intent);
            } catch (Exception e2) {
            }
        }
    }
}
