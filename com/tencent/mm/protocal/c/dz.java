package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class dz extends a {
    public LinkedList<String> thN = new LinkedList();
    public int thO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.thN);
            aVar.eO(2, this.thO);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 1, this.thN) + 0) + a.a.a.a.eL(2, this.thO);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.thN.clear();
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
                dz dzVar = (dz) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        dzVar.thN.add(aVar3.xmD.readString());
                        return 0;
                    case 2:
                        dzVar.thO = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
