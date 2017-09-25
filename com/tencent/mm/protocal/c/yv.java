package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class yv extends avh {
    public String lTm;
    public String lTn;
    public String lTo;
    public String tch;
    public oc tcy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.lTm != null) {
                aVar.e(2, this.lTm);
            }
            if (this.lTn != null) {
                aVar.e(3, this.lTn);
            }
            if (this.lTo != null) {
                aVar.e(4, this.lTo);
            }
            if (this.tch != null) {
                aVar.e(5, this.tch);
            }
            if (this.tcy == null) {
                return 0;
            }
            aVar.eQ(6, this.tcy.aUk());
            this.tcy.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lTm != null) {
                r0 += a.a.a.b.b.a.f(2, this.lTm);
            }
            if (this.lTn != null) {
                r0 += a.a.a.b.b.a.f(3, this.lTn);
            }
            if (this.lTo != null) {
                r0 += a.a.a.b.b.a.f(4, this.lTo);
            }
            if (this.tch != null) {
                r0 += a.a.a.b.b.a.f(5, this.tch);
            }
            if (this.tcy != null) {
                r0 += a.a.a.a.eN(6, this.tcy.aUk());
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
            yv yvVar = (yv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        yvVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    yvVar.lTm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    yvVar.lTn = aVar3.xmD.readString();
                    return 0;
                case 4:
                    yvVar.lTo = aVar3.xmD.readString();
                    return 0;
                case 5:
                    yvVar.tch = aVar3.xmD.readString();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new oc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        yvVar.tcy = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
