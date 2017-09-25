package com.google.android.gms.c;

import java.lang.reflect.Array;

public final class az<M extends ay<M>, T> {
    protected final boolean aCA;
    protected final Class<T> aCz;
    public final int tag;
    protected final int type;

    private int ae(Object obj) {
        int cu = bh.cu(this.tag);
        switch (this.type) {
            case 10:
                return (ax.cn(cu) * 2) + ((be) obj).lH();
            case 11:
                return ax.b(cu, (be) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    private void b(Object obj, ax axVar) {
        try {
            axVar.co(this.tag);
            switch (this.type) {
                case 10:
                    be beVar = (be) obj;
                    int cu = bh.cu(this.tag);
                    beVar.a(axVar);
                    axVar.am(cu, 4);
                    return;
                case 11:
                    axVar.b((be) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    final void a(Object obj, ax axVar) {
        if (this.aCA) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    b(obj2, axVar);
                }
            }
            return;
        }
        b(obj, axVar);
    }

    final int ad(Object obj) {
        int i = 0;
        if (!this.aCA) {
            return ae(obj);
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += ae(Array.get(obj, i2));
            }
        }
        return i;
    }
}
