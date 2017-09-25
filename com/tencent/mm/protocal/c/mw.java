package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class mw extends avh {
    public int jNd;
    public String msj;
    public String tth;
    public String tti;
    public aiy ttj;
    public LinkedList<avx> ttk = new LinkedList();
    public String ttl;
    public String ttm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ttj == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.msj != null) {
                aVar.e(2, this.msj);
            }
            if (this.tth != null) {
                aVar.e(3, this.tth);
            }
            if (this.tti != null) {
                aVar.e(4, this.tti);
            }
            if (this.ttj != null) {
                aVar.eQ(5, this.ttj.aUk());
                this.ttj.a(aVar);
            }
            aVar.eO(6, this.jNd);
            aVar.d(7, 8, this.ttk);
            if (this.ttl != null) {
                aVar.e(8, this.ttl);
            }
            if (this.ttm == null) {
                return 0;
            }
            aVar.e(9, this.ttm);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(2, this.msj);
            }
            if (this.tth != null) {
                r0 += a.a.a.b.b.a.f(3, this.tth);
            }
            if (this.tti != null) {
                r0 += a.a.a.b.b.a.f(4, this.tti);
            }
            if (this.ttj != null) {
                r0 += a.a.a.a.eN(5, this.ttj.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(6, this.jNd)) + a.a.a.a.c(7, 8, this.ttk);
            if (this.ttl != null) {
                r0 += a.a.a.b.b.a.f(8, this.ttl);
            }
            if (this.ttm != null) {
                r0 += a.a.a.b.b.a.f(9, this.ttm);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ttk.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            mw mwVar = (mw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        mwVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    mwVar.msj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mwVar.tth = aVar3.xmD.readString();
                    return 0;
                case 4:
                    mwVar.tti = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new aiy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        mwVar.ttj = emVar;
                    }
                    return 0;
                case 6:
                    mwVar.jNd = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        mwVar.ttk.add(emVar);
                    }
                    return 0;
                case 8:
                    mwVar.ttl = aVar3.xmD.readString();
                    return 0;
                case 9:
                    mwVar.ttm = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
