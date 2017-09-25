package com.tencent.mm.plugin.fps_lighter.c;

public final class a {
    public long lQp;
    public long lQq;
    public boolean lQr;
    public int lQs;
    public int lQt;
    public int lQu;
    public long lQv;
    public boolean lQw;
    public int scene;

    public final long avK() {
        return this.lQp - this.lQq;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("\t");
        stringBuilder.append(this.scene);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQq);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQp);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQr);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQs);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQt);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQu);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQv);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQw);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
