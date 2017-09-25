package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ox extends a {
    public int jOc;
    public String mvU;
    public String tfi;
    public int tgJ;
    public int tgK;
    public String tuA;
    public String tuB;
    public String tuC;
    public int tuD;
    public String tuy;
    public avw tuz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tuz == null) {
                throw new b("Not all required fields were included: EmojiBuffer");
            }
            if (this.tuy != null) {
                aVar.e(1, this.tuy);
            }
            aVar.eO(2, this.tgK);
            aVar.eO(3, this.tgJ);
            if (this.tuz != null) {
                aVar.eQ(4, this.tuz.aUk());
                this.tuz.a(aVar);
            }
            aVar.eO(5, this.jOc);
            if (this.mvU != null) {
                aVar.e(6, this.mvU);
            }
            if (this.tuA != null) {
                aVar.e(7, this.tuA);
            }
            if (this.tuB != null) {
                aVar.e(8, this.tuB);
            }
            if (this.tuC != null) {
                aVar.e(9, this.tuC);
            }
            if (this.tfi != null) {
                aVar.e(10, this.tfi);
            }
            aVar.eO(11, this.tuD);
            return 0;
        } else if (i == 1) {
            if (this.tuy != null) {
                r0 = a.a.a.b.b.a.f(1, this.tuy) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tgK)) + a.a.a.a.eL(3, this.tgJ);
            if (this.tuz != null) {
                r0 += a.a.a.a.eN(4, this.tuz.aUk());
            }
            r0 += a.a.a.a.eL(5, this.jOc);
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(6, this.mvU);
            }
            if (this.tuA != null) {
                r0 += a.a.a.b.b.a.f(7, this.tuA);
            }
            if (this.tuB != null) {
                r0 += a.a.a.b.b.a.f(8, this.tuB);
            }
            if (this.tuC != null) {
                r0 += a.a.a.b.b.a.f(9, this.tuC);
            }
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(10, this.tfi);
            }
            return r0 + a.a.a.a.eL(11, this.tuD);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tuz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ox oxVar = (ox) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oxVar.tuy = aVar3.xmD.readString();
                    return 0;
                case 2:
                    oxVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 3:
                    oxVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        oxVar.tuz = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 5:
                    oxVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 6:
                    oxVar.mvU = aVar3.xmD.readString();
                    return 0;
                case 7:
                    oxVar.tuA = aVar3.xmD.readString();
                    return 0;
                case 8:
                    oxVar.tuB = aVar3.xmD.readString();
                    return 0;
                case 9:
                    oxVar.tuC = aVar3.xmD.readString();
                    return 0;
                case 10:
                    oxVar.tfi = aVar3.xmD.readString();
                    return 0;
                case 11:
                    oxVar.tuD = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
