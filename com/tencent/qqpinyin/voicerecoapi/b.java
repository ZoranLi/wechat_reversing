package com.tencent.qqpinyin.voicerecoapi;

public final class b extends Exception {
    private String iMT = "";
    private int jUO;

    public b(int i) {
        String str;
        this.jUO = i;
        switch (i) {
            case -104:
                str = "null param or 0 length";
                break;
            case -103:
                str = "already init";
                break;
            case -102:
                str = "should init at first";
                break;
            case -101:
                str = "speex engine error";
                break;
            case -100:
                str = "out of memory";
                break;
            default:
                str = "unknown error";
                break;
        }
        this.iMT = str;
        new StringBuilder("errorCode: ").append(this.jUO).append("\t msg: ").append(this.iMT);
    }
}
