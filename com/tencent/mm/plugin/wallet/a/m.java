package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bd.a;

public final class m extends a {
    public String desc;
    public String id;
    public String name;
    public String ryh;
    public String ryi;
    public String ryj = "0";
    public String ryk = "0";
    public int status;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.eO(4, this.status);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.eO(6, this.type);
            if (this.ryh != null) {
                aVar.e(7, this.ryh);
            }
            if (this.ryi != null) {
                aVar.e(8, this.ryi);
            }
            if (this.ryj != null) {
                aVar.e(9, this.ryj);
            }
            if (this.ryk == null) {
                return 0;
            }
            aVar.e(10, this.ryk);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                r0 = a.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(3, this.desc);
            }
            r0 += a.a.a.a.eL(4, this.status);
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(5, this.url);
            }
            r0 += a.a.a.a.eL(6, this.type);
            if (this.ryh != null) {
                r0 += a.a.a.b.b.a.f(7, this.ryh);
            }
            if (this.ryi != null) {
                r0 += a.a.a.b.b.a.f(8, this.ryi);
            }
            if (this.ryj != null) {
                r0 += a.a.a.b.b.a.f(9, this.ryj);
            }
            if (this.ryk != null) {
                r0 += a.a.a.b.b.a.f(10, this.ryk);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.id = aVar3.xmD.readString();
                    return 0;
                case 2:
                    mVar.name = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mVar.desc = aVar3.xmD.readString();
                    return 0;
                case 4:
                    mVar.status = aVar3.xmD.mL();
                    return 0;
                case 5:
                    mVar.url = aVar3.xmD.readString();
                    return 0;
                case 6:
                    mVar.type = aVar3.xmD.mL();
                    return 0;
                case 7:
                    mVar.ryh = aVar3.xmD.readString();
                    return 0;
                case 8:
                    mVar.ryi = aVar3.xmD.readString();
                    return 0;
                case 9:
                    mVar.ryj = aVar3.xmD.readString();
                    return 0;
                case 10:
                    mVar.ryk = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
