package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bdb extends a {
    public int trD;
    public int tvL;
    public int ued;
    public int uee;
    public int uef;
    public int ueg;
    public int ueh;
    public LinkedList<Integer> uei = new LinkedList();
    public int uej;
    public int uek;
    public LinkedList<Integer> uel = new LinkedList();
    public int uem;
    public int uen;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tvL);
            aVar.eO(2, this.ued);
            aVar.eO(3, this.trD);
            aVar.eO(4, this.uee);
            aVar.eO(5, this.uef);
            aVar.eO(6, this.ueg);
            aVar.eO(7, this.ueh);
            aVar.d(8, 2, this.uei);
            aVar.eO(9, this.uej);
            aVar.eO(10, this.uek);
            aVar.d(11, 2, this.uel);
            aVar.eO(12, this.uem);
            aVar.eO(13, this.uen);
            return 0;
        } else if (i == 1) {
            return ((((((((((((a.a.a.a.eL(1, this.tvL) + 0) + a.a.a.a.eL(2, this.ued)) + a.a.a.a.eL(3, this.trD)) + a.a.a.a.eL(4, this.uee)) + a.a.a.a.eL(5, this.uef)) + a.a.a.a.eL(6, this.ueg)) + a.a.a.a.eL(7, this.ueh)) + a.a.a.a.c(8, 2, this.uei)) + a.a.a.a.eL(9, this.uej)) + a.a.a.a.eL(10, this.uek)) + a.a.a.a.c(11, 2, this.uel)) + a.a.a.a.eL(12, this.uem)) + a.a.a.a.eL(13, this.uen);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.uei.clear();
                this.uel.clear();
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
                bdb com_tencent_mm_protocal_c_bdb = (bdb) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bdb.tvL = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bdb.ued = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bdb.trD = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bdb.uee = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_bdb.uef = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_bdb.ueg = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_bdb.ueh = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_bdb.uei.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    case 9:
                        com_tencent_mm_protocal_c_bdb.uej = aVar3.xmD.mL();
                        return 0;
                    case 10:
                        com_tencent_mm_protocal_c_bdb.uek = aVar3.xmD.mL();
                        return 0;
                    case 11:
                        com_tencent_mm_protocal_c_bdb.uel.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    case 12:
                        com_tencent_mm_protocal_c_bdb.uem = aVar3.xmD.mL();
                        return 0;
                    case 13:
                        com_tencent_mm_protocal_c_bdb.uen = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
