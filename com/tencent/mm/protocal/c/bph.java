package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bph extends a {
    public String tky;
    public String tup;
    public String umt;
    public int unF;
    public int unG;
    public String unK;
    public bpa unL;
    public bpg unM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.unK == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.umt == null) {
                throw new b("Not all required fields were included: Charset");
            } else {
                if (this.unK != null) {
                    aVar.e(4, this.unK);
                }
                if (this.umt != null) {
                    aVar.e(12, this.umt);
                }
                if (this.unL != null) {
                    aVar.eQ(9, this.unL.aUk());
                    this.unL.a(aVar);
                }
                if (this.unM != null) {
                    aVar.eQ(10, this.unM.aUk());
                    this.unM.a(aVar);
                }
                if (this.tup != null) {
                    aVar.e(5, this.tup);
                }
                if (this.tky != null) {
                    aVar.e(6, this.tky);
                }
                aVar.eO(7, this.unF);
                aVar.eO(8, this.unG);
                return 0;
            }
        } else if (i == 1) {
            if (this.unK != null) {
                r0 = a.a.a.b.b.a.f(4, this.unK) + 0;
            } else {
                r0 = 0;
            }
            if (this.umt != null) {
                r0 += a.a.a.b.b.a.f(12, this.umt);
            }
            if (this.unL != null) {
                r0 += a.a.a.a.eN(9, this.unL.aUk());
            }
            if (this.unM != null) {
                r0 += a.a.a.a.eN(10, this.unM.aUk());
            }
            if (this.tup != null) {
                r0 += a.a.a.b.b.a.f(5, this.tup);
            }
            if (this.tky != null) {
                r0 += a.a.a.b.b.a.f(6, this.tky);
            }
            return (r0 + a.a.a.a.eL(7, this.unF)) + a.a.a.a.eL(8, this.unG);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.unK == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.umt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Charset");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bph com_tencent_mm_protocal_c_bph = (bph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bpa;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 4:
                    com_tencent_mm_protocal_c_bph.unK = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bph.tup = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bph.tky = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bph.unF = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bph.unG = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bpa = new bpa();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bpa.a(aVar4, com_tencent_mm_protocal_c_bpa, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bph.unL = com_tencent_mm_protocal_c_bpa;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bpa = new bpg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bpa.a(aVar4, com_tencent_mm_protocal_c_bpa, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bph.unM = com_tencent_mm_protocal_c_bpa;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bph.umt = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
