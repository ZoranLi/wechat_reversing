package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class hj extends avh {
    public int count;
    public int oTM;
    public String oVR;
    public String oVS;
    public int odt;
    public String tlu;
    public String tlv;
    public String tlw;
    public String tlx;
    public String tly;
    public String tlz;
    public int type;
    public String value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tlu != null) {
                aVar.e(2, this.tlu);
            }
            if (this.tlv != null) {
                aVar.e(3, this.tlv);
            }
            if (this.tlw != null) {
                aVar.e(4, this.tlw);
            }
            if (this.tlx != null) {
                aVar.e(5, this.tlx);
            }
            if (this.tly != null) {
                aVar.e(6, this.tly);
            }
            aVar.eO(7, this.oTM);
            if (this.tlz != null) {
                aVar.e(8, this.tlz);
            }
            if (this.oVS != null) {
                aVar.e(9, this.oVS);
            }
            if (this.oVR != null) {
                aVar.e(10, this.oVR);
            }
            aVar.eO(11, this.type);
            if (this.value != null) {
                aVar.e(12, this.value);
            }
            aVar.eO(13, this.count);
            aVar.eO(14, this.odt);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tlu != null) {
                r0 += a.a.a.b.b.a.f(2, this.tlu);
            }
            if (this.tlv != null) {
                r0 += a.a.a.b.b.a.f(3, this.tlv);
            }
            if (this.tlw != null) {
                r0 += a.a.a.b.b.a.f(4, this.tlw);
            }
            if (this.tlx != null) {
                r0 += a.a.a.b.b.a.f(5, this.tlx);
            }
            if (this.tly != null) {
                r0 += a.a.a.b.b.a.f(6, this.tly);
            }
            r0 += a.a.a.a.eL(7, this.oTM);
            if (this.tlz != null) {
                r0 += a.a.a.b.b.a.f(8, this.tlz);
            }
            if (this.oVS != null) {
                r0 += a.a.a.b.b.a.f(9, this.oVS);
            }
            if (this.oVR != null) {
                r0 += a.a.a.b.b.a.f(10, this.oVR);
            }
            r0 += a.a.a.a.eL(11, this.type);
            if (this.value != null) {
                r0 += a.a.a.b.b.a.f(12, this.value);
            }
            return (r0 + a.a.a.a.eL(13, this.count)) + a.a.a.a.eL(14, this.odt);
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
            hj hjVar = (hj) objArr[1];
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
                        hjVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    hjVar.tlu = aVar3.xmD.readString();
                    return 0;
                case 3:
                    hjVar.tlv = aVar3.xmD.readString();
                    return 0;
                case 4:
                    hjVar.tlw = aVar3.xmD.readString();
                    return 0;
                case 5:
                    hjVar.tlx = aVar3.xmD.readString();
                    return 0;
                case 6:
                    hjVar.tly = aVar3.xmD.readString();
                    return 0;
                case 7:
                    hjVar.oTM = aVar3.xmD.mL();
                    return 0;
                case 8:
                    hjVar.tlz = aVar3.xmD.readString();
                    return 0;
                case 9:
                    hjVar.oVS = aVar3.xmD.readString();
                    return 0;
                case 10:
                    hjVar.oVR = aVar3.xmD.readString();
                    return 0;
                case 11:
                    hjVar.type = aVar3.xmD.mL();
                    return 0;
                case 12:
                    hjVar.value = aVar3.xmD.readString();
                    return 0;
                case 13:
                    hjVar.count = aVar3.xmD.mL();
                    return 0;
                case 14:
                    hjVar.odt = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
