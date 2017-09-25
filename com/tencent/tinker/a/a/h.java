package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class h extends a<h> {
    public int xcb;
    public int[] xcc;
    public byte[] xcd;

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        int i = this.xcb;
        int i2 = hVar.xcb;
        if (i != i2) {
            return i - i2;
        }
        int[] iArr = this.xcc;
        int[] iArr2 = hVar.xcc;
        int length = iArr.length;
        i = iArr2.length;
        if (length < i) {
            i = -1;
        } else if (length > i) {
            i = 1;
        } else {
            for (i2 = 0; i2 < length; i2++) {
                i = c.eD(iArr[i2], iArr2[i2]);
                if (i != 0) {
                    break;
                }
            }
            i = 0;
        }
        return i == 0 ? c.l(this.xcd, hVar.xcd) : i;
    }

    public h(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.xcb = i2;
        this.xcc = iArr;
        this.xcd = bArr;
    }
}
