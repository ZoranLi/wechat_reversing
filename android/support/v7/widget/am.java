package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class am extends ContextWrapper {
    private static final ArrayList<WeakReference<am>> aeB = new ArrayList();
    private Resources Cu;
    private final Theme OD;

    public static Context p(Context context) {
        Object obj = ((context instanceof am) || (context.getResources() instanceof ao) || (context.getResources() instanceof ar)) ? null : (!d.cT() || VERSION.SDK_INT <= 20) ? 1 : null;
        if (obj == null) {
            return context;
        }
        Context context2;
        int size = aeB.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) aeB.get(i);
            context2 = weakReference != null ? (am) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new am(context);
        aeB.add(new WeakReference(context2));
        return context2;
    }

    private am(Context context) {
        super(context);
        if (ar.hd()) {
            this.OD = getResources().newTheme();
            this.OD.setTo(context.getTheme());
            return;
        }
        this.OD = null;
    }

    public final Theme getTheme() {
        return this.OD == null ? super.getTheme() : this.OD;
    }

    public final void setTheme(int i) {
        if (this.OD == null) {
            super.setTheme(i);
        } else {
            this.OD.applyStyle(i, true);
        }
    }

    public final Resources getResources() {
        if (this.Cu == null) {
            this.Cu = this.OD == null ? new ao(this, super.getResources()) : new ar(this, super.getResources());
        }
        return this.Cu;
    }
}
