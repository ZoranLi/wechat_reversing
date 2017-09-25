package com.tencent.mm.plugin.appbrand.appcache;

import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a {
    private static final SparseIntArray iyz;

    static int n(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return wrap.getInt();
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        iyz = sparseIntArray;
        sparseIntArray.put(0, R.l.dGO);
        iyz.put(1, R.l.dDu);
        iyz.put(2, R.l.dDt);
    }

    public static String hu(int i) {
        return ab.getResources().getString(iyz.get(i, R.l.dGO));
    }

    public static String nz(String str) {
        if (bg.mA(str)) {
            return str;
        }
        int i = 0;
        while (i < str.length() && '/' == str.charAt(i)) {
            i++;
        }
        return str.substring(i);
    }

    public static String nA(String str) {
        int i = 0;
        w.d("MicroMsg.AppBrandAppCacheUtil", "eliminateDuplicateSlashForPkgFile, original file name = %s", new Object[]{str});
        if (!str.startsWith("/")) {
            return "/" + str;
        }
        while (i < str.length() && '/' == str.charAt(i)) {
            i++;
        }
        return "/" + str.substring(i);
    }
}
