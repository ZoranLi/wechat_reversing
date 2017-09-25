package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xx extends avh {
    public int tEn;
    public int tdM;
    public avw tfG;
    public int tiJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tfG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tfG != null) {
                aVar.eQ(2, this.tfG.aUk());
                this.tfG.a(aVar);
            }
            aVar.eO(3, this.tiJ);
            aVar.eO(4, this.tdM);
            aVar.eO(5, this.tEn);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfG != null) {
                r0 += a.a.a.a.eN(2, this.tfG.aUk());
            }
            return ((r0 + a.a.a.a.eL(3, this.tiJ)) + a.a.a.a.eL(4, this.tdM)) + a.a.a.a.eL(5, this.tEn);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReqBuf");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xx xxVar = (xx) objArr[1];
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
                        xxVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        xxVar.tfG = emVar;
                    }
                    return 0;
                case 3:
                    xxVar.tiJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    xxVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    xxVar.tEn = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
