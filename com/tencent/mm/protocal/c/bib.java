package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bib extends avh {
    public int aLM;
    public double altitude;
    public double latitude;
    public double longitude;
    public double uhx;
    public double uhy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.a(2, this.latitude);
            aVar.a(3, this.longitude);
            aVar.a(4, this.altitude);
            aVar.a(5, this.uhx);
            aVar.a(6, this.uhy);
            aVar.eO(7, this.aLM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + (a.a.a.b.b.a.cH(2) + 8)) + (a.a.a.b.b.a.cH(3) + 8)) + (a.a.a.b.b.a.cH(4) + 8)) + (a.a.a.b.b.a.cH(5) + 8)) + (a.a.a.b.b.a.cH(6) + 8)) + a.a.a.a.eL(7, this.aLM);
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
            bib com_tencent_mm_protocal_c_bib = (bib) objArr[1];
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
                        com_tencent_mm_protocal_c_bib.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bib.latitude = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bib.longitude = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bib.altitude = aVar3.xmD.readDouble();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bib.uhx = aVar3.xmD.readDouble();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bib.uhy = aVar3.xmD.readDouble();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bib.aLM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
