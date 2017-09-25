package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bi extends a {
    public cg mvb;
    public bt mvc;
    public o mvd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvb != null) {
                aVar.eQ(1, this.mvb.aUk());
                this.mvb.a(aVar);
            }
            if (this.mvc != null) {
                aVar.eQ(2, this.mvc.aUk());
                this.mvc.a(aVar);
            }
            if (this.mvd == null) {
                return 0;
            }
            aVar.eQ(3, this.mvd.aUk());
            this.mvd.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mvb != null) {
                r0 = a.a.a.a.eN(1, this.mvb.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvc != null) {
                r0 += a.a.a.a.eN(2, this.mvc.aUk());
            }
            if (this.mvd != null) {
                r0 += a.a.a.a.eN(3, this.mvd.aUk());
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
            bi biVar = (bi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a cgVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        cgVar = new cg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgVar.a(aVar4, cgVar, a.a(aVar4))) {
                        }
                        biVar.mvb = cgVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        cgVar = new bt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgVar.a(aVar4, cgVar, a.a(aVar4))) {
                        }
                        biVar.mvc = cgVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        cgVar = new o();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgVar.a(aVar4, cgVar, a.a(aVar4))) {
                        }
                        biVar.mvd = cgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
