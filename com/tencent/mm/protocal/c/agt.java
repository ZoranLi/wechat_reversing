package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class agt extends avh {
    public String fTO;
    public String lUw;
    public int scene;
    public String signature;
    public LinkedList<String> tLC = new LinkedList();
    public String tLD;
    public String tLo;
    public String tLp;
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
            aVar.d(4, 1, this.tLC);
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
            aVar.eO(9, this.scene);
            if (this.tLD == null) {
                return 0;
            }
            aVar.e(10, this.tLD);
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
            r0 += a.a.a.a.c(4, 1, this.tLC);
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
            r0 += a.a.a.a.eL(9, this.scene);
            if (this.tLD != null) {
                r0 += a.a.a.b.b.a.f(10, this.tLD);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tLC.clear();
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
            agt com_tencent_mm_protocal_c_agt = (agt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agt.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agt.url = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agt.fTO = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agt.tLC.add(aVar3.xmD.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agt.lUw = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agt.tLo = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agt.signature = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agt.tLp = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agt.scene = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_agt.tLD = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
