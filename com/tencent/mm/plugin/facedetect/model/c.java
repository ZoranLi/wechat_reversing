package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends a<byte[]> {
    public static final c lvG = new c();
    private static int lvH = 0;

    public final /* synthetic */ void as(Object obj) {
        x((byte[]) obj);
    }

    protected final /* bridge */ /* synthetic */ long at(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    protected final /* synthetic */ Comparable au(Object obj) {
        byte[] bArr = (byte[]) obj;
        return (bArr == null || bArr.length <= 0) ? Integer.valueOf(0) : Integer.valueOf(bArr.length);
    }

    protected final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new f(((Integer) comparable).intValue());
    }

    public final /* synthetic */ Object c(Integer num) {
        return h(num);
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    public static void bT(int i, int i2) {
        w.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(5)});
        long NA = bg.NA();
        for (int i3 = 0; i3 < 5; i3++) {
            lvG.x(new byte[(((i * i2) * 3) / 2)]);
        }
        w.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
    }

    private c() {
    }

    public final synchronized void x(byte[] bArr) {
        super.as(bArr);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        bArr = (byte[]) super.c(num);
        if (bArr == null) {
            w.v("MicroMsg.FaceByteArrayPool", "hy: getExactSize no data");
            bArr = new byte[num.intValue()];
        } else {
            w.v("MicroMsg.FaceByteArrayPool", "hy: got exactSize data");
        }
        return bArr;
    }

    protected final long wj() {
        if (lvH <= 0) {
            lvH = ((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (lvH >= 512) {
            return 20971520;
        }
        return 10485760;
    }

    protected final long wk() {
        return 20971520;
    }

    public final void wl() {
        super.wl();
    }
}
