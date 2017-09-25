package android.support.v4.view.a;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static final a Aj;
    public final Object Ak;

    interface a {
        Object a(c cVar);
    }

    static class d implements a {
        d() {
        }

        public Object a(c cVar) {
            return null;
        }
    }

    static class b extends d {
        b() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.d.AnonymousClass1(new a(this) {
                final /* synthetic */ b Am;

                public final boolean cc() {
                    return c.cc();
                }

                public final List<Object> cd() {
                    List list = null;
                    c.cd();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).zL);
                    }
                    return arrayList;
                }

                public final Object cf() {
                    c.cb();
                    return null;
                }
            });
        }
    }

    static class c extends d {
        c() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.e.AnonymousClass1(new a(this) {
                final /* synthetic */ c An;

                public final boolean cc() {
                    return c.cc();
                }

                public final List<Object> cd() {
                    List list = null;
                    c.cd();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).zL);
                    }
                    return arrayList;
                }

                public final Object cf() {
                    c.cb();
                    return null;
                }

                public final Object cg() {
                    c.ce();
                    return null;
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            Aj = new c();
        } else if (VERSION.SDK_INT >= 16) {
            Aj = new b();
        } else {
            Aj = new d();
        }
    }

    public c() {
        this.Ak = Aj.a(this);
    }

    public c(Object obj) {
        this.Ak = obj;
    }

    public static b cb() {
        return null;
    }

    public static boolean cc() {
        return false;
    }

    public static List<b> cd() {
        return null;
    }

    public static b ce() {
        return null;
    }
}
