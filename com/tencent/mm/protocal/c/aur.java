package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aur extends avp {
    public int tYk;
    public int tYn;
    public int tYo;
    public bjp tYp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tYp == null) {
                throw new b("Not all required fields were included: NextPiece");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(2, this.tYn);
                aVar.eO(3, this.tYo);
                if (this.tYp != null) {
                    aVar.eQ(4, this.tYp.aUk());
                    this.tYp.a(aVar);
                }
                aVar.eO(5, this.tYk);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tYn)) + a.a.a.a.eL(3, this.tYo);
            if (this.tYp != null) {
                r0 += a.a.a.a.eN(4, this.tYp.aUk());
            }
            return r0 + a.a.a.a.eL(5, this.tYk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tYp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NextPiece");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aur com_tencent_mm_protocal_c_aur = (aur) objArr[1];
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
                        com_tencent_mm_protocal_c_aur.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aur.tYn = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aur.tYo = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bjp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aur.tYp = enVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aur.tYk = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
