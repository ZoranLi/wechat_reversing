package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public class aba extends avp {
    public String mQZ;
    public LinkedList<bac> tGX = new LinkedList();
    public int tGY;
    public int tGZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.d(2, 8, this.tGX);
            if (this.mQZ != null) {
                aVar.e(3, this.mQZ);
            }
            aVar.eO(4, this.tGY);
            aVar.eO(5, this.tGZ);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.tGX);
            if (this.mQZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mQZ);
            }
            return (r0 + a.a.a.a.eL(4, this.tGY)) + a.a.a.a.eL(5, this.tGZ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tGX.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aba com_tencent_mm_protocal_c_aba = (aba) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aba.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bac();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aba.tGX.add(enVar);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aba.mQZ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aba.tGY = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aba.tGZ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
