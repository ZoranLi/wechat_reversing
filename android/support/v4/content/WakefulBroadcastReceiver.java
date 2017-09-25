package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<WakeLock> tH = new SparseArray();
    private static int tI = 1;

    public static ComponentName a(Context context, Intent intent) {
        synchronized (tH) {
            int i = tI;
            int i2 = tI + 1;
            tI = i2;
            if (i2 <= 0) {
                tI = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            tH.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean c(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (tH) {
            WakeLock wakeLock = (WakeLock) tH.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                tH.remove(intExtra);
                return true;
            }
            return true;
        }
    }
}
