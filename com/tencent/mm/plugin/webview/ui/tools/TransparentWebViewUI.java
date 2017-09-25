package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.ui.base.a;

@a(3)
public class TransparentWebViewUI extends GameWebViewUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.screenOrientation == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED) {
            this.screenOrientation = 0;
            if (this.scW != null) {
                this.scW.enable();
            }
        } else if (this.screenOrientation == MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED) {
            this.screenOrientation = 1;
            if (this.scW != null) {
                this.scW.enable();
            }
        }
    }

    protected final void KC() {
        super.KC();
        this.sez.scE = true;
        this.sez.iEh = false;
        this.sez.iQ(true);
        this.sez.wm(0);
        if (this.scU && this.scT != null) {
            this.scT.snF = false;
        }
    }

    protected final void bxP() {
        zf(0);
        this.uSU.ipu.setBackgroundResource(0);
        this.oET.setBackgroundResource(17170445);
        this.oET.setBackgroundColor(0);
        findViewById(R.h.cSv).setBackgroundResource(17170445);
    }
}
