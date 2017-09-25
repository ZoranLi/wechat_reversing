package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class dj extends a {
    public String fGV;
    public String hNk;
    public String tgQ;
    public LinkedList<String> tgR = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgQ == null) {
                throw new b("Not all required fields were included: roomname");
            }
            if (this.tgQ != null) {
                aVar.e(1, this.tgQ);
            }
            if (this.fGV != null) {
                aVar.e(2, this.fGV);
            }
            if (this.hNk != null) {
                aVar.e(3, this.hNk);
            }
            aVar.d(4, 1, this.tgR);
            return 0;
        } else if (i == 1) {
            if (this.tgQ != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgQ) + 0;
            } else {
                r0 = 0;
            }
            if (this.fGV != null) {
                r0 += a.a.a.b.b.a.f(2, this.fGV);
            }
            if (this.hNk != null) {
                r0 += a.a.a.b.b.a.f(3, this.hNk);
            }
            return r0 + a.a.a.a.c(4, 1, this.tgR);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.tgR.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgQ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: roomname");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dj djVar = (dj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    djVar.tgQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    djVar.fGV = aVar3.xmD.readString();
                    return 0;
                case 3:
                    djVar.hNk = aVar3.xmD.readString();
                    return 0;
                case 4:
                    djVar.tgR.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
