package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bu extends a {
    public int jNB;
    public int mtd;
    public int ogM;
    public int tfc;
    public avx tfd;
    public avx tfe;
    public avx tff;
    public int tfg;
    public avw tfh;
    public String tfi;
    public String tfj;
    public long tfk;
    public int tfl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tff == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                aVar.eO(1, this.tfc);
                if (this.tfd != null) {
                    aVar.eQ(2, this.tfd.aUk());
                    this.tfd.a(aVar);
                }
                if (this.tfe != null) {
                    aVar.eQ(3, this.tfe.aUk());
                    this.tfe.a(aVar);
                }
                aVar.eO(4, this.mtd);
                if (this.tff != null) {
                    aVar.eQ(5, this.tff.aUk());
                    this.tff.a(aVar);
                }
                aVar.eO(6, this.jNB);
                aVar.eO(7, this.tfg);
                if (this.tfh != null) {
                    aVar.eQ(8, this.tfh.aUk());
                    this.tfh.a(aVar);
                }
                aVar.eO(9, this.ogM);
                if (this.tfi != null) {
                    aVar.e(10, this.tfi);
                }
                if (this.tfj != null) {
                    aVar.e(11, this.tfj);
                }
                aVar.O(12, this.tfk);
                aVar.eO(13, this.tfl);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tfc) + 0;
            if (this.tfd != null) {
                r0 += a.a.a.a.eN(2, this.tfd.aUk());
            }
            if (this.tfe != null) {
                r0 += a.a.a.a.eN(3, this.tfe.aUk());
            }
            r0 += a.a.a.a.eL(4, this.mtd);
            if (this.tff != null) {
                r0 += a.a.a.a.eN(5, this.tff.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(6, this.jNB)) + a.a.a.a.eL(7, this.tfg);
            if (this.tfh != null) {
                r0 += a.a.a.a.eN(8, this.tfh.aUk());
            }
            r0 += a.a.a.a.eL(9, this.ogM);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(10, this.tfi);
            }
            if (this.tfj != null) {
                r0 += a.a.a.b.b.a.f(11, this.tfj);
            }
            return (r0 + a.a.a.a.N(12, this.tfk)) + a.a.a.a.eL(13, this.tfl);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tff == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.tfh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bu buVar = (bu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    buVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        buVar.tfd = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        buVar.tfe = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 4:
                    buVar.mtd = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        buVar.tff = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 6:
                    buVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 7:
                    buVar.tfg = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        buVar.tfh = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 9:
                    buVar.ogM = aVar3.xmD.mL();
                    return 0;
                case 10:
                    buVar.tfi = aVar3.xmD.readString();
                    return 0;
                case 11:
                    buVar.tfj = aVar3.xmD.readString();
                    return 0;
                case 12:
                    buVar.tfk = aVar3.xmD.mM();
                    return 0;
                case 13:
                    buVar.tfl = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
