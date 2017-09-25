package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mm.bm.a.i;

public final class w {
    private static DisplayMetrics vpG = null;

    public static class a {
        public int jwE;
        public int jwF;
        public int qLb;
        public int vpH;

        public final String toString() {
            return " marginLeft:" + this.jwE + " marginRight:" + this.jwF;
        }
    }

    public static a a(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7 = 0;
        int i8 = 1;
        a aVar = new a();
        if (vpG == null) {
            vpG = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = vpG;
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(context, 95);
        if (i < fromDPToPix) {
            i = fromDPToPix;
        }
        if (i2 < 0) {
            aVar.jwE = 0;
            aVar.jwF = displayMetrics.widthPixels - ((i5 * 2) + i);
            fromDPToPix = 0;
            i6 = 1;
        } else if (displayMetrics.widthPixels - ((i2 + i) + (i5 * 2)) < 0) {
            aVar.jwE = (i2 - i) - i5;
            aVar.jwF = (displayMetrics.widthPixels - i2) - i5;
            fromDPToPix = 1;
            i6 = 0;
        } else {
            aVar.jwE = i2;
            aVar.jwF = displayMetrics.widthPixels - (i2 + i);
            fromDPToPix = 0;
            i6 = 1;
        }
        if (i3 < 0 || i3 > displayMetrics.heightPixels) {
            i3 = (int) (((float) displayMetrics.heightPixels) / 2.0f);
        }
        if (z) {
            if (i3 >= i4 + i5) {
                aVar.qLb = (i3 - i5) - i4;
            }
            aVar.qLb = i3 - i5;
            i8 = 0;
            i7 = 1;
        } else {
            if (displayMetrics.heightPixels - i3 < (i5 * 3) + i4) {
                aVar.qLb = (i3 - i5) - i4;
            }
            aVar.qLb = i3 - i5;
            i8 = 0;
            i7 = 1;
        }
        if (i8 != 0) {
            aVar.qLb -= i5 * 2;
        } else if (i7 != 0) {
            aVar.qLb += i5 * 2;
        }
        if (i6 == 0 || i7 == 0) {
            if (fromDPToPix != 0 && i7 != 0) {
                aVar.vpH = i.foD;
                return aVar;
            } else if (i6 != 0 && i8 != 0) {
                aVar.vpH = i.foB;
                return aVar;
            } else if (!(fromDPToPix == 0 || i8 == 0)) {
                aVar.vpH = i.wAt;
                return aVar;
            }
        }
        aVar.vpH = i.foC;
        return aVar;
    }
}
