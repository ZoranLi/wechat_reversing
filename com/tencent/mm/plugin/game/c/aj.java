package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.em;
import java.util.LinkedList;

public final class aj extends avh {
    public String hAM;
    public String mtJ;
    public int mtK;

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
            if (this.mtJ != null) {
                aVar.e(2, this.mtJ);
            }
            if (this.hAM != null) {
                aVar.e(3, this.hAM);
            }
            aVar.eO(4, this.mtK);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtJ);
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(3, this.hAM);
            }
            return r0 + a.a.a.a.eL(4, this.mtK);
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
            aj ajVar = (aj) objArr[1];
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
                        ajVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    ajVar.mtJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ajVar.hAM = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ajVar.mtK = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
