package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;

public interface INativeDataSource {

    public interface Factory {
        INativeDataSource createDataSource();
    }

    AudioType getAudioType();

    long getNativeInstance();
}
