package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class a extends i {
    public String jNn;
    public b leH;
    public int leI;
    public int leJ;
    public int leK;
    public b leL;
    public b leM;
    public String leN;
    public String leO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lfh != null) {
                aVar.eQ(1, this.lfh.aUk());
                this.lfh.a(aVar);
            }
            if (this.leH != null) {
                aVar.b(2, this.leH);
            }
            aVar.eO(3, this.leI);
            aVar.eO(4, this.leJ);
            aVar.eO(5, this.leK);
            if (this.leL != null) {
                aVar.b(6, this.leL);
            }
            if (this.leM != null) {
                aVar.b(7, this.leM);
            }
            if (this.leN != null) {
                aVar.e(10, this.leN);
            }
            if (this.leO != null) {
                aVar.e(11, this.leO);
            }
            if (this.jNn == null) {
                return 0;
            }
            aVar.e(12, this.jNn);
            return 0;
        } else if (i == 1) {
            if (this.lfh != null) {
                r0 = a.a.a.a.eN(1, this.lfh.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.leH != null) {
                r0 += a.a.a.a.a(2, this.leH);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.leI)) + a.a.a.a.eL(4, this.leJ)) + a.a.a.a.eL(5, this.leK);
            if (this.leL != null) {
                r0 += a.a.a.a.a(6, this.leL);
            }
            if (this.leM != null) {
                r0 += a.a.a.a.a(7, this.leM);
            }
            if (this.leN != null) {
                r0 += a.a.a.b.b.a.f(10, this.leN);
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(11, this.leO);
            }
            if (this.jNn != null) {
                r0 += a.a.a.b.b.a.f(12, this.jNn);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = i.a(aVar2); r0 > 0; r0 = i.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a dVar = new d();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar5, dVar, i.a(aVar5))) {
                        }
                        aVar4.lfh = dVar;
                    }
                    return 0;
                case 2:
                    aVar4.leH = aVar3.cic();
                    return 0;
                case 3:
                    aVar4.leI = aVar3.xmD.mL();
                    return 0;
                case 4:
                    aVar4.leJ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    aVar4.leK = aVar3.xmD.mL();
                    return 0;
                case 6:
                    aVar4.leL = aVar3.cic();
                    return 0;
                case 7:
                    aVar4.leM = aVar3.cic();
                    return 0;
                case 10:
                    aVar4.leN = aVar3.xmD.readString();
                    return 0;
                case 11:
                    aVar4.leO = aVar3.xmD.readString();
                    return 0;
                case 12:
                    aVar4.jNn = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
