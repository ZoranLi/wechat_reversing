package com.tencent.mm.bh;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;

public final class f {
    SparseIntArray upH;
    byte[] upI;

    private f(SparseIntArray sparseIntArray, byte[] bArr) {
        this.upH = sparseIntArray;
        this.upI = bArr;
    }

    public static f a(SparseIntArray sparseIntArray, InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        try {
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                w.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
            }
            return new f(sparseIntArray, bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", bg.g(e));
            return null;
        }
    }

    public final String getString(int i) {
        String str;
        try {
            int indexOfKey = this.upH.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            int valueAt;
            int valueAt2 = this.upH.valueAt(indexOfKey);
            if (indexOfKey < this.upH.size() - 1) {
                valueAt = this.upH.valueAt(indexOfKey + 1) - valueAt2;
            } else {
                valueAt = this.upI.length - valueAt2;
            }
            str = new String(this.upI, valueAt2, valueAt, "UTF-8");
            return str;
        } catch (Throwable e) {
            w.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bg.g(e));
            str = null;
        } catch (Throwable e2) {
            w.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bg.g(e2));
            str = null;
        }
    }
}
