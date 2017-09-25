package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class rh extends avh {
    public int tce;
    public float tmZ;
    public float tna;
    public String tuo;
    public String twP;
    public int twQ;
    public String twR;
    public String twS;
    public int twT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tce);
            if (this.twP != null) {
                aVar.e(3, this.twP);
            }
            aVar.n(4, this.tmZ);
            aVar.n(5, this.tna);
            aVar.eO(6, this.twQ);
            if (this.twR != null) {
                aVar.e(7, this.twR);
            }
            if (this.twS != null) {
                aVar.e(8, this.twS);
            }
            aVar.eO(9, this.twT);
            if (this.tuo == null) {
                return 0;
            }
            aVar.e(10, this.tuo);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tce);
            if (this.twP != null) {
                r0 += a.a.a.b.b.a.f(3, this.twP);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cH(4) + 4)) + (a.a.a.b.b.a.cH(5) + 4)) + a.a.a.a.eL(6, this.twQ);
            if (this.twR != null) {
                r0 += a.a.a.b.b.a.f(7, this.twR);
            }
            if (this.twS != null) {
                r0 += a.a.a.b.b.a.f(8, this.twS);
            }
            r0 += a.a.a.a.eL(9, this.twT);
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(10, this.tuo);
            }
            return r0;
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
            rh rhVar = (rh) objArr[1];
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
                        rhVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    rhVar.tce = aVar3.xmD.mL();
                    return 0;
                case 3:
                    rhVar.twP = aVar3.xmD.readString();
                    return 0;
                case 4:
                    rhVar.tmZ = aVar3.xmD.readFloat();
                    return 0;
                case 5:
                    rhVar.tna = aVar3.xmD.readFloat();
                    return 0;
                case 6:
                    rhVar.twQ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    rhVar.twR = aVar3.xmD.readString();
                    return 0;
                case 8:
                    rhVar.twS = aVar3.xmD.readString();
                    return 0;
                case 9:
                    rhVar.twT = aVar3.xmD.mL();
                    return 0;
                case 10:
                    rhVar.tuo = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
