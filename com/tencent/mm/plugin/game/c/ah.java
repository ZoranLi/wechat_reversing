package com.tencent.mm.plugin.game.c;

import a.a.a.c.a;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.em;
import java.util.LinkedList;

public final class ah extends avh {
    public String msh;
    public int mtE;
    public int mtF;
    public int mtG;
    public String mtH;
    public String mtI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.msh != null) {
                aVar.e(2, this.msh);
            }
            aVar.eO(3, this.mtE);
            aVar.eO(4, this.mtF);
            aVar.eO(5, this.mtG);
            if (this.mtH != null) {
                aVar.e(6, this.mtH);
            }
            if (this.mtI == null) {
                return 0;
            }
            aVar.e(7, this.mtI);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.msh != null) {
                r0 += a.a.a.b.b.a.f(2, this.msh);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.mtE)) + a.a.a.a.eL(4, this.mtF)) + a.a.a.a.eL(5, this.mtG);
            if (this.mtH != null) {
                r0 += a.a.a.b.b.a.f(6, this.mtH);
            }
            if (this.mtI != null) {
                r0 += a.a.a.b.b.a.f(7, this.mtI);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ah ahVar = (ah) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        ahVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    ahVar.msh = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ahVar.mtE = aVar3.xmD.mL();
                    return 0;
                case 4:
                    ahVar.mtF = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ahVar.mtG = aVar3.xmD.mL();
                    return 0;
                case 6:
                    ahVar.mtH = aVar3.xmD.readString();
                    return 0;
                case 7:
                    ahVar.mtI = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
