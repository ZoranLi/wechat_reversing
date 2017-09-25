package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bik extends a {
    public String title;
    public LinkedList<ben> uhT = new LinkedList();
    public LinkedList<ben> uhU = new LinkedList();
    public LinkedList<lz> uhV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.d(2, 8, this.uhT);
            aVar.d(3, 8, this.uhU);
            aVar.d(4, 8, this.uhV);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.c(2, 8, this.uhT)) + a.a.a.a.c(3, 8, this.uhU)) + a.a.a.a.c(4, 8, this.uhV);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uhT.clear();
            this.uhU.clear();
            this.uhV.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bik com_tencent_mm_protocal_c_bik = (bik) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_ben;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bik.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ben = new ben();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ben.a(aVar4, com_tencent_mm_protocal_c_ben, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.uhT.add(com_tencent_mm_protocal_c_ben);
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ben = new ben();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ben.a(aVar4, com_tencent_mm_protocal_c_ben, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.uhU.add(com_tencent_mm_protocal_c_ben);
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ben = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ben.a(aVar4, com_tencent_mm_protocal_c_ben, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.uhV.add(com_tencent_mm_protocal_c_ben);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
