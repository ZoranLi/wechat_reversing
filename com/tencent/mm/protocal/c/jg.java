package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public class jg extends a {
    public String kdH;
    public String khk;
    public String ofg;
    public String title;
    public String tnY;
    public String tnZ;
    public long tpl;
    public String tpm;
    public String tpn;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.kdH != null) {
                aVar.e(2, this.kdH);
            }
            if (this.khk != null) {
                aVar.e(3, this.khk);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.O(5, this.tpl);
            if (this.tpm != null) {
                aVar.e(6, this.tpm);
            }
            if (this.tpn != null) {
                aVar.e(7, this.tpn);
            }
            if (this.ofg != null) {
                aVar.e(8, this.ofg);
            }
            if (this.tnY != null) {
                aVar.e(9, this.tnY);
            }
            if (this.tnZ == null) {
                return 0;
            }
            aVar.e(10, this.tnZ);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.kdH != null) {
                r0 += a.a.a.b.b.a.f(2, this.kdH);
            }
            if (this.khk != null) {
                r0 += a.a.a.b.b.a.f(3, this.khk);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(4, this.url);
            }
            r0 += a.a.a.a.N(5, this.tpl);
            if (this.tpm != null) {
                r0 += a.a.a.b.b.a.f(6, this.tpm);
            }
            if (this.tpn != null) {
                r0 += a.a.a.b.b.a.f(7, this.tpn);
            }
            if (this.ofg != null) {
                r0 += a.a.a.b.b.a.f(8, this.ofg);
            }
            if (this.tnY != null) {
                r0 += a.a.a.b.b.a.f(9, this.tnY);
            }
            if (this.tnZ != null) {
                r0 += a.a.a.b.b.a.f(10, this.tnZ);
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
            jg jgVar = (jg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jgVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    jgVar.kdH = aVar3.xmD.readString();
                    return 0;
                case 3:
                    jgVar.khk = aVar3.xmD.readString();
                    return 0;
                case 4:
                    jgVar.url = aVar3.xmD.readString();
                    return 0;
                case 5:
                    jgVar.tpl = aVar3.xmD.mM();
                    return 0;
                case 6:
                    jgVar.tpm = aVar3.xmD.readString();
                    return 0;
                case 7:
                    jgVar.tpn = aVar3.xmD.readString();
                    return 0;
                case 8:
                    jgVar.ofg = aVar3.xmD.readString();
                    return 0;
                case 9:
                    jgVar.tnY = aVar3.xmD.readString();
                    return 0;
                case 10:
                    jgVar.tnZ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
