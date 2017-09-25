package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class adf extends avp {
    public String fDC;
    public String mQZ;
    public String msk;
    public String tIH;
    public String tII;
    public String tIJ;
    public String tIK;
    public String tIL;
    public String tIM;
    public bmg tIN;
    public String tIO;
    public String tIP;
    public String tIQ;
    public String tIR;
    public String tIS;
    public int tIu;
    public LinkedList<bma> tIv = new LinkedList();

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
            if (this.tIH != null) {
                aVar.e(2, this.tIH);
            }
            if (this.mQZ != null) {
                aVar.e(3, this.mQZ);
            }
            if (this.fDC != null) {
                aVar.e(4, this.fDC);
            }
            if (this.msk != null) {
                aVar.e(5, this.msk);
            }
            if (this.tII != null) {
                aVar.e(6, this.tII);
            }
            if (this.tIJ != null) {
                aVar.e(7, this.tIJ);
            }
            if (this.tIK != null) {
                aVar.e(8, this.tIK);
            }
            if (this.tIL != null) {
                aVar.e(9, this.tIL);
            }
            if (this.tIM != null) {
                aVar.e(10, this.tIM);
            }
            if (this.tIN != null) {
                aVar.eQ(11, this.tIN.aUk());
                this.tIN.a(aVar);
            }
            if (this.tIO != null) {
                aVar.e(12, this.tIO);
            }
            if (this.tIP != null) {
                aVar.e(13, this.tIP);
            }
            if (this.tIQ != null) {
                aVar.e(14, this.tIQ);
            }
            if (this.tIR != null) {
                aVar.e(15, this.tIR);
            }
            if (this.tIS != null) {
                aVar.e(16, this.tIS);
            }
            aVar.eO(17, this.tIu);
            aVar.d(18, 8, this.tIv);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tIH != null) {
                r0 += a.a.a.b.b.a.f(2, this.tIH);
            }
            if (this.mQZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mQZ);
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(4, this.fDC);
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(5, this.msk);
            }
            if (this.tII != null) {
                r0 += a.a.a.b.b.a.f(6, this.tII);
            }
            if (this.tIJ != null) {
                r0 += a.a.a.b.b.a.f(7, this.tIJ);
            }
            if (this.tIK != null) {
                r0 += a.a.a.b.b.a.f(8, this.tIK);
            }
            if (this.tIL != null) {
                r0 += a.a.a.b.b.a.f(9, this.tIL);
            }
            if (this.tIM != null) {
                r0 += a.a.a.b.b.a.f(10, this.tIM);
            }
            if (this.tIN != null) {
                r0 += a.a.a.a.eN(11, this.tIN.aUk());
            }
            if (this.tIO != null) {
                r0 += a.a.a.b.b.a.f(12, this.tIO);
            }
            if (this.tIP != null) {
                r0 += a.a.a.b.b.a.f(13, this.tIP);
            }
            if (this.tIQ != null) {
                r0 += a.a.a.b.b.a.f(14, this.tIQ);
            }
            if (this.tIR != null) {
                r0 += a.a.a.b.b.a.f(15, this.tIR);
            }
            if (this.tIS != null) {
                r0 += a.a.a.b.b.a.f(16, this.tIS);
            }
            return (r0 + a.a.a.a.eL(17, this.tIu)) + a.a.a.a.c(18, 8, this.tIv);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tIv.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            adf com_tencent_mm_protocal_c_adf = (adf) objArr[1];
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
                        com_tencent_mm_protocal_c_adf.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adf.tIH = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adf.mQZ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adf.fDC = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adf.msk = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adf.tII = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adf.tIJ = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adf.tIK = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_adf.tIL = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_adf.tIM = aVar3.xmD.readString();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bmg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adf.tIN = enVar;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_adf.tIO = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_adf.tIP = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_adf.tIQ = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_adf.tIR = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_adf.tIS = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_adf.tIu = aVar3.xmD.mL();
                    return 0;
                case 18:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bma();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adf.tIv.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
