package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class dg extends a {
    public dh tgB;
    public di tgH;
    public b tgI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgH == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.tgB == null) {
                throw new a.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.tgI == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.tgH != null) {
                    aVar.eQ(1, this.tgH.aUk());
                    this.tgH.a(aVar);
                }
                if (this.tgB != null) {
                    aVar.eQ(2, this.tgB.aUk());
                    this.tgB.a(aVar);
                }
                if (this.tgI == null) {
                    return 0;
                }
                aVar.b(3, this.tgI);
                return 0;
            }
        } else if (i == 1) {
            if (this.tgH != null) {
                r0 = a.a.a.a.eN(1, this.tgH.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tgB != null) {
                r0 += a.a.a.a.eN(2, this.tgB.aUk());
            }
            if (this.tgI != null) {
                r0 += a.a.a.a.a(3, this.tgI);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgH == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.tgB == null) {
                throw new a.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.tgI != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dg dgVar = (dg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a diVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        diVar = new di();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = diVar.a(aVar4, diVar, a.a(aVar4))) {
                        }
                        dgVar.tgH = diVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        diVar = new dh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = diVar.a(aVar4, diVar, a.a(aVar4))) {
                        }
                        dgVar.tgB = diVar;
                    }
                    return 0;
                case 3:
                    dgVar.tgI = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
