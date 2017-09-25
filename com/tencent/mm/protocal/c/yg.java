package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class yg extends avp {
    public long jNA;
    public int tEH;
    public int tEI;
    public int tEJ;
    public long tfa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.O(2, this.tfa);
            aVar.O(3, this.jNA);
            aVar.eO(4, this.tEH);
            aVar.eO(5, this.tEI);
            aVar.eO(6, this.tEJ);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return ((((r0 + a.a.a.a.N(2, this.tfa)) + a.a.a.a.N(3, this.jNA)) + a.a.a.a.eL(4, this.tEH)) + a.a.a.a.eL(5, this.tEI)) + a.a.a.a.eL(6, this.tEJ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            yg ygVar = (yg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        ygVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    ygVar.tfa = aVar3.xmD.mM();
                    return 0;
                case 3:
                    ygVar.jNA = aVar3.xmD.mM();
                    return 0;
                case 4:
                    ygVar.tEH = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ygVar.tEI = aVar3.xmD.mL();
                    return 0;
                case 6:
                    ygVar.tEJ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
