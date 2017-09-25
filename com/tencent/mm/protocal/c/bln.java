package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bln extends avh {
    public LinkedList<bda> tEZ = new LinkedList();
    public double tld;
    public double tle;
    public int trD;
    public int tvL;
    public long tvM;
    public long ulr;
    public avx uls;
    public avx ult;
    public int ulu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.uls == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.ult == null) {
                throw new b("Not all required fields were included: WifiName");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                aVar.O(2, this.ulr);
                aVar.O(3, this.tvM);
                aVar.eO(4, this.trD);
                if (this.uls != null) {
                    aVar.eQ(5, this.uls.aUk());
                    this.uls.a(aVar);
                }
                if (this.ult != null) {
                    aVar.eQ(6, this.ult.aUk());
                    this.ult.a(aVar);
                }
                aVar.a(7, this.tld);
                aVar.a(8, this.tle);
                aVar.eO(9, this.tvL);
                aVar.eO(10, this.ulu);
                aVar.d(11, 8, this.tEZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.N(2, this.ulr)) + a.a.a.a.N(3, this.tvM)) + a.a.a.a.eL(4, this.trD);
            if (this.uls != null) {
                r0 += a.a.a.a.eN(5, this.uls.aUk());
            }
            if (this.ult != null) {
                r0 += a.a.a.a.eN(6, this.ult.aUk());
            }
            return ((((r0 + (a.a.a.b.b.a.cH(7) + 8)) + (a.a.a.b.b.a.cH(8) + 8)) + a.a.a.a.eL(9, this.tvL)) + a.a.a.a.eL(10, this.ulu)) + a.a.a.a.c(11, 8, this.tEZ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tEZ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uls == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.ult != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: WifiName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bln com_tencent_mm_protocal_c_bln = (bln) objArr[1];
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
                        com_tencent_mm_protocal_c_bln.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bln.ulr = aVar3.xmD.mM();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bln.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bln.trD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bln.uls = emVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bln.ult = emVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bln.tld = aVar3.xmD.readDouble();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bln.tle = aVar3.xmD.readDouble();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bln.tvL = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bln.ulu = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bda();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bln.tEZ.add(emVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
