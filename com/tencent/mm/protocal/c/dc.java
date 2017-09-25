package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class dc extends avp {
    public int tgA;
    public dh tgB;
    public dd tgC;
    public b tgu;
    public int tgz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(2, this.tgz);
            aVar.eO(3, this.tgA);
            if (this.tgu != null) {
                aVar.b(4, this.tgu);
            }
            if (this.tgB != null) {
                aVar.eQ(5, this.tgB.aUk());
                this.tgB.a(aVar);
            }
            if (this.tgC == null) {
                return 0;
            }
            aVar.eQ(6, this.tgC.aUk());
            this.tgC.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tgz)) + a.a.a.a.eL(3, this.tgA);
            if (this.tgu != null) {
                r0 += a.a.a.a.a(4, this.tgu);
            }
            if (this.tgB != null) {
                r0 += a.a.a.a.eN(5, this.tgB.aUk());
            }
            if (this.tgC != null) {
                r0 += a.a.a.a.eN(6, this.tgC.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dc dcVar = (dc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        dcVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    dcVar.tgz = aVar3.xmD.mL();
                    return 0;
                case 3:
                    dcVar.tgA = aVar3.xmD.mL();
                    return 0;
                case 4:
                    dcVar.tgu = aVar3.cic();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new dh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        dcVar.tgB = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new dd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        dcVar.tgC = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
