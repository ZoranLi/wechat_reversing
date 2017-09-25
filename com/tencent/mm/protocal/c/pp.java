package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class pp extends a {
    public pq tvI;
    public po tvJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tvI == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.tvJ == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.tvI != null) {
                    aVar.eQ(1, this.tvI.aUk());
                    this.tvI.a(aVar);
                }
                if (this.tvJ == null) {
                    return 0;
                }
                aVar.eQ(2, this.tvJ.aUk());
                this.tvJ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tvI != null) {
                r0 = a.a.a.a.eN(1, this.tvI.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tvJ != null) {
                r0 += a.a.a.a.eN(2, this.tvJ.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tvI == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.tvJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            pp ppVar = (pp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a pqVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        pqVar = new pq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pqVar.a(aVar4, pqVar, a.a(aVar4))) {
                        }
                        ppVar.tvI = pqVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        pqVar = new po();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pqVar.a(aVar4, pqVar, a.a(aVar4))) {
                        }
                        ppVar.tvJ = pqVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
