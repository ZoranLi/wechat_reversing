package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.b.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

public final class l {
    protected static final k fvg = new k(101010256);
    public static com.tencent.mm.b.l kHl = new com.tencent.mm.b.l(38650);

    private static class a {
        Properties kHm = new Properties();
        byte[] kHn;

        public final String toString() {
            return "ApkExternalInfo [p=" + this.kHm + ", otherData=" + Arrays.toString(this.kHn) + "]";
        }
    }

    private static String c(File file, String str) {
        Throwable th;
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] c = c(randomAccessFile);
                if (c == null) {
                    randomAccessFile.close();
                } else {
                    a aVar = new a();
                    if (c != null) {
                        ByteBuffer wrap = ByteBuffer.wrap(c);
                        kHl.getBytes();
                        byte[] bArr = new byte[2];
                        wrap.get(bArr);
                        if (!kHl.equals(new com.tencent.mm.b.l(bArr))) {
                            throw new ProtocolException("unknow protocl [" + Arrays.toString(c) + "]");
                        } else if (c.length - 2 > 2) {
                            bArr = new byte[2];
                            wrap.get(bArr);
                            int i = new com.tencent.mm.b.l(bArr).value;
                            if ((c.length - 2) - 2 >= i) {
                                byte[] bArr2 = new byte[i];
                                wrap.get(bArr2);
                                aVar.kHm.load(new ByteArrayInputStream(bArr2));
                                int length = ((c.length - 2) - i) - 2;
                                if (length > 0) {
                                    aVar.kHn = new byte[length];
                                    wrap.get(aVar.kHn);
                                }
                            }
                        }
                    }
                    str2 = aVar.kHm.getProperty(str);
                    randomAccessFile.close();
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            randomAccessFile = null;
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String q(File file) {
        return c(file, DownloadInfoColumns.CHANNELID);
    }

    private static byte[] c(RandomAccessFile randomAccessFile) {
        int i = 1;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = fvg.getBytes();
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((16 + length) + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        i = new com.tencent.mm.b.l(bArr).value;
        if (i == 0) {
            return null;
        }
        bArr = new byte[i];
        randomAccessFile.read(bArr);
        return bArr;
    }
}
