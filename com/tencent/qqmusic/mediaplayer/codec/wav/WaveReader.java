package com.tencent.qqmusic.mediaplayer.codec.wav;

import com.tencent.qqmusic.mediaplayer.CacheBytesManager;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.InputStream;

public class WaveReader {
    private static final String TAG = "WaveReader";
    private static final int WAV_FORMAT = 1463899717;
    private static final int WAV_FORMAT_CHUNK_ID = 1718449184;
    private static final int WAV_HEADER_CHUNK_ID = 1380533830;
    private static final int WAV_HEADER_SIZE = 50;

    public static boolean isWavFormat(String str) {
        InputStream fileInputStream;
        Throwable e;
        Throwable e2;
        byte[] bArr = CacheBytesManager.getStatic(50);
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileInputStream.read(bArr);
                int readUnsignedInt = readUnsignedInt(bArr, 0);
                if (readUnsignedInt != WAV_HEADER_CHUNK_ID) {
                    Logger.i(TAG, "isWavFormat Invalid WAVE header chunk ID = " + readUnsignedInt);
                    try {
                        fileInputStream.close();
                    } catch (Throwable e3) {
                        Logger.e(TAG, e3);
                    }
                    CacheBytesManager.recycle(bArr);
                    return false;
                }
                readUnsignedInt = readUnsignedInt(bArr, 8);
                if (readUnsignedInt != WAV_FORMAT) {
                    Logger.i(TAG, "isWavFormat Invalid WAVE format = " + readUnsignedInt);
                    try {
                        fileInputStream.close();
                    } catch (Throwable e32) {
                        Logger.e(TAG, e32);
                    }
                    CacheBytesManager.recycle(bArr);
                    return false;
                }
                readUnsignedInt = readUnsignedInt(bArr, 12);
                if (readUnsignedInt != WAV_FORMAT_CHUNK_ID) {
                    Logger.i(TAG, "isWavFormat Invalid WAVE format chunk ID formatId = " + readUnsignedInt);
                    try {
                        fileInputStream.close();
                    } catch (Throwable e322) {
                        Logger.e(TAG, e322);
                    }
                    CacheBytesManager.recycle(bArr);
                    return false;
                }
                Logger.i(TAG, "isWavFormat formatSize = " + readUnsignedIntLE(bArr, 16));
                Logger.i(TAG, "isWavFormat mAudioFormat = " + readUnsignedShortLE(bArr, 20));
                try {
                    fileInputStream.close();
                } catch (Throwable e22) {
                    Logger.e(TAG, e22);
                }
                CacheBytesManager.recycle(bArr);
                return true;
            } catch (Exception e4) {
                e322 = e4;
                try {
                    Logger.e(TAG, e322);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e3222) {
                            Logger.e(TAG, e3222);
                        }
                    }
                    CacheBytesManager.recycle(bArr);
                    return false;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e32222) {
                            Logger.e(TAG, e32222);
                        }
                    }
                    CacheBytesManager.recycle(bArr);
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e32222 = e5;
            fileInputStream = null;
            Logger.e(TAG, e32222);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            CacheBytesManager.recycle(bArr);
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            CacheBytesManager.recycle(bArr);
            throw e22;
        }
    }

    private static int readUnsignedInt(byte[] bArr, int i) {
        if (i + 4 > bArr.length) {
            return -1;
        }
        return ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
    }

    private static int readUnsignedIntLE(byte[] bArr, int i) {
        if (i + 4 > bArr.length) {
            return -1;
        }
        return (((bArr[0] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
    }

    private static short readUnsignedShortLE(byte[] bArr, int i) {
        if (i + 2 > bArr.length) {
            return (short) -1;
        }
        return byteToShortLE(bArr[i], bArr[i + 1]);
    }

    private static short byteToShortLE(byte b, byte b2) {
        return (short) ((b & 255) | ((b2 & 255) << 8));
    }
}
