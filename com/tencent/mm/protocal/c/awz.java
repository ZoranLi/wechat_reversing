package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class awz extends avp {
    public int tZO;
    public cb tZP;
    public String tiZ;
    public ame tja;
    public aen tjo;
    public aeo tjp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tja == null) {
                throw new b("Not all required fields were included: Contact");
            } else if (this.tjo == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.tjp == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tja != null) {
                    aVar.eQ(2, this.tja.aUk());
                    this.tja.a(aVar);
                }
                if (this.tjo != null) {
                    aVar.eQ(3, this.tjo.aUk());
                    this.tjo.a(aVar);
                }
                if (this.tjp != null) {
                    aVar.eQ(4, this.tjp.aUk());
                    this.tjp.a(aVar);
                }
                if (this.tiZ != null) {
                    aVar.e(5, this.tiZ);
                }
                aVar.eO(6, this.tZO);
                if (this.tZP == null) {
                    return 0;
                }
                aVar.eQ(7, this.tZP.aUk());
                this.tZP.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tja != null) {
                r0 += a.a.a.a.eN(2, this.tja.aUk());
            }
            if (this.tjo != null) {
                r0 += a.a.a.a.eN(3, this.tjo.aUk());
            }
            if (this.tjp != null) {
                r0 += a.a.a.a.eN(4, this.tjp.aUk());
            }
            if (this.tiZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.tiZ);
            }
            r0 += a.a.a.a.eL(6, this.tZO);
            if (this.tZP != null) {
                r0 += a.a.a.a.eN(7, this.tZP.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tja == null) {
                throw new b("Not all required fields were included: Contact");
            } else if (this.tjo == null) {
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
            awz com_tencent_mm_protocal_c_awz = (awz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awz.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new ame();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awz.tja = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new aen();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awz.tjo = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new aeo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awz.tjp = enVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awz.tiZ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awz.tZO = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new cb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awz.tZP = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
