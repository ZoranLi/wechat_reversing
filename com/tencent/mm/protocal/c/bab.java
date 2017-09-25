package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bab extends a {
    public LinkedList<String> ubk = new LinkedList();
    public LinkedList<String> ubl = new LinkedList();
    public LinkedList<Integer> ubm = new LinkedList();
    public LinkedList<Integer> ubn = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.ubk);
            aVar.d(2, 1, this.ubl);
            aVar.d(3, 2, this.ubm);
            aVar.d(4, 2, this.ubn);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.c(1, 1, this.ubk) + 0) + a.a.a.a.c(2, 1, this.ubl)) + a.a.a.a.c(3, 2, this.ubm)) + a.a.a.a.c(4, 2, this.ubn);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.ubk.clear();
                this.ubl.clear();
                this.ubm.clear();
                this.ubn.clear();
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
                bab com_tencent_mm_protocal_c_bab = (bab) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bab.ubk.add(aVar3.xmD.readString());
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bab.ubl.add(aVar3.xmD.readString());
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bab.ubm.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bab.ubn.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
