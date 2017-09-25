package com.tencent.e;

import android.content.Context;
import com.tencent.e.b.b;
import com.tencent.e.b.d;

public final class i {
    private static i xjo;
    private boolean ny;
    private Context ty;

    private static i che() {
        if (xjo == null) {
            synchronized (i.class) {
                if (xjo == null) {
                    xjo = new i();
                }
            }
        }
        return xjo;
    }

    public static void hJ(Context context) {
        i che = che();
        if (!che.ny) {
            che.ty = context;
            try {
                b a = f.a(new d("EventCenter", com.tencent.e.a.b.class.getName()));
                if (a != null) {
                    a.start();
                }
            } catch (Throwable th) {
                com.tencent.pb.common.c.d.k("service", th);
            }
        }
    }
}
