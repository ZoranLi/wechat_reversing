package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bd.a;
import com.tencent.mm.protocal.c.alh;
import java.util.LinkedList;

public final class b extends a {
    public alh fVV;
    public int hFf;
    public String qaD;
    public int qaE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fVV != null) {
                aVar.eQ(1, this.fVV.aUk());
                this.fVV.a(aVar);
            }
            if (this.qaD != null) {
                aVar.e(2, this.qaD);
            }
            aVar.eO(3, this.hFf);
            aVar.eO(4, this.qaE);
            return 0;
        } else if (i == 1) {
            if (this.fVV != null) {
                r0 = a.a.a.a.eN(1, this.fVV.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.qaD != null) {
                r0 += a.a.a.b.b.a.f(2, this.qaD);
            }
            return (r0 + a.a.a.a.eL(3, this.hFf)) + a.a.a.a.eL(4, this.qaE);
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_alh = new alh();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_alh.a(aVar4, com_tencent_mm_protocal_c_alh, a.a(aVar4))) {
                        }
                        bVar.fVV = com_tencent_mm_protocal_c_alh;
                    }
                    return 0;
                case 2:
                    bVar.qaD = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bVar.hFf = aVar3.xmD.mL();
                    return 0;
                case 4:
                    bVar.qaE = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
