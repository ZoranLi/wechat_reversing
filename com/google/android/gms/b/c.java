package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;

public abstract class c<T> {
    private final String asS;
    private T asT;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public c(String str) {
        this.asS = str;
    }

    public final T C(Context context) {
        if (this.asT == null) {
            w.Z(context);
            Context z = e.z(context);
            if (z == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.asT = e((IBinder) z.getClassLoader().loadClass(this.asS).newInstance());
            } catch (Throwable e) {
                throw new a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new a("Could not access creator.", e22);
            }
        }
        return this.asT;
    }

    public abstract T e(IBinder iBinder);
}
