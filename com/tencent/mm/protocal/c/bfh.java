package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bfh extends a {
    public int state;
    public String trp;
    public LinkedList<bfg> ufO = new LinkedList();
    public int ufP;
    public int ufQ;
    public avl ufR;
    public int ufS;
    public LinkedList<bff> ufT = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.trp == null) {
                throw new b("Not all required fields were included: patchid");
            }
            if (this.trp != null) {
                aVar.e(1, this.trp);
            }
            aVar.eO(2, this.state);
            aVar.d(3, 8, this.ufO);
            aVar.eO(4, this.ufP);
            aVar.eO(5, this.ufQ);
            if (this.ufR != null) {
                aVar.eQ(6, this.ufR.aUk());
                this.ufR.a(aVar);
            }
            aVar.eO(7, this.ufS);
            aVar.d(8, 8, this.ufT);
            return 0;
        } else if (i == 1) {
            if (this.trp != null) {
                r0 = a.a.a.b.b.a.f(1, this.trp) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.eL(2, this.state)) + a.a.a.a.c(3, 8, this.ufO)) + a.a.a.a.eL(4, this.ufP)) + a.a.a.a.eL(5, this.ufQ);
            if (this.ufR != null) {
                r0 += a.a.a.a.eN(6, this.ufR.aUk());
            }
            return (r0 + a.a.a.a.eL(7, this.ufS)) + a.a.a.a.c(8, 8, this.ufT);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ufO.clear();
            this.ufT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.trp != null) {
                return 0;
            }
            throw new b("Not all required fields were included: patchid");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bfh com_tencent_mm_protocal_c_bfh = (bfh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_bfg;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bfh.trp = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfh.state = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bfg = new bfg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfg.a(aVar4, com_tencent_mm_protocal_c_bfg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfh.ufO.add(com_tencent_mm_protocal_c_bfg);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfh.ufP = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfh.ufQ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bfg = new avl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfg.a(aVar4, com_tencent_mm_protocal_c_bfg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfh.ufR = com_tencent_mm_protocal_c_bfg;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfh.ufS = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bfg = new bff();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfg.a(aVar4, com_tencent_mm_protocal_c_bfg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfh.ufT.add(com_tencent_mm_protocal_c_bfg);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
