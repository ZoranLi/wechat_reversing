package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class akq extends avp {
    public int tOo;
    public String tOp;
    public String tlt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tlt == null) {
                throw new b("Not all required fields were included: Json");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            if (this.tlt != null) {
                aVar.e(2, this.tlt);
            }
            aVar.eO(3, this.tOo);
            if (this.tOp == null) {
                return 0;
            }
            aVar.e(4, this.tOp);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tlt != null) {
                r0 += a.a.a.b.b.a.f(2, this.tlt);
            }
            r0 += a.a.a.a.eL(3, this.tOo);
            if (this.tOp != null) {
                r0 += a.a.a.b.b.a.f(4, this.tOp);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tlt != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Json");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            akq com_tencent_mm_protocal_c_akq = (akq) objArr[1];
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
                        com_tencent_mm_protocal_c_akq.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akq.tlt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akq.tOo = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akq.tOp = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
