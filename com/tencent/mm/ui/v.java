package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ab;

public final class v {
    private static float omC = 0.0f;

    public static float dI(Context context) {
        float f = context.getSharedPreferences(ab.bIX(), 0).getFloat("text_size_scale_key", 1.0f);
        omC = f;
        return f;
    }

    public static void e(Context context, float f) {
        Editor edit = context.getSharedPreferences(ab.bIX(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        omC = f;
    }
}
