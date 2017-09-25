package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class hr extends a {
    public int tlO;
    public int tlP;
    public int tlQ;
    public LinkedList<hq> tlR = new LinkedList();
    public LinkedList<hq> tlS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tlO);
            aVar.eO(2, this.tlP);
            aVar.eO(5, this.tlQ);
            aVar.d(3, 8, this.tlR);
            aVar.d(4, 8, this.tlS);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.eL(1, this.tlO) + 0) + a.a.a.a.eL(2, this.tlP)) + a.a.a.a.eL(5, this.tlQ)) + a.a.a.a.c(3, 8, this.tlR)) + a.a.a.a.c(4, 8, this.tlS);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tlR.clear();
                this.tlS.clear();
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
                hr hrVar = (hr) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList En;
                int size;
                a hqVar;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        hrVar.tlO = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        hrVar.tlP = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            hqVar = new hq();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = hqVar.a(aVar4, hqVar, a.a(aVar4))) {
                            }
                            hrVar.tlR.add(hqVar);
                        }
                        return 0;
                    case 4:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            hqVar = new hq();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = hqVar.a(aVar4, hqVar, a.a(aVar4))) {
                            }
                            hrVar.tlS.add(hqVar);
                        }
                        return 0;
                    case 5:
                        hrVar.tlQ = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
