package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> qaG = new LinkedList();
    public LinkedList<e> qaH = new LinkedList();
    public LinkedList<e> qaI = new LinkedList();
    public LinkedList<e> qaJ = new LinkedList();
    public LinkedList<f> qaK = new LinkedList();
    public LinkedList<f> qaL = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.qaG);
            aVar.d(2, 8, this.qaH);
            aVar.d(3, 8, this.qaI);
            aVar.d(4, 8, this.qaJ);
            aVar.d(5, 8, this.qaK);
            aVar.d(6, 8, this.qaL);
            return 0;
        } else if (i == 1) {
            return (((((a.a.a.a.c(1, 8, this.qaG) + 0) + a.a.a.a.c(2, 8, this.qaH)) + a.a.a.a.c(3, 8, this.qaI)) + a.a.a.a.c(4, 8, this.qaJ)) + a.a.a.a.c(5, 8, this.qaK)) + a.a.a.a.c(6, 8, this.qaL);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.qaG.clear();
                this.qaH.clear();
                this.qaI.clear();
                this.qaJ.clear();
                this.qaK.clear();
                this.qaL.clear();
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
                d dVar = (d) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList En;
                int size;
                a eVar;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.qaG.add(eVar);
                        }
                        return 0;
                    case 2:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.qaH.add(eVar);
                        }
                        return 0;
                    case 3:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.qaI.add(eVar);
                        }
                        return 0;
                    case 4:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.qaJ.add(eVar);
                        }
                        return 0;
                    case 5:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            eVar = new f();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.qaK.add(eVar);
                        }
                        return 0;
                    case 6:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            eVar = new f();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.qaL.add(eVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
