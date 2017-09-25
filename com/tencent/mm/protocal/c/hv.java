package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class hv extends a {
    public String fDC;
    public int jND;
    public LinkedList<ia> muY = new LinkedList();
    public long tlY;
    public int tlZ;
    public int tll;
    public LinkedList<String> tma = new LinkedList();
    public String tmb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tmb == null) {
                throw new b("Not all required fields were included: SearchID");
            }
            aVar.O(1, this.tlY);
            aVar.eO(2, this.tlZ);
            if (this.fDC != null) {
                aVar.e(3, this.fDC);
            }
            aVar.d(4, 1, this.tma);
            aVar.d(5, 8, this.muY);
            aVar.eO(6, this.jND);
            if (this.tmb != null) {
                aVar.e(7, this.tmb);
            }
            aVar.eO(8, this.tll);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.N(1, this.tlY) + 0) + a.a.a.a.eL(2, this.tlZ);
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(3, this.fDC);
            }
            r0 = ((r0 + a.a.a.a.c(4, 1, this.tma)) + a.a.a.a.c(5, 8, this.muY)) + a.a.a.a.eL(6, this.jND);
            if (this.tmb != null) {
                r0 += a.a.a.b.b.a.f(7, this.tmb);
            }
            return r0 + a.a.a.a.eL(8, this.tll);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tma.clear();
            this.muY.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tmb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SearchID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hv hvVar = (hv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hvVar.tlY = aVar3.xmD.mM();
                    return 0;
                case 2:
                    hvVar.tlZ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    hvVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    hvVar.tma.add(aVar3.xmD.readString());
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a iaVar = new ia();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = iaVar.a(aVar4, iaVar, a.a(aVar4))) {
                        }
                        hvVar.muY.add(iaVar);
                    }
                    return 0;
                case 6:
                    hvVar.jND = aVar3.xmD.mL();
                    return 0;
                case 7:
                    hvVar.tmb = aVar3.xmD.readString();
                    return 0;
                case 8:
                    hvVar.tll = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
