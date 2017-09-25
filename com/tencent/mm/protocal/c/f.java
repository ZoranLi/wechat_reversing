package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class f extends avh {
    public int scene;
    public String tbi;
    public int tbk;
    public long tbl;
    public LinkedList<String> tbm = new LinkedList();
    public at tbn;
    public long tbo;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tbk);
            aVar.O(3, this.tbl);
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            aVar.d(5, 1, this.tbm);
            aVar.eO(6, this.scene);
            if (this.tbi != null) {
                aVar.e(7, this.tbi);
            }
            if (this.tbn != null) {
                aVar.eQ(8, this.tbn.aUk());
                this.tbn.a(aVar);
            }
            aVar.O(9, this.tbo);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tbk)) + a.a.a.a.N(3, this.tbl);
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(4, this.title);
            }
            r0 = (r0 + a.a.a.a.c(5, 1, this.tbm)) + a.a.a.a.eL(6, this.scene);
            if (this.tbi != null) {
                r0 += a.a.a.b.b.a.f(7, this.tbi);
            }
            if (this.tbn != null) {
                r0 += a.a.a.a.eN(8, this.tbn.aUk());
            }
            return r0 + a.a.a.a.N(9, this.tbo);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tbm.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        fVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    fVar.tbk = aVar3.xmD.mL();
                    return 0;
                case 3:
                    fVar.tbl = aVar3.xmD.mM();
                    return 0;
                case 4:
                    fVar.title = aVar3.xmD.readString();
                    return 0;
                case 5:
                    fVar.tbm.add(aVar3.xmD.readString());
                    return 0;
                case 6:
                    fVar.scene = aVar3.xmD.mL();
                    return 0;
                case 7:
                    fVar.tbi = aVar3.xmD.readString();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new at();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        fVar.tbn = emVar;
                    }
                    return 0;
                case 9:
                    fVar.tbo = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
