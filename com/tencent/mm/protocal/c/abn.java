package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class abn extends avh {
    public String jOp;
    public String leO;
    public String tHf;
    public String tHg;
    public String tHh;
    public String tHi;
    public String tHj;
    public int tHk;
    public String thC;
    public avw tjF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tjF == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tjF != null) {
                aVar.eQ(2, this.tjF.aUk());
                this.tjF.a(aVar);
            }
            if (this.tHf != null) {
                aVar.e(3, this.tHf);
            }
            if (this.tHg != null) {
                aVar.e(4, this.tHg);
            }
            if (this.jOp != null) {
                aVar.e(5, this.jOp);
            }
            if (this.tHh != null) {
                aVar.e(6, this.tHh);
            }
            if (this.tHi != null) {
                aVar.e(7, this.tHi);
            }
            if (this.tHj != null) {
                aVar.e(8, this.tHj);
            }
            aVar.eO(9, this.tHk);
            if (this.leO != null) {
                aVar.e(10, this.leO);
            }
            if (this.thC == null) {
                return 0;
            }
            aVar.e(11, this.thC);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tjF != null) {
                r0 += a.a.a.a.eN(2, this.tjF.aUk());
            }
            if (this.tHf != null) {
                r0 += a.a.a.b.b.a.f(3, this.tHf);
            }
            if (this.tHg != null) {
                r0 += a.a.a.b.b.a.f(4, this.tHg);
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(5, this.jOp);
            }
            if (this.tHh != null) {
                r0 += a.a.a.b.b.a.f(6, this.tHh);
            }
            if (this.tHi != null) {
                r0 += a.a.a.b.b.a.f(7, this.tHi);
            }
            if (this.tHj != null) {
                r0 += a.a.a.b.b.a.f(8, this.tHj);
            }
            r0 += a.a.a.a.eL(9, this.tHk);
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(10, this.leO);
            }
            if (this.thC != null) {
                r0 += a.a.a.b.b.a.f(11, this.thC);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tjF != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            abn com_tencent_mm_protocal_c_abn = (abn) objArr[1];
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
                        com_tencent_mm_protocal_c_abn.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abn.tjF = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_abn.tHf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_abn.tHg = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_abn.jOp = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_abn.tHh = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_abn.tHi = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_abn.tHj = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_abn.tHk = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_abn.leO = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_abn.thC = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
