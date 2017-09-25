package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class biq extends a {
    public String tgG;
    public aqv uiu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uiu == null) {
                throw new b("Not all required fields were included: Position");
            }
            if (this.tgG != null) {
                aVar.e(1, this.tgG);
            }
            if (this.uiu == null) {
                return 0;
            }
            aVar.eQ(2, this.uiu.aUk());
            this.uiu.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tgG != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgG) + 0;
            } else {
                r0 = 0;
            }
            if (this.uiu != null) {
                r0 += a.a.a.a.eN(2, this.uiu.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uiu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Position");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            biq com_tencent_mm_protocal_c_biq = (biq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_biq.tgG = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aqv = new aqv();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aqv.a(aVar4, com_tencent_mm_protocal_c_aqv, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biq.uiu = com_tencent_mm_protocal_c_aqv;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
