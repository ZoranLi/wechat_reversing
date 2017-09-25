package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class mv extends avp {
    public int ksW;
    public LinkedList<alm> teK = new LinkedList();
    public avx teL;
    public avw tfh;
    public String tqb;
    public String tqc;
    public avx ttd;
    public avx ttf;
    public avx ttg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ttd == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.teL == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.ttd != null) {
                    aVar.eQ(2, this.ttd.aUk());
                    this.ttd.a(aVar);
                }
                if (this.ttf != null) {
                    aVar.eQ(3, this.ttf.aUk());
                    this.ttf.a(aVar);
                }
                if (this.ttg != null) {
                    aVar.eQ(4, this.ttg.aUk());
                    this.ttg.a(aVar);
                }
                aVar.eO(5, this.ksW);
                aVar.d(6, 8, this.teK);
                if (this.teL != null) {
                    aVar.eQ(7, this.teL.aUk());
                    this.teL.a(aVar);
                }
                if (this.tfh != null) {
                    aVar.eQ(8, this.tfh.aUk());
                    this.tfh.a(aVar);
                }
                if (this.tqb != null) {
                    aVar.e(9, this.tqb);
                }
                if (this.tqc == null) {
                    return 0;
                }
                aVar.e(10, this.tqc);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ttd != null) {
                r0 += a.a.a.a.eN(2, this.ttd.aUk());
            }
            if (this.ttf != null) {
                r0 += a.a.a.a.eN(3, this.ttf.aUk());
            }
            if (this.ttg != null) {
                r0 += a.a.a.a.eN(4, this.ttg.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(5, this.ksW)) + a.a.a.a.c(6, 8, this.teK);
            if (this.teL != null) {
                r0 += a.a.a.a.eN(7, this.teL.aUk());
            }
            if (this.tfh != null) {
                r0 += a.a.a.a.eN(8, this.tfh.aUk());
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(9, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(10, this.tqc);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.teK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ttd == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.teL == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.tfh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            mv mvVar = (mv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        mvVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        mvVar.ttd = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        mvVar.ttf = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        mvVar.ttg = enVar;
                    }
                    return 0;
                case 5:
                    mvVar.ksW = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new alm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        mvVar.teK.add(enVar);
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        mvVar.teL = enVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        mvVar.tfh = enVar;
                    }
                    return 0;
                case 9:
                    mvVar.tqb = aVar3.xmD.readString();
                    return 0;
                case 10:
                    mvVar.tqc = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
