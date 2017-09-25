package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bfe extends a {
    public String arH;
    public String oQo;
    public LinkedList<String> ufM = new LinkedList();
    public String value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.arH == null) {
                throw new b("Not all required fields were included: key");
            } else if (this.value == null) {
                throw new b("Not all required fields were included: value");
            } else {
                if (this.arH != null) {
                    aVar.e(1, this.arH);
                }
                if (this.value != null) {
                    aVar.e(2, this.value);
                }
                if (this.oQo != null) {
                    aVar.e(3, this.oQo);
                }
                aVar.d(4, 1, this.ufM);
                return 0;
            }
        } else if (i == 1) {
            if (this.arH != null) {
                r0 = a.a.a.b.b.a.f(1, this.arH) + 0;
            } else {
                r0 = 0;
            }
            if (this.value != null) {
                r0 += a.a.a.b.b.a.f(2, this.value);
            }
            if (this.oQo != null) {
                r0 += a.a.a.b.b.a.f(3, this.oQo);
            }
            return r0 + a.a.a.a.c(4, 1, this.ufM);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.ufM.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.arH == null) {
                throw new b("Not all required fields were included: key");
            } else if (this.value != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: value");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bfe com_tencent_mm_protocal_c_bfe = (bfe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bfe.arH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfe.value = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfe.oQo = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfe.ufM.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
