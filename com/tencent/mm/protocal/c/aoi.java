package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aoi extends a {
    public int tTv;
    public String tTw;
    public String tTx;
    public int tlQ;
    public int trD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tlQ);
            if (this.tTx != null) {
                aVar.e(3, this.tTx);
            }
            aVar.eO(4, this.tTv);
            aVar.eO(5, this.trD);
            if (this.tTw != null) {
                aVar.e(6, this.tTw);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tlQ) + 0;
            if (this.tTx != null) {
                r0 += a.a.a.b.b.a.f(3, this.tTx);
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tTv)) + a.a.a.a.eL(5, this.trD);
            if (this.tTw != null) {
                return r0 + a.a.a.b.b.a.f(6, this.tTw);
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
            aoi com_tencent_mm_protocal_c_aoi = (aoi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoi.tlQ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoi.tTx = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoi.tTv = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoi.trD = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoi.tTw = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
