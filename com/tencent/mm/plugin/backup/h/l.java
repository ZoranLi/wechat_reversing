package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class l extends a {
    public LinkedList<k> jNk = new LinkedList();
    public int jNl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.jNk);
            aVar.eO(2, this.jNl);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 8, this.jNk) + 0) + a.a.a.a.eL(2, this.jNl);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.jNk.clear();
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
                l lVar = (l) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a kVar = new k();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                            }
                            lVar.jNk.add(kVar);
                        }
                        return 0;
                    case 2:
                        lVar.jNl = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
