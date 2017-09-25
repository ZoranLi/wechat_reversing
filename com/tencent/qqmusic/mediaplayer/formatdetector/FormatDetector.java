package com.tencent.qqmusic.mediaplayer.formatdetector;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class FormatDetector {
    private static final String SO_NAME = "FormatDetector";
    private static final String TAG = "FormatDetector";
    private static FormatDetector mInstance = new FormatDetector();
    public static boolean sIsLoadSuccess;

    private native int getFormat(String str, boolean z);

    private native int getFormatFromDataSource(IDataSource iDataSource, boolean z);

    static {
        boolean z = false;
        sIsLoadSuccess = false;
        try {
            ISoLibraryLoader soLibraryLoader = AudioPlayerConfigure.getSoLibraryLoader();
            if (soLibraryLoader.load("audio_common") && soLibraryLoader.load("FormatDetector")) {
                z = true;
            }
            sIsLoadSuccess = z;
        } catch (Throwable th) {
            Logger.e("FormatDetector", "failed to load so!", th);
        }
    }

    public static AudioType getAudioFormat(String str) {
        return getAudioFormat(str, true);
    }

    public static AudioType getAudioFormat(String str, boolean z) {
        try {
            return AudioFormat.getAudioType(mInstance.getFormat(str, z));
        } catch (Throwable e) {
            Logger.e("FormatDetector", e);
            return AudioRecognition.guessFormat(str);
        }
    }

    public static AudioType getAudioFormat(IDataSource iDataSource, boolean z) {
        AudioType audioType = AudioType.UNSUPPORT;
        try {
            audioType = AudioFormat.getAudioType(mInstance.getFormatFromDataSource(iDataSource, z));
        } catch (Throwable e) {
            Logger.e("FormatDetector", e);
        }
        return audioType;
    }
}
