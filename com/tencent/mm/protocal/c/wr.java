package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class wr extends a {
    public avx tDp;
    public int tDq;
    public int tDr;
    public int tDs = 1;
    public int tDt;
    public int tfl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tDp == null) {
                throw new b("Not all required fields were included: ChatroomId");
            }
            if (this.tDp != null) {
                aVar.eQ(1, this.tDp.aUk());
                this.tDp.a(aVar);
            }
            aVar.eO(2, this.tfl);
            aVar.eO(3, this.tDq);
            aVar.eO(4, this.tDr);
            aVar.eO(5, this.tDs);
            aVar.eO(6, this.tDt);
            return 0;
        } else if (i == 1) {
            if (this.tDp != null) {
                r0 = a.a.a.a.eN(1, this.tDp.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return ((((r0 + a.a.a.a.eL(2, this.tfl)) + a.a.a.a.eL(3, this.tDq)) + a.a.a.a.eL(4, this.tDr)) + a.a.a.a.eL(5, this.tDs)) + a.a.a.a.eL(6, this.tDt);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tDp != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ChatroomId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            wr wrVar = (wr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avx = new avx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        wrVar.tDp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    wrVar.tfl = aVar3.xmD.mL();
                    return 0;
                case 3:
                    wrVar.tDq = aVar3.xmD.mL();
                    return 0;
                case 4:
                    wrVar.tDr = aVar3.xmD.mL();
                    return 0;
                case 5:
                    wrVar.tDs = aVar3.xmD.mL();
                    return 0;
                case 6:
                    wrVar.tDt = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
