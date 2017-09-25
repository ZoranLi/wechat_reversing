package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class blv extends avh {
    public String tWt;
    public int toa;
    public avw tob;
    public int tvL;
    public long tvM;
    public long ujr;
    public bku ulC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tob == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.ulC == null) {
                throw new b("Not all required fields were included: OpLog");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tWt != null) {
                    aVar.e(2, this.tWt);
                }
                aVar.eO(3, this.tvL);
                if (this.tob != null) {
                    aVar.eQ(4, this.tob.aUk());
                    this.tob.a(aVar);
                }
                if (this.ulC != null) {
                    aVar.eQ(5, this.ulC.aUk());
                    this.ulC.a(aVar);
                }
                aVar.O(6, this.tvM);
                aVar.eO(7, this.toa);
                aVar.O(8, this.ujr);
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
            r0 += a.a.a.a.eL(3, this.tvL);
            if (this.tob != null) {
                r0 += a.a.a.a.eN(4, this.tob.aUk());
            }
            if (this.ulC != null) {
                r0 += a.a.a.a.eN(5, this.ulC.aUk());
            }
            return ((r0 + a.a.a.a.N(6, this.tvM)) + a.a.a.a.eL(7, this.toa)) + a.a.a.a.N(8, this.ujr);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tob == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.ulC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: OpLog");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            blv com_tencent_mm_protocal_c_blv = (blv) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blv.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blv.tWt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blv.tvL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blv.tob = emVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bku();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blv.ulC = emVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blv.tvM = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blv.toa = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_blv.ujr = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
