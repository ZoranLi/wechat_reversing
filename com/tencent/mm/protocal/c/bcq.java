package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bcq extends avh {
    public int tfW;
    public String tgG;
    public String ubX;
    public long ubY;
    public long udt;
    public int udu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.ubX != null) {
                aVar.e(2, this.ubX);
            }
            if (this.tgG != null) {
                aVar.e(3, this.tgG);
            }
            aVar.O(4, this.ubY);
            aVar.eO(5, this.tfW);
            aVar.O(6, this.udt);
            aVar.eO(7, this.udu);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ubX != null) {
                r0 += a.a.a.b.b.a.f(2, this.ubX);
            }
            if (this.tgG != null) {
                r0 += a.a.a.b.b.a.f(3, this.tgG);
            }
            return (((r0 + a.a.a.a.N(4, this.ubY)) + a.a.a.a.eL(5, this.tfW)) + a.a.a.a.N(6, this.udt)) + a.a.a.a.eL(7, this.udu);
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
            bcq com_tencent_mm_protocal_c_bcq = (bcq) objArr[1];
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
                        com_tencent_mm_protocal_c_bcq.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcq.ubX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcq.tgG = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcq.ubY = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcq.tfW = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcq.udt = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcq.udu = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
