package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class afw extends a {
    public avx tKZ;
    public avw tfh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.tKZ == null) {
                throw new b("Not all required fields were included: Username");
            } else {
                if (this.tfh != null) {
                    aVar.eQ(1, this.tfh.aUk());
                    this.tfh.a(aVar);
                }
                if (this.tKZ == null) {
                    return 0;
                }
                aVar.eQ(2, this.tKZ.aUk());
                this.tKZ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tfh != null) {
                r0 = a.a.a.a.eN(1, this.tfh.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tKZ != null) {
                r0 += a.a.a.a.eN(2, this.tKZ.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.tKZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Username");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            afw com_tencent_mm_protocal_c_afw = (afw) objArr[1];
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
                        com_tencent_mm_protocal_c_afw.tfh = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afw.tKZ = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
