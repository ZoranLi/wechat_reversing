package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends a<byte[]> {
    private static int lvH = 0;
    public static final j nEA = new j();

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

    private j() {
    }

    public final synchronized void x(byte[] bArr) {
        super.as(bArr);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        bArr = (byte[]) super.c(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        return bArr;
    }

    protected final long wj() {
        if (lvH <= 0) {
            lvH = ((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (lvH >= 512) {
            return 41943040;
        }
        return 20971520;
    }

    protected final long wk() {
        return 10485760;
    }

    public final void wl() {
        super.wl();
    }
}
