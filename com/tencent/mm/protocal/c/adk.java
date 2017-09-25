package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class adk extends avh {
    public String jNj;
    public avw tBy;
    public String tIW;
    public int tdM;
    public avw thn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.thn == null) {
                throw new b("Not all required fields were included: A2Key");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.thn != null) {
                aVar.eQ(2, this.thn.aUk());
                this.thn.a(aVar);
            }
            if (this.jNj != null) {
                aVar.e(3, this.jNj);
            }
            aVar.eO(4, this.tdM);
            if (this.tIW != null) {
                aVar.e(5, this.tIW);
            }
            if (this.tBy == null) {
                return 0;
            }
            aVar.eQ(6, this.tBy.aUk());
            this.tBy.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.thn != null) {
                r0 += a.a.a.a.eN(2, this.thn.aUk());
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(3, this.jNj);
            }
            r0 += a.a.a.a.eL(4, this.tdM);
            if (this.tIW != null) {
                r0 += a.a.a.b.b.a.f(5, this.tIW);
            }
            if (this.tBy != null) {
                r0 += a.a.a.a.eN(6, this.tBy.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.thn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: A2Key");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            adk com_tencent_mm_protocal_c_adk = (adk) objArr[1];
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
                        com_tencent_mm_protocal_c_adk.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adk.thn = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adk.jNj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adk.tdM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adk.tIW = aVar3.xmD.readString();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adk.tBy = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
