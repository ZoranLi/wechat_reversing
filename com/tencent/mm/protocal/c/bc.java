package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bc extends avh {
    public String bssid;
    public int cGa;
    public String hTm;
    public int scene;
    public String ssid;
    public be teA;
    public int teB;
    public String tek;
    public long tel;
    public int ten;
    public String tep;
    public int tey;
    public bb tez;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.hTm != null) {
                aVar.e(2, this.hTm);
            }
            aVar.eO(3, this.scene);
            aVar.eO(4, this.type);
            aVar.eO(5, this.tey);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.O(8, this.tel);
            if (this.tez != null) {
                aVar.eQ(9, this.tez.aUk());
                this.tez.a(aVar);
            }
            if (this.teA != null) {
                aVar.eQ(10, this.teA.aUk());
                this.teA.a(aVar);
            }
            aVar.eO(11, this.ten);
            if (this.tek != null) {
                aVar.e(12, this.tek);
            }
            aVar.eO(13, this.cGa);
            if (this.tep != null) {
                aVar.e(14, this.tep);
            }
            aVar.eO(15, this.teB);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.hTm != null) {
                r0 += a.a.a.b.b.a.f(2, this.hTm);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.scene)) + a.a.a.a.eL(4, this.type)) + a.a.a.a.eL(5, this.tey);
            if (this.ssid != null) {
                r0 += a.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                r0 += a.a.a.b.b.a.f(7, this.bssid);
            }
            r0 += a.a.a.a.N(8, this.tel);
            if (this.tez != null) {
                r0 += a.a.a.a.eN(9, this.tez.aUk());
            }
            if (this.teA != null) {
                r0 += a.a.a.a.eN(10, this.teA.aUk());
            }
            r0 += a.a.a.a.eL(11, this.ten);
            if (this.tek != null) {
                r0 += a.a.a.b.b.a.f(12, this.tek);
            }
            r0 += a.a.a.a.eL(13, this.cGa);
            if (this.tep != null) {
                r0 += a.a.a.b.b.a.f(14, this.tep);
            }
            return r0 + a.a.a.a.eL(15, this.teB);
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
            bc bcVar = (bc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        bcVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    bcVar.hTm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bcVar.scene = aVar3.xmD.mL();
                    return 0;
                case 4:
                    bcVar.type = aVar3.xmD.mL();
                    return 0;
                case 5:
                    bcVar.tey = aVar3.xmD.mL();
                    return 0;
                case 6:
                    bcVar.ssid = aVar3.xmD.readString();
                    return 0;
                case 7:
                    bcVar.bssid = aVar3.xmD.readString();
                    return 0;
                case 8:
                    bcVar.tel = aVar3.xmD.mM();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        bcVar.tez = emVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new be();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        bcVar.teA = emVar;
                    }
                    return 0;
                case 11:
                    bcVar.ten = aVar3.xmD.mL();
                    return 0;
                case 12:
                    bcVar.tek = aVar3.xmD.readString();
                    return 0;
                case 13:
                    bcVar.cGa = aVar3.xmD.mL();
                    return 0;
                case 14:
                    bcVar.tep = aVar3.xmD.readString();
                    return 0;
                case 15:
                    bcVar.teB = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
