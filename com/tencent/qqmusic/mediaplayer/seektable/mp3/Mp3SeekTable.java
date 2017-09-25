package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Information;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import java.io.InputStream;

public abstract class Mp3SeekTable implements SeekTable {
    private static final String TAG = "Mp3SeekTable";
    protected long mDuration = 0;
    protected long mFileLength = 0;
    protected long mFirstAudioFramePosition = 0;
    protected long mId3Size = -1;
    protected MP3Information mInfo = null;

    public abstract long getPosition(long j);

    public void setAudioInfomation(MP3Information mP3Information) {
        this.mInfo = mP3Information;
    }

    public void parse(InputStream inputStream) {
        if (this.mInfo != null) {
            this.mId3Size = this.mInfo.getId3v2Size();
            this.mId3Size = Math.max(this.mId3Size, 0);
            if (this.mInfo.getFileLengthInBytes() > 0) {
                this.mFileLength = this.mInfo.getFileLengthInBytes();
            }
            if (this.mInfo.getFirstFramePos() >= 0 && this.mInfo.getFirstFrameSize() >= 0) {
                this.mFirstAudioFramePosition = this.mInfo.getFirstFramePos() + this.mInfo.getFirstFrameSize();
            }
            this.mDuration = this.mInfo.getDuration();
        }
    }

    public long seek(long j) {
        return getPosition(j);
    }
}
