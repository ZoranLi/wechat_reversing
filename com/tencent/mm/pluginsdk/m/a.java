package com.tencent.mm.pluginsdk.m;

@Deprecated
public final class a {
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

    public static a bDK() {
        a aVar = new a();
        aVar.gPE = 30;
        aVar.gPG = 0;
        aVar.nDc = 640;
        aVar.nDd = 480;
        aVar.lAK = 640;
        aVar.lAJ = 480;
        aVar.nDb = 1440000;
        aVar.nDe = 1;
        aVar.nDf = 4;
        aVar.nDg = "/sdcard/1.yuv";
        aVar.nDk = "/sdcard/1.mp4";
        aVar.nDh = "/sdcard/1.pcm";
        aVar.nDj = "/sdcard/1.x264";
        aVar.nDl = 0;
        aVar.iap = 0;
        aVar.nDm = 0;
        return aVar;
    }

    public static a bDL() {
        a aVar = new a();
        aVar.gPE = 30;
        aVar.gPG = 0;
        aVar.nDc = nDa;
        aVar.nDd = nCZ;
        aVar.lAK = nDa;
        aVar.lAJ = nCZ;
        aVar.nDb = 327680;
        aVar.nDe = 4;
        aVar.nDf = 1;
        aVar.nDg = "/sdcard/2.yuv";
        aVar.nDk = "/sdcard/2.mp4";
        aVar.nDh = "/sdcard/2.pcm";
        aVar.nDj = "/sdcard/2.x264";
        aVar.nDl = 0;
        aVar.iap = 0;
        aVar.nDm = 0;
        return aVar;
    }
}
