package com.tencent.mm.plugin.card.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class p {
    public static void I(Context context, String str) {
        if (VERSION.SDK_INT >= 11) {
            n nVar = new n();
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            return;
        }
        o oVar = new o();
        ((android.text.ClipboardManager) context.getSystemService("clipboard")).setText(str);
    }
}
