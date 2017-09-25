package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class apk extends a {
    public String fTO;
    public String kdG;
    public int tUr;
    public String tUs;
    public String tUt;
    public String tog;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fTO != null) {
                aVar.e(1, this.fTO);
            }
            aVar.eO(2, this.tUr);
            if (this.tUs != null) {
                aVar.e(3, this.tUs);
            }
            if (this.tUt != null) {
                aVar.e(4, this.tUt);
            }
            if (this.tog != null) {
                aVar.e(5, this.tog);
            }
            if (this.kdG == null) {
                return 0;
            }
            aVar.e(6, this.kdG);
            return 0;
        } else if (i == 1) {
            if (this.fTO != null) {
                r0 = a.a.a.b.b.a.f(1, this.fTO) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tUr);
            if (this.tUs != null) {
                r0 += a.a.a.b.b.a.f(3, this.tUs);
            }
            if (this.tUt != null) {
                r0 += a.a.a.b.b.a.f(4, this.tUt);
            }
            if (this.tog != null) {
                r0 += a.a.a.b.b.a.f(5, this.tog);
            }
            if (this.kdG != null) {
                r0 += a.a.a.b.b.a.f(6, this.kdG);
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
            apk com_tencent_mm_protocal_c_apk = (apk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_apk.fTO = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apk.tUr = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apk.tUs = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apk.tUt = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apk.tog = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apk.kdG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
