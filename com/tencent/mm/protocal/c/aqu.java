package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aqu extends a {
    public float tmZ;
    public float tna;
    public int twQ;
    public String twR;
    public String twS;
    public int twT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.n(1, this.tmZ);
            aVar.n(2, this.tna);
            aVar.eO(3, this.twQ);
            if (this.twR != null) {
                aVar.e(4, this.twR);
            }
            if (this.twS != null) {
                aVar.e(5, this.twS);
            }
            aVar.eO(6, this.twT);
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.b.b.a.cH(1) + 4) + 0) + (a.a.a.b.b.a.cH(2) + 4)) + a.a.a.a.eL(3, this.twQ);
            if (this.twR != null) {
                r0 += a.a.a.b.b.a.f(4, this.twR);
            }
            if (this.twS != null) {
                r0 += a.a.a.b.b.a.f(5, this.twS);
            }
            return r0 + a.a.a.a.eL(6, this.twT);
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
            aqu com_tencent_mm_protocal_c_aqu = (aqu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqu.tmZ = aVar3.xmD.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqu.tna = aVar3.xmD.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqu.twQ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqu.twR = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqu.twS = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqu.twT = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
