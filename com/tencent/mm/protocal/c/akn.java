package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class akn extends a {
    public String fTO;
    public int tLJ;
    public int tOe;
    public int tOf;
    public String tOg;
    public int tOh;
    public int tdM;
    public int tkv;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fTO != null) {
                aVar.e(1, this.fTO);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.eO(3, this.tLJ);
            aVar.eO(4, this.tkv);
            aVar.eO(5, this.tdM);
            aVar.eO(6, this.tOe);
            aVar.eO(7, this.tOf);
            if (this.tOg != null) {
                aVar.e(8, this.tOg);
            }
            aVar.eO(9, this.tOh);
            return 0;
        } else if (i == 1) {
            if (this.fTO != null) {
                r0 = a.a.a.b.b.a.f(1, this.fTO) + 0;
            } else {
                r0 = 0;
            }
            if (this.username != null) {
                r0 += a.a.a.b.b.a.f(2, this.username);
            }
            r0 = ((((r0 + a.a.a.a.eL(3, this.tLJ)) + a.a.a.a.eL(4, this.tkv)) + a.a.a.a.eL(5, this.tdM)) + a.a.a.a.eL(6, this.tOe)) + a.a.a.a.eL(7, this.tOf);
            if (this.tOg != null) {
                r0 += a.a.a.b.b.a.f(8, this.tOg);
            }
            return r0 + a.a.a.a.eL(9, this.tOh);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            akn com_tencent_mm_protocal_c_akn = (akn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akn.fTO = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akn.username = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akn.tLJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akn.tkv = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akn.tdM = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akn.tOe = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akn.tOf = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_akn.tOg = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_akn.tOh = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
