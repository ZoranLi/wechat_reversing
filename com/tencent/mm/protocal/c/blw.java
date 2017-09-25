package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class blw extends avp {
    public int tlZ;
    public avw tob;
    public int tvL;
    public long tvM;
    public bku ulD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tob == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.ulD == null) {
                throw new b("Not all required fields were included: CmdList");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(3, this.tvL);
                if (this.tob != null) {
                    aVar.eQ(4, this.tob.aUk());
                    this.tob.a(aVar);
                }
                if (this.ulD != null) {
                    aVar.eQ(5, this.ulD.aUk());
                    this.ulD.a(aVar);
                }
                aVar.eO(7, this.tlZ);
                aVar.O(8, this.tvM);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(3, this.tvL);
            if (this.tob != null) {
                r0 += a.a.a.a.eN(4, this.tob.aUk());
            }
            if (this.ulD != null) {
                r0 += a.a.a.a.eN(5, this.ulD.aUk());
            }
            return (r0 + a.a.a.a.eL(7, this.tlZ)) + a.a.a.a.N(8, this.tvM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tob == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.ulD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CmdList");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            blw com_tencent_mm_protocal_c_blw = (blw) objArr[1];
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
                        com_tencent_mm_protocal_c_blw.tZe = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blw.tvL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blw.tob = enVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bku();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blw.ulD = enVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blw.tlZ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_blw.tvM = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
