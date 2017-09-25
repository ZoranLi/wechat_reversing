package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aow extends a {
    public aox tTS;
    public int thX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tTS == null) {
                throw new b("Not all required fields were included: OplogRet");
            }
            aVar.eO(1, this.thX);
            if (this.tTS != null) {
                aVar.eQ(2, this.tTS.aUk());
                this.tTS.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.thX) + 0;
            if (this.tTS != null) {
                return r0 + a.a.a.a.eN(2, this.tTS.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tTS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: OplogRet");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aow com_tencent_mm_protocal_c_aow = (aow) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aow.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aox = new aox();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aox.a(aVar4, com_tencent_mm_protocal_c_aox, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aow.tTS = com_tencent_mm_protocal_c_aox;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
