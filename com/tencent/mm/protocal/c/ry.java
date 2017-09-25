package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ry extends a implements bah {
    public int thX;
    public int tlZ;
    public avw tob;
    public lv toe;

    public final int getRet() {
        return this.thX;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.toe == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.tob == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                aVar.eO(1, this.thX);
                if (this.toe != null) {
                    aVar.eQ(2, this.toe.aUk());
                    this.toe.a(aVar);
                }
                if (this.tob != null) {
                    aVar.eQ(3, this.tob.aUk());
                    this.tob.a(aVar);
                }
                aVar.eO(4, this.tlZ);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.thX) + 0;
            if (this.toe != null) {
                r0 += a.a.a.a.eN(2, this.toe.aUk());
            }
            if (this.tob != null) {
                r0 += a.a.a.a.eN(3, this.tob.aUk());
            }
            return r0 + a.a.a.a.eL(4, this.tlZ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.toe == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.tob != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ry ryVar = (ry) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a lvVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ryVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        lvVar = new lv();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lvVar.a(aVar4, lvVar, a.a(aVar4))) {
                        }
                        ryVar.toe = lvVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        lvVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lvVar.a(aVar4, lvVar, a.a(aVar4))) {
                        }
                        ryVar.tob = lvVar;
                    }
                    return 0;
                case 4:
                    ryVar.tlZ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
