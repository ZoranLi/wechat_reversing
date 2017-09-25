package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class dr extends a {
    public int leD;
    public String tdI;
    public os thd;
    public avw the;
    public avw thf;
    public int thg;
    public avw thh;
    public bmi thi;
    public bpo thj;
    public avw thk;
    public avw thl;
    public String thm;
    public avw thn;
    public String tho;
    public bad thp;
    public String thq;
    public int thr;
    public int ths;
    public int tht;
    public int thu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.thd == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.the == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.thf == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else {
                aVar.eO(1, this.leD);
                if (this.thd != null) {
                    aVar.eQ(2, this.thd.aUk());
                    this.thd.a(aVar);
                }
                if (this.the != null) {
                    aVar.eQ(3, this.the.aUk());
                    this.the.a(aVar);
                }
                if (this.thf != null) {
                    aVar.eQ(4, this.thf.aUk());
                    this.thf.a(aVar);
                }
                aVar.eO(5, this.thg);
                if (this.thh != null) {
                    aVar.eQ(6, this.thh.aUk());
                    this.thh.a(aVar);
                }
                if (this.thi != null) {
                    aVar.eQ(7, this.thi.aUk());
                    this.thi.a(aVar);
                }
                if (this.thj != null) {
                    aVar.eQ(8, this.thj.aUk());
                    this.thj.a(aVar);
                }
                if (this.thk != null) {
                    aVar.eQ(9, this.thk.aUk());
                    this.thk.a(aVar);
                }
                if (this.thl != null) {
                    aVar.eQ(10, this.thl.aUk());
                    this.thl.a(aVar);
                }
                if (this.thm != null) {
                    aVar.e(11, this.thm);
                }
                if (this.thn != null) {
                    aVar.eQ(12, this.thn.aUk());
                    this.thn.a(aVar);
                }
                if (this.tho != null) {
                    aVar.e(14, this.tho);
                }
                if (this.thp != null) {
                    aVar.eQ(15, this.thp.aUk());
                    this.thp.a(aVar);
                }
                if (this.thq != null) {
                    aVar.e(16, this.thq);
                }
                aVar.eO(17, this.thr);
                aVar.eO(18, this.ths);
                aVar.eO(19, this.tht);
                if (this.tdI != null) {
                    aVar.e(20, this.tdI);
                }
                aVar.eO(21, this.thu);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.leD) + 0;
            if (this.thd != null) {
                r0 += a.a.a.a.eN(2, this.thd.aUk());
            }
            if (this.the != null) {
                r0 += a.a.a.a.eN(3, this.the.aUk());
            }
            if (this.thf != null) {
                r0 += a.a.a.a.eN(4, this.thf.aUk());
            }
            r0 += a.a.a.a.eL(5, this.thg);
            if (this.thh != null) {
                r0 += a.a.a.a.eN(6, this.thh.aUk());
            }
            if (this.thi != null) {
                r0 += a.a.a.a.eN(7, this.thi.aUk());
            }
            if (this.thj != null) {
                r0 += a.a.a.a.eN(8, this.thj.aUk());
            }
            if (this.thk != null) {
                r0 += a.a.a.a.eN(9, this.thk.aUk());
            }
            if (this.thl != null) {
                r0 += a.a.a.a.eN(10, this.thl.aUk());
            }
            if (this.thm != null) {
                r0 += a.a.a.b.b.a.f(11, this.thm);
            }
            if (this.thn != null) {
                r0 += a.a.a.a.eN(12, this.thn.aUk());
            }
            if (this.tho != null) {
                r0 += a.a.a.b.b.a.f(14, this.tho);
            }
            if (this.thp != null) {
                r0 += a.a.a.a.eN(15, this.thp.aUk());
            }
            if (this.thq != null) {
                r0 += a.a.a.b.b.a.f(16, this.thq);
            }
            r0 = ((r0 + a.a.a.a.eL(17, this.thr)) + a.a.a.a.eL(18, this.ths)) + a.a.a.a.eL(19, this.tht);
            if (this.tdI != null) {
                r0 += a.a.a.b.b.a.f(20, this.tdI);
            }
            return r0 + a.a.a.a.eL(21, this.thu);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.thd == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.the == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.thf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dr drVar = (dr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a osVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    drVar.leD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new os();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thd = osVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.the = osVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thf = osVar;
                    }
                    return 0;
                case 5:
                    drVar.thg = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thh = osVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new bmi();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thi = osVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new bpo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thj = osVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thk = osVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thl = osVar;
                    }
                    return 0;
                case 11:
                    drVar.thm = aVar3.xmD.readString();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thn = osVar;
                    }
                    return 0;
                case 14:
                    drVar.tho = aVar3.xmD.readString();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        osVar = new bad();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = osVar.a(aVar4, osVar, a.a(aVar4))) {
                        }
                        drVar.thp = osVar;
                    }
                    return 0;
                case 16:
                    drVar.thq = aVar3.xmD.readString();
                    return 0;
                case 17:
                    drVar.thr = aVar3.xmD.mL();
                    return 0;
                case 18:
                    drVar.ths = aVar3.xmD.mL();
                    return 0;
                case 19:
                    drVar.tht = aVar3.xmD.mL();
                    return 0;
                case 20:
                    drVar.tdI = aVar3.xmD.readString();
                    return 0;
                case 21:
                    drVar.thu = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
