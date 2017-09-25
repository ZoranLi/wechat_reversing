package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bcl extends avh {
    public avw ubE;
    public String ubX;
    public long ubY;
    public long udt;
    public int udu;
    public long udv;
    public int udw;

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
            aVar.O(3, this.ubY);
            aVar.O(4, this.udt);
            aVar.eO(5, this.udu);
            aVar.O(6, this.udv);
            if (this.ubE != null) {
                aVar.eQ(7, this.ubE.aUk());
                this.ubE.a(aVar);
            }
            aVar.eO(8, this.udw);
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
            r0 = (((r0 + a.a.a.a.N(3, this.ubY)) + a.a.a.a.N(4, this.udt)) + a.a.a.a.eL(5, this.udu)) + a.a.a.a.N(6, this.udv);
            if (this.ubE != null) {
                r0 += a.a.a.a.eN(7, this.ubE.aUk());
            }
            return r0 + a.a.a.a.eL(8, this.udw);
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
            bcl com_tencent_mm_protocal_c_bcl = (bcl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcl.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcl.ubX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcl.ubY = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcl.udt = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcl.udu = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcl.udv = aVar3.xmD.mM();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcl.ubE = emVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcl.udw = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
