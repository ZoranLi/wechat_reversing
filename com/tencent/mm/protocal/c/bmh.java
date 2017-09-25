package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bmh extends a {
    public String tjV;
    public String tjW;
    public avw tjZ;
    public String ulQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tjZ == null) {
                throw new b("Not all required fields were included: KSid");
            }
            if (this.tjV != null) {
                aVar.e(1, this.tjV);
            }
            if (this.tjW != null) {
                aVar.e(2, this.tjW);
            }
            if (this.ulQ != null) {
                aVar.e(3, this.ulQ);
            }
            if (this.tjZ == null) {
                return 0;
            }
            aVar.eQ(4, this.tjZ.aUk());
            this.tjZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tjV != null) {
                r0 = a.a.a.b.b.a.f(1, this.tjV) + 0;
            } else {
                r0 = 0;
            }
            if (this.tjW != null) {
                r0 += a.a.a.b.b.a.f(2, this.tjW);
            }
            if (this.ulQ != null) {
                r0 += a.a.a.b.b.a.f(3, this.ulQ);
            }
            if (this.tjZ != null) {
                r0 += a.a.a.a.eN(4, this.tjZ.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tjZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KSid");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bmh com_tencent_mm_protocal_c_bmh = (bmh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bmh.tjV = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmh.tjW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bmh.ulQ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bmh.tjZ = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
