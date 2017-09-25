package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bhn extends avh {
    public String jNj;
    public int tET;
    public int tgJ;
    public int tgK;
    public avw tsk;
    public String ugW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tgJ);
            aVar.eO(3, this.tgK);
            aVar.eO(4, this.tET);
            if (this.tsk != null) {
                aVar.eQ(5, this.tsk.aUk());
                this.tsk.a(aVar);
            }
            if (this.ugW != null) {
                aVar.e(6, this.ugW);
            }
            if (this.jNj == null) {
                return 0;
            }
            aVar.e(7, this.jNj);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.tgJ)) + a.a.a.a.eL(3, this.tgK)) + a.a.a.a.eL(4, this.tET);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(5, this.tsk.aUk());
            }
            if (this.ugW != null) {
                r0 += a.a.a.b.b.a.f(6, this.ugW);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(7, this.jNj);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhn com_tencent_mm_protocal_c_bhn = (bhn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhn.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhn.tgJ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhn.tgK = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhn.tET = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhn.tsk = emVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhn.ugW = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhn.jNj = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
