package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioPlayerConfigure {
    private static final String TAG = "AudioPlayerConfigure";
    private static ISoLibraryLoader mISoLibraryLoader = new ISoLibraryLoader() {
        public final boolean load(String str) {
            System.loadLibrary(str);
            return true;
        }
    };

    public static void setSoLibraryLoader(ISoLibraryLoader iSoLibraryLoader) {
        if (iSoLibraryLoader != null) {
            mISoLibraryLoader = iSoLibraryLoader;
        }
    }

    public static ISoLibraryLoader getSoLibraryLoader() {
        return mISoLibraryLoader;
    }

    public static void setLog(ILog iLog) {
        if (iLog != null) {
            iLog.i(TAG, "QQMusicAudioPlayer version name:0.5.7");
        }
        Logger.setLog(iLog);
    }
}
