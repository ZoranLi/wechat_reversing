package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bqg extends a {
    public int tkv;
    public LinkedList<je> ttk = new LinkedList();
    public cv uoA;
    public int uow;
    public String uox;
    public String uoy;
    public int uoz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tkv);
            aVar.eO(2, this.uow);
            if (this.uox != null) {
                aVar.e(3, this.uox);
            }
            if (this.uoy != null) {
                aVar.e(4, this.uoy);
            }
            aVar.eO(5, this.uoz);
            aVar.d(6, 8, this.ttk);
            if (this.uoA != null) {
                aVar.eQ(7, this.uoA.aUk());
                this.uoA.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.tkv) + 0) + a.a.a.a.eL(2, this.uow);
            if (this.uox != null) {
                r0 += a.a.a.b.b.a.f(3, this.uox);
            }
            if (this.uoy != null) {
                r0 += a.a.a.b.b.a.f(4, this.uoy);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.uoz)) + a.a.a.a.c(6, 8, this.ttk);
            if (this.uoA != null) {
                return r0 + a.a.a.a.eN(7, this.uoA.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ttk.clear();
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
            bqg com_tencent_mm_protocal_c_bqg = (bqg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a jeVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bqg.tkv = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqg.uow = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqg.uox = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqg.uoy = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqg.uoz = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jeVar = new je();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jeVar.a(aVar4, jeVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqg.ttk.add(jeVar);
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jeVar = new cv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jeVar.a(aVar4, jeVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqg.uoA = jeVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
