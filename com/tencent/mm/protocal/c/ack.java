package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ack extends avp {
    public String hhW;
    public boolean lfS;
    public LinkedList<String> tHU = new LinkedList();
    public String tHV;
    public String tHW;
    public boolean tHY;
    public LinkedList<bra> tIb = new LinkedList();
    public LinkedList<brb> tIc = new LinkedList();
    public String tId;
    public String tIe;
    public String tIf;
    public String tIg;
    public boolean tIh;
    public int tIi;
    public String tIj;
    public LinkedList<sk> tfb = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tId == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.tIe == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.hhW == null) {
                throw new b("Not all required fields were included: rankid");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.d(2, 8, this.tIb);
                aVar.d(3, 8, this.tIc);
                aVar.d(4, 1, this.tHU);
                if (this.tId != null) {
                    aVar.e(5, this.tId);
                }
                if (this.tIe != null) {
                    aVar.e(6, this.tIe);
                }
                if (this.hhW != null) {
                    aVar.e(7, this.hhW);
                }
                if (this.tIf != null) {
                    aVar.e(8, this.tIf);
                }
                if (this.tHV != null) {
                    aVar.e(9, this.tHV);
                }
                aVar.an(10, this.lfS);
                if (this.tHW != null) {
                    aVar.e(11, this.tHW);
                }
                aVar.d(12, 8, this.tfb);
                aVar.an(13, this.tHY);
                if (this.tIg != null) {
                    aVar.e(14, this.tIg);
                }
                aVar.an(15, this.tIh);
                aVar.eO(16, this.tIi);
                if (this.tIj == null) {
                    return 0;
                }
                aVar.e(17, this.tIj);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.c(2, 8, this.tIb)) + a.a.a.a.c(3, 8, this.tIc)) + a.a.a.a.c(4, 1, this.tHU);
            if (this.tId != null) {
                r0 += a.a.a.b.b.a.f(5, this.tId);
            }
            if (this.tIe != null) {
                r0 += a.a.a.b.b.a.f(6, this.tIe);
            }
            if (this.hhW != null) {
                r0 += a.a.a.b.b.a.f(7, this.hhW);
            }
            if (this.tIf != null) {
                r0 += a.a.a.b.b.a.f(8, this.tIf);
            }
            if (this.tHV != null) {
                r0 += a.a.a.b.b.a.f(9, this.tHV);
            }
            r0 += a.a.a.b.b.a.cH(10) + 1;
            if (this.tHW != null) {
                r0 += a.a.a.b.b.a.f(11, this.tHW);
            }
            r0 = (r0 + a.a.a.a.c(12, 8, this.tfb)) + (a.a.a.b.b.a.cH(13) + 1);
            if (this.tIg != null) {
                r0 += a.a.a.b.b.a.f(14, this.tIg);
            }
            r0 = (r0 + (a.a.a.b.b.a.cH(15) + 1)) + a.a.a.a.eL(16, this.tIi);
            if (this.tIj != null) {
                r0 += a.a.a.b.b.a.f(17, this.tIj);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tIb.clear();
            this.tIc.clear();
            this.tHU.clear();
            this.tfb.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tId == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.tIe == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.hhW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ack com_tencent_mm_protocal_c_ack = (ack) objArr[1];
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
                        com_tencent_mm_protocal_c_ack.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bra();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ack.tIb.add(enVar);
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new brb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ack.tIc.add(enVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ack.tHU.add(aVar3.xmD.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ack.tId = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ack.tIe = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ack.hhW = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ack.tIf = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ack.tHV = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ack.lfS = aVar3.cib();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ack.tHW = aVar3.xmD.readString();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new sk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ack.tfb.add(enVar);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ack.tHY = aVar3.cib();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ack.tIg = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ack.tIh = aVar3.cib();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ack.tIi = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ack.tIj = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
