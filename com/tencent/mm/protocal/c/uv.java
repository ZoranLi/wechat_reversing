package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class uv extends avp {
    public int kAC;
    public String kAD;
    public LinkedList<String> tCv = new LinkedList();
    public String tCw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.d(2, 1, this.tCv);
            aVar.eO(3, this.kAC);
            if (this.kAD != null) {
                aVar.e(4, this.kAD);
            }
            if (this.tCw == null) {
                return 0;
            }
            aVar.e(5, this.tCw);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.c(2, 1, this.tCv)) + a.a.a.a.eL(3, this.kAC);
            if (this.kAD != null) {
                r0 += a.a.a.b.b.a.f(4, this.kAD);
            }
            if (this.tCw != null) {
                r0 += a.a.a.b.b.a.f(5, this.tCw);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tCv.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            uv uvVar = (uv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        uvVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    uvVar.tCv.add(aVar3.xmD.readString());
                    return 0;
                case 3:
                    uvVar.kAC = aVar3.xmD.mL();
                    return 0;
                case 4:
                    uvVar.kAD = aVar3.xmD.readString();
                    return 0;
                case 5:
                    uvVar.tCw = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}