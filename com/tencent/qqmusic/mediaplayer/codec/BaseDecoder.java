package com.tencent.qqmusic.mediaplayer.codec;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.SoNotFindException;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.Util4Phone;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDecoder {
    private static final String TAG = "BaseDecoder";
    private AudioType mAudioType = null;
    private final boolean mHasLoadSoSuccess;
    public int mNativeApeDecoderRef = 0;

    public abstract AudioType getAudioType(String str, byte[] bArr);

    public abstract List<String> getSoNameList();

    public abstract AudioType guessAudioType(String str);

    public BaseDecoder() {
        List<String> soNameListForV7a;
        boolean z;
        boolean z2 = true;
        if (Util4Phone.isSupportNeon()) {
            soNameListForV7a = getSoNameListForV7a();
            if (soNameListForV7a == null || soNameListForV7a.isEmpty()) {
                z = false;
                break;
            }
            for (String loadLibrary : soNameListForV7a) {
                if (!loadLibrary(loadLibrary)) {
                    z = false;
                    break;
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            soNameListForV7a = getSoNameList();
            if (soNameListForV7a != null && !soNameListForV7a.isEmpty()) {
                for (String loadLibrary2 : soNameListForV7a) {
                    if (!loadLibrary(loadLibrary2)) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = false;
            break;
        }
        z2 = z;
        this.mHasLoadSoSuccess = z2;
    }

    public List<String> getSoNameListForV7a() {
        return new ArrayList();
    }

    private boolean loadLibrary(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                z = AudioPlayerConfigure.getSoLibraryLoader().load(str);
            } catch (Throwable th) {
                Logger.e(TAG, "load library exception ", th);
            }
            Logger.d(TAG, "loadLibrary  mHasLoadSoSuccess = " + this.mHasLoadSoSuccess + ",soName = " + str);
        }
        return z;
    }

    public void throwIfSoNotLoadSuccess() {
        if (!this.mHasLoadSoSuccess) {
            throw new SoNotFindException("has't load so success , can't call native funcation");
        }
    }

    public int init(String str, boolean z) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int init(IDataSource iDataSource) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int init(INativeDataSource iNativeDataSource) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public AudioInformation getAudioInformation() {
        throwIfSoNotLoadSuccess();
        return null;
    }

    public int decodeData(int i, short[] sArr) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public long getCurrentTime() {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int seekTo(int i) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int release() {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int getErrorCodeMask() {
        return -1;
    }

    public boolean checkFormatBySoftDecoder(String str) {
        throwIfSoNotLoadSuccess();
        try {
            if (init(str, false) == 0) {
                AudioInformation audioInformation = getAudioInformation();
                if (audioInformation != null && audioInformation.getSampleRate() > 0 && audioInformation.getDuration() > 0) {
                    try {
                        release();
                    } catch (Throwable th) {
                        Logger.e(TAG, th);
                    }
                    return true;
                }
            }
            try {
                release();
                return false;
            } catch (Throwable th2) {
                Logger.e(TAG, th2);
                return false;
            }
        } catch (Throwable th22) {
            Logger.e(TAG, th22);
            return false;
        }
    }

    public AudioType getAudioType() {
        return this.mAudioType;
    }

    public void setAudioType(AudioType audioType) {
        this.mAudioType = audioType;
    }
}
