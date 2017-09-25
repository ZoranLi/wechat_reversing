package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ary extends avh {
    public int jNB;
    public String mvV;
    public long tVW;
    public long tVZ;
    public int tvL;
    public long tvM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mvV == null) {
                throw new b("Not all required fields were included: FromUserName");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mvV != null) {
                aVar.e(2, this.mvV);
            }
            aVar.eO(3, this.tvL);
            aVar.O(4, this.tvM);
            aVar.O(5, this.tVW);
            aVar.O(6, this.tVZ);
            aVar.eO(7, this.jNB);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvV);
            }
            return ((((r0 + a.a.a.a.eL(3, this.tvL)) + a.a.a.a.N(4, this.tvM)) + a.a.a.a.N(5, this.tVW)) + a.a.a.a.N(6, this.tVZ)) + a.a.a.a.eL(7, this.jNB);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mvV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: FromUserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ary com_tencent_mm_protocal_c_ary = (ary) objArr[1];
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
                        com_tencent_mm_protocal_c_ary.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ary.mvV = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ary.tvL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ary.tvM = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ary.tVW = aVar3.xmD.mM();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ary.tVZ = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ary.jNB = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
