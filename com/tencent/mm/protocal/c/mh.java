package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class mh extends a {
    public int hAD;
    public String hAI;
    public String jNj;
    public String jOp;
    public String mvZ;
    public avw tfh;
    public int tsA;
    public String tsB;
    public String tsC;
    public int tsD;
    public int tsE;
    public LinkedList<avv> tsF = new LinkedList();
    public String tsG;
    public int tsH;
    public int tsI;
    public int tsJ;
    public int tsK;
    public String tsv;
    public String tsw;
    public int tsx;
    public int tsy;
    public String tsz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            }
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            if (this.jOp != null) {
                aVar.e(2, this.jOp);
            }
            if (this.tsv != null) {
                aVar.e(3, this.tsv);
            }
            if (this.tsw != null) {
                aVar.e(4, this.tsw);
            }
            aVar.eO(5, this.hAD);
            if (this.tfh != null) {
                aVar.eQ(6, this.tfh.aUk());
                this.tfh.a(aVar);
            }
            aVar.eO(7, this.tsx);
            aVar.eO(8, this.tsy);
            if (this.tsz != null) {
                aVar.e(9, this.tsz);
            }
            aVar.eO(10, this.tsA);
            if (this.tsB != null) {
                aVar.e(11, this.tsB);
            }
            if (this.tsC != null) {
                aVar.e(12, this.tsC);
            }
            aVar.eO(13, this.tsD);
            aVar.eO(14, this.tsE);
            aVar.d(15, 8, this.tsF);
            if (this.tsG != null) {
                aVar.e(16, this.tsG);
            }
            aVar.eO(17, this.tsH);
            aVar.eO(18, this.tsI);
            if (this.mvZ != null) {
                aVar.e(19, this.mvZ);
            }
            aVar.eO(20, this.tsJ);
            aVar.eO(21, this.tsK);
            if (this.hAI == null) {
                return 0;
            }
            aVar.e(22, this.hAI);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            if (this.tsv != null) {
                r0 += a.a.a.b.b.a.f(3, this.tsv);
            }
            if (this.tsw != null) {
                r0 += a.a.a.b.b.a.f(4, this.tsw);
            }
            r0 += a.a.a.a.eL(5, this.hAD);
            if (this.tfh != null) {
                r0 += a.a.a.a.eN(6, this.tfh.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(7, this.tsx)) + a.a.a.a.eL(8, this.tsy);
            if (this.tsz != null) {
                r0 += a.a.a.b.b.a.f(9, this.tsz);
            }
            r0 += a.a.a.a.eL(10, this.tsA);
            if (this.tsB != null) {
                r0 += a.a.a.b.b.a.f(11, this.tsB);
            }
            if (this.tsC != null) {
                r0 += a.a.a.b.b.a.f(12, this.tsC);
            }
            r0 = ((r0 + a.a.a.a.eL(13, this.tsD)) + a.a.a.a.eL(14, this.tsE)) + a.a.a.a.c(15, 8, this.tsF);
            if (this.tsG != null) {
                r0 += a.a.a.b.b.a.f(16, this.tsG);
            }
            r0 = (r0 + a.a.a.a.eL(17, this.tsH)) + a.a.a.a.eL(18, this.tsI);
            if (this.mvZ != null) {
                r0 += a.a.a.b.b.a.f(19, this.mvZ);
            }
            r0 = (r0 + a.a.a.a.eL(20, this.tsJ)) + a.a.a.a.eL(21, this.tsK);
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(22, this.hAI);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tsF.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfh != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuf");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            mh mhVar = (mh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    mhVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    mhVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mhVar.tsv = aVar3.xmD.readString();
                    return 0;
                case 4:
                    mhVar.tsw = aVar3.xmD.readString();
                    return 0;
                case 5:
                    mhVar.hAD = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        mhVar.tfh = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 7:
                    mhVar.tsx = aVar3.xmD.mL();
                    return 0;
                case 8:
                    mhVar.tsy = aVar3.xmD.mL();
                    return 0;
                case 9:
                    mhVar.tsz = aVar3.xmD.readString();
                    return 0;
                case 10:
                    mhVar.tsA = aVar3.xmD.mL();
                    return 0;
                case 11:
                    mhVar.tsB = aVar3.xmD.readString();
                    return 0;
                case 12:
                    mhVar.tsC = aVar3.xmD.readString();
                    return 0;
                case 13:
                    mhVar.tsD = aVar3.xmD.mL();
                    return 0;
                case 14:
                    mhVar.tsE = aVar3.xmD.mL();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        mhVar.tsF.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 16:
                    mhVar.tsG = aVar3.xmD.readString();
                    return 0;
                case 17:
                    mhVar.tsH = aVar3.xmD.mL();
                    return 0;
                case 18:
                    mhVar.tsI = aVar3.xmD.mL();
                    return 0;
                case 19:
                    mhVar.mvZ = aVar3.xmD.readString();
                    return 0;
                case 20:
                    mhVar.tsJ = aVar3.xmD.mL();
                    return 0;
                case 21:
                    mhVar.tsK = aVar3.xmD.mL();
                    return 0;
                case 22:
                    mhVar.hAI = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
