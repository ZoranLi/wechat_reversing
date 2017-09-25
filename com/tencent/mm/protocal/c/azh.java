package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class azh extends avp {
    public String fVm;
    public String hib;
    public String kdE;
    public String kdG;
    public String kdH;
    public String kdI;
    public int kdL;
    public String keT;
    public int kfr;
    public int poM;
    public int poP;
    public String poQ;
    public String poR;
    public String poS;
    public String poT;
    public String poU;
    public boolean poV;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(2, this.kfr);
            if (this.kdE != null) {
                aVar.e(3, this.kdE);
            }
            if (this.fVm != null) {
                aVar.e(4, this.fVm);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.kdH != null) {
                aVar.e(6, this.kdH);
            }
            if (this.kdI != null) {
                aVar.e(7, this.kdI);
            }
            if (this.keT != null) {
                aVar.e(8, this.keT);
            }
            if (this.kdG != null) {
                aVar.e(9, this.kdG);
            }
            if (this.hib != null) {
                aVar.e(10, this.hib);
            }
            aVar.eO(11, this.poM);
            aVar.eO(12, this.poP);
            if (this.poQ != null) {
                aVar.e(13, this.poQ);
            }
            if (this.poR != null) {
                aVar.e(14, this.poR);
            }
            if (this.poS != null) {
                aVar.e(19, this.poS);
            }
            if (this.poT != null) {
                aVar.e(21, this.poT);
            }
            aVar.eO(22, this.kdL);
            if (this.poU != null) {
                aVar.e(23, this.poU);
            }
            aVar.an(24, this.poV);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.kfr);
            if (this.kdE != null) {
                r0 += a.a.a.b.b.a.f(3, this.kdE);
            }
            if (this.fVm != null) {
                r0 += a.a.a.b.b.a.f(4, this.fVm);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(5, this.title);
            }
            if (this.kdH != null) {
                r0 += a.a.a.b.b.a.f(6, this.kdH);
            }
            if (this.kdI != null) {
                r0 += a.a.a.b.b.a.f(7, this.kdI);
            }
            if (this.keT != null) {
                r0 += a.a.a.b.b.a.f(8, this.keT);
            }
            if (this.kdG != null) {
                r0 += a.a.a.b.b.a.f(9, this.kdG);
            }
            if (this.hib != null) {
                r0 += a.a.a.b.b.a.f(10, this.hib);
            }
            r0 = (r0 + a.a.a.a.eL(11, this.poM)) + a.a.a.a.eL(12, this.poP);
            if (this.poQ != null) {
                r0 += a.a.a.b.b.a.f(13, this.poQ);
            }
            if (this.poR != null) {
                r0 += a.a.a.b.b.a.f(14, this.poR);
            }
            if (this.poS != null) {
                r0 += a.a.a.b.b.a.f(19, this.poS);
            }
            if (this.poT != null) {
                r0 += a.a.a.b.b.a.f(21, this.poT);
            }
            r0 += a.a.a.a.eL(22, this.kdL);
            if (this.poU != null) {
                r0 += a.a.a.b.b.a.f(23, this.poU);
            }
            return r0 + (a.a.a.b.b.a.cH(24) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            azh com_tencent_mm_protocal_c_azh = (azh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azh.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azh.kfr = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azh.kdE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azh.fVm = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azh.title = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azh.kdH = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azh.kdI = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azh.keT = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_azh.kdG = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_azh.hib = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_azh.poM = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_azh.poP = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_azh.poQ = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_azh.poR = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_azh.poS = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_azh.poT = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_azh.kdL = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_azh.poU = aVar3.xmD.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_azh.poV = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
