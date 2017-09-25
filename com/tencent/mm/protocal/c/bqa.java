package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bqa extends a {
    public String msG;
    public String teQ;
    public int uod;
    public bai uoe;
    public cx uof;
    public ani uog;
    public cm uoh;
    public cw uoi;
    public cq uoj;
    public LinkedList<je> uok = new LinkedList();
    public String uol;
    public String uom;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.teQ != null) {
                aVar.e(1, this.teQ);
            }
            aVar.eO(2, this.uod);
            if (this.msG != null) {
                aVar.e(3, this.msG);
            }
            if (this.uoe != null) {
                aVar.eQ(4, this.uoe.aUk());
                this.uoe.a(aVar);
            }
            if (this.uof != null) {
                aVar.eQ(5, this.uof.aUk());
                this.uof.a(aVar);
            }
            if (this.uog != null) {
                aVar.eQ(6, this.uog.aUk());
                this.uog.a(aVar);
            }
            if (this.uoh != null) {
                aVar.eQ(7, this.uoh.aUk());
                this.uoh.a(aVar);
            }
            if (this.uoi != null) {
                aVar.eQ(8, this.uoi.aUk());
                this.uoi.a(aVar);
            }
            if (this.uoj != null) {
                aVar.eQ(11, this.uoj.aUk());
                this.uoj.a(aVar);
            }
            aVar.d(12, 8, this.uok);
            if (this.uol != null) {
                aVar.e(13, this.uol);
            }
            if (this.uom == null) {
                return 0;
            }
            aVar.e(14, this.uom);
            return 0;
        } else if (i == 1) {
            if (this.teQ != null) {
                r0 = a.a.a.b.b.a.f(1, this.teQ) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.uod);
            if (this.msG != null) {
                r0 += a.a.a.b.b.a.f(3, this.msG);
            }
            if (this.uoe != null) {
                r0 += a.a.a.a.eN(4, this.uoe.aUk());
            }
            if (this.uof != null) {
                r0 += a.a.a.a.eN(5, this.uof.aUk());
            }
            if (this.uog != null) {
                r0 += a.a.a.a.eN(6, this.uog.aUk());
            }
            if (this.uoh != null) {
                r0 += a.a.a.a.eN(7, this.uoh.aUk());
            }
            if (this.uoi != null) {
                r0 += a.a.a.a.eN(8, this.uoi.aUk());
            }
            if (this.uoj != null) {
                r0 += a.a.a.a.eN(11, this.uoj.aUk());
            }
            r0 += a.a.a.a.c(12, 8, this.uok);
            if (this.uol != null) {
                r0 += a.a.a.b.b.a.f(13, this.uol);
            }
            if (this.uom != null) {
                r0 += a.a.a.b.b.a.f(14, this.uom);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uok.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bqa com_tencent_mm_protocal_c_bqa = (bqa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_bai;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bqa.teQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqa.uod = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqa.msG = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bai = new bai();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bai.a(aVar4, com_tencent_mm_protocal_c_bai, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqa.uoe = com_tencent_mm_protocal_c_bai;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bai = new cx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bai.a(aVar4, com_tencent_mm_protocal_c_bai, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqa.uof = com_tencent_mm_protocal_c_bai;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bai = new ani();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bai.a(aVar4, com_tencent_mm_protocal_c_bai, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqa.uog = com_tencent_mm_protocal_c_bai;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bai = new cm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bai.a(aVar4, com_tencent_mm_protocal_c_bai, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqa.uoh = com_tencent_mm_protocal_c_bai;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bai = new cw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bai.a(aVar4, com_tencent_mm_protocal_c_bai, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqa.uoi = com_tencent_mm_protocal_c_bai;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bai = new cq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bai.a(aVar4, com_tencent_mm_protocal_c_bai, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqa.uoj = com_tencent_mm_protocal_c_bai;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bai = new je();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bai.a(aVar4, com_tencent_mm_protocal_c_bai, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqa.uok.add(com_tencent_mm_protocal_c_bai);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bqa.uol = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bqa.uom = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
