package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bfs extends avp {
    public String fIA;
    public int fIz;
    public String uge;
    public String ugf;
    public baa ugg;
    public int version;

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
            aVar.eO(2, this.fIz);
            if (this.fIA != null) {
                aVar.e(3, this.fIA);
            }
            if (this.uge != null) {
                aVar.e(4, this.uge);
            }
            if (this.ugf != null) {
                aVar.e(5, this.ugf);
            }
            if (this.ugg != null) {
                aVar.eQ(6, this.ugg.aUk());
                this.ugg.a(aVar);
            }
            aVar.eO(7, this.version);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.fIz);
            if (this.fIA != null) {
                r0 += a.a.a.b.b.a.f(3, this.fIA);
            }
            if (this.uge != null) {
                r0 += a.a.a.b.b.a.f(4, this.uge);
            }
            if (this.ugf != null) {
                r0 += a.a.a.b.b.a.f(5, this.ugf);
            }
            if (this.ugg != null) {
                r0 += a.a.a.a.eN(6, this.ugg.aUk());
            }
            return r0 + a.a.a.a.eL(7, this.version);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
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
            bfs com_tencent_mm_protocal_c_bfs = (bfs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfs.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfs.fIz = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfs.fIA = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfs.uge = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfs.ugf = aVar3.xmD.readString();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new baa();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfs.ugg = enVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfs.version = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
