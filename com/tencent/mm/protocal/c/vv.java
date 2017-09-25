package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class vv extends avp {
    public if tpc;
    public if tpd;
    public if tpe;
    public avw tpf;
    public avw tpg;
    public if tph;
    public int tpi;
    public ie tpj;
    public ie tpk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tpc == null) {
                throw new b("Not all required fields were included: DnsInfo");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tpc != null) {
                    aVar.eQ(2, this.tpc.aUk());
                    this.tpc.a(aVar);
                }
                if (this.tpd != null) {
                    aVar.eQ(3, this.tpd.aUk());
                    this.tpd.a(aVar);
                }
                if (this.tpe != null) {
                    aVar.eQ(4, this.tpe.aUk());
                    this.tpe.a(aVar);
                }
                if (this.tpf != null) {
                    aVar.eQ(5, this.tpf.aUk());
                    this.tpf.a(aVar);
                }
                if (this.tpg != null) {
                    aVar.eQ(6, this.tpg.aUk());
                    this.tpg.a(aVar);
                }
                if (this.tph != null) {
                    aVar.eQ(7, this.tph.aUk());
                    this.tph.a(aVar);
                }
                aVar.eO(8, this.tpi);
                if (this.tpj != null) {
                    aVar.eQ(9, this.tpj.aUk());
                    this.tpj.a(aVar);
                }
                if (this.tpk == null) {
                    return 0;
                }
                aVar.eQ(10, this.tpk.aUk());
                this.tpk.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tpc != null) {
                r0 += a.a.a.a.eN(2, this.tpc.aUk());
            }
            if (this.tpd != null) {
                r0 += a.a.a.a.eN(3, this.tpd.aUk());
            }
            if (this.tpe != null) {
                r0 += a.a.a.a.eN(4, this.tpe.aUk());
            }
            if (this.tpf != null) {
                r0 += a.a.a.a.eN(5, this.tpf.aUk());
            }
            if (this.tpg != null) {
                r0 += a.a.a.a.eN(6, this.tpg.aUk());
            }
            if (this.tph != null) {
                r0 += a.a.a.a.eN(7, this.tph.aUk());
            }
            r0 += a.a.a.a.eL(8, this.tpi);
            if (this.tpj != null) {
                r0 += a.a.a.a.eN(9, this.tpj.aUk());
            }
            if (this.tpk != null) {
                r0 += a.a.a.a.eN(10, this.tpk.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tpc != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DnsInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            vv vvVar = (vv) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tpc = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tpd = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tpe = enVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tpf = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tpg = enVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tph = enVar;
                    }
                    return 0;
                case 8:
                    vvVar.tpi = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new ie();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tpj = enVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new ie();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        vvVar.tpk = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
