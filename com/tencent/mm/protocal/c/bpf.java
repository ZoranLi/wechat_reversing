package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bpf extends a {
    public String mtb;
    public bpc unH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.unH == null) {
                throw new b("Not all required fields were included: PkgConfig");
            } else {
                if (this.mtb != null) {
                    aVar.e(1, this.mtb);
                }
                if (this.unH == null) {
                    return 0;
                }
                aVar.eQ(2, this.unH.aUk());
                this.unH.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mtb != null) {
                r0 = a.a.a.b.b.a.f(1, this.mtb) + 0;
            } else {
                r0 = 0;
            }
            if (this.unH != null) {
                r0 += a.a.a.a.eN(2, this.unH.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mtb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.unH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: PkgConfig");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bpf com_tencent_mm_protocal_c_bpf = (bpf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bpf.mtb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bpc = new bpc();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bpc.a(aVar4, com_tencent_mm_protocal_c_bpc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bpf.unH = com_tencent_mm_protocal_c_bpc;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
