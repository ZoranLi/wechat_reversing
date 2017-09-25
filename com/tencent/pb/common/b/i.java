package com.tencent.pb.common.b;

import com.tencent.pb.common.c.d;
import java.lang.ref.WeakReference;

public final class i implements c {
    private WeakReference<c> wLC;

    public i(c cVar) {
        this.wLC = new WeakReference(cVar);
    }

    public final void n(int i, byte[] bArr) {
        if (this.wLC == null || this.wLC.get() == null) {
            d.k("OnRespForLongAIDLImpl fail", "callback is null, errCode=" + i);
            return;
        }
        ((c) this.wLC.get()).n(i, bArr);
    }
}
