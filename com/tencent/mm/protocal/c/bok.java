package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bok extends a {
    public String tGa;
    public int tdM;
    public String tmj;
    public String tuy;
    public String umH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umH == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.tGa == null) {
                throw new b("Not all required fields were included: Text");
            } else if (this.tuy == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.tmj == null) {
                throw new b("Not all required fields were included: ProductId");
            } else {
                if (this.umH != null) {
                    aVar.e(1, this.umH);
                }
                if (this.tGa != null) {
                    aVar.e(2, this.tGa);
                }
                if (this.tuy != null) {
                    aVar.e(3, this.tuy);
                }
                if (this.tmj != null) {
                    aVar.e(4, this.tmj);
                }
                aVar.eO(5, this.tdM);
                return 0;
            }
        } else if (i == 1) {
            if (this.umH != null) {
                r0 = a.a.a.b.b.a.f(1, this.umH) + 0;
            } else {
                r0 = 0;
            }
            if (this.tGa != null) {
                r0 += a.a.a.b.b.a.f(2, this.tGa);
            }
            if (this.tuy != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuy);
            }
            if (this.tmj != null) {
                r0 += a.a.a.b.b.a.f(4, this.tmj);
            }
            return r0 + a.a.a.a.eL(5, this.tdM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umH == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.tGa == null) {
                throw new b("Not all required fields were included: Text");
            } else if (this.tuy == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.tmj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ProductId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bok com_tencent_mm_protocal_c_bok = (bok) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bok.umH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bok.tGa = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bok.tuy = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bok.tmj = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bok.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
