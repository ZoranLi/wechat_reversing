package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aew extends a {
    public el tJY;
    public ij tJZ;
    public aln tKa;
    public bdr tKb;
    public awi tKc;
    public lw tKd;
    public sg tKe;
    public sv tKf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tJY != null) {
                aVar.eQ(1, this.tJY.aUk());
                this.tJY.a(aVar);
            }
            if (this.tJZ != null) {
                aVar.eQ(2, this.tJZ.aUk());
                this.tJZ.a(aVar);
            }
            if (this.tKa != null) {
                aVar.eQ(3, this.tKa.aUk());
                this.tKa.a(aVar);
            }
            if (this.tKb != null) {
                aVar.eQ(4, this.tKb.aUk());
                this.tKb.a(aVar);
            }
            if (this.tKc != null) {
                aVar.eQ(6, this.tKc.aUk());
                this.tKc.a(aVar);
            }
            if (this.tKd != null) {
                aVar.eQ(7, this.tKd.aUk());
                this.tKd.a(aVar);
            }
            if (this.tKe != null) {
                aVar.eQ(8, this.tKe.aUk());
                this.tKe.a(aVar);
            }
            if (this.tKf == null) {
                return 0;
            }
            aVar.eQ(9, this.tKf.aUk());
            this.tKf.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tJY != null) {
                r0 = a.a.a.a.eN(1, this.tJY.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tJZ != null) {
                r0 += a.a.a.a.eN(2, this.tJZ.aUk());
            }
            if (this.tKa != null) {
                r0 += a.a.a.a.eN(3, this.tKa.aUk());
            }
            if (this.tKb != null) {
                r0 += a.a.a.a.eN(4, this.tKb.aUk());
            }
            if (this.tKc != null) {
                r0 += a.a.a.a.eN(6, this.tKc.aUk());
            }
            if (this.tKd != null) {
                r0 += a.a.a.a.eN(7, this.tKd.aUk());
            }
            if (this.tKe != null) {
                r0 += a.a.a.a.eN(8, this.tKe.aUk());
            }
            if (this.tKf != null) {
                r0 += a.a.a.a.eN(9, this.tKf.aUk());
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
            aew com_tencent_mm_protocal_c_aew = (aew) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a elVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new el();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tJY = elVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new ij();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tJZ = elVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new aln();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tKa = elVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new bdr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tKb = elVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new awi();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tKc = elVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new lw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tKd = elVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new sg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tKe = elVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        elVar = new sv();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aew.tKf = elVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
