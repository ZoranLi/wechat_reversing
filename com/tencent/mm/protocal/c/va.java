package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class va extends avh {
    public int jOc;
    public String tCE;
    public int tdM;
    public avw tjF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.jOc);
            aVar.eO(3, this.tdM);
            if (this.tCE != null) {
                aVar.e(4, this.tCE);
            }
            if (this.tjF == null) {
                return 0;
            }
            aVar.eQ(5, this.tjF.aUk());
            this.tjF.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.jOc)) + a.a.a.a.eL(3, this.tdM);
            if (this.tCE != null) {
                r0 += a.a.a.b.b.a.f(4, this.tCE);
            }
            if (this.tjF != null) {
                r0 += a.a.a.a.eN(5, this.tjF.aUk());
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
            va vaVar = (va) objArr[1];
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
                        vaVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    vaVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    vaVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 4:
                    vaVar.tCE = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        vaVar.tjF = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
