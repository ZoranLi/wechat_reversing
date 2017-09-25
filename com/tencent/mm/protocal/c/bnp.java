package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bnp extends a {
    public String gtZ;
    public String jNo;
    public int tfT;
    public String tst;
    public String umA;
    public String umB;
    public String umC;
    public String umD;
    public String umE;
    public String umF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umA == null) {
                throw new b("Not all required fields were included: LocalNodeId");
            }
            if (this.umA != null) {
                aVar.e(1, this.umA);
            }
            if (this.jNo != null) {
                aVar.e(2, this.jNo);
            }
            if (this.umB != null) {
                aVar.e(3, this.umB);
            }
            if (this.gtZ != null) {
                aVar.e(4, this.gtZ);
            }
            if (this.umC != null) {
                aVar.e(5, this.umC);
            }
            if (this.tst != null) {
                aVar.e(6, this.tst);
            }
            if (this.umD != null) {
                aVar.e(7, this.umD);
            }
            if (this.umE != null) {
                aVar.e(8, this.umE);
            }
            if (this.umF != null) {
                aVar.e(9, this.umF);
            }
            aVar.eO(10, this.tfT);
            return 0;
        } else if (i == 1) {
            if (this.umA != null) {
                r0 = a.a.a.b.b.a.f(1, this.umA) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNo != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNo);
            }
            if (this.umB != null) {
                r0 += a.a.a.b.b.a.f(3, this.umB);
            }
            if (this.gtZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.gtZ);
            }
            if (this.umC != null) {
                r0 += a.a.a.b.b.a.f(5, this.umC);
            }
            if (this.tst != null) {
                r0 += a.a.a.b.b.a.f(6, this.tst);
            }
            if (this.umD != null) {
                r0 += a.a.a.b.b.a.f(7, this.umD);
            }
            if (this.umE != null) {
                r0 += a.a.a.b.b.a.f(8, this.umE);
            }
            if (this.umF != null) {
                r0 += a.a.a.b.b.a.f(9, this.umF);
            }
            return r0 + a.a.a.a.eL(10, this.tfT);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LocalNodeId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bnp com_tencent_mm_protocal_c_bnp = (bnp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bnp.umA = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnp.jNo = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnp.umB = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnp.gtZ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bnp.umC = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bnp.tst = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bnp.umD = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bnp.umE = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bnp.umF = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bnp.tfT = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
