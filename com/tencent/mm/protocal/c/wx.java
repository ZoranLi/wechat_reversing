package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class wx extends a {
    public int tDD;
    public int tDE;
    public int tDF;
    public int trE;
    public int trF;
    public int trG;
    public b trI;
    public aey trJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.trE);
            aVar.eO(2, this.trF);
            aVar.eO(3, this.trG);
            if (this.trI != null) {
                aVar.b(4, this.trI);
            }
            aVar.eO(5, this.tDD);
            aVar.eO(6, this.tDE);
            aVar.eO(7, this.tDF);
            if (this.trJ != null) {
                aVar.eQ(8, this.trJ.aUk());
                this.trJ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.trE) + 0) + a.a.a.a.eL(2, this.trF)) + a.a.a.a.eL(3, this.trG);
            if (this.trI != null) {
                r0 += a.a.a.a.a(4, this.trI);
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.tDD)) + a.a.a.a.eL(6, this.tDE)) + a.a.a.a.eL(7, this.tDF);
            if (this.trJ != null) {
                return r0 + a.a.a.a.eN(8, this.trJ.aUk());
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
            wx wxVar = (wx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wxVar.trE = aVar3.xmD.mL();
                    return 0;
                case 2:
                    wxVar.trF = aVar3.xmD.mL();
                    return 0;
                case 3:
                    wxVar.trG = aVar3.xmD.mL();
                    return 0;
                case 4:
                    wxVar.trI = aVar3.cic();
                    return 0;
                case 5:
                    wxVar.tDD = aVar3.xmD.mL();
                    return 0;
                case 6:
                    wxVar.tDE = aVar3.xmD.mL();
                    return 0;
                case 7:
                    wxVar.tDF = aVar3.xmD.mL();
                    return 0;
                case 8:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aey = new aey();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aey.a(aVar4, com_tencent_mm_protocal_c_aey, a.a(aVar4))) {
                        }
                        wxVar.trJ = com_tencent_mm_protocal_c_aey;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
