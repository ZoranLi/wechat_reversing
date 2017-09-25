package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ani extends a {
    public LinkedList<String> tSk = new LinkedList();
    public LinkedList<String> tSl = new LinkedList();
    public LinkedList<String> tSm = new LinkedList();
    public LinkedList<String> tSn = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(5, 1, this.tSk);
            aVar.d(6, 1, this.tSl);
            aVar.d(7, 1, this.tSm);
            aVar.d(8, 1, this.tSn);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.c(5, 1, this.tSk) + 0) + a.a.a.a.c(6, 1, this.tSl)) + a.a.a.a.c(7, 1, this.tSm)) + a.a.a.a.c(8, 1, this.tSn);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.tSk.clear();
                this.tSl.clear();
                this.tSm.clear();
                this.tSn.clear();
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
                ani com_tencent_mm_protocal_c_ani = (ani) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 5:
                        com_tencent_mm_protocal_c_ani.tSk.add(aVar3.xmD.readString());
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_ani.tSl.add(aVar3.xmD.readString());
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_ani.tSm.add(aVar3.xmD.readString());
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_ani.tSn.add(aVar3.xmD.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
