package com.tencent.mm.plugin.h.a.b.a;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Serializable;

public abstract class a implements Serializable {
    private static final String TAG = a.class.getName();
    public String jSL;
    public int jSM;
    public long jSe;

    public abstract byte[] adj();

    public static a Y(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            w.e(TAG, "data input error");
            return null;
        }
        Object am = b.am(bArr);
        if (am != null && (am instanceof a)) {
            return (a) am;
        }
        w.e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
