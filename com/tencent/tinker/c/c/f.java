package com.tencent.tinker.c.c;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class f implements Cloneable {
    int cIm = -1;
    public String name;
    long size = -1;
    String ubd;
    public long xfC = -1;
    public long xfD = -1;
    int xfE = -1;
    int xfF = -1;
    byte[] xfG;
    long xfH = -1;
    long xfI = -1;

    public f(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        String str2 = "Name";
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes.length > 65535) {
            throw new IllegalArgumentException(str2 + " too long: " + bytes.length);
        }
        this.name = str;
    }

    public f(f fVar) {
        this.name = fVar.name;
        this.ubd = fVar.ubd;
        this.cIm = fVar.cIm;
        this.size = fVar.size;
        this.xfD = fVar.xfD;
        this.xfC = fVar.xfC;
        this.xfE = fVar.xfE;
        this.xfF = fVar.xfF;
        this.xfG = fVar.xfG;
        this.xfH = fVar.xfH;
        this.xfI = fVar.xfI;
    }

    public f(f fVar, String str) {
        this.name = str;
        this.ubd = fVar.ubd;
        this.cIm = fVar.cIm;
        this.size = fVar.size;
        this.xfD = fVar.xfD;
        this.xfC = fVar.xfC;
        this.xfE = fVar.xfE;
        this.xfF = fVar.xfF;
        this.xfG = fVar.xfG;
        this.xfH = fVar.xfH;
        this.xfI = fVar.xfI;
    }

    f(byte[] bArr, InputStream inputStream, Charset charset) {
        e.b(inputStream, bArr, 0, 46);
        b a = c.a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int readInt = a.readInt();
        if (((long) readInt) != 33639248) {
            g.a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
        }
        a.seek(8);
        int readShort = a.readShort() & 65535;
        if ((readShort & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: " + readShort);
        }
        if ((readShort & 2048) != 0) {
            charset = Charset.forName("UTF-8");
        }
        this.xfE = a.readShort() & 65535;
        this.cIm = a.readShort() & 65535;
        this.xfF = a.readShort() & 65535;
        this.xfC = ((long) a.readInt()) & 4294967295L;
        this.xfD = ((long) a.readInt()) & 4294967295L;
        this.size = ((long) a.readInt()) & 4294967295L;
        readShort = a.readShort() & 65535;
        int readShort2 = a.readShort() & 65535;
        int readShort3 = a.readShort() & 65535;
        a.seek(42);
        this.xfH = ((long) a.readInt()) & 4294967295L;
        byte[] bArr2 = new byte[readShort];
        e.b(inputStream, bArr2, 0, bArr2.length);
        if (bF(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset);
        if (readShort2 > 0) {
            this.xfG = new byte[readShort2];
            e.b(inputStream, this.xfG, 0, readShort2);
        }
        if (readShort3 > 0) {
            bArr2 = new byte[readShort3];
            e.b(inputStream, bArr2, 0, readShort3);
            this.ubd = new String(bArr2, 0, bArr2.length, charset);
        }
    }

    private static boolean bF(byte[] bArr) {
        for (byte b : bArr) {
            if (b == (byte) 0) {
                return true;
            }
        }
        return false;
    }

    public final void setMethod(int i) {
        if (i == 0 || i == 8) {
            this.xfE = i;
            return;
        }
        throw new IllegalArgumentException("Bad method: " + i);
    }

    public final void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Bad size: " + j);
        }
        this.size = j;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.name);
        stringBuffer.append("\ncomment:" + this.ubd);
        stringBuffer.append("\ntime:" + this.cIm);
        stringBuffer.append("\nsize:" + this.size);
        stringBuffer.append("\ncompressedSize:" + this.xfD);
        stringBuffer.append("\ncrc:" + this.xfC);
        stringBuffer.append("\ncompressionMethod:" + this.xfE);
        stringBuffer.append("\nmodDate:" + this.xfF);
        stringBuffer.append("\nextra length:" + this.xfG.length);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.xfH);
        stringBuffer.append("\ndataOffset:" + this.xfI);
        return stringBuffer.toString();
    }

    public final Object clone() {
        try {
            f fVar = (f) super.clone();
            fVar.xfG = this.xfG != null ? (byte[]) this.xfG.clone() : null;
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final int hashCode() {
        return this.name.hashCode();
    }
}
