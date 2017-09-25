package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class asb extends avp {
    public int leR;
    public String leS;
    public int mNR;
    public String mNS;
    public int mOh;
    public int tWu;
    public int tWw;
    public int tWx;
    public int tvL;
    public long tvM;

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
            aVar.eO(3, this.tvL);
            aVar.O(4, this.tvM);
            aVar.eO(5, this.tWw);
            aVar.eO(6, this.tWu);
            aVar.eO(7, this.mOh);
            aVar.eO(8, this.tWx);
            aVar.eO(9, this.leR);
            if (this.leS != null) {
                aVar.e(10, this.leS);
            }
            aVar.eO(11, this.mNR);
            if (this.mNS == null) {
                return 0;
            }
            aVar.e(12, this.mNS);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + a.a.a.a.eL(3, this.tvL)) + a.a.a.a.N(4, this.tvM)) + a.a.a.a.eL(5, this.tWw)) + a.a.a.a.eL(6, this.tWu)) + a.a.a.a.eL(7, this.mOh)) + a.a.a.a.eL(8, this.tWx)) + a.a.a.a.eL(9, this.leR);
            if (this.leS != null) {
                r0 += a.a.a.b.b.a.f(10, this.leS);
            }
            r0 += a.a.a.a.eL(11, this.mNR);
            if (this.mNS != null) {
                r0 += a.a.a.b.b.a.f(12, this.mNS);
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
            asb com_tencent_mm_protocal_c_asb = (asb) objArr[1];
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
                        com_tencent_mm_protocal_c_asb.tZe = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asb.tvL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asb.tvM = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asb.tWw = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asb.tWu = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asb.mOh = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_asb.tWx = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_asb.leR = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_asb.leS = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_asb.mNR = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_asb.mNS = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
