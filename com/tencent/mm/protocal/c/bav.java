package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bav extends a {
    public String teW;
    public long tmx;
    public long ubQ;
    public bau ubR;
    public bau ubS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ubR == null) {
                throw new b("Not all required fields were included: CurrentAction");
            }
            aVar.O(1, this.tmx);
            aVar.O(2, this.ubQ);
            if (this.ubR != null) {
                aVar.eQ(3, this.ubR.aUk());
                this.ubR.a(aVar);
            }
            if (this.ubS != null) {
                aVar.eQ(4, this.ubS.aUk());
                this.ubS.a(aVar);
            }
            if (this.teW != null) {
                aVar.e(5, this.teW);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.N(1, this.tmx) + 0) + a.a.a.a.N(2, this.ubQ);
            if (this.ubR != null) {
                r0 += a.a.a.a.eN(3, this.ubR.aUk());
            }
            if (this.ubS != null) {
                r0 += a.a.a.a.eN(4, this.ubS.aUk());
            }
            if (this.teW != null) {
                return r0 + a.a.a.b.b.a.f(5, this.teW);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ubR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CurrentAction");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bav com_tencent_mm_protocal_c_bav = (bav) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bau;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bav.tmx = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bav.ubQ = aVar3.xmD.mM();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bau = new bau();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bau.a(aVar4, com_tencent_mm_protocal_c_bau, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bav.ubR = com_tencent_mm_protocal_c_bau;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bau = new bau();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bau.a(aVar4, com_tencent_mm_protocal_c_bau, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bav.ubS = com_tencent_mm_protocal_c_bau;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bav.teW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
