package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;

final class u {
    private static u wWl = null;
    Context ty;
    v wWm = null;

    private u(Context context) {
        this.ty = context.getApplicationContext();
        this.wWm = new v(this.ty);
    }

    public static synchronized u gy(Context context) {
        u uVar;
        synchronized (u.class) {
            if (wWl == null) {
                wWl = new u(context);
            }
            uVar = wWl;
        }
        return uVar;
    }

    final void k(Activity activity, int i) {
        v vVar = this.wWm;
        if (!(i != 3 || vVar.ceU() || vVar.wWp == null)) {
            vVar.wWp.pause();
        }
        if (i == 4) {
            vVar.mContext = null;
            if (!(vVar.ceU() || vVar.wWp == null)) {
                vVar.wWp.stopPlayback();
                vVar.wWp = null;
            }
        }
        if (i == 2 && !vVar.ceU()) {
            vVar.mContext = activity;
            if (!(vVar.ceU() || vVar.wWp == null)) {
                if (vVar.wWp.getParent() == null) {
                    Window window = activity.getWindow();
                    FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                    window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    window.addFlags(FileUtils.S_IWUSR);
                    frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    MediaController mediaController = new MediaController(activity);
                    mediaController.setMediaPlayer(vVar.wWp);
                    vVar.wWp.setMediaController(mediaController);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    frameLayout.addView(vVar.wWp, layoutParams);
                }
                if (VERSION.SDK_INT >= 8) {
                    vVar.wWp.start();
                }
            }
        }
        if (vVar.ceU()) {
            vVar.wWo.a(vVar.wWn, activity, i);
        }
    }
}
