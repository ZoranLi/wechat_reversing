package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class apf extends avp {
    public int leR;
    public String leS;
    public String tBn;
    public String tBo;
    public String tUn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            if (this.tBo != null) {
                aVar.e(2, this.tBo);
            }
            aVar.eO(3, this.leR);
            if (this.leS != null) {
                aVar.e(4, this.leS);
            }
            if (this.tBn != null) {
                aVar.e(5, this.tBn);
            }
            if (this.tUn == null) {
                return 0;
            }
            aVar.e(6, this.tUn);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tBo != null) {
                r0 += a.a.a.b.b.a.f(2, this.tBo);
            }
            r0 += a.a.a.a.eL(3, this.leR);
            if (this.leS != null) {
                r0 += a.a.a.b.b.a.f(4, this.leS);
            }
            if (this.tBn != null) {
                r0 += a.a.a.b.b.a.f(5, this.tBn);
            }
            if (this.tUn != null) {
                r0 += a.a.a.b.b.a.f(6, this.tUn);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            apf com_tencent_mm_protocal_c_apf = (apf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apf.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apf.tBo = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apf.leR = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apf.leS = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apf.tBn = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apf.tUn = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
