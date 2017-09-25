package com.tencent.mm.plugin.music.a.a;

import com.tencent.mm.plugin.music.a.d.a;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    private byte[] buffer = new byte[81920];
    public int hP = 0;
    public a nTA;
    public c nTB;
    public e nTC;
    public int wa = -1;

    public b(a aVar) {
        this.nTA = aVar;
    }

    public final boolean qe(int i) {
        return this.wa <= i && i <= this.wa + 81920;
    }

    public final boolean qf(int i) {
        return this.wa <= i && i <= this.wa + this.hP;
    }

    public final synchronized boolean aNY() {
        boolean z = false;
        synchronized (this) {
            if (this.wa < 0 || this.hP <= 0) {
                w.e("MicroMsg.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", new Object[]{Integer.valueOf(this.wa), Integer.valueOf(this.hP)});
            } else {
                int[] iArr;
                Object obj = new byte[this.hP];
                System.arraycopy(this.buffer, 0, obj, 0, this.hP);
                this.nTC.b(obj, (long) this.wa, this.hP);
                c cVar = this.nTB;
                int i = this.wa;
                int i2 = this.hP;
                if (i < 0 || i2 < 0 || ((long) i) > cVar.ilG || ((long) (i + i2)) > cVar.ilG) {
                    w.i("MicroMsg.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(cVar.ilG)});
                    w.e("MicroMsg.IndexBitMgr", "getWriteBuffRange invalid parameter!");
                    iArr = null;
                } else {
                    iArr = new int[]{-1, -1};
                    int i3 = i + i2;
                    int index = cVar.getIndex(i);
                    int index2 = cVar.getIndex(i3);
                    for (i2 = index; i2 <= index2; i2++) {
                        int i4 = (i2 + 1) * 8192;
                        if (i2 * 8192 >= i && i4 <= i3) {
                            if (iArr[0] == -1) {
                                iArr[0] = i2;
                            }
                            if (iArr[0] > i2) {
                                iArr[0] = i2;
                            }
                            if (iArr[1] == -1) {
                                iArr[1] = i2;
                            }
                            if (iArr[1] < i2) {
                                iArr[1] = i2;
                            }
                        }
                    }
                    if (iArr[0] == -1 && iArr[1] == -1 && ((long) i3) == cVar.ilG) {
                        w.i("MicroMsg.IndexBitMgr", "write to file end!");
                        iArr[0] = index;
                        iArr[1] = index2;
                    }
                }
                if (iArr == null) {
                    w.e("MicroMsg.FileBytesCacheMgr", "flushBufferAll, range is null");
                } else if (iArr[0] == -1 || iArr[1] == -1) {
                    w.d("MicroMsg.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                } else {
                    for (int i5 = iArr[0]; i5 <= iArr[1]; i5++) {
                        this.nTB.nTD.set(i5);
                    }
                    this.nTB.aNZ();
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void qg(int i) {
        this.wa = i;
        this.hP = 0;
    }

    public final synchronized void e(byte[] bArr, int i, int i2) {
        int i3 = i - this.wa;
        this.hP = i3 + i2;
        System.arraycopy(bArr, 0, this.buffer, i3, i2);
    }
}
