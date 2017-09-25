package a.a.a.b.b;

import com.tencent.wcdb.FileUtils;
import java.io.UnsupportedEncodingException;

public final class a {
    private final int aIo;
    private final byte[] buffer;
    private int position = 0;

    public a(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aIo = i2 + 0;
    }

    public static int f(int i, String str) {
        if (str == null) {
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + (cH(i) + cJ(bytes.length));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported.");
        }
    }

    public final void cG(int i) {
        byte b = (byte) i;
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    public final void j(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (bArr == null) {
                return;
            }
            if (this.aIo - this.position >= length) {
                System.arraycopy(bArr, 0, this.buffer, this.position, length);
                this.position = length + this.position;
                return;
            }
            int i = this.aIo - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            int i2 = i + 0;
            length -= i;
            this.position = this.aIo;
            if (length <= this.aIo) {
                System.arraycopy(bArr, i2, this.buffer, 0, length);
                this.position = length;
            }
        }
    }

    public final void at(int i, int i2) {
        cI(a.a.a.b.a.au(i, i2));
    }

    public static int cH(int i) {
        return cJ(a.a.a.b.a.au(i, 0));
    }

    public final void cI(int i) {
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

    public final void n(long j) {
        while ((-128 & j) != 0) {
            cG((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        cG((int) j);
    }
}
