package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class b extends a {
    public int nettype;
    public int tao;
    public LinkedList<a> tap = new LinkedList();
    public int uin;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uin);
            aVar.eO(2, this.tao);
            aVar.d(3, 8, this.tap);
            aVar.eO(4, this.nettype);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.uin) + 0) + a.a.a.a.eL(2, this.tao)) + a.a.a.a.c(3, 8, this.tap)) + a.a.a.a.eL(4, this.nettype);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tap.clear();
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
                b bVar = (b) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bVar.uin = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        bVar.tao = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a aVar4 = new a();
                            a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                            }
                            bVar.tap.add(aVar4);
                        }
                        return 0;
                    case 4:
                        bVar.nettype = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
