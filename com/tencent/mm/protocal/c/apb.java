package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class apb extends a {
    public int jNW;
    public int jOb;
    public String msj;
    public int mvT;
    public avw tUb;
    public avw tfV;
    public String tuV;
    public String tup;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.mvT);
            aVar.eO(2, this.jOb);
            if (this.msj != null) {
                aVar.e(3, this.msj);
            }
            aVar.eO(4, this.jNW);
            if (this.tfV != null) {
                aVar.eQ(5, this.tfV.aUk());
                this.tfV.a(aVar);
            }
            if (this.tuV != null) {
                aVar.e(6, this.tuV);
            }
            if (this.tUb != null) {
                aVar.eQ(7, this.tUb.aUk());
                this.tUb.a(aVar);
            }
            if (this.tup != null) {
                aVar.e(8, this.tup);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.mvT) + 0) + a.a.a.a.eL(2, this.jOb);
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(3, this.msj);
            }
            r0 += a.a.a.a.eL(4, this.jNW);
            if (this.tfV != null) {
                r0 += a.a.a.a.eN(5, this.tfV.aUk());
            }
            if (this.tuV != null) {
                r0 += a.a.a.b.b.a.f(6, this.tuV);
            }
            if (this.tUb != null) {
                r0 += a.a.a.a.eN(7, this.tUb.aUk());
            }
            if (this.tup != null) {
                return r0 + a.a.a.b.b.a.f(8, this.tup);
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
            apb com_tencent_mm_protocal_c_apb = (apb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_apb.mvT = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apb.jOb = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apb.msj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apb.jNW = aVar3.xmD.mL();
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
                        com_tencent_mm_protocal_c_apb.tfV = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apb.tuV = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apb.tUb = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_apb.tup = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
