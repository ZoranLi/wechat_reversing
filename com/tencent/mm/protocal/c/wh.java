package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class wh extends avp {
    public LinkedList<String> kcK = new LinkedList();
    public int kcM;
    public int kcN;
    public int kcO;

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
            aVar.d(2, 1, this.kcK);
            aVar.eO(3, this.kcM);
            aVar.eO(4, this.kcN);
            aVar.eO(5, this.kcO);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.c(2, 1, this.kcK)) + a.a.a.a.eL(3, this.kcM)) + a.a.a.a.eL(4, this.kcN)) + a.a.a.a.eL(5, this.kcO);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.kcK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            wh whVar = (wh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        whVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    whVar.kcK.add(aVar3.xmD.readString());
                    return 0;
                case 3:
                    whVar.kcM = aVar3.xmD.mL();
                    return 0;
                case 4:
                    whVar.kcN = aVar3.xmD.mL();
                    return 0;
                case 5:
                    whVar.kcO = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
