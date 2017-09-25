package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class am extends avp {
    public c msc;
    public String mtU;
    public LinkedList<q> mtV = new LinkedList();
    public bm mtW;
    public az mtX;
    public aw mtY;
    public bx mtZ;
    public LinkedList<r> mua = new LinkedList();
    public cc mub;
    public ay muc;
    public av mud;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.msc == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.mtU == null) {
                throw new b("Not all required fields were included: BackGroundURL");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.msc != null) {
                    aVar.eQ(2, this.msc.aUk());
                    this.msc.a(aVar);
                }
                if (this.mtU != null) {
                    aVar.e(3, this.mtU);
                }
                aVar.d(4, 8, this.mtV);
                if (this.mtW != null) {
                    aVar.eQ(5, this.mtW.aUk());
                    this.mtW.a(aVar);
                }
                if (this.mtX != null) {
                    aVar.eQ(7, this.mtX.aUk());
                    this.mtX.a(aVar);
                }
                if (this.mtY != null) {
                    aVar.eQ(8, this.mtY.aUk());
                    this.mtY.a(aVar);
                }
                if (this.mtZ != null) {
                    aVar.eQ(9, this.mtZ.aUk());
                    this.mtZ.a(aVar);
                }
                aVar.d(10, 8, this.mua);
                if (this.mub != null) {
                    aVar.eQ(11, this.mub.aUk());
                    this.mub.a(aVar);
                }
                if (this.muc != null) {
                    aVar.eQ(12, this.muc.aUk());
                    this.muc.a(aVar);
                }
                if (this.mud == null) {
                    return 0;
                }
                aVar.eQ(13, this.mud.aUk());
                this.mud.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.msc != null) {
                r0 += a.a.a.a.eN(2, this.msc.aUk());
            }
            if (this.mtU != null) {
                r0 += a.a.a.b.b.a.f(3, this.mtU);
            }
            r0 += a.a.a.a.c(4, 8, this.mtV);
            if (this.mtW != null) {
                r0 += a.a.a.a.eN(5, this.mtW.aUk());
            }
            if (this.mtX != null) {
                r0 += a.a.a.a.eN(7, this.mtX.aUk());
            }
            if (this.mtY != null) {
                r0 += a.a.a.a.eN(8, this.mtY.aUk());
            }
            if (this.mtZ != null) {
                r0 += a.a.a.a.eN(9, this.mtZ.aUk());
            }
            r0 += a.a.a.a.c(10, 8, this.mua);
            if (this.mub != null) {
                r0 += a.a.a.a.eN(11, this.mub.aUk());
            }
            if (this.muc != null) {
                r0 += a.a.a.a.eN(12, this.muc.aUk());
            }
            if (this.mud != null) {
                r0 += a.a.a.a.eN(13, this.mud.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mtV.clear();
            this.mua.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.msc == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.mtU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BackGroundURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            am amVar = (am) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new c();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.msc = enVar;
                    }
                    return 0;
                case 3:
                    amVar.mtU = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new q();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mtV.add(enVar);
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mtW = enVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new az();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mtX = enVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mtY = enVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mtZ = enVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new r();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mua.add(enVar);
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new cc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mub = enVar;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new ay();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.muc = enVar;
                    }
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new av();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        amVar.mud = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
