package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class z extends avh {
    public String SSID;
    public String URL;
    public String tcb;
    public String tcc;
    public String tcd;
    public int tce;
    public LinkedList<cj> tcf = new LinkedList();
    public int tcg;
    public String tch;
    public int tci;
    public String tcj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.URL != null) {
                aVar.e(2, this.URL);
            }
            if (this.SSID != null) {
                aVar.e(3, this.SSID);
            }
            if (this.tcb != null) {
                aVar.e(4, this.tcb);
            }
            if (this.tcc != null) {
                aVar.e(5, this.tcc);
            }
            if (this.tcd != null) {
                aVar.e(6, this.tcd);
            }
            aVar.eO(7, this.tce);
            aVar.d(8, 8, this.tcf);
            aVar.eO(9, this.tcg);
            if (this.tch != null) {
                aVar.e(10, this.tch);
            }
            aVar.eO(11, this.tci);
            if (this.tcj == null) {
                return 0;
            }
            aVar.e(12, this.tcj);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.URL != null) {
                r0 += a.a.a.b.b.a.f(2, this.URL);
            }
            if (this.SSID != null) {
                r0 += a.a.a.b.b.a.f(3, this.SSID);
            }
            if (this.tcb != null) {
                r0 += a.a.a.b.b.a.f(4, this.tcb);
            }
            if (this.tcc != null) {
                r0 += a.a.a.b.b.a.f(5, this.tcc);
            }
            if (this.tcd != null) {
                r0 += a.a.a.b.b.a.f(6, this.tcd);
            }
            r0 = ((r0 + a.a.a.a.eL(7, this.tce)) + a.a.a.a.c(8, 8, this.tcf)) + a.a.a.a.eL(9, this.tcg);
            if (this.tch != null) {
                r0 += a.a.a.b.b.a.f(10, this.tch);
            }
            r0 += a.a.a.a.eL(11, this.tci);
            if (this.tcj != null) {
                r0 += a.a.a.b.b.a.f(12, this.tcj);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tcf.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
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
                        zVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    zVar.URL = aVar3.xmD.readString();
                    return 0;
                case 3:
                    zVar.SSID = aVar3.xmD.readString();
                    return 0;
                case 4:
                    zVar.tcb = aVar3.xmD.readString();
                    return 0;
                case 5:
                    zVar.tcc = aVar3.xmD.readString();
                    return 0;
                case 6:
                    zVar.tcd = aVar3.xmD.readString();
                    return 0;
                case 7:
                    zVar.tce = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new cj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        zVar.tcf.add(emVar);
                    }
                    return 0;
                case 9:
                    zVar.tcg = aVar3.xmD.mL();
                    return 0;
                case 10:
                    zVar.tch = aVar3.xmD.readString();
                    return 0;
                case 11:
                    zVar.tci = aVar3.xmD.mL();
                    return 0;
                case 12:
                    zVar.tcj = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
