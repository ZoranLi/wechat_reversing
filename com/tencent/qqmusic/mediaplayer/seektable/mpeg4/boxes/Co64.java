package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Co64 extends FullBox {
    private long[] chunkOffset;
    private int entryCount;

    public void parse(Parsable parsable, Box box) {
        super.parse(parsable, box);
        this.entryCount = parsable.readInt();
        this.chunkOffset = parsable.readLongArray(this.entryCount);
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public long[] getChunkOffset() {
        return this.chunkOffset;
    }
}
