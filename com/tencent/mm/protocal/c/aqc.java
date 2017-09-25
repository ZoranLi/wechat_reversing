package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aqc extends avh {
    public String mtb;
    public String mvZ;
    public String tBk;
    public int tcg;
    public String tju;
    public String tqx;
    public String trf;
    public String trg;
    public String trh;
    public String tri;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            if (this.trf != null) {
                aVar.e(3, this.trf);
            }
            if (this.tju != null) {
                aVar.e(4, this.tju);
            }
            if (this.trg != null) {
                aVar.e(5, this.trg);
            }
            if (this.trh != null) {
                aVar.e(6, this.trh);
            }
            if (this.tri != null) {
                aVar.e(7, this.tri);
            }
            if (this.tqx != null) {
                aVar.e(8, this.tqx);
            }
            if (this.tBk != null) {
                aVar.e(9, this.tBk);
            }
            aVar.eO(10, this.tcg);
            if (this.mvZ == null) {
                return 0;
            }
            aVar.e(11, this.mvZ);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            if (this.trf != null) {
                r0 += a.a.a.b.b.a.f(3, this.trf);
            }
            if (this.tju != null) {
                r0 += a.a.a.b.b.a.f(4, this.tju);
            }
            if (this.trg != null) {
                r0 += a.a.a.b.b.a.f(5, this.trg);
            }
            if (this.trh != null) {
                r0 += a.a.a.b.b.a.f(6, this.trh);
            }
            if (this.tri != null) {
                r0 += a.a.a.b.b.a.f(7, this.tri);
            }
            if (this.tqx != null) {
                r0 += a.a.a.b.b.a.f(8, this.tqx);
            }
            if (this.tBk != null) {
                r0 += a.a.a.b.b.a.f(9, this.tBk);
            }
            r0 += a.a.a.a.eL(10, this.tcg);
            if (this.mvZ != null) {
                r0 += a.a.a.b.b.a.f(11, this.mvZ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aqc com_tencent_mm_protocal_c_aqc = (aqc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqc.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqc.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqc.trf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqc.tju = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqc.trg = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqc.trh = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqc.tri = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqc.tqx = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqc.tBk = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqc.tcg = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqc.mvZ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
