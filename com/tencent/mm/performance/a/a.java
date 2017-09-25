package com.tencent.mm.performance.a;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.performance.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

public final class a extends com.tencent.mm.performance.d.a {
    public static String TYPE = "ActivityMonitorController";
    private boolean igi = false;
    public Set<a> igj = null;
    private Object igk = null;
    public Instrumentation igl = null;

    public static abstract class a {
        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void h(Activity activity) {
        }

        public void i(Activity activity) {
        }

        public void j(Activity activity) {
        }

        public void k(Activity activity) {
        }

        public void l(Activity activity) {
        }

        public void m(Activity activity) {
        }

        public void c(Activity activity, Intent intent) {
        }

        public void d(Activity activity, Intent intent) {
        }

        public void n(Activity activity) {
        }

        public void o(Activity activity) {
        }

        public void p(Activity activity) {
        }

        public void q(Activity activity) {
        }
    }

    private class b extends Instrumentation {
        final /* synthetic */ a igm;

        private b(a aVar) {
            this.igm = aVar;
        }

        public void callActivityOnCreate(Activity activity, Bundle bundle) {
            this.igm.a(activity, bundle, true);
            this.igm.igl.callActivityOnCreate(activity, bundle);
            this.igm.a(activity, bundle, false);
        }

        public void callActivityOnResume(Activity activity) {
            this.igm.a(activity, true);
            this.igm.igl.callActivityOnResume(activity);
            this.igm.a(activity, false);
        }

        public void callActivityOnPause(Activity activity) {
            this.igm.b(activity, true);
            this.igm.igl.callActivityOnPause(activity);
            this.igm.b(activity, false);
        }

        public void callActivityOnStart(Activity activity) {
            this.igm.c(activity, true);
            this.igm.igl.callActivityOnStart(activity);
            this.igm.c(activity, false);
        }

        public void callActivityOnRestart(Activity activity) {
            this.igm.MX();
            this.igm.igl.callActivityOnRestart(activity);
            this.igm.MX();
        }

        public void callActivityOnNewIntent(Activity activity, Intent intent) {
            this.igm.a(activity, intent, true);
            this.igm.igl.callActivityOnNewIntent(activity, intent);
            this.igm.a(activity, intent, false);
        }

        public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
            this.igm.MY();
            this.igm.igl.callActivityOnSaveInstanceState(activity, bundle);
            this.igm.MY();
        }

        public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
            this.igm.MZ();
            this.igm.igl.callActivityOnRestoreInstanceState(activity, bundle);
            this.igm.MZ();
        }

        public void callActivityOnStop(Activity activity) {
            this.igm.d(activity, true);
            this.igm.igl.callActivityOnStop(activity);
            this.igm.d(activity, false);
        }

        public void callActivityOnDestroy(Activity activity) {
            this.igm.e(activity, true);
            this.igm.igl.callActivityOnDestroy(activity);
            this.igm.e(activity, false);
        }
    }

    public final synchronized void a(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback is null");
        } else if (this.igi) {
            this.igj.add(aVar);
        }
    }

    public final synchronized void a(Activity activity, Bundle bundle, boolean z) {
        for (a aVar : this.igj) {
            if (z) {
                aVar.a(activity, bundle);
            } else {
                aVar.b(activity, bundle);
            }
        }
    }

    public final synchronized void a(Activity activity, boolean z) {
        for (a aVar : this.igj) {
            if (z) {
                aVar.h(activity);
            } else {
                aVar.i(activity);
            }
        }
    }

    public final synchronized void b(Activity activity, boolean z) {
        for (a aVar : this.igj) {
            if (z) {
                aVar.j(activity);
            } else {
                aVar.k(activity);
            }
        }
    }

    public final synchronized void c(Activity activity, boolean z) {
        for (a aVar : this.igj) {
            if (z) {
                aVar.l(activity);
            } else {
                aVar.m(activity);
            }
        }
    }

    public final synchronized void MX() {
        Iterator it = this.igj.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final synchronized void a(Activity activity, Intent intent, boolean z) {
        for (a aVar : this.igj) {
            if (z) {
                aVar.c(activity, intent);
            } else {
                aVar.d(activity, intent);
            }
        }
    }

    public final synchronized void MY() {
        Iterator it = this.igj.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final synchronized void MZ() {
        Iterator it = this.igj.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final synchronized void d(Activity activity, boolean z) {
        for (a aVar : this.igj) {
            if (z) {
                aVar.n(activity);
            } else {
                aVar.o(activity);
            }
        }
    }

    public final synchronized void e(Activity activity, boolean z) {
        for (a aVar : this.igj) {
            if (z) {
                aVar.p(activity);
            } else {
                aVar.q(activity);
            }
        }
    }

    public final boolean Na() {
        boolean z;
        try {
            this.igk = c.ao("android.app.ActivityThread", "currentActivityThread");
            if (this.igk == null) {
                throw new IllegalStateException("Failed to get CurrentActivityThread.");
            }
            this.igl = (Instrumentation) c.a(this.igk.getClass(), "mInstrumentation", this.igk);
            if (this.igl == null) {
                throw new IllegalStateException("Failed to get Instrumentation instance.");
            } else if (this.igl.getClass().equals(b.class)) {
                return true;
            } else {
                if (this.igl.getClass().equals(Instrumentation.class) || this.igl.getClass().getName().startsWith(ab.getPackageName())) {
                    Class cls = this.igk.getClass();
                    String str = "mInstrumentation";
                    b bVar = new b();
                    Object obj = this.igk;
                    try {
                        Field declaredField = cls.getDeclaredField(str);
                        declaredField.setAccessible(true);
                        declaredField.set(obj, bVar);
                        z = true;
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ReflectHelper", e, "", new Object[0]);
                        z = true;
                    }
                    this.igi = z;
                    return z;
                }
                throw new IllegalStateException("Not original Instrumentation instance, give up monitoring.");
            }
        } catch (Exception e2) {
            z = false;
        }
    }

    public final String Nb() {
        return TYPE;
    }

    public final void Nc() {
    }
}
