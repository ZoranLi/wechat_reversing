package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class x extends a {
    public String msG;
    public String mto;
    public String mtp;
    public int mtq;
    public int mtr;
    public bf mts;
    public be mtt;
    public bg mtu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mto != null) {
                aVar.e(1, this.mto);
            }
            if (this.mtp != null) {
                aVar.e(2, this.mtp);
            }
            aVar.eO(3, this.mtq);
            if (this.msG != null) {
                aVar.e(4, this.msG);
            }
            aVar.eO(5, this.mtr);
            if (this.mts != null) {
                aVar.eQ(6, this.mts.aUk());
                this.mts.a(aVar);
            }
            if (this.mtt != null) {
                aVar.eQ(7, this.mtt.aUk());
                this.mtt.a(aVar);
            }
            if (this.mtu == null) {
                return 0;
            }
            aVar.eQ(9, this.mtu.aUk());
            this.mtu.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mto != null) {
                r0 = a.a.a.b.b.a.f(1, this.mto) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtp != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtp);
            }
            r0 += a.a.a.a.eL(3, this.mtq);
            if (this.msG != null) {
                r0 += a.a.a.b.b.a.f(4, this.msG);
            }
            r0 += a.a.a.a.eL(5, this.mtr);
            if (this.mts != null) {
                r0 += a.a.a.a.eN(6, this.mts.aUk());
            }
            if (this.mtt != null) {
                r0 += a.a.a.a.eN(7, this.mtt.aUk());
            }
            if (this.mtu != null) {
                r0 += a.a.a.a.eN(9, this.mtu.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a bfVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    xVar.mto = aVar3.xmD.readString();
                    return 0;
                case 2:
                    xVar.mtp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    xVar.mtq = aVar3.xmD.mL();
                    return 0;
                case 4:
                    xVar.msG = aVar3.xmD.readString();
                    return 0;
                case 5:
                    xVar.mtr = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bfVar = new bf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfVar.a(aVar4, bfVar, a.a(aVar4))) {
                        }
                        xVar.mts = bfVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bfVar = new be();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfVar.a(aVar4, bfVar, a.a(aVar4))) {
                        }
                        xVar.mtt = bfVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bfVar = new bg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfVar.a(aVar4, bfVar, a.a(aVar4))) {
                        }
                        xVar.mtu = bfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
