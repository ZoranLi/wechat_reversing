package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends a<Bitmap> {
    private static int hgy = 20971520;
    public static final c hgz = new c();

    public final /* synthetic */ Object a(Comparable comparable) {
        return e((Integer) comparable);
    }

    public final /* synthetic */ void as(Object obj) {
        e((Bitmap) obj);
    }

    @TargetApi(19)
    protected final /* synthetic */ long at(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            return 0;
        }
        return (long) (d.ep(19) ? bitmap.getByteCount() : bitmap.getAllocationByteCount());
    }

    protected final /* synthetic */ Comparable au(Object obj) {
        return d((Bitmap) obj);
    }

    protected final /* synthetic */ Comparable b(Comparable comparable) {
        return d((Integer) comparable);
    }

    public final /* synthetic */ Object b(Integer num) {
        return e(num);
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new b(((Integer) comparable).intValue());
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return Bitmap.createBitmap(1, ((Integer) comparable).intValue(), k.hgI);
    }

    private c() {
        w.i("MicroMsg.BitmapPool", "BitmapPool %dMB", Integer.valueOf(((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass()));
        if (((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) {
            hgy = 20971520;
        } else {
            hgy = 10485760;
        }
        wn();
    }

    protected static Integer d(Integer num) {
        return Integer.valueOf(num.intValue() * 4);
    }

    protected final long wj() {
        return (long) hgy;
    }

    protected final long wk() {
        return 1048576;
    }

    public final synchronized Bitmap e(Integer num) {
        Bitmap bitmap;
        bitmap = (Bitmap) super.b(num);
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            bitmap = null;
        } else {
            w.d("MicroMsg.BitmapPool", "get stored element: %s, width: %s, height: %s, size: %s, requireSize: %s", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), d(bitmap), num);
        }
        return bitmap;
    }

    private static Integer d(Bitmap bitmap) {
        if (bitmap == null) {
            return Integer.valueOf(0);
        }
        int byteCount;
        if (d.ep(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        return Integer.valueOf(byteCount);
    }

    public final synchronized void e(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable() && !bitmap.isRecycled()) {
                w.i("MicroMsg.BitmapPool", "release: %s", bitmap);
                super.as(bitmap);
            }
        }
    }

    public final void wl() {
        super.wl();
    }
}
