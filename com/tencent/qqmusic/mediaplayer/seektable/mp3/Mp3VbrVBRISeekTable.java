package com.tencent.qqmusic.mediaplayer.seektable.mp3;

public class Mp3VbrVBRISeekTable extends Mp3SeekTable {
    public long getPosition(long j) {
        if (this.mInfo == null) {
            return 0;
        }
        long[] tocTable = this.mInfo.getTocTable();
        if (tocTable == null || tocTable.length <= 0) {
            return this.mFirstAudioFramePosition;
        }
        int length = (int) (((((double) j) * 1.0d) / ((double) this.mDuration)) * ((double) (tocTable.length - 1)));
        long j2 = length < 0 ? this.mFirstAudioFramePosition : tocTable[length];
        long j3 = length >= tocTable.length + -1 ? this.mFileLength : tocTable[length + 1];
        long length2 = (((long) length) * this.mDuration) / ((long) (tocTable.length - 1));
        return j2 + (j3 == j2 ? 0 : (long) (((((double) (j3 - j2)) * 1.0d) * ((double) (j - length2))) / ((double) (((((long) (length + 1)) * this.mDuration) / ((long) (tocTable.length - 1))) - length2))));
    }
}
