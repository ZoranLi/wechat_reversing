package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class age extends a {
    public String jNj;
    public int leD;
    public avx tLj;
    public int tLk;
    public String tjk;
    public String tsz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            }
            aVar.eO(1, this.leD);
            if (this.tLj != null) {
                aVar.eQ(2, this.tLj.aUk());
                this.tLj.a(aVar);
            }
            if (this.tjk != null) {
                aVar.e(3, this.tjk);
            }
            if (this.tsz != null) {
                aVar.e(4, this.tsz);
            }
            if (this.jNj != null) {
                aVar.e(5, this.jNj);
            }
            aVar.eO(6, this.tLk);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.leD) + 0;
            if (this.tLj != null) {
                r0 += a.a.a.a.eN(2, this.tLj.aUk());
            }
            if (this.tjk != null) {
                r0 += a.a.a.b.b.a.f(3, this.tjk);
            }
            if (this.tsz != null) {
                r0 += a.a.a.b.b.a.f(4, this.tsz);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNj);
            }
            return r0 + a.a.a.a.eL(6, this.tLk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tLj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: NickName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            age com_tencent_mm_protocal_c_age = (age) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_age.leD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avx = new avx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_age.tLj = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_age.tjk = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_age.tsz = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_age.jNj = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_age.tLk = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
