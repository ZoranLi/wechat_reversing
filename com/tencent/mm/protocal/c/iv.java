package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class iv extends a {
    public int bHh;
    public int poY;
    public String text;
    public String tnW;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.type);
            if (this.text != null) {
                aVar.e(2, this.text);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.eO(4, this.poY);
            aVar.eO(5, this.bHh);
            if (this.tnW != null) {
                aVar.e(6, this.tnW);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.type) + 0;
            if (this.text != null) {
                r0 += a.a.a.b.b.a.f(2, this.text);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(3, this.url);
            }
            r0 = (r0 + a.a.a.a.eL(4, this.poY)) + a.a.a.a.eL(5, this.bHh);
            if (this.tnW != null) {
                return r0 + a.a.a.b.b.a.f(6, this.tnW);
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
            iv ivVar = (iv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ivVar.type = aVar3.xmD.mL();
                    return 0;
                case 2:
                    ivVar.text = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ivVar.url = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ivVar.poY = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ivVar.bHh = aVar3.xmD.mL();
                    return 0;
                case 6:
                    ivVar.tnW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
