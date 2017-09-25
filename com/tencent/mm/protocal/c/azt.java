package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class azt extends a {
    public String fVl;
    public String fVm;
    public String kdE;
    public String tcO;
    public String tcP;
    public int tcQ;
    public String ubd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fVl != null) {
                aVar.e(1, this.fVl);
            }
            if (this.kdE != null) {
                aVar.e(2, this.kdE);
            }
            if (this.fVm != null) {
                aVar.e(3, this.fVm);
            }
            if (this.tcO != null) {
                aVar.e(4, this.tcO);
            }
            if (this.tcP != null) {
                aVar.e(5, this.tcP);
            }
            aVar.eO(6, this.tcQ);
            if (this.ubd == null) {
                return 0;
            }
            aVar.e(7, this.ubd);
            return 0;
        } else if (i == 1) {
            if (this.fVl != null) {
                r0 = a.a.a.b.b.a.f(1, this.fVl) + 0;
            } else {
                r0 = 0;
            }
            if (this.kdE != null) {
                r0 += a.a.a.b.b.a.f(2, this.kdE);
            }
            if (this.fVm != null) {
                r0 += a.a.a.b.b.a.f(3, this.fVm);
            }
            if (this.tcO != null) {
                r0 += a.a.a.b.b.a.f(4, this.tcO);
            }
            if (this.tcP != null) {
                r0 += a.a.a.b.b.a.f(5, this.tcP);
            }
            r0 += a.a.a.a.eL(6, this.tcQ);
            if (this.ubd != null) {
                r0 += a.a.a.b.b.a.f(7, this.ubd);
            }
            return r0;
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
            azt com_tencent_mm_protocal_c_azt = (azt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_azt.fVl = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azt.kdE = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azt.fVm = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azt.tcO = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azt.tcP = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azt.tcQ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azt.ubd = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
