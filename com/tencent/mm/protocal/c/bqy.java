package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bqy extends avh {
    public String leO;
    public int msn;
    public String thA;
    public String uoV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.leO != null) {
                aVar.e(2, this.leO);
            }
            if (this.thA != null) {
                aVar.e(3, this.thA);
            }
            if (this.uoV != null) {
                aVar.e(4, this.uoV);
            }
            aVar.eO(5, this.msn);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(2, this.leO);
            }
            if (this.thA != null) {
                r0 += a.a.a.b.b.a.f(3, this.thA);
            }
            if (this.uoV != null) {
                r0 += a.a.a.b.b.a.f(4, this.uoV);
            }
            return r0 + a.a.a.a.eL(5, this.msn);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bqy com_tencent_mm_protocal_c_bqy = (bqy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqy.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqy.leO = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqy.thA = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqy.uoV = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqy.msn = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
