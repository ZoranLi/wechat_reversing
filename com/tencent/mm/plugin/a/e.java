package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.w;
import java.io.RandomAccessFile;

public final class e extends a {
    public static final int ilV = c.mE("vide");
    public static final int ilW = c.mE("soun");
    public static final int ilX = c.mE("hint");
    long duration = 0;
    long ilY = 0;
    long ilZ = 0;
    long ima = 0;

    public e(int i, long j, int i2, long j2) {
        super(i, j, i2, 0);
    }

    public final boolean a(RandomAccessFile randomAccessFile, byte[] bArr) {
        Object obj;
        Object obj2 = null;
        Object obj3 = null;
        int read = randomAccessFile.read(bArr);
        Object obj4 = null;
        while (read >= 8) {
            long j;
            int l = c.l(bArr, 0);
            int l2 = c.l(bArr, 4);
            int i;
            if (l2 == a.ikP) {
                byte[] bArr2 = new byte[4];
                l2 = randomAccessFile.read(bArr2);
                if (l2 < 4) {
                    l2 = -1;
                } else {
                    l2 += 0;
                    if (bArr2[0] == (byte) 0) {
                        if (c.a(randomAccessFile, 8)) {
                            i = l2 + 8;
                            l2 = randomAccessFile.read(bArr);
                            if (l2 < 8) {
                                l2 = -1;
                            } else {
                                i += l2;
                                this.ilY = c.m(bArr, 0);
                                this.duration = c.m(bArr, 4);
                            }
                        } else {
                            l2 = -1;
                        }
                    } else if (c.a(randomAccessFile, 16)) {
                        l2 += 16;
                        int read2 = randomAccessFile.read(bArr2);
                        if (read2 < 4) {
                            l2 = -1;
                        } else {
                            l2 += read2;
                            this.ilY = c.m(bArr2, 0);
                            i = randomAccessFile.read(bArr);
                            if (i < 8) {
                                l2 = -1;
                            } else {
                                i += l2;
                                this.duration = c.I(bArr);
                            }
                        }
                    } else {
                        l2 = -1;
                    }
                    l2 = i;
                }
                if (l2 <= 0) {
                    w.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
                    return false;
                }
                j = (long) ((l - read) - l2);
                obj = obj3;
                obj3 = obj2;
                obj2 = 1;
                obj4 = obj;
            } else if (l2 == a.ikQ) {
                int read3;
                if (c.a(randomAccessFile, 8)) {
                    read3 = randomAccessFile.read(bArr, 0, 4);
                    if (read3 < 4) {
                        read3 = -1;
                    } else {
                        this.ilZ = (long) c.l(bArr, 0);
                        read3 += 8;
                    }
                } else {
                    read3 = -1;
                }
                if (read3 <= 0) {
                    w.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
                    return false;
                }
                long j2 = (long) ((l - read) - read3);
                obj2 = obj4;
                obj4 = obj3;
                int i2 = 1;
                j = j2;
            } else if (l2 == a.ikE) {
                this.ima = randomAccessFile.getFilePointer() - ((long) read);
                j = (long) (l - read);
                obj3 = obj2;
                obj2 = obj4;
                i = 1;
            } else {
                j = (long) (l - 8);
                obj = obj3;
                obj3 = obj2;
                obj2 = obj4;
                obj4 = obj;
            }
            if (obj2 != null && obj3 != null && obj4 != null) {
                break;
            } else if (!c.a(randomAccessFile, j)) {
                return false;
            } else {
                read = randomAccessFile.read(bArr);
                obj = obj4;
                obj4 = obj2;
                obj2 = obj3;
                obj3 = obj;
            }
        }
        obj = obj3;
        obj3 = obj2;
        obj2 = obj4;
        obj4 = obj;
        return (obj2 == null || obj3 == null || obj4 == null) ? false : true;
    }
}
