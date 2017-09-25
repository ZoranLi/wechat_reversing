package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class oe extends a {
    public int ttL;
    public of ttM;
    public int ttN;
    public of ttO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttM == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.ttO == null) {
                throw new b("Not all required fields were included: AllDayTime");
            } else {
                aVar.eO(1, this.ttL);
                if (this.ttM != null) {
                    aVar.eQ(2, this.ttM.aUk());
                    this.ttM.a(aVar);
                }
                aVar.eO(3, this.ttN);
                if (this.ttO != null) {
                    aVar.eQ(4, this.ttO.aUk());
                    this.ttO.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.ttL) + 0;
            if (this.ttM != null) {
                r0 += a.a.a.a.eN(2, this.ttM.aUk());
            }
            r0 += a.a.a.a.eL(3, this.ttN);
            if (this.ttO != null) {
                return r0 + a.a.a.a.eN(4, this.ttO.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttM == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.ttO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AllDayTime");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            oe oeVar = (oe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a ofVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    oeVar.ttL = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        ofVar = new of();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ofVar.a(aVar4, ofVar, a.a(aVar4))) {
                        }
                        oeVar.ttM = ofVar;
                    }
                    return 0;
                case 3:
                    oeVar.ttN = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        ofVar = new of();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ofVar.a(aVar4, ofVar, a.a(aVar4))) {
                        }
                        oeVar.ttO = ofVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
