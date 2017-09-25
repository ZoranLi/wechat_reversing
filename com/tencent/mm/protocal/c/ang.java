package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ang extends a {
    public String path;
    public String tSc;
    public String tSd;
    public int tlJ;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.tSc != null) {
                aVar.e(2, this.tSc);
            }
            if (this.tSd != null) {
                aVar.e(3, this.tSd);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            aVar.eO(5, this.tlJ);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = a.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            if (this.tSc != null) {
                r0 += a.a.a.b.b.a.f(2, this.tSc);
            }
            if (this.tSd != null) {
                r0 += a.a.a.b.b.a.f(3, this.tSd);
            }
            if (this.path != null) {
                r0 += a.a.a.b.b.a.f(4, this.path);
            }
            return r0 + a.a.a.a.eL(5, this.tlJ);
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
            ang com_tencent_mm_protocal_c_ang = (ang) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ang.username = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ang.tSc = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ang.tSd = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ang.path = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ang.tlJ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
