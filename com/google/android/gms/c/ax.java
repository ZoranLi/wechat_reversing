package com.google.android.gms.c;

import com.tencent.wcdb.FileUtils;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

public final class ax {
    final ByteBuffer aCx;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private ax(ByteBuffer byteBuffer) {
        this.aCx = byteBuffer;
    }

    private ax(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | FileUtils.S_IWUSR);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | FileUtils.S_IWUSR);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | FileUtils.S_IWUSR);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | FileUtils.S_IWUSR);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | FileUtils.S_IWUSR);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | FileUtils.S_IWUSR);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            b(charSequence, byteBuffer);
        }
    }

    public static int aj(String str) {
        int m = m(str);
        return m + cp(m);
    }

    public static int al(int i, int i2) {
        return cn(i) + cl(i2);
    }

    public static int b(int i, be beVar) {
        int cn = cn(i);
        int lH = beVar.lH();
        return cn + (lH + cp(lH));
    }

    public static ax b(byte[] bArr, int i, int i2) {
        return new ax(bArr, 0, i2);
    }

    private static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | FileUtils.S_IWUSR));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | FileUtils.S_IWUSR));
                byteBuffer.put((byte) ((charAt & 63) | FileUtils.S_IWUSR));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | FileUtils.S_IWUSR));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | FileUtils.S_IWUSR));
                        byteBuffer.put((byte) ((toCodePoint & 63) | FileUtils.S_IWUSR));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int cl(int i) {
        return i >= 0 ? cp(i) : 10;
    }

    public static int cn(int i) {
        return cp(bh.an(i, 0));
    }

    public static int cp(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int cq(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int d(int i, String str) {
        return cn(i) + aj(str);
    }

    public static int e(int i, long j) {
        return cn(i) + k(j);
    }

    public static int k(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private void l(long j) {
        while ((-128 & j) != 0) {
            cm((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        cm((int) j);
    }

    private static int m(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new IllegalArgumentException("Unpaired surrogate at index " + i2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i += i3;
                if (i < length) {
                    return i;
                }
                throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
            }
        }
        i = i3;
        if (i < length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    public final void a(int i, be beVar) {
        am(i, 2);
        b(beVar);
    }

    public final void ak(int i, int i2) {
        am(i, 0);
        if (i2 >= 0) {
            co(i2);
        } else {
            l((long) i2);
        }
    }

    public final void am(int i, int i2) {
        co(bh.an(i, i2));
    }

    public final void b(be beVar) {
        co(beVar.lG());
        beVar.a(this);
    }

    public final void c(int i, float f) {
        am(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        cm(floatToIntBits & 255);
        cm((floatToIntBits >> 8) & 255);
        cm((floatToIntBits >> 16) & 255);
        cm((floatToIntBits >> 24) & 255);
    }

    public final void c(int i, String str) {
        am(i, 2);
        try {
            int cp = cp(str.length());
            if (cp == cp(str.length() * 3)) {
                int position = this.aCx.position();
                this.aCx.position(position + cp);
                a((CharSequence) str, this.aCx);
                int position2 = this.aCx.position();
                this.aCx.position(position);
                co((position2 - position) - cp);
                this.aCx.position(position2);
                return;
            }
            co(m(str));
            a((CharSequence) str, this.aCx);
        } catch (BufferOverflowException e) {
            throw new a(this.aCx.position(), this.aCx.limit());
        }
    }

    public final void cm(int i) {
        byte b = (byte) i;
        if (this.aCx.hasRemaining()) {
            this.aCx.put(b);
            return;
        }
        throw new a(this.aCx.position(), this.aCx.limit());
    }

    public final void co(int i) {
        while ((i & -128) != 0) {
            cm((i & 127) | FileUtils.S_IWUSR);
            i >>>= 7;
        }
        cm(i);
    }

    public final void d(int i, long j) {
        am(i, 0);
        l(j);
    }

    public final void g(byte[] bArr) {
        int length = bArr.length;
        if (this.aCx.remaining() >= length) {
            this.aCx.put(bArr, 0, length);
            return;
        }
        throw new a(this.aCx.position(), this.aCx.limit());
    }

    public final void q(int i, boolean z) {
        int i2 = 0;
        am(i, 0);
        if (z) {
            i2 = 1;
        }
        cm(i2);
    }
}
