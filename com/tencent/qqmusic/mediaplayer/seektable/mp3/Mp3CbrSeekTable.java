package com.tencent.qqmusic.mediaplayer.seektable.mp3;

public class Mp3CbrSeekTable extends Mp3SeekTable {
    public long getPosition(long j) {
        return ((((long) this.mInfo.getBitrate()) / 8) * j) + this.mId3Size;
    }
}
