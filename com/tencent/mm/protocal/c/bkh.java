package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class bkh extends avh {
    public long tVW;
    public int tVX;
    public int trD;
    public String ujU;
    public b ujV;
    public b ujW;
    public String ujX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ujU == null) {
                throw new a.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.ujW == null) {
                throw new a.a.a.b("Not all required fields were included: CapInfo");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                aVar.eO(2, this.tVX);
                if (this.ujU != null) {
                    aVar.e(3, this.ujU);
                }
                aVar.eO(4, this.trD);
                if (this.ujV != null) {
                    aVar.b(5, this.ujV);
                }
                if (this.ujW != null) {
                    aVar.b(6, this.ujW);
                }
                aVar.O(7, this.tVW);
                if (this.ujX == null) {
                    return 0;
                }
                aVar.e(8, this.ujX);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tVX);
            if (this.ujU != null) {
                r0 += a.a.a.b.b.a.f(3, this.ujU);
            }
            r0 += a.a.a.a.eL(4, this.trD);
            if (this.ujV != null) {
                r0 += a.a.a.a.a(5, this.ujV);
            }
            if (this.ujW != null) {
                r0 += a.a.a.a.a(6, this.ujW);
            }
            r0 += a.a.a.a.N(7, this.tVW);
            if (this.ujX != null) {
                r0 += a.a.a.b.b.a.f(8, this.ujX);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ujU == null) {
                throw new a.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.ujW != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bkh com_tencent_mm_protocal_c_bkh = (bkh) objArr[1];
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
                        com_tencent_mm_protocal_c_bkh.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkh.tVX = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkh.ujU = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkh.trD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkh.ujV = aVar3.cic();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkh.ujW = aVar3.cic();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bkh.tVW = aVar3.xmD.mM();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bkh.ujX = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
