package com.tencent.mm.af;

import android.os.HandlerThread;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class a implements am {
    private static HandlerThread hDX = null;
    private static ae hDY = null;

    public static boolean a(Runnable runnable, long j) {
        boolean z = false;
        if (runnable == null) {
            return false;
        }
        if (hDY == null || hDX == null) {
            String str = "MicroMsg.GIF.SubCoreGIF";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(hDY != null);
            if (hDX != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bg.bJZ();
            w.w(str, str2, objArr);
            if (hDY != null) {
                hDY.removeCallbacksAndMessages(null);
            }
            if (hDX != null) {
                hDX.quit();
            }
            HandlerThread Qu = e.Qu("GIF-Decoder");
            hDX = Qu;
            Qu.start();
            hDY = new ae(hDX.getLooper());
        }
        if (j > 0) {
            hDY.postDelayed(runnable, j);
        } else {
            hDY.post(runnable);
        }
        return true;
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        if (hDY != null) {
            hDY.removeCallbacksAndMessages(null);
        }
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        if (hDY != null) {
            hDY.removeCallbacksAndMessages(null);
        }
    }
}
