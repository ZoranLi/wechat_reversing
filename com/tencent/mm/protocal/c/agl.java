package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class agl extends avh {
    public String lUw;
    public String msh;
    public String scope;
    public String signature;
    public String tLm;
    public String tLo;
    public String tLp;
    public b tLq;
    public int tLr;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.msh != null) {
                aVar.e(3, this.msh);
            }
            if (this.tLm != null) {
                aVar.e(4, this.tLm);
            }
            if (this.lUw != null) {
                aVar.e(5, this.lUw);
            }
            if (this.tLo != null) {
                aVar.e(6, this.tLo);
            }
            if (this.signature != null) {
                aVar.e(7, this.signature);
            }
            if (this.tLp != null) {
                aVar.e(8, this.tLp);
            }
            if (this.tLq != null) {
                aVar.b(9, this.tLq);
            }
            aVar.eO(10, this.tLr);
            if (this.scope == null) {
                return 0;
            }
            aVar.e(11, this.scope);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.msh != null) {
                r0 += a.a.a.b.b.a.f(3, this.msh);
            }
            if (this.tLm != null) {
                r0 += a.a.a.b.b.a.f(4, this.tLm);
            }
            if (this.lUw != null) {
                r0 += a.a.a.b.b.a.f(5, this.lUw);
            }
            if (this.tLo != null) {
                r0 += a.a.a.b.b.a.f(6, this.tLo);
            }
            if (this.signature != null) {
                r0 += a.a.a.b.b.a.f(7, this.signature);
            }
            if (this.tLp != null) {
                r0 += a.a.a.b.b.a.f(8, this.tLp);
            }
            if (this.tLq != null) {
                r0 += a.a.a.a.a(9, this.tLq);
            }
            r0 += a.a.a.a.eL(10, this.tLr);
            if (this.scope != null) {
                r0 += a.a.a.b.b.a.f(11, this.scope);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            agl com_tencent_mm_protocal_c_agl = (agl) objArr[1];
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
                        com_tencent_mm_protocal_c_agl.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agl.url = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agl.msh = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agl.tLm = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agl.lUw = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agl.tLo = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agl.signature = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agl.tLp = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agl.tLq = aVar3.cic();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_agl.tLr = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_agl.scope = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
