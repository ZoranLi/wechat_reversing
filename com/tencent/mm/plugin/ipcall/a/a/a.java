package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public abstract class a implements e {
    protected int errCode = 0;
    protected int errType = 0;
    public a mNH;
    public c mNd;

    public interface a {
        void a(int i, Object obj, int i2, int i3);

        void b(int i, Object obj, int i2, int i3);
    }

    public abstract int De();

    public abstract int[] aEt();

    public abstract void b(c cVar);

    public abstract void onDestroy();

    public abstract void oo();

    public void init() {
        for (int a : aEt()) {
            ap.vd().a(a, this);
        }
        oo();
    }

    public void destroy() {
        for (int b : aEt()) {
            ap.vd().b(b, this);
        }
        this.mNH = null;
        onDestroy();
    }

    public void a(c cVar) {
        w.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[]{Integer.valueOf(De())});
        this.mNd = cVar;
        b(this.mNd);
    }

    public void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()), Integer.valueOf(De())});
        this.errType = i;
        this.errCode = i2;
        if (i == 0 && i2 == 0) {
            if (this.mNH != null) {
                this.mNH.a(De(), kVar, i, i2);
            }
        } else if (this.mNH != null) {
            this.mNH.b(De(), kVar, i, i2);
        }
    }
}
