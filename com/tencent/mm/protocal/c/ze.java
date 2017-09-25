package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ze extends avp {
    public String fVm;
    public String hib;
    public String kdE;
    public String kdG;
    public String kdH;
    public String kdI;
    public int kdL;
    public String keT;
    public int poP;
    public String poQ;
    public String poR;
    public String poS;
    public String poU;
    public boolean poV;
    public boolean tFm;
    public boolean tFn;
    public String tFo;
    public String tFp;
    public int tFq;
    public String tFr;
    public int tFs;
    public String tFt;
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
            aVar.an(2, this.tFm);
            aVar.an(3, this.tFn);
            if (this.tFo != null) {
                aVar.e(4, this.tFo);
            }
            if (this.tFp != null) {
                aVar.e(5, this.tFp);
            }
            aVar.eO(6, this.tFq);
            if (this.tFr != null) {
                aVar.e(7, this.tFr);
            }
            aVar.eO(8, this.tFs);
            if (this.kdE != null) {
                aVar.e(9, this.kdE);
            }
            if (this.fVm != null) {
                aVar.e(10, this.fVm);
            }
            if (this.title != null) {
                aVar.e(11, this.title);
            }
            if (this.kdH != null) {
                aVar.e(12, this.kdH);
            }
            if (this.kdI != null) {
                aVar.e(13, this.kdI);
            }
            if (this.keT != null) {
                aVar.e(14, this.keT);
            }
            if (this.kdG != null) {
                aVar.e(15, this.kdG);
            }
            if (this.hib != null) {
                aVar.e(16, this.hib);
            }
            aVar.eO(17, this.poP);
            if (this.poQ != null) {
                aVar.e(18, this.poQ);
            }
            if (this.poR != null) {
                aVar.e(19, this.poR);
            }
            if (this.poS != null) {
                aVar.e(20, this.poS);
            }
            aVar.eO(21, this.kdL);
            if (this.poU != null) {
                aVar.e(22, this.poU);
            }
            if (this.tFt != null) {
                aVar.e(23, this.tFt);
            }
            aVar.an(24, this.poV);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + (a.a.a.b.b.a.cH(2) + 1)) + (a.a.a.b.b.a.cH(3) + 1);
            if (this.tFo != null) {
                r0 += a.a.a.b.b.a.f(4, this.tFo);
            }
            if (this.tFp != null) {
                r0 += a.a.a.b.b.a.f(5, this.tFp);
            }
            r0 += a.a.a.a.eL(6, this.tFq);
            if (this.tFr != null) {
                r0 += a.a.a.b.b.a.f(7, this.tFr);
            }
            r0 += a.a.a.a.eL(8, this.tFs);
            if (this.kdE != null) {
                r0 += a.a.a.b.b.a.f(9, this.kdE);
            }
            if (this.fVm != null) {
                r0 += a.a.a.b.b.a.f(10, this.fVm);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(11, this.title);
            }
            if (this.kdH != null) {
                r0 += a.a.a.b.b.a.f(12, this.kdH);
            }
            if (this.kdI != null) {
                r0 += a.a.a.b.b.a.f(13, this.kdI);
            }
            if (this.keT != null) {
                r0 += a.a.a.b.b.a.f(14, this.keT);
            }
            if (this.kdG != null) {
                r0 += a.a.a.b.b.a.f(15, this.kdG);
            }
            if (this.hib != null) {
                r0 += a.a.a.b.b.a.f(16, this.hib);
            }
            r0 += a.a.a.a.eL(17, this.poP);
            if (this.poQ != null) {
                r0 += a.a.a.b.b.a.f(18, this.poQ);
            }
            if (this.poR != null) {
                r0 += a.a.a.b.b.a.f(19, this.poR);
            }
            if (this.poS != null) {
                r0 += a.a.a.b.b.a.f(20, this.poS);
            }
            r0 += a.a.a.a.eL(21, this.kdL);
            if (this.poU != null) {
                r0 += a.a.a.b.b.a.f(22, this.poU);
            }
            if (this.tFt != null) {
                r0 += a.a.a.b.b.a.f(23, this.tFt);
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
            ze zeVar = (ze) objArr[1];
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
                        zeVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    zeVar.tFm = aVar3.cib();
                    return 0;
                case 3:
                    zeVar.tFn = aVar3.cib();
                    return 0;
                case 4:
                    zeVar.tFo = aVar3.xmD.readString();
                    return 0;
                case 5:
                    zeVar.tFp = aVar3.xmD.readString();
                    return 0;
                case 6:
                    zeVar.tFq = aVar3.xmD.mL();
                    return 0;
                case 7:
                    zeVar.tFr = aVar3.xmD.readString();
                    return 0;
                case 8:
                    zeVar.tFs = aVar3.xmD.mL();
                    return 0;
                case 9:
                    zeVar.kdE = aVar3.xmD.readString();
                    return 0;
                case 10:
                    zeVar.fVm = aVar3.xmD.readString();
                    return 0;
                case 11:
                    zeVar.title = aVar3.xmD.readString();
                    return 0;
                case 12:
                    zeVar.kdH = aVar3.xmD.readString();
                    return 0;
                case 13:
                    zeVar.kdI = aVar3.xmD.readString();
                    return 0;
                case 14:
                    zeVar.keT = aVar3.xmD.readString();
                    return 0;
                case 15:
                    zeVar.kdG = aVar3.xmD.readString();
                    return 0;
                case 16:
                    zeVar.hib = aVar3.xmD.readString();
                    return 0;
                case 17:
                    zeVar.poP = aVar3.xmD.mL();
                    return 0;
                case 18:
                    zeVar.poQ = aVar3.xmD.readString();
                    return 0;
                case 19:
                    zeVar.poR = aVar3.xmD.readString();
                    return 0;
                case 20:
                    zeVar.poS = aVar3.xmD.readString();
                    return 0;
                case 21:
                    zeVar.kdL = aVar3.xmD.mL();
                    return 0;
                case 22:
                    zeVar.poU = aVar3.xmD.readString();
                    return 0;
                case 23:
                    zeVar.tFt = aVar3.xmD.readString();
                    return 0;
                case 24:
                    zeVar.poV = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
