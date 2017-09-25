package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class apm extends avp {
    public int leR;
    public String leS;
    public String msF;
    public String tBn;
    public String tBo;
    public String tUu;

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
            if (this.tBn != null) {
                aVar.e(2, this.tBn);
            }
            if (this.msF != null) {
                aVar.e(3, this.msF);
            }
            if (this.tBo != null) {
                aVar.e(4, this.tBo);
            }
            aVar.eO(5, this.leR);
            if (this.leS != null) {
                aVar.e(6, this.leS);
            }
            if (this.tUu == null) {
                return 0;
            }
            aVar.e(7, this.tUu);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tBn != null) {
                r0 += a.a.a.b.b.a.f(2, this.tBn);
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(3, this.msF);
            }
            if (this.tBo != null) {
                r0 += a.a.a.b.b.a.f(4, this.tBo);
            }
            r0 += a.a.a.a.eL(5, this.leR);
            if (this.leS != null) {
                r0 += a.a.a.b.b.a.f(6, this.leS);
            }
            if (this.tUu != null) {
                r0 += a.a.a.b.b.a.f(7, this.tUu);
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
            apm com_tencent_mm_protocal_c_apm = (apm) objArr[1];
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
                        com_tencent_mm_protocal_c_apm.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apm.tBn = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apm.msF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apm.tBo = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apm.leR = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apm.leS = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_apm.tUu = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
