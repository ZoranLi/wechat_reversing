package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class vr extends a implements bah {
    public int tCS;
    public int tCT;
    public int tCU;
    public LinkedList<avx> tCV = new LinkedList();
    public int thX;

    public final int getRet() {
        return this.thX;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.thX);
            aVar.eO(2, this.tCS);
            aVar.eO(3, this.tCT);
            aVar.eO(4, this.tCU);
            aVar.d(5, 8, this.tCV);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.eL(1, this.thX) + 0) + a.a.a.a.eL(2, this.tCS)) + a.a.a.a.eL(3, this.tCT)) + a.a.a.a.eL(4, this.tCU)) + a.a.a.a.c(5, 8, this.tCV);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tCV.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                vr vrVar = (vr) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        vrVar.thX = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        vrVar.tCS = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        vrVar.tCT = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        vrVar.tCU = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_avx = new avx();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                            }
                            vrVar.tCV.add(com_tencent_mm_protocal_c_avx);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
