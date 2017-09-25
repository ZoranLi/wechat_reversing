package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class w extends avh {
    public int aIo;
    public int offset;
    public String tbU;
    public int tbV;
    public int tbW;
    public String tbX;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.aIo);
            aVar.eO(3, this.offset);
            aVar.eO(4, this.type);
            if (this.tbU != null) {
                aVar.e(5, this.tbU);
            }
            aVar.eO(6, this.tbV);
            aVar.eO(7, this.tbW);
            if (this.tbX == null) {
                return 0;
            }
            aVar.e(8, this.tbX);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.aIo)) + a.a.a.a.eL(3, this.offset)) + a.a.a.a.eL(4, this.type);
            if (this.tbU != null) {
                r0 += a.a.a.b.b.a.f(5, this.tbU);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tbV)) + a.a.a.a.eL(7, this.tbW);
            if (this.tbX != null) {
                r0 += a.a.a.b.b.a.f(8, this.tbX);
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
            w wVar = (w) objArr[1];
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
                        wVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    wVar.aIo = aVar3.xmD.mL();
                    return 0;
                case 3:
                    wVar.offset = aVar3.xmD.mL();
                    return 0;
                case 4:
                    wVar.type = aVar3.xmD.mL();
                    return 0;
                case 5:
                    wVar.tbU = aVar3.xmD.readString();
                    return 0;
                case 6:
                    wVar.tbV = aVar3.xmD.mL();
                    return 0;
                case 7:
                    wVar.tbW = aVar3.xmD.mL();
                    return 0;
                case 8:
                    wVar.tbX = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
