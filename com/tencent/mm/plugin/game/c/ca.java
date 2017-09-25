package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ca extends a {
    public g mvJ;
    public bz mvK;
    public bz mvL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvJ != null) {
                aVar.eQ(1, this.mvJ.aUk());
                this.mvJ.a(aVar);
            }
            if (this.mvK != null) {
                aVar.eQ(2, this.mvK.aUk());
                this.mvK.a(aVar);
            }
            if (this.mvL == null) {
                return 0;
            }
            aVar.eQ(3, this.mvL.aUk());
            this.mvL.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mvJ != null) {
                r0 = a.a.a.a.eN(1, this.mvJ.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvK != null) {
                r0 += a.a.a.a.eN(2, this.mvK.aUk());
            }
            if (this.mvL != null) {
                r0 += a.a.a.a.eN(3, this.mvL.aUk());
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
            ca caVar = (ca) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a gVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        gVar = new g();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        caVar.mvJ = gVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        gVar = new bz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        caVar.mvK = gVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        gVar = new bz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        caVar.mvL = gVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
