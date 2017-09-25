package com.tencent.b.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class p {
    private static volatile p aQC = null;
    private boolean aQD = false;
    private Context context = null;

    public final boolean n(String str, String str2) {
        if (this.aQD) {
            try {
                return System.putString(this.context.getContentResolver(), str, str2);
            } catch (Exception e) {
            }
        }
        return false;
    }

    private p(Context context) {
        this.context = context.getApplicationContext();
        this.aQD = s.k(this.context, "android.permission.WRITE_SETTINGS");
        if (VERSION.SDK_INT >= 23) {
            try {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.aQD = ((Boolean) declaredMethod.invoke(null, new Object[]{this.context})).booleanValue();
            } catch (Exception e) {
            }
        }
    }

    public static p S(Context context) {
        if (aQC == null) {
            synchronized (p.class) {
                if (aQC == null) {
                    aQC = new p(context);
                }
            }
        }
        return aQC;
    }
}
