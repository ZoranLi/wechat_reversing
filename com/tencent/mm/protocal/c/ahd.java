package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ahd extends avh {
    public String mtb;
    public LinkedList<String> tLH = new LinkedList();
    public int tLI;
    public int tLJ;
    public bqo tLK;
    public int tLM;
    public String tLN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            aVar.d(3, 1, this.tLH);
            aVar.eO(4, this.tLM);
            if (this.tLN != null) {
                aVar.e(6, this.tLN);
            }
            aVar.eO(7, this.tLI);
            aVar.eO(8, this.tLJ);
            if (this.tLK == null) {
                return 0;
            }
            aVar.eQ(9, this.tLK.aUk());
            this.tLK.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            r0 = (r0 + a.a.a.a.c(3, 1, this.tLH)) + a.a.a.a.eL(4, this.tLM);
            if (this.tLN != null) {
                r0 += a.a.a.b.b.a.f(6, this.tLN);
            }
            r0 = (r0 + a.a.a.a.eL(7, this.tLI)) + a.a.a.a.eL(8, this.tLJ);
            if (this.tLK != null) {
                r0 += a.a.a.a.eN(9, this.tLK.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tLH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ahd com_tencent_mm_protocal_c_ahd = (ahd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahd.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahd.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahd.tLH.add(aVar3.xmD.readString());
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahd.tLM = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ahd.tLN = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ahd.tLI = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ahd.tLJ = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bqo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahd.tLK = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
