package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class vm extends avh {
    public String knP;
    public String rEK;
    public String signature;
    public String tCO;
    public String tCP;
    public String tCQ;
    public String tsS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.tCO == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.rEK == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.knP == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.tCP == null) {
                throw new b("Not all required fields were included: from_url");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tsS != null) {
                    aVar.e(2, this.tsS);
                }
                if (this.tCO != null) {
                    aVar.e(3, this.tCO);
                }
                if (this.rEK != null) {
                    aVar.e(4, this.rEK);
                }
                if (this.knP != null) {
                    aVar.e(5, this.knP);
                }
                if (this.signature != null) {
                    aVar.e(6, this.signature);
                }
                if (this.tCP != null) {
                    aVar.e(7, this.tCP);
                }
                if (this.tCQ == null) {
                    return 0;
                }
                aVar.e(8, this.tCQ);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tsS != null) {
                r0 += a.a.a.b.b.a.f(2, this.tsS);
            }
            if (this.tCO != null) {
                r0 += a.a.a.b.b.a.f(3, this.tCO);
            }
            if (this.rEK != null) {
                r0 += a.a.a.b.b.a.f(4, this.rEK);
            }
            if (this.knP != null) {
                r0 += a.a.a.b.b.a.f(5, this.knP);
            }
            if (this.signature != null) {
                r0 += a.a.a.b.b.a.f(6, this.signature);
            }
            if (this.tCP != null) {
                r0 += a.a.a.b.b.a.f(7, this.tCP);
            }
            if (this.tCQ != null) {
                r0 += a.a.a.b.b.a.f(8, this.tCQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsS == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.tCO == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.rEK == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.knP == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.tCP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: from_url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            vm vmVar = (vm) objArr[1];
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
                        vmVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    vmVar.tsS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    vmVar.tCO = aVar3.xmD.readString();
                    return 0;
                case 4:
                    vmVar.rEK = aVar3.xmD.readString();
                    return 0;
                case 5:
                    vmVar.knP = aVar3.xmD.readString();
                    return 0;
                case 6:
                    vmVar.signature = aVar3.xmD.readString();
                    return 0;
                case 7:
                    vmVar.tCP = aVar3.xmD.readString();
                    return 0;
                case 8:
                    vmVar.tCQ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
