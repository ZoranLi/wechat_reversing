package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class anx extends avh {
    public String tSZ;
    public String tTa;
    public int tli;
    public avw tlj;
    public int tlm;
    public int tln;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tlj == null) {
                throw new b("Not all required fields were included: ImageBuffer");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tli);
            if (this.tlj != null) {
                aVar.eQ(3, this.tlj.aUk());
                this.tlj.a(aVar);
            }
            aVar.eO(4, this.tlm);
            if (this.tSZ != null) {
                aVar.e(5, this.tSZ);
            }
            if (this.tTa != null) {
                aVar.e(6, this.tTa);
            }
            aVar.eO(7, this.tln);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tli);
            if (this.tlj != null) {
                r0 += a.a.a.a.eN(3, this.tlj.aUk());
            }
            r0 += a.a.a.a.eL(4, this.tlm);
            if (this.tSZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.tSZ);
            }
            if (this.tTa != null) {
                r0 += a.a.a.b.b.a.f(6, this.tTa);
            }
            return r0 + a.a.a.a.eL(7, this.tln);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tlj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImageBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            anx com_tencent_mm_protocal_c_anx = (anx) objArr[1];
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
                        com_tencent_mm_protocal_c_anx.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anx.tli = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anx.tlj = emVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anx.tlm = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_anx.tSZ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_anx.tTa = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_anx.tln = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
