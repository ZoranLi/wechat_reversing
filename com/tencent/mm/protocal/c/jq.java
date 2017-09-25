package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class jq extends avh {
    public int boy;
    public String kBe;
    public b tpt;
    public b tpu;
    public int tpv = 4;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.boy);
            if (this.tpt != null) {
                aVar.b(3, this.tpt);
            }
            if (this.tpu != null) {
                aVar.b(4, this.tpu);
            }
            if (this.kBe != null) {
                aVar.e(5, this.kBe);
            }
            aVar.eO(6, this.tpv);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.boy);
            if (this.tpt != null) {
                r0 += a.a.a.a.a(3, this.tpt);
            }
            if (this.tpu != null) {
                r0 += a.a.a.a.a(4, this.tpu);
            }
            if (this.kBe != null) {
                r0 += a.a.a.b.b.a.f(5, this.kBe);
            }
            return r0 + a.a.a.a.eL(6, this.tpv);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            jq jqVar = (jq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        jqVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    jqVar.boy = aVar3.xmD.mL();
                    return 0;
                case 3:
                    jqVar.tpt = aVar3.cic();
                    return 0;
                case 4:
                    jqVar.tpu = aVar3.cic();
                    return 0;
                case 5:
                    jqVar.kBe = aVar3.xmD.readString();
                    return 0;
                case 6:
                    jqVar.tpv = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
