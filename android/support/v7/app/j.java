package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

final class j {
    private static final int[] HA = new int[]{16843375};
    private static final String[] HB = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> HC = new android.support.v4.e.a();
    private static final Class<?>[] Hz = new Class[]{Context.class, AttributeSet.class};
    private final Object[] HD = new Object[2];

    private static class a implements OnClickListener {
        private final View HE;
        private final String HF;
        private Method HG;
        private Context HH;

        public a(View view, String str) {
            this.HE = view;
            this.HF = str;
        }

        public final void onClick(View view) {
            if (this.HG == null) {
                for (Context context = this.HE.getContext(); context != null; context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null) {
                    try {
                        if (!context.isRestricted()) {
                            Method method = context.getClass().getMethod(this.HF, new Class[]{View.class});
                            if (method != null) {
                                this.HG = method;
                                this.HH = context;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                    }
                }
                int id = this.HE.getId();
                throw new IllegalStateException("Could not find method " + this.HF + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.HE.getClass() + (id == -1 ? "" : " with id '" + this.HE.getContext().getResources().getResourceEntryName(id) + "'"));
            }
            try {
                this.HG.invoke(this.HH, new Object[]{view});
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (Throwable e22) {
                throw new IllegalStateException("Could not execute method for android:onClick", e22);
            }
        }
    }

    j() {
    }

    final View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.HD[0] = context;
            this.HD[1] = attributeSet;
            View b;
            if (-1 == str.indexOf(46)) {
                for (String b2 : HB) {
                    b = b(context, str, b2);
                    if (b != null) {
                        return b;
                    }
                }
                this.HD[0] = null;
                this.HD[1] = null;
                return null;
            }
            b = b(context, str, null);
            this.HD[0] = null;
            this.HD[1] = null;
            return b;
        } catch (Exception e) {
            return null;
        } finally {
            this.HD[0] = null;
            this.HD[1] = null;
        }
    }

    static void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || z.am(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, HA);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View b(Context context, String str, String str2) {
        Constructor constructor = (Constructor) HC.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(Hz);
                HC.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.HD);
    }

    static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        int resourceId2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.dE, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(k.NZ, 0);
        } else {
            resourceId = 0;
        }
        if (resourceId == 0) {
            resourceId2 = obtainStyledAttributes.getResourceId(k.Oa, 0);
        } else {
            resourceId2 = resourceId;
        }
        obtainStyledAttributes.recycle();
        if (resourceId2 == 0) {
            return context;
        }
        if ((context instanceof d) && ((d) context).OC == resourceId2) {
            return context;
        }
        return new d(context, resourceId2);
    }
}
