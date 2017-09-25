package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Method;

public final class RemoteController {
    private static Method ibq;
    private static Method ibr;
    private AudioManager ibo;
    private ComponentName ibp;

    public static class RemoteControlReceiver extends BroadcastReceiver {
        private static aj fyI;
        private static a ibs;

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                    if (fyI == null && ibs != null) {
                        w.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
                        fyI = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                            final /* synthetic */ RemoteControlReceiver ibt;

                            {
                                this.ibt = r1;
                            }

                            public final boolean oQ() {
                                w.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
                                RemoteControlReceiver.fyI = null;
                                return false;
                            }
                        }, true);
                    }
                    if (fyI != null) {
                        fyI.v(1000, 1000);
                        return;
                    }
                    return;
                }
                w.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + intent.getAction());
            }
        }

        public static void Lv() {
            ibs = null;
            if (fyI != null) {
                fyI.KH();
                fyI = null;
            }
        }
    }

    public interface a {
    }

    static {
        try {
            if (ibq == null) {
                ibq = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            if (ibr == null) {
                ibr = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
        } catch (NoSuchMethodException e) {
        }
    }

    protected final void finalize() {
        try {
            if (ibr != null) {
                ibr.invoke(this.ibo, new Object[]{this.ibp});
                RemoteControlReceiver.Lv();
            }
        } catch (Throwable e) {
            Throwable th = e;
            Throwable e2 = th.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException(th);
            }
        } catch (IllegalAccessException e3) {
            w.e("MicroMsg.RemoteControlReceiver", "unexpected " + e3);
        }
        super.finalize();
    }
}
