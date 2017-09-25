package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class dw extends a {
    public dx thG;
    public du thH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.thG == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.thH == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.thG != null) {
                    aVar.eQ(1, this.thG.aUk());
                    this.thG.a(aVar);
                }
                if (this.thH == null) {
                    return 0;
                }
                aVar.eQ(2, this.thH.aUk());
                this.thH.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.thG != null) {
                r0 = a.a.a.a.eN(1, this.thG.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.thH != null) {
                r0 += a.a.a.a.eN(2, this.thH.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.thG == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.thH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dw dwVar = (dw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a dxVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        dxVar = new dx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dxVar.a(aVar4, dxVar, a.a(aVar4))) {
                        }
                        dwVar.thG = dxVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        dxVar = new du();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dxVar.a(aVar4, dxVar, a.a(aVar4))) {
                        }
                        dwVar.thH = dxVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
