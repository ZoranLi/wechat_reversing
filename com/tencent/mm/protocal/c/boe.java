package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class boe extends a {
    public int ueH;
    public String ulM;
    public b umX;
    public b umY;
    public String umZ;
    public String una;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ulM == null) {
                throw new a.a.a.b("Not all required fields were included: Msg");
            }
            aVar.eO(1, this.ueH);
            if (this.ulM != null) {
                aVar.e(2, this.ulM);
            }
            if (this.umX != null) {
                aVar.b(3, this.umX);
            }
            if (this.umY != null) {
                aVar.b(4, this.umY);
            }
            if (this.umZ != null) {
                aVar.e(5, this.umZ);
            }
            if (this.una != null) {
                aVar.e(6, this.una);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.ueH) + 0;
            if (this.ulM != null) {
                r0 += a.a.a.b.b.a.f(2, this.ulM);
            }
            if (this.umX != null) {
                r0 += a.a.a.a.a(3, this.umX);
            }
            if (this.umY != null) {
                r0 += a.a.a.a.a(4, this.umY);
            }
            if (this.umZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.umZ);
            }
            if (this.una != null) {
                return r0 + a.a.a.b.b.a.f(6, this.una);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ulM != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            boe com_tencent_mm_protocal_c_boe = (boe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_boe.ueH = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_boe.ulM = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_boe.umX = aVar3.cic();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_boe.umY = aVar3.cic();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_boe.umZ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_boe.una = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
