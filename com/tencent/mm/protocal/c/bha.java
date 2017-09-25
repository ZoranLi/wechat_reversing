package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bha extends avp {
    public int tDA;
    public int tDv;
    public int tDw;
    public int tDx;
    public int tDy;
    public String tDz;
    public String tQJ;

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
            if (this.tQJ != null) {
                aVar.e(2, this.tQJ);
            }
            if (this.tDz != null) {
                aVar.e(3, this.tDz);
            }
            aVar.eO(4, this.tDy);
            aVar.eO(5, this.tDv);
            aVar.eO(6, this.tDw);
            aVar.eO(7, this.tDx);
            aVar.eO(8, this.tDA);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tQJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tQJ);
            }
            if (this.tDz != null) {
                r0 += a.a.a.b.b.a.f(3, this.tDz);
            }
            return ((((r0 + a.a.a.a.eL(4, this.tDy)) + a.a.a.a.eL(5, this.tDv)) + a.a.a.a.eL(6, this.tDw)) + a.a.a.a.eL(7, this.tDx)) + a.a.a.a.eL(8, this.tDA);
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
            bha com_tencent_mm_protocal_c_bha = (bha) objArr[1];
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
                        com_tencent_mm_protocal_c_bha.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bha.tQJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bha.tDz = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bha.tDy = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bha.tDv = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bha.tDw = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bha.tDx = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bha.tDA = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
