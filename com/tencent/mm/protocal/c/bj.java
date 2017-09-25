package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bj extends avh {
    public int ksW;
    public LinkedList<all> teK = new LinkedList();
    public avx teL;
    public int teM;
    public String teN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.teL == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.ksW);
            aVar.d(3, 8, this.teK);
            if (this.teL != null) {
                aVar.eQ(4, this.teL.aUk());
                this.teL.a(aVar);
            }
            aVar.eO(5, this.teM);
            if (this.teN == null) {
                return 0;
            }
            aVar.e(6, this.teN);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.ksW)) + a.a.a.a.c(3, 8, this.teK);
            if (this.teL != null) {
                r0 += a.a.a.a.eN(4, this.teL.aUk());
            }
            r0 += a.a.a.a.eL(5, this.teM);
            if (this.teN != null) {
                r0 += a.a.a.b.b.a.f(6, this.teN);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.teK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.teL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ChatRoomName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bj bjVar = (bj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        bjVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    bjVar.ksW = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new all();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        bjVar.teK.add(emVar);
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        bjVar.teL = emVar;
                    }
                    return 0;
                case 5:
                    bjVar.teM = aVar3.xmD.mL();
                    return 0;
                case 6:
                    bjVar.teN = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
