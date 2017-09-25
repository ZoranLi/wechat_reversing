package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class axm extends avh {
    public String hAG;
    public int tgM;
    public int tni;
    public int tuG;
    public String tup;
    public cu uae;
    public String uaf;
    public String uag;
    public int uah;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.uae == null) {
                throw new b("Not all required fields were included: Msg");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.uae != null) {
                aVar.eQ(2, this.uae.aUk());
                this.uae.a(aVar);
            }
            if (this.uaf != null) {
                aVar.e(3, this.uaf);
            }
            aVar.eO(4, this.tuG);
            if (this.tup != null) {
                aVar.e(5, this.tup);
            }
            aVar.eO(6, this.tgM);
            if (this.hAG != null) {
                aVar.e(7, this.hAG);
            }
            if (this.uag != null) {
                aVar.e(8, this.uag);
            }
            aVar.eO(9, this.uah);
            aVar.eO(10, this.tni);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.uae != null) {
                r0 += a.a.a.a.eN(2, this.uae.aUk());
            }
            if (this.uaf != null) {
                r0 += a.a.a.b.b.a.f(3, this.uaf);
            }
            r0 += a.a.a.a.eL(4, this.tuG);
            if (this.tup != null) {
                r0 += a.a.a.b.b.a.f(5, this.tup);
            }
            r0 += a.a.a.a.eL(6, this.tgM);
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(7, this.hAG);
            }
            if (this.uag != null) {
                r0 += a.a.a.b.b.a.f(8, this.uag);
            }
            return (r0 + a.a.a.a.eL(9, this.uah)) + a.a.a.a.eL(10, this.tni);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uae != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axm com_tencent_mm_protocal_c_axm = (axm) objArr[1];
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
                        com_tencent_mm_protocal_c_axm.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new cu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axm.uae = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axm.uaf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axm.tuG = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axm.tup = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axm.tgM = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axm.hAG = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axm.uag = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axm.uah = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axm.tni = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
