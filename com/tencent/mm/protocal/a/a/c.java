package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class c extends a {
    public int ret;
    public int taq;
    public int tar;
    public o tas;
    public o tat;
    public int tau;
    public int tav;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ret);
            aVar.eO(2, this.taq);
            aVar.eO(3, this.tar);
            if (this.tas != null) {
                aVar.eQ(4, this.tas.aUk());
                this.tas.a(aVar);
            }
            if (this.tat != null) {
                aVar.eQ(5, this.tat.aUk());
                this.tat.a(aVar);
            }
            aVar.eO(6, this.tau);
            aVar.eO(7, this.tav);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.ret) + 0) + a.a.a.a.eL(2, this.taq)) + a.a.a.a.eL(3, this.tar);
            if (this.tas != null) {
                r0 += a.a.a.a.eN(4, this.tas.aUk());
            }
            if (this.tat != null) {
                r0 += a.a.a.a.eN(5, this.tat.aUk());
            }
            return (r0 + a.a.a.a.eL(6, this.tau)) + a.a.a.a.eL(7, this.tav);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a oVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.ret = aVar3.xmD.mL();
                    return 0;
                case 2:
                    cVar.taq = aVar3.xmD.mL();
                    return 0;
                case 3:
                    cVar.tar = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        oVar = new o();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.tas = oVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        oVar = new o();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.tat = oVar;
                    }
                    return 0;
                case 6:
                    cVar.tau = aVar3.xmD.mL();
                    return 0;
                case 7:
                    cVar.tav = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
