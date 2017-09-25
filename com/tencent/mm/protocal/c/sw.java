package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class sw extends a {
    public String msj;
    public String msl;
    public String mtb;
    public String muU;
    public tf tAK;
    public int tAL;
    public String tAM;
    public String tsz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.msj == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.tsz == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.muU == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.tAK == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else {
                if (this.mtb != null) {
                    aVar.e(1, this.mtb);
                }
                if (this.msj != null) {
                    aVar.e(2, this.msj);
                }
                if (this.tsz != null) {
                    aVar.e(3, this.tsz);
                }
                if (this.muU != null) {
                    aVar.e(4, this.muU);
                }
                if (this.msl != null) {
                    aVar.e(5, this.msl);
                }
                if (this.tAK != null) {
                    aVar.eQ(6, this.tAK.aUk());
                    this.tAK.a(aVar);
                }
                aVar.eO(7, this.tAL);
                if (this.tAM == null) {
                    return 0;
                }
                aVar.e(8, this.tAM);
                return 0;
            }
        } else if (i == 1) {
            if (this.mtb != null) {
                r0 = a.a.a.b.b.a.f(1, this.mtb) + 0;
            } else {
                r0 = 0;
            }
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(2, this.msj);
            }
            if (this.tsz != null) {
                r0 += a.a.a.b.b.a.f(3, this.tsz);
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(4, this.muU);
            }
            if (this.msl != null) {
                r0 += a.a.a.b.b.a.f(5, this.msl);
            }
            if (this.tAK != null) {
                r0 += a.a.a.a.eN(6, this.tAK.aUk());
            }
            r0 += a.a.a.a.eL(7, this.tAL);
            if (this.tAM != null) {
                r0 += a.a.a.b.b.a.f(8, this.tAM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mtb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.msj == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.tsz == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.muU == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.tAK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            sw swVar = (sw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    swVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    swVar.msj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    swVar.tsz = aVar3.xmD.readString();
                    return 0;
                case 4:
                    swVar.muU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    swVar.msl = aVar3.xmD.readString();
                    return 0;
                case 6:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a tfVar = new tf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tfVar.a(aVar4, tfVar, a.a(aVar4))) {
                        }
                        swVar.tAK = tfVar;
                    }
                    return 0;
                case 7:
                    swVar.tAL = aVar3.xmD.mL();
                    return 0;
                case 8:
                    swVar.tAM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
