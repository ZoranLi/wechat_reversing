package com.tencent.mm.bi;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;

public final class c extends a {
    public int hrt;
    public int size;
    public int uyp;
    public int uyq;
    public int uyr;
    public int uys = -1;
    public int uyt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uyp);
            aVar.eO(2, this.uyq);
            aVar.eO(3, this.uyr);
            aVar.eO(41, this.uys);
            aVar.eO(5, this.uyt);
            aVar.eO(6, this.hrt);
            aVar.eO(7, this.size);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.eL(1, this.uyp) + 0) + a.a.a.a.eL(2, this.uyq)) + a.a.a.a.eL(3, this.uyr)) + a.a.a.a.eL(41, this.uys)) + a.a.a.a.eL(5, this.uyt)) + a.a.a.a.eL(6, this.hrt)) + a.a.a.a.eL(7, this.size);
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
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.uyp = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        cVar.uyq = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        cVar.uyr = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        cVar.uyt = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        cVar.hrt = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        cVar.size = aVar3.xmD.mL();
                        return 0;
                    case v.CTRL_BYTE /*41*/:
                        cVar.uys = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
