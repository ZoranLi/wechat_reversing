package com.tencent.e;

import com.tencent.e.b.b;
import com.tencent.e.b.c;
import com.tencent.e.b.d;
import java.util.HashMap;

public final class f {
    private static f xjc;
    private HashMap<String, g> xjd = new HashMap();
    HashMap<String, Object> xje = new HashMap();
    private Object xjf = new Object();
    Object xjg = new Object();
    private a xjh = new a(this);

    class a {
        private final Object mLock = new Object();
        private final HashMap<String, Object> xji = new HashMap();
        final /* synthetic */ f xjj;

        a(f fVar) {
            this.xjj = fVar;
        }

        final void fm(String str, String str2) {
            String str3 = str + str2;
            synchronized (this.mLock) {
                while (this.xji.get(str3) != null) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e) {
                        throw new c("install fail,lock interrupted!");
                    }
                }
                this.xji.put(str3, str2);
            }
        }

        final void fn(String str, String str2) {
            String str3 = str + str2;
            synchronized (this.mLock) {
                this.xji.remove(str3);
                this.mLock.notifyAll();
            }
        }
    }

    static f chd() {
        if (xjc == null) {
            synchronized (f.class) {
                if (xjc == null) {
                    xjc = new f();
                }
            }
        }
        return xjc;
    }

    public static Object VY(String str) {
        return chd().VZ(str);
    }

    public static b a(d dVar) {
        return chd().b(dVar);
    }

    private Object VZ(String str) {
        if (str == null) {
            throw new h("TpfServiceCenter|getService|service name should not be null");
        }
        Object obj;
        synchronized (this.xjg) {
            obj = this.xje.get(str);
        }
        if (obj == null) {
            g gVar;
            synchronized (this.xjf) {
                gVar = (g) this.xjd.get(str);
            }
            if (gVar != null) {
                if (gVar.xjl.xjx) {
                    return c(gVar);
                }
                Object obj2;
                if (4 == gVar.mState) {
                    try {
                        a(gVar);
                    } catch (c e) {
                        com.tencent.pb.common.c.d.k("service", e);
                        return null;
                    }
                }
                synchronized (this.xjg) {
                    obj2 = this.xje.get(str);
                }
                return obj2;
            }
        }
        return obj;
    }

    private b b(d dVar) {
        Object obj = 1;
        if (dVar == null || dVar.xjv == null) {
            return null;
        }
        String str = dVar.xjv;
        this.xjh.fm("install_", str);
        try {
            b bVar;
            Object obj2;
            synchronized (this.xjf) {
                bVar = (g) this.xjd.get(str);
                if (bVar == null) {
                    bVar = new g(this, dVar);
                    bVar.mState = 2;
                    com.tencent.pb.common.c.d.d("service", "service [", str, "] installed!");
                    this.xjd.put(str, bVar);
                    obj2 = 1;
                } else {
                    com.tencent.pb.common.c.d.d("service", "service [", str, "] had been installed!");
                    obj2 = null;
                }
            }
            if (obj2 != null) {
                if (dVar.xju == null) {
                    obj = null;
                }
                if (obj != null) {
                    bVar.mState = 4;
                    com.tencent.pb.common.c.d.d("service", "service [", str, "] resolved!");
                } else {
                    throw new c("resolve service [" + str + "] failed.");
                }
            }
            this.xjh.fn("install_", str);
            return bVar;
        } catch (Throwable th) {
            this.xjh.fn("install_", str);
        }
    }

    final boolean a(g gVar) {
        boolean z = false;
        d dVar = gVar.xjl;
        String str = dVar.xjv;
        this.xjh.fm("service_", str);
        try {
            if (gVar.mState == 32) {
                z = true;
            } else if (gVar.mState == 4) {
                gVar.mState = 8;
                com.tencent.pb.common.c.d.d("service", "service [", str, "] starting...");
                if (dVar.xjw != null) {
                    M(dVar.xjw);
                }
                if (b(gVar)) {
                    gVar.mState = 32;
                    com.tencent.pb.common.c.d.d("service", "service [", str, "] active...");
                    z = true;
                }
            }
            this.xjh.fn("service_", str);
            if (z) {
                return true;
            }
            throw new c("startService [" + str + "] failed");
        } catch (Throwable th) {
            this.xjh.fn("service_", str);
        }
    }

    private boolean M(String[] strArr) {
        if (strArr != null) {
            for (Object obj : strArr) {
                if (obj != null) {
                    g gVar;
                    synchronized (this.xjf) {
                        gVar = (g) this.xjd.get(obj);
                    }
                    if (gVar == null) {
                        return false;
                    }
                    a(gVar);
                    if (gVar.mState != 32) {
                        return false;
                    }
                    gVar.mReferenceCount++;
                    com.tencent.pb.common.c.d.d("reference_count", "addReferenceCount|", gVar.xjl.xjv, "|refcount=", Integer.valueOf(gVar.mReferenceCount));
                }
            }
        }
        return true;
    }

    private static boolean b(g gVar) {
        if (!gVar.xjl.xjx) {
            try {
                b bVar = (b) Class.forName(gVar.xjl.xju).newInstance();
                gVar.xjm = bVar;
                com.tencent.e.b.a aVar = new a(gVar);
                gVar.xjn = aVar;
                bVar.a(aVar);
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.d.k("service", e);
            }
        }
        return false;
    }

    private static Object c(g gVar) {
        try {
            c cVar = (c) Class.forName(gVar.xjl.xju).newInstance();
            gVar.xjn = new a(gVar);
            gVar.mState = 32;
            return cVar.cha();
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("service", e);
            return null;
        }
    }
}
