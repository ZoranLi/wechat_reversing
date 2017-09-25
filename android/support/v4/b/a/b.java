package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

final class b {
    static Method tM;
    static boolean tN;
    private static Method tO;
    private static boolean tP;

    public static int i(Drawable drawable) {
        if (!tP) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                tO = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            tP = true;
        }
        if (tO != null) {
            try {
                return ((Integer) tO.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                tO = null;
            }
        }
        return -1;
    }
}
