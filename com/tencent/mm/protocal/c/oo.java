package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class oo extends avp {
    public String tfU;
    public int tfc;
    public long tfk;
    public int tiL;
    public int tll;
    public avw tsk;
    public int tuc;
    public int tue;
    public int tuf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                aVar.eO(1, this.tfc);
                aVar.eO(2, this.tll);
                aVar.eO(3, this.tuc);
                aVar.eO(5, this.tue);
                if (this.tfU != null) {
                    aVar.e(6, this.tfU);
                }
                if (this.tsk != null) {
                    aVar.eQ(7, this.tsk.aUk());
                    this.tsk.a(aVar);
                }
                aVar.eO(8, this.tiL);
                if (this.tZe != null) {
                    aVar.eQ(9, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(10, this.tuf);
                aVar.O(11, this.tfk);
                return 0;
            }
        } else if (i == 1) {
            r0 = (((a.a.a.a.eL(1, this.tfc) + 0) + a.a.a.a.eL(2, this.tll)) + a.a.a.a.eL(3, this.tuc)) + a.a.a.a.eL(5, this.tue);
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(6, this.tfU);
            }
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(7, this.tsk.aUk());
            }
            r0 += a.a.a.a.eL(8, this.tiL);
            if (this.tZe != null) {
                r0 += a.a.a.a.eN(9, this.tZe.aUk());
            }
            return (r0 + a.a.a.a.eL(10, this.tuf)) + a.a.a.a.N(11, this.tfk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.tZe != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            oo ooVar = (oo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ooVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    ooVar.tll = aVar3.xmD.mL();
                    return 0;
                case 3:
                    ooVar.tuc = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ooVar.tue = aVar3.xmD.mL();
                    return 0;
                case 6:
                    ooVar.tfU = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ooVar.tsk = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 8:
                    ooVar.tiL = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ooVar.tZe = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 10:
                    ooVar.tuf = aVar3.xmD.mL();
                    return 0;
                case 11:
                    ooVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
