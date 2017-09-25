package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class fm extends a {
    public String jNn;
    public int thX;
    public String tiU;
    public String tiZ;
    public ame tja;
    public aen tjb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.thX);
            if (this.tiZ != null) {
                aVar.e(2, this.tiZ);
            }
            if (this.tja != null) {
                aVar.eQ(3, this.tja.aUk());
                this.tja.a(aVar);
            }
            if (this.tiU != null) {
                aVar.e(4, this.tiU);
            }
            if (this.jNn != null) {
                aVar.e(5, this.jNn);
            }
            if (this.tjb != null) {
                aVar.eQ(6, this.tjb.aUk());
                this.tjb.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.thX) + 0;
            if (this.tiZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tiZ);
            }
            if (this.tja != null) {
                r0 += a.a.a.a.eN(3, this.tja.aUk());
            }
            if (this.tiU != null) {
                r0 += a.a.a.b.b.a.f(4, this.tiU);
            }
            if (this.jNn != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNn);
            }
            if (this.tjb != null) {
                return r0 + a.a.a.a.eN(6, this.tjb.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            fm fmVar = (fm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_ame;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fmVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    fmVar.tiZ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ame = new ame();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ame.a(aVar4, com_tencent_mm_protocal_c_ame, a.a(aVar4))) {
                        }
                        fmVar.tja = com_tencent_mm_protocal_c_ame;
                    }
                    return 0;
                case 4:
                    fmVar.tiU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    fmVar.jNn = aVar3.xmD.readString();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ame = new aen();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ame.a(aVar4, com_tencent_mm_protocal_c_ame, a.a(aVar4))) {
                        }
                        fmVar.tjb = com_tencent_mm_protocal_c_ame;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
