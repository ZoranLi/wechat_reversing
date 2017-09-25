package com.tencent.mm.bh;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;

public final class b {
    public byte[] jQY;
    public SparseArray<a> upr;

    static class a {
        public final int ups;
        public final int[] upt;
        public final int[] upu;

        public a(int i, int[] iArr, int[] iArr2) {
            this.ups = i;
            this.upt = iArr;
            this.upu = iArr2;
        }
    }

    private b(SparseArray<a> sparseArray, byte[] bArr) {
        this.upr = sparseArray;
        this.jQY = bArr;
    }

    public static b a(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                w.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new b(sparseArray, bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", bg.g(e));
            return null;
        }
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        Throwable e;
        String str;
        try {
            int indexOfKey = this.upr.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            a aVar = (a) this.upr.valueAt(indexOfKey);
            int length = aVar.upt.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5;
                if (aVar.upt[i3] == i2) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
            }
            if (indexOfKey <= this.upr.size() - 1) {
                if (i4 >= length - 1) {
                    str = new String(this.jQY, aVar.upu[i4], ((a) this.upr.valueAt(indexOfKey + 1)).upu[0] - aVar.upu[i4]);
                } else {
                    str = new String(this.jQY, aVar.upu[i4], aVar.upu[i4 + 1] - aVar.upu[i4]);
                }
            } else if (i4 >= length - 1) {
                str = new String(this.jQY, aVar.upu[i4], this.jQY.length - aVar.upu[i4]);
            } else {
                str = new String(this.jQY, aVar.upu[i4], aVar.upu[i4 + 1] - aVar.upu[i4]);
            }
            try {
                if (bg.mA(str) || objArr != null) {
                    return String.format(str, objArr);
                }
                return str;
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", bg.g(e));
                return str;
            }
        } catch (Throwable e3) {
            e = e3;
            str = null;
            w.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", bg.g(e));
            return str;
        }
    }
}
