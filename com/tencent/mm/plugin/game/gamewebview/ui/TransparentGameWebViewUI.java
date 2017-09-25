package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import com.tencent.mm.ui.base.a;

@a(1)
public class TransparentGameWebViewUI extends GameWebViewUI {
    protected final void KC() {
        super.KC();
        this.mmd.setBackgroundColor(0);
    }

    protected final void d(Intent intent, boolean z) {
        this.mmd.c(intent, z);
    }
}
