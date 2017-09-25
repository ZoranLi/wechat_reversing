package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class jp extends a {
    public jo tpA;
    public jo tpB;
    public jo tpC;
    public jo tpD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tpA != null) {
                aVar.eQ(1, this.tpA.aUk());
                this.tpA.a(aVar);
            }
            if (this.tpB != null) {
                aVar.eQ(2, this.tpB.aUk());
                this.tpB.a(aVar);
            }
            if (this.tpC != null) {
                aVar.eQ(3, this.tpC.aUk());
                this.tpC.a(aVar);
            }
            if (this.tpD == null) {
                return 0;
            }
            aVar.eQ(4, this.tpD.aUk());
            this.tpD.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tpA != null) {
                r0 = a.a.a.a.eN(1, this.tpA.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tpB != null) {
                r0 += a.a.a.a.eN(2, this.tpB.aUk());
            }
            if (this.tpC != null) {
                r0 += a.a.a.a.eN(3, this.tpC.aUk());
            }
            if (this.tpD != null) {
                r0 += a.a.a.a.eN(4, this.tpD.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            jp jpVar = (jp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a joVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        joVar = new jo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = joVar.a(aVar4, joVar, a.a(aVar4))) {
                        }
                        jpVar.tpA = joVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        joVar = new jo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = joVar.a(aVar4, joVar, a.a(aVar4))) {
                        }
                        jpVar.tpB = joVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        joVar = new jo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = joVar.a(aVar4, joVar, a.a(aVar4))) {
                        }
                        jpVar.tpC = joVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        joVar = new jo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = joVar.a(aVar4, joVar, a.a(aVar4))) {
                        }
                        jpVar.tpD = joVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
