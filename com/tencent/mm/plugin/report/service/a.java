package com.tencent.mm.plugin.report.service;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    public int jNd;
    public LinkedList<b> oTC = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jNd);
            aVar.d(2, 8, this.oTC);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.jNd) + 0) + a.a.a.a.c(2, 8, this.oTC);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.oTC.clear();
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
                switch (intValue) {
                    case 1:
                        aVar4.jNd = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            com.tencent.mm.bd.a bVar = new b();
                            a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bd.a.a(aVar5))) {
                            }
                            aVar4.oTC.add(bVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
