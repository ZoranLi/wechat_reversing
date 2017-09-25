package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.mm.bn.b;

public final class s {
    private static SparseArray<a> nyG = new SparseArray();
    private static b<r> nyH;

    private static class a<T extends com.tencent.mm.bd.a> extends com.tencent.mm.bn.a<q<T>> implements q<T> {
        public final void b(final T t) {
            a(new com.tencent.mm.bn.a.a<q<T>>(this) {
                final /* synthetic */ a nyJ;

                public final /* synthetic */ void ao(Object obj) {
                    ((q) obj).b(t);
                }
            });
        }

        public final void a(final T t) {
            a(new com.tencent.mm.bn.a.a<q<T>>(this) {
                final /* synthetic */ a nyJ;

                public final /* synthetic */ void ao(Object obj) {
                    ((q) obj).a(t);
                }
            });
        }
    }

    public static synchronized <T extends com.tencent.mm.bd.a> void a(int i, q<T> qVar) {
        synchronized (s.class) {
            a aVar = (a) nyG.get(i);
            if (aVar == null) {
                aVar = new a();
                nyG.put(i, aVar);
            }
            aVar.bI(qVar);
        }
    }

    public static synchronized <T extends com.tencent.mm.bd.a> void d(T t) {
        synchronized (s.class) {
            a aVar = (a) nyG.get(5);
            if (aVar != null) {
                aVar.b(t);
            }
        }
    }

    public static synchronized <T extends com.tencent.mm.bd.a> void a(int i, T t) {
        synchronized (s.class) {
            a aVar = (a) nyG.get(i);
            if (aVar != null) {
                aVar.a(t);
            }
        }
    }

    public static final b<r> aJY() {
        return nyH;
    }

    public static final void b(b<r> bVar) {
        nyH = bVar;
    }
}
