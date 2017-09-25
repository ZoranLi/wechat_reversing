package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class hl extends a {
    public String tlA;
    public int tlB;
    public String tlC;
    public int tlD;
    public LinkedList<gl> tlE = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tlA != null) {
                aVar.e(1, this.tlA);
            }
            aVar.eO(2, this.tlB);
            if (this.tlC != null) {
                aVar.e(3, this.tlC);
            }
            aVar.eO(4, this.tlD);
            aVar.d(5, 8, this.tlE);
            return 0;
        } else if (i == 1) {
            if (this.tlA != null) {
                r0 = a.a.a.b.b.a.f(1, this.tlA) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tlB);
            if (this.tlC != null) {
                r0 += a.a.a.b.b.a.f(3, this.tlC);
            }
            return (r0 + a.a.a.a.eL(4, this.tlD)) + a.a.a.a.c(5, 8, this.tlE);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tlE.clear();
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
            hl hlVar = (hl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hlVar.tlA = aVar3.xmD.readString();
                    return 0;
                case 2:
                    hlVar.tlB = aVar3.xmD.mL();
                    return 0;
                case 3:
                    hlVar.tlC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    hlVar.tlD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a glVar = new gl();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = glVar.a(aVar4, glVar, a.a(aVar4))) {
                        }
                        hlVar.tlE.add(glVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
