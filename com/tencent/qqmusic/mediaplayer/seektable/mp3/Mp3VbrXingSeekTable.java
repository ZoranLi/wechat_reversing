package com.tencent.qqmusic.mediaplayer.seektable.mp3;

public class Mp3VbrXingSeekTable extends Mp3SeekTable {
    public long getPosition(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        if (this.mInfo == null) {
            return 0;
        }
        long[] tocTable = this.mInfo.getTocTable();
        if (tocTable == null) {
            return this.mFirstAudioFramePosition;
        }
        float f3 = (((float) j) * 100.0f) / ((float) this.mDuration);
        if (f3 <= 0.0f) {
            f = 0.0f;
        } else if (f3 < 100.0f) {
            int i = (int) f3;
            if (i != 0) {
                f2 = (float) tocTable[i - 1];
            }
            if (i < 99) {
                f = (float) tocTable[i];
            }
            f = ((f - f2) * (f3 - ((float) i))) + f2;
        }
        return Math.min(Math.round((((double) f) * 0.00390625d) * ((double) this.mFileLength)) + this.mFirstAudioFramePosition, ((this.mFirstAudioFramePosition - this.mId3Size) + this.mFileLength) - 1);
    }
}
