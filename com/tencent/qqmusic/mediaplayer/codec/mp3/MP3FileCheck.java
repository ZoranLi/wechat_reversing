package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.RandomAccessFile;

public class MP3FileCheck {
    private static final String TAG = "MP3FileCheck";
    private byte[] buf = new byte[8192];
    private int endPos;
    private boolean eof;
    private int frameCount;
    private boolean hasCheck = false;
    private boolean hasID3V2 = false;
    private MP3Header header = new MP3Header();
    private int headerMask;
    private boolean isMP3 = false;
    private String mFilePath = null;
    private int mID3V2Size = -1;
    private RandomAccessFile mRandomAccessFile = null;
    private int pos;
    private int skipped;
    private boolean sync;

    public MP3FileCheck(String str) {
        this.mFilePath = str;
    }

    public static boolean isMp3File(String str) {
        return new MP3FileCheck(str).isMp3File();
    }

    private boolean isMp3File() {
        if (!this.hasCheck) {
            fileCheck();
        }
        return this.isMP3;
    }

    private boolean checkAndSeekID3V2Tag() {
        byte[] bArr = new byte[10];
        int fillBuffer = fillBuffer(bArr, 0, 10);
        if (fillBuffer <= 0) {
            return false;
        }
        if (bArr[0] == (byte) 73 && bArr[1] == (byte) 68 && bArr[2] == (byte) 51) {
            this.mID3V2Size = (((bArr[6] << 21) + (bArr[7] << 14)) + (bArr[8] << 7)) + bArr[9];
            this.hasID3V2 = true;
            seekTo(this.mID3V2Size - fillBuffer);
            Logger.d(TAG, "有ID3V2，ID3V2大小 = " + this.mID3V2Size);
        } else {
            closeFileStream();
            Logger.d(TAG, "没有有ID3V2");
        }
        return this.hasID3V2;
    }

    private void closeFileStream() {
        if (this.mRandomAccessFile != null) {
            try {
                this.mRandomAccessFile.close();
            } catch (Throwable e) {
                Logger.e(TAG, e);
            }
            this.mRandomAccessFile = null;
        }
    }

    private void seekTo(int i) {
        try {
            this.mRandomAccessFile.seek((long) i);
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
    }

    public void fileCheck() {
        try {
            this.hasCheck = true;
            checkAndSeekID3V2Tag();
            this.headerMask = -2097152;
            this.sync = false;
            this.eof = false;
            this.frameCount = 0;
            int length = this.buf.length;
            this.pos = length;
            this.endPos = length;
            this.header.initialize();
            nextFrameHeader();
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (Throwable e) {
                    Logger.e(TAG, e);
                }
            }
        } catch (Throwable e2) {
            Logger.e(TAG, e2);
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (Throwable e22) {
                    Logger.e(TAG, e22);
                }
            }
        } catch (Throwable th) {
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (Throwable e3) {
                    Logger.e(TAG, e3);
                }
            }
        }
    }

    public int getFrameSize() {
        if (this.header != null) {
            return this.header.getFrameSize();
        }
        return -1;
    }

    private void nextFrameHeader() {
        int i = 0;
        while (!this.eof && !syncFrame()) {
            int i2 = this.endPos - this.pos;
            if (i2 > 0) {
                System.arraycopy(this.buf, this.pos, this.buf, 0, i2);
            }
            this.endPos = fillBuffer(this.buf, i2, this.pos) + i2;
            if (this.endPos > i2) {
                i += this.pos;
                if (i <= 65536) {
                    this.pos = 0;
                }
            }
            this.eof = true;
            this.pos = 0;
        }
    }

    private boolean syncFrame() {
        int i = this.pos;
        if (this.endPos - this.pos <= 4) {
            return false;
        }
        int byte2int = byte2int(this.buf, this.pos);
        this.pos += 4;
        System.out.println(this.frameCount);
        while (!this.eof) {
            while (!available(byte2int, this.headerMask)) {
                byte2int <<= 8;
                byte[] bArr = this.buf;
                int i2 = this.pos;
                this.pos = i2 + 1;
                byte2int |= bArr[i2] & 255;
                if (this.pos == this.endPos) {
                    byte2int = this.skipped;
                    int i3 = this.pos - 4;
                    this.pos = i3;
                    this.skipped = byte2int + (i3 - i);
                    return false;
                }
            }
            if (this.pos > i + 4) {
                this.sync = false;
                this.skipped += (this.pos - 4) - i;
            }
            this.header.decode(byte2int);
            int frameSize = this.header.getFrameSize();
            if (this.pos + frameSize > this.endPos + 4) {
                byte2int = this.skipped;
                i3 = this.pos - 4;
                this.pos = i3;
                this.skipped = byte2int + (i3 - i);
                return false;
            } else if (this.sync) {
                break;
            } else if (this.pos + frameSize > this.endPos) {
                byte2int = this.skipped;
                i3 = this.pos - 4;
                this.pos = i3;
                this.skipped = byte2int + (i3 - i);
                return false;
            } else {
                i2 = (((1572864 & byte2int) | -2097152) | (393216 & byte2int)) | (byte2int & 3072);
                if (available(byte2int(this.buf, frameSize + (this.pos - 4)), i2)) {
                    if (this.headerMask == -2097152) {
                        this.headerMask = i2;
                    }
                    this.sync = true;
                } else {
                    byte2int <<= 8;
                    bArr = this.buf;
                    i2 = this.pos;
                    this.pos = i2 + 1;
                    byte2int |= bArr[i2] & 255;
                }
            }
        }
        if (this.header.isProtected()) {
            this.pos += 2;
        }
        this.frameCount++;
        if (this.skipped > 0 || (this.skipped == 0 && this.sync)) {
            this.isMP3 = true;
            this.skipped = 0;
        }
        return true;
    }

    private int fillBuffer(byte[] bArr, int i, int i2) {
        try {
            if (this.mRandomAccessFile == null) {
                this.mRandomAccessFile = new RandomAccessFile(this.mFilePath, "r");
            }
            return this.mRandomAccessFile.read(bArr, i, i2);
        } catch (Exception e) {
            return -1;
        }
    }

    private int byte2int(byte[] bArr, int i) {
        return (((bArr[i] << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
    }

    private boolean available(int i, int i2) {
        return ((i & i2) != i2 || ((i >> 19) & 3) == 1 || ((i >> 17) & 3) == 0 || ((i >> 12) & 15) == 15 || ((i >> 12) & 15) == 0 || ((i >> 10) & 3) == 3) ? false : true;
    }
}
