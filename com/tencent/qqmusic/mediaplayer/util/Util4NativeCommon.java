package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;

public class Util4NativeCommon {
    private static final String TAG = "Util4NativeCommon";

    public static native boolean isSupportNeon();

    static {
        try {
            AudioPlayerConfigure.getSoLibraryLoader().load("audio_common");
        } catch (Throwable e) {
            Logger.e(TAG, e);
        } catch (Throwable e2) {
            Logger.e(TAG, e2);
        }
    }
}
