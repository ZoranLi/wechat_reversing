package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class anv extends a {
    public long lastUpdateTime;
    public LinkedList<is> tsY = new LinkedList();
    public int tsZ;
    public int tta;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.tsY);
            aVar.eO(2, this.version);
            aVar.eO(3, this.tsZ);
            aVar.eO(4, this.tta);
            aVar.O(5, this.lastUpdateTime);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.c(1, 8, this.tsY) + 0) + a.a.a.a.eL(2, this.version)) + a.a.a.a.eL(3, this.tsZ)) + a.a.a.a.eL(4, this.tta)) + a.a.a.a.N(5, this.lastUpdateTime);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tsY.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
                anv com_tencent_mm_protocal_c_anv = (anv) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a isVar = new is();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = isVar.a(aVar4, isVar, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_anv.tsY.add(isVar);
                        }
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_anv.version = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_anv.tsZ = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_anv.tta = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_anv.lastUpdateTime = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
