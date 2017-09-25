package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class pd extends a {
    public int Height;
    public int Width;
    public String mQT;
    public String tuL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mQT != null) {
                aVar.e(1, this.mQT);
            }
            aVar.eO(2, this.Width);
            aVar.eO(3, this.Height);
            if (this.tuL == null) {
                return 0;
            }
            aVar.e(4, this.tuL);
            return 0;
        } else if (i == 1) {
            if (this.mQT != null) {
                r0 = a.a.a.b.b.a.f(1, this.mQT) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.Width)) + a.a.a.a.eL(3, this.Height);
            if (this.tuL != null) {
                r0 += a.a.a.b.b.a.f(4, this.tuL);
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
            pd pdVar = (pd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pdVar.mQT = aVar3.xmD.readString();
                    return 0;
                case 2:
                    pdVar.Width = aVar3.xmD.mL();
                    return 0;
                case 3:
                    pdVar.Height = aVar3.xmD.mL();
                    return 0;
                case 4:
                    pdVar.tuL = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
