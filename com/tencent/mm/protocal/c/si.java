package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class si extends avh {
    public String ohr;
    public String tAn;
    public String tAo;
    public String tAp;
    public String tjy;
    public String tuo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tAn != null) {
                aVar.e(2, this.tAn);
            }
            if (this.tjy != null) {
                aVar.e(3, this.tjy);
            }
            if (this.ohr != null) {
                aVar.e(4, this.ohr);
            }
            if (this.tAo != null) {
                aVar.e(5, this.tAo);
            }
            if (this.tAp != null) {
                aVar.e(6, this.tAp);
            }
            if (this.tuo == null) {
                return 0;
            }
            aVar.e(7, this.tuo);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tAn != null) {
                r0 += a.a.a.b.b.a.f(2, this.tAn);
            }
            if (this.tjy != null) {
                r0 += a.a.a.b.b.a.f(3, this.tjy);
            }
            if (this.ohr != null) {
                r0 += a.a.a.b.b.a.f(4, this.ohr);
            }
            if (this.tAo != null) {
                r0 += a.a.a.b.b.a.f(5, this.tAo);
            }
            if (this.tAp != null) {
                r0 += a.a.a.b.b.a.f(6, this.tAp);
            }
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(7, this.tuo);
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
            si siVar = (si) objArr[1];
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
                        siVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    siVar.tAn = aVar3.xmD.readString();
                    return 0;
                case 3:
                    siVar.tjy = aVar3.xmD.readString();
                    return 0;
                case 4:
                    siVar.ohr = aVar3.xmD.readString();
                    return 0;
                case 5:
                    siVar.tAo = aVar3.xmD.readString();
                    return 0;
                case 6:
                    siVar.tAp = aVar3.xmD.readString();
                    return 0;
                case 7:
                    siVar.tuo = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
