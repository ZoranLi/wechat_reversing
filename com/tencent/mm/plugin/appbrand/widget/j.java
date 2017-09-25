package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class j {
    @SuppressLint({"StaticFieldLeak"})
    private static final j jrD = new j() {
        public final void a(a aVar) {
        }
    };
    private static final WeakHashMap<Activity, j> jrE = new WeakHashMap();
    static final boolean jrz;
    final Set<WeakReference<a>> igj = new HashSet();
    private final WeakReference<Activity> jrA;
    private boolean jrB = false;
    public int jrC = 0;

    public interface a {
        void ix(int i);
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        jrz = z;
    }

    public j(Activity activity) {
        this.jrA = new WeakReference(activity);
    }

    public void a(a aVar) {
        if (!this.jrB) {
            this.jrB = true;
            Activity activity = (Activity) this.jrA.get();
            if (!(activity == null || activity.getWindow() == null)) {
                try {
                    ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0).setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                        final /* synthetic */ j jrF;

                        {
                            this.jrF = r1;
                        }

                        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            j jVar = this.jrF;
                            j jVar2 = this.jrF;
                            int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
                            jVar2.jrC = systemWindowInsetTop;
                            for (WeakReference weakReference : jVar.igj) {
                                a aVar = (a) weakReference.get();
                                if (aVar != null) {
                                    aVar.ix(systemWindowInsetTop);
                                }
                            }
                            return windowInsets.consumeSystemWindowInsets();
                        }
                    });
                } catch (Exception e) {
                    w.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[]{e});
                }
            }
        }
        if (aVar != null) {
            this.igj.add(new WeakReference(aVar));
            if (this.jrC > 0) {
                aVar.ix(this.jrC);
            }
        }
    }

    public static j s(Activity activity) {
        if (!jrz || activity == null) {
            return jrD;
        }
        j jVar = (j) jrE.get(activity);
        if (jVar != null) {
            return jVar;
        }
        jVar = new j(activity);
        jrE.put(activity, jVar);
        return jVar;
    }
}
