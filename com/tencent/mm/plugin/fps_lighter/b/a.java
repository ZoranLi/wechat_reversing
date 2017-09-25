package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;

class a implements ActivityLifecycleCallbacks {
    public boolean kNU;
    private Handler lPA = new Handler(Looper.getMainLooper());
    public boolean lPx;
    private Activity lPy;
    private Runnable lPz;
    public ArrayList<a> mListeners = new ArrayList();

    protected interface a {
        void A(Activity activity);

        void x(Activity activity);

        void y(Activity activity);

        void z(Activity activity);
    }

    a() {
    }

    public void c(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void d(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
        this.mListeners.clear();
    }

    public void onActivityResumed(final Activity activity) {
        this.lPx = false;
        w.i("MicroMsg.BaseFrameBeatCore", "[onActivityResumed] foreground:%s", new Object[]{Boolean.valueOf(this.kNU)});
        final boolean z = !this.kNU;
        this.kNU = true;
        if (activity != this.lPy) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                try {
                    ((a) it.next()).A(activity);
                } catch (Exception e) {
                    w.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
                }
            }
            this.lPy = activity;
        }
        Handler handler = this.lPA;
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ a lPC;

            public final void run() {
                if (z) {
                    w.i("MicroMsg.BaseFrameBeatCore", "went foreground");
                    Iterator it = this.lPC.mListeners.iterator();
                    while (it.hasNext()) {
                        try {
                            ((a) it.next()).x(activity);
                        } catch (Exception e) {
                            w.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
                        }
                    }
                    return;
                }
                w.i("MicroMsg.BaseFrameBeatCore", "still foreground");
            }
        };
        this.lPz = anonymousClass1;
        handler.postDelayed(anonymousClass1, 600);
    }

    public void onActivityPaused(final Activity activity) {
        w.i("MicroMsg.BaseFrameBeatCore", "[onActivityPaused] foreground:%s", new Object[]{Boolean.valueOf(this.kNU)});
        this.lPx = true;
        if (this.lPz != null) {
            this.lPA.removeCallbacks(this.lPz);
        }
        Handler handler = this.lPA;
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ a lPC;

            public final void run() {
                if (this.lPC.kNU && this.lPC.lPx) {
                    this.lPC.kNU = false;
                    w.i("MicroMsg.BaseFrameBeatCore", "went background");
                    Iterator it = this.lPC.mListeners.iterator();
                    while (it.hasNext()) {
                        try {
                            ((a) it.next()).y(activity);
                        } catch (Exception e) {
                            w.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
                        }
                    }
                    return;
                }
                w.i("MicroMsg.BaseFrameBeatCore", "still foreground");
            }
        };
        this.lPz = anonymousClass2;
        handler.postDelayed(anonymousClass2, 600);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        w.i("MicroMsg.BaseFrameBeatCore", "Activity:%s", new Object[]{activity.getClass().getSimpleName()});
        this.lPy = activity;
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                ((a) it.next()).z(activity);
            } catch (Exception e) {
                w.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
            }
        }
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
