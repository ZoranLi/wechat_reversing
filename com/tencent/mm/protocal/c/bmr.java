package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bmr extends avh {
    public int jOc;
    public String tDX;
    public int tVQ;
    public int tll;
    public String tmb;
    public int umf;
    public int umg = 2;
    public double umh;
    public double umi;
    public String umj;
    public String umk;
    public String uml;
    public String umm;
    public int umn;
    public String umo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tDX != null) {
                aVar.e(2, this.tDX);
            }
            aVar.eO(3, this.tll);
            aVar.eO(4, this.umf);
            if (this.tmb != null) {
                aVar.e(5, this.tmb);
            }
            aVar.eO(6, this.umg);
            aVar.a(7, this.umh);
            aVar.a(8, this.umi);
            aVar.eO(9, this.jOc);
            aVar.eO(10, this.tVQ);
            if (this.umj != null) {
                aVar.e(99, this.umj);
            }
            if (this.umk != null) {
                aVar.e(100, this.umk);
            }
            if (this.uml != null) {
                aVar.e(101, this.uml);
            }
            if (this.umm != null) {
                aVar.e(102, this.umm);
            }
            aVar.eO(103, this.umn);
            if (this.umo == null) {
                return 0;
            }
            aVar.e(104, this.umo);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tDX != null) {
                r0 += a.a.a.b.b.a.f(2, this.tDX);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tll)) + a.a.a.a.eL(4, this.umf);
            if (this.tmb != null) {
                r0 += a.a.a.b.b.a.f(5, this.tmb);
            }
            r0 = ((((r0 + a.a.a.a.eL(6, this.umg)) + (a.a.a.b.b.a.cH(7) + 8)) + (a.a.a.b.b.a.cH(8) + 8)) + a.a.a.a.eL(9, this.jOc)) + a.a.a.a.eL(10, this.tVQ);
            if (this.umj != null) {
                r0 += a.a.a.b.b.a.f(99, this.umj);
            }
            if (this.umk != null) {
                r0 += a.a.a.b.b.a.f(100, this.umk);
            }
            if (this.uml != null) {
                r0 += a.a.a.b.b.a.f(101, this.uml);
            }
            if (this.umm != null) {
                r0 += a.a.a.b.b.a.f(102, this.umm);
            }
            r0 += a.a.a.a.eL(103, this.umn);
            if (this.umo != null) {
                r0 += a.a.a.b.b.a.f(104, this.umo);
            }
            return r0;
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
            bmr com_tencent_mm_protocal_c_bmr = (bmr) objArr[1];
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
                        com_tencent_mm_protocal_c_bmr.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmr.tDX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bmr.tll = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bmr.umf = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bmr.tmb = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bmr.umg = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bmr.umh = aVar3.xmD.readDouble();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bmr.umi = aVar3.xmD.readDouble();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bmr.jOc = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bmr.tVQ = aVar3.xmD.mL();
                    return 0;
                case 99:
                    com_tencent_mm_protocal_c_bmr.umj = aVar3.xmD.readString();
                    return 0;
                case 100:
                    com_tencent_mm_protocal_c_bmr.umk = aVar3.xmD.readString();
                    return 0;
                case 101:
                    com_tencent_mm_protocal_c_bmr.uml = aVar3.xmD.readString();
                    return 0;
                case 102:
                    com_tencent_mm_protocal_c_bmr.umm = aVar3.xmD.readString();
                    return 0;
                case 103:
                    com_tencent_mm_protocal_c_bmr.umn = aVar3.xmD.mL();
                    return 0;
                case 104:
                    com_tencent_mm_protocal_c_bmr.umo = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
