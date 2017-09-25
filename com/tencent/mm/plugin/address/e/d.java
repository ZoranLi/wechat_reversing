package com.tencent.mm.plugin.address.e;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class d {
    public static void I(Context context, String str) {
        if (VERSION.SDK_INT >= 11) {
            b bVar = new b();
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            return;
        }
        c cVar = new c();
        ((android.text.ClipboardManager) context.getSystemService("clipboard")).setText(str);
    }
}
