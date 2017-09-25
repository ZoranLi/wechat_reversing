package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bld extends avh {
    public int tVX;
    public String tWt;
    public int trD;
    public int tvL;
    public long tvM;
    public int ued;
    public blj ujn;
    public blj ujo;
    public long ujr;
    public int ukj;
    public int uku;
    public LinkedList<avx> ukv = new LinkedList();
    public int ukw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ujn == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.ujo == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tWt != null) {
                    aVar.e(2, this.tWt);
                }
                aVar.eO(3, this.uku);
                aVar.d(4, 8, this.ukv);
                if (this.ujn != null) {
                    aVar.eQ(6, this.ujn.aUk());
                    this.ujn.a(aVar);
                }
                if (this.ujo != null) {
                    aVar.eQ(7, this.ujo.aUk());
                    this.ujo.a(aVar);
                }
                aVar.eO(8, this.trD);
                aVar.eO(9, this.ued);
                aVar.eO(10, this.tvL);
                aVar.O(11, this.tvM);
                aVar.eO(12, this.ukj);
                aVar.O(13, this.ujr);
                aVar.eO(14, this.ukw);
                aVar.eO(15, this.tVX);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tWt != null) {
                r0 += a.a.a.b.b.a.f(2, this.tWt);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.uku)) + a.a.a.a.c(4, 8, this.ukv);
            if (this.ujn != null) {
                r0 += a.a.a.a.eN(6, this.ujn.aUk());
            }
            if (this.ujo != null) {
                r0 += a.a.a.a.eN(7, this.ujo.aUk());
            }
            return (((((((r0 + a.a.a.a.eL(8, this.trD)) + a.a.a.a.eL(9, this.ued)) + a.a.a.a.eL(10, this.tvL)) + a.a.a.a.N(11, this.tvM)) + a.a.a.a.eL(12, this.ukj)) + a.a.a.a.N(13, this.ujr)) + a.a.a.a.eL(14, this.ukw)) + a.a.a.a.eL(15, this.tVX);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ukv.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ujn == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.ujo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bld com_tencent_mm_protocal_c_bld = (bld) objArr[1];
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
                        com_tencent_mm_protocal_c_bld.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bld.tWt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bld.uku = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bld.ukv.add(emVar);
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new blj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bld.ujn = emVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new blj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bld.ujo = emVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bld.trD = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bld.ued = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bld.tvL = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bld.tvM = aVar3.xmD.mM();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bld.ukj = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bld.ujr = aVar3.xmD.mM();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bld.ukw = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bld.tVX = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
