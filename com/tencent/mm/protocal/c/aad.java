package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aad extends avp {
    public String msj;
    public String msk;
    public LinkedList<pn> tEp = new LinkedList();
    public String tGi;
    public avw tfG;
    public LinkedList<ov> tiM = new LinkedList();
    public String tiT;
    public String tvr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tGi == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.msj == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.msk == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.tvr == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.tiT == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.tfG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tGi != null) {
                    aVar.e(2, this.tGi);
                }
                if (this.msj != null) {
                    aVar.e(3, this.msj);
                }
                if (this.msk != null) {
                    aVar.e(4, this.msk);
                }
                if (this.tvr != null) {
                    aVar.e(5, this.tvr);
                }
                if (this.tiT != null) {
                    aVar.e(6, this.tiT);
                }
                aVar.d(7, 8, this.tEp);
                if (this.tfG != null) {
                    aVar.eQ(8, this.tfG.aUk());
                    this.tfG.a(aVar);
                }
                aVar.d(9, 8, this.tiM);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tGi != null) {
                r0 += a.a.a.b.b.a.f(2, this.tGi);
            }
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(3, this.msj);
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(4, this.msk);
            }
            if (this.tvr != null) {
                r0 += a.a.a.b.b.a.f(5, this.tvr);
            }
            if (this.tiT != null) {
                r0 += a.a.a.b.b.a.f(6, this.tiT);
            }
            r0 += a.a.a.a.c(7, 8, this.tEp);
            if (this.tfG != null) {
                r0 += a.a.a.a.eN(8, this.tfG.aUk());
            }
            return r0 + a.a.a.a.c(9, 8, this.tiM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tEp.clear();
            this.tiM.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tGi == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.msj == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.msk == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.tvr == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.tiT == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.tfG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aad com_tencent_mm_protocal_c_aad = (aad) objArr[1];
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
                        com_tencent_mm_protocal_c_aad.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aad.tGi = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aad.msj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aad.msk = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aad.tvr = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aad.tiT = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new pn();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.tEp.add(enVar);
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
                        com_tencent_mm_protocal_c_aad.tfG = enVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new ov();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.tiM.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
