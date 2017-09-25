package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bhw extends avp {
    public int ogM;
    public int tfc;
    public avx tfd;
    public avx tfe;
    public long tfk;
    public int tgJ;
    public int tgK;
    public int tgL;
    public String tng;
    public String tnk;
    public avx uhl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.uhl == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(2, this.tfc);
                if (this.uhl != null) {
                    aVar.eQ(3, this.uhl.aUk());
                    this.uhl.a(aVar);
                }
                if (this.tfd != null) {
                    aVar.eQ(4, this.tfd.aUk());
                    this.tfd.a(aVar);
                }
                if (this.tfe != null) {
                    aVar.eQ(5, this.tfe.aUk());
                    this.tfe.a(aVar);
                }
                aVar.eO(6, this.tgJ);
                aVar.eO(7, this.tgK);
                aVar.eO(8, this.tgL);
                aVar.eO(9, this.ogM);
                aVar.O(10, this.tfk);
                if (this.tng != null) {
                    aVar.e(11, this.tng);
                }
                if (this.tnk == null) {
                    return 0;
                }
                aVar.e(12, this.tnk);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tfc);
            if (this.uhl != null) {
                r0 += a.a.a.a.eN(3, this.uhl.aUk());
            }
            if (this.tfd != null) {
                r0 += a.a.a.a.eN(4, this.tfd.aUk());
            }
            if (this.tfe != null) {
                r0 += a.a.a.a.eN(5, this.tfe.aUk());
            }
            r0 = ((((r0 + a.a.a.a.eL(6, this.tgJ)) + a.a.a.a.eL(7, this.tgK)) + a.a.a.a.eL(8, this.tgL)) + a.a.a.a.eL(9, this.ogM)) + a.a.a.a.N(10, this.tfk);
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(11, this.tng);
            }
            if (this.tnk != null) {
                r0 += a.a.a.b.b.a.f(12, this.tnk);
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
            } else if (this.uhl == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ToUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhw com_tencent_mm_protocal_c_bhw = (bhw) objArr[1];
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
                        com_tencent_mm_protocal_c_bhw.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhw.tfc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhw.uhl = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhw.tfd = enVar;
                    }
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
                        com_tencent_mm_protocal_c_bhw.tfe = enVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhw.tgJ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhw.tgK = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhw.tgL = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhw.ogM = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bhw.tfk = aVar3.xmD.mM();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bhw.tng = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bhw.tnk = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
