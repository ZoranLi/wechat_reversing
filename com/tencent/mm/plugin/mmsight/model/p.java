package com.tencent.mm.plugin.mmsight.model;

public final class p {
    public static int nCZ = 480;
    public static int nDa = 640;
    public int gPE;
    public int gPG;
    public int iap;
    public int lAJ;
    public int lAK;
    public int nDb;
    public int nDc;
    public int nDd;
    public int nDe;
    public int nDf;
    public String nDg;
    public String nDh;
    public String nDi;
    public String nDj;
    public String nDk;
    public int nDl;
    public int nDm;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fps=").append(this.gPE).append('\n');
        stringBuilder.append("width=").append(this.lAJ).append('\n');
        stringBuilder.append("height=").append(this.lAK).append('\n');
        stringBuilder.append("bitrate=").append(this.nDb).append('\n');
        stringBuilder.append("rotate=").append(this.gPG).append('\n');
        stringBuilder.append("yuvWidth=").append(this.nDd).append('\n');
        stringBuilder.append("yuvHeight=").append(this.nDc).append('\n');
        stringBuilder.append("x264Speed=").append(this.nDe).append('\n');
        stringBuilder.append("x264Quality=").append(this.nDf).append('\n');
        stringBuilder.append("yuvFile=").append(this.nDg).append('\n');
        stringBuilder.append("pcmFile=").append(this.nDh).append('\n');
        stringBuilder.append("thuFile=").append(this.nDi).append('\n');
        stringBuilder.append("x264File=").append(this.nDj).append('\n');
        stringBuilder.append("mp4File=").append(this.nDk).append('\n');
        stringBuilder.append("videoFrameCnt=").append(this.nDl).append('\n');
        stringBuilder.append("videoLength=").append(this.iap).append('\n');
        stringBuilder.append("cameraCount=").append(this.nDm).append('\n');
        return stringBuilder.toString();
    }

    public static p aKW() {
        p pVar = new p();
        pVar.gPE = 30;
        pVar.gPG = 0;
        pVar.nDc = nDa;
        pVar.nDd = nCZ;
        pVar.lAK = nDa;
        pVar.lAJ = nCZ;
        pVar.nDb = 327680;
        pVar.nDe = 4;
        pVar.nDf = 1;
        pVar.nDg = "/sdcard/2.yuv";
        pVar.nDk = "/sdcard/2.mp4";
        pVar.nDh = "/sdcard/2.pcm";
        pVar.nDj = "/sdcard/2.x264";
        pVar.nDl = 0;
        pVar.iap = 0;
        pVar.nDm = 0;
        return pVar;
    }
}
