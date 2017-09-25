package com.tencent.mm.plugin.h.a.b.a;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.h.a.b.h;
import com.tencent.mm.sdk.platformtools.w;

@TargetApi(18)
public class f extends a {
    static final String TAG = f.class.getName();
    public static String jTQ = h.jSt;
    public static String jTR = h.jSu;
    public int jTS;
    public int jTT;
    public int jTU;
    public long jTV;
    public long jTW;

    public f() {
        this.jSL = null;
        this.jSM = 8;
        this.jSe = 1;
        this.jTS = -1;
        this.jTT = -1;
        this.jTU = -1;
        this.jTV = 0;
        this.jTW = 0;
    }

    public final byte[] adj() {
        if (this.jTS < 0) {
            w.e(TAG, "stepCount is invalid");
            return null;
        }
        int i;
        if (this.jTT >= 0) {
            i = 7;
        } else {
            i = 4;
        }
        if (this.jTU >= 0) {
            i += 3;
        }
        byte[] bArr = new byte[i];
        bArr[0] = (byte) 1;
        i = 1;
        int i2 = 0;
        while (i2 < 3) {
            bArr[i] = (byte) ((this.jTS >> (i2 * 8)) & 255);
            i2++;
            i++;
        }
        if (this.jTT >= 0) {
            bArr[0] = (byte) (bArr[0] | 2);
            i2 = 0;
            while (i2 < 3) {
                bArr[i] = (byte) ((this.jTT >> (i2 * 8)) & 255);
                i2++;
                i++;
            }
        }
        if (this.jTU >= 0) {
            bArr[0] = (byte) 4;
            int i3 = i;
            for (i = 0; i < 3; i++) {
                bArr[i3] = (byte) ((this.jTU >> (i * 8)) & 255);
                i3++;
            }
        }
        return bArr;
    }
}
