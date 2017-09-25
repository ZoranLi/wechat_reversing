package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class GameWebViewBaseActivity extends MMActivity {
    protected ae mHandler;
    protected int mnG = -1;
    private boolean mnH;
    private boolean mnI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ae();
        this.mnH = getIntent().getBooleanExtra("disable_swipe_back", false);
    }

    protected void onResume() {
        super.onResume();
        if (this.mnH) {
            if (this.uUD != null) {
                this.uUD.mEnable = false;
            }
        } else if (this.uUD != null) {
            this.uUD.mEnable = this.mnI;
        }
        azv();
    }

    protected final void q(Intent intent) {
        this.mnG = intent.getIntExtra("screen_orientation", -1);
    }

    protected void KC() {
        w.i("MicroMsg.GameWebViewBaseUI", "initView");
    }

    public final void ny(int i) {
        this.mnG = i;
        azv();
    }

    protected final void azv() {
        if (this.mnG != -1) {
            setRequestedOrientation(this.mnG);
            return;
        }
        this.uST = getSharedPreferences(ab.bIX(), 4).getBoolean("settings_landscape_mode", false);
        if (this.uST) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected final boolean aAc() {
        return getIntent().getBooleanExtra("from_shortcut", false);
    }

    public final void nz(int i) {
        if (!this.mnH) {
            if (aAc() || !aAd() || i > 1) {
                this.mnI = false;
                if (this.uUD != null) {
                    this.uUD.mEnable = false;
                    return;
                }
                return;
            }
            this.mnI = true;
            if (this.uUD != null) {
                this.uUD.mEnable = true;
            }
        }
    }

    protected boolean aAd() {
        return true;
    }

    protected int getLayoutId() {
        return -1;
    }
}
