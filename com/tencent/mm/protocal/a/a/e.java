package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class e extends a {
    public int nettype;
    public String taA;
    public String taB;
    public String taC;
    public int taD;
    public int tao;
    public LinkedList<d> tap = new LinkedList();
    public String tay;
    public String taz;
    public int uin;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uin);
            aVar.eO(2, this.tao);
            aVar.eO(3, this.nettype);
            aVar.d(4, 8, this.tap);
            if (this.tay != null) {
                aVar.e(5, this.tay);
            }
            if (this.taz != null) {
                aVar.e(6, this.taz);
            }
            if (this.taA != null) {
                aVar.e(7, this.taA);
            }
            if (this.taB != null) {
                aVar.e(8, this.taB);
            }
            if (this.taC != null) {
                aVar.e(9, this.taC);
            }
            aVar.eO(10, this.taD);
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.eL(1, this.uin) + 0) + a.a.a.a.eL(2, this.tao)) + a.a.a.a.eL(3, this.nettype)) + a.a.a.a.c(4, 8, this.tap);
            if (this.tay != null) {
                r0 += a.a.a.b.b.a.f(5, this.tay);
            }
            if (this.taz != null) {
                r0 += a.a.a.b.b.a.f(6, this.taz);
            }
            if (this.taA != null) {
                r0 += a.a.a.b.b.a.f(7, this.taA);
            }
            if (this.taB != null) {
                r0 += a.a.a.b.b.a.f(8, this.taB);
            }
            if (this.taC != null) {
                r0 += a.a.a.b.b.a.f(9, this.taC);
            }
            return r0 + a.a.a.a.eL(10, this.taD);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tap.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.uin = aVar3.xmD.mL();
                    return 0;
                case 2:
                    eVar.tao = aVar3.xmD.mL();
                    return 0;
                case 3:
                    eVar.nettype = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a dVar = new d();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        eVar.tap.add(dVar);
                    }
                    return 0;
                case 5:
                    eVar.tay = aVar3.xmD.readString();
                    return 0;
                case 6:
                    eVar.taz = aVar3.xmD.readString();
                    return 0;
                case 7:
                    eVar.taA = aVar3.xmD.readString();
                    return 0;
                case 8:
                    eVar.taB = aVar3.xmD.readString();
                    return 0;
                case 9:
                    eVar.taC = aVar3.xmD.readString();
                    return 0;
                case 10:
                    eVar.taD = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
