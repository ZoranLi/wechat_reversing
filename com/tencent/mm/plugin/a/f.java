package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

public final class f {
    private long duration;
    private String filePath;
    private long ilY;
    private long imb;
    private long[] imc;
    public int imd;
    private List<g> ime;
    private List<Pair> imf;

    public final boolean a(int i, int i2, PInt pInt, PInt pInt2) {
        if (this.imc == null) {
            return false;
        }
        if (i < 0) {
            i = 0;
        }
        int length = this.imc.length;
        if (i >= length || i2 >= length) {
            i = length - 2;
            i2 = length - 1;
        }
        long j = this.imc[i];
        long j2 = this.imc[i2];
        if (i == 0) {
            pInt.value = 0;
            pInt2.value = (int) j2;
        } else {
            pInt.value = (int) j;
            pInt2.value = ((int) j2) - ((int) j);
        }
        return true;
    }

    public final int bi(int i, int i2) {
        int i3 = 0;
        if (this.imc == null) {
            return 0;
        }
        long j = (long) (i + i2);
        int i4 = 0;
        while (i3 < this.imc.length) {
            if (this.imc[i3] == j) {
                i4 = i3;
                break;
            }
            if (this.imc[i3] >= j) {
                if (this.imc[i3] > j) {
                    break;
                }
            } else {
                i4 = i3;
            }
            i3++;
        }
        return i4;
    }

    public final boolean m(String str, long j) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        RandomAccessFile randomAccessFile2;
        this.filePath = null;
        this.imc = null;
        this.imd = 0;
        this.duration = 0;
        this.ilY = 0;
        this.imb = 0;
        this.filePath = str;
        this.imb = j;
        File file = new File(this.filePath);
        if (!file.exists()) {
            return false;
        }
        try {
            byte[] bArr = new byte[8];
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                a a = a(randomAccessFile, bArr, this.imb);
                while (a != null) {
                    w.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + a.ilD);
                    e b = i.b(randomAccessFile, bArr);
                    if (b == null || !b.a(randomAccessFile, bArr)) {
                        w.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
                        a = null;
                    } else {
                        int i;
                        if (b.ilZ == ((long) e.ilV)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            long NF = a.NF() - randomAccessFile.getFilePointer();
                            w.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: " + NF);
                            a = a(randomAccessFile, bArr, NF);
                        } else {
                            this.ilY = b.ilY;
                            this.duration = b.duration;
                            w.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.ilY + " duration: " + this.duration);
                            randomAccessFile.seek(b.ima);
                            h hVar = (h) c.a(randomAccessFile, bArr, a.ikF);
                            if (hVar != null) {
                                hVar.duration = this.duration;
                                hVar.ilY = this.ilY;
                                hVar.b(randomAccessFile);
                                this.imc = hVar.imc;
                                this.imd = this.imc.length - 2;
                                this.ime = hVar.ime;
                                this.imf = hVar.imf;
                            }
                        }
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                randomAccessFile2 = randomAccessFile;
            } catch (Throwable th) {
                e2 = th;
            }
        } catch (Exception e4) {
            e2 = e4;
            randomAccessFile2 = null;
            try {
                w.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                w.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e2.toString());
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.Mp4Parser", e22, "", new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e5) {
                        w.printErrStackTrace("MicroMsg.Mp4Parser", e5, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th3) {
            e22 = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e22;
        }
    }

    private static i a(RandomAccessFile randomAccessFile, byte[] bArr, long j) {
        w.d("MicroMsg.Mp4Parser", "start to find trak atom.");
        if (c.a(randomAccessFile, j)) {
            return (i) c.a(randomAccessFile, bArr, a.ikC);
        }
        return null;
    }
}
