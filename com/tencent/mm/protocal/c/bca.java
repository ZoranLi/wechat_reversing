package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bca extends a {
    public float aLh;
    public int quO;
    public float udh;
    public float udi;
    public float udj;
    public float udk;
    public int udl;
    public long udm;
    public long udn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.n(1, this.udh);
            aVar.n(2, this.udi);
            aVar.n(3, this.udj);
            aVar.n(4, this.udk);
            aVar.eO(5, this.udl);
            aVar.O(6, this.udm);
            aVar.O(7, this.udn);
            aVar.n(8, this.aLh);
            aVar.eO(9, this.quO);
            return 0;
        } else if (i == 1) {
            return (((((((((a.a.a.b.b.a.cH(1) + 4) + 0) + (a.a.a.b.b.a.cH(2) + 4)) + (a.a.a.b.b.a.cH(3) + 4)) + (a.a.a.b.b.a.cH(4) + 4)) + a.a.a.a.eL(5, this.udl)) + a.a.a.a.N(6, this.udm)) + a.a.a.a.N(7, this.udn)) + (a.a.a.b.b.a.cH(8) + 4)) + a.a.a.a.eL(9, this.quO);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                bca com_tencent_mm_protocal_c_bca = (bca) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bca.udh = aVar3.xmD.readFloat();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bca.udi = aVar3.xmD.readFloat();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bca.udj = aVar3.xmD.readFloat();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bca.udk = aVar3.xmD.readFloat();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_bca.udl = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_bca.udm = aVar3.xmD.mM();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_bca.udn = aVar3.xmD.mM();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_bca.aLh = aVar3.xmD.readFloat();
                        return 0;
                    case 9:
                        com_tencent_mm_protocal_c_bca.quO = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
