package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class mb extends avh {
    public String teW;
    public int tgJ;
    public int tgK;
    public int tgL;
    public avw tsk;
    public String tsl;
    public String tsm;
    public int tsn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.teW != null) {
                aVar.e(2, this.teW);
            }
            aVar.eO(3, this.tgJ);
            aVar.eO(4, this.tgK);
            aVar.eO(5, this.tgL);
            if (this.tsk != null) {
                aVar.eQ(6, this.tsk.aUk());
                this.tsk.a(aVar);
            }
            if (this.tsl != null) {
                aVar.e(7, this.tsl);
            }
            if (this.tsm != null) {
                aVar.e(9, this.tsm);
            }
            aVar.eO(10, this.tsn);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.teW != null) {
                r0 += a.a.a.b.b.a.f(2, this.teW);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.tgJ)) + a.a.a.a.eL(4, this.tgK)) + a.a.a.a.eL(5, this.tgL);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(6, this.tsk.aUk());
            }
            if (this.tsl != null) {
                r0 += a.a.a.b.b.a.f(7, this.tsl);
            }
            if (this.tsm != null) {
                r0 += a.a.a.b.b.a.f(9, this.tsm);
            }
            return r0 + a.a.a.a.eL(10, this.tsn);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            mb mbVar = (mb) objArr[1];
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
                        mbVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    mbVar.teW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mbVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    mbVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 5:
                    mbVar.tgL = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        mbVar.tsk = emVar;
                    }
                    return 0;
                case 7:
                    mbVar.tsl = aVar3.xmD.readString();
                    return 0;
                case 9:
                    mbVar.tsm = aVar3.xmD.readString();
                    return 0;
                case 10:
                    mbVar.tsn = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
