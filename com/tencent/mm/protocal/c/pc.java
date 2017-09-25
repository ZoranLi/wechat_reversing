package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class pc extends a {
    public pn tuJ;
    public pd tuK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tuJ == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.tuK == null) {
                throw new b("Not all required fields were included: BannerImg");
            } else {
                if (this.tuJ != null) {
                    aVar.eQ(1, this.tuJ.aUk());
                    this.tuJ.a(aVar);
                }
                if (this.tuK == null) {
                    return 0;
                }
                aVar.eQ(2, this.tuK.aUk());
                this.tuK.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tuJ != null) {
                r0 = a.a.a.a.eN(1, this.tuJ.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tuK != null) {
                r0 += a.a.a.a.eN(2, this.tuK.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tuJ == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.tuK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BannerImg");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            pc pcVar = (pc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a pnVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        pnVar = new pn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pnVar.a(aVar4, pnVar, a.a(aVar4))) {
                        }
                        pcVar.tuJ = pnVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        pnVar = new pd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pnVar.a(aVar4, pnVar, a.a(aVar4))) {
                        }
                        pcVar.tuK = pnVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
