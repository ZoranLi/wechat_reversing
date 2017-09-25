package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.WebView;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class d implements Closeable {
    private final File iyI;
    public final RandomAccessFile wXB;
    private final byte[] wXC;
    public boolean wXD;

    private d(File file) {
        this.wXC = new byte[8];
        this.iyI = file;
        this.wXB = new RandomAccessFile(this.iyI, "r");
    }

    public d(String str) {
        this(new File(str));
    }

    public final int a(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        int read = this.wXB.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return read;
    }

    public final void close() {
        try {
            this.wXB.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public final int readInt() {
        int readInt = this.wXB.readInt();
        if (!this.wXD) {
            return readInt;
        }
        return ((readInt & WebView.NIGHT_MODE_COLOR) >>> 24) | ((((readInt & 255) << 24) | ((65280 & readInt) << 8)) | ((16711680 & readInt) >>> 8));
    }
}
