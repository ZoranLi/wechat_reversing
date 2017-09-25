package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public final class h extends a {
    long duration;
    long ilY;
    long[] imc;
    List<g> ime = new LinkedList();
    List<Pair> imf = new LinkedList();
    long imi;
    private long imj;
    private long imk;
    private long iml;
    private long imm;
    private int[] imn;
    private int[] imo;
    private int[] imp;
    private long[] imq;
    private int[] imr;
    private int[] ims;
    private int[] imt;

    public h(int i, long j, int i2, long j2) {
        super(i, j, i2, 0);
    }

    public final void b(RandomAccessFile randomAccessFile) {
        byte[] bArr = new byte[8];
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        int read = randomAccessFile.read(bArr);
        while (read >= 8) {
            Object obj6;
            Object obj7;
            Object obj8;
            int l = c.l(bArr, 0);
            int l2 = c.l(bArr, 4);
            long j = 0;
            int i;
            int i2;
            int i3;
            Object obj9;
            if (l2 == a.ili) {
                this.imi = randomAccessFile.getFilePointer();
                if (c.a(randomAccessFile, 4)) {
                    byte[] bArr2 = new byte[8];
                    if (randomAccessFile.read(bArr2, 0, 4) < 4) {
                        w.w("MicroMsg.StblAtom", "stts read entry count error");
                        j = -1;
                    } else {
                        int l3 = c.l(bArr2, 0);
                        long j2 = ((long) l3) * 8;
                        if (j2 > ((long) (l - 16)) || j2 <= 0) {
                            w.w("MicroMsg.StblAtom", "stts error entryCount : " + l3);
                            j = -1;
                        } else {
                            int i4 = 0;
                            i = 0;
                            this.imc = new long[(((int) (this.duration / this.ilY)) + 2)];
                            i2 = 1;
                            this.imc[0] = 1;
                            j = 0;
                            l2 = randomAccessFile.read(bArr2);
                            while (l2 >= 8) {
                                long j3 = ((long) l2) + j;
                                int l4 = c.l(bArr2, 0);
                                int l5 = c.l(bArr2, 4);
                                int i5 = i4;
                                int i6 = i2;
                                i2 = i;
                                i = 0;
                                l3 = i6;
                                while (i < l4) {
                                    g gVar = new g();
                                    gVar.img = (long) l5;
                                    this.ime.add(gVar);
                                    i5 += l5;
                                    i4 = i2 + 1;
                                    while (((long) i5) >= this.ilY && l3 < this.imc.length) {
                                        i5 = (int) (((long) i5) - this.ilY);
                                        this.imc[l3] = (long) i4;
                                        l3++;
                                    }
                                    i++;
                                    i2 = i4;
                                }
                                if (j3 >= j2) {
                                    w.d("MicroMsg.StblAtom", "read stts Atom end");
                                    long j4 = j3;
                                    l2 = l3;
                                    i3 = i2;
                                    j = j4;
                                    break;
                                }
                                i4 = i5;
                                i = i2;
                                i2 = l3;
                                j = j3;
                                l2 = randomAccessFile.read(bArr2);
                            }
                            l2 = i2;
                            i3 = i;
                            if (l2 < this.imc.length) {
                                this.imc[l2] = (long) i3;
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj = obj4;
                obj6 = obj3;
                obj7 = obj2;
                obj9 = obj5;
                obj5 = 1;
                obj8 = obj9;
            } else if (l2 == a.ill) {
                j = a(randomAccessFile, l);
                i2 = 1;
                obj7 = obj2;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (l2 == a.iln) {
                j = b(randomAccessFile, l);
                obj6 = obj3;
                i = 1;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (l2 == a.ilo) {
                j = c(randomAccessFile, l);
                obj6 = obj3;
                i = 1;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (l2 == a.ilm) {
                j = d(randomAccessFile, l);
                obj6 = obj3;
                obj7 = obj2;
                obj9 = obj5;
                obj5 = obj;
                i3 = 1;
                obj8 = obj9;
            } else if (l2 == a.ilj) {
                j = e(randomAccessFile, l);
                obj8 = 1;
                obj6 = obj3;
                obj7 = obj2;
                obj5 = obj;
                obj = obj4;
            } else {
                obj8 = obj5;
                obj6 = obj3;
                obj7 = obj2;
                obj5 = obj;
                obj = obj4;
            }
            if (c.a(randomAccessFile, (((long) l) - j) - ((long) read))) {
                if (obj5 != null && obj7 != null && obj6 != null && obj != null && obj8 != null) {
                    w.i("MicroMsg.StblAtom", "read stbl atom finish");
                    break;
                }
                obj4 = obj;
                obj3 = obj6;
                obj2 = obj7;
                read = randomAccessFile.read(bArr);
                obj = obj5;
                obj5 = obj8;
            } else {
                throw new IOException("skip file error.");
            }
        }
        NG();
    }

    private long a(RandomAccessFile randomAccessFile, int i) {
        this.imj = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[12];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            w.w("MicroMsg.StblAtom", "stsc read entry count error");
            return -1;
        }
        int l = c.l(bArr, 0);
        long j = 12 * ((long) l);
        if (j > ((long) (i - 16)) || j <= 0) {
            w.w("MicroMsg.StblAtom", "stsc error entryCount : " + l);
            return -1;
        }
        w.d("MicroMsg.StblAtom", "handle stsc entryCount : " + l);
        this.imn = new int[l];
        this.imo = new int[l];
        int i2 = 0;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 12) {
            j2 += (long) read;
            this.imn[i2] = c.l(bArr, 0);
            this.imo[i2] = c.l(bArr, 4);
            i2++;
            if (j2 >= j) {
                w.d("MicroMsg.StblAtom", "read stsc atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
        }
        return j2 + 8;
    }

    private long b(RandomAccessFile randomAccessFile, int i) {
        this.imk = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            w.w("MicroMsg.StblAtom", "stco read entry count error");
            return -1;
        }
        int l = c.l(bArr, 0);
        long j = 4 * ((long) l);
        if (j <= 0 || j > ((long) (i - 16))) {
            w.w("MicroMsg.StblAtom", "stco error entryCount : " + l);
            return -1;
        }
        this.imp = new int[(l + 1)];
        int i2 = 1;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 4) {
            j2 += (long) read;
            int i3 = i2 + 1;
            this.imp[i2] = c.l(bArr, 0);
            if (j2 >= j) {
                w.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private long c(RandomAccessFile randomAccessFile, int i) {
        this.iml = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            w.w("MicroMsg.StblAtom", "co64 read entry count error");
            return -1;
        }
        int l = c.l(bArr, 0);
        long j = ((long) l) * 8;
        if (j <= 0 || j > ((long) (i - 16))) {
            w.w("MicroMsg.StblAtom", "stco error entryCount : " + l);
            return -1;
        }
        this.imq = new long[(l + 1)];
        int read = randomAccessFile.read(bArr);
        int i2 = 1;
        long j2 = 0;
        while (read >= 8) {
            j2 += (long) read;
            l = i2 + 1;
            this.imq[i2] = c.I(bArr);
            if (j2 >= j) {
                w.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = l;
        }
        return j2 + 8;
    }

    private long d(RandomAccessFile randomAccessFile, int i) {
        this.imm = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            w.w("MicroMsg.StblAtom", "stsz read sample size error");
            return -1;
        }
        int l = c.l(bArr, 0);
        if (l > 0) {
            this.imr = new int[1];
            this.imr[0] = l;
            w.i("MicroMsg.StblAtom", "all sample size is the same. size : " + l);
            return 8;
        } else if (randomAccessFile.read(bArr, 0, 4) < 4) {
            w.w("MicroMsg.StblAtom", "stsz read entry count error");
            return -1;
        } else {
            l = c.l(bArr, 0);
            long j = 4 * ((long) l);
            if (j <= 0 || j > ((long) (i - 20))) {
                w.w("MicroMsg.StblAtom", "stco error entryCount : " + l);
                return -1;
            }
            this.imr = new int[(l + 1)];
            int i2 = 1;
            int read = randomAccessFile.read(bArr);
            long j2 = 0;
            while (read >= 4) {
                j2 += (long) read;
                int i3 = i2 + 1;
                this.imr[i2] = c.l(bArr, 0);
                if (j2 >= j) {
                    w.d("MicroMsg.StblAtom", "read stsz atom end");
                    break;
                }
                read = randomAccessFile.read(bArr);
                i2 = i3;
            }
            return j2 + 12;
        }
    }

    private long e(RandomAccessFile randomAccessFile, int i) {
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            w.w("MicroMsg.StblAtom", "stss rread entry count error");
            return -1;
        }
        int l = c.l(bArr, 0);
        long j = 4 * ((long) l);
        if (j <= 0 || j > ((long) (i - 16))) {
            w.w("MicroMsg.StblAtom", "stss error entryCount : " + l);
            return -1;
        }
        this.ims = new int[l];
        int i2 = 0;
        int read = randomAccessFile.read(bArr);
        long j2 = 0;
        while (read >= 4) {
            j2 += (long) read;
            int i3 = i2 + 1;
            this.ims[i2] = c.l(bArr, 0);
            if (j2 >= j) {
                w.d("MicroMsg.StblAtom", "read stss atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private boolean NG() {
        int i;
        int i2;
        int i3;
        long j = 0;
        int i4 = 0;
        int length = (this.imp != null ? this.imp.length : this.imq.length) - 1;
        int length2 = this.imn.length;
        for (i = 1; i < length2; i++) {
            this.imn[i - 1] = this.imn[i] - this.imn[i - 1];
        }
        this.imn[length2 - 1] = (length - this.imn[length2 - 1]) + 1;
        this.imt = new int[(length + 1)];
        this.imt[0] = 0;
        i = 1;
        for (i2 = 0; i2 < length2; i2++) {
            int i5 = this.imn[i2];
            i3 = this.imo[i2];
            for (length = 0; length < i5; length++) {
                this.imt[i] = this.imt[i - 1] + i3;
                i++;
            }
        }
        for (i2 = 0; i2 < this.imc.length; i2++) {
            long j2;
            i5 = (int) this.imc[i2];
            i3 = hd(i5);
            i = this.imt[i3 - 1] + 1;
            if (this.imr.length == 1) {
                j2 = (long) ((i5 - i) * this.imr[0]);
            } else {
                j2 = 0;
                for (length2 = i; length2 < i5; length2++) {
                    j2 += (long) this.imr[length2];
                }
            }
            this.imc[i2] = j2 + he(i3);
        }
        long j3 = 0;
        length = 0;
        i3 = 1;
        for (g gVar : this.ime) {
            g gVar2;
            gVar2.size = this.imr[i3];
            i2 = hd(i3);
            if (i2 != length) {
                gVar2.start = he(i2);
            } else {
                gVar2.start = j;
            }
            j = gVar2.start + ((long) gVar2.size);
            j3 += gVar2.img;
            gVar2.img = (long) ((((((float) j3) * 1.0f) / ((float) this.ilY)) * 1000.0f) * 1000.0f);
            gVar2.id = i3;
            length = i2;
            i3++;
        }
        while (i4 < this.ims.length) {
            gVar2 = (g) this.ime.get(this.ims[i4] - 1);
            gVar2.imh = 1;
            this.imf.add(new Pair(Integer.valueOf(this.ims[i4] - 1), Long.valueOf(gVar2.img)));
            i4++;
        }
        return true;
    }

    private int hd(int i) {
        for (int i2 = 0; i2 < this.imt.length; i2++) {
            if (i <= this.imt[i2]) {
                return i2;
            }
        }
        return 0;
    }

    private long he(int i) {
        if (this.imp != null) {
            return (long) this.imp[i];
        }
        if (this.imq != null) {
            return this.imq[i];
        }
        return 0;
    }
}
