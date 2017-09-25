package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class sg extends a {
    public boolean tAa;
    public boolean tAb;
    public boolean tAc;
    public boolean tAd;
    public boolean tAe;
    public boolean tAf;
    public boolean tAg;
    public boolean tAh;
    public boolean tAi;
    public boolean tAj;
    public boolean tzS;
    public boolean tzT;
    public boolean tzU;
    public boolean tzV;
    public boolean tzW;
    public boolean tzX;
    public boolean tzY;
    public boolean tzZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.an(1, this.tzS);
            aVar.an(2, this.tzT);
            aVar.an(3, this.tzU);
            aVar.an(4, this.tzV);
            aVar.an(5, this.tzW);
            aVar.an(6, this.tzX);
            aVar.an(7, this.tzY);
            aVar.an(8, this.tzZ);
            aVar.an(9, this.tAa);
            aVar.an(10, this.tAb);
            aVar.an(11, this.tAc);
            aVar.an(12, this.tAd);
            aVar.an(13, this.tAe);
            aVar.an(14, this.tAf);
            aVar.an(15, this.tAg);
            aVar.an(16, this.tAh);
            aVar.an(17, this.tAi);
            aVar.an(18, this.tAj);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((((((a.a.a.b.b.a.cH(1) + 1) + 0) + (a.a.a.b.b.a.cH(2) + 1)) + (a.a.a.b.b.a.cH(3) + 1)) + (a.a.a.b.b.a.cH(4) + 1)) + (a.a.a.b.b.a.cH(5) + 1)) + (a.a.a.b.b.a.cH(6) + 1)) + (a.a.a.b.b.a.cH(7) + 1)) + (a.a.a.b.b.a.cH(8) + 1)) + (a.a.a.b.b.a.cH(9) + 1)) + (a.a.a.b.b.a.cH(10) + 1)) + (a.a.a.b.b.a.cH(11) + 1)) + (a.a.a.b.b.a.cH(12) + 1)) + (a.a.a.b.b.a.cH(13) + 1)) + (a.a.a.b.b.a.cH(14) + 1)) + (a.a.a.b.b.a.cH(15) + 1)) + (a.a.a.b.b.a.cH(16) + 1)) + (a.a.a.b.b.a.cH(17) + 1)) + (a.a.a.b.b.a.cH(18) + 1);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                sg sgVar = (sg) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        sgVar.tzS = aVar3.cib();
                        return 0;
                    case 2:
                        sgVar.tzT = aVar3.cib();
                        return 0;
                    case 3:
                        sgVar.tzU = aVar3.cib();
                        return 0;
                    case 4:
                        sgVar.tzV = aVar3.cib();
                        return 0;
                    case 5:
                        sgVar.tzW = aVar3.cib();
                        return 0;
                    case 6:
                        sgVar.tzX = aVar3.cib();
                        return 0;
                    case 7:
                        sgVar.tzY = aVar3.cib();
                        return 0;
                    case 8:
                        sgVar.tzZ = aVar3.cib();
                        return 0;
                    case 9:
                        sgVar.tAa = aVar3.cib();
                        return 0;
                    case 10:
                        sgVar.tAb = aVar3.cib();
                        return 0;
                    case 11:
                        sgVar.tAc = aVar3.cib();
                        return 0;
                    case 12:
                        sgVar.tAd = aVar3.cib();
                        return 0;
                    case 13:
                        sgVar.tAe = aVar3.cib();
                        return 0;
                    case 14:
                        sgVar.tAf = aVar3.cib();
                        return 0;
                    case 15:
                        sgVar.tAg = aVar3.cib();
                        return 0;
                    case 16:
                        sgVar.tAh = aVar3.cib();
                        return 0;
                    case 17:
                        sgVar.tAi = aVar3.cib();
                        return 0;
                    case 18:
                        sgVar.tAj = aVar3.cib();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
