package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class rr extends a {
    public String appId;
    public String desc;
    public String fCJ;
    public String fOu;
    public rv fTi;
    public String title;
    public int type;
    public String tzb;
    public LinkedList<String> tzc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.fOu != null) {
                aVar.e(3, this.fOu);
            }
            if (this.tzb != null) {
                aVar.e(4, this.tzb);
            }
            if (this.appId != null) {
                aVar.e(5, this.appId);
            }
            if (this.fCJ != null) {
                aVar.e(6, this.fCJ);
            }
            aVar.d(7, 1, this.tzc);
            aVar.eO(8, this.type);
            if (this.fTi == null) {
                return 0;
            }
            aVar.eQ(9, this.fTi.aUk());
            this.fTi.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            if (this.fOu != null) {
                r0 += a.a.a.b.b.a.f(3, this.fOu);
            }
            if (this.tzb != null) {
                r0 += a.a.a.b.b.a.f(4, this.tzb);
            }
            if (this.appId != null) {
                r0 += a.a.a.b.b.a.f(5, this.appId);
            }
            if (this.fCJ != null) {
                r0 += a.a.a.b.b.a.f(6, this.fCJ);
            }
            r0 = (r0 + a.a.a.a.c(7, 1, this.tzc)) + a.a.a.a.eL(8, this.type);
            if (this.fTi != null) {
                r0 += a.a.a.a.eN(9, this.fTi.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tzc.clear();
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
            rr rrVar = (rr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rrVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    rrVar.desc = aVar3.xmD.readString();
                    return 0;
                case 3:
                    rrVar.fOu = aVar3.xmD.readString();
                    return 0;
                case 4:
                    rrVar.tzb = aVar3.xmD.readString();
                    return 0;
                case 5:
                    rrVar.appId = aVar3.xmD.readString();
                    return 0;
                case 6:
                    rrVar.fCJ = aVar3.xmD.readString();
                    return 0;
                case 7:
                    rrVar.tzc.add(aVar3.xmD.readString());
                    return 0;
                case 8:
                    rrVar.type = aVar3.xmD.mL();
                    return 0;
                case 9:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a rvVar = new rv();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = rvVar.a(aVar4, rvVar, a.a(aVar4))) {
                        }
                        rrVar.fTi = rvVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
