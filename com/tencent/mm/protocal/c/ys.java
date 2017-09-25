package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ys extends a {
    public int tEV;
    public int thX;
    public aen tjb;
    public String tuo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.thX);
            if (this.tjb != null) {
                aVar.eQ(2, this.tjb.aUk());
                this.tjb.a(aVar);
            }
            if (this.tuo != null) {
                aVar.e(3, this.tuo);
            }
            aVar.eO(4, this.tEV);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.thX) + 0;
            if (this.tjb != null) {
                r0 += a.a.a.a.eN(2, this.tjb.aUk());
            }
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuo);
            }
            return r0 + a.a.a.a.eL(4, this.tEV);
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
            ys ysVar = (ys) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ysVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aen = new aen();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aen.a(aVar4, com_tencent_mm_protocal_c_aen, a.a(aVar4))) {
                        }
                        ysVar.tjb = com_tencent_mm_protocal_c_aen;
                    }
                    return 0;
                case 3:
                    ysVar.tuo = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ysVar.tEV = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
