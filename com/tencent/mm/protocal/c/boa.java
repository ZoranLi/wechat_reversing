package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class boa extends a {
    public String fDC;
    public int mvT;
    public String opI;
    public String umH;
    public int umT;
    public boolean umU;
    public boolean umV;
    public boolean umW;
    public b umz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.fDC == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.opI == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.eO(1, this.mvT);
                if (this.umH != null) {
                    aVar.e(2, this.umH);
                }
                if (this.fDC != null) {
                    aVar.e(3, this.fDC);
                }
                if (this.opI != null) {
                    aVar.e(4, this.opI);
                }
                aVar.eO(5, this.umT);
                if (this.umz != null) {
                    aVar.b(6, this.umz);
                }
                aVar.an(7, this.umU);
                aVar.an(8, this.umV);
                aVar.an(9, this.umW);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.mvT) + 0;
            if (this.umH != null) {
                r0 += a.a.a.b.b.a.f(2, this.umH);
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(3, this.fDC);
            }
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(4, this.opI);
            }
            r0 += a.a.a.a.eL(5, this.umT);
            if (this.umz != null) {
                r0 += a.a.a.a.a(6, this.umz);
            }
            return ((r0 + (a.a.a.b.b.a.cH(7) + 1)) + (a.a.a.b.b.a.cH(8) + 1)) + (a.a.a.b.b.a.cH(9) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.fDC == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.opI != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            boa com_tencent_mm_protocal_c_boa = (boa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_boa.mvT = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_boa.umH = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_boa.fDC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_boa.opI = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_boa.umT = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_boa.umz = aVar3.cic();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_boa.umU = aVar3.cib();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_boa.umV = aVar3.cib();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_boa.umW = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
