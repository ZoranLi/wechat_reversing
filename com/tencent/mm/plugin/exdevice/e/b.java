package com.tencent.mm.plugin.exdevice.e;

import a.a.a.c.a;
import java.util.LinkedList;

public final class b extends j {
    public com.tencent.mm.bd.b leP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lfi == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            } else if (this.leP == null) {
                throw new a.a.a.b("Not all required fields were included: AesSessionKey");
            } else {
                if (this.lfi != null) {
                    aVar.eQ(1, this.lfi.aUk());
                    this.lfi.a(aVar);
                }
                if (this.leP == null) {
                    return 0;
                }
                aVar.b(2, this.leP);
                return 0;
            }
        } else if (i == 1) {
            if (this.lfi != null) {
                r0 = a.a.a.a.eN(1, this.lfi.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.leP != null) {
                r0 += a.a.a.a.a(2, this.leP);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = j.a(aVar2); r0 > 0; r0 = j.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.lfi == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            } else if (this.leP != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: AesSessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
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
                        bVar.lfi = eVar;
                    }
                    return 0;
                case 2:
                    bVar.leP = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
