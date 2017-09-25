package com.tencent.mm.plugin.game.gamewebview.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameMMToClientEvent;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.j;

public abstract class b extends SwipeBackLayout implements com.tencent.mm.ui.widget.SwipeBackLayout.a, com.tencent.mm.ui.widget.j.a {
    private boolean jck;
    boolean jcl = false;
    protected GameWebViewBaseActivity mmc;
    c mmd;
    boolean mme;
    Bundle uT = new Bundle();

    public interface a {
        void azD();
    }

    public abstract String VD();

    public abstract d azw();

    public abstract d azx();

    public b(GameWebViewBaseActivity gameWebViewBaseActivity, c cVar) {
        super(gameWebViewBaseActivity);
        this.mmc = gameWebViewBaseActivity;
        this.mmd = cVar;
        setLayoutParams(new LayoutParams(-1, -1));
        init();
        this.wxG = false;
        lU(true);
        addView(azw());
        this.Ih = azw();
        this.wxL = this;
    }

    public final void Vz() {
        w.d("MicroMsg.GameWebPage", "onPageForeground: %s", new Object[]{bg.mz(azx().mlI)});
        j.b(this);
        this.wuc = false;
        this.mEnable = azy();
        this.jck = false;
        setVisibility(0);
        if (this.uT.getBoolean("transparent_page", false)) {
            azz();
        }
        this.mmc.ny(this.uT.getInt("screen_orientation", -1));
        GameWebViewBaseActivity gameWebViewBaseActivity = this.mmc;
        if (isFullScreen()) {
            gameWebViewBaseActivity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            gameWebViewBaseActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
        } else {
            gameWebViewBaseActivity.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            gameWebViewBaseActivity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
        FrameLayout azx = azx();
        boolean isFullScreen = isFullScreen();
        w.d("MicroMsg.GameWebPageView", "setFullScreen, rawUrl = %s, fullscreen = %b, mHVGameAppId = %s", new Object[]{azx.mlI, Boolean.valueOf(isFullScreen), azx.mnh});
        azx.mnd = isFullScreen;
        if (isFullScreen) {
            azx.nu(8);
            if (bg.mA(azx.mnh)) {
                azx.mmC.setVisibility(0);
            } else {
                if (azx.mmE == null) {
                    azx.mmE = new GameMenuImageButton(azx.mmc);
                    azx.mmE.a(azx, new com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a(azx) {
                        final /* synthetic */ d mnm;

                        {
                            this.mnm = r1;
                        }

                        public final void aAa() {
                            if (this.mnm.mmt != null) {
                                this.mnm.mmt.aAb();
                            }
                        }
                    });
                }
                azx.mmC.setVisibility(8);
            }
        } else {
            azx.nu(0);
            azx.mmC.setVisibility(8);
        }
        d azx2 = azx();
        azx2.azP();
        azx2.xD("onResume");
        azx2.xE("onResume");
        azx2.mmr.mlO = System.currentTimeMillis();
    }

    public final void ez(boolean z) {
        w.d("MicroMsg.GameWebPage", "onPageBackground: %s", new Object[]{bg.mz(azx().mlI)});
        if (z) {
            j.a(this);
        }
        this.jck = true;
        d azx = azx();
        com.tencent.mm.plugin.game.gamewebview.c.a aVar = azx.mmr;
        aVar.mlP += System.currentTimeMillis() - aVar.mlO;
        azx.xD("onPause");
        azx.xE("onPause");
        azx.jeh.onHideCustomView();
    }

    protected final void VB() {
        w.d("MicroMsg.GameWebPage", "onPageDestroy: %s", new Object[]{VD()});
        d azx = azx();
        w.d("MicroMsg.GameWebPageView", "onPageDestroy");
        azx.kIH = true;
        if (azx.mnf != null) {
            azx.mnf.cancel();
        }
        if (azx.mmK != null) {
            azx.mmK.onDestroy();
        }
        com.tencent.mm.plugin.game.gamewebview.c.a aVar = azx.mmr;
        w.d("MicroMsg.GameWebViewReportManager", "totalTime = %d, visitTime = %d, loadSuccess = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - aVar.mlN), Long.valueOf(aVar.mlP), Integer.valueOf(aVar.mlL)});
        aVar.a(aVar.mkn.azN(), 4, r4, aVar.mlL, 0);
        aVar.a(aVar.mkn.azN(), 1, aVar.mlP, aVar.mlL, 0);
        azx.xD("onDestroy");
        w.d("MicroMsg.GameWebPageView", "destroy");
        GameMMToClientEvent.nq(azx.hashCode());
        com.tencent.mm.plugin.game.gamewebview.model.a.b(azx);
        azx.mmw.release();
        if (azx.mmH != null) {
            azx.mmH.detach();
            azx.mmH = null;
        }
        azx.mmx.iHc.getLooper().quit();
        azx.mmy.setWebChromeClient(null);
        azx.mmy.setWebChromeClient(null);
        azx.mmy.setOnTouchListener(null);
        azx.mmy.setOnLongClickListener(null);
        try {
            azx.mmy.destroy();
        } catch (Exception e) {
            w.e("MicroMsg.GameWebPageView", "destroy, webview destroy, excepiton: " + e.getMessage());
        }
        azx.mmy = null;
        System.gc();
    }

    public final void w(final Runnable runnable) {
        Animator ofFloat = ObjectAnimator.ofFloat(this, "translationX", new float[]{(float) c.getScreenWidth(this.mmc), 0.0f});
        ofFloat.setDuration(250);
        ofFloat.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ b mmf;

            public final void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        ofFloat.start();
    }

    public final boolean azy() {
        if (!(this.uT.getBoolean("disable_swipe_back", false) || this.uT.getBoolean("transparent_page", false) || this.mme)) {
            if (this.mmd.mmi.size() > 1) {
                return true;
            }
        }
        return false;
    }

    public final void hide() {
        if (this.jck) {
            w.d("MicroMsg.GameWebPage", "hide, %d", new Object[]{Integer.valueOf(hashCode())});
            setVisibility(4);
        }
    }

    public final void O(float f) {
        w.d("MicroMsg.GameWebPage", "onSwipe， " + hashCode());
        if (this.jck) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.j.n(azw(), 0.0f);
            return;
        }
        com.tencent.mm.ui.tools.j.n(azw(), (((float) (azw().getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public final void d(boolean z, int i) {
        long j = 120;
        w.d("MicroMsg.GameWebPage", "onSettle(%d), %b, %d ", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), Integer.valueOf(i)});
        if (z) {
            View azw = azw();
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(azw, j, 0.0f, null);
            return;
        }
        azw = azw();
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(azw, j, (float) ((azw().getWidth() * -1) / 4), null);
    }

    public final boolean VJ() {
        return false;
    }

    public final void VK() {
        this.mmd.eA(true);
    }

    public final void VL() {
        this.jcl = true;
    }

    public final void onCancel() {
        this.jcl = false;
    }

    public void azz() {
    }

    public void loadUrl(String str) {
    }

    public final void azA() {
        this.mme = false;
        this.mEnable = azy();
    }

    public final boolean azB() {
        return this.uT.getBoolean("is_from_keep_top", false);
    }

    public final void azC() {
        this.mmd.eA(true);
    }

    public final boolean isFullScreen() {
        return this.uT.getBoolean("show_full_screen", false);
    }

    public final void nt(int i) {
        this.uT.putInt("screen_orientation", i);
        this.mmc.ny(i);
    }
}
