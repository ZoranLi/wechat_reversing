package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class gg extends avp {
    public int jNB;
    public int tdE;
    public int tdH;
    public avw tfh;
    public avw thh;
    public avw thn;
    public awa tjQ;
    public String tjV;
    public avx tjY;
    public avw tjZ;
    public int tkb;
    public String tkc;
    public String tkd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tjV != null) {
                    aVar.e(2, this.tjV);
                }
                if (this.tfh != null) {
                    aVar.eQ(3, this.tfh.aUk());
                    this.tfh.a(aVar);
                }
                aVar.eO(4, this.tdH);
                aVar.eO(5, this.tkb);
                if (this.tkc != null) {
                    aVar.e(6, this.tkc);
                }
                aVar.eO(7, this.jNB);
                if (this.tkd != null) {
                    aVar.e(8, this.tkd);
                }
                if (this.tjY != null) {
                    aVar.eQ(9, this.tjY.aUk());
                    this.tjY.a(aVar);
                }
                if (this.thn != null) {
                    aVar.eQ(10, this.thn.aUk());
                    this.thn.a(aVar);
                }
                if (this.tjZ != null) {
                    aVar.eQ(11, this.tjZ.aUk());
                    this.tjZ.a(aVar);
                }
                if (this.tjQ != null) {
                    aVar.eQ(12, this.tjQ.aUk());
                    this.tjQ.a(aVar);
                }
                aVar.eO(13, this.tdE);
                if (this.thh == null) {
                    return 0;
                }
                aVar.eQ(14, this.thh.aUk());
                this.thh.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tjV != null) {
                r0 += a.a.a.b.b.a.f(2, this.tjV);
            }
            if (this.tfh != null) {
                r0 += a.a.a.a.eN(3, this.tfh.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tdH)) + a.a.a.a.eL(5, this.tkb);
            if (this.tkc != null) {
                r0 += a.a.a.b.b.a.f(6, this.tkc);
            }
            r0 += a.a.a.a.eL(7, this.jNB);
            if (this.tkd != null) {
                r0 += a.a.a.b.b.a.f(8, this.tkd);
            }
            if (this.tjY != null) {
                r0 += a.a.a.a.eN(9, this.tjY.aUk());
            }
            if (this.thn != null) {
                r0 += a.a.a.a.eN(10, this.thn.aUk());
            }
            if (this.tjZ != null) {
                r0 += a.a.a.a.eN(11, this.tjZ.aUk());
            }
            if (this.tjQ != null) {
                r0 += a.a.a.a.eN(12, this.tjQ.aUk());
            }
            r0 += a.a.a.a.eL(13, this.tdE);
            if (this.thh != null) {
                r0 += a.a.a.a.eN(14, this.thh.aUk());
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
            } else if (this.tfh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            gg ggVar = (gg) objArr[1];
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
                        ggVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    ggVar.tjV = aVar3.xmD.readString();
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
                        ggVar.tfh = enVar;
                    }
                    return 0;
                case 4:
                    ggVar.tdH = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ggVar.tkb = aVar3.xmD.mL();
                    return 0;
                case 6:
                    ggVar.tkc = aVar3.xmD.readString();
                    return 0;
                case 7:
                    ggVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 8:
                    ggVar.tkd = aVar3.xmD.readString();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ggVar.tjY = enVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ggVar.thn = enVar;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ggVar.tjZ = enVar;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new awa();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ggVar.tjQ = enVar;
                    }
                    return 0;
                case 13:
                    ggVar.tdE = aVar3.xmD.mL();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ggVar.thh = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
