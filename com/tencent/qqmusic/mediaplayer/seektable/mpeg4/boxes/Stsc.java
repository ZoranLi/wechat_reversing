package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stsc extends FullBox {
    int entryCount;
    int[] firstChunk;
    int[] sampleDescIndex;
    int[] samplesPerChunk;

    public void parse(Parsable parsable, Box box) {
        super.parse(parsable, box);
        this.entryCount = parsable.readInt();
        this.firstChunk = new int[this.entryCount];
        this.samplesPerChunk = new int[this.entryCount];
        this.sampleDescIndex = new int[this.entryCount];
        parsable.readIntArrayInterleaved(this.entryCount, this.firstChunk, this.samplesPerChunk, this.sampleDescIndex);
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public int[] getFirstChunk() {
        return this.firstChunk;
    }

    public int[] getSamplesPerChunk() {
        return this.samplesPerChunk;
    }

    public int[] getSampleDescIndex() {
        return this.sampleDescIndex;
    }
}
