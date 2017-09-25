package com.google.a.a;

import com.tencent.wcdb.FileUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b {
    final int aIo;
    private final byte[] buffer;
    int position = 0;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    b(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aIo = i2 + 0;
    }

    public final void f(int i, long j) {
        at(i, 0);
        n(j);
    }

    public final void g(int i, long j) {
        at(i, 0);
        n(j);
    }

    public final void ap(int i, int i2) {
        at(i, 0);
        if (i2 >= 0) {
            cI(i2);
        } else {
            n((long) i2);
        }
    }

    public final void e(int i, String str) {
        at(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        cI(bytes.length);
        j(bytes);
    }

    public final void a(int i, e eVar) {
        at(i, 2);
        if (eVar.aIq < 0) {
            eVar.mX();
        }
        cI(eVar.aIq);
        eVar.a(this);
    }

    public final void a(int i, byte[] bArr) {
        at(i, 2);
        cI(bArr.length);
        j(bArr);
    }

    public final void aq(int i, int i2) {
        at(i, 0);
        cI(i2);
    }

    public static int h(int i, long j) {
        return cH(i) + o(j);
    }

    public static int i(int i, long j) {
        return cH(i) + o(j);
    }

    public static int ar(int i, int i2) {
        return cH(i) + cF(i2);
    }

    public static int f(int i, String str) {
        return cH(i) + au(str);
    }

    public static int b(int i, e eVar) {
        int cH = cH(i);
        int mX = eVar.mX();
        return cH + (mX + cJ(mX));
    }

    public static int b(int i, byte[] bArr) {
        return cH(i) + (cJ(bArr.length) + bArr.length);
    }

    public static int as(int i, int i2) {
        return cH(i) + cJ(i2);
    }

    public static int cF(int i) {
        if (i >= 0) {
            return cJ(i);
        }
        return 10;
    }

    public static int au(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + cJ(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    private void cG(int i) {
        byte b = (byte) i;
        if (this.position == this.aIo) {
            throw new a(this.position, this.aIo);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    private void j(byte[] bArr) {
        int length = bArr.length;
        if (this.aIo - this.position >= length) {
            System.arraycopy(bArr, 0, this.buffer, this.position, length);
            this.position = length + this.position;
            return;
        }
        throw new a(this.position, this.aIo);
    }

    private void at(int i, int i2) {
        cI(g.au(i, i2));
    }

    private static int cH(int i) {
        return cJ(g.au(i, 0));
    }

    private void cI(int i) {
        while ((i & -128) != 0) {
            cG((i & 127) | FileUtils.S_IWUSR);
            i >>>= 7;
        }
        cG(i);
    }

    public static int cJ(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    private void n(long j) {
        while ((-128 & j) != 0) {
            cG((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        cG((int) j);
    }

    private static int o(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }
}
