package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class amn extends a {
    public int tRj;
    public aen tjo;
    public aeo tjp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tjo == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.tjp == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.tjo != null) {
                    aVar.eQ(1, this.tjo.aUk());
                    this.tjo.a(aVar);
                }
                if (this.tjp != null) {
                    aVar.eQ(2, this.tjp.aUk());
                    this.tjp.a(aVar);
                }
                aVar.eO(3, this.tRj);
                return 0;
            }
        } else if (i == 1) {
            if (this.tjo != null) {
                r0 = a.a.a.a.eN(1, this.tjo.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tjp != null) {
                r0 += a.a.a.a.eN(2, this.tjp.aUk());
            }
            return r0 + a.a.a.a.eL(3, this.tRj);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tjo == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.tjp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HardDeviceAttr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            amn com_tencent_mm_protocal_c_amn = (amn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_aen;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aen = new aen();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aen.a(aVar4, com_tencent_mm_protocal_c_aen, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amn.tjo = com_tencent_mm_protocal_c_aen;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aen = new aeo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aen.a(aVar4, com_tencent_mm_protocal_c_aen, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amn.tjp = com_tencent_mm_protocal_c_aen;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amn.tRj = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
