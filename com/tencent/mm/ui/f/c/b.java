package com.tencent.mm.ui.f.c;

import android.content.Context;

public final class b {
    private static a wfQ = null;

    public static void a(a aVar) {
        wfQ = aVar;
    }

    public static CharSequence a(Context context, CharSequence charSequence, int i) {
        if (wfQ != null) {
            return wfQ.a(context, charSequence, i);
        }
        return charSequence;
    }

    public static CharSequence a(Context context, CharSequence charSequence, float f) {
        if (wfQ != null) {
            return wfQ.a(context, charSequence, f);
        }
        return charSequence;
    }

    public static int m(Context context, String str, int i) {
        if (wfQ != null) {
            return wfQ.aG(str, i);
        }
        return i;
    }
}
