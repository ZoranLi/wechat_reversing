package com.tencent.mm.ay;

import android.content.Context;
import com.tencent.mm.R;

public final class b {
    public static float aw(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static CharSequence s(Context context, int i) {
        if (i <= 0) {
            return context.getString(R.l.ejo, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
        }
        int i2 = i / 60;
        int i3 = i % 60;
        return context.getString(R.l.ejo, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
