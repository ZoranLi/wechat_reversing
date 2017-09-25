package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class alc extends avh {
    public int mtd;
    public String ohq;
    public int tFO;
    public String tOL;
    public String tOM;
    public String tON;
    public int tOO;
    public avw tOP;
    public int tOQ;
    public int tOR;
    public int tOS;
    public int tOT;
    public avw tOU;
    public int tOV;
    public int tOW;
    public int tOX;
    public int tOY;
    public int tOZ;
    public String tPa;
    public String tPb;
    public String tPc;
    public int tmW;
    public int tmX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tOP == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.tOU == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tOL != null) {
                    aVar.e(2, this.tOL);
                }
                if (this.tOM != null) {
                    aVar.e(3, this.tOM);
                }
                if (this.tON != null) {
                    aVar.e(4, this.tON);
                }
                aVar.eO(5, this.mtd);
                aVar.eO(6, this.tOO);
                if (this.tOP != null) {
                    aVar.eQ(7, this.tOP.aUk());
                    this.tOP.a(aVar);
                }
                aVar.eO(8, this.tOQ);
                aVar.eO(9, this.tOR);
                aVar.eO(10, this.tOS);
                aVar.eO(11, this.tOT);
                if (this.tOU != null) {
                    aVar.eQ(12, this.tOU.aUk());
                    this.tOU.a(aVar);
                }
                aVar.eO(13, this.tOV);
                aVar.eO(14, this.tOW);
                aVar.eO(15, this.tOX);
                aVar.eO(16, this.tOY);
                aVar.eO(17, this.tFO);
                aVar.eO(18, this.tOZ);
                if (this.tPa != null) {
                    aVar.e(19, this.tPa);
                }
                if (this.ohq != null) {
                    aVar.e(20, this.ohq);
                }
                aVar.eO(21, this.tmX);
                aVar.eO(22, this.tmW);
                if (this.tPb != null) {
                    aVar.e(23, this.tPb);
                }
                if (this.tPc == null) {
                    return 0;
                }
                aVar.e(24, this.tPc);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tOL != null) {
                r0 += a.a.a.b.b.a.f(2, this.tOL);
            }
            if (this.tOM != null) {
                r0 += a.a.a.b.b.a.f(3, this.tOM);
            }
            if (this.tON != null) {
                r0 += a.a.a.b.b.a.f(4, this.tON);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.mtd)) + a.a.a.a.eL(6, this.tOO);
            if (this.tOP != null) {
                r0 += a.a.a.a.eN(7, this.tOP.aUk());
            }
            r0 = (((r0 + a.a.a.a.eL(8, this.tOQ)) + a.a.a.a.eL(9, this.tOR)) + a.a.a.a.eL(10, this.tOS)) + a.a.a.a.eL(11, this.tOT);
            if (this.tOU != null) {
                r0 += a.a.a.a.eN(12, this.tOU.aUk());
            }
            r0 = (((((r0 + a.a.a.a.eL(13, this.tOV)) + a.a.a.a.eL(14, this.tOW)) + a.a.a.a.eL(15, this.tOX)) + a.a.a.a.eL(16, this.tOY)) + a.a.a.a.eL(17, this.tFO)) + a.a.a.a.eL(18, this.tOZ);
            if (this.tPa != null) {
                r0 += a.a.a.b.b.a.f(19, this.tPa);
            }
            if (this.ohq != null) {
                r0 += a.a.a.b.b.a.f(20, this.ohq);
            }
            r0 = (r0 + a.a.a.a.eL(21, this.tmX)) + a.a.a.a.eL(22, this.tmW);
            if (this.tPb != null) {
                r0 += a.a.a.b.b.a.f(23, this.tPb);
            }
            if (this.tPc != null) {
                r0 += a.a.a.b.b.a.f(24, this.tPc);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tOP == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.tOU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alc com_tencent_mm_protocal_c_alc = (alc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alc.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alc.tOL = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alc.tOM = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alc.tON = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alc.mtd = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alc.tOO = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alc.tOP = emVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_alc.tOQ = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_alc.tOR = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_alc.tOS = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_alc.tOT = aVar3.xmD.mL();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alc.tOU = emVar;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_alc.tOV = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_alc.tOW = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_alc.tOX = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_alc.tOY = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_alc.tFO = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_alc.tOZ = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_alc.tPa = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_alc.ohq = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_alc.tmX = aVar3.xmD.mL();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_alc.tmW = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_alc.tPb = aVar3.xmD.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_alc.tPc = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
