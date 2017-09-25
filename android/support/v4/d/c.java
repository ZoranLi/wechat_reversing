package android.support.v4.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

final class c {
    private static Method vw;
    private static Method vx;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                vx = cls.getMethod("getScript", new Class[]{String.class});
                vw = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e) {
            vx = null;
            vw = null;
        }
    }

    public static String a(Locale locale) {
        String b = b(locale);
        if (b != null) {
            return m(b);
        }
        return null;
    }

    private static String m(String str) {
        try {
            if (vx != null) {
                return (String) vx.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (vw != null) {
                return (String) vw.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return locale2;
    }
}
