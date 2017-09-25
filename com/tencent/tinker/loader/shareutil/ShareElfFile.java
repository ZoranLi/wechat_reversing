package com.tencent.tinker.loader.shareutil;

import com.tencent.wcdb.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile implements Closeable {
    private final FileInputStream jHF;
    private final Map<String, SectionHeader> xhJ = new HashMap();
    public ElfHeader xhK = null;
    public ProgramHeader[] xhL = null;
    public SectionHeader[] xhM = null;

    public static class ElfHeader {
        public final byte[] xhN = new byte[16];
        public final short xhO;
        public final short xhP;
        public final int xhQ;
        public final long xhR;
        public final long xhS;
        public final long xhT;
        public final int xhU;
        public final short xhV;
        public final short xhW;
        public final short xhX;
        public final short xhY;
        public final short xhZ;
        public final short xia;

        public ElfHeader(FileChannel fileChannel) {
            fileChannel.position(0);
            fileChannel.read(ByteBuffer.wrap(this.xhN));
            if (this.xhN[0] == Byte.MAX_VALUE && this.xhN[1] == (byte) 69 && this.xhN[2] == (byte) 76 && this.xhN[3] == (byte) 70) {
                ShareElfFile.x(this.xhN[4], 2, "bad elf class: " + this.xhN[4]);
                ShareElfFile.x(this.xhN[5], 2, "bad elf data encoding: " + this.xhN[5]);
                ByteBuffer allocate = ByteBuffer.allocate(this.xhN[4] == (byte) 1 ? 36 : 48);
                allocate.order(this.xhN[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                ShareElfFile.a(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.xhO = allocate.getShort();
                this.xhP = allocate.getShort();
                this.xhQ = allocate.getInt();
                ShareElfFile.x(this.xhQ, 1, "bad elf version: " + this.xhQ);
                switch (this.xhN[4]) {
                    case (byte) 1:
                        this.xhR = (long) allocate.getInt();
                        this.xhS = (long) allocate.getInt();
                        this.xhT = (long) allocate.getInt();
                        break;
                    case (byte) 2:
                        this.xhR = allocate.getLong();
                        this.xhS = allocate.getLong();
                        this.xhT = allocate.getLong();
                        break;
                    default:
                        throw new IOException("Unexpected elf class: " + this.xhN[4]);
                }
                this.xhU = allocate.getInt();
                this.xhV = allocate.getShort();
                this.xhW = allocate.getShort();
                this.xhX = allocate.getShort();
                this.xhY = allocate.getShort();
                this.xhZ = allocate.getShort();
                this.xia = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(this.xhN[0]), Byte.valueOf(this.xhN[1]), Byte.valueOf(this.xhN[2]), Byte.valueOf(this.xhN[3])}));
        }
    }

    public static class ProgramHeader {
        public final int xib;
        public final int xic;
        public final long xid;
        public final long xie;
        public final long xif;
        public final long xig;
        public final long xih;
        public final long xii;

        public ProgramHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.xib = byteBuffer.getInt();
                    this.xid = (long) byteBuffer.getInt();
                    this.xie = (long) byteBuffer.getInt();
                    this.xif = (long) byteBuffer.getInt();
                    this.xig = (long) byteBuffer.getInt();
                    this.xih = (long) byteBuffer.getInt();
                    this.xic = byteBuffer.getInt();
                    this.xii = (long) byteBuffer.getInt();
                    return;
                case 2:
                    this.xib = byteBuffer.getInt();
                    this.xic = byteBuffer.getInt();
                    this.xid = byteBuffer.getLong();
                    this.xie = byteBuffer.getLong();
                    this.xif = byteBuffer.getLong();
                    this.xig = byteBuffer.getLong();
                    this.xih = byteBuffer.getLong();
                    this.xii = byteBuffer.getLong();
                    return;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
        }
    }

    public static class SectionHeader {
        public final int xij;
        public final int xik;
        public final long xil;
        public final long xim;
        public final long xin;
        public final long xio;
        public final int xip;
        public final int xiq;
        public final long xir;
        public final long xis;
        public String xit;

        public SectionHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.xij = byteBuffer.getInt();
                    this.xik = byteBuffer.getInt();
                    this.xil = (long) byteBuffer.getInt();
                    this.xim = (long) byteBuffer.getInt();
                    this.xin = (long) byteBuffer.getInt();
                    this.xio = (long) byteBuffer.getInt();
                    this.xip = byteBuffer.getInt();
                    this.xiq = byteBuffer.getInt();
                    this.xir = (long) byteBuffer.getInt();
                    this.xis = (long) byteBuffer.getInt();
                    break;
                case 2:
                    this.xij = byteBuffer.getInt();
                    this.xik = byteBuffer.getInt();
                    this.xil = byteBuffer.getLong();
                    this.xim = byteBuffer.getLong();
                    this.xin = byteBuffer.getLong();
                    this.xio = byteBuffer.getLong();
                    this.xip = byteBuffer.getInt();
                    this.xiq = byteBuffer.getInt();
                    this.xir = byteBuffer.getLong();
                    this.xis = byteBuffer.getLong();
                    break;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
            this.xit = null;
        }
    }

    public ShareElfFile(File file) {
        int i;
        int i2 = 0;
        this.jHF = new FileInputStream(file);
        FileChannel channel = this.jHF.getChannel();
        this.xhK = new ElfHeader(channel);
        ByteBuffer allocate = ByteBuffer.allocate(FileUtils.S_IWUSR);
        allocate.limit(this.xhK.xhW);
        allocate.order(this.xhK.xhN[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.xhK.xhS);
        this.xhL = new ProgramHeader[this.xhK.xhX];
        for (i = 0; i < this.xhL.length; i++) {
            a(channel, allocate, "failed to read phdr.");
            this.xhL[i] = new ProgramHeader(allocate, this.xhK.xhN[4]);
        }
        channel.position(this.xhK.xhT);
        allocate.limit(this.xhK.xhY);
        this.xhM = new SectionHeader[this.xhK.xhZ];
        for (i = 0; i < this.xhM.length; i++) {
            a(channel, allocate, "failed to read shdr.");
            this.xhM[i] = new SectionHeader(allocate, this.xhK.xhN[4]);
        }
        if (this.xhK.xia > (short) 0) {
            SectionHeader sectionHeader = this.xhM[this.xhK.xia];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) sectionHeader.xio);
            this.jHF.getChannel().position(sectionHeader.xin);
            a(this.jHF.getChannel(), allocate2, "failed to read section: " + sectionHeader.xit);
            SectionHeader[] sectionHeaderArr = this.xhM;
            int length = sectionHeaderArr.length;
            while (i2 < length) {
                SectionHeader sectionHeader2 = sectionHeaderArr[i2];
                allocate2.position(sectionHeader2.xij);
                sectionHeader2.xit = o(allocate2);
                this.xhJ.put(sectionHeader2.xit, sectionHeader2);
                i2++;
            }
        }
    }

    public static void x(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }

    public static int S(File file) {
        Throwable th;
        InputStream inputStream;
        try {
            byte[] bArr = new byte[4];
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                if (bArr[0] == (byte) 100 && bArr[1] == (byte) 101 && bArr[2] == (byte) 121 && bArr[3] == (byte) 10) {
                    try {
                        fileInputStream.close();
                        return 0;
                    } catch (Throwable th2) {
                        return 0;
                    }
                } else if (bArr[0] == Byte.MAX_VALUE && bArr[1] == (byte) 69 && bArr[2] == (byte) 76 && bArr[3] == (byte) 70) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                    }
                    return 1;
                } else {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                    }
                    return -1;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static void a(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
        }
        byteBuffer.flip();
    }

    private static String o(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != (byte) 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public void close() {
        this.jHF.close();
        this.xhJ.clear();
        this.xhL = null;
        this.xhM = null;
    }
}
