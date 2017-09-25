package com.tencent.mm.t;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public class i extends a {
    public String fUR;
    public String fUS;
    public String gxD;
    public LinkedList<l> hkm = new LinkedList();
    public int hkn;
    public String name;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.type);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.fUR != null) {
                aVar.e(3, this.fUR);
            }
            if (this.fUS != null) {
                aVar.e(4, this.fUS);
            }
            if (this.gxD != null) {
                aVar.e(5, this.gxD);
            }
            aVar.d(6, 8, this.hkm);
            aVar.eO(7, this.hkn);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.type) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.fUR != null) {
                r0 += a.a.a.b.b.a.f(3, this.fUR);
            }
            if (this.fUS != null) {
                r0 += a.a.a.b.b.a.f(4, this.fUS);
            }
            if (this.gxD != null) {
                r0 += a.a.a.b.b.a.f(5, this.gxD);
            }
            return (r0 + a.a.a.a.c(6, 8, this.hkm)) + a.a.a.a.eL(7, this.hkn);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hkm.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.type = aVar3.xmD.mL();
                    return 0;
                case 2:
                    iVar.name = aVar3.xmD.readString();
                    return 0;
                case 3:
                    iVar.fUR = aVar3.xmD.readString();
                    return 0;
                case 4:
                    iVar.fUS = aVar3.xmD.readString();
                    return 0;
                case 5:
                    iVar.gxD = aVar3.xmD.readString();
                    return 0;
                case 6:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a lVar = new l();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = lVar.a(aVar4, lVar, a.a(aVar4))) {
                        }
                        iVar.hkm.add(lVar);
                    }
                    return 0;
                case 7:
                    iVar.hkn = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
