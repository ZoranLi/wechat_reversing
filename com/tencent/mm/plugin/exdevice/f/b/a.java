package com.tencent.mm.plugin.exdevice.f.b;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a {
    SparseArray<WeakReference<e>> lgc;

    public final void a(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.lgc == null) {
            this.lgc = new SparseArray();
        }
        this.lgc.put(eVar.hashCode(), new WeakReference(eVar));
    }

    public final void b(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.lgc == null) {
            w.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
        } else {
            this.lgc.remove(eVar.hashCode());
        }
    }

    public final void a(String str, d dVar) {
        Assert.assertTrue(true);
        if (this.lgc == null) {
            w.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
            return;
        }
        for (int i = 0; i < this.lgc.size(); i++) {
            e eVar = (e) ((WeakReference) this.lgc.get(this.lgc.keyAt(i))).get();
            if (eVar != null) {
                eVar.b(str, dVar);
            }
        }
        w.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
    }
}
