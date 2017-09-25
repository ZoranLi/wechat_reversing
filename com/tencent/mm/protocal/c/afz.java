package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class afz extends avh {
    public String tLd;
    public LinkedList<String> tLe = new LinkedList();
    public String tsS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.tLd == null) {
                throw new b("Not all required fields were included: bizchat_name");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tsS != null) {
                    aVar.e(2, this.tsS);
                }
                if (this.tLd != null) {
                    aVar.e(3, this.tLd);
                }
                aVar.d(4, 1, this.tLe);
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
            if (this.tLd != null) {
                r0 += a.a.a.b.b.a.f(3, this.tLd);
            }
            return r0 + a.a.a.a.c(4, 1, this.tLe);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tLe.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.tLd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            afz com_tencent_mm_protocal_c_afz = (afz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afz.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afz.tsS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afz.tLd = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afz.tLe.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
