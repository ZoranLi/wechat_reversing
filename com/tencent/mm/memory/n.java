package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class n implements i {
    private static ConcurrentHashMap<Bitmap, Integer> hgQ = new ConcurrentHashMap();
    private boolean DEBUG = false;
    public Bitmap bitmap = null;
    private ae hgN = new ae(Looper.getMainLooper());
    private boolean hgO = false;
    private AtomicInteger hgP = new AtomicInteger();
    private boolean hgR = true;
    private Runnable hgS = new Runnable(this) {
        final /* synthetic */ n hgV;

        {
            this.hgV = r1;
        }

        public final void run() {
            this.hgV.wz();
        }
    };
    private int hgT = 0;
    private int hgU = 0;

    private n(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.hgP.set(1);
        if (this.DEBUG) {
            w.i("MicroMsg.ReleasableBitmap", "bitmap " + bitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bg.bJZ().toString());
        }
        this.hgO = false;
        getAllocationByteCount();
    }

    public static n g(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new n(bitmap);
    }

    public final Bitmap ww() {
        this.hgR = false;
        return this.bitmap;
    }

    public final void ws() {
        this.hgP.incrementAndGet();
        if (this.DEBUG) {
            w.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.hgP + " bitmap:" + this.bitmap + " " + this + " " + bg.bJZ().toString());
        }
    }

    public final void wt() {
        if (this.DEBUG) {
            w.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.hgP + " bitmap:" + this.bitmap + " " + this + " " + bg.bJZ().toString());
        }
        if (this.hgP.get() > 0) {
            this.hgP.decrementAndGet();
            if (this.hgP.get() >= 0) {
                this.hgN.removeCallbacks(this.hgS);
                this.hgN.postDelayed(this.hgS, 500);
            }
        }
    }

    public final Bitmap wx() {
        if (this.DEBUG) {
            w.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bg.bJZ().toString());
        }
        return this.bitmap;
    }

    public final boolean isRecycled() {
        return this.hgO || this.bitmap == null || this.bitmap.isRecycled();
    }

    public final boolean wy() {
        this.hgP.decrementAndGet();
        if (this.DEBUG) {
            w.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.hgO + " isMutable:" + this.hgR + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hgP + bg.bJZ().toString());
        }
        wz();
        return true;
    }

    public final boolean wz() {
        if (this.DEBUG) {
            w.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.hgO + " isMutable:" + this.hgR + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hgP + bg.bJZ().toString());
        }
        if (this.hgO || this.hgP.get() > 0) {
            return false;
        }
        this.hgO = true;
        if (this.DEBUG) {
            hgQ.remove(this.bitmap);
        }
        if (!this.hgR) {
            return true;
        }
        l.wu().f(this.bitmap);
        return true;
    }

    public final int getAllocationByteCount() {
        if (d.ep(19)) {
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                w.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.hgT + " " + toString());
                return this.hgT;
            }
            this.hgT = this.bitmap.getByteCount();
            return this.hgT;
        } else if (this.bitmap == null || this.bitmap.isRecycled()) {
            w.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.hgU + " " + toString());
            return this.hgU;
        } else {
            this.hgU = this.bitmap.getAllocationByteCount();
            return this.hgU;
        }
    }

    public final String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode() + " attachCount: " + this.hgP;
        if (this.bitmap != null) {
            return str + this.bitmap;
        }
        return str;
    }

    protected final void finalize() {
        if (this.DEBUG) {
            w.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
        }
    }

    public final String wA() {
        return this + " " + this.bitmap;
    }
}
