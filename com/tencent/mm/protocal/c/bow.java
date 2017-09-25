package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bow extends a {
    public String leO;
    public String tBB;
    public int tOk;
    public aiz tOl;
    public int tdM;
    public long tlY;
    public LinkedList<String> uno = new LinkedList();
    public LinkedList<ma> unp = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.uno);
            aVar.eO(2, this.tOk);
            if (this.leO != null) {
                aVar.e(3, this.leO);
            }
            aVar.eO(4, this.tdM);
            aVar.O(5, this.tlY);
            if (this.tBB != null) {
                aVar.e(6, this.tBB);
            }
            if (this.tOl != null) {
                aVar.eQ(7, this.tOl.aUk());
                this.tOl.a(aVar);
            }
            aVar.d(8, 8, this.unp);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.c(1, 1, this.uno) + 0) + a.a.a.a.eL(2, this.tOk);
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(3, this.leO);
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tdM)) + a.a.a.a.N(5, this.tlY);
            if (this.tBB != null) {
                r0 += a.a.a.b.b.a.f(6, this.tBB);
            }
            if (this.tOl != null) {
                r0 += a.a.a.a.eN(7, this.tOl.aUk());
            }
            return r0 + a.a.a.a.c(8, 8, this.unp);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uno.clear();
            this.unp.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bow com_tencent_mm_protocal_c_bow = (bow) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_aiz;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bow.uno.add(aVar3.xmD.readString());
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bow.tOk = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bow.leO = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bow.tdM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bow.tlY = aVar3.xmD.mM();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bow.tBB = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new aiz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bow.tOl = com_tencent_mm_protocal_c_aiz;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new ma();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bow.unp.add(com_tencent_mm_protocal_c_aiz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
