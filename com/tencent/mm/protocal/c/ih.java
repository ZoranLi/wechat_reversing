package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ih extends avh {
    public String mvU;
    public String mvV;
    public int tdM;
    public int tfW;
    public String tfi;
    public String tmV;
    public int tmW;
    public int tmX;
    public avw tmY;
    public float tmZ;
    public float tna;
    public String tnb;
    public int tnc;
    public int tnd;
    public int tne;
    public int tnf;
    public String tng;
    public int tnh;
    public int tni;
    public int tnj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tmV != null) {
                aVar.e(1, this.tmV);
            }
            if (this.mvV != null) {
                aVar.e(2, this.mvV);
            }
            if (this.mvU != null) {
                aVar.e(3, this.mvU);
            }
            aVar.eO(4, this.tmW);
            aVar.eO(5, this.tmX);
            if (this.tfi != null) {
                aVar.e(6, this.tfi);
            }
            if (this.tmY != null) {
                aVar.eQ(7, this.tmY.aUk());
                this.tmY.a(aVar);
            }
            aVar.eO(8, this.tdM);
            aVar.n(9, this.tmZ);
            aVar.n(10, this.tna);
            if (this.tnb != null) {
                aVar.e(11, this.tnb);
            }
            aVar.eO(12, this.tnc);
            aVar.eO(13, this.tnd);
            aVar.eO(14, this.tne);
            aVar.eO(15, this.tnf);
            if (this.tng != null) {
                aVar.e(16, this.tng);
            }
            aVar.eO(17, this.tnh);
            aVar.eO(18, this.tni);
            aVar.eO(19, this.tnj);
            aVar.eO(20, this.tfW);
            return 0;
        } else if (i == 1) {
            if (this.tmV != null) {
                r0 = a.a.a.b.b.a.f(1, this.tmV) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvV);
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvU);
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tmW)) + a.a.a.a.eL(5, this.tmX);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(6, this.tfi);
            }
            if (this.tmY != null) {
                r0 += a.a.a.a.eN(7, this.tmY.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(8, this.tdM)) + (a.a.a.b.b.a.cH(9) + 4)) + (a.a.a.b.b.a.cH(10) + 4);
            if (this.tnb != null) {
                r0 += a.a.a.b.b.a.f(11, this.tnb);
            }
            r0 = (((r0 + a.a.a.a.eL(12, this.tnc)) + a.a.a.a.eL(13, this.tnd)) + a.a.a.a.eL(14, this.tne)) + a.a.a.a.eL(15, this.tnf);
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(16, this.tng);
            }
            return (((r0 + a.a.a.a.eL(17, this.tnh)) + a.a.a.a.eL(18, this.tni)) + a.a.a.a.eL(19, this.tnj)) + a.a.a.a.eL(20, this.tfW);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ih ihVar = (ih) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ihVar.tmV = aVar3.xmD.readString();
                    return 0;
                case 2:
                    ihVar.mvV = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ihVar.mvU = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ihVar.tmW = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ihVar.tmX = aVar3.xmD.mL();
                    return 0;
                case 6:
                    ihVar.tfi = aVar3.xmD.readString();
                    return 0;
                case 7:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ihVar.tmY = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 8:
                    ihVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 9:
                    ihVar.tmZ = aVar3.xmD.readFloat();
                    return 0;
                case 10:
                    ihVar.tna = aVar3.xmD.readFloat();
                    return 0;
                case 11:
                    ihVar.tnb = aVar3.xmD.readString();
                    return 0;
                case 12:
                    ihVar.tnc = aVar3.xmD.mL();
                    return 0;
                case 13:
                    ihVar.tnd = aVar3.xmD.mL();
                    return 0;
                case 14:
                    ihVar.tne = aVar3.xmD.mL();
                    return 0;
                case 15:
                    ihVar.tnf = aVar3.xmD.mL();
                    return 0;
                case 16:
                    ihVar.tng = aVar3.xmD.readString();
                    return 0;
                case 17:
                    ihVar.tnh = aVar3.xmD.mL();
                    return 0;
                case 18:
                    ihVar.tni = aVar3.xmD.mL();
                    return 0;
                case 19:
                    ihVar.tnj = aVar3.xmD.mL();
                    return 0;
                case 20:
                    ihVar.tfW = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
