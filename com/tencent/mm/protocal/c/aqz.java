package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aqz extends avp {
    public String content;
    public String kft;
    public boolean kga;
    public int status;
    public String tVr;
    public String tVs;
    public String tVt;
    public String tVu;
    public String tcY;
    public String tcZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            if (this.tcY != null) {
                aVar.e(2, this.tcY);
            }
            if (this.tcZ != null) {
                aVar.e(3, this.tcZ);
            }
            aVar.eO(4, this.status);
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            if (this.kft != null) {
                aVar.e(6, this.kft);
            }
            if (this.tVr != null) {
                aVar.e(7, this.tVr);
            }
            aVar.an(8, this.kga);
            if (this.tVs != null) {
                aVar.e(9, this.tVs);
            }
            if (this.tVt != null) {
                aVar.e(10, this.tVt);
            }
            if (this.tVu == null) {
                return 0;
            }
            aVar.e(11, this.tVu);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tcY != null) {
                r0 += a.a.a.b.b.a.f(2, this.tcY);
            }
            if (this.tcZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.tcZ);
            }
            r0 += a.a.a.a.eL(4, this.status);
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(5, this.content);
            }
            if (this.kft != null) {
                r0 += a.a.a.b.b.a.f(6, this.kft);
            }
            if (this.tVr != null) {
                r0 += a.a.a.b.b.a.f(7, this.tVr);
            }
            r0 += a.a.a.b.b.a.cH(8) + 1;
            if (this.tVs != null) {
                r0 += a.a.a.b.b.a.f(9, this.tVs);
            }
            if (this.tVt != null) {
                r0 += a.a.a.b.b.a.f(10, this.tVt);
            }
            if (this.tVu != null) {
                r0 += a.a.a.b.b.a.f(11, this.tVu);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aqz com_tencent_mm_protocal_c_aqz = (aqz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqz.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqz.tcY = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqz.tcZ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqz.status = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqz.content = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqz.kft = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqz.tVr = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqz.kga = aVar3.cib();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqz.tVs = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqz.tVt = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqz.tVu = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
