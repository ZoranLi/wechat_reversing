package com.tencent.tinker.c.c;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

public final class g implements Closeable {
    private final String filename;
    public String ubd;
    public final LinkedHashMap<String, f> xfJ;
    private File xfK;
    private RandomAccessFile xfL;

    class AnonymousClass1 implements Enumeration<f> {
        final /* synthetic */ Iterator xfM;
        final /* synthetic */ g xfN;

        public AnonymousClass1(g gVar, Iterator it) {
            this.xfN = gVar;
            this.xfM = it;
        }

        public final /* synthetic */ Object nextElement() {
            this.xfN.cgM();
            return (f) this.xfM.next();
        }

        public final boolean hasMoreElements() {
            this.xfN.cgM();
            return this.xfM.hasNext();
        }
    }

    public static class a extends InputStream {
        private long hHx;
        private final RandomAccessFile xfO;
        private long xfP;

        private a(RandomAccessFile randomAccessFile, long j, long j2) {
            this.xfO = randomAccessFile;
            this.hHx = j;
            this.xfP = j2;
        }

        public a(RandomAccessFile randomAccessFile, long j) {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public final int available() {
            return this.hHx < this.xfP ? 1 : 0;
        }

        public final int read() {
            return e.q(this);
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read;
            synchronized (this.xfO) {
                long j = this.xfP - this.hHx;
                if (((long) i2) > j) {
                    i2 = (int) j;
                }
                this.xfO.seek(this.hHx);
                read = this.xfO.read(bArr, i, i2);
                if (read > 0) {
                    this.hHx += (long) read;
                } else {
                    read = -1;
                }
            }
            return read;
        }

        public final long skip(long j) {
            if (j > this.xfP - this.hHx) {
                j = this.xfP - this.hHx;
            }
            this.hHx += j;
            return j;
        }
    }

    public g(File file) {
        this(file, (byte) 0);
    }

    public g(String str) {
        this(new File(str), (byte) 0);
    }

    private g(File file, byte b) {
        this.xfJ = new LinkedHashMap();
        this.filename = file.getPath();
        this.xfK = null;
        this.xfL = new RandomAccessFile(this.filename, "r");
        cgN();
    }

    static void a(String str, long j, String str2, long j2, String str3, int i) {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }

    public final void close() {
        RandomAccessFile randomAccessFile = this.xfL;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.xfL = null;
                randomAccessFile.close();
            }
            if (this.xfK != null) {
                this.xfK.delete();
                this.xfK = null;
            }
        }
    }

    public final void cgM() {
        if (this.xfL == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final f VL(String str) {
        cgM();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        f fVar = (f) this.xfJ.get(str);
        if (fVar == null) {
            return (f) this.xfJ.get(str + "/");
        }
        return fVar;
    }

    public final InputStream a(f fVar) {
        f VL = VL(fVar.name);
        if (VL == null) {
            return null;
        }
        InputStream aVar;
        RandomAccessFile randomAccessFile = this.xfL;
        synchronized (randomAccessFile) {
            aVar = new a(randomAccessFile, VL.xfH);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.filename, randomAccessFile.length(), VL.name, VL.xfH, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            dataInputStream.close();
            aVar.skip((long) (reverseBytes2 + reverseBytes3));
            if (VL.xfE == 0) {
                aVar.xfP = aVar.hHx + VL.size;
            } else {
                aVar.xfP = aVar.hHx + VL.xfD;
            }
        }
        return aVar;
    }

    private void cgN() {
        long j = 0;
        long length = this.xfL.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.xfL.length());
        }
        this.xfL.seek(0);
        if (((long) Integer.reverseBytes(this.xfL.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - 65536;
        if (j2 < 0) {
            j2 = length;
        } else {
            j = j2;
            j2 = length;
        }
        do {
            this.xfL.seek(j2);
            if (((long) Integer.reverseBytes(this.xfL.readInt())) != 101010256) {
                j2--;
            } else {
                byte[] bArr = new byte[18];
                this.xfL.readFully(bArr);
                b a = c.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int readShort = a.readShort() & 65535;
                int readShort2 = a.readShort() & 65535;
                int readShort3 = a.readShort() & 65535;
                int readShort4 = a.readShort() & 65535;
                a.cgL();
                long readInt = ((long) a.readInt()) & 4294967295L;
                int readShort5 = a.readShort() & 65535;
                if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                    if (readShort5 > 0) {
                        bArr = new byte[readShort5];
                        this.xfL.readFully(bArr);
                        this.ubd = new String(bArr, 0, bArr.length, d.UTF_8);
                    }
                    InputStream bufferedInputStream = new BufferedInputStream(new a(this.xfL, readInt), Downloads.RECV_BUFFER_SIZE);
                    byte[] bArr2 = new byte[46];
                    for (readShort5 = 0; readShort5 < readShort3; readShort5++) {
                        f fVar = new f(bArr2, bufferedInputStream, d.UTF_8);
                        if (fVar.xfH >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = fVar.name;
                        if (this.xfJ.put(str, fVar) != null) {
                            throw new ZipException("Duplicate entry name: " + str);
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
