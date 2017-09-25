package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class g extends a {
    public String fDC;
    public String msE;
    public String msF;
    public String msG;
    public String msH;
    public LinkedList<p> msI = new LinkedList();
    public String msk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            if (this.msk != null) {
                aVar.e(2, this.msk);
            }
            if (this.msE != null) {
                aVar.e(3, this.msE);
            }
            if (this.msF != null) {
                aVar.e(4, this.msF);
            }
            if (this.msG != null) {
                aVar.e(5, this.msG);
            }
            if (this.msH != null) {
                aVar.e(6, this.msH);
            }
            aVar.d(7, 8, this.msI);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(2, this.msk);
            }
            if (this.msE != null) {
                r0 += a.a.a.b.b.a.f(3, this.msE);
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(4, this.msF);
            }
            if (this.msG != null) {
                r0 += a.a.a.b.b.a.f(5, this.msG);
            }
            if (this.msH != null) {
                r0 += a.a.a.b.b.a.f(6, this.msH);
            }
            return r0 + a.a.a.a.c(7, 8, this.msI);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.msI.clear();
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
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    gVar.msk = aVar3.xmD.readString();
                    return 0;
                case 3:
                    gVar.msE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    gVar.msF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    gVar.msG = aVar3.xmD.readString();
                    return 0;
                case 6:
                    gVar.msH = aVar3.xmD.readString();
                    return 0;
                case 7:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a pVar = new p();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = pVar.a(aVar4, pVar, a.a(aVar4))) {
                        }
                        gVar.msI.add(pVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
