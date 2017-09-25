package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ef extends a {
    public String ID;
    public int thX;
    public avw thY;
    public String thZ;
    public int tia;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.thY == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            }
            aVar.eO(1, this.thX);
            if (this.thY != null) {
                aVar.eQ(2, this.thY.aUk());
                this.thY.a(aVar);
            }
            if (this.thZ != null) {
                aVar.e(3, this.thZ);
            }
            aVar.eO(4, this.tia);
            if (this.ID != null) {
                aVar.e(5, this.ID);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.thX) + 0;
            if (this.thY != null) {
                r0 += a.a.a.a.eN(2, this.thY.aUk());
            }
            if (this.thZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.thZ);
            }
            r0 += a.a.a.a.eL(4, this.tia);
            if (this.ID != null) {
                return r0 + a.a.a.b.b.a.f(5, this.ID);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.thY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: QRCodeBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ef efVar = (ef) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    efVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        efVar.thY = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 3:
                    efVar.thZ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    efVar.tia = aVar3.xmD.mL();
                    return 0;
                case 5:
                    efVar.ID = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
