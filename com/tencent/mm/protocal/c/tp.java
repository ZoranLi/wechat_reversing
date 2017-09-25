package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class tp extends a {
    public int fRW;
    public int tBS;
    public LinkedList<qd> tBT = new LinkedList();
    public int tBU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tBS);
            aVar.d(2, 8, this.tBT);
            aVar.eO(3, this.tBU);
            aVar.eO(4, this.fRW);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.tBS) + 0) + a.a.a.a.c(2, 8, this.tBT)) + a.a.a.a.eL(3, this.tBU)) + a.a.a.a.eL(4, this.fRW);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tBT.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                tp tpVar = (tp) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        tpVar.tBS = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a qdVar = new qd();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = qdVar.a(aVar4, qdVar, a.a(aVar4))) {
                            }
                            tpVar.tBT.add(qdVar);
                        }
                        return 0;
                    case 3:
                        tpVar.tBU = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        tpVar.fRW = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
