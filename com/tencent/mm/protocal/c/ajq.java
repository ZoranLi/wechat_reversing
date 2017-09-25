package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class ajq extends a {
    public float aLh;
    public String hAF;
    public String ndv;
    public String quK;
    public int quM;
    public int quO;
    public int score;
    public String tNr;
    public String tNs;
    public int tNt;
    public int tNu;
    public b tNv;
    public float tmZ;
    public float tna;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.n(1, this.tmZ);
            aVar.n(2, this.tna);
            if (this.hAF != null) {
                aVar.e(3, this.hAF);
            }
            if (this.ndv != null) {
                aVar.e(4, this.ndv);
            }
            if (this.quK != null) {
                aVar.e(5, this.quK);
            }
            if (this.tNr != null) {
                aVar.e(6, this.tNr);
            }
            aVar.eO(7, this.quM);
            if (this.tNs != null) {
                aVar.e(8, this.tNs);
            }
            aVar.eO(9, this.tNt);
            aVar.eO(10, this.tNu);
            aVar.eO(11, this.quO);
            aVar.n(12, this.aLh);
            if (this.tNv != null) {
                aVar.b(13, this.tNv);
            }
            aVar.eO(14, this.score);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.b.b.a.cH(1) + 4) + 0) + (a.a.a.b.b.a.cH(2) + 4);
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(3, this.hAF);
            }
            if (this.ndv != null) {
                r0 += a.a.a.b.b.a.f(4, this.ndv);
            }
            if (this.quK != null) {
                r0 += a.a.a.b.b.a.f(5, this.quK);
            }
            if (this.tNr != null) {
                r0 += a.a.a.b.b.a.f(6, this.tNr);
            }
            r0 += a.a.a.a.eL(7, this.quM);
            if (this.tNs != null) {
                r0 += a.a.a.b.b.a.f(8, this.tNs);
            }
            r0 = (((r0 + a.a.a.a.eL(9, this.tNt)) + a.a.a.a.eL(10, this.tNu)) + a.a.a.a.eL(11, this.quO)) + (a.a.a.b.b.a.cH(12) + 4);
            if (this.tNv != null) {
                r0 += a.a.a.a.a(13, this.tNv);
            }
            return r0 + a.a.a.a.eL(14, this.score);
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
            ajq com_tencent_mm_protocal_c_ajq = (ajq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ajq.tmZ = aVar3.xmD.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajq.tna = aVar3.xmD.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajq.hAF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajq.ndv = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajq.quK = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ajq.tNr = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ajq.quM = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ajq.tNs = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ajq.tNt = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ajq.tNu = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ajq.quO = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ajq.aLh = aVar3.xmD.readFloat();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ajq.tNv = aVar3.cic();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ajq.score = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
