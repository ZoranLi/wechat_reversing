package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aec extends a {
    public String jNj;
    public String jOp;
    public String tBM;
    public String tJy;
    public String tJz;
    public int thX;
    public String tjl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tjl != null) {
                aVar.e(1, this.tjl);
            }
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            if (this.tJy != null) {
                aVar.e(3, this.tJy);
            }
            if (this.tJz != null) {
                aVar.e(4, this.tJz);
            }
            aVar.eO(5, this.thX);
            if (this.jOp != null) {
                aVar.e(6, this.jOp);
            }
            if (this.tBM == null) {
                return 0;
            }
            aVar.e(7, this.tBM);
            return 0;
        } else if (i == 1) {
            if (this.tjl != null) {
                r0 = a.a.a.b.b.a.f(1, this.tjl) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            if (this.tJy != null) {
                r0 += a.a.a.b.b.a.f(3, this.tJy);
            }
            if (this.tJz != null) {
                r0 += a.a.a.b.b.a.f(4, this.tJz);
            }
            r0 += a.a.a.a.eL(5, this.thX);
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(6, this.jOp);
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(7, this.tBM);
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
            aec com_tencent_mm_protocal_c_aec = (aec) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aec.tjl = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aec.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aec.tJy = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aec.tJz = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aec.thX = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aec.jOp = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aec.tBM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
