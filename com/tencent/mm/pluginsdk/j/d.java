package com.tencent.mm.pluginsdk.j;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class d {
    public static void a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (VERSION.SDK_INT >= 11) {
            e eVar = new e();
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
            return;
        }
        f fVar = new f();
        ((android.text.ClipboardManager) context.getSystemService("clipboard")).setText(charSequence2);
    }
}
