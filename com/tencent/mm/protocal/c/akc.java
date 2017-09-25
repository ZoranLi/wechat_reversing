package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class akc extends avh {
    public String fTO;
    public String tNY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.fTO != null) {
                aVar.e(10, this.fTO);
            }
            if (this.tNY == null) {
                return 0;
            }
            aVar.e(20, this.tNY);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fTO != null) {
                r0 += a.a.a.b.b.a.f(10, this.fTO);
            }
            if (this.tNY != null) {
                r0 += a.a.a.b.b.a.f(20, this.tNY);
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
            akc com_tencent_mm_protocal_c_akc = (akc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.tYN = emVar;
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_akc.fTO = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_akc.tNY = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
