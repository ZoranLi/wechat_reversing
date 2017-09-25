package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aif extends a {
    public int tMo;
    public String tlu;
    public String tlv;
    public String tlw;
    public String tlx;
    public String tly;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tlu != null) {
                aVar.e(1, this.tlu);
            }
            if (this.tlv != null) {
                aVar.e(2, this.tlv);
            }
            if (this.tlw != null) {
                aVar.e(3, this.tlw);
            }
            if (this.tlx != null) {
                aVar.e(4, this.tlx);
            }
            if (this.tly != null) {
                aVar.e(5, this.tly);
            }
            aVar.eO(6, this.tMo);
            return 0;
        } else if (i == 1) {
            if (this.tlu != null) {
                r0 = a.a.a.b.b.a.f(1, this.tlu) + 0;
            } else {
                r0 = 0;
            }
            if (this.tlv != null) {
                r0 += a.a.a.b.b.a.f(2, this.tlv);
            }
            if (this.tlw != null) {
                r0 += a.a.a.b.b.a.f(3, this.tlw);
            }
            if (this.tlx != null) {
                r0 += a.a.a.b.b.a.f(4, this.tlx);
            }
            if (this.tly != null) {
                r0 += a.a.a.b.b.a.f(5, this.tly);
            }
            return r0 + a.a.a.a.eL(6, this.tMo);
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
            aif com_tencent_mm_protocal_c_aif = (aif) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aif.tlu = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aif.tlv = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aif.tlw = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aif.tlx = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aif.tly = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aif.tMo = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
