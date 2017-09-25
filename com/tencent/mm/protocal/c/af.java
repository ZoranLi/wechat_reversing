package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class af extends a {
    public int tcI;
    public int tcJ;
    public int tcK;
    public LinkedList<ad> tcL = new LinkedList();
    public int tcM;
    public LinkedList<ad> tcN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tcI);
            aVar.eO(2, this.tcK);
            aVar.d(3, 8, this.tcL);
            aVar.eO(4, this.tcJ);
            aVar.eO(5, this.tcM);
            aVar.d(6, 8, this.tcN);
            return 0;
        } else if (i == 1) {
            return (((((a.a.a.a.eL(1, this.tcI) + 0) + a.a.a.a.eL(2, this.tcK)) + a.a.a.a.c(3, 8, this.tcL)) + a.a.a.a.eL(4, this.tcJ)) + a.a.a.a.eL(5, this.tcM)) + a.a.a.a.c(6, 8, this.tcN);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tcL.clear();
                this.tcN.clear();
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
                af afVar = (af) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList En;
                int size;
                a adVar;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        afVar.tcI = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        afVar.tcK = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            adVar = new ad();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = adVar.a(aVar4, adVar, a.a(aVar4))) {
                            }
                            afVar.tcL.add(adVar);
                        }
                        return 0;
                    case 4:
                        afVar.tcJ = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        afVar.tcM = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            adVar = new ad();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = adVar.a(aVar4, adVar, a.a(aVar4))) {
                            }
                            afVar.tcN.add(adVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
