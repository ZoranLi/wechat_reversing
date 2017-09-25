package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.em;
import java.util.LinkedList;

public final class ap extends avh {
    public String hAM;
    public String mtJ;
    public LinkedList<String> mue = new LinkedList();
    public int muw;
    public int mux;
    public int muy;
    public boolean muz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mtJ == null) {
                throw new b("Not all required fields were included: Lang");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.muw);
            aVar.eO(3, this.mux);
            if (this.mtJ != null) {
                aVar.e(4, this.mtJ);
            }
            aVar.d(5, 1, this.mue);
            if (this.hAM != null) {
                aVar.e(6, this.hAM);
            }
            aVar.eO(7, this.muy);
            aVar.an(8, this.muz);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.muw)) + a.a.a.a.eL(3, this.mux);
            if (this.mtJ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtJ);
            }
            r0 += a.a.a.a.c(5, 1, this.mue);
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(6, this.hAM);
            }
            return (r0 + a.a.a.a.eL(7, this.muy)) + (a.a.a.b.b.a.cH(8) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mue.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mtJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Lang");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ap apVar = (ap) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        apVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    apVar.muw = aVar3.xmD.mL();
                    return 0;
                case 3:
                    apVar.mux = aVar3.xmD.mL();
                    return 0;
                case 4:
                    apVar.mtJ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    apVar.mue.add(aVar3.xmD.readString());
                    return 0;
                case 6:
                    apVar.hAM = aVar3.xmD.readString();
                    return 0;
                case 7:
                    apVar.muy = aVar3.xmD.mL();
                    return 0;
                case 8:
                    apVar.muz = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
