package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class alm extends a {
    public int hAD;
    public String hAE;
    public String hAF;
    public String hAG;
    public int hAH;
    public String hAM;
    public avx tLj;
    public int tMP;
    public String tMQ;
    public int tQk;
    public avx tQl;
    public avx tQm;
    public avx tQn;
    public int tsD;
    public avx ttf;
    public avx ttg;
    public avx ttv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttv == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.tQl == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.tQm == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.tQn == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.ttv != null) {
                    aVar.eQ(1, this.ttv.aUk());
                    this.ttv.a(aVar);
                }
                aVar.eO(2, this.tQk);
                if (this.tLj != null) {
                    aVar.eQ(3, this.tLj.aUk());
                    this.tLj.a(aVar);
                }
                if (this.ttf != null) {
                    aVar.eQ(4, this.ttf.aUk());
                    this.ttf.a(aVar);
                }
                if (this.ttg != null) {
                    aVar.eQ(5, this.ttg.aUk());
                    this.ttg.a(aVar);
                }
                aVar.eO(6, this.hAD);
                if (this.tQl != null) {
                    aVar.eQ(9, this.tQl.aUk());
                    this.tQl.a(aVar);
                }
                if (this.tQm != null) {
                    aVar.eQ(10, this.tQm.aUk());
                    this.tQm.a(aVar);
                }
                if (this.tQn != null) {
                    aVar.eQ(11, this.tQn.aUk());
                    this.tQn.a(aVar);
                }
                aVar.eO(12, this.tsD);
                if (this.hAE != null) {
                    aVar.e(13, this.hAE);
                }
                if (this.hAF != null) {
                    aVar.e(14, this.hAF);
                }
                if (this.hAG != null) {
                    aVar.e(15, this.hAG);
                }
                aVar.eO(16, this.hAH);
                aVar.eO(17, this.tMP);
                if (this.tMQ != null) {
                    aVar.e(18, this.tMQ);
                }
                if (this.hAM == null) {
                    return 0;
                }
                aVar.e(19, this.hAM);
                return 0;
            }
        } else if (i == 1) {
            if (this.ttv != null) {
                r0 = a.a.a.a.eN(1, this.ttv.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tQk);
            if (this.tLj != null) {
                r0 += a.a.a.a.eN(3, this.tLj.aUk());
            }
            if (this.ttf != null) {
                r0 += a.a.a.a.eN(4, this.ttf.aUk());
            }
            if (this.ttg != null) {
                r0 += a.a.a.a.eN(5, this.ttg.aUk());
            }
            r0 += a.a.a.a.eL(6, this.hAD);
            if (this.tQl != null) {
                r0 += a.a.a.a.eN(9, this.tQl.aUk());
            }
            if (this.tQm != null) {
                r0 += a.a.a.a.eN(10, this.tQm.aUk());
            }
            if (this.tQn != null) {
                r0 += a.a.a.a.eN(11, this.tQn.aUk());
            }
            r0 += a.a.a.a.eL(12, this.tsD);
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(13, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(14, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(15, this.hAG);
            }
            r0 = (r0 + a.a.a.a.eL(16, this.hAH)) + a.a.a.a.eL(17, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(18, this.tMQ);
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(19, this.hAM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttv == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.tQl == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.tQm == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.tQn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RemarkQuanPin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alm com_tencent_mm_protocal_c_alm = (alm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alm.ttv = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alm.tQk = aVar3.xmD.mL();
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
                        com_tencent_mm_protocal_c_alm.tLj = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alm.ttf = com_tencent_mm_protocal_c_avx;
                    }
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
                        com_tencent_mm_protocal_c_alm.ttg = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alm.hAD = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alm.tQl = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alm.tQm = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alm.tQn = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_alm.tsD = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_alm.hAE = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_alm.hAF = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_alm.hAG = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_alm.hAH = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_alm.tMP = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_alm.tMQ = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_alm.hAM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
