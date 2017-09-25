package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class y extends a {
    public bd mtv;
    public bd mtw;
    public bd mtx;
    public cb mty;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtv != null) {
                aVar.eQ(1, this.mtv.aUk());
                this.mtv.a(aVar);
            }
            if (this.mtw != null) {
                aVar.eQ(2, this.mtw.aUk());
                this.mtw.a(aVar);
            }
            if (this.mtx != null) {
                aVar.eQ(3, this.mtx.aUk());
                this.mtx.a(aVar);
            }
            if (this.mty == null) {
                return 0;
            }
            aVar.eQ(4, this.mty.aUk());
            this.mty.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mtv != null) {
                r0 = a.a.a.a.eN(1, this.mtv.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtw != null) {
                r0 += a.a.a.a.eN(2, this.mtw.aUk());
            }
            if (this.mtx != null) {
                r0 += a.a.a.a.eN(3, this.mtx.aUk());
            }
            if (this.mty != null) {
                r0 += a.a.a.a.eN(4, this.mty.aUk());
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
            y yVar = (y) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a bdVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bdVar = new bd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdVar.a(aVar4, bdVar, a.a(aVar4))) {
                        }
                        yVar.mtv = bdVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bdVar = new bd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdVar.a(aVar4, bdVar, a.a(aVar4))) {
                        }
                        yVar.mtw = bdVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bdVar = new bd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdVar.a(aVar4, bdVar, a.a(aVar4))) {
                        }
                        yVar.mtx = bdVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bdVar = new cb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdVar.a(aVar4, bdVar, a.a(aVar4))) {
                        }
                        yVar.mty = bdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
