package com.tencent.mm.bi;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    public LinkedList<d> uxS = new LinkedList();
    public LinkedList<c> uxT = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(3, 8, this.uxS);
            aVar.d(4, 8, this.uxT);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(3, 8, this.uxS) + 0) + a.a.a.a.c(4, 8, this.uxT);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.uxS.clear();
                this.uxT.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = com.tencent.mm.bd.a.a(aVar2); a > 0; a = com.tencent.mm.bd.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList En;
                int size;
                com.tencent.mm.bd.a dVar;
                a.a.a.a.a aVar5;
                boolean z;
                switch (intValue) {
                    case 3:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            dVar = new d();
                            aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = dVar.a(aVar5, dVar, com.tencent.mm.bd.a.a(aVar5))) {
                            }
                            aVar4.uxS.add(dVar);
                        }
                        return 0;
                    case 4:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            dVar = new c();
                            aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = dVar.a(aVar5, dVar, com.tencent.mm.bd.a.a(aVar5))) {
                            }
                            aVar4.uxT.add(dVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
