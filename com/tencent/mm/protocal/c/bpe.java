package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bpe extends a {
    public String tAk;
    public String tAm;
    public bpd unz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tAk == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.tAm == null) {
                throw new b("Not all required fields were included: MimeType");
            } else if (this.unz == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else {
                if (this.tAk != null) {
                    aVar.e(1, this.tAk);
                }
                if (this.tAm != null) {
                    aVar.e(2, this.tAm);
                }
                if (this.unz == null) {
                    return 0;
                }
                aVar.eQ(3, this.unz.aUk());
                this.unz.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tAk != null) {
                r0 = a.a.a.b.b.a.f(1, this.tAk) + 0;
            } else {
                r0 = 0;
            }
            if (this.tAm != null) {
                r0 += a.a.a.b.b.a.f(2, this.tAm);
            }
            if (this.unz != null) {
                r0 += a.a.a.a.eN(3, this.unz.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tAk == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.tAm == null) {
                throw new b("Not all required fields were included: MimeType");
            } else if (this.unz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bpe com_tencent_mm_protocal_c_bpe = (bpe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bpe.tAk = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpe.tAm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bpd = new bpd();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bpd.a(aVar4, com_tencent_mm_protocal_c_bpd, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bpe.unz = com_tencent_mm_protocal_c_bpd;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
