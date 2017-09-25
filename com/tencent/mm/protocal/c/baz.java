package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class baz extends avp {
    public int tRg;
    public String tgT;
    public LinkedList<bbk> tiQ = new LinkedList();
    public String ubX;
    public int ucb;
    public int ucc;
    public bcb ucd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ucd == null) {
                throw new b("Not all required fields were included: ServerConfig");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.ubX != null) {
                    aVar.e(2, this.ubX);
                }
                aVar.eO(3, this.tRg);
                aVar.d(4, 8, this.tiQ);
                aVar.eO(5, this.ucb);
                if (this.tgT != null) {
                    aVar.e(6, this.tgT);
                }
                aVar.eO(7, this.ucc);
                if (this.ucd == null) {
                    return 0;
                }
                aVar.eQ(8, this.ucd.aUk());
                this.ucd.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ubX != null) {
                r0 += a.a.a.b.b.a.f(2, this.ubX);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.tRg)) + a.a.a.a.c(4, 8, this.tiQ)) + a.a.a.a.eL(5, this.ucb);
            if (this.tgT != null) {
                r0 += a.a.a.b.b.a.f(6, this.tgT);
            }
            r0 += a.a.a.a.eL(7, this.ucc);
            if (this.ucd != null) {
                r0 += a.a.a.a.eN(8, this.ucd.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tiQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ucd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ServerConfig");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            baz com_tencent_mm_protocal_c_baz = (baz) objArr[1];
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
                        com_tencent_mm_protocal_c_baz.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_baz.ubX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_baz.tRg = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bbk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_baz.tiQ.add(enVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_baz.ucb = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_baz.tgT = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_baz.ucc = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bcb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_baz.ucd = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
