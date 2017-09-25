package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stts extends FullBox {
    int entryCount;
    int[] sampleCount;
    int[] sampleDelta;

    public void parse(Parsable parsable, Box box) {
        super.parse(parsable, box);
        this.entryCount = parsable.readInt();
        this.sampleCount = new int[this.entryCount];
        this.sampleDelta = new int[this.entryCount];
        parsable.readIntArrayInterleaved(this.entryCount, this.sampleCount, this.sampleDelta);
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public int[] getSampleCount() {
        return this.sampleCount;
    }

    public int[] getSampleDelta() {
        return this.sampleDelta;
    }
}
