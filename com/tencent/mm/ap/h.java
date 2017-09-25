package com.tencent.mm.ap;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class h extends a {
    public LinkedList<g> hOi = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).d(1, 8, this.hOi);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.c(1, 8, this.hOi) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.hOi.clear();
                a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                h hVar = (h) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar2.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a gVar = new g();
                            a.a.a.a.a aVar3 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = gVar.a(aVar3, gVar, a.a(aVar3))) {
                            }
                            hVar.hOi.add(gVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
