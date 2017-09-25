package com.tencent.mm.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public final class d {
    public static int a(RandomAccessFile randomAccessFile, File file, File file2, int i) {
        if (randomAccessFile.length() <= 0) {
            return 3;
        }
        if (file2.length() <= 0) {
            return 2;
        }
        byte[] bArr = new byte[((int) file2.length())];
        e.a(new FileInputStream(file2), bArr, bArr.length);
        return a(randomAccessFile, (int) randomAccessFile.length(), bArr, bArr.length, file, i);
    }

    private static int a(RandomAccessFile randomAccessFile, int i, byte[] bArr, int i2, File file, int i3) {
        if (randomAccessFile == null || i <= 0) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (i2 <= 0) {
            return 2;
        }
        int i4 = (i - i3) - 2;
        if (i4 <= 2) {
            return 3;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, 0, i2));
        dataInputStream.skip(8);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
        byteArrayInputStream.skip(32);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
        byteArrayInputStream.skip(32 + readLong);
        InputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
        byteArrayInputStream.skip((readLong + readLong2) + 32);
        InputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
        OutputStream fileOutputStream = new FileOutputStream(file);
        int[] iArr = new int[3];
        int i5 = 0;
        int i6 = 0;
        while (i6 < readLong3) {
            int i7;
            for (i7 = 0; i7 <= 2; i7++) {
                iArr[i7] = dataInputStream2.readInt();
            }
            if (iArr[0] + i6 > readLong3) {
                fileOutputStream.close();
                return 2;
            }
            byte[] bArr2 = new byte[iArr[0]];
            if (e.a(gZIPInputStream, bArr2, iArr[0])) {
                byte[] bArr3 = new byte[iArr[0]];
                if (randomAccessFile.read(bArr3, 0, iArr[0]) < iArr[0]) {
                    fileOutputStream.close();
                    return 2;
                }
                i7 = 0;
                while (i7 < iArr[0]) {
                    if (i5 + i7 == i4) {
                        bArr3[i7] = (byte) 0;
                        bArr3[i7 + 1] = (byte) 0;
                    }
                    if (i5 + i7 >= 0 && i5 + i7 < i) {
                        bArr2[i7] = (byte) (bArr2[i7] + bArr3[i7]);
                    }
                    i7++;
                }
                fileOutputStream.write(bArr2);
                i7 = iArr[0] + i6;
                i6 = iArr[0] + i5;
                if (iArr[1] + i7 > readLong3) {
                    fileOutputStream.close();
                    return 2;
                }
                byte[] bArr4 = new byte[iArr[1]];
                if (e.a(gZIPInputStream2, bArr4, iArr[1])) {
                    fileOutputStream.write(bArr4);
                    fileOutputStream.flush();
                    i7 += iArr[1];
                    i6 += iArr[2];
                    randomAccessFile.seek((long) i6);
                    i5 = i6;
                    i6 = i7;
                } else {
                    fileOutputStream.close();
                    return 2;
                }
            }
            fileOutputStream.close();
            return 2;
        }
        dataInputStream2.close();
        gZIPInputStream.close();
        gZIPInputStream2.close();
        randomAccessFile.close();
        fileOutputStream.close();
        return 1;
    }
}
