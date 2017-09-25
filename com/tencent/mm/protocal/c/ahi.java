package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ahi extends avp {
    public b jMQ;
    public String muS;
    public agn tLL;
    public awh tLS;
    public String tee;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            if (this.tLL != null) {
                aVar.eQ(2, this.tLL.aUk());
                this.tLL.a(aVar);
            }
            if (this.jMQ != null) {
                aVar.b(3, this.jMQ);
            }
            if (this.tLS != null) {
                aVar.eQ(4, this.tLS.aUk());
                this.tLS.a(aVar);
            }
            if (this.muS != null) {
                aVar.e(5, this.muS);
            }
            if (this.tee == null) {
                return 0;
            }
            aVar.e(6, this.tee);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tLL != null) {
                r0 += a.a.a.a.eN(2, this.tLL.aUk());
            }
            if (this.jMQ != null) {
                r0 += a.a.a.a.a(3, this.jMQ);
            }
            if (this.tLS != null) {
                r0 += a.a.a.a.eN(4, this.tLS.aUk());
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(5, this.muS);
            }
            if (this.tee != null) {
                r0 += a.a.a.b.b.a.f(6, this.tee);
            }
            return r0;
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
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ahi com_tencent_mm_protocal_c_ahi = (ahi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahi.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new agn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahi.tLL = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahi.jMQ = aVar3.cic();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new awh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahi.tLS = enVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahi.muS = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ahi.tee = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
