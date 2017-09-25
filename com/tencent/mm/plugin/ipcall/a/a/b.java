package com.tencent.mm.plugin.ipcall.a.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public abstract class b extends a implements com.tencent.mm.plugin.ipcall.a.a.a.a {
    private ae mHandler = new ae(Looper.getMainLooper());
    protected boolean mNI = false;
    public a mNJ = null;

    public interface a {
        void a(int i, k kVar, int i2, int i3);

        void b(int i, k kVar, int i2, int i3);
    }

    public abstract int aEu();

    public abstract void aEv();

    public abstract void aEw();

    public abstract void b(c cVar);

    public abstract void onStop();

    public final void init() {
        this.mNH = this;
        super.init();
    }

    public final void destroy() {
        super.destroy();
    }

    public final void a(c cVar) {
        super.a(cVar);
        this.mNI = true;
        w.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[]{Integer.valueOf(De())});
    }

    public final void stop() {
        this.mNI = false;
        onStop();
        w.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[]{Integer.valueOf(De())});
    }

    public final void a(int i, Object obj, int i2, int i3) {
        w.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.mNI), Integer.valueOf(aEu())});
        aEv();
        if (this.mNJ != null) {
            this.mNJ.a(i, (k) obj, i2, i3);
        }
        if (this.mNI) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ b mNK;

                {
                    this.mNK = r1;
                }

                public final void run() {
                    this.mNK.b(this.mNK.mNd);
                }
            }, (long) aEu());
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        w.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.mNI), Integer.valueOf(aEu())});
        aEw();
        if (this.mNJ != null) {
            this.mNJ.b(i, (k) obj, i2, i3);
        }
        if (this.mNI) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ b mNK;

                {
                    this.mNK = r1;
                }

                public final void run() {
                    this.mNK.b(this.mNK.mNd);
                }
            }, (long) aEu());
        }
    }
}
