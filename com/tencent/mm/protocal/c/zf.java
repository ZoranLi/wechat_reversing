package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zf extends avh {
    public String tAN;
    public avw tFu;
    public int tFv;
    public int tFw;
    public LinkedList<aqm> tFx = new LinkedList();
    public int tFy;
    public int tdM;
    public int thO;
    public aiy ttj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ttj == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.thO);
            aVar.eO(3, this.tdM);
            if (this.tFu != null) {
                aVar.eQ(4, this.tFu.aUk());
                this.tFu.a(aVar);
            }
            if (this.ttj != null) {
                aVar.eQ(5, this.ttj.aUk());
                this.ttj.a(aVar);
            }
            if (this.tAN != null) {
                aVar.e(6, this.tAN);
            }
            aVar.eO(7, this.tFv);
            aVar.eO(8, this.tFw);
            aVar.d(11, 8, this.tFx);
            aVar.eO(12, this.tFy);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.thO)) + a.a.a.a.eL(3, this.tdM);
            if (this.tFu != null) {
                r0 += a.a.a.a.eN(4, this.tFu.aUk());
            }
            if (this.ttj != null) {
                r0 += a.a.a.a.eN(5, this.ttj.aUk());
            }
            if (this.tAN != null) {
                r0 += a.a.a.b.b.a.f(6, this.tAN);
            }
            return (((r0 + a.a.a.a.eL(7, this.tFv)) + a.a.a.a.eL(8, this.tFw)) + a.a.a.a.c(11, 8, this.tFx)) + a.a.a.a.eL(12, this.tFy);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tFx.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zf zfVar = (zf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        zfVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    zfVar.thO = aVar3.xmD.mL();
                    return 0;
                case 3:
                    zfVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        zfVar.tFu = emVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new aiy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        zfVar.ttj = emVar;
                    }
                    return 0;
                case 6:
                    zfVar.tAN = aVar3.xmD.readString();
                    return 0;
                case 7:
                    zfVar.tFv = aVar3.xmD.mL();
                    return 0;
                case 8:
                    zfVar.tFw = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new aqm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        zfVar.tFx.add(emVar);
                    }
                    return 0;
                case 12:
                    zfVar.tFy = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
