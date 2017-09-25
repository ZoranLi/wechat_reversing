package com.tencent.qqmusic.mediaplayer.codec.ffmpeg;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FfmpegPlayer extends BaseDecoder {
    private static final String SO_AUDIO_COMMON = "audio_common";
    private static final String SO_BASE_NAME = "FFmpeg";
    private static final String SO_NAME = "ffmpeg_decoder";
    private static final String SO_NEON_BASE_NAME = "FFmpeg_v7a";
    private static final String SO_NEON_NAME = "ffmpeg_decoder_v7a";
    private static final String TAG = "FfmpegPlayer";
    private boolean mHasRelease = false;

    private native int nativeDecode(int i, short[] sArr);

    private native AudioInformation nativeGetAudioInformation();

    private native long nativeGetDuration();

    private native long nativeGetPosition();

    private native int nativeInit(String str);

    private native int nativeInitDataSource(IDataSource iDataSource);

    private native int nativeInitNativeDataSource(long j);

    private native int nativeRelease();

    private native int nativeSeek(int i);

    protected List<String> getSoNameList() {
        List<String> arrayList = new ArrayList();
        arrayList.add(SO_AUDIO_COMMON);
        arrayList.add(SO_BASE_NAME);
        arrayList.add(SO_NAME);
        return arrayList;
    }

    protected List<String> getSoNameListForV7a() {
        List<String> arrayList = new ArrayList();
        arrayList.add(SO_AUDIO_COMMON);
        arrayList.add(SO_NEON_BASE_NAME);
        arrayList.add(SO_NEON_NAME);
        return arrayList;
    }

    public AudioInformation getAudioInformation() {
        super.getAudioInformation();
        return nativeGetAudioInformation();
    }

    public int seekTo(int i) {
        super.seekTo(i);
        return nativeSeek(i);
    }

    public long getCurrentTime() {
        super.getCurrentTime();
        return nativeGetPosition();
    }

    public long getDuration() {
        return nativeGetDuration();
    }

    public int decodeData(int i, short[] sArr) {
        super.decodeData(i, sArr);
        return nativeDecode(i, sArr);
    }

    public int init(String str, boolean z) {
        super.init(str, z);
        return nativeInit(str);
    }

    public int init(IDataSource iDataSource) {
        super.init(iDataSource);
        return nativeInitDataSource(iDataSource);
    }

    public int init(INativeDataSource iNativeDataSource) {
        super.init(iNativeDataSource);
        long nativeInstance = iNativeDataSource.getNativeInstance();
        if (nativeInstance == 0) {
            return -1;
        }
        return nativeInitNativeDataSource(nativeInstance);
    }

    public AudioType getAudioType(String str, byte[] bArr) {
        InputStream fileInputStream;
        Throwable e;
        String str2 = null;
        if (bArr == null || bArr.length == 0) {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    byte[] bArr2 = new byte[64];
                    fileInputStream.read(bArr2);
                    String str3 = new String(bArr2);
                    try {
                        fileInputStream.close();
                        str2 = str3;
                    } catch (Throwable e2) {
                        Logger.e(TAG, e2);
                        str2 = str3;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Logger.e(TAG, e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                Logger.e(TAG, e4);
                            }
                        }
                        if (str2 == null) {
                        }
                        return AudioType.UNSUPPORT;
                    } catch (Throwable th) {
                        e4 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e22) {
                                Logger.e(TAG, e22);
                            }
                        }
                        throw e4;
                    }
                }
            } catch (Exception e5) {
                e4 = e5;
                fileInputStream = null;
                Logger.e(TAG, e4);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (str2 == null) {
                }
                return AudioType.UNSUPPORT;
            } catch (Throwable th2) {
                e4 = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e4;
            }
        }
        str2 = new String(bArr);
        if (str2 == null && str2.contains("ftyp")) {
            return AudioType.M4A;
        }
        return AudioType.UNSUPPORT;
    }

    public AudioType guessAudioType(String str) {
        return getAudioType(str, null);
    }

    public int release() {
        super.release();
        if (!this.mHasRelease) {
            this.mHasRelease = true;
            nativeRelease();
        }
        return 0;
    }

    public int getErrorCodeMask() {
        return 67108863;
    }
}
