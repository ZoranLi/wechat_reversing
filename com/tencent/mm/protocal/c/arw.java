package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class arw extends avh {
    public long tVZ;
    public avx tWp;
    public avx tWq;
    public avx tWr;
    public int tWs;
    public int tvL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tWp == null) {
                throw new b("Not all required fields were included: ClientReport");
            } else if (this.tWq == null) {
                throw new b("Not all required fields were included: ChannelReport");
            } else if (this.tWr == null) {
                throw new b("Not all required fields were included: EngineReport");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tWp != null) {
                    aVar.eQ(2, this.tWp.aUk());
                    this.tWp.a(aVar);
                }
                if (this.tWq != null) {
                    aVar.eQ(3, this.tWq.aUk());
                    this.tWq.a(aVar);
                }
                if (this.tWr != null) {
                    aVar.eQ(4, this.tWr.aUk());
                    this.tWr.a(aVar);
                }
                aVar.eO(5, this.tvL);
                aVar.O(6, this.tVZ);
                aVar.eO(7, this.tWs);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tWp != null) {
                r0 += a.a.a.a.eN(2, this.tWp.aUk());
            }
            if (this.tWq != null) {
                r0 += a.a.a.a.eN(3, this.tWq.aUk());
            }
            if (this.tWr != null) {
                r0 += a.a.a.a.eN(4, this.tWr.aUk());
            }
            return ((r0 + a.a.a.a.eL(5, this.tvL)) + a.a.a.a.N(6, this.tVZ)) + a.a.a.a.eL(7, this.tWs);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tWp == null) {
                throw new b("Not all required fields were included: ClientReport");
            } else if (this.tWq == null) {
                throw new b("Not all required fields were included: ChannelReport");
            } else if (this.tWr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: EngineReport");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            arw com_tencent_mm_protocal_c_arw = (arw) objArr[1];
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
                        com_tencent_mm_protocal_c_arw.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arw.tWp = emVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arw.tWq = emVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arw.tWr = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_arw.tvL = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_arw.tVZ = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_arw.tWs = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
