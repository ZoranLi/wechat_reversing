package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class yp extends a {
    public int tEV;
    public int tEW;
    public aen tjb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tjb == null) {
                throw new b("Not all required fields were included: Device");
            }
            aVar.eO(1, this.tEV);
            aVar.eO(2, this.tEW);
            if (this.tjb != null) {
                aVar.eQ(3, this.tjb.aUk());
                this.tjb.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.tEV) + 0) + a.a.a.a.eL(2, this.tEW);
            if (this.tjb != null) {
                return r0 + a.a.a.a.eN(3, this.tjb.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tjb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Device");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            yp ypVar = (yp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ypVar.tEV = aVar3.xmD.mL();
                    return 0;
                case 2:
                    ypVar.tEW = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aen = new aen();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aen.a(aVar4, com_tencent_mm_protocal_c_aen, a.a(aVar4))) {
                        }
                        ypVar.tjb = com_tencent_mm_protocal_c_aen;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
