package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class axo extends avh {
    public String jNj;
    public String opI;
    public int tGA;
    public int tSE;
    public String uai;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            if (this.opI != null) {
                aVar.e(3, this.opI);
            }
            aVar.eO(4, this.tSE);
            aVar.eO(5, this.tGA);
            if (this.uai == null) {
                return 0;
            }
            aVar.e(6, this.uai);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(3, this.opI);
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tSE)) + a.a.a.a.eL(5, this.tGA);
            if (this.uai != null) {
                r0 += a.a.a.b.b.a.f(6, this.uai);
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
            axo com_tencent_mm_protocal_c_axo = (axo) objArr[1];
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
                        com_tencent_mm_protocal_c_axo.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axo.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axo.opI = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axo.tSE = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axo.tGA = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axo.uai = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
