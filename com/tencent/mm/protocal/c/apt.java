package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class apt extends a {
    public String hHt;
    public String oQK;
    public String oga;
    public int tUI;
    public String tUJ;
    public String tUK;
    public int tUL;
    public String tUM;
    public int tUN;
    public String tUO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tUI);
            if (this.tUJ != null) {
                aVar.e(2, this.tUJ);
            }
            if (this.tUK != null) {
                aVar.e(3, this.tUK);
            }
            aVar.eO(4, this.tUL);
            if (this.oga != null) {
                aVar.e(5, this.oga);
            }
            if (this.tUM != null) {
                aVar.e(6, this.tUM);
            }
            if (this.oQK != null) {
                aVar.e(7, this.oQK);
            }
            aVar.eO(8, this.tUN);
            if (this.hHt != null) {
                aVar.e(9, this.hHt);
            }
            if (this.tUO != null) {
                aVar.e(10, this.tUO);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tUI) + 0;
            if (this.tUJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tUJ);
            }
            if (this.tUK != null) {
                r0 += a.a.a.b.b.a.f(3, this.tUK);
            }
            r0 += a.a.a.a.eL(4, this.tUL);
            if (this.oga != null) {
                r0 += a.a.a.b.b.a.f(5, this.oga);
            }
            if (this.tUM != null) {
                r0 += a.a.a.b.b.a.f(6, this.tUM);
            }
            if (this.oQK != null) {
                r0 += a.a.a.b.b.a.f(7, this.oQK);
            }
            r0 += a.a.a.a.eL(8, this.tUN);
            if (this.hHt != null) {
                r0 += a.a.a.b.b.a.f(9, this.hHt);
            }
            if (this.tUO != null) {
                return r0 + a.a.a.b.b.a.f(10, this.tUO);
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
            apt com_tencent_mm_protocal_c_apt = (apt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_apt.tUI = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apt.tUJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apt.tUK = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apt.tUL = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apt.oga = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apt.tUM = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_apt.oQK = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_apt.tUN = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_apt.hHt = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_apt.tUO = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
