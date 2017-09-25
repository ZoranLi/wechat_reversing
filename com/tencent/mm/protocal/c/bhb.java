package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bhb extends avh {
    public String jNj;
    public int jOc;
    public String mtb;
    public int tfT;
    public int tgJ;
    public int tgK;
    public int tgL;
    public avw tsk;
    public String tuy;
    public String ugK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            aVar.eO(3, this.tfT);
            if (this.ugK != null) {
                aVar.e(4, this.ugK);
            }
            if (this.jNj != null) {
                aVar.e(5, this.jNj);
            }
            aVar.eO(6, this.tgJ);
            aVar.eO(7, this.tgK);
            aVar.eO(8, this.tgL);
            if (this.tsk != null) {
                aVar.eQ(9, this.tsk.aUk());
                this.tsk.a(aVar);
            }
            aVar.eO(10, this.jOc);
            if (this.tuy == null) {
                return 0;
            }
            aVar.e(11, this.tuy);
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
            r0 += a.a.a.a.eL(3, this.tfT);
            if (this.ugK != null) {
                r0 += a.a.a.b.b.a.f(4, this.ugK);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNj);
            }
            r0 = ((r0 + a.a.a.a.eL(6, this.tgJ)) + a.a.a.a.eL(7, this.tgK)) + a.a.a.a.eL(8, this.tgL);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(9, this.tsk.aUk());
            }
            r0 += a.a.a.a.eL(10, this.jOc);
            if (this.tuy != null) {
                r0 += a.a.a.b.b.a.f(11, this.tuy);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhb com_tencent_mm_protocal_c_bhb = (bhb) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhb.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhb.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhb.tfT = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhb.ugK = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhb.jNj = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhb.tgJ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhb.tgK = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhb.tgL = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhb.tsk = emVar;
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bhb.jOc = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bhb.tuy = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
