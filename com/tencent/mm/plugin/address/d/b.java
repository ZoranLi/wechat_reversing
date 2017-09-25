package com.tencent.mm.plugin.address.d;

import com.tencent.mm.bd.a;

public final class b extends a {
    public int id;
    public String itr;
    public String its;
    public String itt;
    public String itu;
    public String itv;
    public String itw;
    public String itx;
    public String ity;
    public String itz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.id);
            if (this.itr != null) {
                aVar.e(2, this.itr);
            }
            if (this.its != null) {
                aVar.e(3, this.its);
            }
            if (this.itt != null) {
                aVar.e(4, this.itt);
            }
            if (this.itu != null) {
                aVar.e(5, this.itu);
            }
            if (this.itv != null) {
                aVar.e(6, this.itv);
            }
            if (this.itw != null) {
                aVar.e(7, this.itw);
            }
            if (this.itx != null) {
                aVar.e(8, this.itx);
            }
            if (this.ity != null) {
                aVar.e(9, this.ity);
            }
            if (this.itz != null) {
                aVar.e(10, this.itz);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.id) + 0;
            if (this.itr != null) {
                r0 += a.a.a.b.b.a.f(2, this.itr);
            }
            if (this.its != null) {
                r0 += a.a.a.b.b.a.f(3, this.its);
            }
            if (this.itt != null) {
                r0 += a.a.a.b.b.a.f(4, this.itt);
            }
            if (this.itu != null) {
                r0 += a.a.a.b.b.a.f(5, this.itu);
            }
            if (this.itv != null) {
                r0 += a.a.a.b.b.a.f(6, this.itv);
            }
            if (this.itw != null) {
                r0 += a.a.a.b.b.a.f(7, this.itw);
            }
            if (this.itx != null) {
                r0 += a.a.a.b.b.a.f(8, this.itx);
            }
            if (this.ity != null) {
                r0 += a.a.a.b.b.a.f(9, this.ity);
            }
            if (this.itz != null) {
                return r0 + a.a.a.b.b.a.f(10, this.itz);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.id = aVar3.xmD.mL();
                    return 0;
                case 2:
                    bVar.itr = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bVar.its = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bVar.itt = aVar3.xmD.readString();
                    return 0;
                case 5:
                    bVar.itu = aVar3.xmD.readString();
                    return 0;
                case 6:
                    bVar.itv = aVar3.xmD.readString();
                    return 0;
                case 7:
                    bVar.itw = aVar3.xmD.readString();
                    return 0;
                case 8:
                    bVar.itx = aVar3.xmD.readString();
                    return 0;
                case 9:
                    bVar.ity = aVar3.xmD.readString();
                    return 0;
                case 10:
                    bVar.itz = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
