package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class x extends avp {
    public int kAC = 268513600;
    public String kAD = "请求不成功，请稍候再试";
    public String tbU;
    public int tbV;
    public int tbW;
    public String tbX;
    public LinkedList<k> tbY = new LinkedList();
    public String tbZ;

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
            aVar.eO(2, this.kAC);
            if (this.kAD != null) {
                aVar.e(3, this.kAD);
            }
            aVar.d(4, 8, this.tbY);
            if (this.tbZ != null) {
                aVar.e(5, this.tbZ);
            }
            if (this.tbU != null) {
                aVar.e(6, this.tbU);
            }
            aVar.eO(7, this.tbV);
            aVar.eO(8, this.tbW);
            if (this.tbX == null) {
                return 0;
            }
            aVar.e(9, this.tbX);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.kAC);
            if (this.kAD != null) {
                r0 += a.a.a.b.b.a.f(3, this.kAD);
            }
            r0 += a.a.a.a.c(4, 8, this.tbY);
            if (this.tbZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.tbZ);
            }
            if (this.tbU != null) {
                r0 += a.a.a.b.b.a.f(6, this.tbU);
            }
            r0 = (r0 + a.a.a.a.eL(7, this.tbV)) + a.a.a.a.eL(8, this.tbW);
            if (this.tbX != null) {
                r0 += a.a.a.b.b.a.f(9, this.tbX);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tbY.clear();
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
            x xVar = (x) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    xVar.kAC = aVar3.xmD.mL();
                    return 0;
                case 3:
                    xVar.kAD = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new k();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xVar.tbY.add(enVar);
                    }
                    return 0;
                case 5:
                    xVar.tbZ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    xVar.tbU = aVar3.xmD.readString();
                    return 0;
                case 7:
                    xVar.tbV = aVar3.xmD.mL();
                    return 0;
                case 8:
                    xVar.tbW = aVar3.xmD.mL();
                    return 0;
                case 9:
                    xVar.tbX = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
