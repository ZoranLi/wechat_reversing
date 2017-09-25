package com.tencent.mm.bh;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;

public final class d {
    public byte[] jQY;
    public SparseArray<a> upw;

    static class a {
        public final int rqp;
        public final int[] upx;

        public a(int i, int[] iArr) {
            this.rqp = i;
            this.upx = iArr;
        }
    }

    private d(SparseArray<a> sparseArray, byte[] bArr) {
        this.upw = sparseArray;
        this.jQY = bArr;
    }

    public static d b(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                w.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new d(sparseArray, bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", bg.g(e));
            return null;
        }
    }
}
