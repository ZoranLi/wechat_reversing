package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class hg extends avp {
    public int jOc;
    public int tiL;
    public int tli;
    public int tlm;
    public String tlo;
    public float tlp;
    public float tlq;

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
            aVar.eO(2, this.tli);
            aVar.eO(3, this.jOc);
            if (this.tlo != null) {
                aVar.e(4, this.tlo);
            }
            aVar.eO(5, this.tiL);
            aVar.eO(6, this.tlm);
            aVar.n(7, this.tlp);
            aVar.n(8, this.tlq);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tli)) + a.a.a.a.eL(3, this.jOc);
            if (this.tlo != null) {
                r0 += a.a.a.b.b.a.f(4, this.tlo);
            }
            return (((r0 + a.a.a.a.eL(5, this.tiL)) + a.a.a.a.eL(6, this.tlm)) + (a.a.a.b.b.a.cH(7) + 4)) + (a.a.a.b.b.a.cH(8) + 4);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            hg hgVar = (hg) objArr[1];
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
                        hgVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    hgVar.tli = aVar3.xmD.mL();
                    return 0;
                case 3:
                    hgVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    hgVar.tlo = aVar3.xmD.readString();
                    return 0;
                case 5:
                    hgVar.tiL = aVar3.xmD.mL();
                    return 0;
                case 6:
                    hgVar.tlm = aVar3.xmD.mL();
                    return 0;
                case 7:
                    hgVar.tlp = aVar3.xmD.readFloat();
                    return 0;
                case 8:
                    hgVar.tlq = aVar3.xmD.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
