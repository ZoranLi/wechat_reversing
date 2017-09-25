package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class du extends avh {
    public String hAG;
    public String jNn;
    public String leN;
    public String leO;
    public String thA;
    public int thB;
    public String thC;
    public String thD;
    public avw thf;
    public ek thy;
    public String thz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.thf == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.thy != null) {
                aVar.eQ(2, this.thy.aUk());
                this.thy.a(aVar);
            }
            if (this.thf != null) {
                aVar.eQ(3, this.thf.aUk());
                this.thf.a(aVar);
            }
            if (this.thz != null) {
                aVar.e(4, this.thz);
            }
            if (this.thA != null) {
                aVar.e(5, this.thA);
            }
            aVar.eO(6, this.thB);
            if (this.thC != null) {
                aVar.e(7, this.thC);
            }
            if (this.hAG != null) {
                aVar.e(8, this.hAG);
            }
            if (this.jNn != null) {
                aVar.e(9, this.jNn);
            }
            if (this.thD != null) {
                aVar.e(10, this.thD);
            }
            if (this.leO != null) {
                aVar.e(11, this.leO);
            }
            if (this.leN == null) {
                return 0;
            }
            aVar.e(12, this.leN);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.thy != null) {
                r0 += a.a.a.a.eN(2, this.thy.aUk());
            }
            if (this.thf != null) {
                r0 += a.a.a.a.eN(3, this.thf.aUk());
            }
            if (this.thz != null) {
                r0 += a.a.a.b.b.a.f(4, this.thz);
            }
            if (this.thA != null) {
                r0 += a.a.a.b.b.a.f(5, this.thA);
            }
            r0 += a.a.a.a.eL(6, this.thB);
            if (this.thC != null) {
                r0 += a.a.a.b.b.a.f(7, this.thC);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(8, this.hAG);
            }
            if (this.jNn != null) {
                r0 += a.a.a.b.b.a.f(9, this.jNn);
            }
            if (this.thD != null) {
                r0 += a.a.a.b.b.a.f(10, this.thD);
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(11, this.leO);
            }
            if (this.leN != null) {
                r0 += a.a.a.b.b.a.f(12, this.leN);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.thf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AutoAuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            du duVar = (du) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        duVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new ek();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        duVar.thy = emVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        duVar.thf = emVar;
                    }
                    return 0;
                case 4:
                    duVar.thz = aVar3.xmD.readString();
                    return 0;
                case 5:
                    duVar.thA = aVar3.xmD.readString();
                    return 0;
                case 6:
                    duVar.thB = aVar3.xmD.mL();
                    return 0;
                case 7:
                    duVar.thC = aVar3.xmD.readString();
                    return 0;
                case 8:
                    duVar.hAG = aVar3.xmD.readString();
                    return 0;
                case 9:
                    duVar.jNn = aVar3.xmD.readString();
                    return 0;
                case 10:
                    duVar.thD = aVar3.xmD.readString();
                    return 0;
                case 11:
                    duVar.leO = aVar3.xmD.readString();
                    return 0;
                case 12:
                    duVar.leN = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
