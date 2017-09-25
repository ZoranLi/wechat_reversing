package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b> {
    final int priority;
    public int usg;
    private b<c> ush;

    public abstract boolean a(T t);

    public c() {
        this(0);
    }

    public c(int i) {
        this.usg = 0;
        this.priority = i;
    }

    final int bIx() {
        if (this.usg == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            this.usg = ((Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).getName().hashCode();
            w.v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), r1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.usg;
    }

    public final synchronized b<c> bIy() {
        if (this.ush == null) {
            this.ush = a.urY.a(this);
        }
        return this.ush;
    }

    public final synchronized void dead() {
        if (this.ush != null) {
            this.ush.dead();
            this.ush = null;
        }
    }
}
