package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class avw extends a {
    public int tZn;
    private boolean tZo;
    public b tZp;
    public boolean tZq;

    public final /* synthetic */ a aD(byte[] bArr) {
        return bc(bArr);
    }

    protected final /* synthetic */ a aUl() {
        return bHx();
    }

    private avw ym(int i) {
        this.tZn = i;
        this.tZo = true;
        return this;
    }

    public final avw bb(byte[] bArr) {
        b aU = b.aU(bArr);
        b(aU);
        ym(aU.sYA.length);
        return this;
    }

    public final avw z(byte[] bArr, int i) {
        b h = b.h(bArr, 0, i);
        b(h);
        ym(h.sYA.length);
        return this;
    }

    public final avw b(b bVar) {
        if (bVar == null) {
            bb(null);
        }
        this.tZp = bVar;
        this.tZq = true;
        ym(this.tZp.sYA.length);
        return this;
    }

    public final String toString() {
        Object stringBuilder = new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("iLen = ").append(this.tZn).append("   ").toString();
        if (this.tZq) {
            stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("Buffer = ").append(this.tZp).append("   ").toString();
        }
        return new StringBuilder(String.valueOf(stringBuilder)).append(")").toString();
    }

    private avw bHx() {
        if (this.tZo) {
            return this;
        }
        throw new a.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.tZo);
    }

    public final int aUk() {
        int eL = a.a.a.a.eL(1, this.tZn) + 0;
        if (this.tZq) {
            eL += a.a.a.a.a(2, this.tZp);
        }
        return eL + 0;
    }

    public final byte[] toByteArray() {
        bHx();
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        aVar.eO(1, this.tZn);
        if (this.tZq) {
            aVar.b(2, this.tZp);
        }
    }

    public final boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        avw com_tencent_mm_protocal_c_avw = (avw) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_avw.ym(aVar.xmD.mL());
                return true;
            case 2:
                com_tencent_mm_protocal_c_avw.b(aVar.cic());
                return true;
            default:
                return false;
        }
    }

    public final avw bc(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cid();
            }
        }
        return bHx();
    }
}
