package com.tencent.mm.plugin.collect.b;

import a.a.a.b;
import com.tencent.mm.bd.a;

public class q extends a {
    public String fFd;
    public String fTA;
    public String gMX;
    public double kBc;
    public int kBd;
    public String kBe;
    public int msgType;
    public int scene;
    public int status;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.fTA == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.fFd == null) {
                throw new b("Not all required fields were included: feeType");
            } else {
                if (this.username != null) {
                    aVar.e(1, this.username);
                }
                if (this.fTA != null) {
                    aVar.e(2, this.fTA);
                }
                aVar.a(3, this.kBc);
                if (this.fFd != null) {
                    aVar.e(4, this.fFd);
                }
                aVar.eO(5, this.kBd);
                aVar.eO(6, this.scene);
                aVar.eO(7, this.status);
                if (this.gMX != null) {
                    aVar.e(8, this.gMX);
                }
                if (this.kBe != null) {
                    aVar.e(9, this.kBe);
                }
                aVar.eO(10, this.msgType);
                return 0;
            }
        } else if (i == 1) {
            if (this.username != null) {
                r0 = a.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            if (this.fTA != null) {
                r0 += a.a.a.b.b.a.f(2, this.fTA);
            }
            r0 += a.a.a.b.b.a.cH(3) + 8;
            if (this.fFd != null) {
                r0 += a.a.a.b.b.a.f(4, this.fFd);
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.kBd)) + a.a.a.a.eL(6, this.scene)) + a.a.a.a.eL(7, this.status);
            if (this.gMX != null) {
                r0 += a.a.a.b.b.a.f(8, this.gMX);
            }
            if (this.kBe != null) {
                r0 += a.a.a.b.b.a.f(9, this.kBe);
            }
            return r0 + a.a.a.a.eL(10, this.msgType);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.fTA == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.fFd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: feeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.username = aVar3.xmD.readString();
                    return 0;
                case 2:
                    qVar.fTA = aVar3.xmD.readString();
                    return 0;
                case 3:
                    qVar.kBc = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    qVar.fFd = aVar3.xmD.readString();
                    return 0;
                case 5:
                    qVar.kBd = aVar3.xmD.mL();
                    return 0;
                case 6:
                    qVar.scene = aVar3.xmD.mL();
                    return 0;
                case 7:
                    qVar.status = aVar3.xmD.mL();
                    return 0;
                case 8:
                    qVar.gMX = aVar3.xmD.readString();
                    return 0;
                case 9:
                    qVar.kBe = aVar3.xmD.readString();
                    return 0;
                case 10:
                    qVar.msgType = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
