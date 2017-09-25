package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bdc extends a {
    public int udS;
    public bjx udT;
    public int ueo;
    public int uep;
    public int ueq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.udT == null) {
                throw new b("Not all required fields were included: Addr");
            }
            if (this.udT != null) {
                aVar.eQ(1, this.udT.aUk());
                this.udT.a(aVar);
            }
            aVar.eO(2, this.udS);
            aVar.eO(3, this.ueo);
            aVar.eO(4, this.uep);
            aVar.eO(5, this.ueq);
            return 0;
        } else if (i == 1) {
            if (this.udT != null) {
                r0 = a.a.a.a.eN(1, this.udT.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.eL(2, this.udS)) + a.a.a.a.eL(3, this.ueo)) + a.a.a.a.eL(4, this.uep)) + a.a.a.a.eL(5, this.ueq);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.udT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bdc com_tencent_mm_protocal_c_bdc = (bdc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bjx = new bjx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bjx.a(aVar4, com_tencent_mm_protocal_c_bjx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdc.udT = com_tencent_mm_protocal_c_bjx;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdc.udS = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdc.ueo = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdc.uep = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdc.ueq = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
