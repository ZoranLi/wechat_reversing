package com.tencent.mm.plugin.qqmail.b;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class d extends a {
    public String content;
    public int ozk;
    public String ozl;
    public LinkedList<i> ozm = new LinkedList();
    public LinkedList<i> ozn = new LinkedList();
    public LinkedList<i> ozo = new LinkedList();
    public LinkedList<y> ozp = new LinkedList();
    public String ozq;
    public int ozr = 5;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.content == null) {
                throw new b("Not all required fields were included: content");
            }
            aVar.eO(1, this.ozk);
            if (this.ozl != null) {
                aVar.e(2, this.ozl);
            }
            aVar.d(3, 8, this.ozm);
            aVar.d(4, 8, this.ozn);
            aVar.d(5, 8, this.ozo);
            aVar.d(6, 8, this.ozp);
            if (this.ozq != null) {
                aVar.e(7, this.ozq);
            }
            if (this.content != null) {
                aVar.e(8, this.content);
            }
            aVar.eO(9, this.ozr);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.ozk) + 0;
            if (this.ozl != null) {
                r0 += a.a.a.b.b.a.f(2, this.ozl);
            }
            r0 = (((r0 + a.a.a.a.c(3, 8, this.ozm)) + a.a.a.a.c(4, 8, this.ozn)) + a.a.a.a.c(5, 8, this.ozo)) + a.a.a.a.c(6, 8, this.ozp);
            if (this.ozq != null) {
                r0 += a.a.a.b.b.a.f(7, this.ozq);
            }
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(8, this.content);
            }
            return r0 + a.a.a.a.eL(9, this.ozr);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ozm.clear();
            this.ozn.clear();
            this.ozo.clear();
            this.ozp.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.content != null) {
                return 0;
            }
            throw new b("Not all required fields were included: content");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a iVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dVar.ozk = aVar3.xmD.mL();
                    return 0;
                case 2:
                    dVar.ozl = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        iVar = new i();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ozm.add(iVar);
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        iVar = new i();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ozn.add(iVar);
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        iVar = new i();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ozo.add(iVar);
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        iVar = new y();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ozp.add(iVar);
                    }
                    return 0;
                case 7:
                    dVar.ozq = aVar3.xmD.readString();
                    return 0;
                case 8:
                    dVar.content = aVar3.xmD.readString();
                    return 0;
                case 9:
                    dVar.ozr = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
