package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class qr extends avh {
    public double latitude;
    public double longitude;
    public String njw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.njw != null) {
                aVar.e(2, this.njw);
            }
            aVar.a(3, this.latitude);
            aVar.a(4, this.longitude);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.njw != null) {
                r0 += a.a.a.b.b.a.f(2, this.njw);
            }
            return (r0 + (a.a.a.b.b.a.cH(3) + 8)) + (a.a.a.b.b.a.cH(4) + 8);
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
            qr qrVar = (qr) objArr[1];
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
                        qrVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    qrVar.njw = aVar3.xmD.readString();
                    return 0;
                case 3:
                    qrVar.latitude = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    qrVar.longitude = aVar3.xmD.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
