package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.sdk.platformtools.w;

public final class o {
    public int gRq = 1;
    public int hzY;
    public VideoTransPara nAE;
    public int nBn = -1;
    public boolean nCI = false;
    public int nCU = -1;
    public boolean nCV = false;
    public boolean nCW = false;
    public boolean nCX = true;
    b nCY;

    public static o a(int i, VideoTransPara videoTransPara) {
        o oVar;
        switch (i) {
            case 1:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
                oVar = new o(2, videoTransPara);
                oVar.nCW = false;
                break;
            case 2:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
                oVar = new o(2, videoTransPara);
                oVar.nCW = false;
                oVar = oVar.aKT().aKS();
                break;
            case 3:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
                oVar = new o(1, videoTransPara);
                oVar.nCW = false;
                break;
            case 4:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
                oVar = new o(1, videoTransPara);
                oVar.nCW = false;
                oVar = oVar.aKT().aKS();
                break;
            case 5:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
                oVar = new o(2, videoTransPara);
                oVar.nCW = false;
                oVar = oVar.aKS();
                break;
            case 6:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
                oVar = new o(1, videoTransPara);
                oVar.nCW = false;
                oVar = oVar.aKS();
                break;
            case 7:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
                oVar = new o(2, videoTransPara);
                oVar.nCW = true;
                oVar = oVar.aKU();
                oVar.nCV = false;
                break;
            case 8:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
                oVar = new o(2, videoTransPara);
                oVar.nCW = true;
                oVar = oVar.aKU();
                oVar.nCV = true;
                break;
            case 9:
                oVar = new o(1, videoTransPara);
                oVar.nCW = true;
                oVar = oVar.aKU();
                oVar.nCV = false;
                break;
            case 10:
                w.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                oVar = new o(1, videoTransPara);
                oVar.nCW = true;
                oVar = oVar.aKU();
                oVar.nCV = true;
                break;
            default:
                return null;
        }
        if (oVar == null) {
            return oVar;
        }
        oVar.nCU = i;
        return oVar;
    }

    private o(int i, VideoTransPara videoTransPara) {
        this.nAE = videoTransPara;
        this.gRq = i;
        this.hzY = videoTransPara.hzY;
        this.nBn = videoTransPara.width;
    }

    public final o aKS() {
        this.nBn = 720;
        return this;
    }

    public final o aKT() {
        this.hzY = this.nAE.hzY * 2;
        return this;
    }

    public final o aKU() {
        this.nBn = this.nAE.width * 2;
        return this;
    }

    public final boolean aKV() {
        return this.nAE.width < this.nBn;
    }

    public final String toString() {
        return String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[]{Integer.valueOf(this.gRq), Integer.valueOf(this.hzY), Boolean.valueOf(this.nCI), Boolean.valueOf(this.nCV), Boolean.valueOf(this.nCW), Integer.valueOf(this.nBn), this.nAE});
    }
}
