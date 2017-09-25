package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class js extends avh {
    public int boy;
    public String tpE;
    public String tpF;
    public String tpG;
    public String tpH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tpE == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.tpF == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.tpH == null) {
                throw new b("Not all required fields were included: receiver_open_id");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tpE != null) {
                    aVar.e(2, this.tpE);
                }
                if (this.tpF != null) {
                    aVar.e(3, this.tpF);
                }
                if (this.tpG != null) {
                    aVar.e(4, this.tpG);
                }
                if (this.tpH != null) {
                    aVar.e(5, this.tpH);
                }
                aVar.eO(6, this.boy);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tpE != null) {
                r0 += a.a.a.b.b.a.f(2, this.tpE);
            }
            if (this.tpF != null) {
                r0 += a.a.a.b.b.a.f(3, this.tpF);
            }
            if (this.tpG != null) {
                r0 += a.a.a.b.b.a.f(4, this.tpG);
            }
            if (this.tpH != null) {
                r0 += a.a.a.b.b.a.f(5, this.tpH);
            }
            return r0 + a.a.a.a.eL(6, this.boy);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tpE == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.tpF == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.tpH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: receiver_open_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            js jsVar = (js) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        jsVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    jsVar.tpE = aVar3.xmD.readString();
                    return 0;
                case 3:
                    jsVar.tpF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    jsVar.tpG = aVar3.xmD.readString();
                    return 0;
                case 5:
                    jsVar.tpH = aVar3.xmD.readString();
                    return 0;
                case 6:
                    jsVar.boy = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
