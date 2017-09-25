package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ars extends avp {
    public int mNR;
    public String mNS;
    public int mNX;
    public int mOd;
    public int mOe;
    public int mOf;
    public b mOg;
    public int mOi;
    public int mOl;
    public long tVZ;
    public int tWi;
    public int tWj;
    public LinkedList<ark> tWk = new LinkedList();
    public String tWl;
    public b tWm;
    public int tWn;
    public LinkedList<ark> thS = new LinkedList();
    public int tvL;
    public long tvM;

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
            aVar.eO(2, this.tvL);
            aVar.O(3, this.tvM);
            aVar.eO(4, this.tWi);
            aVar.d(5, 8, this.thS);
            aVar.eO(6, this.tWj);
            aVar.eO(7, this.mOd);
            aVar.eO(8, this.mOe);
            aVar.O(9, this.tVZ);
            aVar.eO(10, this.mOf);
            if (this.mOg != null) {
                aVar.b(11, this.mOg);
            }
            aVar.eO(12, this.mNX);
            aVar.eO(13, this.mNR);
            if (this.mNS != null) {
                aVar.e(14, this.mNS);
            }
            aVar.eO(15, this.mOi);
            aVar.d(16, 8, this.tWk);
            aVar.eO(17, this.mOl);
            if (this.tWl != null) {
                aVar.e(18, this.tWl);
            }
            if (this.tWm != null) {
                aVar.b(19, this.tWm);
            }
            aVar.eO(20, this.tWn);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((((r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.N(3, this.tvM)) + a.a.a.a.eL(4, this.tWi)) + a.a.a.a.c(5, 8, this.thS)) + a.a.a.a.eL(6, this.tWj)) + a.a.a.a.eL(7, this.mOd)) + a.a.a.a.eL(8, this.mOe)) + a.a.a.a.N(9, this.tVZ)) + a.a.a.a.eL(10, this.mOf);
            if (this.mOg != null) {
                r0 += a.a.a.a.a(11, this.mOg);
            }
            r0 = (r0 + a.a.a.a.eL(12, this.mNX)) + a.a.a.a.eL(13, this.mNR);
            if (this.mNS != null) {
                r0 += a.a.a.b.b.a.f(14, this.mNS);
            }
            r0 = ((r0 + a.a.a.a.eL(15, this.mOi)) + a.a.a.a.c(16, 8, this.tWk)) + a.a.a.a.eL(17, this.mOl);
            if (this.tWl != null) {
                r0 += a.a.a.b.b.a.f(18, this.tWl);
            }
            if (this.tWm != null) {
                r0 += a.a.a.a.a(19, this.tWm);
            }
            return r0 + a.a.a.a.eL(20, this.tWn);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.thS.clear();
            this.tWk.clear();
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
            ars com_tencent_mm_protocal_c_ars = (ars) objArr[1];
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
                        com_tencent_mm_protocal_c_ars.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ars.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ars.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ars.tWi = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new ark();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.thS.add(enVar);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ars.tWj = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ars.mOd = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ars.mOe = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ars.tVZ = aVar3.xmD.mM();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ars.mOf = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ars.mOg = aVar3.cic();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ars.mNX = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ars.mNR = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ars.mNS = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ars.mOi = aVar3.xmD.mL();
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new ark();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.tWk.add(enVar);
                    }
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ars.mOl = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ars.tWl = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ars.tWm = aVar3.cic();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ars.tWn = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
