package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import java.util.LinkedList;

public final class bhv extends avh {
    public int mtd;
    public int tFO;
    public String tKJ;
    public avx tfd;
    public avx tfe;
    public String tfi;
    public int tgJ;
    public int tgK;
    public int tgL;
    public String tng;
    public int tnh;
    public int tni;
    public int tnj;
    public int trD;
    public avw tsk;
    public String ttW;
    public int tuG;
    public String tup;
    public int uah;
    public int udC;
    public avx uhl;
    public String uhm;
    public String uhn;
    public int uho;
    public int uhp;
    public String uhq;
    public int uhr;
    public int uhs;
    public int uht;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.uhl == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.uhl != null) {
                    aVar.eQ(2, this.uhl.aUk());
                    this.uhl.a(aVar);
                }
                if (this.tfd != null) {
                    aVar.eQ(3, this.tfd.aUk());
                    this.tfd.a(aVar);
                }
                if (this.tfe != null) {
                    aVar.eQ(4, this.tfe.aUk());
                    this.tfe.a(aVar);
                }
                aVar.eO(5, this.tgJ);
                aVar.eO(6, this.tgK);
                aVar.eO(7, this.tgL);
                if (this.tsk != null) {
                    aVar.eQ(8, this.tsk.aUk());
                    this.tsk.a(aVar);
                }
                aVar.eO(9, this.mtd);
                if (this.tfi != null) {
                    aVar.e(10, this.tfi);
                }
                aVar.eO(11, this.tFO);
                aVar.eO(12, this.trD);
                aVar.eO(13, this.udC);
                if (this.ttW != null) {
                    aVar.e(14, this.ttW);
                }
                if (this.uhm != null) {
                    aVar.e(15, this.uhm);
                }
                if (this.uhn != null) {
                    aVar.e(16, this.uhn);
                }
                if (this.tng != null) {
                    aVar.e(17, this.tng);
                }
                aVar.eO(18, this.tnh);
                aVar.eO(19, this.uho);
                aVar.eO(20, this.uhp);
                if (this.uhq != null) {
                    aVar.e(21, this.uhq);
                }
                aVar.eO(22, this.uhr);
                aVar.eO(23, this.uhs);
                aVar.eO(24, this.uht);
                if (this.tKJ != null) {
                    aVar.e(25, this.tKJ);
                }
                aVar.eO(26, this.tuG);
                if (this.tup != null) {
                    aVar.e(27, this.tup);
                }
                aVar.eO(28, this.tni);
                aVar.eO(29, this.tnj);
                aVar.eO(30, this.uah);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.uhl != null) {
                r0 += a.a.a.a.eN(2, this.uhl.aUk());
            }
            if (this.tfd != null) {
                r0 += a.a.a.a.eN(3, this.tfd.aUk());
            }
            if (this.tfe != null) {
                r0 += a.a.a.a.eN(4, this.tfe.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.tgJ)) + a.a.a.a.eL(6, this.tgK)) + a.a.a.a.eL(7, this.tgL);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(8, this.tsk.aUk());
            }
            r0 += a.a.a.a.eL(9, this.mtd);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(10, this.tfi);
            }
            r0 = ((r0 + a.a.a.a.eL(11, this.tFO)) + a.a.a.a.eL(12, this.trD)) + a.a.a.a.eL(13, this.udC);
            if (this.ttW != null) {
                r0 += a.a.a.b.b.a.f(14, this.ttW);
            }
            if (this.uhm != null) {
                r0 += a.a.a.b.b.a.f(15, this.uhm);
            }
            if (this.uhn != null) {
                r0 += a.a.a.b.b.a.f(16, this.uhn);
            }
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(17, this.tng);
            }
            r0 = ((r0 + a.a.a.a.eL(18, this.tnh)) + a.a.a.a.eL(19, this.uho)) + a.a.a.a.eL(20, this.uhp);
            if (this.uhq != null) {
                r0 += a.a.a.b.b.a.f(21, this.uhq);
            }
            r0 = ((r0 + a.a.a.a.eL(22, this.uhr)) + a.a.a.a.eL(23, this.uhs)) + a.a.a.a.eL(24, this.uht);
            if (this.tKJ != null) {
                r0 += a.a.a.b.b.a.f(25, this.tKJ);
            }
            r0 += a.a.a.a.eL(26, this.tuG);
            if (this.tup != null) {
                r0 += a.a.a.b.b.a.f(27, this.tup);
            }
            return ((r0 + a.a.a.a.eL(28, this.tni)) + a.a.a.a.eL(29, this.tnj)) + a.a.a.a.eL(30, this.uah);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uhl == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tsk != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhv com_tencent_mm_protocal_c_bhv = (bhv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhv.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhv.uhl = emVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhv.tfd = emVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhv.tfe = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhv.tgJ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhv.tgK = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhv.tgL = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhv.tsk = emVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhv.mtd = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bhv.tfi = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bhv.tFO = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bhv.trD = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bhv.udC = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bhv.ttW = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bhv.uhm = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bhv.uhn = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bhv.tng = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bhv.tnh = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bhv.uho = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bhv.uhp = aVar3.xmD.mL();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bhv.uhq = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bhv.uhr = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bhv.uhs = aVar3.xmD.mL();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bhv.uht = aVar3.xmD.mL();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bhv.tKJ = aVar3.xmD.readString();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bhv.tuG = aVar3.xmD.mL();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bhv.tup = aVar3.xmD.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bhv.tni = aVar3.xmD.mL();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_bhv.tnj = aVar3.xmD.mL();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bhv.uah = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
