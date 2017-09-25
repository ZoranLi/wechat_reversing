package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class axk extends a {
    public os thd;
    public avw the;
    public avw thf;
    public int tht;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.thf == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.thd == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.the == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else {
                if (this.thf != null) {
                    aVar.eQ(1, this.thf.aUk());
                    this.thf.a(aVar);
                }
                if (this.thd != null) {
                    aVar.eQ(2, this.thd.aUk());
                    this.thd.a(aVar);
                }
                if (this.the != null) {
                    aVar.eQ(3, this.the.aUk());
                    this.the.a(aVar);
                }
                aVar.eO(4, this.tht);
                return 0;
            }
        } else if (i == 1) {
            if (this.thf != null) {
                r0 = a.a.a.a.eN(1, this.thf.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.thd != null) {
                r0 += a.a.a.a.eN(2, this.thd.aUk());
            }
            if (this.the != null) {
                r0 += a.a.a.a.eN(3, this.the.aUk());
            }
            return r0 + a.a.a.a.eL(4, this.tht);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.thf == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.thd == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.the != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axk com_tencent_mm_protocal_c_axk = (axk) objArr[1];
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
                        com_tencent_mm_protocal_c_axk.thf = com_tencent_mm_protocal_c_avw;
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
                        com_tencent_mm_protocal_c_axk.thd = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axk.the = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axk.tht = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
