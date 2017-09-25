package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class xh extends a {
    public int tDV;
    public avw tDW;
    public String tDX;
    public int tDY;
    public long tDZ;
    public int tce;
    public int tuw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tce);
            aVar.eO(2, this.tDV);
            if (this.tDW != null) {
                aVar.eQ(3, this.tDW.aUk());
                this.tDW.a(aVar);
            }
            aVar.eO(4, this.tuw);
            if (this.tDX != null) {
                aVar.e(5, this.tDX);
            }
            aVar.eO(6, this.tDY);
            aVar.O(7, this.tDZ);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.tce) + 0) + a.a.a.a.eL(2, this.tDV);
            if (this.tDW != null) {
                r0 += a.a.a.a.eN(3, this.tDW.aUk());
            }
            r0 += a.a.a.a.eL(4, this.tuw);
            if (this.tDX != null) {
                r0 += a.a.a.b.b.a.f(5, this.tDX);
            }
            return (r0 + a.a.a.a.eL(6, this.tDY)) + a.a.a.a.N(7, this.tDZ);
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
            xh xhVar = (xh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    xhVar.tce = aVar3.xmD.mL();
                    return 0;
                case 2:
                    xhVar.tDV = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        xhVar.tDW = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 4:
                    xhVar.tuw = aVar3.xmD.mL();
                    return 0;
                case 5:
                    xhVar.tDX = aVar3.xmD.readString();
                    return 0;
                case 6:
                    xhVar.tDY = aVar3.xmD.mL();
                    return 0;
                case 7:
                    xhVar.tDZ = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
