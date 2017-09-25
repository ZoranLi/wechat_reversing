package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class ao extends avp {
    public String mtN;
    public y mui;
    public ae muj;
    public h muk;
    public ca mul;
    public ci mum;
    public w mun;
    public bj muo;
    public bi mup;
    public bp muq;
    public k mur;
    public n mus;
    public String mut;
    public int muu;
    public boolean muv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            if (this.mui != null) {
                aVar.eQ(2, this.mui.aUk());
                this.mui.a(aVar);
            }
            if (this.muj != null) {
                aVar.eQ(3, this.muj.aUk());
                this.muj.a(aVar);
            }
            if (this.mtN != null) {
                aVar.e(4, this.mtN);
            }
            if (this.muk != null) {
                aVar.eQ(5, this.muk.aUk());
                this.muk.a(aVar);
            }
            if (this.mul != null) {
                aVar.eQ(6, this.mul.aUk());
                this.mul.a(aVar);
            }
            if (this.mum != null) {
                aVar.eQ(7, this.mum.aUk());
                this.mum.a(aVar);
            }
            if (this.mun != null) {
                aVar.eQ(8, this.mun.aUk());
                this.mun.a(aVar);
            }
            if (this.muo != null) {
                aVar.eQ(9, this.muo.aUk());
                this.muo.a(aVar);
            }
            if (this.mup != null) {
                aVar.eQ(10, this.mup.aUk());
                this.mup.a(aVar);
            }
            if (this.muq != null) {
                aVar.eQ(11, this.muq.aUk());
                this.muq.a(aVar);
            }
            if (this.mur != null) {
                aVar.eQ(12, this.mur.aUk());
                this.mur.a(aVar);
            }
            if (this.mus != null) {
                aVar.eQ(13, this.mus.aUk());
                this.mus.a(aVar);
            }
            if (this.mut != null) {
                aVar.e(14, this.mut);
            }
            aVar.eO(15, this.muu);
            aVar.an(16, this.muv);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mui != null) {
                r0 += a.a.a.a.eN(2, this.mui.aUk());
            }
            if (this.muj != null) {
                r0 += a.a.a.a.eN(3, this.muj.aUk());
            }
            if (this.mtN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtN);
            }
            if (this.muk != null) {
                r0 += a.a.a.a.eN(5, this.muk.aUk());
            }
            if (this.mul != null) {
                r0 += a.a.a.a.eN(6, this.mul.aUk());
            }
            if (this.mum != null) {
                r0 += a.a.a.a.eN(7, this.mum.aUk());
            }
            if (this.mun != null) {
                r0 += a.a.a.a.eN(8, this.mun.aUk());
            }
            if (this.muo != null) {
                r0 += a.a.a.a.eN(9, this.muo.aUk());
            }
            if (this.mup != null) {
                r0 += a.a.a.a.eN(10, this.mup.aUk());
            }
            if (this.muq != null) {
                r0 += a.a.a.a.eN(11, this.muq.aUk());
            }
            if (this.mur != null) {
                r0 += a.a.a.a.eN(12, this.mur.aUk());
            }
            if (this.mus != null) {
                r0 += a.a.a.a.eN(13, this.mus.aUk());
            }
            if (this.mut != null) {
                r0 += a.a.a.b.b.a.f(14, this.mut);
            }
            return (r0 + a.a.a.a.eL(15, this.muu)) + (a.a.a.b.b.a.cH(16) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ao aoVar = (ao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new y();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.mui = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new ae();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.muj = enVar;
                    }
                    return 0;
                case 4:
                    aoVar.mtN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new h();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.muk = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new ca();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.mul = enVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new ci();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.mum = enVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new w();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.mun = enVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.muo = enVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bi();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.mup = enVar;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.muq = enVar;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new k();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.mur = enVar;
                    }
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new n();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aoVar.mus = enVar;
                    }
                    return 0;
                case 14:
                    aoVar.mut = aVar3.xmD.readString();
                    return 0;
                case 15:
                    aoVar.muu = aVar3.xmD.mL();
                    return 0;
                case 16:
                    aoVar.muv = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
