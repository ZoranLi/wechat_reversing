package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class tn extends avh {
    public String jNj;
    public int tBA;
    public String tBB;
    public int tBC;
    public int tBD;
    public int tBE;
    public avx tBr;
    public avx tBs;
    public avx tBt;
    public avx tBu;
    public String tBv;
    public int tBw;
    public String tBx;
    public avw tBy;
    public int tBz;
    public int tce;
    public int tdM;
    public int teT;
    public avw thn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tce);
            if (this.thn != null) {
                aVar.eQ(3, this.thn.aUk());
                this.thn.a(aVar);
            }
            if (this.tBr != null) {
                aVar.eQ(4, this.tBr.aUk());
                this.tBr.a(aVar);
            }
            if (this.tBs != null) {
                aVar.eQ(5, this.tBs.aUk());
                this.tBs.a(aVar);
            }
            if (this.tBt != null) {
                aVar.eQ(6, this.tBt.aUk());
                this.tBt.a(aVar);
            }
            if (this.tBu != null) {
                aVar.eQ(7, this.tBu.aUk());
                this.tBu.a(aVar);
            }
            if (this.tBv != null) {
                aVar.e(8, this.tBv);
            }
            aVar.eO(9, this.tBw);
            aVar.eO(10, this.tdM);
            if (this.jNj != null) {
                aVar.e(11, this.jNj);
            }
            if (this.tBx != null) {
                aVar.e(12, this.tBx);
            }
            if (this.tBy != null) {
                aVar.eQ(13, this.tBy.aUk());
                this.tBy.a(aVar);
            }
            aVar.eO(14, this.tBz);
            aVar.eO(15, this.tBA);
            aVar.eO(16, this.teT);
            if (this.tBB != null) {
                aVar.e(17, this.tBB);
            }
            aVar.eO(18, this.tBC);
            aVar.eO(19, this.tBD);
            aVar.eO(20, this.tBE);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tce);
            if (this.thn != null) {
                r0 += a.a.a.a.eN(3, this.thn.aUk());
            }
            if (this.tBr != null) {
                r0 += a.a.a.a.eN(4, this.tBr.aUk());
            }
            if (this.tBs != null) {
                r0 += a.a.a.a.eN(5, this.tBs.aUk());
            }
            if (this.tBt != null) {
                r0 += a.a.a.a.eN(6, this.tBt.aUk());
            }
            if (this.tBu != null) {
                r0 += a.a.a.a.eN(7, this.tBu.aUk());
            }
            if (this.tBv != null) {
                r0 += a.a.a.b.b.a.f(8, this.tBv);
            }
            r0 = (r0 + a.a.a.a.eL(9, this.tBw)) + a.a.a.a.eL(10, this.tdM);
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(11, this.jNj);
            }
            if (this.tBx != null) {
                r0 += a.a.a.b.b.a.f(12, this.tBx);
            }
            if (this.tBy != null) {
                r0 += a.a.a.a.eN(13, this.tBy.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(14, this.tBz)) + a.a.a.a.eL(15, this.tBA)) + a.a.a.a.eL(16, this.teT);
            if (this.tBB != null) {
                r0 += a.a.a.b.b.a.f(17, this.tBB);
            }
            return ((r0 + a.a.a.a.eL(18, this.tBC)) + a.a.a.a.eL(19, this.tBD)) + a.a.a.a.eL(20, this.tBE);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            tn tnVar = (tn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tnVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    tnVar.tce = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tnVar.thn = emVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tnVar.tBr = emVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tnVar.tBs = emVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tnVar.tBt = emVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tnVar.tBu = emVar;
                    }
                    return 0;
                case 8:
                    tnVar.tBv = aVar3.xmD.readString();
                    return 0;
                case 9:
                    tnVar.tBw = aVar3.xmD.mL();
                    return 0;
                case 10:
                    tnVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 11:
                    tnVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 12:
                    tnVar.tBx = aVar3.xmD.readString();
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        tnVar.tBy = emVar;
                    }
                    return 0;
                case 14:
                    tnVar.tBz = aVar3.xmD.mL();
                    return 0;
                case 15:
                    tnVar.tBA = aVar3.xmD.mL();
                    return 0;
                case 16:
                    tnVar.teT = aVar3.xmD.mL();
                    return 0;
                case 17:
                    tnVar.tBB = aVar3.xmD.readString();
                    return 0;
                case 18:
                    tnVar.tBC = aVar3.xmD.mL();
                    return 0;
                case 19:
                    tnVar.tBD = aVar3.xmD.mL();
                    return 0;
                case 20:
                    tnVar.tBE = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
