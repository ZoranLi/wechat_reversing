package com.tencent.mm.plugin.fps_lighter.c;

public final class b {
    public long beginTime;
    public int hKa;
    public long jgm;
    public long lQx;
    public long lQy;
    public int lQz;

    public static class a {
        public long hTv;
        public boolean lQA;
        public long lQB;
        public long lQy;
        public int lQz;

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.lQA);
            stringBuilder.append(" ");
            stringBuilder.append(this.lQB);
            stringBuilder.append(" ");
            stringBuilder.append(this.lQy);
            stringBuilder.append(" ");
            stringBuilder.append(this.hTv);
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
    }

    public final String getKey() {
        return this.lQy + ">" + this.hKa;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(16);
        for (int i = 0; i < this.hKa; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(this.lQy);
        stringBuilder.append(" ");
        stringBuilder.append(this.jgm);
        stringBuilder.append(" ");
        stringBuilder.append(this.beginTime);
        stringBuilder.append(" ");
        stringBuilder.append(this.hKa);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQx);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
