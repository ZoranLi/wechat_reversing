package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bdd extends a {
    public int aOD;
    public String appName;
    public String uer;
    public boolean ues;
    public boolean uet;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uer != null) {
                aVar.e(1, this.uer);
            }
            if (this.appName != null) {
                aVar.e(2, this.appName);
            }
            aVar.eO(3, this.aOD);
            aVar.an(4, this.ues);
            aVar.an(5, this.uet);
            return 0;
        } else if (i == 1) {
            if (this.uer != null) {
                r0 = a.a.a.b.b.a.f(1, this.uer) + 0;
            } else {
                r0 = 0;
            }
            if (this.appName != null) {
                r0 += a.a.a.b.b.a.f(2, this.appName);
            }
            return ((r0 + a.a.a.a.eL(3, this.aOD)) + (a.a.a.b.b.a.cH(4) + 1)) + (a.a.a.b.b.a.cH(5) + 1);
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
            bdd com_tencent_mm_protocal_c_bdd = (bdd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bdd.uer = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdd.appName = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdd.aOD = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdd.ues = aVar3.cib();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdd.uet = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
