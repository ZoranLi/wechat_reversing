package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class auw extends a {
    public String jNO;
    public int pyi;
    public int tYu;
    public int tYv;
    public String tYw;
    public String tlu;
    public String tlv;
    public String tlw;
    public String tlx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNO != null) {
                aVar.e(1, this.jNO);
            }
            aVar.eO(2, this.tYu);
            if (this.tlu != null) {
                aVar.e(3, this.tlu);
            }
            if (this.tlv != null) {
                aVar.e(4, this.tlv);
            }
            aVar.eO(5, this.pyi);
            aVar.eO(6, this.tYv);
            if (this.tlw != null) {
                aVar.e(7, this.tlw);
            }
            if (this.tlx != null) {
                aVar.e(8, this.tlx);
            }
            if (this.tYw == null) {
                return 0;
            }
            aVar.e(9, this.tYw);
            return 0;
        } else if (i == 1) {
            if (this.jNO != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNO) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tYu);
            if (this.tlu != null) {
                r0 += a.a.a.b.b.a.f(3, this.tlu);
            }
            if (this.tlv != null) {
                r0 += a.a.a.b.b.a.f(4, this.tlv);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.pyi)) + a.a.a.a.eL(6, this.tYv);
            if (this.tlw != null) {
                r0 += a.a.a.b.b.a.f(7, this.tlw);
            }
            if (this.tlx != null) {
                r0 += a.a.a.b.b.a.f(8, this.tlx);
            }
            if (this.tYw != null) {
                r0 += a.a.a.b.b.a.f(9, this.tYw);
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
            auw com_tencent_mm_protocal_c_auw = (auw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_auw.jNO = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auw.tYu = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auw.tlu = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auw.tlv = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auw.pyi = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_auw.tYv = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_auw.tlw = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_auw.tlx = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_auw.tYw = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
