package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class gh extends avh {
    public String mac;
    public String tke;
    public String tkf;
    public long tkg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tke != null) {
                aVar.e(2, this.tke);
            }
            if (this.tkf != null) {
                aVar.e(3, this.tkf);
            }
            if (this.mac != null) {
                aVar.e(4, this.mac);
            }
            aVar.O(5, this.tkg);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tke != null) {
                r0 += a.a.a.b.b.a.f(2, this.tke);
            }
            if (this.tkf != null) {
                r0 += a.a.a.b.b.a.f(3, this.tkf);
            }
            if (this.mac != null) {
                r0 += a.a.a.b.b.a.f(4, this.mac);
            }
            return r0 + a.a.a.a.N(5, this.tkg);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            gh ghVar = (gh) objArr[1];
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
                        ghVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    ghVar.tke = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ghVar.tkf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ghVar.mac = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ghVar.tkg = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
