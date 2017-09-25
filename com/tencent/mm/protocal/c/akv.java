package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class akv extends a {
    public String jNj;
    public os thJ;
    public avw tjF;
    public String tjK;
    public String tjU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tjF == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.thJ == null) {
                throw new b("Not all required fields were included: CliPubECDHKey");
            } else {
                if (this.tjF != null) {
                    aVar.eQ(1, this.tjF.aUk());
                    this.tjF.a(aVar);
                }
                if (this.thJ != null) {
                    aVar.eQ(2, this.thJ.aUk());
                    this.thJ.a(aVar);
                }
                if (this.jNj != null) {
                    aVar.e(3, this.jNj);
                }
                if (this.tjK != null) {
                    aVar.e(4, this.tjK);
                }
                if (this.tjU == null) {
                    return 0;
                }
                aVar.e(5, this.tjU);
                return 0;
            }
        } else if (i == 1) {
            if (this.tjF != null) {
                r0 = a.a.a.a.eN(1, this.tjF.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.thJ != null) {
                r0 += a.a.a.a.eN(2, this.thJ.aUk());
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(3, this.jNj);
            }
            if (this.tjK != null) {
                r0 += a.a.a.b.b.a.f(4, this.tjK);
            }
            if (this.tjU != null) {
                r0 += a.a.a.b.b.a.f(5, this.tjU);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tjF == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.thJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CliPubECDHKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            akv com_tencent_mm_protocal_c_akv = (akv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akv.tjF = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new os();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akv.thJ = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akv.jNj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akv.tjK = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akv.tjU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
