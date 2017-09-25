package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class l extends a {
    public String msS;
    public String msT;
    public String msU;
    public cm msV;
    public int msW;
    public int msX;
    public String msY;
    public int msZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msS == null) {
                throw new b("Not all required fields were included: DownloadURL");
            }
            if (this.msS != null) {
                aVar.e(1, this.msS);
            }
            if (this.msT != null) {
                aVar.e(2, this.msT);
            }
            if (this.msU != null) {
                aVar.e(4, this.msU);
            }
            if (this.msV != null) {
                aVar.eQ(5, this.msV.aUk());
                this.msV.a(aVar);
            }
            aVar.eO(6, this.msW);
            aVar.eO(7, this.msX);
            if (this.msY != null) {
                aVar.e(8, this.msY);
            }
            aVar.eO(9, this.msZ);
            return 0;
        } else if (i == 1) {
            if (this.msS != null) {
                r0 = a.a.a.b.b.a.f(1, this.msS) + 0;
            } else {
                r0 = 0;
            }
            if (this.msT != null) {
                r0 += a.a.a.b.b.a.f(2, this.msT);
            }
            if (this.msU != null) {
                r0 += a.a.a.b.b.a.f(4, this.msU);
            }
            if (this.msV != null) {
                r0 += a.a.a.a.eN(5, this.msV.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(6, this.msW)) + a.a.a.a.eL(7, this.msX);
            if (this.msY != null) {
                r0 += a.a.a.b.b.a.f(8, this.msY);
            }
            return r0 + a.a.a.a.eL(9, this.msZ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.msS = aVar3.xmD.readString();
                    return 0;
                case 2:
                    lVar.msT = aVar3.xmD.readString();
                    return 0;
                case 4:
                    lVar.msU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a cmVar = new cm();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        lVar.msV = cmVar;
                    }
                    return 0;
                case 6:
                    lVar.msW = aVar3.xmD.mL();
                    return 0;
                case 7:
                    lVar.msX = aVar3.xmD.mL();
                    return 0;
                case 8:
                    lVar.msY = aVar3.xmD.readString();
                    return 0;
                case 9:
                    lVar.msZ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
