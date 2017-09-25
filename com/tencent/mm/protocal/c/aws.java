package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aws extends a {
    public String tDX;
    public aiz tOl;
    public int tZJ;
    public LinkedList<bin> tZK = new LinkedList();
    public int tdM;
    public long tlY;
    public int tll;
    public String tmb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tDX == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.O(1, this.tlY);
            if (this.tDX != null) {
                aVar.e(2, this.tDX);
            }
            aVar.eO(3, this.tll);
            if (this.tOl != null) {
                aVar.eQ(4, this.tOl.aUk());
                this.tOl.a(aVar);
            }
            aVar.eO(5, this.tZJ);
            aVar.d(6, 8, this.tZK);
            aVar.eO(7, this.tdM);
            if (this.tmb != null) {
                aVar.e(8, this.tmb);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.tlY) + 0;
            if (this.tDX != null) {
                r0 += a.a.a.b.b.a.f(2, this.tDX);
            }
            r0 += a.a.a.a.eL(3, this.tll);
            if (this.tOl != null) {
                r0 += a.a.a.a.eN(4, this.tOl.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.tZJ)) + a.a.a.a.c(6, 8, this.tZK)) + a.a.a.a.eL(7, this.tdM);
            if (this.tmb != null) {
                return r0 + a.a.a.b.b.a.f(8, this.tmb);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tZK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tDX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aws com_tencent_mm_protocal_c_aws = (aws) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_aiz;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aws.tlY = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aws.tDX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aws.tll = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new aiz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aws.tOl = com_tencent_mm_protocal_c_aiz;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aws.tZJ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new bin();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aws.tZK.add(com_tencent_mm_protocal_c_aiz);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aws.tdM = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aws.tmb = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
