package com.tencent.mm.plugin.music.a.a;

import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e {
    public String fyF;
    private String mUrl;
    public RandomAccessFile randomAccessFile = null;

    public e(String str) {
        this.mUrl = str;
        this.fyF = h.Bq(this.mUrl);
        w.i("MicroMsg.PieceFileCache", "PieceFileCache mUrl:%s, fileName:%s,", new Object[]{this.mUrl, this.fyF});
    }

    public final synchronized int a(byte[] bArr, long j, int i) {
        int i2 = -1;
        synchronized (this) {
            if (i == 0) {
                Logger.e("MicroMsg.PieceFileCache", "read error, length == 0");
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.PieceFileCache", "read error, randomAccessFile is null");
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    i2 = this.randomAccessFile.read(bArr, 0, i);
                } catch (IOException e) {
                    Logger.e("MicroMsg.PieceFileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)}));
                }
            }
        }
        return i2;
    }

    public final synchronized boolean b(byte[] bArr, long j, int i) {
        boolean z = false;
        synchronized (this) {
            if (i == 0) {
                Logger.e("MicroMsg.PieceFileCache", "write error, length == 0");
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.PieceFileCache", "write error, randomAccessFile is null");
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    this.randomAccessFile.write(bArr, 0, i);
                    z = true;
                } catch (IOException e) {
                    Logger.e("MicroMsg.PieceFileCache", String.format("Error writing %d bytes to from buffer with size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i = -1;
        synchronized (this) {
            if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.PieceFileCache", "getLength error, randomAccessFile is null");
            } else {
                try {
                    i = (int) this.randomAccessFile.length();
                } catch (IOException e) {
                    Logger.e("MicroMsg.PieceFileCache", "Error get length of file , err %s", e.getMessage());
                }
            }
        }
        return i;
    }

    public final synchronized void setLength(int i) {
        if (this.randomAccessFile == null) {
            Logger.e("MicroMsg.PieceFileCache", "setLength error, randomAccessFile is null");
        } else if (i <= 0) {
            Logger.e("MicroMsg.PieceFileCache", "setLength error, length is " + i);
        } else {
            Logger.e("MicroMsg.PieceFileCache", "set file length %s ", String.valueOf(i));
            try {
                this.randomAccessFile.setLength((long) i);
            } catch (IOException e) {
                Logger.e("MicroMsg.PieceFileCache", "Error set length of file, err %s", e.getMessage());
            }
        }
    }

    public final synchronized long aOa() {
        long length;
        File file = new File(this.fyF);
        if (file.exists()) {
            length = file.length();
        } else {
            length = -1;
        }
        return length;
    }

    public static void tv(String str) {
        Logger.i("MicroMsg.PieceFileCache", "deleteFile, fileName:" + str);
        File file = new File(str);
        if (file.exists()) {
            Logger.i("MicroMsg.PieceFileCache", "delete the piece File");
            file.delete();
            return;
        }
        Logger.e("MicroMsg.PieceFileCache", "file not exist, delete piece File fail");
    }
}
