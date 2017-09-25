package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class auq extends avh {
    public int jOa;
    public int tYk;
    public bjp tYl;
    public int tYm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYl == null) {
                throw new b("Not all required fields were included: PieceData");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.jOa);
            aVar.eO(3, this.tYk);
            if (this.tYl != null) {
                aVar.eQ(4, this.tYl.aUk());
                this.tYl.a(aVar);
            }
            aVar.eO(5, this.tYm);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.jOa)) + a.a.a.a.eL(3, this.tYk);
            if (this.tYl != null) {
                r0 += a.a.a.a.eN(4, this.tYl.aUk());
            }
            return r0 + a.a.a.a.eL(5, this.tYm);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tYl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PieceData");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auq com_tencent_mm_protocal_c_auq = (auq) objArr[1];
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
                        com_tencent_mm_protocal_c_auq.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auq.jOa = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auq.tYk = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bjp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auq.tYl = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auq.tYm = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
