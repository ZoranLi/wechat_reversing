package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class azl extends avh {
    public int tGv;
    public int tGw;
    public int tfT;
    public int tiL;
    public float tna;
    public int trD;
    public avw tsk;
    public int uaL;
    public float uaM;
    public float uaN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tsk != null) {
                aVar.eQ(2, this.tsk.aUk());
                this.tsk.a(aVar);
            }
            aVar.eO(3, this.uaL);
            aVar.eO(4, this.tiL);
            aVar.n(5, this.uaM);
            aVar.eO(6, this.trD);
            aVar.eO(7, this.tfT);
            aVar.n(8, this.uaN);
            aVar.n(9, this.tna);
            aVar.eO(10, this.tGv);
            aVar.eO(11, this.tGw);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(2, this.tsk.aUk());
            }
            return ((((((((r0 + a.a.a.a.eL(3, this.uaL)) + a.a.a.a.eL(4, this.tiL)) + (a.a.a.b.b.a.cH(5) + 4)) + a.a.a.a.eL(6, this.trD)) + a.a.a.a.eL(7, this.tfT)) + (a.a.a.b.b.a.cH(8) + 4)) + (a.a.a.b.b.a.cH(9) + 4)) + a.a.a.a.eL(10, this.tGv)) + a.a.a.a.eL(11, this.tGw);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            azl com_tencent_mm_protocal_c_azl = (azl) objArr[1];
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
                        com_tencent_mm_protocal_c_azl.tYN = emVar;
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
                        com_tencent_mm_protocal_c_azl.tsk = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azl.uaL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azl.tiL = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azl.uaM = aVar3.xmD.readFloat();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azl.trD = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azl.tfT = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azl.uaN = aVar3.xmD.readFloat();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_azl.tna = aVar3.xmD.readFloat();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_azl.tGv = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_azl.tGw = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
