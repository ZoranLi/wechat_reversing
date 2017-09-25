package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class awu extends a {
    public avw tDW;
    public String tDX;
    public long tDZ;
    public int tiJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tDX == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.eO(1, this.tiJ);
            if (this.tDX != null) {
                aVar.e(2, this.tDX);
            }
            if (this.tDW != null) {
                aVar.eQ(3, this.tDW.aUk());
                this.tDW.a(aVar);
            }
            aVar.O(4, this.tDZ);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tiJ) + 0;
            if (this.tDX != null) {
                r0 += a.a.a.b.b.a.f(2, this.tDX);
            }
            if (this.tDW != null) {
                r0 += a.a.a.a.eN(3, this.tDW.aUk());
            }
            return r0 + a.a.a.a.N(4, this.tDZ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tDX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awu com_tencent_mm_protocal_c_awu = (awu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_awu.tiJ = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awu.tDX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awu.tDW = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awu.tDZ = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
