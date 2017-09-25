package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class kn extends avh {
    public String tqK;
    public String tqL;
    public String tqM;
    public String tqN;
    public String tqO;
    public long tqP;
    public String tqQ;
    public String tqR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tqK != null) {
                aVar.e(2, this.tqK);
            }
            if (this.tqL != null) {
                aVar.e(3, this.tqL);
            }
            if (this.tqM != null) {
                aVar.e(4, this.tqM);
            }
            if (this.tqN != null) {
                aVar.e(5, this.tqN);
            }
            if (this.tqO != null) {
                aVar.e(6, this.tqO);
            }
            aVar.O(7, this.tqP);
            if (this.tqQ != null) {
                aVar.e(8, this.tqQ);
            }
            if (this.tqR == null) {
                return 0;
            }
            aVar.e(9, this.tqR);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tqK != null) {
                r0 += a.a.a.b.b.a.f(2, this.tqK);
            }
            if (this.tqL != null) {
                r0 += a.a.a.b.b.a.f(3, this.tqL);
            }
            if (this.tqM != null) {
                r0 += a.a.a.b.b.a.f(4, this.tqM);
            }
            if (this.tqN != null) {
                r0 += a.a.a.b.b.a.f(5, this.tqN);
            }
            if (this.tqO != null) {
                r0 += a.a.a.b.b.a.f(6, this.tqO);
            }
            r0 += a.a.a.a.N(7, this.tqP);
            if (this.tqQ != null) {
                r0 += a.a.a.b.b.a.f(8, this.tqQ);
            }
            if (this.tqR != null) {
                r0 += a.a.a.b.b.a.f(9, this.tqR);
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
            kn knVar = (kn) objArr[1];
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
                        knVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    knVar.tqK = aVar3.xmD.readString();
                    return 0;
                case 3:
                    knVar.tqL = aVar3.xmD.readString();
                    return 0;
                case 4:
                    knVar.tqM = aVar3.xmD.readString();
                    return 0;
                case 5:
                    knVar.tqN = aVar3.xmD.readString();
                    return 0;
                case 6:
                    knVar.tqO = aVar3.xmD.readString();
                    return 0;
                case 7:
                    knVar.tqP = aVar3.xmD.mM();
                    return 0;
                case 8:
                    knVar.tqQ = aVar3.xmD.readString();
                    return 0;
                case 9:
                    knVar.tqR = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
