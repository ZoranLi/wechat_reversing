package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import java.util.LinkedList;

public final class bil extends a {
    public String gkP;
    public String hAN;
    public bcp tMV;
    public String tQM;
    public String tQN;
    public int tdE;
    public ajj tfr;
    public awa tjQ;
    public String tjl;
    public String tqb;
    public String tqc;
    public String uhW;
    public String uhX;
    public int uhY;
    public int uhZ;
    public int uia;
    public String uib;
    public int uic;
    public avx uie;
    public int uif;
    public String uig;
    public String uih;
    public String uii;
    public String uij;
    public String uik;
    public apd uil;
    public String uim;
    public int uio;
    public int uip;
    public long uiq;
    public String uir;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tMV == null) {
                throw new b("Not all required fields were included: SnsUserInfo");
            }
            if (this.tMV != null) {
                aVar.eQ(1, this.tMV.aUk());
                this.tMV.a(aVar);
            }
            if (this.hAN != null) {
                aVar.e(2, this.hAN);
            }
            if (this.uhW != null) {
                aVar.e(3, this.uhW);
            }
            if (this.uhX != null) {
                aVar.e(4, this.uhX);
            }
            aVar.eO(5, this.uhY);
            aVar.eO(6, this.uhZ);
            aVar.eO(7, this.uia);
            if (this.uib != null) {
                aVar.e(8, this.uib);
            }
            if (this.tqb != null) {
                aVar.e(9, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(10, this.tqc);
            }
            aVar.eO(11, this.uic);
            if (this.uie != null) {
                aVar.eQ(12, this.uie.aUk());
                this.uie.a(aVar);
            }
            if (this.tjQ != null) {
                aVar.eQ(13, this.tjQ.aUk());
                this.tjQ.a(aVar);
            }
            aVar.eO(14, this.tdE);
            aVar.eO(15, this.uif);
            if (this.tjl != null) {
                aVar.e(16, this.tjl);
            }
            if (this.tQM != null) {
                aVar.e(17, this.tQM);
            }
            if (this.tQN != null) {
                aVar.e(18, this.tQN);
            }
            if (this.uig != null) {
                aVar.e(19, this.uig);
            }
            if (this.uih != null) {
                aVar.e(20, this.uih);
            }
            if (this.uii != null) {
                aVar.e(21, this.uii);
            }
            if (this.uij != null) {
                aVar.e(22, this.uij);
            }
            if (this.tfr != null) {
                aVar.eQ(23, this.tfr.aUk());
                this.tfr.a(aVar);
            }
            if (this.uik != null) {
                aVar.e(24, this.uik);
            }
            if (this.uil != null) {
                aVar.eQ(25, this.uil.aUk());
                this.uil.a(aVar);
            }
            if (this.uim != null) {
                aVar.e(26, this.uim);
            }
            aVar.eO(27, this.uio);
            if (this.gkP != null) {
                aVar.e(28, this.gkP);
            }
            aVar.eO(29, this.uip);
            aVar.O(30, this.uiq);
            if (this.uir == null) {
                return 0;
            }
            aVar.e(31, this.uir);
            return 0;
        } else if (i == 1) {
            if (this.tMV != null) {
                r0 = a.a.a.a.eN(1, this.tMV.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(2, this.hAN);
            }
            if (this.uhW != null) {
                r0 += a.a.a.b.b.a.f(3, this.uhW);
            }
            if (this.uhX != null) {
                r0 += a.a.a.b.b.a.f(4, this.uhX);
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.uhY)) + a.a.a.a.eL(6, this.uhZ)) + a.a.a.a.eL(7, this.uia);
            if (this.uib != null) {
                r0 += a.a.a.b.b.a.f(8, this.uib);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(9, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(10, this.tqc);
            }
            r0 += a.a.a.a.eL(11, this.uic);
            if (this.uie != null) {
                r0 += a.a.a.a.eN(12, this.uie.aUk());
            }
            if (this.tjQ != null) {
                r0 += a.a.a.a.eN(13, this.tjQ.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(14, this.tdE)) + a.a.a.a.eL(15, this.uif);
            if (this.tjl != null) {
                r0 += a.a.a.b.b.a.f(16, this.tjl);
            }
            if (this.tQM != null) {
                r0 += a.a.a.b.b.a.f(17, this.tQM);
            }
            if (this.tQN != null) {
                r0 += a.a.a.b.b.a.f(18, this.tQN);
            }
            if (this.uig != null) {
                r0 += a.a.a.b.b.a.f(19, this.uig);
            }
            if (this.uih != null) {
                r0 += a.a.a.b.b.a.f(20, this.uih);
            }
            if (this.uii != null) {
                r0 += a.a.a.b.b.a.f(21, this.uii);
            }
            if (this.uij != null) {
                r0 += a.a.a.b.b.a.f(22, this.uij);
            }
            if (this.tfr != null) {
                r0 += a.a.a.a.eN(23, this.tfr.aUk());
            }
            if (this.uik != null) {
                r0 += a.a.a.b.b.a.f(24, this.uik);
            }
            if (this.uil != null) {
                r0 += a.a.a.a.eN(25, this.uil.aUk());
            }
            if (this.uim != null) {
                r0 += a.a.a.b.b.a.f(26, this.uim);
            }
            r0 += a.a.a.a.eL(27, this.uio);
            if (this.gkP != null) {
                r0 += a.a.a.b.b.a.f(28, this.gkP);
            }
            r0 = (r0 + a.a.a.a.eL(29, this.uip)) + a.a.a.a.N(30, this.uiq);
            if (this.uir != null) {
                r0 += a.a.a.b.b.a.f(31, this.uir);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tMV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsUserInfo");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bil com_tencent_mm_protocal_c_bil = (bil) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bcp;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new bcp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bil.tMV = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bil.hAN = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bil.uhW = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bil.uhX = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bil.uhY = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bil.uhZ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bil.uia = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bil.uib = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bil.tqb = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bil.tqc = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bil.uic = aVar3.xmD.mL();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bil.uie = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new awa();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bil.tjQ = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bil.tdE = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bil.uif = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bil.tjl = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bil.tQM = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bil.tQN = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bil.uig = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bil.uih = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bil.uii = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bil.uij = aVar3.xmD.readString();
                    return 0;
                case 23:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new ajj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bil.tfr = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bil.uik = aVar3.xmD.readString();
                    return 0;
                case 25:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new apd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bil.uil = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bil.uim = aVar3.xmD.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bil.uio = aVar3.xmD.mL();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bil.gkP = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_bil.uip = aVar3.xmD.mL();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bil.uiq = aVar3.xmD.mM();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    com_tencent_mm_protocal_c_bil.uir = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
