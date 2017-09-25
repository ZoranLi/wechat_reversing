package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class amr extends a {
    public aql tQW;
    public String tRa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tRa == null) {
                throw new b("Not all required fields were included: ContactUsername");
            } else if (this.tQW == null) {
                throw new b("Not all required fields were included: PhoneNumListInfo");
            } else {
                if (this.tRa != null) {
                    aVar.e(1, this.tRa);
                }
                if (this.tQW == null) {
                    return 0;
                }
                aVar.eQ(2, this.tQW.aUk());
                this.tQW.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tRa != null) {
                r0 = a.a.a.b.b.a.f(1, this.tRa) + 0;
            } else {
                r0 = 0;
            }
            if (this.tQW != null) {
                r0 += a.a.a.a.eN(2, this.tQW.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tRa == null) {
                throw new b("Not all required fields were included: ContactUsername");
            } else if (this.tQW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: PhoneNumListInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            amr com_tencent_mm_protocal_c_amr = (amr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_amr.tRa = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aql = new aql();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aql.a(aVar4, com_tencent_mm_protocal_c_aql, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amr.tQW = com_tencent_mm_protocal_c_aql;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
