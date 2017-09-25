package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class vo extends avh {
    public String data;
    public int ou;
    public String tsS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.data == null) {
                throw new b("Not all required fields were included: data");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tsS != null) {
                    aVar.e(2, this.tsS);
                }
                aVar.eO(3, this.ou);
                if (this.data == null) {
                    return 0;
                }
                aVar.e(4, this.data);
                return 0;
            }
        } else if (i == 1) {
            int eN;
            if (this.tYN != null) {
                eN = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                eN = 0;
            }
            if (this.tsS != null) {
                eN += a.a.a.b.b.a.f(2, this.tsS);
            }
            eN += a.a.a.a.eL(3, this.ou);
            if (this.data != null) {
                eN += a.a.a.b.b.a.f(4, this.data);
            }
            return eN;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (int a = avh.a(aVar2); a > 0; a = avh.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cid();
                }
            }
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (r0 != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            vo voVar = (vo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        voVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    voVar.tsS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    voVar.ou = aVar3.xmD.mL();
                    return 0;
                case 4:
                    voVar.data = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
