package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class c extends a {
    public int jNB;
    public int jOb;
    public String mse;
    public String msg;
    public String msh;
    public String msi;
    public String msj;
    public String msk;
    public String msl;
    public String msm;
    public int msn;
    public l mso;
    public int msp;
    public boolean msq;
    public LinkedList<String> msr = new LinkedList();
    public boolean mss;
    public boolean mst;
    public boolean msu;
    public boolean msv;
    public bn msw;
    public int msx;
    public bb msy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msh == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.msi == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                if (this.msh != null) {
                    aVar.e(1, this.msh);
                }
                if (this.msi != null) {
                    aVar.e(2, this.msi);
                }
                if (this.msj != null) {
                    aVar.e(3, this.msj);
                }
                if (this.msk != null) {
                    aVar.e(4, this.msk);
                }
                if (this.msl != null) {
                    aVar.e(5, this.msl);
                }
                if (this.mse != null) {
                    aVar.e(6, this.mse);
                }
                if (this.msm != null) {
                    aVar.e(7, this.msm);
                }
                aVar.eO(8, this.msn);
                if (this.mso != null) {
                    aVar.eQ(9, this.mso.aUk());
                    this.mso.a(aVar);
                }
                aVar.eO(10, this.jNB);
                aVar.eO(11, this.msp);
                if (this.msg != null) {
                    aVar.e(12, this.msg);
                }
                aVar.an(13, this.msq);
                aVar.d(14, 1, this.msr);
                aVar.an(15, this.mss);
                aVar.eO(16, this.jOb);
                aVar.an(17, this.mst);
                aVar.an(18, this.msu);
                aVar.an(19, this.msv);
                if (this.msw != null) {
                    aVar.eQ(20, this.msw.aUk());
                    this.msw.a(aVar);
                }
                aVar.eO(21, this.msx);
                if (this.msy == null) {
                    return 0;
                }
                aVar.eQ(22, this.msy.aUk());
                this.msy.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.msh != null) {
                r0 = a.a.a.b.b.a.f(1, this.msh) + 0;
            } else {
                r0 = 0;
            }
            if (this.msi != null) {
                r0 += a.a.a.b.b.a.f(2, this.msi);
            }
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(3, this.msj);
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(4, this.msk);
            }
            if (this.msl != null) {
                r0 += a.a.a.b.b.a.f(5, this.msl);
            }
            if (this.mse != null) {
                r0 += a.a.a.b.b.a.f(6, this.mse);
            }
            if (this.msm != null) {
                r0 += a.a.a.b.b.a.f(7, this.msm);
            }
            r0 += a.a.a.a.eL(8, this.msn);
            if (this.mso != null) {
                r0 += a.a.a.a.eN(9, this.mso.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(10, this.jNB)) + a.a.a.a.eL(11, this.msp);
            if (this.msg != null) {
                r0 += a.a.a.b.b.a.f(12, this.msg);
            }
            r0 = ((((((r0 + (a.a.a.b.b.a.cH(13) + 1)) + a.a.a.a.c(14, 1, this.msr)) + (a.a.a.b.b.a.cH(15) + 1)) + a.a.a.a.eL(16, this.jOb)) + (a.a.a.b.b.a.cH(17) + 1)) + (a.a.a.b.b.a.cH(18) + 1)) + (a.a.a.b.b.a.cH(19) + 1);
            if (this.msw != null) {
                r0 += a.a.a.a.eN(20, this.msw.aUk());
            }
            r0 += a.a.a.a.eL(21, this.msx);
            if (this.msy != null) {
                r0 += a.a.a.a.eN(22, this.msy.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.msr.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msh == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.msi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a lVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.msh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    cVar.msi = aVar3.xmD.readString();
                    return 0;
                case 3:
                    cVar.msj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    cVar.msk = aVar3.xmD.readString();
                    return 0;
                case 5:
                    cVar.msl = aVar3.xmD.readString();
                    return 0;
                case 6:
                    cVar.mse = aVar3.xmD.readString();
                    return 0;
                case 7:
                    cVar.msm = aVar3.xmD.readString();
                    return 0;
                case 8:
                    cVar.msn = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lVar = new l();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lVar.a(aVar4, lVar, a.a(aVar4))) {
                        }
                        cVar.mso = lVar;
                    }
                    return 0;
                case 10:
                    cVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 11:
                    cVar.msp = aVar3.xmD.mL();
                    return 0;
                case 12:
                    cVar.msg = aVar3.xmD.readString();
                    return 0;
                case 13:
                    cVar.msq = aVar3.cib();
                    return 0;
                case 14:
                    cVar.msr.add(aVar3.xmD.readString());
                    return 0;
                case 15:
                    cVar.mss = aVar3.cib();
                    return 0;
                case 16:
                    cVar.jOb = aVar3.xmD.mL();
                    return 0;
                case 17:
                    cVar.mst = aVar3.cib();
                    return 0;
                case 18:
                    cVar.msu = aVar3.cib();
                    return 0;
                case 19:
                    cVar.msv = aVar3.cib();
                    return 0;
                case 20:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lVar = new bn();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lVar.a(aVar4, lVar, a.a(aVar4))) {
                        }
                        cVar.msw = lVar;
                    }
                    return 0;
                case 21:
                    cVar.msx = aVar3.xmD.mL();
                    return 0;
                case 22:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lVar = new bb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lVar.a(aVar4, lVar, a.a(aVar4))) {
                        }
                        cVar.msy = lVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
