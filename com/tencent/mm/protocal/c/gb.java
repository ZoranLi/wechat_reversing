package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class gb extends avh {
    public int thO;
    public int tjq;
    public String tjr;
    public String tjs;
    public String tjt;
    public String tju;
    public String tjv;
    public String tjw;
    public String tjx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.thO);
            aVar.eO(3, this.tjq);
            if (this.tjr != null) {
                aVar.e(4, this.tjr);
            }
            if (this.tjs != null) {
                aVar.e(5, this.tjs);
            }
            if (this.tjt != null) {
                aVar.e(6, this.tjt);
            }
            if (this.tju != null) {
                aVar.e(7, this.tju);
            }
            if (this.tjv != null) {
                aVar.e(8, this.tjv);
            }
            if (this.tjw != null) {
                aVar.e(9, this.tjw);
            }
            if (this.tjx == null) {
                return 0;
            }
            aVar.e(10, this.tjx);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.thO)) + a.a.a.a.eL(3, this.tjq);
            if (this.tjr != null) {
                r0 += a.a.a.b.b.a.f(4, this.tjr);
            }
            if (this.tjs != null) {
                r0 += a.a.a.b.b.a.f(5, this.tjs);
            }
            if (this.tjt != null) {
                r0 += a.a.a.b.b.a.f(6, this.tjt);
            }
            if (this.tju != null) {
                r0 += a.a.a.b.b.a.f(7, this.tju);
            }
            if (this.tjv != null) {
                r0 += a.a.a.b.b.a.f(8, this.tjv);
            }
            if (this.tjw != null) {
                r0 += a.a.a.b.b.a.f(9, this.tjw);
            }
            if (this.tjx != null) {
                r0 += a.a.a.b.b.a.f(10, this.tjx);
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
            gb gbVar = (gb) objArr[1];
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
                        gbVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    gbVar.thO = aVar3.xmD.mL();
                    return 0;
                case 3:
                    gbVar.tjq = aVar3.xmD.mL();
                    return 0;
                case 4:
                    gbVar.tjr = aVar3.xmD.readString();
                    return 0;
                case 5:
                    gbVar.tjs = aVar3.xmD.readString();
                    return 0;
                case 6:
                    gbVar.tjt = aVar3.xmD.readString();
                    return 0;
                case 7:
                    gbVar.tju = aVar3.xmD.readString();
                    return 0;
                case 8:
                    gbVar.tjv = aVar3.xmD.readString();
                    return 0;
                case 9:
                    gbVar.tjw = aVar3.xmD.readString();
                    return 0;
                case 10:
                    gbVar.tjx = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
