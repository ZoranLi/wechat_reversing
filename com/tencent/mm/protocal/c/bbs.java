package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bbs extends a {
    public int ucL;
    public bct ucM;
    public asx ucN;
    public nu ucO;
    public arf ucP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ucL);
            if (this.ucM != null) {
                aVar.eQ(2, this.ucM.aUk());
                this.ucM.a(aVar);
            }
            if (this.ucN != null) {
                aVar.eQ(3, this.ucN.aUk());
                this.ucN.a(aVar);
            }
            if (this.ucO != null) {
                aVar.eQ(4, this.ucO.aUk());
                this.ucO.a(aVar);
            }
            if (this.ucP != null) {
                aVar.eQ(5, this.ucP.aUk());
                this.ucP.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.ucL) + 0;
            if (this.ucM != null) {
                r0 += a.a.a.a.eN(2, this.ucM.aUk());
            }
            if (this.ucN != null) {
                r0 += a.a.a.a.eN(3, this.ucN.aUk());
            }
            if (this.ucO != null) {
                r0 += a.a.a.a.eN(4, this.ucO.aUk());
            }
            if (this.ucP != null) {
                return r0 + a.a.a.a.eN(5, this.ucP.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bbs com_tencent_mm_protocal_c_bbs = (bbs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bct;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bbs.ucL = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bct = new bct();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bct.a(aVar4, com_tencent_mm_protocal_c_bct, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbs.ucM = com_tencent_mm_protocal_c_bct;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bct = new asx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bct.a(aVar4, com_tencent_mm_protocal_c_bct, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbs.ucN = com_tencent_mm_protocal_c_bct;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bct = new nu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bct.a(aVar4, com_tencent_mm_protocal_c_bct, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbs.ucO = com_tencent_mm_protocal_c_bct;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bct = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bct.a(aVar4, com_tencent_mm_protocal_c_bct, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbs.ucP = com_tencent_mm_protocal_c_bct;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
