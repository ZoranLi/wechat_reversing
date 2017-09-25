package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class avx extends a {
    public String tZr;
    public boolean tZs;

    public final /* synthetic */ a aD(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cid();
            }
        }
        return this;
    }

    protected final /* bridge */ /* synthetic */ a aUl() {
        return this;
    }

    public final avx OV(String str) {
        this.tZr = str;
        this.tZs = true;
        return this;
    }

    public final String toString() {
        return this.tZr;
    }

    public final int aUk() {
        int i = 0;
        if (this.tZs) {
            i = a.a.a.b.b.a.f(1, this.tZr) + 0;
        }
        return i + 0;
    }

    public final byte[] toByteArray() {
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        if (this.tZs) {
            aVar.e(1, this.tZr);
        }
    }

    public final boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        avx com_tencent_mm_protocal_c_avx = (avx) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_avx.OV(aVar.xmD.readString());
                return true;
            default:
                return false;
        }
    }
}
