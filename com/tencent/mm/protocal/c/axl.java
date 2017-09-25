package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class axl extends a {
    public int tZX;
    public int tZY;
    public int tZZ;
    public b tug;
    public int uaa;
    public int uab;
    public int uac;
    public int uad;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tug == null) {
                throw new a.a.a.b("Not all required fields were included: data");
            }
            aVar.eO(1, this.tZX);
            aVar.eO(2, this.tZY);
            aVar.eO(3, this.tZZ);
            aVar.eO(4, this.uaa);
            aVar.eO(5, this.uab);
            aVar.eO(6, this.uac);
            aVar.eO(7, this.uad);
            if (this.tug != null) {
                aVar.b(8, this.tug);
            }
            return 0;
        } else if (i == 1) {
            int eL = ((((((a.a.a.a.eL(1, this.tZX) + 0) + a.a.a.a.eL(2, this.tZY)) + a.a.a.a.eL(3, this.tZZ)) + a.a.a.a.eL(4, this.uaa)) + a.a.a.a.eL(5, this.uab)) + a.a.a.a.eL(6, this.uac)) + a.a.a.a.eL(7, this.uad);
            if (this.tug != null) {
                return eL + a.a.a.a.a(8, this.tug);
            }
            return eL;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cid();
                }
            }
            if (bArr != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axl com_tencent_mm_protocal_c_axl = (axl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_axl.tZX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axl.tZY = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axl.tZZ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axl.uaa = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axl.uab = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axl.uac = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axl.uad = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axl.tug = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
