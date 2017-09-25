package com.tencent.qqmusic.mediaplayer;

interface PlayerCallback {
    void playThreadStart();

    void playerEnded();

    void playerException(int i, int i2, int i3);

    void playerPaused();

    void playerPrepared();

    void playerSeeked();

    void playerStarted();

    void playerStopped();
}
