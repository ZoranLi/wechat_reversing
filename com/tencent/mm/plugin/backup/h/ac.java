package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ac extends a {
    public int jMP;
    public int jNB;
    public q jOt;
    public p jOu;
    public r jOv;
    public s jOw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jMP);
            aVar.eO(2, this.jNB);
            if (this.jOt != null) {
                aVar.eQ(3, this.jOt.aUk());
                this.jOt.a(aVar);
            }
            if (this.jOu != null) {
                aVar.eQ(4, this.jOu.aUk());
                this.jOu.a(aVar);
            }
            if (this.jOv != null) {
                aVar.eQ(5, this.jOv.aUk());
                this.jOv.a(aVar);
            }
            if (this.jOw != null) {
                aVar.eQ(6, this.jOw.aUk());
                this.jOw.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.jMP) + 0) + a.a.a.a.eL(2, this.jNB);
            if (this.jOt != null) {
                r0 += a.a.a.a.eN(3, this.jOt.aUk());
            }
            if (this.jOu != null) {
                r0 += a.a.a.a.eN(4, this.jOu.aUk());
            }
            if (this.jOv != null) {
                r0 += a.a.a.a.eN(5, this.jOv.aUk());
            }
            if (this.jOw != null) {
                return r0 + a.a.a.a.eN(6, this.jOw.aUk());
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
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a qVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    acVar.jMP = aVar3.xmD.mL();
                    return 0;
                case 2:
                    acVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        qVar = new q();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.jOt = qVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        qVar = new p();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.jOu = qVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        qVar = new r();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.jOv = qVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        qVar = new s();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.jOw = qVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
