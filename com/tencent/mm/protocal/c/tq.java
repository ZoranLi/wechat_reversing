package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class tq extends avp {
    public LinkedList<b> tBV = new LinkedList();
    public int tBW;
    public LinkedList<Integer> tBX = new LinkedList();
    public int tvD;

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
            aVar.d(2, 6, this.tBV);
            aVar.eO(3, this.tBW);
            aVar.eO(4, this.tvD);
            aVar.d(5, 2, this.tBX);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.c(2, 6, this.tBV)) + a.a.a.a.eL(3, this.tBW)) + a.a.a.a.eL(4, this.tvD)) + a.a.a.a.c(5, 2, this.tBX);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tBV.clear();
            this.tBX.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            tq tqVar = (tq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tqVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    tqVar.tBV.add(aVar3.cic());
                    return 0;
                case 3:
                    tqVar.tBW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    tqVar.tvD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    tqVar.tBX.add(Integer.valueOf(aVar3.xmD.mL()));
                    return 0;
                default:
                    return -1;
            }
        }
    }
}