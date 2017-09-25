package com.tencent.mm.plugin.location.a;

import a.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    public LinkedList<String> fPA = new LinkedList();
    public double latitude;
    public double longitude;
    public String naK;
    public long timestamp;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.d(2, 1, this.fPA);
            aVar.a(3, this.longitude);
            aVar.a(4, this.latitude);
            if (this.naK != null) {
                aVar.e(5, this.naK);
            }
            aVar.O(6, this.timestamp);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = a.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.c(2, 1, this.fPA)) + (a.a.a.b.b.a.cH(3) + 8)) + (a.a.a.b.b.a.cH(4) + 8);
            if (this.naK != null) {
                r0 += a.a.a.b.b.a.f(5, this.naK);
            }
            return r0 + a.a.a.a.N(6, this.timestamp);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.fPA.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.username = aVar3.xmD.readString();
                    return 0;
                case 2:
                    aVar4.fPA.add(aVar3.xmD.readString());
                    return 0;
                case 3:
                    aVar4.longitude = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    aVar4.latitude = aVar3.xmD.readDouble();
                    return 0;
                case 5:
                    aVar4.naK = aVar3.xmD.readString();
                    return 0;
                case 6:
                    aVar4.timestamp = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
