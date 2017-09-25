package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bdf extends a {
    public int hTu;
    public long hTv;
    public int hTw;
    public int hTx;
    public int hTy;
    public int opType;
    public String uev;
    public String uew;
    public String uex;
    public String uey;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uev == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.uew == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.uex == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.uey == null) {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            } else {
                aVar.eO(1, this.opType);
                aVar.eO(2, this.hTy);
                aVar.eO(3, this.hTu);
                aVar.O(4, this.hTv);
                aVar.eO(5, this.hTw);
                aVar.eO(6, this.hTx);
                if (this.uev != null) {
                    aVar.e(7, this.uev);
                }
                if (this.uew != null) {
                    aVar.e(8, this.uew);
                }
                if (this.uex != null) {
                    aVar.e(9, this.uex);
                }
                if (this.uey != null) {
                    aVar.e(10, this.uey);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = (((((a.a.a.a.eL(1, this.opType) + 0) + a.a.a.a.eL(2, this.hTy)) + a.a.a.a.eL(3, this.hTu)) + a.a.a.a.N(4, this.hTv)) + a.a.a.a.eL(5, this.hTw)) + a.a.a.a.eL(6, this.hTx);
            if (this.uev != null) {
                r0 += a.a.a.b.b.a.f(7, this.uev);
            }
            if (this.uew != null) {
                r0 += a.a.a.b.b.a.f(8, this.uew);
            }
            if (this.uex != null) {
                r0 += a.a.a.b.b.a.f(9, this.uex);
            }
            if (this.uey != null) {
                return r0 + a.a.a.b.b.a.f(10, this.uey);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uev == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.uew == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.uex == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.uey != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bdf com_tencent_mm_protocal_c_bdf = (bdf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bdf.opType = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdf.hTy = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdf.hTu = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdf.hTv = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdf.hTw = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bdf.hTx = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bdf.uev = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bdf.uew = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bdf.uex = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bdf.uey = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
