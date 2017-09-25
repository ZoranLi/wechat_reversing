package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aoh extends a {
    public String hNZ;
    public int tTs;
    public int tTt;
    public String tTu;
    public int tTv;
    public String tTw;
    public int tlQ;
    public int trD;
    public int tsR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hNZ != null) {
                aVar.e(1, this.hNZ);
            }
            aVar.eO(2, this.tTs);
            aVar.eO(3, this.tTt);
            aVar.eO(4, this.tlQ);
            if (this.tTu != null) {
                aVar.e(5, this.tTu);
            }
            aVar.eO(6, this.tsR);
            aVar.eO(7, this.tTv);
            aVar.eO(8, this.trD);
            if (this.tTw == null) {
                return 0;
            }
            aVar.e(9, this.tTw);
            return 0;
        } else if (i == 1) {
            if (this.hNZ != null) {
                r0 = a.a.a.b.b.a.f(1, this.hNZ) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.tTs)) + a.a.a.a.eL(3, this.tTt)) + a.a.a.a.eL(4, this.tlQ);
            if (this.tTu != null) {
                r0 += a.a.a.b.b.a.f(5, this.tTu);
            }
            r0 = ((r0 + a.a.a.a.eL(6, this.tsR)) + a.a.a.a.eL(7, this.tTv)) + a.a.a.a.eL(8, this.trD);
            if (this.tTw != null) {
                r0 += a.a.a.b.b.a.f(9, this.tTw);
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
            aoh com_tencent_mm_protocal_c_aoh = (aoh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoh.hNZ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoh.tTs = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoh.tTt = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoh.tlQ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoh.tTu = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoh.tsR = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aoh.tTv = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aoh.trD = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aoh.tTw = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
