package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.QbSdk;

public final class d {

    public static class a implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                w.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
                QbSdk.reset(context);
                af.f(new Runnable(this) {
                    final /* synthetic */ a gJN;

                    {
                        this.gJN = r1;
                    }

                    public final void run() {
                        Process.killProcess(Process.myPid());
                    }
                }, 5000);
            }
        }
    }

    public static class b implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                String stringExtra = intent.getStringExtra("tools_process_action_code_key");
                w.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = " + stringExtra);
                if (stringExtra.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
                    w.bIQ();
                    w.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", Boolean.valueOf(n.isLocked()));
                    if (!n.isLocked()) {
                        Process.killProcess(Process.myPid());
                    }
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
                    try {
                        QbSdk.clearAllWebViewCache(context.getApplicationContext(), true);
                    } catch (Exception e) {
                        w.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + e.getMessage());
                    }
                } else if (!stringExtra.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX")) {
                    if (stringExtra.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE")) {
                        w.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", Boolean.valueOf(intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)));
                        if (intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)) {
                            QbSdk.clearAllWebViewCache(context.getApplicationContext(), true);
                        } else {
                            QbSdk.clearAllWebViewCache(context.getApplicationContext(), false);
                        }
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
                        w.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
                        com.tencent.mm.pluginsdk.model.w.bCK();
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_LOCK_TOOLS_PROCESS")) {
                        n.lock();
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_UNLOCK_TOOLS_PROCESS")) {
                        n.unlock();
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
                        w.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
                        com.tencent.mm.pluginsdk.model.w.Y(intent);
                    }
                }
            }
        }
    }
}
