package com.tencent.mm.storage;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ag extends a {
    public int uJg;
    public LinkedList<Integer> uJh = new LinkedList();
    public LinkedList<Integer> uJi = new LinkedList();
    public LinkedList<Integer> uJj = new LinkedList();
    public LinkedList<Long> uJk = new LinkedList();
    public LinkedList<Long> uJl = new LinkedList();
    public LinkedList<Long> uJm = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uJg);
            aVar.d(2, 2, this.uJh);
            aVar.d(3, 2, this.uJi);
            aVar.d(4, 2, this.uJj);
            aVar.d(5, 3, this.uJk);
            aVar.d(6, 3, this.uJl);
            aVar.d(7, 3, this.uJm);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.eL(1, this.uJg) + 0) + a.a.a.a.c(2, 2, this.uJh)) + a.a.a.a.c(3, 2, this.uJi)) + a.a.a.a.c(4, 2, this.uJj)) + a.a.a.a.c(5, 3, this.uJk)) + a.a.a.a.c(6, 3, this.uJl)) + a.a.a.a.c(7, 3, this.uJm);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.uJh.clear();
                this.uJi.clear();
                this.uJj.clear();
                this.uJk.clear();
                this.uJl.clear();
                this.uJm.clear();
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
                ag agVar = (ag) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        agVar.uJg = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        agVar.uJh.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    case 3:
                        agVar.uJi.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    case 4:
                        agVar.uJj.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    case 5:
                        agVar.uJk.add(Long.valueOf(aVar3.xmD.mM()));
                        return 0;
                    case 6:
                        agVar.uJl.add(Long.valueOf(aVar3.xmD.mM()));
                        return 0;
                    case 7:
                        agVar.uJm.add(Long.valueOf(aVar3.xmD.mM()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
