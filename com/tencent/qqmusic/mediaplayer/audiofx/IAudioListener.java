package com.tencent.qqmusic.mediaplayer.audiofx;

import com.tencent.qqmusic.mediaplayer.BufferInfo;

public interface IAudioListener {
    boolean isEnabled();

    boolean isTerminal();

    boolean onPcm(BufferInfo bufferInfo, BufferInfo bufferInfo2);

    long onPlayerReady(long j, int i, int i2);

    void onPlayerSeekComplete(long j);

    void onPlayerStopped();
}
