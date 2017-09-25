package com.tencent.mm.kernel.b;

import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kernel.j;
import java.util.HashSet;
import junit.framework.Assert;

public abstract class d implements c {
    private static final String TAG = "MMKernel.Plugin";
    private boolean mConfigured = false;
    private boolean mDependencyMade = false;
    private boolean mInstalled = false;
    private boolean mMakingDependencies = false;
    private boolean mPendingInstall = false;
    private HashSet<b> mPins = new HashSet();

    public void invokeInstalled() {
        this.mInstalled = true;
        installed();
        detectAlias();
    }

    private final void detectAlias() {
        for (Class cls : getClass().getInterfaces()) {
            if (a.class.isAssignableFrom(cls)) {
                alias(cls);
            }
        }
    }

    public void installed() {
    }

    public void dependency() {
    }

    public void uninstalled() {
        this.mConfigured = false;
        this.mInstalled = false;
    }

    public void invokeDependency() {
        this.mMakingDependencies = true;
        dependency();
        checkIfNeedDefaultDependency();
        this.mDependencyMade = true;
        this.mMakingDependencies = false;
    }

    private void checkIfNeedDefaultDependency() {
        i.vN();
        c vE = i.vE();
        if (!vE.gXQ.aq(getClass())) {
            i.vN();
            Class cls = i.vE().gXT;
            if (cls != null) {
                dependsOn(cls);
                j.i(TAG, "plugin[%s] not specific any depsOn, we using default one [%s]", this, cls);
            }
        }
    }

    public void invokeConfigure(e eVar) {
        configure(eVar);
        this.mConfigured = true;
    }

    public void alias(Class<? extends a> cls) {
        Assert.assertNotNull(cls);
        Assert.assertTrue(cls.isInstance(this));
        i.vN();
        i.vE().c(getClass(), cls);
    }

    public synchronized void pin(b bVar) {
        if (!this.mPins.contains(bVar)) {
            this.mPins.add(bVar);
            i.vN();
            i.vE().a(bVar.getClass(), new com.tencent.mm.kernel.c.c(bVar));
        }
    }

    public synchronized void unpin(b bVar) {
        if (this.mPins.contains(bVar)) {
            this.mPins.remove(bVar);
            i.vN();
            i.vE().i(bVar.getClass());
        }
    }

    public void dependsOnRoot() {
        if (this.mMakingDependencies) {
            i.vN();
            i.vE().d(getClass(), getClass());
            return;
        }
        j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
    }

    public void dependsOn(Class<? extends a> cls) {
        if (this.mMakingDependencies) {
            i.vN();
            i.vE().d(getClass(), cls);
            return;
        }
        j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
    }

    public String identify() {
        return getClass().getSimpleName();
    }

    public boolean isConfigured() {
        return this.mConfigured;
    }

    public boolean isDependencyMade() {
        return this.mDependencyMade;
    }

    public String name() {
        return toString();
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
    }

    public String[] ofProcesses() {
        return new String[0];
    }

    public int hashCode() {
        return name().hashCode();
    }
}
