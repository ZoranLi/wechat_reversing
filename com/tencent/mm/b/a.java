package com.tencent.mm.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class a {
    public a fuR;
    public b fuS = null;

    public static class a {
        static final long fuT = ((long) "Micromsg".hashCode());
        public int fuU = 0;

        public a(int i) {
            this.fuU = i;
        }

        public static a r(byte[] bArr) {
            if (bArr.length == 8) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    j |= ((long) (bArr[i] & 255)) << (i * 8);
                }
                if ((j >> 32) == fuT) {
                    return new a((int) j);
                }
            }
            return null;
        }

        static byte[] q(long j) {
            byte[] bArr = new byte[8];
            for (int i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
            }
            return bArr;
        }
    }

    public a(b bVar) {
        this.fuS = bVar;
    }

    public final int g(File file) {
        try {
            if (aZ(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                return -1;
            }
            byte[] toByteArray = this.fuS.toByteArray();
            byte[] q = a.q((a.fuT << 32) | ((long) new a(toByteArray.length).fuU));
            byte[] bArr = new byte[]{(byte) ((toByteArray.length + 8) % 256), (byte) ((toByteArray.length + 8) / 256)};
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length() - 2);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(toByteArray);
            fileOutputStream.write(q);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public static a aZ(String str) {
        int i = 0;
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    i = (int) file.length();
                }
            } catch (Exception e) {
                return null;
            }
        }
        if (i < 8) {
            return null;
        }
        a r = a.r(d(str, i - 8, 8));
        if (r == null || r.fuU < 0) {
            return null;
        }
        b bVar = new b();
        bVar.aD(d(str, (i - r.fuU) - 8, r.fuU));
        a aVar = new a(bVar);
        aVar.fuR = r;
        return aVar;
    }

    public static boolean ba(String str) {
        boolean z = false;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                a aZ = aZ(str);
                if (!(aZ == null || aZ.fuS == null)) {
                    try {
                        byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                        File file2 = new File(str);
                        if (file2.exists()) {
                            z = aZ.fuS.apkMd5.equalsIgnoreCase(g.a(file2, (int) ((file.length() - ((long) (aZ.fuR.fuU + 8))) - 2), bArr));
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return z;
    }

    private static byte[] d(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length;
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            byte[] bArr = new byte[length];
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (Exception e) {
                return bArr;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
