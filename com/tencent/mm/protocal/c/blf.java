package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class blf extends a {
    public int mOi;
    public blj ujn;
    public blj ujo;
    public int ukA;
    public bjy ukB;
    public bjy ukC;
    public int ukD;
    public int ukE;
    public int ukF;
    public int ukG;
    public avw ukH;
    public int ukI;
    public bjy ukJ;
    public int ukK;
    public int ukL;
    public int ukM;
    public int ukN;
    public int ukO;
    public int ukP;
    public avw ukQ;
    public avw ukR;
    public int ukS;
    public avw ukT;
    public int ukU;
    public int ukV;
    public int ukW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ujn == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.ujo == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.ujn != null) {
                    aVar.eQ(1, this.ujn.aUk());
                    this.ujn.a(aVar);
                }
                if (this.ujo != null) {
                    aVar.eQ(2, this.ujo.aUk());
                    this.ujo.a(aVar);
                }
                aVar.eO(3, this.ukA);
                if (this.ukB != null) {
                    aVar.eQ(4, this.ukB.aUk());
                    this.ukB.a(aVar);
                }
                if (this.ukC != null) {
                    aVar.eQ(5, this.ukC.aUk());
                    this.ukC.a(aVar);
                }
                aVar.eO(6, this.ukD);
                aVar.eO(7, this.ukE);
                aVar.eO(8, this.ukF);
                aVar.eO(9, this.ukG);
                if (this.ukH != null) {
                    aVar.eQ(10, this.ukH.aUk());
                    this.ukH.a(aVar);
                }
                aVar.eO(11, this.ukI);
                if (this.ukJ != null) {
                    aVar.eQ(12, this.ukJ.aUk());
                    this.ukJ.a(aVar);
                }
                aVar.eO(13, this.ukK);
                aVar.eO(14, this.ukL);
                aVar.eO(15, this.ukM);
                aVar.eO(16, this.ukN);
                aVar.eO(17, this.ukO);
                aVar.eO(18, this.mOi);
                aVar.eO(19, this.ukP);
                if (this.ukQ != null) {
                    aVar.eQ(20, this.ukQ.aUk());
                    this.ukQ.a(aVar);
                }
                if (this.ukR != null) {
                    aVar.eQ(21, this.ukR.aUk());
                    this.ukR.a(aVar);
                }
                aVar.eO(22, this.ukS);
                if (this.ukT != null) {
                    aVar.eQ(23, this.ukT.aUk());
                    this.ukT.a(aVar);
                }
                aVar.eO(24, this.ukU);
                aVar.eO(25, this.ukV);
                aVar.eO(26, this.ukW);
                return 0;
            }
        } else if (i == 1) {
            if (this.ujn != null) {
                r0 = a.a.a.a.eN(1, this.ujn.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ujo != null) {
                r0 += a.a.a.a.eN(2, this.ujo.aUk());
            }
            r0 += a.a.a.a.eL(3, this.ukA);
            if (this.ukB != null) {
                r0 += a.a.a.a.eN(4, this.ukB.aUk());
            }
            if (this.ukC != null) {
                r0 += a.a.a.a.eN(5, this.ukC.aUk());
            }
            r0 = (((r0 + a.a.a.a.eL(6, this.ukD)) + a.a.a.a.eL(7, this.ukE)) + a.a.a.a.eL(8, this.ukF)) + a.a.a.a.eL(9, this.ukG);
            if (this.ukH != null) {
                r0 += a.a.a.a.eN(10, this.ukH.aUk());
            }
            r0 += a.a.a.a.eL(11, this.ukI);
            if (this.ukJ != null) {
                r0 += a.a.a.a.eN(12, this.ukJ.aUk());
            }
            r0 = ((((((r0 + a.a.a.a.eL(13, this.ukK)) + a.a.a.a.eL(14, this.ukL)) + a.a.a.a.eL(15, this.ukM)) + a.a.a.a.eL(16, this.ukN)) + a.a.a.a.eL(17, this.ukO)) + a.a.a.a.eL(18, this.mOi)) + a.a.a.a.eL(19, this.ukP);
            if (this.ukQ != null) {
                r0 += a.a.a.a.eN(20, this.ukQ.aUk());
            }
            if (this.ukR != null) {
                r0 += a.a.a.a.eN(21, this.ukR.aUk());
            }
            r0 += a.a.a.a.eL(22, this.ukS);
            if (this.ukT != null) {
                r0 += a.a.a.a.eN(23, this.ukT.aUk());
            }
            return ((r0 + a.a.a.a.eL(24, this.ukU)) + a.a.a.a.eL(25, this.ukV)) + a.a.a.a.eL(26, this.ukW);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ujn == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.ujo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            blf com_tencent_mm_protocal_c_blf = (blf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_blj;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new blj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ujn = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new blj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ujo = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blf.ukA = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new bjy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ukB = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new bjy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ukC = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blf.ukD = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blf.ukE = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_blf.ukF = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_blf.ukG = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ukH = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_blf.ukI = aVar3.xmD.mL();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new bjy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ukJ = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_blf.ukK = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_blf.ukL = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_blf.ukM = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_blf.ukN = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_blf.ukO = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_blf.mOi = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_blf.ukP = aVar3.xmD.mL();
                    return 0;
                case 20:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ukQ = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 21:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ukR = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_blf.ukS = aVar3.xmD.mL();
                    return 0;
                case 23:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_blj = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blj.a(aVar4, com_tencent_mm_protocal_c_blj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blf.ukT = com_tencent_mm_protocal_c_blj;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_blf.ukU = aVar3.xmD.mL();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_blf.ukV = aVar3.xmD.mL();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_blf.ukW = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
