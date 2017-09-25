package com.tencent.mm.protocal.a.a;

public final class a extends com.tencent.mm.bd.a {
    public int count;
    public int tan;
    public int value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tan);
            aVar.eO(2, this.value);
            aVar.eO(3, this.count);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.tan) + 0) + a.a.a.a.eL(2, this.value)) + a.a.a.a.eL(3, this.count);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = com.tencent.mm.bd.a.a(aVar2); a > 0; a = com.tencent.mm.bd.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aVar4.tan = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        aVar4.value = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        aVar4.count = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
