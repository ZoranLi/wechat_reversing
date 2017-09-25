package com.tencent.mm.app;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.LauncherUI;
import java.util.HashSet;
import java.util.Iterator;

public final class i {
    private static i fwh;
    public FrameLayout fwi;
    public WindowManager fwj;
    public LayoutParams fwk;
    public ViewGroup.LayoutParams fwl;
    public boolean fwm;
    public boolean fwn;
    public boolean fwo;
    public BitmapDrawable fwp = null;
    @Deprecated
    public Boolean fwq = Boolean.valueOf(false);
    public HashSet<a> fwr = new HashSet();
    private final int fws = 5;
    protected Object mLock = new Object();
    public View mView;

    public interface a {
        void oo();
    }

    public static i oj() {
        if (fwh == null) {
            fwh = new i();
        }
        return fwh;
    }

    public final synchronized void ok() {
        Iterator it = this.fwr.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.oo();
            }
        }
        this.fwr.clear();
        w.i("MicroMsg.INIT", "start time check notifyALLinit  hascreate: " + (System.currentTimeMillis() - LauncherUI.uRL));
        try {
            ab.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.INIT", e, "%s", e.getMessage());
        }
    }

    public final void ol() {
        try {
            synchronized (this.mLock) {
                if (this.fwj != null) {
                    if (this.fwi != null) {
                        this.fwj.removeView(this.fwi);
                    }
                    this.fwj = null;
                }
                if (this.fwi != null) {
                    this.fwi.removeAllViews();
                    this.fwi = null;
                }
                this.mView = null;
                this.fwm = false;
            }
        } catch (Exception e) {
        }
        this.fwm = false;
    }
}
