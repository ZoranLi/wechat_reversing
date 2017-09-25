package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class r extends a {
    public String ID;
    public long jNA;
    public int jND;
    public int jNE;
    public int jNF;
    public long jNG;
    public long jNH;
    public LinkedList<t> jNS = new LinkedList();
    public LinkedList<t> jNT = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.eO(2, this.jND);
            aVar.eO(3, this.jNE);
            aVar.eO(4, this.jNF);
            aVar.O(5, this.jNA);
            aVar.O(6, this.jNG);
            aVar.O(7, this.jNH);
            aVar.d(8, 8, this.jNS);
            aVar.d(9, 8, this.jNT);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            return (((((((r0 + a.a.a.a.eL(2, this.jND)) + a.a.a.a.eL(3, this.jNE)) + a.a.a.a.eL(4, this.jNF)) + a.a.a.a.N(5, this.jNA)) + a.a.a.a.N(6, this.jNG)) + a.a.a.a.N(7, this.jNH)) + a.a.a.a.c(8, 8, this.jNS)) + a.a.a.a.c(9, 8, this.jNT);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.jNS.clear();
            this.jNT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a tVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rVar.ID = aVar3.xmD.readString();
                    return 0;
                case 2:
                    rVar.jND = aVar3.xmD.mL();
                    return 0;
                case 3:
                    rVar.jNE = aVar3.xmD.mL();
                    return 0;
                case 4:
                    rVar.jNF = aVar3.xmD.mL();
                    return 0;
                case 5:
                    rVar.jNA = aVar3.xmD.mM();
                    return 0;
                case 6:
                    rVar.jNG = aVar3.xmD.mM();
                    return 0;
                case 7:
                    rVar.jNH = aVar3.xmD.mM();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        tVar = new t();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.jNS.add(tVar);
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        tVar = new t();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.jNT.add(tVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
