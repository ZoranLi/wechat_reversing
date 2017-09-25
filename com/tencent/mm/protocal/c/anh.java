package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class anh extends a {
    public String tSe;
    public String tSf;
    public int tSg;
    public int tSh;
    public int tSi;
    public int tSj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tSe != null) {
                aVar.e(1, this.tSe);
            }
            if (this.tSf != null) {
                aVar.e(2, this.tSf);
            }
            aVar.eO(3, this.tSg);
            aVar.eO(4, this.tSh);
            aVar.eO(5, this.tSi);
            aVar.eO(7, this.tSj);
            return 0;
        } else if (i == 1) {
            if (this.tSe != null) {
                r0 = a.a.a.b.b.a.f(1, this.tSe) + 0;
            } else {
                r0 = 0;
            }
            if (this.tSf != null) {
                r0 += a.a.a.b.b.a.f(2, this.tSf);
            }
            return (((r0 + a.a.a.a.eL(3, this.tSg)) + a.a.a.a.eL(4, this.tSh)) + a.a.a.a.eL(5, this.tSi)) + a.a.a.a.eL(7, this.tSj);
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
            anh com_tencent_mm_protocal_c_anh = (anh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_anh.tSe = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anh.tSf = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anh.tSg = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anh.tSh = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_anh.tSi = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_anh.tSj = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
