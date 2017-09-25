package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ll extends a {
    public int trE;
    public int trF;
    public int trG;
    public LinkedList<lk> trH = new LinkedList();
    public b trI;
    public aey trJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.trE);
            aVar.eO(2, this.trF);
            aVar.eO(3, this.trG);
            aVar.d(4, 8, this.trH);
            if (this.trI != null) {
                aVar.b(5, this.trI);
            }
            if (this.trJ != null) {
                aVar.eQ(6, this.trJ.aUk());
                this.trJ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.eL(1, this.trE) + 0) + a.a.a.a.eL(2, this.trF)) + a.a.a.a.eL(3, this.trG)) + a.a.a.a.c(4, 8, this.trH);
            if (this.trI != null) {
                r0 += a.a.a.a.a(5, this.trI);
            }
            if (this.trJ != null) {
                return r0 + a.a.a.a.eN(6, this.trJ.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.trH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ll llVar = (ll) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a lkVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    llVar.trE = aVar3.xmD.mL();
                    return 0;
                case 2:
                    llVar.trF = aVar3.xmD.mL();
                    return 0;
                case 3:
                    llVar.trG = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lkVar = new lk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lkVar.a(aVar4, lkVar, a.a(aVar4))) {
                        }
                        llVar.trH.add(lkVar);
                    }
                    return 0;
                case 5:
                    llVar.trI = aVar3.cic();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lkVar = new aey();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lkVar.a(aVar4, lkVar, a.a(aVar4))) {
                        }
                        llVar.trJ = lkVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
