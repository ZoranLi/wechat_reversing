package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class px extends avh {
    public int tdM;
    public String tgW;
    public String tvS;
    public int tvT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tgW != null) {
                aVar.e(2, this.tgW);
            }
            if (this.tvS != null) {
                aVar.e(3, this.tvS);
            }
            aVar.eO(4, this.tvT);
            aVar.eO(5, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tgW != null) {
                r0 += a.a.a.b.b.a.f(2, this.tgW);
            }
            if (this.tvS != null) {
                r0 += a.a.a.b.b.a.f(3, this.tvS);
            }
            return (r0 + a.a.a.a.eL(4, this.tvT)) + a.a.a.a.eL(5, this.tdM);
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
            px pxVar = (px) objArr[1];
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
                        pxVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    pxVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    pxVar.tvS = aVar3.xmD.readString();
                    return 0;
                case 4:
                    pxVar.tvT = aVar3.xmD.mL();
                    return 0;
                case 5:
                    pxVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
