package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class pe extends a {
    public String fDC;
    public int fxo;
    public String msk;
    public String muU;
    public String tgW;
    public pd tuK;
    public String tuM;
    public String tuN;
    public int tuO;
    public String tuP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tuK == null) {
                throw new b("Not all required fields were included: BannerImg");
            }
            if (this.tuK != null) {
                aVar.eQ(1, this.tuK.aUk());
                this.tuK.a(aVar);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            if (this.tuM != null) {
                aVar.e(3, this.tuM);
            }
            aVar.eO(4, this.fxo);
            if (this.tuN != null) {
                aVar.e(5, this.tuN);
            }
            aVar.eO(6, this.tuO);
            if (this.muU != null) {
                aVar.e(7, this.muU);
            }
            if (this.msk != null) {
                aVar.e(8, this.msk);
            }
            if (this.tgW != null) {
                aVar.e(9, this.tgW);
            }
            if (this.tuP == null) {
                return 0;
            }
            aVar.e(10, this.tuP);
            return 0;
        } else if (i == 1) {
            if (this.tuK != null) {
                r0 = a.a.a.a.eN(1, this.tuK.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.tuM != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuM);
            }
            r0 += a.a.a.a.eL(4, this.fxo);
            if (this.tuN != null) {
                r0 += a.a.a.b.b.a.f(5, this.tuN);
            }
            r0 += a.a.a.a.eL(6, this.tuO);
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(7, this.muU);
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(8, this.msk);
            }
            if (this.tgW != null) {
                r0 += a.a.a.b.b.a.f(9, this.tgW);
            }
            if (this.tuP != null) {
                r0 += a.a.a.b.b.a.f(10, this.tuP);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tuK != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BannerImg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            pe peVar = (pe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a pdVar = new pd();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = pdVar.a(aVar4, pdVar, a.a(aVar4))) {
                        }
                        peVar.tuK = pdVar;
                    }
                    return 0;
                case 2:
                    peVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    peVar.tuM = aVar3.xmD.readString();
                    return 0;
                case 4:
                    peVar.fxo = aVar3.xmD.mL();
                    return 0;
                case 5:
                    peVar.tuN = aVar3.xmD.readString();
                    return 0;
                case 6:
                    peVar.tuO = aVar3.xmD.mL();
                    return 0;
                case 7:
                    peVar.muU = aVar3.xmD.readString();
                    return 0;
                case 8:
                    peVar.msk = aVar3.xmD.readString();
                    return 0;
                case 9:
                    peVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 10:
                    peVar.tuP = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
