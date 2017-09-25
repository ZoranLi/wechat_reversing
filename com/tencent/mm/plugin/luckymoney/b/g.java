package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class g extends a {
    public int hPS;
    public LinkedList<h> nmB = new LinkedList();
    public int nmF;
    public long nmG;
    public int nmH;
    public long nmI;
    public int nms;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.nmF);
            aVar.O(2, this.nmG);
            aVar.eO(3, this.nmH);
            aVar.O(4, this.nmI);
            aVar.eO(5, this.hPS);
            aVar.eO(6, this.nms);
            aVar.d(7, 8, this.nmB);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.eL(1, this.nmF) + 0) + a.a.a.a.N(2, this.nmG)) + a.a.a.a.eL(3, this.nmH)) + a.a.a.a.N(4, this.nmI)) + a.a.a.a.eL(5, this.hPS)) + a.a.a.a.eL(6, this.nms)) + a.a.a.a.c(7, 8, this.nmB);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.nmB.clear();
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
                g gVar = (g) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        gVar.nmF = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        gVar.nmG = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        gVar.nmH = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        gVar.nmI = aVar3.xmD.mM();
                        return 0;
                    case 5:
                        gVar.hPS = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        gVar.nms = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a hVar = new h();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                            }
                            gVar.nmB.add(hVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
