package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Ftyp extends Box {
    int[] compatibleBrands;
    int majorBrand;
    int minorVersion;

    public void parse(Parsable parsable, Box box) {
        super.parse(parsable, box);
        this.majorBrand = parsable.readInt();
        this.minorVersion = parsable.readInt();
        int available = ((int) parsable.available()) / 4;
        if (available > 0) {
            this.compatibleBrands = parsable.readIntArray(available);
        }
    }
}
