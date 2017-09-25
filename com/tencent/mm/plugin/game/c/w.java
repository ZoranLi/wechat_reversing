package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class w extends a {
    public LinkedList<s> msJ = new LinkedList();
    public br mtn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.msJ);
            if (this.mtn != null) {
                aVar.eQ(2, this.mtn.aUk());
                this.mtn.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.msJ) + 0;
            if (this.mtn != null) {
                return r0 + a.a.a.a.eN(2, this.mtn.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.msJ.clear();
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
            w wVar = (w) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a sVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        sVar = new s();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = sVar.a(aVar4, sVar, a.a(aVar4))) {
                        }
                        wVar.msJ.add(sVar);
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        sVar = new br();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = sVar.a(aVar4, sVar, a.a(aVar4))) {
                        }
                        wVar.mtn = sVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
