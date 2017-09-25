package com.tencent.mm.storage;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;

public final class an {
    public static final an uJE = new an("timeline");
    public static final an uJF = new an("album_friend");
    public static final an uJG = new an("album_self");
    public static final an uJH = new an("album_stranger");
    public static final an uJI = new an("profile_friend");
    public static final an uJJ = new an("profile_stranger");
    public static final an uJK = new an(FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
    public static final an uJL = new an("comment_detail");
    public static final an uJM = new an("other");
    public static final an uJN = new an("snssight");
    public static final an uJO = new an("fts");
    public int cIm = 0;
    public String tag = "";

    public static an bLR() {
        return new an("timeline");
    }

    public static an bLS() {
        return new an("album_friend");
    }

    public static an bLT() {
        return new an("album_self");
    }

    public static an bLU() {
        return new an("album_stranger");
    }

    public static an bLV() {
        return new an("snssight");
    }

    public an(String str) {
        this.tag = str;
    }

    public final an yE(int i) {
        this.cIm = i;
        return this;
    }

    public static an a(an anVar, int i) {
        an anVar2 = new an(anVar.tag);
        anVar2.cIm = i;
        return anVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof an) {
            return ((an) obj).tag.equals(this.tag);
        }
        return super.equals(obj);
    }

    public final String toString() {
        return this.tag + "@" + this.cIm;
    }
}
