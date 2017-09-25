package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class m extends a {
    public int taT;
    public int taU;
    public LinkedList<n> taV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.taT);
            aVar.eO(2, this.taU);
            aVar.d(3, 8, this.taV);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.taT) + 0) + a.a.a.a.eL(2, this.taU)) + a.a.a.a.c(3, 8, this.taV);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.taV.clear();
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
                m mVar = (m) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        mVar.taT = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        mVar.taU = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a nVar = new n();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                            }
                            mVar.taV.add(nVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
