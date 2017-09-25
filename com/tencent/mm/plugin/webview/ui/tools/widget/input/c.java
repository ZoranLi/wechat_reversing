package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bi.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a;
import com.tencent.mm.sdk.platformtools.ab;

public class c {
    Context kLX;
    int kUW;
    int kUX;
    boolean soq = false;
    b sos;
    a sot;

    public final a bAk() {
        if (this.sos == null) {
            this.sos = new b();
            this.sos.kLX = this.kLX;
            this.sos.a(this);
        }
        return this.sos;
    }

    public static int[] Xf() {
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        return r1;
    }

    public e YX() {
        return e.bKD();
    }
}
