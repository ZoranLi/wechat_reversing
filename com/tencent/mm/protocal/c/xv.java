package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class xv extends a {
    public avw tfG;
    public String tgW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgW == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.tfG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.tgW != null) {
                    aVar.e(1, this.tgW);
                }
                if (this.tfG == null) {
                    return 0;
                }
                aVar.eQ(2, this.tfG.aUk());
                this.tfG.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tgW != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgW) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfG != null) {
                r0 += a.a.a.a.eN(2, this.tfG.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgW == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.tfG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xv xvVar = (xv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    xvVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        xvVar.tfG = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
