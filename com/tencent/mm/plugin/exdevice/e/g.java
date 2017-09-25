package com.tencent.mm.plugin.exdevice.e;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class g extends j {
    public String jNo;
    public int leV;
    public int leW;
    public int leX;
    public int leY;
    public int leZ;
    public String lfa;
    public int lfb;
    public String lfc;
    public int lfd;
    public int lfe;
    public String lff;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lfi == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.lfi != null) {
                aVar.eQ(1, this.lfi.aUk());
                this.lfi.a(aVar);
            }
            aVar.eO(2, this.leV);
            aVar.eO(3, this.leW);
            aVar.eO(4, this.leX);
            aVar.eO(5, this.leY);
            aVar.eO(6, this.leZ);
            if (this.lfa != null) {
                aVar.e(11, this.lfa);
            }
            aVar.eO(12, this.lfb);
            if (this.jNo != null) {
                aVar.e(13, this.jNo);
            }
            if (this.lfc != null) {
                aVar.e(14, this.lfc);
            }
            aVar.eO(15, this.lfd);
            aVar.eO(16, this.lfe);
            if (this.lff == null) {
                return 0;
            }
            aVar.e(17, this.lff);
            return 0;
        } else if (i == 1) {
            if (this.lfi != null) {
                r0 = a.a.a.a.eN(1, this.lfi.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.eL(2, this.leV)) + a.a.a.a.eL(3, this.leW)) + a.a.a.a.eL(4, this.leX)) + a.a.a.a.eL(5, this.leY)) + a.a.a.a.eL(6, this.leZ);
            if (this.lfa != null) {
                r0 += a.a.a.b.b.a.f(11, this.lfa);
            }
            r0 += a.a.a.a.eL(12, this.lfb);
            if (this.jNo != null) {
                r0 += a.a.a.b.b.a.f(13, this.jNo);
            }
            if (this.lfc != null) {
                r0 += a.a.a.b.b.a.f(14, this.lfc);
            }
            r0 = (r0 + a.a.a.a.eL(15, this.lfd)) + a.a.a.a.eL(16, this.lfe);
            if (this.lff != null) {
                r0 += a.a.a.b.b.a.f(17, this.lff);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = j.a(aVar2); r0 > 0; r0 = j.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.lfi != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, j.a(aVar4))) {
                        }
                        gVar.lfi = eVar;
                    }
                    return 0;
                case 2:
                    gVar.leV = aVar3.xmD.mL();
                    return 0;
                case 3:
                    gVar.leW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    gVar.leX = aVar3.xmD.mL();
                    return 0;
                case 5:
                    gVar.leY = aVar3.xmD.mL();
                    return 0;
                case 6:
                    gVar.leZ = aVar3.xmD.mL();
                    return 0;
                case 11:
                    gVar.lfa = aVar3.xmD.readString();
                    return 0;
                case 12:
                    gVar.lfb = aVar3.xmD.mL();
                    return 0;
                case 13:
                    gVar.jNo = aVar3.xmD.readString();
                    return 0;
                case 14:
                    gVar.lfc = aVar3.xmD.readString();
                    return 0;
                case 15:
                    gVar.lfd = aVar3.xmD.mL();
                    return 0;
                case 16:
                    gVar.lfe = aVar3.xmD.mL();
                    return 0;
                case 17:
                    gVar.lff = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
