package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ht extends a {
    public String fDC;
    public String msk;
    public String ohq;
    public hw tlT;
    public hx tlU;
    public hs tlV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msk == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.ohq == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.tlT == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.tlV == null) {
                throw new b("Not all required fields were included: ActionInfo");
            } else {
                if (this.fDC != null) {
                    aVar.e(1, this.fDC);
                }
                if (this.msk != null) {
                    aVar.e(2, this.msk);
                }
                if (this.ohq != null) {
                    aVar.e(3, this.ohq);
                }
                if (this.tlT != null) {
                    aVar.eQ(4, this.tlT.aUk());
                    this.tlT.a(aVar);
                }
                if (this.tlU != null) {
                    aVar.eQ(5, this.tlU.aUk());
                    this.tlU.a(aVar);
                }
                if (this.tlV == null) {
                    return 0;
                }
                aVar.eQ(6, this.tlV.aUk());
                this.tlV.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(2, this.msk);
            }
            if (this.ohq != null) {
                r0 += a.a.a.b.b.a.f(3, this.ohq);
            }
            if (this.tlT != null) {
                r0 += a.a.a.a.eN(4, this.tlT.aUk());
            }
            if (this.tlU != null) {
                r0 += a.a.a.a.eN(5, this.tlU.aUk());
            }
            if (this.tlV != null) {
                r0 += a.a.a.a.eN(6, this.tlV.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msk == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.ohq == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.tlT == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.tlV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActionInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ht htVar = (ht) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a hwVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    htVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    htVar.msk = aVar3.xmD.readString();
                    return 0;
                case 3:
                    htVar.ohq = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        hwVar = new hw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, a.a(aVar4))) {
                        }
                        htVar.tlT = hwVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        hwVar = new hx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, a.a(aVar4))) {
                        }
                        htVar.tlU = hwVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        hwVar = new hs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, a.a(aVar4))) {
                        }
                        htVar.tlV = hwVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
