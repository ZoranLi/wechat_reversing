package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class cb extends a {
    public String tfw;
    public LinkedList<bdo> tfx = new LinkedList();
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfw != null) {
                aVar.e(1, this.tfw);
            }
            aVar.d(2, 8, this.tfx);
            if (this.title == null) {
                return 0;
            }
            aVar.e(3, this.title);
            return 0;
        } else if (i == 1) {
            if (this.tfw != null) {
                r0 = a.a.a.b.b.a.f(1, this.tfw) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.tfx);
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(3, this.title);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tfx.clear();
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
            cb cbVar = (cb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbVar.tfw = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bdo = new bdo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        cbVar.tfx.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 3:
                    cbVar.title = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
