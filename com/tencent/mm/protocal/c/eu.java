package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class eu extends a {
    public int tiI;
    public int tiJ;
    public LinkedList<String> tiK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tiI);
            aVar.eO(2, this.tiJ);
            aVar.d(3, 1, this.tiK);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.tiI) + 0) + a.a.a.a.eL(2, this.tiJ)) + a.a.a.a.c(3, 1, this.tiK);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.tiK.clear();
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
                eu euVar = (eu) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        euVar.tiI = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        euVar.tiJ = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        euVar.tiK.add(aVar3.xmD.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
