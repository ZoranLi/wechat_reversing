package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bmp extends a {
    public String ohj;
    public String tOp;
    public String tYA;
    public int tdM;
    public String ulZ;
    public String uma;
    public int umb;
    public String umc;
    public String umd;
    public String ume;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ulZ != null) {
                aVar.e(1, this.ulZ);
            }
            if (this.uma != null) {
                aVar.e(2, this.uma);
            }
            if (this.tOp != null) {
                aVar.e(3, this.tOp);
            }
            if (this.tYA != null) {
                aVar.e(4, this.tYA);
            }
            aVar.eO(5, this.umb);
            if (this.ohj != null) {
                aVar.e(6, this.ohj);
            }
            if (this.umc != null) {
                aVar.e(7, this.umc);
            }
            if (this.umd != null) {
                aVar.e(8, this.umd);
            }
            aVar.eO(9, this.tdM);
            if (this.ume == null) {
                return 0;
            }
            aVar.e(19, this.ume);
            return 0;
        } else if (i == 1) {
            if (this.ulZ != null) {
                r0 = a.a.a.b.b.a.f(1, this.ulZ) + 0;
            } else {
                r0 = 0;
            }
            if (this.uma != null) {
                r0 += a.a.a.b.b.a.f(2, this.uma);
            }
            if (this.tOp != null) {
                r0 += a.a.a.b.b.a.f(3, this.tOp);
            }
            if (this.tYA != null) {
                r0 += a.a.a.b.b.a.f(4, this.tYA);
            }
            r0 += a.a.a.a.eL(5, this.umb);
            if (this.ohj != null) {
                r0 += a.a.a.b.b.a.f(6, this.ohj);
            }
            if (this.umc != null) {
                r0 += a.a.a.b.b.a.f(7, this.umc);
            }
            if (this.umd != null) {
                r0 += a.a.a.b.b.a.f(8, this.umd);
            }
            r0 += a.a.a.a.eL(9, this.tdM);
            if (this.ume != null) {
                r0 += a.a.a.b.b.a.f(19, this.ume);
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
            bmp com_tencent_mm_protocal_c_bmp = (bmp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bmp.ulZ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmp.uma = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bmp.tOp = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bmp.tYA = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bmp.umb = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bmp.ohj = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bmp.umc = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bmp.umd = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bmp.tdM = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bmp.ume = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
