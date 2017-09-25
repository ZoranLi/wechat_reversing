package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bpd extends a {
    public String tky;
    public String tup;
    public int unF;
    public int unG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tup == null) {
                throw new b("Not all required fields were included: Md5");
            } else if (this.tky == null) {
                throw new b("Not all required fields were included: DownloadUrl");
            } else {
                if (this.tup != null) {
                    aVar.e(1, this.tup);
                }
                if (this.tky != null) {
                    aVar.e(2, this.tky);
                }
                aVar.eO(3, this.unF);
                aVar.eO(4, this.unG);
                return 0;
            }
        } else if (i == 1) {
            if (this.tup != null) {
                r0 = a.a.a.b.b.a.f(1, this.tup) + 0;
            } else {
                r0 = 0;
            }
            if (this.tky != null) {
                r0 += a.a.a.b.b.a.f(2, this.tky);
            }
            return (r0 + a.a.a.a.eL(3, this.unF)) + a.a.a.a.eL(4, this.unG);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tup == null) {
                throw new b("Not all required fields were included: Md5");
            } else if (this.tky != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bpd com_tencent_mm_protocal_c_bpd = (bpd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bpd.tup = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpd.tky = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpd.unF = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpd.unG = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
