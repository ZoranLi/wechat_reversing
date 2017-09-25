package com.tencent.mm.plugin.sns.g;

import a.a.a.b;
import com.tencent.mm.bd.a;
import com.tencent.mm.protocal.c.bav;
import java.util.LinkedList;

public final class e extends a {
    public bav pTK;
    public String qaM;
    public int qaN;
    public String qaO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.qaM == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.pTK == null) {
                throw new b("Not all required fields were included: actionGroup");
            } else {
                if (this.qaM != null) {
                    aVar.e(1, this.qaM);
                }
                if (this.pTK != null) {
                    aVar.eQ(2, this.pTK.aUk());
                    this.pTK.a(aVar);
                }
                aVar.eO(3, this.qaN);
                if (this.qaO == null) {
                    return 0;
                }
                aVar.e(4, this.qaO);
                return 0;
            }
        } else if (i == 1) {
            if (this.qaM != null) {
                r0 = a.a.a.b.b.a.f(1, this.qaM) + 0;
            } else {
                r0 = 0;
            }
            if (this.pTK != null) {
                r0 += a.a.a.a.eN(2, this.pTK.aUk());
            }
            r0 += a.a.a.a.eL(3, this.qaN);
            if (this.qaO != null) {
                r0 += a.a.a.b.b.a.f(4, this.qaO);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.qaM == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.pTK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: actionGroup");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.qaM = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bav = new bav();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bav.a(aVar4, com_tencent_mm_protocal_c_bav, a.a(aVar4))) {
                        }
                        eVar.pTK = com_tencent_mm_protocal_c_bav;
                    }
                    return 0;
                case 3:
                    eVar.qaN = aVar3.xmD.mL();
                    return 0;
                case 4:
                    eVar.qaO = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
