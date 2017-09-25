package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class boy extends a {
    public beo hPC;
    public String leO;
    public String tAN;
    public aiz tOl;
    public int tYD;
    public LinkedList<bin> tZK = new LinkedList();
    public int tdM;
    public long tlY;
    public int tll;
    public String tmb;
    public int umf;
    public int umg = 2;
    public String umj;
    public int unq;
    public String unr;
    public String uns;
    public int unt;
    public LinkedList<String> unu = new LinkedList();
    public LinkedList<ma> unv = new LinkedList();
    public LinkedList<anw> unw = new LinkedList();
    public b unx;
    public b uny;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tAN == null) {
                throw new a.a.a.b("Not all required fields were included: Keyword");
            }
            aVar.eO(1, this.tYD);
            if (this.tAN != null) {
                aVar.e(2, this.tAN);
            }
            aVar.eO(3, this.tll);
            aVar.O(4, this.tlY);
            aVar.eO(5, this.umf);
            if (this.tOl != null) {
                aVar.eQ(6, this.tOl.aUk());
                this.tOl.a(aVar);
            }
            aVar.d(7, 8, this.tZK);
            aVar.eO(8, this.tdM);
            if (this.tmb != null) {
                aVar.e(9, this.tmb);
            }
            aVar.eO(10, this.unq);
            if (this.unr != null) {
                aVar.e(11, this.unr);
            }
            if (this.uns != null) {
                aVar.e(12, this.uns);
            }
            aVar.eO(13, this.unt);
            aVar.d(14, 1, this.unu);
            aVar.eO(15, this.umg);
            if (this.hPC != null) {
                aVar.eQ(16, this.hPC.aUk());
                this.hPC.a(aVar);
            }
            aVar.d(17, 8, this.unv);
            aVar.d(18, 8, this.unw);
            if (this.leO != null) {
                aVar.e(19, this.leO);
            }
            if (this.unx != null) {
                aVar.b(20, this.unx);
            }
            if (this.umj != null) {
                aVar.e(21, this.umj);
            }
            if (this.uny != null) {
                aVar.b(22, this.uny);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tYD) + 0;
            if (this.tAN != null) {
                r0 += a.a.a.b.b.a.f(2, this.tAN);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.tll)) + a.a.a.a.N(4, this.tlY)) + a.a.a.a.eL(5, this.umf);
            if (this.tOl != null) {
                r0 += a.a.a.a.eN(6, this.tOl.aUk());
            }
            r0 = (r0 + a.a.a.a.c(7, 8, this.tZK)) + a.a.a.a.eL(8, this.tdM);
            if (this.tmb != null) {
                r0 += a.a.a.b.b.a.f(9, this.tmb);
            }
            r0 += a.a.a.a.eL(10, this.unq);
            if (this.unr != null) {
                r0 += a.a.a.b.b.a.f(11, this.unr);
            }
            if (this.uns != null) {
                r0 += a.a.a.b.b.a.f(12, this.uns);
            }
            r0 = ((r0 + a.a.a.a.eL(13, this.unt)) + a.a.a.a.c(14, 1, this.unu)) + a.a.a.a.eL(15, this.umg);
            if (this.hPC != null) {
                r0 += a.a.a.a.eN(16, this.hPC.aUk());
            }
            r0 = (r0 + a.a.a.a.c(17, 8, this.unv)) + a.a.a.a.c(18, 8, this.unw);
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(19, this.leO);
            }
            if (this.unx != null) {
                r0 += a.a.a.a.a(20, this.unx);
            }
            if (this.umj != null) {
                r0 += a.a.a.b.b.a.f(21, this.umj);
            }
            if (this.uny != null) {
                return r0 + a.a.a.a.a(22, this.uny);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tZK.clear();
            this.unu.clear();
            this.unv.clear();
            this.unw.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tAN != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Keyword");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            boy com_tencent_mm_protocal_c_boy = (boy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_aiz;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_boy.tYD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_boy.tAN = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_boy.tll = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_boy.tlY = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_boy.umf = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new aiz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_boy.tOl = com_tencent_mm_protocal_c_aiz;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new bin();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_boy.tZK.add(com_tencent_mm_protocal_c_aiz);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_boy.tdM = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_boy.tmb = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_boy.unq = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_boy.unr = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_boy.uns = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_boy.unt = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_boy.unu.add(aVar3.xmD.readString());
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_boy.umg = aVar3.xmD.mL();
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new beo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_boy.hPC = com_tencent_mm_protocal_c_aiz;
                    }
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new ma();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_boy.unv.add(com_tencent_mm_protocal_c_aiz);
                    }
                    return 0;
                case 18:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new anw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_boy.unw.add(com_tencent_mm_protocal_c_aiz);
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_boy.leO = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_boy.unx = aVar3.cic();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_boy.umj = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_boy.uny = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
