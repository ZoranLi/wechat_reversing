package com.tencent.mm.plugin.game.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.em;
import java.util.LinkedList;

public final class aa extends avh {
    public String msh;
    public String mti;
    public b mtk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.msh == null) {
                throw new a.a.a.b("Not all required fields were included: AppID");
            } else if (this.mti == null) {
                throw new a.a.a.b("Not all required fields were included: GroupID");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.msh != null) {
                    aVar.e(2, this.msh);
                }
                if (this.mti != null) {
                    aVar.e(3, this.mti);
                }
                if (this.mtk == null) {
                    return 0;
                }
                aVar.b(4, this.mtk);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.msh != null) {
                r0 += a.a.a.b.b.a.f(2, this.msh);
            }
            if (this.mti != null) {
                r0 += a.a.a.b.b.a.f(3, this.mti);
            }
            if (this.mtk != null) {
                r0 += a.a.a.a.a(4, this.mtk);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msh == null) {
                throw new a.a.a.b("Not all required fields were included: AppID");
            } else if (this.mti != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: GroupID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
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
                        aaVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    aaVar.msh = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aaVar.mti = aVar3.xmD.readString();
                    return 0;
                case 4:
                    aaVar.mtk = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
