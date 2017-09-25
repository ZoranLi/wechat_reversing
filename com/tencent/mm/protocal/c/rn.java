package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class rn extends a {
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
    public ro tyu;
    public boolean tyv = false;
    public rs tyw;
    public boolean tyx = false;
    public sf tyy;
    public boolean tyz = false;

    public final rn c(ro roVar) {
        this.tyu = roVar;
        this.tyv = true;
        return this;
    }

    public final rn a(rs rsVar) {
        this.tyw = rsVar;
        this.tyx = true;
        return this;
    }

    public final rn a(sf sfVar) {
        this.tyy = sfVar;
        this.tyz = true;
        return this;
    }

    public final rn a(ru ruVar) {
        this.tyA = ruVar;
        this.tyB = true;
        return this;
    }

    public final rn a(rz rzVar) {
        this.tyC = rzVar;
        this.tyD = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tyu != null) {
                aVar.eQ(1, this.tyu.aUk());
                this.tyu.a(aVar);
            }
            if (this.tyw != null) {
                aVar.eQ(2, this.tyw.aUk());
                this.tyw.a(aVar);
            }
            if (this.tyy != null) {
                aVar.eQ(3, this.tyy.aUk());
                this.tyy.a(aVar);
            }
            if (this.tyA != null) {
                aVar.eQ(4, this.tyA.aUk());
                this.tyA.a(aVar);
            }
            if (this.tyC != null) {
                aVar.eQ(5, this.tyC.aUk());
                this.tyC.a(aVar);
            }
            if (this.iBi != null) {
                aVar.e(6, this.iBi);
            }
            if (this.title != null) {
                aVar.e(7, this.title);
            }
            if (this.desc != null) {
                aVar.e(8, this.desc);
            }
            if (this.tyG) {
                aVar.O(9, this.tyF);
            }
            if (this.tyI) {
                aVar.eO(101, this.tyH);
            }
            if (!this.tyK) {
                return 0;
            }
            aVar.O(11, this.tyJ);
            return 0;
        } else if (i == 1) {
            if (this.tyu != null) {
                r0 = a.a.a.a.eN(1, this.tyu.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tyw != null) {
                r0 += a.a.a.a.eN(2, this.tyw.aUk());
            }
            if (this.tyy != null) {
                r0 += a.a.a.a.eN(3, this.tyy.aUk());
            }
            if (this.tyA != null) {
                r0 += a.a.a.a.eN(4, this.tyA.aUk());
            }
            if (this.tyC != null) {
                r0 += a.a.a.a.eN(5, this.tyC.aUk());
            }
            if (this.iBi != null) {
                r0 += a.a.a.b.b.a.f(6, this.iBi);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(7, this.title);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(8, this.desc);
            }
            if (this.tyG) {
                r0 += a.a.a.a.N(9, this.tyF);
            }
            if (this.tyI) {
                r0 += a.a.a.a.eL(101, this.tyH);
            }
            if (this.tyK) {
                r0 += a.a.a.a.N(11, this.tyJ);
            }
            return r0;
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
            rn rnVar = (rn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a roVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        roVar = new ro();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = roVar.a(aVar4, roVar, a.a(aVar4))) {
                        }
                        rnVar.tyu = roVar;
                    }
                    rnVar.tyv = true;
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        roVar = new rs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = roVar.a(aVar4, roVar, a.a(aVar4))) {
                        }
                        rnVar.tyw = roVar;
                    }
                    rnVar.tyx = true;
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        roVar = new sf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = roVar.a(aVar4, roVar, a.a(aVar4))) {
                        }
                        rnVar.tyy = roVar;
                    }
                    rnVar.tyz = true;
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        roVar = new ru();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = roVar.a(aVar4, roVar, a.a(aVar4))) {
                        }
                        rnVar.tyA = roVar;
                    }
                    rnVar.tyB = true;
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        roVar = new rz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = roVar.a(aVar4, roVar, a.a(aVar4))) {
                        }
                        rnVar.tyC = roVar;
                    }
                    rnVar.tyD = true;
                    return 0;
                case 6:
                    rnVar.iBi = aVar3.xmD.readString();
                    rnVar.tyE = true;
                    return 0;
                case 7:
                    rnVar.title = aVar3.xmD.readString();
                    rnVar.txb = true;
                    return 0;
                case 8:
                    rnVar.desc = aVar3.xmD.readString();
                    rnVar.txc = true;
                    return 0;
                case 9:
                    rnVar.tyF = aVar3.xmD.mM();
                    rnVar.tyG = true;
                    return 0;
                case 11:
                    rnVar.tyJ = aVar3.xmD.mM();
                    rnVar.tyK = true;
                    return 0;
                case 101:
                    rnVar.tyH = aVar3.xmD.mL();
                    rnVar.tyI = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
