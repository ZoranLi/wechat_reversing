package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class atk extends avp {
    public int ksW;
    public int tce;
    public LinkedList<ati> teK = new LinkedList();
    public String tuo;

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
            if (this.tuo != null) {
                aVar.e(2, this.tuo);
            }
            aVar.eO(3, this.tce);
            aVar.eO(4, this.ksW);
            aVar.d(5, 8, this.teK);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(2, this.tuo);
            }
            return ((r0 + a.a.a.a.eL(3, this.tce)) + a.a.a.a.eL(4, this.ksW)) + a.a.a.a.c(5, 8, this.teK);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.teK.clear();
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
            atk com_tencent_mm_protocal_c_atk = (atk) objArr[1];
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
                        com_tencent_mm_protocal_c_atk.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atk.tuo = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_atk.tce = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_atk.ksW = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new ati();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atk.teK.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
