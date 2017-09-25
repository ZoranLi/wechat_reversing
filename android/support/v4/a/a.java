package android.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

public final class a {
    private static final c nu;

    static {
        if (VERSION.SDK_INT >= 12) {
            nu = new f();
        } else {
            nu = new e();
        }
    }

    public static g aB() {
        return nu.aB();
    }

    public static void v(View view) {
        nu.v(view);
    }
}
