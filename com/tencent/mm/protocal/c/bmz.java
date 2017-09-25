package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bmz extends a {
    public String jNn;
    public String thD;
    public String tlu;
    public String tlv;
    public String tlw;
    public String tlx;
    public String umu;
    public String umv;
    public String umw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.thD != null) {
                aVar.e(1, this.thD);
            }
            if (this.tlv != null) {
                aVar.e(2, this.tlv);
            }
            if (this.tlu != null) {
                aVar.e(3, this.tlu);
            }
            if (this.jNn != null) {
                aVar.e(4, this.jNn);
            }
            if (this.umu != null) {
                aVar.e(5, this.umu);
            }
            if (this.tlw != null) {
                aVar.e(6, this.tlw);
            }
            if (this.tlx != null) {
                aVar.e(7, this.tlx);
            }
            if (this.umv != null) {
                aVar.e(8, this.umv);
            }
            if (this.umw == null) {
                return 0;
            }
            aVar.e(9, this.umw);
            return 0;
        } else if (i == 1) {
            if (this.thD != null) {
                r0 = a.a.a.b.b.a.f(1, this.thD) + 0;
            } else {
                r0 = 0;
            }
            if (this.tlv != null) {
                r0 += a.a.a.b.b.a.f(2, this.tlv);
            }
            if (this.tlu != null) {
                r0 += a.a.a.b.b.a.f(3, this.tlu);
            }
            if (this.jNn != null) {
                r0 += a.a.a.b.b.a.f(4, this.jNn);
            }
            if (this.umu != null) {
                r0 += a.a.a.b.b.a.f(5, this.umu);
            }
            if (this.tlw != null) {
                r0 += a.a.a.b.b.a.f(6, this.tlw);
            }
            if (this.tlx != null) {
                r0 += a.a.a.b.b.a.f(7, this.tlx);
            }
            if (this.umv != null) {
                r0 += a.a.a.b.b.a.f(8, this.umv);
            }
            if (this.umw != null) {
                r0 += a.a.a.b.b.a.f(9, this.umw);
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
            bmz com_tencent_mm_protocal_c_bmz = (bmz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bmz.thD = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmz.tlv = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bmz.tlu = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bmz.jNn = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bmz.umu = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bmz.tlw = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bmz.tlx = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bmz.umv = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bmz.umw = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
