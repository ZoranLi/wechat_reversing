package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ia extends a {
    public int jOc;
    public hu tmo;
    public ht tmp;
    public long tmq;
    public hz tmr;
    public ic tms;
    public hy tmt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jOc);
            if (this.tmo != null) {
                aVar.eQ(2, this.tmo.aUk());
                this.tmo.a(aVar);
            }
            if (this.tmp != null) {
                aVar.eQ(3, this.tmp.aUk());
                this.tmp.a(aVar);
            }
            aVar.O(4, this.tmq);
            if (this.tmr != null) {
                aVar.eQ(5, this.tmr.aUk());
                this.tmr.a(aVar);
            }
            if (this.tms != null) {
                aVar.eQ(6, this.tms.aUk());
                this.tms.a(aVar);
            }
            if (this.tmt != null) {
                aVar.eQ(7, this.tmt.aUk());
                this.tmt.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jOc) + 0;
            if (this.tmo != null) {
                r0 += a.a.a.a.eN(2, this.tmo.aUk());
            }
            if (this.tmp != null) {
                r0 += a.a.a.a.eN(3, this.tmp.aUk());
            }
            r0 += a.a.a.a.N(4, this.tmq);
            if (this.tmr != null) {
                r0 += a.a.a.a.eN(5, this.tmr.aUk());
            }
            if (this.tms != null) {
                r0 += a.a.a.a.eN(6, this.tms.aUk());
            }
            if (this.tmt != null) {
                return r0 + a.a.a.a.eN(7, this.tmt.aUk());
            }
            return r0;
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
            ia iaVar = (ia) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a huVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iaVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        huVar = new hu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = huVar.a(aVar4, huVar, a.a(aVar4))) {
                        }
                        iaVar.tmo = huVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        huVar = new ht();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = huVar.a(aVar4, huVar, a.a(aVar4))) {
                        }
                        iaVar.tmp = huVar;
                    }
                    return 0;
                case 4:
                    iaVar.tmq = aVar3.xmD.mM();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        huVar = new hz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = huVar.a(aVar4, huVar, a.a(aVar4))) {
                        }
                        iaVar.tmr = huVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        huVar = new ic();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = huVar.a(aVar4, huVar, a.a(aVar4))) {
                        }
                        iaVar.tms = huVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        huVar = new hy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = huVar.a(aVar4, huVar, a.a(aVar4))) {
                        }
                        iaVar.tmt = huVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
