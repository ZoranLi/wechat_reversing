package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class asy extends avh {
    public String tkF;
    public String tkL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tkL == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.tkF == null) {
                throw new b("Not all required fields were included: bizchat_id");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tkL != null) {
                    aVar.e(2, this.tkL);
                }
                if (this.tkF == null) {
                    return 0;
                }
                aVar.e(3, this.tkF);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tkL != null) {
                r0 += a.a.a.b.b.a.f(2, this.tkL);
            }
            if (this.tkF != null) {
                r0 += a.a.a.b.b.a.f(3, this.tkF);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tkL == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.tkF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            asy com_tencent_mm_protocal_c_asy = (asy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asy.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asy.tkL = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asy.tkF = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
