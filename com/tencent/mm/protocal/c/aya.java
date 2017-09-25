package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aya extends a {
    public String fFW;
    public int hYY;
    public int hhC;
    public int hhD;
    public String hhE;
    public int iap;
    public String qaM;
    public LinkedList<bfi> uap = new LinkedList();
    public int uaq;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.qaM == null) {
                throw new b("Not all required fields were included: clientID");
            }
            aVar.d(1, 8, this.uap);
            if (this.qaM != null) {
                aVar.e(2, this.qaM);
            }
            if (this.fFW != null) {
                aVar.e(3, this.fFW);
            }
            if (this.hhE != null) {
                aVar.e(4, this.hhE);
            }
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.eO(6, this.iap);
            aVar.eO(7, this.hYY);
            aVar.eO(8, this.uaq);
            aVar.eO(9, this.hhC);
            aVar.eO(10, this.hhD);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.uap) + 0;
            if (this.qaM != null) {
                r0 += a.a.a.b.b.a.f(2, this.qaM);
            }
            if (this.fFW != null) {
                r0 += a.a.a.b.b.a.f(3, this.fFW);
            }
            if (this.hhE != null) {
                r0 += a.a.a.b.b.a.f(4, this.hhE);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(5, this.url);
            }
            return ((((r0 + a.a.a.a.eL(6, this.iap)) + a.a.a.a.eL(7, this.hYY)) + a.a.a.a.eL(8, this.uaq)) + a.a.a.a.eL(9, this.hhC)) + a.a.a.a.eL(10, this.hhD);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uap.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.qaM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: clientID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aya com_tencent_mm_protocal_c_aya = (aya) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bfi = new bfi();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bfi.a(aVar4, com_tencent_mm_protocal_c_bfi, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aya.uap.add(com_tencent_mm_protocal_c_bfi);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aya.qaM = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aya.fFW = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aya.hhE = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aya.url = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aya.iap = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aya.hYY = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aya.uaq = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aya.hhC = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aya.hhD = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
