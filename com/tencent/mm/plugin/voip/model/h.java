package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.b.a;

public final class h {
    long beginTime = 0;
    public int rgD;
    public int rgE;
    public int rgF;
    public int rgG;
    byte rgH;
    byte rgI;
    byte rgJ;
    byte rgK;
    byte rgL;
    byte rgM;
    byte rgN;
    int rgO;
    public int rgP;
    public int rgQ;
    public int rgR;
    public int rgS;
    public int rgT;
    public int rgU;
    public int rgV;
    int rgW;
    int rgX;
    int rgY;
    int rgZ;
    int rha;
    int rhb;
    int rhc;
    int rhd;
    public long rhe;
    long rhf;
    long rhg;
    long rhh;
    long rhi;
    public long rhj;
    long rhk;
    long rhl;
    long rhm;

    public h() {
        reset();
        bpy();
    }

    public final void bpx() {
        if (this.rhj == 0) {
            this.rgZ = 0;
        } else {
            this.rgZ = (int) (System.currentTimeMillis() - this.rhj);
        }
        a.dJ("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
        a.dJ("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.rgZ);
    }

    public final void reset() {
        this.beginTime = 0;
        this.rgD = 0;
        this.rgE = 0;
        this.rgF = 0;
        this.rgG = 0;
        this.rgH = (byte) 0;
        this.rgI = (byte) 0;
        this.rgJ = (byte) 0;
        this.rgK = (byte) 0;
        this.rgL = (byte) 0;
        this.rgM = (byte) 0;
        this.rgN = (byte) 0;
        this.rgO = 0;
    }

    public final void bpy() {
        this.rhe = 0;
        this.rhi = 0;
        this.rhj = 0;
        this.rhk = 0;
        this.rhl = 0;
        this.rhm = 0;
        this.rhf = 0;
        this.rhg = 0;
        this.rhh = 0;
        this.rgP = 0;
        this.rgQ = 0;
        this.rgR = 0;
        this.rgS = 0;
        this.rgT = 0;
        this.rgU = 0;
        this.rgV = 0;
        this.rgW = 0;
        this.rgX = 0;
        this.rgY = 0;
        this.rgZ = 0;
        this.rha = 0;
        this.rhb = 0;
        this.rhc = 0;
        this.rhd = 0;
    }

    public final String bpz() {
        return "," + this.rgN;
    }
}
