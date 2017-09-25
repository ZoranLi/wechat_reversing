package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bq extends avh {
    public int jOc;
    public String teW;
    public int teX;
    public String teY;
    public String teZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.teW != null) {
                aVar.e(2, this.teW);
            }
            aVar.eO(3, this.jOc);
            aVar.eO(4, this.teX);
            if (this.teY != null) {
                aVar.e(5, this.teY);
            }
            if (this.teZ == null) {
                return 0;
            }
            aVar.e(6, this.teZ);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.teW != null) {
                r0 += a.a.a.b.b.a.f(2, this.teW);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.jOc)) + a.a.a.a.eL(4, this.teX);
            if (this.teY != null) {
                r0 += a.a.a.b.b.a.f(5, this.teY);
            }
            if (this.teZ != null) {
                r0 += a.a.a.b.b.a.f(6, this.teZ);
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
            bq bqVar = (bq) objArr[1];
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
                        bqVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    bqVar.teW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bqVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    bqVar.teX = aVar3.xmD.mL();
                    return 0;
                case 5:
                    bqVar.teY = aVar3.xmD.readString();
                    return 0;
                case 6:
                    bqVar.teZ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
