package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;

final class aa {
    private static Field yd;
    private static boolean ye;
    private static Field yf;
    private static boolean yg;

    static int T(View view) {
        if (!ye) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                yd = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            ye = true;
        }
        if (yd != null) {
            try {
                return ((Integer) yd.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int U(View view) {
        if (!yg) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                yf = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            yg = true;
        }
        if (yf != null) {
            try {
                return ((Integer) yf.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
