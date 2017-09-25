package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ant extends a {
    public lv tSS;
    public int tST;
    public int tdM;
    public String thD;
    public int toa;
    public avw tob;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tSS == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.tob == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                if (this.tSS != null) {
                    aVar.eQ(1, this.tSS.aUk());
                    this.tSS.a(aVar);
                }
                aVar.eO(2, this.toa);
                if (this.tob != null) {
                    aVar.eQ(3, this.tob.aUk());
                    this.tob.a(aVar);
                }
                aVar.eO(4, this.tdM);
                if (this.thD != null) {
                    aVar.e(5, this.thD);
                }
                aVar.eO(6, this.tST);
                return 0;
            }
        } else if (i == 1) {
            if (this.tSS != null) {
                r0 = a.a.a.a.eN(1, this.tSS.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.toa);
            if (this.tob != null) {
                r0 += a.a.a.a.eN(3, this.tob.aUk());
            }
            r0 += a.a.a.a.eL(4, this.tdM);
            if (this.thD != null) {
                r0 += a.a.a.b.b.a.f(5, this.thD);
            }
            return r0 + a.a.a.a.eL(6, this.tST);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tSS == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.tob != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ant com_tencent_mm_protocal_c_ant = (ant) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a lvVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        lvVar = new lv();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lvVar.a(aVar4, lvVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ant.tSS = lvVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ant.toa = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        lvVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lvVar.a(aVar4, lvVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ant.tob = lvVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ant.tdM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ant.thD = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ant.tST = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
