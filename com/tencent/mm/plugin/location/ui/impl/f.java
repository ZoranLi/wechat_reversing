package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.c.aoy;

public final class f {
    public double aKd;
    public double aKe;
    public String mName;
    public String nhT;
    public String nhU;
    public String nhV;
    public String nhW;
    public String nhX;
    public String nhY;
    public String nhZ;
    public String nia;
    public String nib;
    public String nic;
    public Addr nid;
    public String nie;
    public String nif;
    public int type;

    public f(aoy com_tencent_mm_protocal_c_aoy, String str) {
        this.mName = com_tencent_mm_protocal_c_aoy.msj;
        this.nhT = com_tencent_mm_protocal_c_aoy.tTU;
        this.aKe = com_tencent_mm_protocal_c_aoy.tld;
        this.aKd = com_tencent_mm_protocal_c_aoy.tle;
        this.nhU = com_tencent_mm_protocal_c_aoy.tTV;
        this.nhV = com_tencent_mm_protocal_c_aoy.nXf;
        this.nhW = com_tencent_mm_protocal_c_aoy.tTW;
        this.nhX = com_tencent_mm_protocal_c_aoy.hAE;
        this.nhY = com_tencent_mm_protocal_c_aoy.hAF;
        this.nhZ = com_tencent_mm_protocal_c_aoy.tth;
        this.nia = com_tencent_mm_protocal_c_aoy.tti;
        this.nib = com_tencent_mm_protocal_c_aoy.tTX;
        this.nie = str;
        this.nid = new Addr();
        this.nid.hCE = this.nhT;
        this.nid.hCG = this.nhY;
        this.nid.hCH = this.nhY;
        this.nid.hCI = this.nhZ;
        this.nid.hCK = this.nib;
        this.nid.hCN = this.mName;
        this.nid.hCF = this.nhX;
        this.nid.hCQ = (float) com_tencent_mm_protocal_c_aoy.tld;
        this.nid.hCP = (float) com_tencent_mm_protocal_c_aoy.tle;
        this.type = 0;
    }
}
