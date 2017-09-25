package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bd.a;

public final class b extends a {
    public int fxo;
    public int oTD;
    public int oTE;
    public boolean oTF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.fxo);
            aVar.eO(2, this.oTD);
            aVar.eO(3, this.oTE);
            aVar.an(4, this.oTF);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.fxo) + 0) + a.a.a.a.eL(2, this.oTD)) + a.a.a.a.eL(3, this.oTE)) + (a.a.a.b.b.a.cH(4) + 1);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                b bVar = (b) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bVar.fxo = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        bVar.oTD = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        bVar.oTE = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        bVar.oTF = aVar3.cib();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
