package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bo extends a {
    public LinkedList<a> mvj = new LinkedList();
    public bv mvk;
    public LinkedList<j> mvl = new LinkedList();
    public bs mvm;
    public LinkedList<cd> mvn = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mvj);
            if (this.mvk != null) {
                aVar.eQ(2, this.mvk.aUk());
                this.mvk.a(aVar);
            }
            aVar.d(3, 8, this.mvl);
            if (this.mvm != null) {
                aVar.eQ(4, this.mvm.aUk());
                this.mvm.a(aVar);
            }
            aVar.d(5, 8, this.mvn);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.mvj) + 0;
            if (this.mvk != null) {
                r0 += a.a.a.a.eN(2, this.mvk.aUk());
            }
            r0 += a.a.a.a.c(3, 8, this.mvl);
            if (this.mvm != null) {
                r0 += a.a.a.a.eN(4, this.mvm.aUk());
            }
            return r0 + a.a.a.a.c(5, 8, this.mvn);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mvj.clear();
            this.mvl.clear();
            this.mvn.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bo boVar = (bo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a aVar4;
            a.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new a();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        boVar.mvj.add(aVar4);
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new bv();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        boVar.mvk = aVar4;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new j();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        boVar.mvl.add(aVar4);
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new bs();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        boVar.mvm = aVar4;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new cd();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        boVar.mvn.add(aVar4);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
