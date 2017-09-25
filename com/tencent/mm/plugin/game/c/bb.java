package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bb extends a {
    public String msF;
    public String msh;
    public bn msw;
    public String muR;
    public String muS;
    public String muT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msh != null) {
                aVar.e(1, this.msh);
            }
            if (this.muR != null) {
                aVar.e(2, this.muR);
            }
            if (this.muS != null) {
                aVar.e(3, this.muS);
            }
            if (this.muT != null) {
                aVar.e(4, this.muT);
            }
            if (this.msw != null) {
                aVar.eQ(5, this.msw.aUk());
                this.msw.a(aVar);
            }
            if (this.msF == null) {
                return 0;
            }
            aVar.e(6, this.msF);
            return 0;
        } else if (i == 1) {
            if (this.msh != null) {
                r0 = a.a.a.b.b.a.f(1, this.msh) + 0;
            } else {
                r0 = 0;
            }
            if (this.muR != null) {
                r0 += a.a.a.b.b.a.f(2, this.muR);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(3, this.muS);
            }
            if (this.muT != null) {
                r0 += a.a.a.b.b.a.f(4, this.muT);
            }
            if (this.msw != null) {
                r0 += a.a.a.a.eN(5, this.msw.aUk());
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(6, this.msF);
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
            bb bbVar = (bb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bbVar.msh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    bbVar.muR = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bbVar.muS = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bbVar.muT = aVar3.xmD.readString();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a bnVar = new bn();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bnVar.a(aVar4, bnVar, a.a(aVar4))) {
                        }
                        bbVar.msw = bnVar;
                    }
                    return 0;
                case 6:
                    bbVar.msF = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
