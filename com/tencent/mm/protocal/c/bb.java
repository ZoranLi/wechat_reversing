package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bb extends a {
    public long endTime;
    public int pOT;
    public int pOU;
    public long startTime;
    public float ter;
    public float tes;
    public float tet;
    public long teu;
    public long tev;
    public long tew;
    public long tex;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.pOT);
            aVar.eO(2, this.pOU);
            aVar.n(3, this.ter);
            aVar.n(4, this.tes);
            aVar.n(5, this.tet);
            aVar.O(6, this.startTime);
            aVar.O(7, this.endTime);
            aVar.O(8, this.teu);
            aVar.O(9, this.tev);
            aVar.O(10, this.tew);
            aVar.O(11, this.tex);
            return 0;
        } else if (i == 1) {
            return ((((((((((a.a.a.a.eL(1, this.pOT) + 0) + a.a.a.a.eL(2, this.pOU)) + (a.a.a.b.b.a.cH(3) + 4)) + (a.a.a.b.b.a.cH(4) + 4)) + (a.a.a.b.b.a.cH(5) + 4)) + a.a.a.a.N(6, this.startTime)) + a.a.a.a.N(7, this.endTime)) + a.a.a.a.N(8, this.teu)) + a.a.a.a.N(9, this.tev)) + a.a.a.a.N(10, this.tew)) + a.a.a.a.N(11, this.tex);
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
                bb bbVar = (bb) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bbVar.pOT = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        bbVar.pOU = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        bbVar.ter = aVar3.xmD.readFloat();
                        return 0;
                    case 4:
                        bbVar.tes = aVar3.xmD.readFloat();
                        return 0;
                    case 5:
                        bbVar.tet = aVar3.xmD.readFloat();
                        return 0;
                    case 6:
                        bbVar.startTime = aVar3.xmD.mM();
                        return 0;
                    case 7:
                        bbVar.endTime = aVar3.xmD.mM();
                        return 0;
                    case 8:
                        bbVar.teu = aVar3.xmD.mM();
                        return 0;
                    case 9:
                        bbVar.tev = aVar3.xmD.mM();
                        return 0;
                    case 10:
                        bbVar.tew = aVar3.xmD.mM();
                        return 0;
                    case 11:
                        bbVar.tex = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
