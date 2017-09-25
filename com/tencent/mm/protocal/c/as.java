package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class as extends a {
    public int jOc;
    public String msN;
    public int tdM;
    public String tdN;
    public String tdO;
    public String tdP;
    public aq tdQ;
    public String tdR;
    public cl tdS;
    public ct tdT;
    public cs tdU;
    public cs tdV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jOc);
            if (this.msN != null) {
                aVar.e(2, this.msN);
            }
            aVar.eO(3, this.tdM);
            if (this.tdN != null) {
                aVar.e(4, this.tdN);
            }
            if (this.tdO != null) {
                aVar.e(5, this.tdO);
            }
            if (this.tdP != null) {
                aVar.e(6, this.tdP);
            }
            if (this.tdQ != null) {
                aVar.eQ(7, this.tdQ.aUk());
                this.tdQ.a(aVar);
            }
            if (this.tdR != null) {
                aVar.e(8, this.tdR);
            }
            if (this.tdS != null) {
                aVar.eQ(9, this.tdS.aUk());
                this.tdS.a(aVar);
            }
            if (this.tdT != null) {
                aVar.eQ(10, this.tdT.aUk());
                this.tdT.a(aVar);
            }
            if (this.tdU != null) {
                aVar.eQ(11, this.tdU.aUk());
                this.tdU.a(aVar);
            }
            if (this.tdV != null) {
                aVar.eQ(12, this.tdV.aUk());
                this.tdV.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jOc) + 0;
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(2, this.msN);
            }
            r0 += a.a.a.a.eL(3, this.tdM);
            if (this.tdN != null) {
                r0 += a.a.a.b.b.a.f(4, this.tdN);
            }
            if (this.tdO != null) {
                r0 += a.a.a.b.b.a.f(5, this.tdO);
            }
            if (this.tdP != null) {
                r0 += a.a.a.b.b.a.f(6, this.tdP);
            }
            if (this.tdQ != null) {
                r0 += a.a.a.a.eN(7, this.tdQ.aUk());
            }
            if (this.tdR != null) {
                r0 += a.a.a.b.b.a.f(8, this.tdR);
            }
            if (this.tdS != null) {
                r0 += a.a.a.a.eN(9, this.tdS.aUk());
            }
            if (this.tdT != null) {
                r0 += a.a.a.a.eN(10, this.tdT.aUk());
            }
            if (this.tdU != null) {
                r0 += a.a.a.a.eN(11, this.tdU.aUk());
            }
            if (this.tdV != null) {
                return r0 + a.a.a.a.eN(12, this.tdV.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            as asVar = (as) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a aqVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    asVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    asVar.msN = aVar3.xmD.readString();
                    return 0;
                case 3:
                    asVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 4:
                    asVar.tdN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    asVar.tdO = aVar3.xmD.readString();
                    return 0;
                case 6:
                    asVar.tdP = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        aqVar = new aq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqVar.a(aVar4, aqVar, a.a(aVar4))) {
                        }
                        asVar.tdQ = aqVar;
                    }
                    return 0;
                case 8:
                    asVar.tdR = aVar3.xmD.readString();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        aqVar = new cl();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqVar.a(aVar4, aqVar, a.a(aVar4))) {
                        }
                        asVar.tdS = aqVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        aqVar = new ct();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqVar.a(aVar4, aqVar, a.a(aVar4))) {
                        }
                        asVar.tdT = aqVar;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        aqVar = new cs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqVar.a(aVar4, aqVar, a.a(aVar4))) {
                        }
                        asVar.tdU = aqVar;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        aqVar = new cs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqVar.a(aVar4, aqVar, a.a(aVar4))) {
                        }
                        asVar.tdV = aqVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
