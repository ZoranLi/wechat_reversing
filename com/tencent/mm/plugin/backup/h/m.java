package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class m extends a {
    public String jNm;
    public String jNn;
    public String jNo;
    public String jNp;
    public String jNq;
    public int jNr;
    public long jNs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNm == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.jNn == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.jNo == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.jNp == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.jNq == null) {
                throw new b("Not all required fields were included: SystemVersion");
            } else {
                if (this.jNm != null) {
                    aVar.e(1, this.jNm);
                }
                if (this.jNn != null) {
                    aVar.e(2, this.jNn);
                }
                if (this.jNo != null) {
                    aVar.e(3, this.jNo);
                }
                if (this.jNp != null) {
                    aVar.e(4, this.jNp);
                }
                if (this.jNq != null) {
                    aVar.e(5, this.jNq);
                }
                aVar.eO(6, this.jNr);
                aVar.O(7, this.jNs);
                return 0;
            }
        } else if (i == 1) {
            if (this.jNm != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNm) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNn != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNn);
            }
            if (this.jNo != null) {
                r0 += a.a.a.b.b.a.f(3, this.jNo);
            }
            if (this.jNp != null) {
                r0 += a.a.a.b.b.a.f(4, this.jNp);
            }
            if (this.jNq != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNq);
            }
            return (r0 + a.a.a.a.eL(6, this.jNr)) + a.a.a.a.N(7, this.jNs);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNm == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.jNn == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.jNo == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.jNp == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.jNq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SystemVersion");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.jNm = aVar3.xmD.readString();
                    return 0;
                case 2:
                    mVar.jNn = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mVar.jNo = aVar3.xmD.readString();
                    return 0;
                case 4:
                    mVar.jNp = aVar3.xmD.readString();
                    return 0;
                case 5:
                    mVar.jNq = aVar3.xmD.readString();
                    return 0;
                case 6:
                    mVar.jNr = aVar3.xmD.mL();
                    return 0;
                case 7:
                    mVar.jNs = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
