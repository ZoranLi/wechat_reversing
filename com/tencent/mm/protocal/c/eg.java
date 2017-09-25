package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class eg extends a implements bah {
    public String ID;
    public avw thF;
    public String thW;
    public int thX;
    public avw thY;
    public String thZ;
    public int tia;
    public String tib;
    public String tic;

    public final int getRet() {
        return this.thX;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.thY == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.thF == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                aVar.eO(1, this.thX);
                if (this.thY != null) {
                    aVar.eQ(2, this.thY.aUk());
                    this.thY.a(aVar);
                }
                if (this.thZ != null) {
                    aVar.e(3, this.thZ);
                }
                if (this.thF != null) {
                    aVar.eQ(4, this.thF.aUk());
                    this.thF.a(aVar);
                }
                if (this.tib != null) {
                    aVar.e(5, this.tib);
                }
                if (this.tic != null) {
                    aVar.e(6, this.tic);
                }
                aVar.eO(7, this.tia);
                if (this.ID != null) {
                    aVar.e(8, this.ID);
                }
                if (this.thW != null) {
                    aVar.e(9, this.thW);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.thX) + 0;
            if (this.thY != null) {
                r0 += a.a.a.a.eN(2, this.thY.aUk());
            }
            if (this.thZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.thZ);
            }
            if (this.thF != null) {
                r0 += a.a.a.a.eN(4, this.thF.aUk());
            }
            if (this.tib != null) {
                r0 += a.a.a.b.b.a.f(5, this.tib);
            }
            if (this.tic != null) {
                r0 += a.a.a.b.b.a.f(6, this.tic);
            }
            r0 += a.a.a.a.eL(7, this.tia);
            if (this.ID != null) {
                r0 += a.a.a.b.b.a.f(8, this.ID);
            }
            if (this.thW != null) {
                return r0 + a.a.a.b.b.a.f(9, this.thW);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.thY == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.thF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            eg egVar = (eg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    egVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        egVar.thY = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 3:
                    egVar.thZ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        egVar.thF = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 5:
                    egVar.tib = aVar3.xmD.readString();
                    return 0;
                case 6:
                    egVar.tic = aVar3.xmD.readString();
                    return 0;
                case 7:
                    egVar.tia = aVar3.xmD.mL();
                    return 0;
                case 8:
                    egVar.ID = aVar3.xmD.readString();
                    return 0;
                case 9:
                    egVar.thW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
