package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ww extends avp {
    public int jNa;
    public String tDB;
    public jy tDC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tDC == null) {
                throw new b("Not all required fields were included: NewChatroomData");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tDB != null) {
                    aVar.e(2, this.tDB);
                }
                aVar.eO(3, this.jNa);
                if (this.tDC == null) {
                    return 0;
                }
                aVar.eQ(4, this.tDC.aUk());
                this.tDC.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tDB != null) {
                r0 += a.a.a.b.b.a.f(2, this.tDB);
            }
            r0 += a.a.a.a.eL(3, this.jNa);
            if (this.tDC != null) {
                r0 += a.a.a.a.eN(4, this.tDC.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tDC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NewChatroomData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ww wwVar = (ww) objArr[1];
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
                        wwVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    wwVar.tDB = aVar3.xmD.readString();
                    return 0;
                case 3:
                    wwVar.jNa = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new jy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        wwVar.tDC = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
