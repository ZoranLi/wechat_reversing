package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aci extends avp {
    public String aJE;
    public boolean lfF;
    public String lfu;
    public String lfw;
    public int lmk;
    public String tHQ;
    public brc tHR;
    public LinkedList<bre> tHS = new LinkedList();
    public LinkedList<brd> tHT = new LinkedList();
    public LinkedList<String> tHU = new LinkedList();
    public String tHV;
    public String tHW;
    public LinkedList<id> tHX = new LinkedList();
    public boolean tHY;
    public LinkedList<sk> tfb = new LinkedList();
    public LinkedList<bdq> tfx = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tHQ == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.lfw == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.tHR == null) {
                throw new b("Not all required fields were included: rankdesc");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tHQ != null) {
                    aVar.e(2, this.tHQ);
                }
                if (this.lfw != null) {
                    aVar.e(3, this.lfw);
                }
                if (this.tHR != null) {
                    aVar.eQ(4, this.tHR.aUk());
                    this.tHR.a(aVar);
                }
                aVar.d(5, 8, this.tHS);
                aVar.d(6, 8, this.tHT);
                if (this.aJE != null) {
                    aVar.e(7, this.aJE);
                }
                aVar.d(8, 1, this.tHU);
                if (this.tHV != null) {
                    aVar.e(9, this.tHV);
                }
                if (this.tHW != null) {
                    aVar.e(10, this.tHW);
                }
                aVar.d(14, 8, this.tfx);
                aVar.d(15, 8, this.tfb);
                aVar.an(16, this.lfF);
                aVar.d(17, 8, this.tHX);
                aVar.an(18, this.tHY);
                aVar.eO(19, this.lmk);
                if (this.lfu == null) {
                    return 0;
                }
                aVar.e(20, this.lfu);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tHQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tHQ);
            }
            if (this.lfw != null) {
                r0 += a.a.a.b.b.a.f(3, this.lfw);
            }
            if (this.tHR != null) {
                r0 += a.a.a.a.eN(4, this.tHR.aUk());
            }
            r0 = (r0 + a.a.a.a.c(5, 8, this.tHS)) + a.a.a.a.c(6, 8, this.tHT);
            if (this.aJE != null) {
                r0 += a.a.a.b.b.a.f(7, this.aJE);
            }
            r0 += a.a.a.a.c(8, 1, this.tHU);
            if (this.tHV != null) {
                r0 += a.a.a.b.b.a.f(9, this.tHV);
            }
            if (this.tHW != null) {
                r0 += a.a.a.b.b.a.f(10, this.tHW);
            }
            r0 = (((((r0 + a.a.a.a.c(14, 8, this.tfx)) + a.a.a.a.c(15, 8, this.tfb)) + (a.a.a.b.b.a.cH(16) + 1)) + a.a.a.a.c(17, 8, this.tHX)) + (a.a.a.b.b.a.cH(18) + 1)) + a.a.a.a.eL(19, this.lmk);
            if (this.lfu != null) {
                r0 += a.a.a.b.b.a.f(20, this.lfu);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tHS.clear();
            this.tHT.clear();
            this.tHU.clear();
            this.tfx.clear();
            this.tfb.clear();
            this.tHX.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tHQ == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.lfw == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.tHR != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankdesc");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aci com_tencent_mm_protocal_c_aci = (aci) objArr[1];
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
                        com_tencent_mm_protocal_c_aci.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aci.tHQ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aci.lfw = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new brc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aci.tHR = enVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bre();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aci.tHS.add(enVar);
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new brd();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aci.tHT.add(enVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aci.aJE = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aci.tHU.add(aVar3.xmD.readString());
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aci.tHV = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aci.tHW = aVar3.xmD.readString();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bdq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aci.tfx.add(enVar);
                    }
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new sk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aci.tfb.add(enVar);
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aci.lfF = aVar3.cib();
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new id();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aci.tHX.add(enVar);
                    }
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aci.tHY = aVar3.cib();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aci.lmk = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aci.lfu = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
