package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.model.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.model.GameWebViewLaunchParams;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class GameWebViewUI extends GameWebViewBaseActivity {
    protected c mmd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.GameWebViewUI", "onCreate");
        this.mHandler = new ae();
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        KC();
    }

    public void onNewIntent(Intent intent) {
        w.i("MicroMsg.GameWebViewUI", "onNewIntent");
        setIntent(intent);
        d(intent, false);
    }

    protected void onResume() {
        super.onResume();
        w.i("MicroMsg.GameWebViewUI", "onResume");
        b bVar = (b) this.mmd.mmi.peek();
        if (bVar != null) {
            bVar.Vz();
        }
    }

    public void onPause() {
        super.onPause();
        w.i("MicroMsg.GameWebViewUI", "onPause");
        b bVar = (b) this.mmd.mmi.peek();
        if (bVar != null) {
            bVar.ez(true);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.GameWebViewUI", "onDestroy");
        this.mmd.Po();
        System.gc();
    }

    protected void KC() {
        View frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(17170443);
        frameLayout.setId(R.h.bSE);
        setContentView(frameLayout);
        this.mmd = new c(this);
        this.mmd.setBackgroundResource(17170443);
        this.mmd.setId(R.h.bSO);
        frameLayout.addView(this.mmd);
        d(getIntent(), true);
    }

    protected void d(Intent intent, boolean z) {
        this.mmd.c(intent, z);
        q(intent);
        intent.setExtrasClassLoader(GameWebViewLaunchParams.class.getClassLoader());
        GameWebViewLaunchParams gameWebViewLaunchParams = (GameWebViewLaunchParams) intent.getParcelableExtra("launchParams");
        if (gameWebViewLaunchParams != null) {
            final GameFloatLayerInfo gameFloatLayerInfo = gameWebViewLaunchParams.mrA;
            if (gameFloatLayerInfo != null) {
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ GameWebViewUI mod;

                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", gameFloatLayerInfo.url);
                        intent.putExtra("show_full_screen", gameFloatLayerInfo.mpB);
                        intent.putExtra("screen_orientation", gameFloatLayerInfo.orientation);
                        intent.putExtra("transparent_page", true);
                        intent.putExtra("needAnimation", false);
                        this.mod.d(intent, false);
                    }
                }, 200);
            }
        }
        if (aAc()) {
            d.bD(this.uSU.uTo);
        } else {
            d.bF(this.uSU.uTo);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        this.mmd.eA(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mmd.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean Xb() {
        return true;
    }

    protected final void SC() {
        super.SC();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        aq(10);
        aq(1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mmd != null) {
            Object obj;
            b bVar = (b) this.mmd.mmi.peek();
            if (bVar != null) {
                d azx = bVar.azx();
                if (azx.mmQ == null || !azx.mmQ.a(azx.mmc, i, i2, intent)) {
                    if (azx.mmt != null) {
                        f fVar = azx.mmt;
                        if (fVar.mnC != null ? fVar.mnC.onActivityResult(i, i2, intent) : false) {
                            int i3 = 1;
                        }
                    }
                    obj = null;
                } else {
                    obj = 1;
                }
            } else {
                obj = null;
            }
            if (obj == null) {
            }
        }
    }

    protected final boolean aAd() {
        b bVar = (b) this.mmd.mmi.peek();
        return bVar != null && bVar.azy();
    }
}
