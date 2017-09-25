package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bor extends a {
    public b tgI;
    public int tuc;
    public String umH;
    public boolean unj;
    public boolean unk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            }
            if (this.umH != null) {
                aVar.e(1, this.umH);
            }
            aVar.eO(2, this.tuc);
            if (this.tgI != null) {
                aVar.b(3, this.tgI);
            }
            aVar.an(4, this.unj);
            aVar.an(5, this.unk);
            return 0;
        } else if (i == 1) {
            if (this.umH != null) {
                r0 = a.a.a.b.b.a.f(1, this.umH) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tuc);
            if (this.tgI != null) {
                r0 += a.a.a.a.a(3, this.tgI);
            }
            return (r0 + (a.a.a.b.b.a.cH(4) + 1)) + (a.a.a.b.b.a.cH(5) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umH != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Talker");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bor com_tencent_mm_protocal_c_bor = (bor) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bor.umH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bor.tuc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bor.tgI = aVar3.cic();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bor.unj = aVar3.cib();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bor.unk = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
