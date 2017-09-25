package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aqw extends a {
    public int tFd;
    public String tFe;
    public String tFf;
    public bfw tVq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tFd);
            if (this.tFe != null) {
                aVar.e(2, this.tFe);
            }
            if (this.tFf != null) {
                aVar.e(3, this.tFf);
            }
            if (this.tVq != null) {
                aVar.eQ(4, this.tVq.aUk());
                this.tVq.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tFd) + 0;
            if (this.tFe != null) {
                r0 += a.a.a.b.b.a.f(2, this.tFe);
            }
            if (this.tFf != null) {
                r0 += a.a.a.b.b.a.f(3, this.tFf);
            }
            if (this.tVq != null) {
                return r0 + a.a.a.a.eN(4, this.tVq.aUk());
            }
            return r0;
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
            aqw com_tencent_mm_protocal_c_aqw = (aqw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aqw.tFd = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqw.tFe = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqw.tFf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bfw = new bfw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bfw.a(aVar4, com_tencent_mm_protocal_c_bfw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqw.tVq = com_tencent_mm_protocal_c_bfw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
