package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.em;
import java.util.LinkedList;

public final class al extends avh {
    public String hAM;
    public String msh;
    public String mtJ;
    public boolean mtR;
    public boolean mtS;
    public boolean mtT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mtJ == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.msh == null) {
                throw new b("Not all required fields were included: AppID");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.mtJ != null) {
                    aVar.e(2, this.mtJ);
                }
                if (this.msh != null) {
                    aVar.e(3, this.msh);
                }
                aVar.an(4, this.mtR);
                if (this.hAM != null) {
                    aVar.e(5, this.hAM);
                }
                aVar.an(6, this.mtS);
                aVar.an(7, this.mtT);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtJ);
            }
            if (this.msh != null) {
                r0 += a.a.a.b.b.a.f(3, this.msh);
            }
            r0 += a.a.a.b.b.a.cH(4) + 1;
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(5, this.hAM);
            }
            return (r0 + (a.a.a.b.b.a.cH(6) + 1)) + (a.a.a.b.b.a.cH(7) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mtJ == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.msh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            al alVar = (al) objArr[1];
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
                        alVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    alVar.mtJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    alVar.msh = aVar3.xmD.readString();
                    return 0;
                case 4:
                    alVar.mtR = aVar3.cib();
                    return 0;
                case 5:
                    alVar.hAM = aVar3.xmD.readString();
                    return 0;
                case 6:
                    alVar.mtS = aVar3.cib();
                    return 0;
                case 7:
                    alVar.mtT = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
