package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.wcdb.FileUtils;

public final class q {
    public static void a(byte[] bArr, int i, String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3;
            char charAt = str.charAt(i2);
            if (charAt != '\u0000' && charAt <= '') {
                i3 = i + 1;
                bArr[i] = (byte) charAt;
            } else if (charAt <= '߿') {
                r4 = i + 1;
                bArr[i] = (byte) (((charAt >> 6) & 31) | bg.CTRL_INDEX);
                i3 = r4 + 1;
                bArr[r4] = (byte) ((charAt & 63) | FileUtils.S_IWUSR);
            } else {
                i3 = i + 1;
                bArr[i] = (byte) (((charAt >> 12) & 15) | 224);
                r4 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 63) | FileUtils.S_IWUSR);
                i3 = r4 + 1;
                bArr[r4] = (byte) ((charAt & 63) | FileUtils.S_IWUSR);
            }
            i2++;
            i = i3;
        }
    }
}
