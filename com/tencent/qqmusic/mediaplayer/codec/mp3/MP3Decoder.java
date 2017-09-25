package com.tencent.qqmusic.mediaplayer.codec.mp3;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class MP3Decoder extends BaseDecoder {
    private static final String TAG = "MP3_DECODER";
    private long mFileLength = 0;
    private String mFilePath = null;
    private long mFirstAudioFramePosition = -1;
    private volatile boolean mHasRelease = false;
    private long mId3Size = -1;
    private AudioInformation mInfo = null;

    private native void nCleanupLib();

    private native int nDecodeMP3(int i, short[] sArr);

    private native MP3Information nGetAudioInformation();

    private native int nGetCurPosition();

    private native int nInitInputBuffer(int i);

    private native int nInitMp3(String str, int i);

    private native int nInitMp3WithDataSource(IDataSource iDataSource);

    private native int nInitMp3WithNativeDataSource(long j);

    private native int nSeekTo(int i);

    public native long nGetFileLengthInVBRFrame();

    public native long[] nGetVBRTOCTable();

    public native void nSetNativeFileLength(long j);

    public int init(String str, boolean z) {
        throwIfSoNotLoadSuccess();
        this.mFilePath = str;
        return nInitMp3(str, z ? 0 : 1);
    }

    public int init(IDataSource iDataSource) {
        throwIfSoNotLoadSuccess();
        return nInitMp3WithDataSource(iDataSource);
    }

    public int init(INativeDataSource iNativeDataSource) {
        throwIfSoNotLoadSuccess();
        return nInitMp3WithNativeDataSource(iNativeDataSource.getNativeInstance());
    }

    public void setFileTotalLength(long j) {
        this.mFileLength = j;
        Logger.i(TAG, "setFileTotalLength mFileLength = " + this.mFileLength);
        nSetNativeFileLength(j);
    }

    public int initInputBuffer(int i) {
        throwIfSoNotLoadSuccess();
        return nInitInputBuffer(i);
    }

    public AudioInformation getAudioInformation() {
        throwIfSoNotLoadSuccess();
        if (this.mInfo == null || this.mInfo.getDuration() <= 0 || this.mInfo.getBitrate() <= 0 || this.mInfo.getSampleRate() <= 0) {
            this.mInfo = nGetAudioInformation();
        }
        if (!(TextUtils.isEmpty(this.mFilePath) || this.mInfo == null || this.mId3Size != -1)) {
            this.mId3Size = ((MP3Information) this.mInfo).getId3v2Size();
            this.mId3Size = Math.max(this.mId3Size, 0);
        }
        if (!(this.mInfo == null || this.mInfo.durationIsCorrect())) {
            MP3Information mP3Information = (MP3Information) this.mInfo;
            if (mP3Information.getFirstFramePos() >= 0 && mP3Information.getFirstFrameSize() >= 0) {
                this.mFirstAudioFramePosition = mP3Information.getFirstFrameSize() + mP3Information.getFirstFramePos();
            }
            if (!this.mInfo.isCbr()) {
                long nGetFileLengthInVBRFrame = nGetFileLengthInVBRFrame();
                if (nGetFileLengthInVBRFrame > 0) {
                    this.mFileLength = nGetFileLengthInVBRFrame;
                }
                ((MP3Information) this.mInfo).setTocTable(nGetVBRTOCTable());
                if (((MP3Information) this.mInfo).getTocTable() == null) {
                    Logger.e(TAG, "dont have toc tables");
                }
            }
        }
        return this.mInfo;
    }

    public int decodeData(int i, short[] sArr) {
        throwIfSoNotLoadSuccess();
        return nDecodeMP3(i, sArr);
    }

    public long getCurrentTime() {
        throwIfSoNotLoadSuccess();
        return (long) nGetCurPosition();
    }

    public int seekTo(int i) {
        throwIfSoNotLoadSuccess();
        return nSeekTo(i);
    }

    public int release() {
        throwIfSoNotLoadSuccess();
        if (!this.mHasRelease) {
            this.mHasRelease = true;
            Logger.i("MP3Decoder", this + "release");
            try {
                nCleanupLib();
            } catch (Throwable th) {
                Logger.e(TAG, th);
                Logger.e("MP3Decoder", th);
            }
        }
        return 0;
    }

    public AudioType getAudioType(String str, byte[] bArr) {
        if (MP3FileCheck.isMp3File(str)) {
            return AudioType.MP3;
        }
        return AudioType.UNSUPPORT;
    }

    public AudioType guessAudioType(String str) {
        if (TextUtils.isEmpty(str) || (!str.toLowerCase().endsWith(".mp3") && !str.endsWith(".mp3.tmp") && !str.endsWith(".mp3.mqcc") && !str.endsWith(".ofl") && !str.endsWith(".efe"))) {
            return AudioType.UNSUPPORT;
        }
        return AudioType.MP3;
    }

    protected List<String> getSoNameList() {
        List<String> arrayList = new ArrayList();
        arrayList.add("qmmpg123");
        return arrayList;
    }

    public long getDuration(String str, long j) {
        MP3FileCheck mP3FileCheck = new MP3FileCheck(str);
        mP3FileCheck.fileCheck();
        return (long) ((((float) j) / ((float) mP3FileCheck.getFrameSize())) * 26.0f);
    }

    public int getErrorCodeMask() {
        return 134217727;
    }
}
