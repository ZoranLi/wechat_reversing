package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aja extends avh {
    public avw tNc;
    public int tce;
    public float tmZ;
    public float tna;
    public int twQ;
    public String twR;
    public String twS;
    public int twT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tce);
            aVar.n(3, this.tmZ);
            aVar.n(4, this.tna);
            aVar.eO(5, this.twQ);
            if (this.twR != null) {
                aVar.e(6, this.twR);
            }
            if (this.twS != null) {
                aVar.e(7, this.twS);
            }
            aVar.eO(8, this.twT);
            if (this.tNc == null) {
                return 0;
            }
            aVar.eQ(9, this.tNc.aUk());
            this.tNc.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.eL(2, this.tce)) + (a.a.a.b.b.a.cH(3) + 4)) + (a.a.a.b.b.a.cH(4) + 4)) + a.a.a.a.eL(5, this.twQ);
            if (this.twR != null) {
                r0 += a.a.a.b.b.a.f(6, this.twR);
            }
            if (this.twS != null) {
                r0 += a.a.a.b.b.a.f(7, this.twS);
            }
            r0 += a.a.a.a.eL(8, this.twT);
            if (this.tNc != null) {
                r0 += a.a.a.a.eN(9, this.tNc.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aja com_tencent_mm_protocal_c_aja = (aja) objArr[1];
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
                        com_tencent_mm_protocal_c_aja.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aja.tce = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aja.tmZ = aVar3.xmD.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aja.tna = aVar3.xmD.readFloat();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aja.twQ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aja.twR = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aja.twS = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aja.twT = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aja.tNc = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
