package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c {
    public static boolean mD(String str) {
        Throwable e;
        if (mA(str)) {
            return false;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8];
                if (fileInputStream.read(bArr, 0, 8) < 8) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
                        return false;
                    }
                }
                int l = l(bArr, 0);
                if (l(bArr, 4) != a.ikc || l <= 0) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.AtomUtil", e22, "", new Object[0]);
                        return false;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e222) {
                    w.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e222 = e3;
                try {
                    w.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e2222) {
                        w.printErrStackTrace("MicroMsg.AtomUtil", e2222, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e2222 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            w.printErrStackTrace("MicroMsg.AtomUtil", e4, "", new Object[0]);
                        }
                    }
                    throw e2222;
                }
            }
        } catch (Exception e5) {
            e2222 = e5;
            fileInputStream = null;
            w.printErrStackTrace("MicroMsg.AtomUtil", e2222, "", new Object[0]);
            if (fileInputStream != null) {
                return false;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th2) {
            e2222 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e2222;
        }
    }

    public static boolean mA(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int mE(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i2 = (i2 << 8) | str.charAt(i);
            i++;
        }
        return i2;
    }

    public static int l(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((((bArr[i2] & 255) << 16) | ((bArr[i] & 255) << 24)) | ((bArr[i3] & 255) << 8)) | (bArr[i3 + 1] & 255);
    }

    public static long m(byte[] bArr, int i) {
        Object obj = new byte[8];
        Arrays.fill(obj, (byte) 0);
        System.arraycopy(bArr, i, obj, 4, 4);
        return I(obj);
    }

    public static long I(byte[] bArr) {
        return ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
    }

    public static a a(RandomAccessFile randomAccessFile, byte[] bArr, int i) {
        try {
            int read = randomAccessFile.read(bArr);
            while (read >= 8) {
                int l = l(bArr, 0);
                int l2 = l(bArr, 4);
                if (l2 != i) {
                    if (l2 != a.ikA && l2 != a.ikE) {
                        if (!a(randomAccessFile, (long) (l - 8))) {
                            break;
                        }
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                } else {
                    long filePointer = randomAccessFile.getFilePointer() - ((long) read);
                    if (l2 == a.ikC) {
                        return new i(l, filePointer, l2, 0);
                    }
                    if (l2 == a.ikD) {
                        return new e(l, filePointer, l2, 0);
                    }
                    return l2 == a.ikF ? new h(l, filePointer, l2, 0) : new a(l, filePointer, l2, 0);
                }
            }
            return null;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AtomUtil", e, "", new Object[0]);
            w.e("MicroMsg.AtomUtil", "find Atom error: " + e.toString());
            return null;
        }
    }

    public static boolean a(RandomAccessFile randomAccessFile, long j) {
        long j2 = 0;
        while (j > 2147483647L) {
            j2 += (long) randomAccessFile.skipBytes(Integer.MAX_VALUE);
            j -= 2147483647L;
        }
        j2 += (long) randomAccessFile.skipBytes((int) j);
        if (j2 == j) {
            return true;
        }
        w.w("MicroMsg.AtomUtil", "can not skip.skip: " + j + " trueSkip : " + j2);
        return false;
    }
}
