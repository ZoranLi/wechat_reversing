package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ax extends avh {
    public String bssid;
    public int cGa;
    public String hTm;
    public int hTp;
    public int scene;
    public String ssid;
    public String tek;
    public long tel;
    public bi tem;
    public int ten;
    public int teo;
    public String tep;

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
            aVar.eO(3, this.hTp);
            if (this.tek != null) {
                aVar.e(4, this.tek);
            }
            aVar.eO(5, this.scene);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.O(8, this.tel);
            if (this.tem != null) {
                aVar.eQ(9, this.tem.aUk());
                this.tem.a(aVar);
            }
            aVar.eO(10, this.ten);
            aVar.eO(11, this.teo);
            aVar.eO(12, this.cGa);
            if (this.tep == null) {
                return 0;
            }
            aVar.e(13, this.tep);
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
            r0 += a.a.a.a.eL(3, this.hTp);
            if (this.tek != null) {
                r0 += a.a.a.b.b.a.f(4, this.tek);
            }
            r0 += a.a.a.a.eL(5, this.scene);
            if (this.ssid != null) {
                r0 += a.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                r0 += a.a.a.b.b.a.f(7, this.bssid);
            }
            r0 += a.a.a.a.N(8, this.tel);
            if (this.tem != null) {
                r0 += a.a.a.a.eN(9, this.tem.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(10, this.ten)) + a.a.a.a.eL(11, this.teo)) + a.a.a.a.eL(12, this.cGa);
            if (this.tep != null) {
                r0 += a.a.a.b.b.a.f(13, this.tep);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ax axVar = (ax) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        axVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    axVar.hTm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    axVar.hTp = aVar3.xmD.mL();
                    return 0;
                case 4:
                    axVar.tek = aVar3.xmD.readString();
                    return 0;
                case 5:
                    axVar.scene = aVar3.xmD.mL();
                    return 0;
                case 6:
                    axVar.ssid = aVar3.xmD.readString();
                    return 0;
                case 7:
                    axVar.bssid = aVar3.xmD.readString();
                    return 0;
                case 8:
                    axVar.tel = aVar3.xmD.mM();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bi();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        axVar.tem = emVar;
                    }
                    return 0;
                case 10:
                    axVar.ten = aVar3.xmD.mL();
                    return 0;
                case 11:
                    axVar.teo = aVar3.xmD.mL();
                    return 0;
                case 12:
                    axVar.cGa = aVar3.xmD.mL();
                    return 0;
                case 13:
                    axVar.tep = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
