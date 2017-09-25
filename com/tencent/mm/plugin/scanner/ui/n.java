package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import com.tencent.mm.e.a.nn;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class n extends m {
    public n(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        w.d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
        Vibrator vibrator = (Vibrator) ab.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 50}, 1);
        }
        Bitmap bitmap = ((l) this.paH).pen;
        com.tencent.mm.sdk.b.b nnVar = new nn();
        nnVar.fUE.cardType = "identity";
        nnVar.fUE.fUF = 1;
        if (this.paH instanceof l) {
            nnVar.fUE.fUH = bitmap;
        }
        a.urY.a(nnVar, Looper.getMainLooper());
        this.paN.aYD().finish();
    }
}
