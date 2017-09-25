package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class att extends avp {
    public String lmI;
    public atq tXC;
    public int tXQ;
    public int tXR;
    public String tXS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tXC == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                if (this.tXC != null) {
                    aVar.eQ(1, this.tXC.aUk());
                    this.tXC.a(aVar);
                }
                aVar.eO(2, this.tXQ);
                if (this.tZe != null) {
                    aVar.eQ(3, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.lmI != null) {
                    aVar.e(4, this.lmI);
                }
                aVar.eO(5, this.tXR);
                if (this.tXS == null) {
                    return 0;
                }
                aVar.e(6, this.tXS);
                return 0;
            }
        } else if (i == 1) {
            if (this.tXC != null) {
                r0 = a.a.a.a.eN(1, this.tXC.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tXQ);
            if (this.tZe != null) {
                r0 += a.a.a.a.eN(3, this.tZe.aUk());
            }
            if (this.lmI != null) {
                r0 += a.a.a.b.b.a.f(4, this.lmI);
            }
            r0 += a.a.a.a.eL(5, this.tXR);
            if (this.tXS != null) {
                r0 += a.a.a.b.b.a.f(6, this.tXS);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tXC == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.tZe != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            att com_tencent_mm_protocal_c_att = (att) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_atq;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_atq = new atq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_atq.a(aVar4, com_tencent_mm_protocal_c_atq, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_att.tXC = com_tencent_mm_protocal_c_atq;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_att.tXQ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_atq = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_atq.a(aVar4, com_tencent_mm_protocal_c_atq, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_att.tZe = com_tencent_mm_protocal_c_atq;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_att.lmI = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_att.tXR = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_att.tXS = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
