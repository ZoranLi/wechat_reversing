package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class pz extends avh {
    public int tdM;
    public String tvK;
    public int tvL;
    public long tvM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tvL);
            aVar.O(3, this.tvM);
            if (this.tvK != null) {
                aVar.e(4, this.tvK);
            }
            aVar.eO(5, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.N(3, this.tvM);
            if (this.tvK != null) {
                r0 += a.a.a.b.b.a.f(4, this.tvK);
            }
            return r0 + a.a.a.a.eL(5, this.tdM);
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
            pz pzVar = (pz) objArr[1];
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
                        pzVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    pzVar.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    pzVar.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    pzVar.tvK = aVar3.xmD.readString();
                    return 0;
                case 5:
                    pzVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
