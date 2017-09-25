package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bjp extends a {
    public int tgK;
    public int ujb;
    public int ujc;
    public avw ujd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ujd == null) {
                throw new b("Not all required fields were included: PieceData");
            }
            aVar.eO(1, this.tgK);
            aVar.eO(2, this.ujb);
            aVar.eO(3, this.ujc);
            if (this.ujd != null) {
                aVar.eQ(4, this.ujd.aUk());
                this.ujd.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.tgK) + 0) + a.a.a.a.eL(2, this.ujb)) + a.a.a.a.eL(3, this.ujc);
            if (this.ujd != null) {
                return r0 + a.a.a.a.eN(4, this.ujd.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ujd != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PieceData");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bjp com_tencent_mm_protocal_c_bjp = (bjp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bjp.tgK = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjp.ujb = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjp.ujc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjp.ujd = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
