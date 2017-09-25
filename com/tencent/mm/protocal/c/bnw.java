package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bnw extends a {
    public int mtd;
    public String opI;
    public String tNz;
    public String umH;
    public long umI;
    public long umN;
    public boolean umO;
    public b umP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tNz == null) {
                throw new a.a.a.b("Not all required fields were included: Nickname");
            } else if (this.opI == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else {
                aVar.O(1, this.umI);
                if (this.tNz != null) {
                    aVar.e(2, this.tNz);
                }
                if (this.opI != null) {
                    aVar.e(3, this.opI);
                }
                aVar.eO(4, this.mtd);
                if (this.umH != null) {
                    aVar.e(5, this.umH);
                }
                aVar.O(6, this.umN);
                aVar.an(7, this.umO);
                if (this.umP != null) {
                    aVar.b(8, this.umP);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.umI) + 0;
            if (this.tNz != null) {
                r0 += a.a.a.b.b.a.f(2, this.tNz);
            }
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(3, this.opI);
            }
            r0 += a.a.a.a.eL(4, this.mtd);
            if (this.umH != null) {
                r0 += a.a.a.b.b.a.f(5, this.umH);
            }
            r0 = (r0 + a.a.a.a.N(6, this.umN)) + (a.a.a.b.b.a.cH(7) + 1);
            if (this.umP != null) {
                return r0 + a.a.a.a.a(8, this.umP);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tNz == null) {
                throw new a.a.a.b("Not all required fields were included: Nickname");
            } else if (this.opI == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else if (this.umH != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Talker");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bnw com_tencent_mm_protocal_c_bnw = (bnw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bnw.umI = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnw.tNz = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnw.opI = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnw.mtd = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bnw.umH = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bnw.umN = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bnw.umO = aVar3.cib();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bnw.umP = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
