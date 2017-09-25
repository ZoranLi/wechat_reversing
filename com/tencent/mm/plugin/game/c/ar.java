package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.em;
import java.util.LinkedList;

public final class ar extends avh {
    public String hAM;
    public String mtJ;
    public int muE;
    public int muF;
    public int muw;
    public int mux;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mtJ == null) {
                throw new b("Not all required fields were included: Lang");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.muw);
            aVar.eO(3, this.mux);
            if (this.mtJ != null) {
                aVar.e(4, this.mtJ);
            }
            aVar.eO(5, this.muE);
            aVar.eO(6, this.muF);
            if (this.hAM == null) {
                return 0;
            }
            aVar.e(7, this.hAM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.muw)) + a.a.a.a.eL(3, this.mux);
            if (this.mtJ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtJ);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.muE)) + a.a.a.a.eL(6, this.muF);
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(7, this.hAM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mtJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Lang");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ar arVar = (ar) objArr[1];
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
                        arVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    arVar.muw = aVar3.xmD.mL();
                    return 0;
                case 3:
                    arVar.mux = aVar3.xmD.mL();
                    return 0;
                case 4:
                    arVar.mtJ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    arVar.muE = aVar3.xmD.mL();
                    return 0;
                case 6:
                    arVar.muF = aVar3.xmD.mL();
                    return 0;
                case 7:
                    arVar.hAM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
