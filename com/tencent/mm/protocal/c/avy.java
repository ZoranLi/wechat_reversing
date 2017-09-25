package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class avy extends a {
    public int tZt;
    private boolean tZu;

    public final /* synthetic */ a aD(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a(aVar); a > 0; a = a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cid();
            }
        }
        return bHy();
    }

    protected final /* synthetic */ a aUl() {
        return bHy();
    }

    public final avy yn(int i) {
        this.tZt = i;
        this.tZu = true;
        return this;
    }

    public final String toString() {
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("uiVal = ").append(this.tZt).append("   ").toString())).append(")").toString();
    }

    private avy bHy() {
        if (this.tZu) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  uiVal:" + this.tZu);
    }

    public final int aUk() {
        return (a.a.a.a.eL(1, this.tZt) + 0) + 0;
    }

    public final byte[] toByteArray() {
        bHy();
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        aVar.eO(1, this.tZt);
    }

    public final boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        avy com_tencent_mm_protocal_c_avy = (avy) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_avy.yn(aVar.xmD.mL());
                return true;
            default:
                return false;
        }
    }
}
