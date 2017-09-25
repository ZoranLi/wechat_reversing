package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;

public final class u extends a {
    public String gxM;
    public int jNX;
    public int jNY;
    public long jNZ;
    public String mediaId;
    public String path;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jNX);
            if (this.gxM != null) {
                aVar.e(2, this.gxM);
            }
            if (this.mediaId != null) {
                aVar.e(3, this.mediaId);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            aVar.eO(5, this.type);
            aVar.eO(6, this.jNY);
            aVar.O(7, this.jNZ);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jNX) + 0;
            if (this.gxM != null) {
                r0 += a.a.a.b.b.a.f(2, this.gxM);
            }
            if (this.mediaId != null) {
                r0 += a.a.a.b.b.a.f(3, this.mediaId);
            }
            if (this.path != null) {
                r0 += a.a.a.b.b.a.f(4, this.path);
            }
            return ((r0 + a.a.a.a.eL(5, this.type)) + a.a.a.a.eL(6, this.jNY)) + a.a.a.a.N(7, this.jNZ);
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
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.jNX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    uVar.gxM = aVar3.xmD.readString();
                    return 0;
                case 3:
                    uVar.mediaId = aVar3.xmD.readString();
                    return 0;
                case 4:
                    uVar.path = aVar3.xmD.readString();
                    return 0;
                case 5:
                    uVar.type = aVar3.xmD.mL();
                    return 0;
                case 6:
                    uVar.jNY = aVar3.xmD.mL();
                    return 0;
                case 7:
                    uVar.jNZ = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
