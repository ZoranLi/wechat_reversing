package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class jk extends avp {
    public String rDD;
    public LinkedList<alp> tpp = new LinkedList();
    public alp tpq;
    public String tpr;
    public boolean tps;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.tpq == null) {
                throw new b("Not all required fields were included: bottom_item");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.url != null) {
                    aVar.e(2, this.url);
                }
                aVar.d(3, 8, this.tpp);
                if (this.tpq != null) {
                    aVar.eQ(4, this.tpq.aUk());
                    this.tpq.a(aVar);
                }
                if (this.rDD != null) {
                    aVar.e(5, this.rDD);
                }
                if (this.tpr != null) {
                    aVar.e(6, this.tpr);
                }
                aVar.an(7, this.tps);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            r0 += a.a.a.a.c(3, 8, this.tpp);
            if (this.tpq != null) {
                r0 += a.a.a.a.eN(4, this.tpq.aUk());
            }
            if (this.rDD != null) {
                r0 += a.a.a.b.b.a.f(5, this.rDD);
            }
            if (this.tpr != null) {
                r0 += a.a.a.b.b.a.f(6, this.tpr);
            }
            return r0 + (a.a.a.b.b.a.cH(7) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tpp.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.tpq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bottom_item");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            jk jkVar = (jk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        jkVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    jkVar.url = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new alp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        jkVar.tpp.add(enVar);
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new alp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        jkVar.tpq = enVar;
                    }
                    return 0;
                case 5:
                    jkVar.rDD = aVar3.xmD.readString();
                    return 0;
                case 6:
                    jkVar.tpr = aVar3.xmD.readString();
                    return 0;
                case 7:
                    jkVar.tps = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
