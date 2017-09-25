package com.tencent.mm.plugin.address.d;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    public LinkedList<b> itq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).d(1, 8, this.itq);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.c(1, 8, this.itq) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.itq.clear();
                a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = com.tencent.mm.bd.a.a(aVar); a > 0; a = com.tencent.mm.bd.a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                a aVar3 = (a) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar2.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            com.tencent.mm.bd.a bVar = new b();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bVar.a(aVar4, bVar, com.tencent.mm.bd.a.a(aVar4))) {
                            }
                            aVar3.itq.add(bVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
