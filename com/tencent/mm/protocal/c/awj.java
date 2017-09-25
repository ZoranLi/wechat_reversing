package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class awj extends avh {
    public String fTO;
    public String state;
    public int tTe;
    public LinkedList<String> tTf = new LinkedList();
    public String tZC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(3, this.tTe);
            aVar.d(4, 1, this.tTf);
            if (this.fTO != null) {
                aVar.e(5, this.fTO);
            }
            if (this.state != null) {
                aVar.e(6, this.state);
            }
            if (this.tZC == null) {
                return 0;
            }
            aVar.e(7, this.tZC);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tTe)) + a.a.a.a.c(4, 1, this.tTf);
            if (this.fTO != null) {
                r0 += a.a.a.b.b.a.f(5, this.fTO);
            }
            if (this.state != null) {
                r0 += a.a.a.b.b.a.f(6, this.state);
            }
            if (this.tZC != null) {
                r0 += a.a.a.b.b.a.f(7, this.tZC);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tTf.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awj com_tencent_mm_protocal_c_awj = (awj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awj.tYN = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awj.tTe = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awj.tTf.add(aVar3.xmD.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awj.fTO = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awj.state = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awj.tZC = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
