package com.tencent.mm.plugin.sns.data;

public final class h {
    public String desc = "";
    public String fKz = "";
    public int fileSize = 0;
    public int height = -1;
    public int pQX = 0;
    public int pQY;
    public int pQZ;
    public int pRa;
    public String pRb = "";
    public String pRc = "";
    public String pRd = "";
    public boolean pRe = false;
    public String path = "";
    public int type;
    public int width = -1;

    public h(String str, int i) {
        this.path = str;
        this.type = i;
        this.pRa = -1;
    }

    public h(int i, int i2) {
        this.pRa = i;
        this.type = i2;
        this.path = "";
    }
}
