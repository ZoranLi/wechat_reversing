package com.tencent.mm.kernel;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class c {
    private final HashMap<Class<? extends com.tencent.mm.kernel.b.a>, d> gXM = new HashMap();
    public final ArrayList<d> gXN = new ArrayList();
    private final HashMap<Class<? extends d>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> gXO = new HashMap();
    private final HashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends d>> gXP = new HashMap();
    public f<Class<? extends d>> gXQ = new f();
    private HashMap<Class<? extends com.tencent.mm.kernel.c.a>, b> gXR = new HashMap();
    protected a gXS;
    public Class<? extends com.tencent.mm.kernel.b.a> gXT = null;
    private HashMap<com.tencent.mm.kernel.b.c, ArrayList<Object>> gXU = new HashMap();

    public interface a {
        void a(com.tencent.mm.kernel.c.a aVar);

        void b(d dVar);

        void b(com.tencent.mm.kernel.c.a aVar);
    }

    public final synchronized void f(Class<? extends d> cls) {
        Assert.assertNotNull(cls);
        try {
            a((d) cls.newInstance());
        } catch (Throwable e) {
            j.printErrStackTrace("MMSkeleton.CorePlugins", e, "", new Object[0]);
            j.printErrStackTrace("MMSkeleton.CorePlugins", e, "Install plugin %s failed.", cls);
        } catch (Throwable e2) {
            j.printErrStackTrace("MMSkeleton.CorePlugins", e2, "", new Object[0]);
            j.printErrStackTrace("MMSkeleton.CorePlugins", e2, "Install plugin %s failed.", cls);
        }
    }

    public final synchronized void ee(String str) {
        try {
            Class cls = Class.forName(str);
            if (d.class.isAssignableFrom(cls)) {
                f(cls);
            } else {
                j.e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", str);
            }
        } catch (ClassNotFoundException e) {
            j.e("MMSkeleton.CorePlugins", "plugin %s not found.", str);
            i.vN().vF().vj();
            new Object[1][0] = str;
        }
    }

    private synchronized void a(d dVar) {
        boolean z = false;
        synchronized (this) {
            if (g(dVar.getClass())) {
                j.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", dVar.getClass());
            } else {
                Assert.assertNotNull(dVar);
                String[] ofProcesses = dVar.ofProcesses();
                if (ofProcesses != null && ofProcesses.length > 0) {
                    e vj = i.vN().vF().vj();
                    for (String ej : ofProcesses) {
                        z = vj.ej(ej);
                        if (z) {
                            break;
                        }
                    }
                    if (!z) {
                        throw new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[]{dVar, vj.gWO, Arrays.asList(ofProcesses)}));
                    }
                }
                this.gXM.put(dVar.getClass(), dVar);
                this.gXN.add(dVar);
                dVar.invokeInstalled();
                if (this.gXS != null) {
                    this.gXS.b(dVar);
                }
            }
        }
    }

    public final synchronized boolean g(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        return this.gXM.containsKey(cls);
    }

    public final synchronized void c(Class<? extends d> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        d dVar = (d) this.gXM.get(cls);
        Assert.assertNotNull(dVar);
        ArrayList arrayList = (ArrayList) this.gXO.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.gXO.put(cls, arrayList);
        }
        this.gXP.put(cls2, cls);
        arrayList.add(cls2);
        this.gXM.put(cls2, dVar);
    }

    public final <T extends com.tencent.mm.kernel.c.a> T h(Class<T> cls) {
        int i;
        b bVar = (b) this.gXR.get(cls);
        if (cls.isInterface() || !Modifier.isAbstract(cls.getModifiers())) {
            i = 0;
        } else {
            j.w("MMSkeleton.CorePlugins", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!", new Object[0]);
            i = 1;
        }
        if (bVar != null) {
            return bVar.vP();
        }
        j.e("MMSkeleton.CorePlugins", "Service(%s) not found!!! ", cls);
        if (i != 0) {
            j.e("MMSkeleton.CorePlugins", "This error must cause by using implementation class to call service! Use interface instead! Understand?", new Object[0]);
        }
        i.vN().vF().vj();
        new Object[1][0] = cls;
        return (com.tencent.mm.kernel.c.a) g.l(cls);
    }

    public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, b<N> bVar) {
        this.gXR.put(cls, bVar);
        if ((bVar instanceof com.tencent.mm.kernel.c.c) && this.gXS != null) {
            this.gXS.a(bVar.vP());
        }
        j.i("MMSkeleton.CorePlugins", "register service %s %s", cls, bVar);
    }

    public final void i(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        b bVar = (b) this.gXR.remove(cls);
        if ((bVar instanceof com.tencent.mm.kernel.c.c) && this.gXS != null) {
            this.gXS.b(bVar.vP());
        }
    }

    public final synchronized <T extends com.tencent.mm.kernel.b.a> T j(Class<T> cls) {
        T t;
        Assert.assertNotNull(cls);
        t = (com.tencent.mm.kernel.b.a) this.gXM.get(cls);
        if (t == null) {
            t = (com.tencent.mm.kernel.b.a) g.l(cls);
        }
        return t;
    }

    private synchronized boolean k(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean z = false;
        synchronized (this) {
            Assert.assertNotNull(cls);
            if (g(cls)) {
                z = true;
            } else {
                j.w("MMSkeleton.CorePlugins", "Plugin " + cls + " must be installed!", new Object[0]);
            }
        }
        return z;
    }

    public final void d(Class<? extends d> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        if (k(cls2)) {
            Class cls3;
            if (this.gXP.containsKey(cls2)) {
                cls3 = (Class) this.gXP.get(cls2);
            } else {
                Class<? extends com.tencent.mm.kernel.b.a> cls4 = cls2;
            }
            this.gXQ.n(cls, cls3);
            i.vN().vF().vj().gZy.a(j(cls), j(cls3));
            return;
        }
        String format = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[]{cls2.getName(), cls.getName()});
        j.e("MMSkeleton.CorePlugins", format, new Object[0]);
        throw new IllegalAccessError(format);
    }

    public final synchronized void a(e eVar) {
        f fVar = new f(this.gXQ);
        com.tencent.mm.kernel.a.a.a("configure chain ... %s", fVar.vD());
        ArrayList vC = fVar.vC();
        if (vC.size() > 0) {
            throw new RuntimeException("Found cycle dependencies between plugins : " + vC);
        }
        com.tencent.mm.kernel.a.a.a("configure check plugin cycle dependency ok...", new Object[0]);
        Iterator it = r1.iterator();
        while (it.hasNext()) {
            d dVar = (d) j((Class) it.next());
            if (dVar.isConfigured()) {
                com.tencent.mm.kernel.a.a.a("skip configure for plugin %s.", dVar);
            } else {
                com.tencent.mm.kernel.a.a.a("configuring plugin [%s]...", dVar);
                dVar.invokeConfigure(eVar);
                if (this.gXU.containsKey(dVar)) {
                    Iterator it2 = ((ArrayList) this.gXU.get(dVar)).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        }
    }

    public final synchronized void vi() {
        Iterator it = this.gXN.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.isDependencyMade()) {
                com.tencent.mm.kernel.a.a.a("skip make dependency for plugin %s.", dVar);
            } else {
                com.tencent.mm.kernel.a.a.a("make dependency for plugin %s...", dVar);
                dVar.invokeDependency();
            }
        }
    }
}
