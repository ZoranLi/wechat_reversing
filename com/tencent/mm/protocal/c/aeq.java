package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aeq extends avp {
    public avw tJR;
    public avw tJS;
    public int tJT;
    public int tJU;
    public int tJV;
    public avw the;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.the == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.tJR == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.tJS == null) {
                throw new b("Not all required fields were included: KeyBuffer");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.the != null) {
                    aVar.eQ(2, this.the.aUk());
                    this.the.a(aVar);
                }
                if (this.tJR != null) {
                    aVar.eQ(3, this.tJR.aUk());
                    this.tJR.a(aVar);
                }
                if (this.tJS != null) {
                    aVar.eQ(4, this.tJS.aUk());
                    this.tJS.a(aVar);
                }
                aVar.eO(5, this.tJT);
                aVar.eO(6, this.tJU);
                aVar.eO(7, this.tJV);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.the != null) {
                r0 += a.a.a.a.eN(2, this.the.aUk());
            }
            if (this.tJR != null) {
                r0 += a.a.a.a.eN(3, this.tJR.aUk());
            }
            if (this.tJS != null) {
                r0 += a.a.a.a.eN(4, this.tJS.aUk());
            }
            return ((r0 + a.a.a.a.eL(5, this.tJT)) + a.a.a.a.eL(6, this.tJU)) + a.a.a.a.eL(7, this.tJV);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.the == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.tJR == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.tJS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aeq com_tencent_mm_protocal_c_aeq = (aeq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aeq.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aeq.the = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aeq.tJR = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aeq.tJS = enVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aeq.tJT = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aeq.tJU = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aeq.tJV = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
