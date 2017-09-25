package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class afg extends a {
    public afl tKA;
    public int tKu;
    public afj tKv;
    public afi tKw;
    public afh tKx;
    public aff tKy;
    public afk tKz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tKu);
            if (this.tKv != null) {
                aVar.eQ(2, this.tKv.aUk());
                this.tKv.a(aVar);
            }
            if (this.tKw != null) {
                aVar.eQ(3, this.tKw.aUk());
                this.tKw.a(aVar);
            }
            if (this.tKx != null) {
                aVar.eQ(4, this.tKx.aUk());
                this.tKx.a(aVar);
            }
            if (this.tKy != null) {
                aVar.eQ(5, this.tKy.aUk());
                this.tKy.a(aVar);
            }
            if (this.tKz != null) {
                aVar.eQ(6, this.tKz.aUk());
                this.tKz.a(aVar);
            }
            if (this.tKA != null) {
                aVar.eQ(7, this.tKA.aUk());
                this.tKA.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tKu) + 0;
            if (this.tKv != null) {
                r0 += a.a.a.a.eN(2, this.tKv.aUk());
            }
            if (this.tKw != null) {
                r0 += a.a.a.a.eN(3, this.tKw.aUk());
            }
            if (this.tKx != null) {
                r0 += a.a.a.a.eN(4, this.tKx.aUk());
            }
            if (this.tKy != null) {
                r0 += a.a.a.a.eN(5, this.tKy.aUk());
            }
            if (this.tKz != null) {
                r0 += a.a.a.a.eN(6, this.tKz.aUk());
            }
            if (this.tKA != null) {
                return r0 + a.a.a.a.eN(7, this.tKA.aUk());
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
            afg com_tencent_mm_protocal_c_afg = (afg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_afj;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_afg.tKu = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afj = new afj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afj.a(aVar4, com_tencent_mm_protocal_c_afj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afg.tKv = com_tencent_mm_protocal_c_afj;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afj = new afi();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afj.a(aVar4, com_tencent_mm_protocal_c_afj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afg.tKw = com_tencent_mm_protocal_c_afj;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afj = new afh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afj.a(aVar4, com_tencent_mm_protocal_c_afj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afg.tKx = com_tencent_mm_protocal_c_afj;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afj = new aff();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afj.a(aVar4, com_tencent_mm_protocal_c_afj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afg.tKy = com_tencent_mm_protocal_c_afj;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afj = new afk();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afj.a(aVar4, com_tencent_mm_protocal_c_afj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afg.tKz = com_tencent_mm_protocal_c_afj;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afj = new afl();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afj.a(aVar4, com_tencent_mm_protocal_c_afj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afg.tKA = com_tencent_mm_protocal_c_afj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
