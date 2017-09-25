package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bjr extends a {
    public int tiL;
    public String trv;
    public avw uhb;
    public int uje;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uhb == null) {
                throw new b("Not all required fields were included: Text");
            }
            if (this.uhb != null) {
                aVar.eQ(1, this.uhb.aUk());
                this.uhb.a(aVar);
            }
            if (this.trv != null) {
                aVar.e(2, this.trv);
            }
            aVar.eO(3, this.tiL);
            aVar.eO(4, this.uje);
            return 0;
        } else if (i == 1) {
            if (this.uhb != null) {
                r0 = a.a.a.a.eN(1, this.uhb.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.trv != null) {
                r0 += a.a.a.b.b.a.f(2, this.trv);
            }
            return (r0 + a.a.a.a.eL(3, this.tiL)) + a.a.a.a.eL(4, this.uje);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uhb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Text");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bjr com_tencent_mm_protocal_c_bjr = (bjr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjr.uhb = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjr.trv = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjr.tiL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjr.uje = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
