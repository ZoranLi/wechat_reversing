package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;

@a(19)
public class H5GameWebViewUI extends GameWebViewUI {
    private int nBA;
    private boolean siL;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.H5GameWebViewUI", "onCreate");
        this.mna = false;
        this.nBA = this.screenOrientation;
        this.siL = this.scU;
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
        setIntent(intent);
        String stringExtra = intent.getStringExtra("rawUrl");
        w.d("MicroMsg.H5GameWebViewUI", "url = " + stringExtra);
        if (!this.sdb.equals(stringExtra)) {
            if (stringExtra.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
                this.sdb = stringExtra;
            }
            if (this.fWY.equals(stringExtra)) {
                this.screenOrientation = this.nBA;
                this.scU = this.siL;
                return;
            }
            this.fWY = stringExtra;
            this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
            this.scU = getIntent().getBooleanExtra("show_full_screen", false);
            this.sdz.mlG = this.fWY;
            if (this.iYG == null) {
                this.iYG = new e(this, this.oET);
            } else {
                this.iYG.a(stringExtra, null, null);
            }
            this.oET.loadUrl("about:blank");
            super.j(this.fWY, false, -1);
        }
    }

    public void onResume() {
        azv();
        super.onResume();
    }

    protected final boolean byb() {
        return false;
    }
}
