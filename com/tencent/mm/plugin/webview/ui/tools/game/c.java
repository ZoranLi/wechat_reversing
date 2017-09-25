package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bg;

public final class c {
    public static String fUX;
    public static int gaA;
    public static String siM;

    public c(Intent intent) {
        if (intent != null) {
            fUX = bg.mz(intent.getStringExtra("KPublisherId"));
            siM = bg.mz(intent.getStringExtra("geta8key_username"));
            gaA = bg.f(Integer.valueOf(intent.getIntExtra("geta8key_scene", 0)));
        }
    }
}
