package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bt extends a {
    public String mte;
    public bu mvt;
    public bu mvu;
    public bu mvv;
    public bu mvw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvt != null) {
                aVar.eQ(1, this.mvt.aUk());
                this.mvt.a(aVar);
            }
            if (this.mvu != null) {
                aVar.eQ(2, this.mvu.aUk());
                this.mvu.a(aVar);
            }
            if (this.mvv != null) {
                aVar.eQ(3, this.mvv.aUk());
                this.mvv.a(aVar);
            }
            if (this.mvw != null) {
                aVar.eQ(4, this.mvw.aUk());
                this.mvw.a(aVar);
            }
            if (this.mte == null) {
                return 0;
            }
            aVar.e(5, this.mte);
            return 0;
        } else if (i == 1) {
            if (this.mvt != null) {
                r0 = a.a.a.a.eN(1, this.mvt.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvu != null) {
                r0 += a.a.a.a.eN(2, this.mvu.aUk());
            }
            if (this.mvv != null) {
                r0 += a.a.a.a.eN(3, this.mvv.aUk());
            }
            if (this.mvw != null) {
                r0 += a.a.a.a.eN(4, this.mvw.aUk());
            }
            if (this.mte != null) {
                r0 += a.a.a.b.b.a.f(5, this.mte);
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
            bt btVar = (bt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a buVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        buVar = new bu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buVar.a(aVar4, buVar, a.a(aVar4))) {
                        }
                        btVar.mvt = buVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        buVar = new bu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buVar.a(aVar4, buVar, a.a(aVar4))) {
                        }
                        btVar.mvu = buVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        buVar = new bu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buVar.a(aVar4, buVar, a.a(aVar4))) {
                        }
                        btVar.mvv = buVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        buVar = new bu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buVar.a(aVar4, buVar, a.a(aVar4))) {
                        }
                        btVar.mvw = buVar;
                    }
                    return 0;
                case 5:
                    btVar.mte = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
