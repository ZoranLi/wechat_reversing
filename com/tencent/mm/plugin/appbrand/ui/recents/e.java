package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.config.SysConfigUtil;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

final class e extends ArrayList<com.tencent.mm.plugin.appbrand.b.e> {
    private final ArrayList<com.tencent.mm.plugin.appbrand.b.e> jnd = new ArrayList(10);
    private final ArrayList<com.tencent.mm.plugin.appbrand.b.e> jne = new ArrayList(m.CTRL_INDEX);

    public final /* synthetic */ Object clone() {
        return XD();
    }

    public final /* synthetic */ Object get(int i) {
        return iz(i);
    }

    public final /* synthetic */ Object remove(int i) {
        return iA(i);
    }

    e() {
    }

    static e c(ArrayList<com.tencent.mm.plugin.appbrand.b.e> arrayList, ArrayList<com.tencent.mm.plugin.appbrand.b.e> arrayList2) {
        e eVar = new e();
        SysConfigUtil.e(eVar.jnd, arrayList);
        SysConfigUtil.e(eVar.jne, arrayList2);
        return eVar;
    }

    final synchronized ArrayList<com.tencent.mm.plugin.appbrand.b.e> XB() {
        return this.jnd;
    }

    final synchronized ArrayList<com.tencent.mm.plugin.appbrand.b.e> XC() {
        return this.jne;
    }

    public final boolean addAll(Collection<? extends com.tencent.mm.plugin.appbrand.b.e> collection) {
        boolean z = false;
        if (e.class.isInstance(collection)) {
            synchronized (this) {
                e eVar = (e) collection;
                this.jnd.addAll(eVar.jnd);
                this.jne.addAll(eVar.jne);
                z = true;
            }
        } else {
            Assert.assertTrue("collection type mismatch!!", false);
        }
        return z;
    }

    public final synchronized e XD() {
        e eVar;
        eVar = new e();
        eVar.jnd.addAll(this.jnd);
        eVar.jne.addAll(this.jne);
        return eVar;
    }

    public final synchronized int size() {
        return this.jnd.size() + this.jne.size();
    }

    private synchronized com.tencent.mm.plugin.appbrand.b.e iz(int i) {
        com.tencent.mm.plugin.appbrand.b.e eVar;
        if (i < this.jnd.size()) {
            eVar = (com.tencent.mm.plugin.appbrand.b.e) this.jnd.get(i);
        } else {
            eVar = (com.tencent.mm.plugin.appbrand.b.e) this.jne.get(i - this.jnd.size());
        }
        return eVar;
    }

    public final synchronized com.tencent.mm.plugin.appbrand.b.e iA(int i) {
        com.tencent.mm.plugin.appbrand.b.e eVar;
        if (i < this.jnd.size()) {
            eVar = (com.tencent.mm.plugin.appbrand.b.e) this.jnd.remove(i);
        } else {
            eVar = (com.tencent.mm.plugin.appbrand.b.e) this.jne.remove(i - this.jnd.size());
        }
        return eVar;
    }

    public final synchronized void clear() {
        this.jnd.clear();
        this.jne.clear();
    }

    public final Iterator<com.tencent.mm.plugin.appbrand.b.e> iterator() {
        Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
        return new Iterator<com.tencent.mm.plugin.appbrand.b.e>(this) {
            final /* synthetic */ e jnf;

            {
                this.jnf = r1;
            }

            public final /* bridge */ /* synthetic */ Object next() {
                return null;
            }

            public final boolean hasNext() {
                return false;
            }

            public final void remove() {
            }
        };
    }
}
