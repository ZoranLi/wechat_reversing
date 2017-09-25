package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class at {
    private static Method afM;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                afM = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    afM.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
            }
        }
    }

    public static boolean bw(View view) {
        return z.J(view) == 1;
    }

    public static int combineMeasuredStates(int i, int i2) {
        return i | i2;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (afM != null) {
            try {
                afM.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e) {
            }
        }
    }

    public static void bx(View view) {
        if (VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException e) {
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
            }
        }
    }
}
