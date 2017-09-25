package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashSet;

public final class c {
    private static HashSet<String> xmA = new HashSet();
    private static String xmz;

    public interface a {
        void QH();
    }

    public static class b {
        public b(Context context, final a aVar) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver(this) {
                final /* synthetic */ b xmC;

                public final void onReceive(Context context, Intent intent) {
                    com.tencent.tinker.lib.e.a.i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[]{intent == null ? "" : intent.getAction()});
                    if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                        context.unregisterReceiver(this);
                        if (aVar != null) {
                            aVar.QH();
                        }
                    }
                }
            }, intentFilter);
        }
    }

    public static String chW() {
        if (xmz == null) {
            return "";
        }
        return xmz;
    }

    public static boolean chX() {
        if (xmz == null) {
            return false;
        }
        return xmA.contains(xmz);
    }
}
