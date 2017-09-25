package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class avz extends a {
    public String msj;
    public int ogM;
    public String thD;
    public String ttx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msj != null) {
                aVar.e(1, this.msj);
            }
            if (this.ttx != null) {
                aVar.e(2, this.ttx);
            }
            if (this.thD != null) {
                aVar.e(3, this.thD);
            }
            aVar.eO(4, this.ogM);
            return 0;
        } else if (i == 1) {
            if (this.msj != null) {
                r0 = a.a.a.b.b.a.f(1, this.msj) + 0;
            } else {
                r0 = 0;
            }
            if (this.ttx != null) {
                r0 += a.a.a.b.b.a.f(2, this.ttx);
            }
            if (this.thD != null) {
                r0 += a.a.a.b.b.a.f(3, this.thD);
            }
            return r0 + a.a.a.a.eL(4, this.ogM);
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
            avz com_tencent_mm_protocal_c_avz = (avz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avz.msj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avz.ttx = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avz.thD = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avz.ogM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
