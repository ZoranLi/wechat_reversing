package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;

public final class rv extends a {
    public String desc;
    public String iBi;
    public String title;
    public boolean txb = false;
    public boolean txc = false;
    public ru tyA;
    public boolean tyB = false;
    public rz tyC;
    public boolean tyD = false;
    public boolean tyE = false;
    public long tyF;
    public boolean tyG = false;
    public int tyH = -1;
    public boolean tyI = false;
    public long tyJ;
    public boolean tyK = false;
    public rs tyw;
    public boolean tyx = false;
    public sf tyy;
    public boolean tyz = false;
    public rw tzl;
    public boolean tzm = false;
    public LinkedList<rm> tzn = new LinkedList();
    public boolean tzo = false;
    public boolean tzp = false;
    public int version;

    public final rv a(rw rwVar) {
        this.tzl = rwVar;
        this.tzm = true;
        return this;
    }

    public final rv av(LinkedList<rm> linkedList) {
        this.tzn = linkedList;
        this.tzo = true;
        return this;
    }

    public final rv b(rs rsVar) {
        this.tyw = rsVar;
        this.tyx = true;
        return this;
    }

    public final rv b(sf sfVar) {
        this.tyy = sfVar;
        this.tyz = true;
        return this;
    }

    public final rv OA(String str) {
        this.iBi = str;
        this.tyE = true;
        return this;
    }

    public final rv OB(String str) {
        this.title = str;
        this.txb = true;
        return this;
    }

    public final rv OC(String str) {
        this.desc = str;
        this.txc = true;
        return this;
    }

    public final rv en(long j) {
        this.tyF = j;
        this.tyG = true;
        return this;
    }

    public final rv yh(int i) {
        this.tyH = i;
        this.tyI = true;
        return this;
    }

    public final rv b(ru ruVar) {
        this.tyA = ruVar;
        this.tyB = true;
        return this;
    }

    public final rv eo(long j) {
        this.tyJ = j;
        this.tyK = true;
        return this;
    }

    public final rv b(rz rzVar) {
        this.tyC = rzVar;
        this.tyD = true;
        return this;
    }

    public final rv yi(int i) {
        this.version = i;
        this.tzp = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tzl != null) {
                aVar.eQ(1, this.tzl.aUk());
                this.tzl.a(aVar);
            }
            aVar.d(2, 8, this.tzn);
            if (this.tyw != null) {
                aVar.eQ(3, this.tyw.aUk());
                this.tyw.a(aVar);
            }
            if (this.tyy != null) {
                aVar.eQ(4, this.tyy.aUk());
                this.tyy.a(aVar);
            }
            if (this.iBi != null) {
                aVar.e(5, this.iBi);
            }
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            if (this.desc != null) {
                aVar.e(7, this.desc);
            }
            if (this.tyG) {
                aVar.O(8, this.tyF);
            }
            if (this.tyI) {
                aVar.eO(91, this.tyH);
            }
            if (this.tyA != null) {
                aVar.eQ(10, this.tyA.aUk());
                this.tyA.a(aVar);
            }
            if (this.tyK) {
                aVar.O(11, this.tyJ);
            }
            if (this.tyC != null) {
                aVar.eQ(12, this.tyC.aUk());
                this.tyC.a(aVar);
            }
            if (!this.tzp) {
                return 0;
            }
            aVar.eO(13, this.version);
            return 0;
        } else if (i == 1) {
            if (this.tzl != null) {
                r0 = a.a.a.a.eN(1, this.tzl.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.tzn);
            if (this.tyw != null) {
                r0 += a.a.a.a.eN(3, this.tyw.aUk());
            }
            if (this.tyy != null) {
                r0 += a.a.a.a.eN(4, this.tyy.aUk());
            }
            if (this.iBi != null) {
                r0 += a.a.a.b.b.a.f(5, this.iBi);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(6, this.title);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(7, this.desc);
            }
            if (this.tyG) {
                r0 += a.a.a.a.N(8, this.tyF);
            }
            if (this.tyI) {
                r0 += a.a.a.a.eL(91, this.tyH);
            }
            if (this.tyA != null) {
                r0 += a.a.a.a.eN(10, this.tyA.aUk());
            }
            if (this.tyK) {
                r0 += a.a.a.a.N(11, this.tyJ);
            }
            if (this.tyC != null) {
                r0 += a.a.a.a.eN(12, this.tyC.aUk());
            }
            if (this.tzp) {
                r0 += a.a.a.a.eL(13, this.version);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tzn.clear();
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
            rv rvVar = (rv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a rwVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        rwVar = new rw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rwVar.a(aVar4, rwVar, a.a(aVar4))) {
                        }
                        rvVar.tzl = rwVar;
                    }
                    rvVar.tzm = true;
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        rwVar = new rm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rwVar.a(aVar4, rwVar, a.a(aVar4))) {
                        }
                        rvVar.tzn.add(rwVar);
                    }
                    rvVar.tzo = true;
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        rwVar = new rs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rwVar.a(aVar4, rwVar, a.a(aVar4))) {
                        }
                        rvVar.tyw = rwVar;
                    }
                    rvVar.tyx = true;
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        rwVar = new sf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rwVar.a(aVar4, rwVar, a.a(aVar4))) {
                        }
                        rvVar.tyy = rwVar;
                    }
                    rvVar.tyz = true;
                    return 0;
                case 5:
                    rvVar.iBi = aVar3.xmD.readString();
                    rvVar.tyE = true;
                    return 0;
                case 6:
                    rvVar.title = aVar3.xmD.readString();
                    rvVar.txb = true;
                    return 0;
                case 7:
                    rvVar.desc = aVar3.xmD.readString();
                    rvVar.txc = true;
                    return 0;
                case 8:
                    rvVar.tyF = aVar3.xmD.mM();
                    rvVar.tyG = true;
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        rwVar = new ru();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rwVar.a(aVar4, rwVar, a.a(aVar4))) {
                        }
                        rvVar.tyA = rwVar;
                    }
                    rvVar.tyB = true;
                    return 0;
                case 11:
                    rvVar.tyJ = aVar3.xmD.mM();
                    rvVar.tyK = true;
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        rwVar = new rz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rwVar.a(aVar4, rwVar, a.a(aVar4))) {
                        }
                        rvVar.tyC = rwVar;
                    }
                    rvVar.tyD = true;
                    return 0;
                case 13:
                    rvVar.version = aVar3.xmD.mL();
                    rvVar.tzp = true;
                    return 0;
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    rvVar.tyH = aVar3.xmD.mL();
                    rvVar.tyI = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
