package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.b.b;
import com.tencent.wcdb.FileUtils;

public final class o {
    public static int a(a aVar) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        do {
            int readByte = aVar.readByte() & 255;
            i3 |= (readByte & 127) << (i * 7);
            i2 <<= 7;
            i++;
            if ((readByte & FileUtils.S_IWUSR) != FileUtils.S_IWUSR) {
                break;
            }
        } while (i < 5);
        if ((readByte & FileUtils.S_IWUSR) == FileUtils.S_IWUSR) {
            throw new j("invalid LEB128 sequence");
        } else if (((i2 >> 1) & i3) != 0) {
            return i3 | i2;
        } else {
            return i3;
        }
    }

    public static int b(a aVar) {
        int i = 0;
        int i2 = 0;
        do {
            int readByte = aVar.readByte() & 255;
            i2 |= (readByte & 127) << (i * 7);
            i++;
            if ((readByte & FileUtils.S_IWUSR) != FileUtils.S_IWUSR) {
                break;
            }
        } while (i < 5);
        if ((readByte & FileUtils.S_IWUSR) != FileUtils.S_IWUSR) {
            return i2;
        }
        throw new j("invalid LEB128 sequence");
    }

    public static int c(a aVar) {
        return b(aVar) - 1;
    }

    public static int a(b bVar, int i) {
        int i2 = 0;
        for (int i3 = i >>> 7; i3 != 0; i3 >>>= 7) {
            bVar.writeByte((byte) ((i & 127) | FileUtils.S_IWUSR));
            i2++;
            i = i3;
        }
        bVar.writeByte((byte) (i & 127));
        return i2 + 1;
    }

    public static int b(b bVar, int i) {
        return a(bVar, i + 1);
    }

    public static int c(b bVar, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        int i4 = 0;
        Object obj = 1;
        int i5 = i2;
        while (obj != null) {
            if (i5 == i3 && (i5 & 1) == ((i >> 6) & 1)) {
                obj = null;
            } else {
                obj = 1;
            }
            int i6 = i & 127;
            if (obj != null) {
                i2 = FileUtils.S_IWUSR;
            } else {
                i2 = 0;
            }
            bVar.writeByte((byte) (i2 | i6));
            i = i5;
            i5 >>= 7;
            i4++;
        }
        return i4;
    }
}
