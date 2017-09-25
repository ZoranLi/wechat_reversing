package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bbu extends a {
    public int qsL;
    public int qsM;
    public String tfY;
    public String tfZ;
    public String tga;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfY != null) {
                aVar.e(1, this.tfY);
            }
            if (this.tfZ != null) {
                aVar.e(2, this.tfZ);
            }
            if (this.tga != null) {
                aVar.e(3, this.tga);
            }
            aVar.eO(4, this.qsL);
            aVar.eO(5, this.qsM);
            return 0;
        } else if (i == 1) {
            if (this.tfY != null) {
                r0 = a.a.a.b.b.a.f(1, this.tfY) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tfZ);
            }
            if (this.tga != null) {
                r0 += a.a.a.b.b.a.f(3, this.tga);
            }
            return (r0 + a.a.a.a.eL(4, this.qsL)) + a.a.a.a.eL(5, this.qsM);
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
            bbu com_tencent_mm_protocal_c_bbu = (bbu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bbu.tfY = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbu.tfZ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbu.tga = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbu.qsL = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbu.qsM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
