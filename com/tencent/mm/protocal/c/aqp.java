package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aqp extends a {
    public bpf tVj;
    public bph tVk;
    public bpb tVl;
    public String trY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.trY == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.trY != null) {
                aVar.e(1, this.trY);
            }
            if (this.tVj != null) {
                aVar.eQ(2, this.tVj.aUk());
                this.tVj.a(aVar);
            }
            if (this.tVk != null) {
                aVar.eQ(3, this.tVk.aUk());
                this.tVk.a(aVar);
            }
            if (this.tVl == null) {
                return 0;
            }
            aVar.eQ(4, this.tVl.aUk());
            this.tVl.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.trY != null) {
                r0 = a.a.a.b.b.a.f(1, this.trY) + 0;
            } else {
                r0 = 0;
            }
            if (this.tVj != null) {
                r0 += a.a.a.a.eN(2, this.tVj.aUk());
            }
            if (this.tVk != null) {
                r0 += a.a.a.a.eN(3, this.tVk.aUk());
            }
            if (this.tVl != null) {
                r0 += a.a.a.a.eN(4, this.tVl.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.trY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aqp com_tencent_mm_protocal_c_aqp = (aqp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bpf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aqp.trY = aVar3.xmD.readString();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bpf = new bpf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bpf.a(aVar4, com_tencent_mm_protocal_c_bpf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqp.tVj = com_tencent_mm_protocal_c_bpf;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bpf = new bph();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bpf.a(aVar4, com_tencent_mm_protocal_c_bpf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqp.tVk = com_tencent_mm_protocal_c_bpf;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bpf = new bpb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bpf.a(aVar4, com_tencent_mm_protocal_c_bpf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqp.tVl = com_tencent_mm_protocal_c_bpf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
