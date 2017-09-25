package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class bki extends avp {
    public int mNX;
    public int mOd;
    public int mOe;
    public int mOi;
    public b tWm;
    public LinkedList<bkc> thS = new LinkedList();
    public long tvM;
    public long ujT;
    public int ujY;
    public int ujZ;
    public int uka;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.O(2, this.ujT);
            aVar.O(3, this.tvM);
            aVar.d(4, 8, this.thS);
            aVar.eO(5, this.ujY);
            aVar.eO(6, this.mOd);
            aVar.eO(7, this.mOe);
            aVar.eO(8, this.mNX);
            aVar.eO(9, this.mOi);
            aVar.eO(10, this.ujZ);
            aVar.eO(11, this.uka);
            if (this.tWm == null) {
                return 0;
            }
            aVar.b(12, this.tWm);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((((((((r0 + a.a.a.a.N(2, this.ujT)) + a.a.a.a.N(3, this.tvM)) + a.a.a.a.c(4, 8, this.thS)) + a.a.a.a.eL(5, this.ujY)) + a.a.a.a.eL(6, this.mOd)) + a.a.a.a.eL(7, this.mOe)) + a.a.a.a.eL(8, this.mNX)) + a.a.a.a.eL(9, this.mOi)) + a.a.a.a.eL(10, this.ujZ)) + a.a.a.a.eL(11, this.uka);
            if (this.tWm != null) {
                r0 += a.a.a.a.a(12, this.tWm);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.thS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bki com_tencent_mm_protocal_c_bki = (bki) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bki.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bki.ujT = aVar3.xmD.mM();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bki.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bkc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bki.thS.add(enVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bki.ujY = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bki.mOd = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bki.mOe = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bki.mNX = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bki.mOi = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bki.ujZ = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bki.uka = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bki.tWm = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
