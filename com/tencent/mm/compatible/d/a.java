package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public boolean gNN = false;
    public int gNO;
    public int gNP;
    public int gNQ;
    public int gNR;
    public int gNS;
    public int gNT;
    public int gNU;
    public int gNV;
    public int gNW;
    public int gNX;
    public int gNY;
    public int gNZ;
    public int gOA;
    public int gOB;
    public int gOC;
    public int gOD;
    public int gOE;
    public int gOF;
    public int gOG;
    public short[] gOH = new short[15];
    public short[] gOI = new short[2];
    public boolean gOJ;
    public int gOK;
    public boolean gOL = false;
    public int gOM;
    public int gON;
    public int gOO;
    public int gOP;
    public int gOQ;
    public int gOR;
    public int gOS;
    public int gOT;
    public int gOU;
    public int gOV;
    public int gOa;
    public int gOb;
    public int gOc;
    public int gOd;
    public int gOe;
    public int gOf;
    public int gOg;
    public int gOh;
    public int gOi;
    public int gOj;
    public int gOk;
    public int gOl;
    public int gOm;
    public int gOn;
    public int gOo;
    public int gOp;
    public int gOq;
    public boolean gOr;
    public int gOs;
    public int gOt;
    public int gOu;
    public int gOv;
    public int gOw;
    public int gOx;
    public int gOy;
    public int gOz;

    public a() {
        reset();
    }

    public final void reset() {
        this.gNN = false;
        this.gNO = -1;
        this.gNP = -1;
        this.gNQ = -1;
        this.gNR = -1;
        this.gNS = -1;
        this.gNT = -1;
        this.gNU = -1;
        this.gNW = -1;
        this.gNV = -1;
        this.gOz = -1;
        this.gNX = -1;
        this.gNY = -1;
        this.gNZ = -1;
        this.gOk = -1;
        this.gOl = -1;
        this.gOm = -1;
        this.gOn = -1;
        this.gOo = -1;
        this.gOp = -1;
        this.gOq = -1;
        this.gOr = false;
        this.gOs = -1;
        this.gOt = -1;
        this.gOv = -1;
        this.gOu = -1;
        this.gOy = -1;
        this.gOw = -1;
        this.gOx = -1;
        this.gOA = -1;
        this.gOB = -1;
        this.gOC = -1;
        this.gOD = -1;
        this.gOa = -1;
        this.gOb = -1;
        this.gOc = -1;
        this.gOd = -1;
        this.gOg = -1;
        this.gOh = -1;
        this.gOi = -1;
        this.gOj = -1;
        this.gOE = 0;
        this.gOF = 0;
        this.gOG = -1;
        this.gOf = -1;
        this.gOe = -1;
        this.gOJ = false;
        this.gOI[0] = (short) -1;
        this.gOI[1] = (short) -1;
        this.gOK = -1;
        this.gOS = -1;
        this.gOT = -1;
        this.gOU = -1;
        this.gOV = -1;
    }

    public final boolean qX() {
        if ((this.gNP < 0 || this.gNQ >= 0) && ((this.gNP >= 0 || this.gNQ < 0) && this.gNR <= 0)) {
            return false;
        }
        return true;
    }

    public final boolean qY() {
        return this.gNS >= 0;
    }

    public final boolean qZ() {
        return this.gNT >= 0;
    }

    public final int ra() {
        if (!qY()) {
            return -1;
        }
        int i = (this.gNS & 224) >> 5;
        w.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean rb() {
        if (!qY()) {
            return false;
        }
        boolean z;
        int i = this.gNS & 16;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        w.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int rc() {
        if (!qY()) {
            return -1;
        }
        int i = (this.gNS & 14) >> 1;
        w.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean rd() {
        if (!qY()) {
            return false;
        }
        boolean z;
        int i = this.gNS & 1;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        w.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int re() {
        if (!qZ()) {
            return -1;
        }
        int i = (this.gNT & 224) >> 5;
        w.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final int rf() {
        if (!qZ()) {
            return -1;
        }
        int i = (this.gNT & 14) >> 1;
        w.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final void dump() {
        w.d("VoipAudioInfo", "streamtype " + this.gNO);
        w.d("VoipAudioInfo", "smode " + this.gNP);
        w.d("VoipAudioInfo", "omode " + this.gNQ);
        w.d("VoipAudioInfo", "ospeaker " + this.gNR);
        w.d("VoipAudioInfo", "operating" + this.gNS);
        w.d("VoipAudioInfo", "moperating" + this.gNT);
        w.d("VoipAudioInfo", "mstreamtype" + this.gNU);
        w.d("VoipAudioInfo", "mVoiceRecordMode" + this.gNV);
        w.d("VoipAudioInfo", "agcMode :" + this.gOz);
        w.d("VoipAudioInfo", "nsMode:" + this.gNY);
        w.d("VoipAudioInfo", "aecMode:" + this.gNX);
        w.d("VoipAudioInfo", "volumMode:" + this.gNZ);
        w.d("VoipAudioInfo", "micMode:" + this.gOk);
        w.d("VoipAudioInfo", "sourceMode:" + this.gOl);
        w.d("VoipAudioInfo", "speakerMode:" + this.gOm);
        w.d("VoipAudioInfo", "phoneMode:" + this.gOn);
        w.d("VoipAudioInfo", "voipstreamType:" + this.gOo);
        w.d("VoipAudioInfo", "speakerstreamtype:" + this.gOp);
        w.d("VoipAudioInfo", "phonestreamtype:" + this.gOq);
        w.d("VoipAudioInfo", "ringphonestream:" + this.gOs);
        w.d("VoipAudioInfo", "ringphonemode:" + this.gOt);
        w.d("VoipAudioInfo", "ringspeakerstream:" + this.gOu);
        w.d("VoipAudioInfo", "ringspeakermode:" + this.gOv);
        w.d("VoipAudioInfo", "agcModeNew :" + this.gOy);
        w.d("VoipAudioInfo", "nsModeNew:" + this.gOx);
        w.d("VoipAudioInfo", "aecModeNew:" + this.gOw);
        w.d("VoipAudioInfo", "agctargetdb:" + this.gOA);
        w.d("VoipAudioInfo", "agcgaindb:" + this.gOB);
        w.d("VoipAudioInfo", "agcflag:" + this.gOC);
        w.d("VoipAudioInfo", "agclimiter:" + this.gOD);
        w.d("VoipAudioInfo", "inputVolumeScale:" + this.gOa);
        w.d("VoipAudioInfo", "outputVolumeScale:" + this.gOb);
        w.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.gOc);
        w.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.gOd);
        w.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.gOg);
        w.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.gOh);
        w.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.gOi);
        w.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.gOj);
        w.d("VoipAudioInfo", "enableRecTimer:" + this.gOE);
        w.d("VoipAudioInfo", "enablePlayTimer:" + this.gOF);
        w.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.gOG);
        w.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.gOe);
        w.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.gOf);
        w.d("VoipAudioInfo", "noisegateon" + this.gOJ);
        w.d("VoipAudioInfo", "noisegatestrength[0]" + this.gOI[0]);
        w.d("VoipAudioInfo", "noisegatestrength[1]" + this.gOI[1]);
        w.d("VoipAudioInfo", "spkecenable:" + this.gOK);
        w.d("VoipAudioInfo", "agcRxFlag:" + this.gOS);
        w.d("VoipAudioInfo", "agcRxTargetdb:" + this.gOT);
        w.d("VoipAudioInfo", "agcRxGaindb:" + this.gOU);
        w.d("VoipAudioInfo", "agcRxLimiter:" + this.gOV);
    }
}
