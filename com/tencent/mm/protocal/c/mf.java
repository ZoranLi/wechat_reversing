package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class mf extends avh {
    public String mtb;
    public String thD;
    public String tst;
    public String tsu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tst == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.thD == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.tsu == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.mtb == null) {
                throw new b("Not all required fields were included: AppId");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tst != null) {
                    aVar.e(2, this.tst);
                }
                if (this.thD != null) {
                    aVar.e(3, this.thD);
                }
                if (this.tsu != null) {
                    aVar.e(4, this.tsu);
                }
                if (this.mtb == null) {
                    return 0;
                }
                aVar.e(5, this.mtb);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tst != null) {
                r0 += a.a.a.b.b.a.f(2, this.tst);
            }
            if (this.thD != null) {
                r0 += a.a.a.b.b.a.f(3, this.thD);
            }
            if (this.tsu != null) {
                r0 += a.a.a.b.b.a.f(4, this.tsu);
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(5, this.mtb);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tst == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.thD == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.tsu == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.mtb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            mf mfVar = (mf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        mfVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    mfVar.tst = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mfVar.thD = aVar3.xmD.readString();
                    return 0;
                case 4:
                    mfVar.tsu = aVar3.xmD.readString();
                    return 0;
                case 5:
                    mfVar.mtb = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
