package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class d extends a {
    public String ID;
    public h jMR;
    public int jMS;
    public int jMT;
    public int jMU;
    public int jMV;
    public int jMW;
    public int jMX;
    public int jMY;
    public int jMZ;
    public int jNa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            if (this.jMR != null) {
                aVar.eQ(2, this.jMR.aUk());
                this.jMR.a(aVar);
            }
            aVar.eO(3, this.jMS);
            aVar.eO(4, this.jMT);
            aVar.eO(5, this.jMU);
            aVar.eO(6, this.jMV);
            aVar.eO(7, this.jMW);
            aVar.eO(8, this.jMX);
            aVar.eO(9, this.jMY);
            aVar.eO(10, this.jMZ);
            aVar.eO(11, this.jNa);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            if (this.jMR != null) {
                r0 += a.a.a.a.eN(2, this.jMR.aUk());
            }
            return ((((((((r0 + a.a.a.a.eL(3, this.jMS)) + a.a.a.a.eL(4, this.jMT)) + a.a.a.a.eL(5, this.jMU)) + a.a.a.a.eL(6, this.jMV)) + a.a.a.a.eL(7, this.jMW)) + a.a.a.a.eL(8, this.jMX)) + a.a.a.a.eL(9, this.jMY)) + a.a.a.a.eL(10, this.jMZ)) + a.a.a.a.eL(11, this.jNa);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.ID = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a hVar = new h();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        dVar.jMR = hVar;
                    }
                    return 0;
                case 3:
                    dVar.jMS = aVar3.xmD.mL();
                    return 0;
                case 4:
                    dVar.jMT = aVar3.xmD.mL();
                    return 0;
                case 5:
                    dVar.jMU = aVar3.xmD.mL();
                    return 0;
                case 6:
                    dVar.jMV = aVar3.xmD.mL();
                    return 0;
                case 7:
                    dVar.jMW = aVar3.xmD.mL();
                    return 0;
                case 8:
                    dVar.jMX = aVar3.xmD.mL();
                    return 0;
                case 9:
                    dVar.jMY = aVar3.xmD.mL();
                    return 0;
                case 10:
                    dVar.jMZ = aVar3.xmD.mL();
                    return 0;
                case 11:
                    dVar.jNa = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
