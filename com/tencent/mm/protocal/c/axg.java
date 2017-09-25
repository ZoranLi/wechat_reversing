package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class axg extends a {
    public int hAD;
    public String hAE;
    public String hAF;
    public String hAG;
    public int hAH;
    public String hAI;
    public String hAM;
    public avx tLj;
    public int tMP;
    public String tMQ;
    public String tMR;
    public String tMS;
    public int tMT;
    public my tMW;
    public String tqb;
    public String tqc;
    public avx ttp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.ttp != null) {
                    aVar.eQ(1, this.ttp.aUk());
                    this.ttp.a(aVar);
                }
                if (this.tLj != null) {
                    aVar.eQ(2, this.tLj.aUk());
                    this.tLj.a(aVar);
                }
                aVar.eO(3, this.hAD);
                if (this.hAE != null) {
                    aVar.e(4, this.hAE);
                }
                if (this.hAF != null) {
                    aVar.e(5, this.hAF);
                }
                if (this.hAG != null) {
                    aVar.e(6, this.hAG);
                }
                aVar.eO(7, this.hAH);
                aVar.eO(8, this.tMP);
                if (this.tMQ != null) {
                    aVar.e(9, this.tMQ);
                }
                if (this.tMR != null) {
                    aVar.e(10, this.tMR);
                }
                if (this.hAI != null) {
                    aVar.e(11, this.hAI);
                }
                if (this.tMS != null) {
                    aVar.e(12, this.tMS);
                }
                aVar.eO(13, this.tMT);
                if (this.hAM != null) {
                    aVar.e(14, this.hAM);
                }
                if (this.tMW != null) {
                    aVar.eQ(15, this.tMW.aUk());
                    this.tMW.a(aVar);
                }
                if (this.tqb != null) {
                    aVar.e(16, this.tqb);
                }
                if (this.tqc == null) {
                    return 0;
                }
                aVar.e(17, this.tqc);
                return 0;
            }
        } else if (i == 1) {
            if (this.ttp != null) {
                r0 = a.a.a.a.eN(1, this.ttp.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tLj != null) {
                r0 += a.a.a.a.eN(2, this.tLj.aUk());
            }
            r0 += a.a.a.a.eL(3, this.hAD);
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(4, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(5, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(6, this.hAG);
            }
            r0 = (r0 + a.a.a.a.eL(7, this.hAH)) + a.a.a.a.eL(8, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(9, this.tMQ);
            }
            if (this.tMR != null) {
                r0 += a.a.a.b.b.a.f(10, this.tMR);
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(11, this.hAI);
            }
            if (this.tMS != null) {
                r0 += a.a.a.b.b.a.f(12, this.tMS);
            }
            r0 += a.a.a.a.eL(13, this.tMT);
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(14, this.hAM);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(15, this.tMW.aUk());
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(16, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(17, this.tqc);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.tLj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axg com_tencent_mm_protocal_c_axg = (axg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axg.ttp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axg.tLj = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axg.hAD = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axg.hAE = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axg.hAF = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axg.hAG = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axg.hAH = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axg.tMP = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axg.tMQ = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axg.tMR = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_axg.hAI = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_axg.tMS = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_axg.tMT = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_axg.hAM = aVar3.xmD.readString();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new my();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axg.tMW = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_axg.tqb = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_axg.tqc = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
