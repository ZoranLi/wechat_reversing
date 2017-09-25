package com.tencent.mm.memory;

import java.util.Arrays;

public final class g extends a<byte[]> {
    public static final g hgG = new g();

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

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    private g() {
    }

    public final synchronized void x(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        super.as(bArr);
    }

    protected final long wj() {
        return 5242880;
    }

    protected final long wk() {
        return 1048576;
    }
}
