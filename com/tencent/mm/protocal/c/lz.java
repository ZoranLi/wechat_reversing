package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class lz extends a {
    public String kdH;
    public String kdI;
    public String ofg;
    public String title;
    public String tnY;
    public String tnZ;
    public long tpl;
    public String tpm;
    public String tpn;
    public ady tsh;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.kdH != null) {
                aVar.e(2, this.kdH);
            }
            if (this.kdI != null) {
                aVar.e(3, this.kdI);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.O(5, this.tpl);
            if (this.tpm != null) {
                aVar.e(6, this.tpm);
            }
            if (this.tpn != null) {
                aVar.e(7, this.tpn);
            }
            if (this.ofg != null) {
                aVar.e(8, this.ofg);
            }
            if (this.tsh != null) {
                aVar.eQ(9, this.tsh.aUk());
                this.tsh.a(aVar);
            }
            if (this.tnY != null) {
                aVar.e(10, this.tnY);
            }
            if (this.tnZ == null) {
                return 0;
            }
            aVar.e(11, this.tnZ);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.kdH != null) {
                r0 += a.a.a.b.b.a.f(2, this.kdH);
            }
            if (this.kdI != null) {
                r0 += a.a.a.b.b.a.f(3, this.kdI);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(4, this.url);
            }
            r0 += a.a.a.a.N(5, this.tpl);
            if (this.tpm != null) {
                r0 += a.a.a.b.b.a.f(6, this.tpm);
            }
            if (this.tpn != null) {
                r0 += a.a.a.b.b.a.f(7, this.tpn);
            }
            if (this.ofg != null) {
                r0 += a.a.a.b.b.a.f(8, this.ofg);
            }
            if (this.tsh != null) {
                r0 += a.a.a.a.eN(9, this.tsh.aUk());
            }
            if (this.tnY != null) {
                r0 += a.a.a.b.b.a.f(10, this.tnY);
            }
            if (this.tnZ != null) {
                r0 += a.a.a.b.b.a.f(11, this.tnZ);
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
            lz lzVar = (lz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lzVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    lzVar.kdH = aVar3.xmD.readString();
                    return 0;
                case 3:
                    lzVar.kdI = aVar3.xmD.readString();
                    return 0;
                case 4:
                    lzVar.url = aVar3.xmD.readString();
                    return 0;
                case 5:
                    lzVar.tpl = aVar3.xmD.mM();
                    return 0;
                case 6:
                    lzVar.tpm = aVar3.xmD.readString();
                    return 0;
                case 7:
                    lzVar.tpn = aVar3.xmD.readString();
                    return 0;
                case 8:
                    lzVar.ofg = aVar3.xmD.readString();
                    return 0;
                case 9:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_ady = new ady();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_ady.a(aVar4, com_tencent_mm_protocal_c_ady, a.a(aVar4))) {
                        }
                        lzVar.tsh = com_tencent_mm_protocal_c_ady;
                    }
                    return 0;
                case 10:
                    lzVar.tnY = aVar3.xmD.readString();
                    return 0;
                case 11:
                    lzVar.tnZ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
