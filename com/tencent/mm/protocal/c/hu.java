package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class hu extends a {
    public String jOp;
    public String msF;
    public hw tlT;
    public axh tlW;
    public ib tlX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jOp == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.tlW == null) {
                throw new b("Not all required fields were included: ContactItem");
            } else {
                if (this.jOp != null) {
                    aVar.e(1, this.jOp);
                }
                if (this.tlT != null) {
                    aVar.eQ(2, this.tlT.aUk());
                    this.tlT.a(aVar);
                }
                if (this.tlW != null) {
                    aVar.eQ(3, this.tlW.aUk());
                    this.tlW.a(aVar);
                }
                if (this.tlX != null) {
                    aVar.eQ(4, this.tlX.aUk());
                    this.tlX.a(aVar);
                }
                if (this.msF == null) {
                    return 0;
                }
                aVar.e(5, this.msF);
                return 0;
            }
        } else if (i == 1) {
            if (this.jOp != null) {
                r0 = a.a.a.b.b.a.f(1, this.jOp) + 0;
            } else {
                r0 = 0;
            }
            if (this.tlT != null) {
                r0 += a.a.a.a.eN(2, this.tlT.aUk());
            }
            if (this.tlW != null) {
                r0 += a.a.a.a.eN(3, this.tlW.aUk());
            }
            if (this.tlX != null) {
                r0 += a.a.a.a.eN(4, this.tlX.aUk());
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(5, this.msF);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jOp == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.tlW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ContactItem");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hu huVar = (hu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a hwVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    huVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        hwVar = new hw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, a.a(aVar4))) {
                        }
                        huVar.tlT = hwVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        hwVar = new axh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, a.a(aVar4))) {
                        }
                        huVar.tlW = hwVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        hwVar = new ib();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, a.a(aVar4))) {
                        }
                        huVar.tlX = hwVar;
                    }
                    return 0;
                case 5:
                    huVar.msF = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
