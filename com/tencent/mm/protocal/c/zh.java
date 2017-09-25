package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class zh extends avh {
    public int Height;
    public int Width;
    public String leO;
    public int tFI;
    public int tFJ;
    public float tmZ;
    public float tna;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.n(2, this.tmZ);
            aVar.n(3, this.tna);
            aVar.eO(4, this.Width);
            aVar.eO(5, this.Height);
            if (this.leO != null) {
                aVar.e(6, this.leO);
            }
            aVar.eO(7, this.tFI);
            aVar.eO(8, this.tFJ);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + (a.a.a.b.b.a.cH(2) + 4)) + (a.a.a.b.b.a.cH(3) + 4)) + a.a.a.a.eL(4, this.Width)) + a.a.a.a.eL(5, this.Height);
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(6, this.leO);
            }
            return (r0 + a.a.a.a.eL(7, this.tFI)) + a.a.a.a.eL(8, this.tFJ);
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
            zh zhVar = (zh) objArr[1];
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
                        zhVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    zhVar.tmZ = aVar3.xmD.readFloat();
                    return 0;
                case 3:
                    zhVar.tna = aVar3.xmD.readFloat();
                    return 0;
                case 4:
                    zhVar.Width = aVar3.xmD.mL();
                    return 0;
                case 5:
                    zhVar.Height = aVar3.xmD.mL();
                    return 0;
                case 6:
                    zhVar.leO = aVar3.xmD.readString();
                    return 0;
                case 7:
                    zhVar.tFI = aVar3.xmD.mL();
                    return 0;
                case 8:
                    zhVar.tFJ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
