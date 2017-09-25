package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bjw extends avp {
    public int tvL;
    public long tvM;
    public int ujm;
    public int ujs;
    public blf ujt;
    public int uju;
    public int ujv;
    public int ujw;
    public int ujx;

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
            aVar.eO(2, this.tvL);
            aVar.O(3, this.tvM);
            aVar.eO(4, this.ujs);
            if (this.ujt != null) {
                aVar.eQ(5, this.ujt.aUk());
                this.ujt.a(aVar);
            }
            aVar.eO(6, this.ujm);
            aVar.eO(7, this.uju);
            aVar.eO(8, this.ujv);
            aVar.eO(9, this.ujw);
            aVar.eO(10, this.ujx);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.N(3, this.tvM)) + a.a.a.a.eL(4, this.ujs);
            if (this.ujt != null) {
                r0 += a.a.a.a.eN(5, this.ujt.aUk());
            }
            return ((((r0 + a.a.a.a.eL(6, this.ujm)) + a.a.a.a.eL(7, this.uju)) + a.a.a.a.eL(8, this.ujv)) + a.a.a.a.eL(9, this.ujw)) + a.a.a.a.eL(10, this.ujx);
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
            bjw com_tencent_mm_protocal_c_bjw = (bjw) objArr[1];
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
                        com_tencent_mm_protocal_c_bjw.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjw.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjw.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjw.ujs = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new blf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjw.ujt = enVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjw.ujm = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjw.uju = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bjw.ujv = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bjw.ujw = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bjw.ujx = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
