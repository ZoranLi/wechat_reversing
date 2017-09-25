package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class se extends a {
    public int tzA;
    public int tzB;
    public int tzC;
    public int tzD;
    public int tzE;
    public int tzF;
    public int tzG;
    public int tzH;
    public int tzI;
    public int tzJ;
    public int tzK;
    public int tzL;
    public int tzM;
    public int tzy;
    public int tzz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tzy);
            aVar.eO(2, this.tzz);
            aVar.eO(3, this.tzA);
            aVar.eO(4, this.tzB);
            aVar.eO(5, this.tzC);
            aVar.eO(6, this.tzD);
            aVar.eO(7, this.tzE);
            aVar.eO(8, this.tzF);
            aVar.eO(9, this.tzG);
            aVar.eO(10, this.tzH);
            aVar.eO(11, this.tzI);
            aVar.eO(12, this.tzJ);
            aVar.eO(13, this.tzK);
            aVar.eO(14, this.tzL);
            aVar.eO(15, this.tzM);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((a.a.a.a.eL(1, this.tzy) + 0) + a.a.a.a.eL(2, this.tzz)) + a.a.a.a.eL(3, this.tzA)) + a.a.a.a.eL(4, this.tzB)) + a.a.a.a.eL(5, this.tzC)) + a.a.a.a.eL(6, this.tzD)) + a.a.a.a.eL(7, this.tzE)) + a.a.a.a.eL(8, this.tzF)) + a.a.a.a.eL(9, this.tzG)) + a.a.a.a.eL(10, this.tzH)) + a.a.a.a.eL(11, this.tzI)) + a.a.a.a.eL(12, this.tzJ)) + a.a.a.a.eL(13, this.tzK)) + a.a.a.a.eL(14, this.tzL)) + a.a.a.a.eL(15, this.tzM);
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
                se seVar = (se) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        seVar.tzy = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        seVar.tzz = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        seVar.tzA = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        seVar.tzB = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        seVar.tzC = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        seVar.tzD = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        seVar.tzE = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        seVar.tzF = aVar3.xmD.mL();
                        return 0;
                    case 9:
                        seVar.tzG = aVar3.xmD.mL();
                        return 0;
                    case 10:
                        seVar.tzH = aVar3.xmD.mL();
                        return 0;
                    case 11:
                        seVar.tzI = aVar3.xmD.mL();
                        return 0;
                    case 12:
                        seVar.tzJ = aVar3.xmD.mL();
                        return 0;
                    case 13:
                        seVar.tzK = aVar3.xmD.mL();
                        return 0;
                    case 14:
                        seVar.tzL = aVar3.xmD.mL();
                        return 0;
                    case 15:
                        seVar.tzM = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
