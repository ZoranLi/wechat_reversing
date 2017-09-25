package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.d;
import java.lang.ref.WeakReference;

public final class ar extends Resources {
    private final WeakReference<Context> aeF;

    public static boolean hd() {
        return d.cT() && VERSION.SDK_INT <= 20;
    }

    public ar(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aeF = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Context context = (Context) this.aeF.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        h ey = h.ey();
        Drawable d = ey.d(context, i);
        if (d == null) {
            d = super.getDrawable(i);
        }
        return d != null ? ey.a(context, i, false, d) : null;
    }
}
