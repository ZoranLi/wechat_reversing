package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aw extends a {
    public String msT;
    public String msh;
    public String muS;
    public String tec;
    public String ted;
    public String tee;
    public String tef;
    public String teg;
    public String teh;
    public bqx tei;
    public String tej;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msh != null) {
                aVar.e(1, this.msh);
            }
            if (this.tec != null) {
                aVar.e(2, this.tec);
            }
            if (this.ted != null) {
                aVar.e(3, this.ted);
            }
            if (this.msT != null) {
                aVar.e(4, this.msT);
            }
            if (this.muS != null) {
                aVar.e(5, this.muS);
            }
            if (this.tee != null) {
                aVar.e(6, this.tee);
            }
            if (this.tef != null) {
                aVar.e(7, this.tef);
            }
            if (this.teg != null) {
                aVar.e(8, this.teg);
            }
            if (this.teh != null) {
                aVar.e(9, this.teh);
            }
            if (this.tei != null) {
                aVar.eQ(10, this.tei.aUk());
                this.tei.a(aVar);
            }
            if (this.tej == null) {
                return 0;
            }
            aVar.e(11, this.tej);
            return 0;
        } else if (i == 1) {
            if (this.msh != null) {
                r0 = a.a.a.b.b.a.f(1, this.msh) + 0;
            } else {
                r0 = 0;
            }
            if (this.tec != null) {
                r0 += a.a.a.b.b.a.f(2, this.tec);
            }
            if (this.ted != null) {
                r0 += a.a.a.b.b.a.f(3, this.ted);
            }
            if (this.msT != null) {
                r0 += a.a.a.b.b.a.f(4, this.msT);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(5, this.muS);
            }
            if (this.tee != null) {
                r0 += a.a.a.b.b.a.f(6, this.tee);
            }
            if (this.tef != null) {
                r0 += a.a.a.b.b.a.f(7, this.tef);
            }
            if (this.teg != null) {
                r0 += a.a.a.b.b.a.f(8, this.teg);
            }
            if (this.teh != null) {
                r0 += a.a.a.b.b.a.f(9, this.teh);
            }
            if (this.tei != null) {
                r0 += a.a.a.a.eN(10, this.tei.aUk());
            }
            if (this.tej != null) {
                r0 += a.a.a.b.b.a.f(11, this.tej);
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
            aw awVar = (aw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awVar.msh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    awVar.tec = aVar3.xmD.readString();
                    return 0;
                case 3:
                    awVar.ted = aVar3.xmD.readString();
                    return 0;
                case 4:
                    awVar.msT = aVar3.xmD.readString();
                    return 0;
                case 5:
                    awVar.muS = aVar3.xmD.readString();
                    return 0;
                case 6:
                    awVar.tee = aVar3.xmD.readString();
                    return 0;
                case 7:
                    awVar.tef = aVar3.xmD.readString();
                    return 0;
                case 8:
                    awVar.teg = aVar3.xmD.readString();
                    return 0;
                case 9:
                    awVar.teh = aVar3.xmD.readString();
                    return 0;
                case 10:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bqx = new bqx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bqx.a(aVar4, com_tencent_mm_protocal_c_bqx, a.a(aVar4))) {
                        }
                        awVar.tei = com_tencent_mm_protocal_c_bqx;
                    }
                    return 0;
                case 11:
                    awVar.tej = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
