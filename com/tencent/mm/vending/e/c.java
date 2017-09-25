package com.tencent.mm.vending.e;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c<_Target extends a> implements a, b<_Target> {
    private List<WeakReference<_Target>> wCH = new ArrayList();
    private boolean wCI = true;

    public final synchronized void a(_Target _Target) {
        if (this.wCI) {
            this.wCH.add(new WeakReference(_Target));
        } else {
            Assert.assertNotNull(_Target);
            _Target.dead();
        }
    }

    public final synchronized void dead() {
        if (this.wCI) {
            for (WeakReference weakReference : this.wCH) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.dead();
                }
            }
            this.wCH.clear();
            this.wCI = false;
        }
    }
}
