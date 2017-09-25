package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class cu extends a {
    public int jOc;
    public String mtb;
    public String mvU;
    public String mvV;
    public int ogM;
    public String opI;
    public int tfT;
    public String tfU;
    public avw tfV;
    public int tfW;
    public int tfX;
    public String tfY;
    public String tfZ;
    public String tfi;
    public String tga;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvV != null) {
                aVar.e(1, this.mvV);
            }
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            aVar.eO(3, this.tfT);
            if (this.mvU != null) {
                aVar.e(4, this.mvU);
            }
            aVar.eO(5, this.jOc);
            if (this.opI != null) {
                aVar.e(6, this.opI);
            }
            aVar.eO(7, this.ogM);
            if (this.tfU != null) {
                aVar.e(8, this.tfU);
            }
            if (this.tfV != null) {
                aVar.eQ(9, this.tfV.aUk());
                this.tfV.a(aVar);
            }
            aVar.eO(10, this.tfW);
            aVar.eO(11, this.tfX);
            if (this.tfi != null) {
                aVar.e(12, this.tfi);
            }
            if (this.tfY != null) {
                aVar.e(13, this.tfY);
            }
            if (this.tfZ != null) {
                aVar.e(14, this.tfZ);
            }
            if (this.tga == null) {
                return 0;
            }
            aVar.e(15, this.tga);
            return 0;
        } else if (i == 1) {
            if (this.mvV != null) {
                r0 = a.a.a.b.b.a.f(1, this.mvV) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            r0 += a.a.a.a.eL(3, this.tfT);
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvU);
            }
            r0 += a.a.a.a.eL(5, this.jOc);
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(6, this.opI);
            }
            r0 += a.a.a.a.eL(7, this.ogM);
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(8, this.tfU);
            }
            if (this.tfV != null) {
                r0 += a.a.a.a.eN(9, this.tfV.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(10, this.tfW)) + a.a.a.a.eL(11, this.tfX);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(12, this.tfi);
            }
            if (this.tfY != null) {
                r0 += a.a.a.b.b.a.f(13, this.tfY);
            }
            if (this.tfZ != null) {
                r0 += a.a.a.b.b.a.f(14, this.tfZ);
            }
            if (this.tga != null) {
                r0 += a.a.a.b.b.a.f(15, this.tga);
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
            cu cuVar = (cu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cuVar.mvV = aVar3.xmD.readString();
                    return 0;
                case 2:
                    cuVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    cuVar.tfT = aVar3.xmD.mL();
                    return 0;
                case 4:
                    cuVar.mvU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    cuVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 6:
                    cuVar.opI = aVar3.xmD.readString();
                    return 0;
                case 7:
                    cuVar.ogM = aVar3.xmD.mL();
                    return 0;
                case 8:
                    cuVar.tfU = aVar3.xmD.readString();
                    return 0;
                case 9:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        cuVar.tfV = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 10:
                    cuVar.tfW = aVar3.xmD.mL();
                    return 0;
                case 11:
                    cuVar.tfX = aVar3.xmD.mL();
                    return 0;
                case 12:
                    cuVar.tfi = aVar3.xmD.readString();
                    return 0;
                case 13:
                    cuVar.tfY = aVar3.xmD.readString();
                    return 0;
                case 14:
                    cuVar.tfZ = aVar3.xmD.readString();
                    return 0;
                case 15:
                    cuVar.tga = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
