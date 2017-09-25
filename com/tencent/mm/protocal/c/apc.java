package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class apc extends a {
    public avw tUc;
    public int tUd;
    public avw tUe;
    public int uin;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uin);
            aVar.eO(2, this.version);
            if (this.tUc != null) {
                aVar.eQ(3, this.tUc.aUk());
                this.tUc.a(aVar);
            }
            aVar.eO(4, this.tUd);
            if (this.tUe != null) {
                aVar.eQ(5, this.tUe.aUk());
                this.tUe.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.uin) + 0) + a.a.a.a.eL(2, this.version);
            if (this.tUc != null) {
                r0 += a.a.a.a.eN(3, this.tUc.aUk());
            }
            r0 += a.a.a.a.eL(4, this.tUd);
            if (this.tUe != null) {
                return r0 + a.a.a.a.eN(5, this.tUe.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            apc com_tencent_mm_protocal_c_apc = (apc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_apc.uin = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apc.version = aVar3.xmD.mL();
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
                        com_tencent_mm_protocal_c_apc.tUc = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apc.tUd = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apc.tUe = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
