package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class q extends a {
    public String jNI;
    public String jNJ;
    public String jNK;
    public String jNL;
    public long jNM;
    public long jNN;
    public String jNO;
    public String jNP;
    public b jNQ;
    public b jNR;
    public String jNo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNI == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.jNJ == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.jNK == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.jNL == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.jNO == null) {
                throw new a.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.jNo == null) {
                throw new a.a.a.b("Not all required fields were included: Model");
            } else if (this.jNP == null) {
                throw new a.a.a.b("Not all required fields were included: Version");
            } else {
                if (this.jNI != null) {
                    aVar.e(1, this.jNI);
                }
                if (this.jNJ != null) {
                    aVar.e(2, this.jNJ);
                }
                if (this.jNK != null) {
                    aVar.e(3, this.jNK);
                }
                if (this.jNL != null) {
                    aVar.e(4, this.jNL);
                }
                aVar.O(5, this.jNM);
                aVar.O(6, this.jNN);
                if (this.jNO != null) {
                    aVar.e(7, this.jNO);
                }
                if (this.jNo != null) {
                    aVar.e(8, this.jNo);
                }
                if (this.jNP != null) {
                    aVar.e(9, this.jNP);
                }
                if (this.jNQ != null) {
                    aVar.b(10, this.jNQ);
                }
                if (this.jNR == null) {
                    return 0;
                }
                aVar.b(11, this.jNR);
                return 0;
            }
        } else if (i == 1) {
            if (this.jNI != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNI) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNJ);
            }
            if (this.jNK != null) {
                r0 += a.a.a.b.b.a.f(3, this.jNK);
            }
            if (this.jNL != null) {
                r0 += a.a.a.b.b.a.f(4, this.jNL);
            }
            r0 = (r0 + a.a.a.a.N(5, this.jNM)) + a.a.a.a.N(6, this.jNN);
            if (this.jNO != null) {
                r0 += a.a.a.b.b.a.f(7, this.jNO);
            }
            if (this.jNo != null) {
                r0 += a.a.a.b.b.a.f(8, this.jNo);
            }
            if (this.jNP != null) {
                r0 += a.a.a.b.b.a.f(9, this.jNP);
            }
            if (this.jNQ != null) {
                r0 += a.a.a.a.a(10, this.jNQ);
            }
            if (this.jNR != null) {
                r0 += a.a.a.a.a(11, this.jNR);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNI == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.jNJ == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.jNK == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.jNL == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.jNO == null) {
                throw new a.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.jNo == null) {
                throw new a.a.a.b("Not all required fields were included: Model");
            } else if (this.jNP != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Version");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.jNI = aVar3.xmD.readString();
                    return 0;
                case 2:
                    qVar.jNJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    qVar.jNK = aVar3.xmD.readString();
                    return 0;
                case 4:
                    qVar.jNL = aVar3.xmD.readString();
                    return 0;
                case 5:
                    qVar.jNM = aVar3.xmD.mM();
                    return 0;
                case 6:
                    qVar.jNN = aVar3.xmD.mM();
                    return 0;
                case 7:
                    qVar.jNO = aVar3.xmD.readString();
                    return 0;
                case 8:
                    qVar.jNo = aVar3.xmD.readString();
                    return 0;
                case 9:
                    qVar.jNP = aVar3.xmD.readString();
                    return 0;
                case 10:
                    qVar.jNQ = aVar3.cic();
                    return 0;
                case 11:
                    qVar.jNR = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
