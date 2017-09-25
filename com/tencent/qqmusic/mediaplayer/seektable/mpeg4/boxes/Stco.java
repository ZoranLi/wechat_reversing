package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stco extends FullBox {
    int[] chunkOffset;
    int entryCount;

    public void parse(Parsable parsable, Box box) {
        super.parse(parsable, box);
        this.entryCount = parsable.readInt();
        this.chunkOffset = parsable.readIntArray(this.entryCount);
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public int[] getChunkOffset() {
        return this.chunkOffset;
    }
}
