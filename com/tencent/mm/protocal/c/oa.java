package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class oa extends a {
    public String desc;
    public String opP;
    public String title;
    public LinkedList<String> ttG = new LinkedList();
    public String ttH;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.d(4, 1, this.ttG);
            if (this.opP != null) {
                aVar.e(5, this.opP);
            }
            if (this.ttH == null) {
                return 0;
            }
            aVar.e(6, this.ttH);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(3, this.desc);
            }
            r0 += a.a.a.a.c(4, 1, this.ttG);
            if (this.opP != null) {
                r0 += a.a.a.b.b.a.f(5, this.opP);
            }
            if (this.ttH != null) {
                r0 += a.a.a.b.b.a.f(6, this.ttH);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.ttG.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            oa oaVar = (oa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oaVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    oaVar.url = aVar3.xmD.readString();
                    return 0;
                case 3:
                    oaVar.desc = aVar3.xmD.readString();
                    return 0;
                case 4:
                    oaVar.ttG.add(aVar3.xmD.readString());
                    return 0;
                case 5:
                    oaVar.opP = aVar3.xmD.readString();
                    return 0;
                case 6:
                    oaVar.ttH = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
