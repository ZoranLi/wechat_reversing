package com.tencent.mm.plugin.fps_lighter.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.mm.e.a.jt;
import com.tencent.mm.plugin.fps_lighter.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

@TargetApi(16)
public final class f extends a implements FrameCallback, OnDrawListener, a {
    private Choreographer jeY = null;
    public boolean lPW = false;
    private long[] lPX = new long[9];
    private long lPY = 0;
    private boolean lPZ;
    private c lPk;
    private c<jt> lQa;
    private long lQb = 0;
    long lQc = 0;
    long lQd = 0;
    private long lQe = 0;
    private ArrayList<com.tencent.mm.plugin.fps_lighter.a.c> mListeners = new ArrayList();

    public final /* bridge */ /* synthetic */ void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);
    }

    public final /* bridge */ /* synthetic */ void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        super.onActivitySaveInstanceState(activity, bundle);
    }

    public final /* bridge */ /* synthetic */ void onActivityStarted(Activity activity) {
        super.onActivityStarted(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityStopped(Activity activity) {
        super.onActivityStopped(activity);
    }

    f(c cVar) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalThreadStateException("not in main thread");
        }
        this.lPk = cVar;
        this.jeY = Choreographer.getInstance();
    }

    public final void c(Application application) {
        super.c(application);
        w.i("MicroMsg.FrameBeatCore", "[setUp]");
        if (!this.mListeners.contains(this)) {
            this.mListeners.add(this);
        }
        if (this.lQa == null) {
            this.lQa = new c<jt>(this) {
                final /* synthetic */ f lQf;

                {
                    this.lQf = r2;
                    this.usg = jt.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    if (((jt) bVar).fQh.visible) {
                        w.i("MicroMsg.FrameBeatCore", "[NotifyFragmentChangeEvent] fragment:%s onCreate!", new Object[]{((jt) bVar).fQh.name});
                        this.lQf.lPW = true;
                    }
                    return true;
                }
            };
        }
        this.lQa.bIy();
    }

    public final void d(Application application) {
        super.d(application);
        w.i("MicroMsg.FrameBeatCore", "[setOff]");
        this.mListeners.remove(this);
        if (this.lQa != null) {
            this.lQa.dead();
            this.lQa = null;
        }
        this.mListeners.clear();
        this.lPk.lPM = false;
        this.jeY.removeFrameCallback(this);
    }

    public final void x(Activity activity) {
        boolean z;
        Iterator it;
        w.i("MicroMsg.FrameBeatCore", "[onBecameForeground]:%s", new Object[]{activity.getClass().getSimpleName()});
        c cVar = this.lPk;
        if (cVar.lPR != 0) {
            if (cVar.lPR == 100) {
                cVar.lPM = true;
            } else if (1 == new Random().nextInt(100 / cVar.lPR)) {
                cVar.lPM = true;
            }
            if (cVar.lPM) {
                w.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", new Object[]{Integer.valueOf(cVar.lPR)});
            }
            z = cVar.lPM;
            if (this.lPk.lPM) {
                it = this.mListeners.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).H(Integer.MAX_VALUE, true);
                }
                this.jeY.removeFrameCallback(this);
                this.jeY.postFrameCallback(this);
            }
        }
        cVar.lPM = false;
        if (cVar.lPM) {
            w.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", new Object[]{Integer.valueOf(cVar.lPR)});
        }
        z = cVar.lPM;
        if (this.lPk.lPM) {
            it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).H(Integer.MAX_VALUE, true);
            }
            this.jeY.removeFrameCallback(this);
            this.jeY.postFrameCallback(this);
        }
    }

    public final void y(Activity activity) {
        w.i("MicroMsg.FrameBeatCore", "[onBecameBackground]:%s", new Object[]{activity.getClass().getSimpleName()});
        this.lPk.lPM = false;
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).H(Integer.MAX_VALUE, false);
        }
    }

    public final void z(Activity activity) {
        w.i("MicroMsg.FrameBeatCore", "[onBegin]:%s", new Object[]{activity.getClass().getSimpleName()});
        this.lPk.B(activity);
        this.lPW = true;
    }

    public final void A(final Activity activity) {
        w.i("MicroMsg.FrameBeatCore", "[onChangeActivity] now Activity:%s", new Object[]{activity.getClass().getSimpleName()});
        this.lPk.B(activity);
        activity.getWindow().getDecorView().post(new Runnable(this) {
            final /* synthetic */ f lQf;

            public final void run() {
                activity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this.lQf);
                activity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(this.lQf);
            }
        });
    }

    public final void doFrame(long j) {
        Object obj;
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        Object obj2 = 1;
        if (!this.lPk.lPM) {
            w.e("MicroMsg.FrameBeatCore", "[doFrame] unEnable!");
            obj2 = null;
        }
        if (this.mListeners.size() <= 0) {
            w.e("MicroMsg.FrameBeatCore", "has not any listener!");
            obj = null;
        } else {
            obj = obj2;
        }
        if (obj == null) {
            this.lPY = 0;
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).H(Integer.MAX_VALUE, false);
            }
            Choreographer.getInstance().removeFrameCallback(this);
        }
        if (obj != null) {
            int intValue;
            long threadCpuTimeNanos2;
            long nanoTime;
            long j2;
            long j3;
            Iterator it2;
            c cVar = this.lPk;
            String str = this.lPk.lPQ;
            if (bg.mA(str)) {
                w.i("MicroMsg.FPSConfig", "null == activityName");
            } else {
                Integer num;
                if (c.lPO.containsKey(str)) {
                    num = (Integer) c.lPO.get(str);
                    intValue = num != null ? num.intValue() : -1;
                } else if (c.lPO.containsKey(cVar.lPP) && cVar.lPQ.equalsIgnoreCase("LauncherUI")) {
                    num = (Integer) c.lPO.get(cVar.lPP);
                    intValue = num != null ? num.intValue() : -1;
                }
                threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
                nanoTime = System.nanoTime();
                if (this.lQd != 0 || this.lQc == 0) {
                    j2 = 0;
                } else {
                    j2 = (long) Math.round(((((float) (threadCpuTimeNanos2 - this.lQd)) * 1.0f) / ((float) (nanoTime - this.lQc))) * 100.0f);
                }
                this.lQd = threadCpuTimeNanos2;
                this.lQc = nanoTime;
                j3 = j - this.lPY;
                if (0 == this.lPY && intValue != -1 && this.lPZ) {
                    int b = a.b(j3, this.lPk.lPH);
                    Iterator it3 = this.mListeners.iterator();
                    while (it3.hasNext()) {
                        ((com.tencent.mm.plugin.fps_lighter.a.c) it3.next()).a(intValue, this.lPY / 1000000, j / 1000000, b, (int) j2, this.lPW, this.lQb / 1000000, this.lPZ);
                    }
                } else {
                    it2 = this.mListeners.iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.mm.plugin.fps_lighter.a.c) it2.next()).H(-1, false);
                    }
                }
                this.lPW = false;
                this.lPZ = false;
                this.lPY = j;
                this.jeY.postFrameCallback(this);
                this.lQb = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
            }
            intValue = -1;
            threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
            nanoTime = System.nanoTime();
            if (this.lQd != 0) {
            }
            j2 = 0;
            this.lQd = threadCpuTimeNanos2;
            this.lQc = nanoTime;
            j3 = j - this.lPY;
            if (0 == this.lPY) {
            }
            it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it2.next()).H(-1, false);
            }
            this.lPW = false;
            this.lPZ = false;
            this.lPY = j;
            this.jeY.postFrameCallback(this);
            this.lQb = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
        }
    }

    public final void a(com.tencent.mm.plugin.fps_lighter.a.c cVar) {
        if (!this.mListeners.contains(cVar)) {
            this.mListeners.add(cVar);
        }
    }

    public final void onDraw() {
        this.lPZ = true;
    }
}
