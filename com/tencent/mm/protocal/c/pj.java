package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class pj extends a {
    public int jOb;
    public String muU;
    public String tgW;
    public String tuV;
    public String tuW;
    public String tuX;
    public String tuY;
    public int tuZ;
    public int tva;
    public int tvb;
    public LinkedList<avx> tvc = new LinkedList();
    public String tvd;
    public int tve;
    public String tvf;
    public String tvg;
    public String tvh;
    public String tvi;
    public String tvj;
    public int tvk;
    public LinkedList<apa> tvl = new LinkedList();
    public String tvm;
    public String tvn;
    public String tvo;
    public pi tvp;
    public aqj tvq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgW != null) {
                aVar.e(1, this.tgW);
            }
            if (this.muU != null) {
                aVar.e(2, this.muU);
            }
            if (this.tuV != null) {
                aVar.e(3, this.tuV);
            }
            if (this.tuW != null) {
                aVar.e(4, this.tuW);
            }
            if (this.tuX != null) {
                aVar.e(5, this.tuX);
            }
            if (this.tuY != null) {
                aVar.e(6, this.tuY);
            }
            aVar.eO(7, this.tuZ);
            aVar.eO(8, this.tva);
            aVar.eO(9, this.tvb);
            aVar.d(10, 8, this.tvc);
            if (this.tvd != null) {
                aVar.e(11, this.tvd);
            }
            aVar.eO(12, this.tve);
            if (this.tvf != null) {
                aVar.e(13, this.tvf);
            }
            if (this.tvg != null) {
                aVar.e(14, this.tvg);
            }
            if (this.tvh != null) {
                aVar.e(15, this.tvh);
            }
            if (this.tvi != null) {
                aVar.e(16, this.tvi);
            }
            if (this.tvj != null) {
                aVar.e(17, this.tvj);
            }
            aVar.eO(18, this.tvk);
            aVar.d(19, 8, this.tvl);
            aVar.eO(20, this.jOb);
            if (this.tvm != null) {
                aVar.e(21, this.tvm);
            }
            if (this.tvn != null) {
                aVar.e(22, this.tvn);
            }
            if (this.tvo != null) {
                aVar.e(23, this.tvo);
            }
            if (this.tvp != null) {
                aVar.eQ(24, this.tvp.aUk());
                this.tvp.a(aVar);
            }
            if (this.tvq == null) {
                return 0;
            }
            aVar.eQ(25, this.tvq.aUk());
            this.tvq.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tgW != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgW) + 0;
            } else {
                r0 = 0;
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(2, this.muU);
            }
            if (this.tuV != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuV);
            }
            if (this.tuW != null) {
                r0 += a.a.a.b.b.a.f(4, this.tuW);
            }
            if (this.tuX != null) {
                r0 += a.a.a.b.b.a.f(5, this.tuX);
            }
            if (this.tuY != null) {
                r0 += a.a.a.b.b.a.f(6, this.tuY);
            }
            r0 = (((r0 + a.a.a.a.eL(7, this.tuZ)) + a.a.a.a.eL(8, this.tva)) + a.a.a.a.eL(9, this.tvb)) + a.a.a.a.c(10, 8, this.tvc);
            if (this.tvd != null) {
                r0 += a.a.a.b.b.a.f(11, this.tvd);
            }
            r0 += a.a.a.a.eL(12, this.tve);
            if (this.tvf != null) {
                r0 += a.a.a.b.b.a.f(13, this.tvf);
            }
            if (this.tvg != null) {
                r0 += a.a.a.b.b.a.f(14, this.tvg);
            }
            if (this.tvh != null) {
                r0 += a.a.a.b.b.a.f(15, this.tvh);
            }
            if (this.tvi != null) {
                r0 += a.a.a.b.b.a.f(16, this.tvi);
            }
            if (this.tvj != null) {
                r0 += a.a.a.b.b.a.f(17, this.tvj);
            }
            r0 = ((r0 + a.a.a.a.eL(18, this.tvk)) + a.a.a.a.c(19, 8, this.tvl)) + a.a.a.a.eL(20, this.jOb);
            if (this.tvm != null) {
                r0 += a.a.a.b.b.a.f(21, this.tvm);
            }
            if (this.tvn != null) {
                r0 += a.a.a.b.b.a.f(22, this.tvn);
            }
            if (this.tvo != null) {
                r0 += a.a.a.b.b.a.f(23, this.tvo);
            }
            if (this.tvp != null) {
                r0 += a.a.a.a.eN(24, this.tvp.aUk());
            }
            if (this.tvq != null) {
                r0 += a.a.a.a.eN(25, this.tvq.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tvc.clear();
            this.tvl.clear();
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
            pj pjVar = (pj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    pjVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 2:
                    pjVar.muU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    pjVar.tuV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    pjVar.tuW = aVar3.xmD.readString();
                    return 0;
                case 5:
                    pjVar.tuX = aVar3.xmD.readString();
                    return 0;
                case 6:
                    pjVar.tuY = aVar3.xmD.readString();
                    return 0;
                case 7:
                    pjVar.tuZ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    pjVar.tva = aVar3.xmD.mL();
                    return 0;
                case 9:
                    pjVar.tvb = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        pjVar.tvc.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 11:
                    pjVar.tvd = aVar3.xmD.readString();
                    return 0;
                case 12:
                    pjVar.tve = aVar3.xmD.mL();
                    return 0;
                case 13:
                    pjVar.tvf = aVar3.xmD.readString();
                    return 0;
                case 14:
                    pjVar.tvg = aVar3.xmD.readString();
                    return 0;
                case 15:
                    pjVar.tvh = aVar3.xmD.readString();
                    return 0;
                case 16:
                    pjVar.tvi = aVar3.xmD.readString();
                    return 0;
                case 17:
                    pjVar.tvj = aVar3.xmD.readString();
                    return 0;
                case 18:
                    pjVar.tvk = aVar3.xmD.mL();
                    return 0;
                case 19:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new apa();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        pjVar.tvl.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 20:
                    pjVar.jOb = aVar3.xmD.mL();
                    return 0;
                case 21:
                    pjVar.tvm = aVar3.xmD.readString();
                    return 0;
                case 22:
                    pjVar.tvn = aVar3.xmD.readString();
                    return 0;
                case 23:
                    pjVar.tvo = aVar3.xmD.readString();
                    return 0;
                case 24:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new pi();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        pjVar.tvp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 25:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new aqj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        pjVar.tvq = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
