package com.tencent.qqmusic.mediaplayer.codec.ape;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class ApeDecoder extends BaseDecoder {
    private static final String APE_SO_NAME = "ape";
    private static final String APE_SO_NEON_NAME = "apev7a";
    public static final String TAG = "ApeDecoder";
    private volatile boolean mHasRelease = false;

    private native void nCleanupApeLib();

    private native int nDecodeApe(int i, short[] sArr);

    private native AudioInformation nGetAudioInformation();

    private native int nGetCurPosition();

    private native int nGetDuration();

    private native int nInitApeLib(String str, int i);

    private native boolean nIsApeFormat(String str);

    private native int nSeekTo(int i);

    public native int nSeekToExactly(int i);

    public int init(String str, boolean z) {
        super.init(str, z);
        return nInitApeLib(str, z ? 0 : 1);
    }

    public AudioInformation getAudioInformation() {
        super.getAudioInformation();
        return nGetAudioInformation();
    }

    public int decodeData(int i, short[] sArr) {
        super.decodeData(i, sArr);
        return nDecodeApe(i, sArr);
    }

    public long getCurrentTime() {
        super.getCurrentTime();
        return (long) nGetCurPosition();
    }

    public int seekTo(int i) {
        super.seekTo(i);
        return nSeekTo(i);
    }

    public int release() {
        super.release();
        if (!this.mHasRelease) {
            this.mHasRelease = true;
            Logger.w(TAG, this + "release");
            nCleanupApeLib();
        }
        return 0;
    }

    public AudioType getAudioType(String str, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && new String(bArr).startsWith("MAC")) {
            return AudioType.APE;
        }
        throwIfSoNotLoadSuccess();
        if (nIsApeFormat(str)) {
            return AudioType.APE;
        }
        return AudioType.UNSUPPORT;
    }

    public AudioType guessAudioType(String str) {
        if (TextUtils.isEmpty(str) || (!str.toLowerCase().contains(".ape") && !str.toLowerCase().contains(".mac"))) {
            return AudioType.UNSUPPORT;
        }
        return AudioType.APE;
    }

    protected List<String> getSoNameList() {
        List arrayList = new ArrayList();
        arrayList.add(APE_SO_NAME);
        return arrayList;
    }

    protected List<String> getSoNameListForV7a() {
        List arrayList = new ArrayList();
        arrayList.add(APE_SO_NEON_NAME);
        return arrayList;
    }

    public int getErrorCodeMask() {
        return 50331647;
    }
}
