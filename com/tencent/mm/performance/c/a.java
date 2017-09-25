package com.tencent.mm.performance.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.performance.d.b;
import com.tencent.mm.performance.d.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class a {
    private static a igt = new a();
    public static b igu = null;

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            w.i("MicroMsg.HARespReceiver", "received cmd: %s", intent.getAction());
            if ("ha_resp_action_send_result".equals(intent.getAction())) {
                if (intent.getIntExtra("ha_version", -1) == 2) {
                    final String string = intent.getExtras().getString("ha_hprof_filepath");
                    String string2 = intent.getExtras().getString("ha_obj_class");
                    String string3 = intent.getExtras().getString("ha_obj_key");
                    String string4 = intent.getExtras().getString("ha_result_refchain_logstr");
                    if (string4 == null || string4.length() == 0) {
                        w.e("MicroMsg.HARespReceiver", "object '%s' with key '%s' is not leaked, sometimes his method may hit this wrong case.", string2, string3);
                    } else {
                        w.i("MicroMsg.HARespReceiver", "analyse result: key:%s, class:%s, refchain:%s", string3, string2, string4);
                        Map hashMap = new HashMap();
                        hashMap.put("leaked_activity", string2);
                        if (a.igu != null) {
                            a.igu.a("UILeaksV2", string4, hashMap);
                        } else {
                            w.e("MicroMsg.HARespReceiver", "no report impl set!");
                        }
                    }
                    e.post(new Runnable(this) {
                        final /* synthetic */ a igx;

                        public final void run() {
                            new File(string).delete();
                        }
                    }, "del_hprof_file");
                    return;
                }
                w.e("MicroMsg.HARespReceiver", "analyzer version mismatch, expected: %s, actual: %s, ignored.", Integer.valueOf(2), Integer.valueOf(intent.getIntExtra("ha_version", -1)));
                return;
            }
            w.e("MicroMsg.HARespReceiver", "unknown command: %s", string);
        }
    }

    public static void h(Context context, final String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("ha_version", 2);
        intent.putExtra("ha_hprof_filepath", str);
        intent.putExtra("ha_obj_key", str2);
        intent.putExtra("ha_weakref_with_key_class", d.class.getName());
        String str3 = "mKey";
        for (Field field : d.class.getDeclaredFields()) {
            if (field.getAnnotation(b.class) != null) {
                str3 = field.getName();
            }
        }
        w.i("MicroMsg.HprofAnalyzerComm", "weakRef key field name: %s", str3);
        intent.putExtra("ha_weakref_key_attr_name", str3);
        intent.setClassName("com.tencent.mm.coolassist", "com.tencent.mm.coolassist.hprofanalyzer.BroadcastCmdReceiver");
        intent.setAction("ha_action_analyze_hprof");
        try {
            context.sendBroadcast(intent, "com.tencent.mm.debug.RECV_CMD");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.HprofAnalyzerComm", e, "Failed to wake up hprof analyzer app.", new Object[0]);
        }
        e.post(new Runnable() {
            public final void run() {
                for (File file : new File(str).getParentFile().listFiles(new FilenameFilter(this) {
                    final /* synthetic */ AnonymousClass1 igw;

                    {
                        this.igw = r1;
                    }

                    public final boolean accept(File file, String str) {
                        return str.endsWith(".hprof");
                    }
                })) {
                    if (System.currentTimeMillis() - file.lastModified() > TimeUnit.DAYS.toMillis(1)) {
                        file.delete();
                    }
                }
            }
        }, "clean_old_hprof");
    }

    public static void bl(Context context) {
        w.i("MicroMsg.HprofAnalyzerComm", "register receiver is called.");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ha_resp_action_send_result");
        context.registerReceiver(igt, intentFilter, "com.tencent.mm.debug.RECV_CMD", null);
    }

    public static boolean isEnabled() {
        return com.tencent.mm.sdk.a.b.bIs();
    }
}
