package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ps extends avp {
    public LinkedList<beu> teK = new LinkedList();
    public int thR;
    public LinkedList<bet> thS = new LinkedList();
    public int tvL;
    public long tvM;
    public int tvN;
    public int tvO;
    public int tvP;

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
            aVar.eO(2, this.tvL);
            aVar.O(3, this.tvM);
            aVar.eO(4, this.tvN);
            aVar.eO(5, this.tvO);
            aVar.d(6, 8, this.teK);
            aVar.eO(7, this.tvP);
            aVar.eO(8, this.thR);
            aVar.d(9, 8, this.thS);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (((((((r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.N(3, this.tvM)) + a.a.a.a.eL(4, this.tvN)) + a.a.a.a.eL(5, this.tvO)) + a.a.a.a.c(6, 8, this.teK)) + a.a.a.a.eL(7, this.tvP)) + a.a.a.a.eL(8, this.thR)) + a.a.a.a.c(9, 8, this.thS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.teK.clear();
            this.thS.clear();
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
            ps psVar = (ps) objArr[1];
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
                        psVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    psVar.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    psVar.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    psVar.tvN = aVar3.xmD.mL();
                    return 0;
                case 5:
                    psVar.tvO = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new beu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        psVar.teK.add(enVar);
                    }
                    return 0;
                case 7:
                    psVar.tvP = aVar3.xmD.mL();
                    return 0;
                case 8:
                    psVar.thR = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bet();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        psVar.thS.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
