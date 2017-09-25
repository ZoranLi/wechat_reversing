package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class aog extends a {
    public int tTo;
    public String tTp;
    public avw tTq;
    public int tTr;
    public b tiB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tTq == null) {
                throw new a.a.a.b("Not all required fields were included: ClientKey");
            }
            aVar.eO(1, this.tTo);
            if (this.tiB != null) {
                aVar.b(2, this.tiB);
            }
            if (this.tTp != null) {
                aVar.e(3, this.tTp);
            }
            if (this.tTq != null) {
                aVar.eQ(4, this.tTq.aUk());
                this.tTq.a(aVar);
            }
            aVar.eO(5, this.tTr);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tTo) + 0;
            if (this.tiB != null) {
                r0 += a.a.a.a.a(2, this.tiB);
            }
            if (this.tTp != null) {
                r0 += a.a.a.b.b.a.f(3, this.tTp);
            }
            if (this.tTq != null) {
                r0 += a.a.a.a.eN(4, this.tTq.aUk());
            }
            return r0 + a.a.a.a.eL(5, this.tTr);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tTq != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: ClientKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aog com_tencent_mm_protocal_c_aog = (aog) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aog.tTo = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aog.tiB = aVar3.cic();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aog.tTp = aVar3.xmD.readString();
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
                        com_tencent_mm_protocal_c_aog.tTq = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aog.tTr = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
