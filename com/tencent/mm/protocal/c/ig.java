package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ig extends a {
    public int tmT;
    public LinkedList<Integer> tmU = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tmT);
            aVar.c(2, this.tmU);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.tmT) + 0) + a.a.a.a.b(2, this.tmU);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.tmU.clear();
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
                ig igVar = (ig) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        igVar.tmT = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        igVar.tmU = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
