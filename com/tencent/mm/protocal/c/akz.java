package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class akz extends a {
    public String bssid;
    public String fEN;
    public int fIx;
    public int lRB;
    public String ssid;
    public int tOH;
    public String tOI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ssid != null) {
                aVar.e(1, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(2, this.bssid);
            }
            aVar.eO(3, this.fIx);
            aVar.eO(4, this.tOH);
            if (this.tOI != null) {
                aVar.e(5, this.tOI);
            }
            if (this.fEN != null) {
                aVar.e(6, this.fEN);
            }
            aVar.eO(7, this.lRB);
            return 0;
        } else if (i == 1) {
            if (this.ssid != null) {
                r0 = a.a.a.b.b.a.f(1, this.ssid) + 0;
            } else {
                r0 = 0;
            }
            if (this.bssid != null) {
                r0 += a.a.a.b.b.a.f(2, this.bssid);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.fIx)) + a.a.a.a.eL(4, this.tOH);
            if (this.tOI != null) {
                r0 += a.a.a.b.b.a.f(5, this.tOI);
            }
            if (this.fEN != null) {
                r0 += a.a.a.b.b.a.f(6, this.fEN);
            }
            return r0 + a.a.a.a.eL(7, this.lRB);
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
            akz com_tencent_mm_protocal_c_akz = (akz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akz.ssid = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akz.bssid = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akz.fIx = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akz.tOH = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akz.tOI = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akz.fEN = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akz.lRB = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
