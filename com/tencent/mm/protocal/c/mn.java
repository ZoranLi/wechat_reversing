package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class mn extends avh {
    public String tsS;
    public String tsT;
    public String tsU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.tsT == null) {
                throw new b("Not all required fields were included: qychat_type");
            } else if (this.tsU == null) {
                throw new b("Not all required fields were included: qychat_id");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tsS != null) {
                    aVar.e(2, this.tsS);
                }
                if (this.tsT != null) {
                    aVar.e(3, this.tsT);
                }
                if (this.tsU == null) {
                    return 0;
                }
                aVar.e(4, this.tsU);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tsS != null) {
                r0 += a.a.a.b.b.a.f(2, this.tsS);
            }
            if (this.tsT != null) {
                r0 += a.a.a.b.b.a.f(3, this.tsT);
            }
            if (this.tsU != null) {
                r0 += a.a.a.b.b.a.f(4, this.tsU);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.tsT == null) {
                throw new b("Not all required fields were included: qychat_type");
            } else if (this.tsU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: qychat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            mn mnVar = (mn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        mnVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    mnVar.tsS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mnVar.tsT = aVar3.xmD.readString();
                    return 0;
                case 4:
                    mnVar.tsU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
