package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ob extends a {
    public String kdH;
    public String title;
    public int ttI;
    public LinkedList<lz> ttJ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.kdH != null) {
                aVar.e(2, this.kdH);
            }
            aVar.eO(3, this.ttI);
            aVar.d(4, 8, this.ttJ);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.kdH != null) {
                r0 += a.a.a.b.b.a.f(2, this.kdH);
            }
            return (r0 + a.a.a.a.eL(3, this.ttI)) + a.a.a.a.c(4, 8, this.ttJ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ttJ.clear();
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
            ob obVar = (ob) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    obVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    obVar.kdH = aVar3.xmD.readString();
                    return 0;
                case 3:
                    obVar.ttI = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a lzVar = new lz();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        obVar.ttJ.add(lzVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
