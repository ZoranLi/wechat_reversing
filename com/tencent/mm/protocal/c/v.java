package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class v extends avp {
    public int kAC = 268513600;
    public String kAD = "请求不成功，请稍候再试";
    public int state;
    public String tbC;
    public String tbG;
    public long tbH;
    public int tbI;
    public long tbJ;
    public int tbK;
    public int tbL;
    public int tbM;
    public int tbN;
    public long tbO;
    public long tbP;
    public long tbQ;
    public int tbR;
    public String tbS;
    public int tbT;
    public String tbh;
    public LinkedList<t> tbm = new LinkedList();
    public int tbs;
    public String title;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(2, this.kAC);
            if (this.kAD != null) {
                aVar.e(3, this.kAD);
            }
            if (this.tbh != null) {
                aVar.e(4, this.tbh);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            aVar.eO(6, this.type);
            if (this.tbG != null) {
                aVar.e(7, this.tbG);
            }
            aVar.O(8, this.tbH);
            aVar.eO(9, this.tbI);
            aVar.O(10, this.tbJ);
            aVar.eO(11, this.tbK);
            aVar.eO(12, this.state);
            aVar.eO(13, this.tbL);
            aVar.eO(14, this.tbM);
            aVar.eO(15, this.tbs);
            aVar.eO(16, this.tbN);
            aVar.O(17, this.tbO);
            aVar.O(18, this.tbP);
            aVar.O(19, this.tbQ);
            aVar.eO(20, this.tbR);
            if (this.tbC != null) {
                aVar.e(21, this.tbC);
            }
            aVar.d(22, 8, this.tbm);
            if (this.tbS != null) {
                aVar.e(23, this.tbS);
            }
            aVar.eO(24, this.tbT);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.kAC);
            if (this.kAD != null) {
                r0 += a.a.a.b.b.a.f(3, this.kAD);
            }
            if (this.tbh != null) {
                r0 += a.a.a.b.b.a.f(4, this.tbh);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(5, this.title);
            }
            r0 += a.a.a.a.eL(6, this.type);
            if (this.tbG != null) {
                r0 += a.a.a.b.b.a.f(7, this.tbG);
            }
            r0 = ((((((((((((r0 + a.a.a.a.N(8, this.tbH)) + a.a.a.a.eL(9, this.tbI)) + a.a.a.a.N(10, this.tbJ)) + a.a.a.a.eL(11, this.tbK)) + a.a.a.a.eL(12, this.state)) + a.a.a.a.eL(13, this.tbL)) + a.a.a.a.eL(14, this.tbM)) + a.a.a.a.eL(15, this.tbs)) + a.a.a.a.eL(16, this.tbN)) + a.a.a.a.N(17, this.tbO)) + a.a.a.a.N(18, this.tbP)) + a.a.a.a.N(19, this.tbQ)) + a.a.a.a.eL(20, this.tbR);
            if (this.tbC != null) {
                r0 += a.a.a.b.b.a.f(21, this.tbC);
            }
            r0 += a.a.a.a.c(22, 8, this.tbm);
            if (this.tbS != null) {
                r0 += a.a.a.b.b.a.f(23, this.tbS);
            }
            return r0 + a.a.a.a.eL(24, this.tbT);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tbm.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        vVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    vVar.kAC = aVar3.xmD.mL();
                    return 0;
                case 3:
                    vVar.kAD = aVar3.xmD.readString();
                    return 0;
                case 4:
                    vVar.tbh = aVar3.xmD.readString();
                    return 0;
                case 5:
                    vVar.title = aVar3.xmD.readString();
                    return 0;
                case 6:
                    vVar.type = aVar3.xmD.mL();
                    return 0;
                case 7:
                    vVar.tbG = aVar3.xmD.readString();
                    return 0;
                case 8:
                    vVar.tbH = aVar3.xmD.mM();
                    return 0;
                case 9:
                    vVar.tbI = aVar3.xmD.mL();
                    return 0;
                case 10:
                    vVar.tbJ = aVar3.xmD.mM();
                    return 0;
                case 11:
                    vVar.tbK = aVar3.xmD.mL();
                    return 0;
                case 12:
                    vVar.state = aVar3.xmD.mL();
                    return 0;
                case 13:
                    vVar.tbL = aVar3.xmD.mL();
                    return 0;
                case 14:
                    vVar.tbM = aVar3.xmD.mL();
                    return 0;
                case 15:
                    vVar.tbs = aVar3.xmD.mL();
                    return 0;
                case 16:
                    vVar.tbN = aVar3.xmD.mL();
                    return 0;
                case 17:
                    vVar.tbO = aVar3.xmD.mM();
                    return 0;
                case 18:
                    vVar.tbP = aVar3.xmD.mM();
                    return 0;
                case 19:
                    vVar.tbQ = aVar3.xmD.mM();
                    return 0;
                case 20:
                    vVar.tbR = aVar3.xmD.mL();
                    return 0;
                case 21:
                    vVar.tbC = aVar3.xmD.readString();
                    return 0;
                case 22:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new t();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        vVar.tbm.add(enVar);
                    }
                    return 0;
                case 23:
                    vVar.tbS = aVar3.xmD.readString();
                    return 0;
                case 24:
                    vVar.tbT = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
