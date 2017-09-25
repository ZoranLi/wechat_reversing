package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class eh extends a {
    public int jOc;
    public String tfU;
    public int tfc;
    public avx tfd;
    public avx tfe;
    public avx tff;
    public String tfi;
    public long tfk;
    public int tie;
    public int tif;
    public int tig;
    public LinkedList<avx> tih = new LinkedList();
    public LinkedList<avy> tii = new LinkedList();
    public avw tij;
    public int tik;
    public int til;
    public int tim;
    public long tin;
    public int tio;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tff == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.eO(1, this.jOc);
                if (this.tfU != null) {
                    aVar.e(2, this.tfU);
                }
                if (this.tfd != null) {
                    aVar.eQ(3, this.tfd.aUk());
                    this.tfd.a(aVar);
                }
                if (this.tfe != null) {
                    aVar.eQ(4, this.tfe.aUk());
                    this.tfe.a(aVar);
                }
                if (this.tff != null) {
                    aVar.eQ(5, this.tff.aUk());
                    this.tff.a(aVar);
                }
                aVar.eO(6, this.tie);
                aVar.eO(7, this.tif);
                if (this.tfi != null) {
                    aVar.e(8, this.tfi);
                }
                aVar.eO(9, this.tfc);
                aVar.eO(10, this.tig);
                aVar.d(11, 8, this.tih);
                aVar.d(12, 8, this.tii);
                if (this.tij != null) {
                    aVar.eQ(13, this.tij.aUk());
                    this.tij.a(aVar);
                }
                aVar.eO(14, this.tik);
                aVar.eO(15, this.til);
                aVar.O(16, this.tfk);
                aVar.eO(17, this.tim);
                aVar.O(18, this.tin);
                aVar.eO(19, this.tio);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jOc) + 0;
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(2, this.tfU);
            }
            if (this.tfd != null) {
                r0 += a.a.a.a.eN(3, this.tfd.aUk());
            }
            if (this.tfe != null) {
                r0 += a.a.a.a.eN(4, this.tfe.aUk());
            }
            if (this.tff != null) {
                r0 += a.a.a.a.eN(5, this.tff.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tie)) + a.a.a.a.eL(7, this.tif);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(8, this.tfi);
            }
            r0 = (((r0 + a.a.a.a.eL(9, this.tfc)) + a.a.a.a.eL(10, this.tig)) + a.a.a.a.c(11, 8, this.tih)) + a.a.a.a.c(12, 8, this.tii);
            if (this.tij != null) {
                r0 += a.a.a.a.eN(13, this.tij.aUk());
            }
            return (((((r0 + a.a.a.a.eL(14, this.tik)) + a.a.a.a.eL(15, this.til)) + a.a.a.a.N(16, this.tfk)) + a.a.a.a.eL(17, this.tim)) + a.a.a.a.N(18, this.tin)) + a.a.a.a.eL(19, this.tio);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tih.clear();
            this.tii.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tff != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            eh ehVar = (eh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ehVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    ehVar.tfU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ehVar.tfd = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ehVar.tfe = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ehVar.tff = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 6:
                    ehVar.tie = aVar3.xmD.mL();
                    return 0;
                case 7:
                    ehVar.tif = aVar3.xmD.mL();
                    return 0;
                case 8:
                    ehVar.tfi = aVar3.xmD.readString();
                    return 0;
                case 9:
                    ehVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 10:
                    ehVar.tig = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ehVar.tih.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ehVar.tii.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ehVar.tij = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 14:
                    ehVar.tik = aVar3.xmD.mL();
                    return 0;
                case 15:
                    ehVar.til = aVar3.xmD.mL();
                    return 0;
                case 16:
                    ehVar.tfk = aVar3.xmD.mM();
                    return 0;
                case 17:
                    ehVar.tim = aVar3.xmD.mL();
                    return 0;
                case 18:
                    ehVar.tin = aVar3.xmD.mM();
                    return 0;
                case 19:
                    ehVar.tio = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
