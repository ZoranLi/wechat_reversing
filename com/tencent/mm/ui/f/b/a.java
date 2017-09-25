package com.tencent.mm.ui.f.b;

import android.graphics.drawable.Drawable;

public final class a {
    private static c wfP = null;

    public static void a(c cVar) {
        wfP = cVar;
    }

    public static Drawable eW(String str, String str2) {
        if (wfP == null) {
            return null;
        }
        b bK = wfP.bK(str, str2);
        if (bK instanceof Drawable) {
            return (Drawable) bK;
        }
        return null;
    }
}
