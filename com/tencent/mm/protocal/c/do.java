package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class do extends avp {
    public String msh;
    public String tgY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tgY == null) {
                throw new b("Not all required fields were included: ReqKey");
            } else if (this.msh == null) {
                throw new b("Not all required fields were included: AppID");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tgY != null) {
                    aVar.e(2, this.tgY);
                }
                if (this.msh == null) {
                    return 0;
                }
                aVar.e(3, this.msh);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tgY != null) {
                r0 += a.a.a.b.b.a.f(2, this.tgY);
            }
            if (this.msh != null) {
                r0 += a.a.a.b.b.a.f(3, this.msh);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tgY == null) {
                throw new b("Not all required fields were included: ReqKey");
            } else if (this.msh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            do doVar = (do) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        doVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    doVar.tgY = aVar3.xmD.readString();
                    return 0;
                case 3:
                    doVar.msh = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
