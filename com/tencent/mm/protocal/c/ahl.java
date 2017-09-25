package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ahl extends a {
    public String scope;
    public int tLU;
    public String tLV;
    public LinkedList<String> tLW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            aVar.eO(2, this.tLU);
            if (this.tLV != null) {
                aVar.e(3, this.tLV);
            }
            aVar.d(4, 1, this.tLW);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                r0 = a.a.a.b.b.a.f(1, this.scope) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tLU);
            if (this.tLV != null) {
                r0 += a.a.a.b.b.a.f(3, this.tLV);
            }
            return r0 + a.a.a.a.c(4, 1, this.tLW);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.tLW.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            ahl com_tencent_mm_protocal_c_ahl = (ahl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ahl.scope = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahl.tLU = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahl.tLV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahl.tLW.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
