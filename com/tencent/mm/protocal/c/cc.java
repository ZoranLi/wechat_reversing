package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class cc extends a {
    public String mtJ;
    public dl tfy;
    public LinkedList<aeg> tfz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfy == null) {
                throw new b("Not all required fields were included: ArtisAuthor");
            }
            if (this.tfy != null) {
                aVar.eQ(1, this.tfy.aUk());
                this.tfy.a(aVar);
            }
            aVar.d(2, 8, this.tfz);
            if (this.mtJ == null) {
                return 0;
            }
            aVar.e(3, this.mtJ);
            return 0;
        } else if (i == 1) {
            if (this.tfy != null) {
                r0 = a.a.a.a.eN(1, this.tfy.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.tfz);
            if (this.mtJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mtJ);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tfz.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisAuthor");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a dlVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        dlVar = new dl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        ccVar.tfy = dlVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        dlVar = new aeg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        ccVar.tfz.add(dlVar);
                    }
                    return 0;
                case 3:
                    ccVar.mtJ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
