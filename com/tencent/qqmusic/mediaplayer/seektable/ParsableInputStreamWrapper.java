package com.tencent.qqmusic.mediaplayer.seektable;

import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ParsableInputStreamWrapper implements Parsable, Closeable {
    private final byte[] intBuffer = new byte[4];
    private final byte[] longBuffer = new byte[8];
    private long position = 0;
    private final InputStream stream;

    public ParsableInputStreamWrapper(InputStream inputStream) {
        this.stream = inputStream;
    }

    public int readInt() {
        int read = this.stream.read(this.intBuffer);
        this.position += (long) read;
        if (read != this.intBuffer.length) {
            return -1;
        }
        return ((((this.intBuffer[0] & 255) << 24) | ((this.intBuffer[1] & 255) << 16)) | ((this.intBuffer[2] & 255) << 8)) | (this.intBuffer[3] & 255);
    }

    public long readLong() {
        int read = this.stream.read(this.longBuffer);
        this.position += (long) read;
        if (read != this.longBuffer.length) {
            return -1;
        }
        return ((((((((((long) this.longBuffer[0]) & 255) << 56) | ((((long) this.longBuffer[1]) & 255) << 48)) | ((((long) this.longBuffer[2]) & 255) << 40)) | ((((long) this.longBuffer[3]) & 255) << 32)) | ((((long) this.longBuffer[4]) & 255) << 24)) | ((((long) this.longBuffer[5]) & 255) << 16)) | ((((long) this.longBuffer[6]) & 255) << 8)) | (((long) this.longBuffer[7]) & 255);
    }

    public int[] readIntArray(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    public long[] readLongArray(int i) {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = readLong();
        }
        return jArr;
    }

    public void readIntArrayInterleaved(int i, int[]... iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int[] iArr2 : iArr) {
                iArr2[i2] = readInt();
            }
        }
    }

    public void readLongArrayInterleaved(int i, long[]... jArr) {
        for (int i2 = 0; i2 < i; i2++) {
            for (long[] jArr2 : jArr) {
                jArr2[i2] = readLong();
            }
        }
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        this.position += (long) this.stream.read(bArr, i, i2);
    }

    public String readString(int i) {
        byte[] bArr = new byte[i];
        readBytes(bArr, 0, i);
        if (VERSION.SDK_INT >= 9) {
            return new String(bArr, Charset.defaultCharset());
        }
        return new String(bArr);
    }

    public long available() {
        return (long) this.stream.available();
    }

    public long skip(long j) {
        long j2 = 0;
        while (j2 != j) {
            long skip = this.stream.skip(j - j2);
            j2 += skip;
            if (skip <= 0) {
                break;
            }
        }
        this.position += j;
        return j2;
    }

    public long tell() {
        return this.position;
    }

    public void close() {
        this.stream.close();
    }
}
