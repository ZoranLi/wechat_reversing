package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class lk extends a {
    public int jOg;
    public int leD;
    public LinkedList<aic> muY = new LinkedList();
    public int tiC;
    public String tlu;
    public String tlv;
    public String tlw;
    public String tlx;
    public String tly;
    public int trD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.leD);
            if (this.tlw != null) {
                aVar.e(7, this.tlw);
            }
            aVar.eO(2, this.tiC);
            aVar.eO(3, this.trD);
            aVar.d(4, 8, this.muY);
            if (this.tlu != null) {
                aVar.e(5, this.tlu);
            }
            if (this.tlv != null) {
                aVar.e(6, this.tlv);
            }
            if (this.tlx != null) {
                aVar.e(8, this.tlx);
            }
            if (this.tly != null) {
                aVar.e(9, this.tly);
            }
            aVar.eO(10, this.jOg);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.leD) + 0;
            if (this.tlw != null) {
                r0 += a.a.a.b.b.a.f(7, this.tlw);
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.tiC)) + a.a.a.a.eL(3, this.trD)) + a.a.a.a.c(4, 8, this.muY);
            if (this.tlu != null) {
                r0 += a.a.a.b.b.a.f(5, this.tlu);
            }
            if (this.tlv != null) {
                r0 += a.a.a.b.b.a.f(6, this.tlv);
            }
            if (this.tlx != null) {
                r0 += a.a.a.b.b.a.f(8, this.tlx);
            }
            if (this.tly != null) {
                r0 += a.a.a.b.b.a.f(9, this.tly);
            }
            return r0 + a.a.a.a.eL(10, this.jOg);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.muY.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            lk lkVar = (lk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lkVar.leD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    lkVar.tiC = aVar3.xmD.mL();
                    return 0;
                case 3:
                    lkVar.trD = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aic = new aic();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aic.a(aVar4, com_tencent_mm_protocal_c_aic, a.a(aVar4))) {
                        }
                        lkVar.muY.add(com_tencent_mm_protocal_c_aic);
                    }
                    return 0;
                case 5:
                    lkVar.tlu = aVar3.xmD.readString();
                    return 0;
                case 6:
                    lkVar.tlv = aVar3.xmD.readString();
                    return 0;
                case 7:
                    lkVar.tlw = aVar3.xmD.readString();
                    return 0;
                case 8:
                    lkVar.tlx = aVar3.xmD.readString();
                    return 0;
                case 9:
                    lkVar.tly = aVar3.xmD.readString();
                    return 0;
                case 10:
                    lkVar.jOg = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
