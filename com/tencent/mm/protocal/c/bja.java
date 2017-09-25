package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bja extends avp {
    public avx tIn;
    public avw tfh;
    public avw thh;
    public String thm;
    public avw thn;
    public avx tjY;
    public avw tjZ;
    public String tuo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tIn == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tIn != null) {
                    aVar.eQ(2, this.tIn.aUk());
                    this.tIn.a(aVar);
                }
                if (this.tfh != null) {
                    aVar.eQ(3, this.tfh.aUk());
                    this.tfh.a(aVar);
                }
                if (this.tuo != null) {
                    aVar.e(4, this.tuo);
                }
                if (this.tjY != null) {
                    aVar.eQ(5, this.tjY.aUk());
                    this.tjY.a(aVar);
                }
                if (this.thn != null) {
                    aVar.eQ(6, this.thn.aUk());
                    this.thn.a(aVar);
                }
                if (this.tjZ != null) {
                    aVar.eQ(7, this.tjZ.aUk());
                    this.tjZ.a(aVar);
                }
                if (this.thm != null) {
                    aVar.e(8, this.thm);
                }
                if (this.thh == null) {
                    return 0;
                }
                aVar.eQ(9, this.thh.aUk());
                this.thh.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tIn != null) {
                r0 += a.a.a.a.eN(2, this.tIn.aUk());
            }
            if (this.tfh != null) {
                r0 += a.a.a.a.eN(3, this.tfh.aUk());
            }
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(4, this.tuo);
            }
            if (this.tjY != null) {
                r0 += a.a.a.a.eN(5, this.tjY.aUk());
            }
            if (this.thn != null) {
                r0 += a.a.a.a.eN(6, this.thn.aUk());
            }
            if (this.tjZ != null) {
                r0 += a.a.a.a.eN(7, this.tjZ.aUk());
            }
            if (this.thm != null) {
                r0 += a.a.a.b.b.a.f(8, this.thm);
            }
            if (this.thh != null) {
                r0 += a.a.a.a.eN(9, this.thh.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tIn == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.tfh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bja com_tencent_mm_protocal_c_bja = (bja) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bja.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bja.tIn = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bja.tfh = enVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bja.tuo = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bja.tjY = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bja.thn = enVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bja.tjZ = enVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bja.thm = aVar3.xmD.readString();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bja.thh = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
