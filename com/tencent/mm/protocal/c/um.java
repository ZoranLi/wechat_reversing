package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class um extends avh {
    public String kdE;
    public String kdK;
    public b kge;
    public int knM;
    public String knN;
    public String knO;
    public String knP;
    public String knQ;
    public int tCp;
    public int time_stamp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.kdK != null) {
                aVar.e(2, this.kdK);
            }
            aVar.eO(3, this.knM);
            if (this.knN != null) {
                aVar.e(4, this.knN);
            }
            if (this.knO != null) {
                aVar.e(5, this.knO);
            }
            aVar.eO(6, this.time_stamp);
            if (this.knP != null) {
                aVar.e(7, this.knP);
            }
            if (this.kdE != null) {
                aVar.e(8, this.kdE);
            }
            if (this.knQ != null) {
                aVar.e(9, this.knQ);
            }
            if (this.kge != null) {
                aVar.b(10, this.kge);
            }
            aVar.eO(11, this.tCp);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.kdK != null) {
                r0 += a.a.a.b.b.a.f(2, this.kdK);
            }
            r0 += a.a.a.a.eL(3, this.knM);
            if (this.knN != null) {
                r0 += a.a.a.b.b.a.f(4, this.knN);
            }
            if (this.knO != null) {
                r0 += a.a.a.b.b.a.f(5, this.knO);
            }
            r0 += a.a.a.a.eL(6, this.time_stamp);
            if (this.knP != null) {
                r0 += a.a.a.b.b.a.f(7, this.knP);
            }
            if (this.kdE != null) {
                r0 += a.a.a.b.b.a.f(8, this.kdE);
            }
            if (this.knQ != null) {
                r0 += a.a.a.b.b.a.f(9, this.knQ);
            }
            if (this.kge != null) {
                r0 += a.a.a.a.a(10, this.kge);
            }
            return r0 + a.a.a.a.eL(11, this.tCp);
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
            um umVar = (um) objArr[1];
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
                        umVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    umVar.kdK = aVar3.xmD.readString();
                    return 0;
                case 3:
                    umVar.knM = aVar3.xmD.mL();
                    return 0;
                case 4:
                    umVar.knN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    umVar.knO = aVar3.xmD.readString();
                    return 0;
                case 6:
                    umVar.time_stamp = aVar3.xmD.mL();
                    return 0;
                case 7:
                    umVar.knP = aVar3.xmD.readString();
                    return 0;
                case 8:
                    umVar.kdE = aVar3.xmD.readString();
                    return 0;
                case 9:
                    umVar.knQ = aVar3.xmD.readString();
                    return 0;
                case 10:
                    umVar.kge = aVar3.cic();
                    return 0;
                case 11:
                    umVar.tCp = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
