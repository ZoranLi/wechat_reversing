package com.tencent.tinker.c.c;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class h extends FilterOutputStream {
    public static final byte[] xfQ = new byte[0];
    private static final byte[] xfR = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private long hHx;
    private final HashSet<String> xfS;
    private final boolean xfT;
    public byte[] xfU;
    private int xfV;
    private ByteArrayOutputStream xfW;
    private f xfX;
    private byte[] xfY;
    private byte[] xfZ;
    private boolean xga;

    public h(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private h(OutputStream outputStream, byte b) {
        super(outputStream);
        this.xfS = new HashSet();
        this.xfU = xfQ;
        this.xfV = 8;
        this.xfW = new ByteArrayOutputStream();
        this.hHx = 0;
        this.xfT = false;
    }

    private static long a(OutputStream outputStream, long j) {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private static int b(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public final void close() {
        if (this.out == null) {
            return;
        }
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.xfW != null) {
            if (this.xfS.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.xfX != null) {
                closeEntry();
            }
            int size = this.xfW.size();
            a(this.xfW, 101010256);
            b(this.xfW, 0);
            b(this.xfW, 0);
            if (this.xga) {
                b(this.xfW, 65535);
                b(this.xfW, 65535);
                a(this.xfW, -1);
                a(this.xfW, -1);
            } else {
                b(this.xfW, this.xfS.size());
                b(this.xfW, this.xfS.size());
                a(this.xfW, (long) size);
                a(this.xfW, this.hHx);
            }
            b(this.xfW, this.xfU.length);
            if (this.xfU.length > 0) {
                this.xfW.write(this.xfU);
            }
            this.xfW.writeTo(this.out);
            this.xfW = null;
        }
        this.out.close();
        this.out = null;
    }

    public final void closeEntry() {
        cgO();
        if (this.xfX != null) {
            long j = 30;
            if (this.xfX.xfE != 0) {
                j = 46;
                a(this.out, 134695760);
                a(this.out, this.xfX.xfC);
                a(this.out, this.xfX.xfD);
                a(this.out, this.xfX.size);
            }
            int i = (this.xfX.xfE == 0 ? 0 : 8) | 2048;
            a(this.xfW, 33639248);
            b(this.xfW, 20);
            b(this.xfW, 20);
            b(this.xfW, i);
            b(this.xfW, this.xfX.xfE);
            b(this.xfW, this.xfX.cIm);
            b(this.xfW, this.xfX.xfF);
            a(this.xfW, this.xfX.xfC);
            if (this.xfX.xfE == 8) {
                j += this.xfX.xfD;
            } else {
                j += this.xfX.size;
            }
            a(this.xfW, this.xfX.xfD);
            a(this.xfW, this.xfX.size);
            j += (long) b(this.xfW, this.xfY.length);
            if (this.xfX.xfG != null) {
                j += (long) b(this.xfW, this.xfX.xfG.length);
            } else {
                b(this.xfW, 0);
            }
            b(this.xfW, this.xfZ.length);
            b(this.xfW, 0);
            b(this.xfW, 0);
            a(this.xfW, 0);
            a(this.xfW, this.xfX.xfH);
            this.xfW.write(this.xfY);
            this.xfY = null;
            if (this.xfX.xfG != null) {
                this.xfW.write(this.xfX.xfG);
            }
            this.hHx = j + this.hHx;
            if (this.xfZ.length > 0) {
                this.xfW.write(this.xfZ);
                this.xfZ = xfQ;
            }
            this.xfX = null;
        }
    }

    public final void b(f fVar) {
        int i;
        if (this.xfX != null) {
            closeEntry();
        }
        int i2 = fVar.xfE;
        if (i2 == -1) {
            i = this.xfV;
        } else {
            i = i2;
        }
        if (i == 0) {
            if (fVar.xfD == -1) {
                fVar.xfD = fVar.size;
            } else if (fVar.size == -1) {
                fVar.setSize(fVar.xfD);
            }
            if (fVar.xfC == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (fVar.size == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (fVar.size != fVar.xfD) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        cgO();
        fVar.ubd = null;
        fVar.xfG = null;
        fVar.cIm = 40691;
        fVar.xfF = 18698;
        this.xfY = fVar.name.getBytes(d.UTF_8);
        y("Name", this.xfY);
        this.xfZ = xfQ;
        if (fVar.ubd != null) {
            this.xfZ = fVar.ubd.getBytes(d.UTF_8);
            y("Comment", this.xfZ);
        }
        fVar.setMethod(i);
        this.xfX = fVar;
        this.xfX.xfH = this.hHx;
        this.xfS.add(this.xfX.name);
        i2 = (i == 0 ? 0 : 8) | 2048;
        a(this.out, 67324752);
        b(this.out, 20);
        b(this.out, i2);
        b(this.out, i);
        b(this.out, this.xfX.cIm);
        b(this.out, this.xfX.xfF);
        if (i == 0) {
            a(this.out, this.xfX.xfC);
            a(this.out, this.xfX.size);
            a(this.out, this.xfX.size);
        } else {
            a(this.out, 0);
            a(this.out, 0);
            a(this.out, 0);
        }
        b(this.out, this.xfY.length);
        if (this.xfX.xfG != null) {
            b(this.out, this.xfX.xfG.length);
        } else {
            b(this.out, 0);
        }
        this.out.write(this.xfY);
        if (this.xfX.xfG != null) {
            this.out.write(this.xfX.xfG);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        a.ab(bArr.length, i, i2);
        if (this.xfX == null) {
            throw new ZipException("No active entry");
        }
        this.out.write(bArr, i, i2);
    }

    private void cgO() {
        if (this.xfW == null) {
            throw new IOException("Stream is closed");
        }
    }

    public static void y(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
