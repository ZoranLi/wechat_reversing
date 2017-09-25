package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class bkq extends avp {
    public long tvM;
    public long ujT;
    public int ukb;
    public int ukc;
    public int ukd;
    public int uke;
    public b ukf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.O(2, this.ujT);
            aVar.O(3, this.tvM);
            aVar.eO(4, this.ukb);
            aVar.eO(5, this.ukc);
            aVar.eO(6, this.ukd);
            aVar.eO(7, this.uke);
            if (this.ukf == null) {
                return 0;
            }
            aVar.b(8, this.ukf);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((((r0 + a.a.a.a.N(2, this.ujT)) + a.a.a.a.N(3, this.tvM)) + a.a.a.a.eL(4, this.ukb)) + a.a.a.a.eL(5, this.ukc)) + a.a.a.a.eL(6, this.ukd)) + a.a.a.a.eL(7, this.uke);
            if (this.ukf != null) {
                r0 += a.a.a.a.a(8, this.ukf);
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
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bkq com_tencent_mm_protocal_c_bkq = (bkq) objArr[1];
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
                        com_tencent_mm_protocal_c_bkq.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkq.ujT = aVar3.xmD.mM();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkq.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkq.ukb = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkq.ukc = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkq.ukd = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bkq.uke = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bkq.ukf = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
