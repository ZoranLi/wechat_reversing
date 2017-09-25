package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bom extends a {
    public int tdM;
    public b tgI;
    public String umH;
    public long unc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.tgI == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.umH != null) {
                    aVar.e(1, this.umH);
                }
                aVar.O(2, this.unc);
                if (this.tgI != null) {
                    aVar.b(3, this.tgI);
                }
                aVar.eO(4, this.tdM);
                return 0;
            }
        } else if (i == 1) {
            if (this.umH != null) {
                r0 = a.a.a.b.b.a.f(1, this.umH) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.N(2, this.unc);
            if (this.tgI != null) {
                r0 += a.a.a.a.a(3, this.tgI);
            }
            return r0 + a.a.a.a.eL(4, this.tdM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.tgI != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bom com_tencent_mm_protocal_c_bom = (bom) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bom.umH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bom.unc = aVar3.xmD.mM();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bom.tgI = aVar3.cic();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bom.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
