package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class hf extends avh {
    public int tdM;
    public int tiL;
    public int tjX;
    public int tli;
    public avw tlj;
    public int tlk;
    public int tll;
    public int tlm;
    public int tln;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tlj == null) {
                throw new b("Not all required fields were included: ImageBuffer");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tli);
            if (this.tlj != null) {
                aVar.eQ(3, this.tlj.aUk());
                this.tlj.a(aVar);
            }
            aVar.eO(4, this.tlk);
            aVar.eO(5, this.tll);
            aVar.eO(6, this.tiL);
            aVar.eO(7, this.tlm);
            aVar.eO(8, this.tjX);
            aVar.eO(9, this.tln);
            aVar.eO(10, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tli);
            if (this.tlj != null) {
                r0 += a.a.a.a.eN(3, this.tlj.aUk());
            }
            return ((((((r0 + a.a.a.a.eL(4, this.tlk)) + a.a.a.a.eL(5, this.tll)) + a.a.a.a.eL(6, this.tiL)) + a.a.a.a.eL(7, this.tlm)) + a.a.a.a.eL(8, this.tjX)) + a.a.a.a.eL(9, this.tln)) + a.a.a.a.eL(10, this.tdM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tlj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImageBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hf hfVar = (hf) objArr[1];
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
                        hfVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    hfVar.tli = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        hfVar.tlj = emVar;
                    }
                    return 0;
                case 4:
                    hfVar.tlk = aVar3.xmD.mL();
                    return 0;
                case 5:
                    hfVar.tll = aVar3.xmD.mL();
                    return 0;
                case 6:
                    hfVar.tiL = aVar3.xmD.mL();
                    return 0;
                case 7:
                    hfVar.tlm = aVar3.xmD.mL();
                    return 0;
                case 8:
                    hfVar.tjX = aVar3.xmD.mL();
                    return 0;
                case 9:
                    hfVar.tln = aVar3.xmD.mL();
                    return 0;
                case 10:
                    hfVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
