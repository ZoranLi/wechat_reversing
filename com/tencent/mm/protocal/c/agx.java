package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class agx extends avh {
    public String fTO;
    public String lUw;
    public String signature;
    public String tLm;
    public String tLo;
    public String tLp;
    public b tLq;
    public int tLr;
    public LinkedList<ahl> tLv = new LinkedList();
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.fTO != null) {
                aVar.e(3, this.fTO);
            }
            if (this.tLm != null) {
                aVar.e(4, this.tLm);
            }
            if (this.lUw != null) {
                aVar.e(5, this.lUw);
            }
            if (this.tLo != null) {
                aVar.e(6, this.tLo);
            }
            if (this.signature != null) {
                aVar.e(7, this.signature);
            }
            if (this.tLp != null) {
                aVar.e(8, this.tLp);
            }
            if (this.tLq != null) {
                aVar.b(9, this.tLq);
            }
            aVar.eO(10, this.tLr);
            aVar.d(11, 8, this.tLv);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.fTO != null) {
                r0 += a.a.a.b.b.a.f(3, this.fTO);
            }
            if (this.tLm != null) {
                r0 += a.a.a.b.b.a.f(4, this.tLm);
            }
            if (this.lUw != null) {
                r0 += a.a.a.b.b.a.f(5, this.lUw);
            }
            if (this.tLo != null) {
                r0 += a.a.a.b.b.a.f(6, this.tLo);
            }
            if (this.signature != null) {
                r0 += a.a.a.b.b.a.f(7, this.signature);
            }
            if (this.tLp != null) {
                r0 += a.a.a.b.b.a.f(8, this.tLp);
            }
            if (this.tLq != null) {
                r0 += a.a.a.a.a(9, this.tLq);
            }
            return (r0 + a.a.a.a.eL(10, this.tLr)) + a.a.a.a.c(11, 8, this.tLv);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tLv.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            agx com_tencent_mm_protocal_c_agx = (agx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agx.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agx.url = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agx.fTO = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agx.tLm = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agx.lUw = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agx.tLo = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agx.signature = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agx.tLp = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agx.tLq = aVar3.cic();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_agx.tLr = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new ahl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agx.tLv.add(emVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
