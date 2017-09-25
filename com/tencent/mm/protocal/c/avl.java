package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class avl extends a {
    public String msN;
    public int tYY;
    public int tYZ;
    public LinkedList<baf> tZa = new LinkedList();
    public String tZb;
    public int tsR;
    public b tug;
    public String tuy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tuy == null) {
                throw new a.a.a.b("Not all required fields were included: MD5");
            } else if (this.msN == null) {
                throw new a.a.a.b("Not all required fields were included: Url");
            } else if (this.tZb == null) {
                throw new a.a.a.b("Not all required fields were included: OriginalMD5");
            } else {
                if (this.tuy != null) {
                    aVar.e(1, this.tuy);
                }
                aVar.eO(2, this.tYY);
                if (this.msN != null) {
                    aVar.e(3, this.msN);
                }
                aVar.eO(4, this.tYZ);
                aVar.d(5, 8, this.tZa);
                if (this.tug != null) {
                    aVar.b(6, this.tug);
                }
                if (this.tZb != null) {
                    aVar.e(7, this.tZb);
                }
                aVar.eO(8, this.tsR);
                return 0;
            }
        } else if (i == 1) {
            if (this.tuy != null) {
                r0 = a.a.a.b.b.a.f(1, this.tuy) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tYY);
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(3, this.msN);
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tYZ)) + a.a.a.a.c(5, 8, this.tZa);
            if (this.tug != null) {
                r0 += a.a.a.a.a(6, this.tug);
            }
            if (this.tZb != null) {
                r0 += a.a.a.b.b.a.f(7, this.tZb);
            }
            return r0 + a.a.a.a.eL(8, this.tsR);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tZa.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tuy == null) {
                throw new a.a.a.b("Not all required fields were included: MD5");
            } else if (this.msN == null) {
                throw new a.a.a.b("Not all required fields were included: Url");
            } else if (this.tZb != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: OriginalMD5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            avl com_tencent_mm_protocal_c_avl = (avl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_avl.tuy = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avl.tYY = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avl.msN = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avl.tYZ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_baf = new baf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_baf.a(aVar4, com_tencent_mm_protocal_c_baf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avl.tZa.add(com_tencent_mm_protocal_c_baf);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avl.tug = aVar3.cic();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avl.tZb = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avl.tsR = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
