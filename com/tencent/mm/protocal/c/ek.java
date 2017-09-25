package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ek extends a {
    public avw thk;
    public avw thl;
    public String thq;
    public avw tit;
    public bmh tiu;
    public bpn tiv;
    public int tiw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tit != null) {
                aVar.eQ(1, this.tit.aUk());
                this.tit.a(aVar);
            }
            if (this.tiu != null) {
                aVar.eQ(2, this.tiu.aUk());
                this.tiu.a(aVar);
            }
            if (this.tiv != null) {
                aVar.eQ(3, this.tiv.aUk());
                this.tiv.a(aVar);
            }
            if (this.thk != null) {
                aVar.eQ(4, this.thk.aUk());
                this.thk.a(aVar);
            }
            if (this.thl != null) {
                aVar.eQ(5, this.thl.aUk());
                this.thl.a(aVar);
            }
            aVar.eO(6, this.tiw);
            if (this.thq == null) {
                return 0;
            }
            aVar.e(7, this.thq);
            return 0;
        } else if (i == 1) {
            if (this.tit != null) {
                r0 = a.a.a.a.eN(1, this.tit.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tiu != null) {
                r0 += a.a.a.a.eN(2, this.tiu.aUk());
            }
            if (this.tiv != null) {
                r0 += a.a.a.a.eN(3, this.tiv.aUk());
            }
            if (this.thk != null) {
                r0 += a.a.a.a.eN(4, this.thk.aUk());
            }
            if (this.thl != null) {
                r0 += a.a.a.a.eN(5, this.thl.aUk());
            }
            r0 += a.a.a.a.eL(6, this.tiw);
            if (this.thq != null) {
                r0 += a.a.a.b.b.a.f(7, this.thq);
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
            ek ekVar = (ek) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        ekVar.tit = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bmh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        ekVar.tiu = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bpn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        ekVar.tiv = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        ekVar.thk = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        ekVar.thl = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 6:
                    ekVar.tiw = aVar3.xmD.mL();
                    return 0;
                case 7:
                    ekVar.thq = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
