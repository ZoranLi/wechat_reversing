package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b {

    public interface a {
        void kG(boolean z);
    }

    private static class b implements InvocationHandler {
        public WeakReference<a> vfG;

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            if (this.vfG == null) {
                w.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
            } else {
                a aVar = (a) this.vfG.get();
                if (aVar == null) {
                    w.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    aVar.kG(z);
                }
            }
            return null;
        }
    }

    public static int SU(String str) {
        Class SV = SV(str);
        if (SV != null) {
            return w(SV);
        }
        return 0;
    }

    public static int w(Class<?> cls) {
        do {
            a aVar = (a) cls.getAnnotation(a.class);
            if (aVar != null) {
                return aVar.value();
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return 0;
    }

    private static Class<?> SV(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ActivityUtil", e, "", new Object[0]);
            w.e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            return null;
        }
    }

    public static boolean x(Class<?> cls) {
        return (w(cls) & 1) == 0;
    }

    public static void ad(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
        }
    }

    public static void eL(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.s.a.a.aRm, com.tencent.mm.s.a.a.aQL);
        }
    }

    public static void eM(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.s.a.a.aRm, com.tencent.mm.s.a.a.aRn);
        }
    }

    public static void A(Context context, Intent intent) {
        if (intent != null && context != null && (context instanceof Activity) && intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.s.a.a.aRm, com.tencent.mm.s.a.a.aQL);
        }
    }

    public static void eN(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.s.a.a.aQL, com.tencent.mm.s.a.a.aRn);
        }
    }

    public static void eO(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.s.a.a.aQL, com.tencent.mm.s.a.a.aQL);
        }
    }
}
