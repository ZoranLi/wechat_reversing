package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bd.a;

public final class h extends a {
    public String njw;
    public int nmA;
    public String nmJ;
    public long nmK;
    public String nmL;
    public String nmM;
    public String nmN;
    public long nmO;
    public int nmP;
    public int nme;
    public String nmj;
    public long nmm;
    public long nmo;
    public String nmp;
    public int status;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.nmJ != null) {
                aVar.e(1, this.nmJ);
            }
            if (this.nmj != null) {
                aVar.e(2, this.nmj);
            }
            aVar.O(3, this.nmK);
            if (this.nmL != null) {
                aVar.e(4, this.nmL);
            }
            aVar.eO(5, this.nme);
            if (this.nmM != null) {
                aVar.e(6, this.nmM);
            }
            if (this.nmN != null) {
                aVar.e(7, this.nmN);
            }
            aVar.O(8, this.nmo);
            aVar.O(9, this.nmO);
            aVar.O(10, this.nmm);
            aVar.eO(11, this.status);
            aVar.eO(12, this.nmP);
            if (this.nmp != null) {
                aVar.e(13, this.nmp);
            }
            if (this.njw != null) {
                aVar.e(14, this.njw);
            }
            aVar.eO(15, this.nmA);
            return 0;
        } else if (i == 1) {
            if (this.nmJ != null) {
                r0 = a.a.a.b.b.a.f(1, this.nmJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.nmj != null) {
                r0 += a.a.a.b.b.a.f(2, this.nmj);
            }
            r0 += a.a.a.a.N(3, this.nmK);
            if (this.nmL != null) {
                r0 += a.a.a.b.b.a.f(4, this.nmL);
            }
            r0 += a.a.a.a.eL(5, this.nme);
            if (this.nmM != null) {
                r0 += a.a.a.b.b.a.f(6, this.nmM);
            }
            if (this.nmN != null) {
                r0 += a.a.a.b.b.a.f(7, this.nmN);
            }
            r0 = ((((r0 + a.a.a.a.N(8, this.nmo)) + a.a.a.a.N(9, this.nmO)) + a.a.a.a.N(10, this.nmm)) + a.a.a.a.eL(11, this.status)) + a.a.a.a.eL(12, this.nmP);
            if (this.nmp != null) {
                r0 += a.a.a.b.b.a.f(13, this.nmp);
            }
            if (this.njw != null) {
                r0 += a.a.a.b.b.a.f(14, this.njw);
            }
            return r0 + a.a.a.a.eL(15, this.nmA);
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
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.nmJ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    hVar.nmj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    hVar.nmK = aVar3.xmD.mM();
                    return 0;
                case 4:
                    hVar.nmL = aVar3.xmD.readString();
                    return 0;
                case 5:
                    hVar.nme = aVar3.xmD.mL();
                    return 0;
                case 6:
                    hVar.nmM = aVar3.xmD.readString();
                    return 0;
                case 7:
                    hVar.nmN = aVar3.xmD.readString();
                    return 0;
                case 8:
                    hVar.nmo = aVar3.xmD.mM();
                    return 0;
                case 9:
                    hVar.nmO = aVar3.xmD.mM();
                    return 0;
                case 10:
                    hVar.nmm = aVar3.xmD.mM();
                    return 0;
                case 11:
                    hVar.status = aVar3.xmD.mL();
                    return 0;
                case 12:
                    hVar.nmP = aVar3.xmD.mL();
                    return 0;
                case 13:
                    hVar.nmp = aVar3.xmD.readString();
                    return 0;
                case 14:
                    hVar.njw = aVar3.xmD.readString();
                    return 0;
                case 15:
                    hVar.nmA = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
