package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class apv extends avh {
    public String tUQ;
    public String tUR;
    public b tUS;
    public int tUT;
    public int tUU;
    public int tcg;
    public at tnu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tUQ != null) {
                aVar.e(2, this.tUQ);
            }
            if (this.tUR != null) {
                aVar.e(3, this.tUR);
            }
            if (this.tUS != null) {
                aVar.b(4, this.tUS);
            }
            aVar.eO(5, this.tUT);
            aVar.eO(6, this.tcg);
            aVar.eO(7, this.tUU);
            if (this.tnu == null) {
                return 0;
            }
            aVar.eQ(8, this.tnu.aUk());
            this.tnu.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tUQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tUQ);
            }
            if (this.tUR != null) {
                r0 += a.a.a.b.b.a.f(3, this.tUR);
            }
            if (this.tUS != null) {
                r0 += a.a.a.a.a(4, this.tUS);
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.tUT)) + a.a.a.a.eL(6, this.tcg)) + a.a.a.a.eL(7, this.tUU);
            if (this.tnu != null) {
                r0 += a.a.a.a.eN(8, this.tnu.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            apv com_tencent_mm_protocal_c_apv = (apv) objArr[1];
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
                        com_tencent_mm_protocal_c_apv.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apv.tUQ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apv.tUR = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apv.tUS = aVar3.cic();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apv.tUT = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apv.tcg = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_apv.tUU = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apv.tnu = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
