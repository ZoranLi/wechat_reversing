package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g extends d {
    public g(i iVar) {
        this.xnn = 2064;
        this.xno = 2;
        this.xnq = iVar;
    }

    public final byte[] bL(byte[] bArr) {
        int length;
        int i;
        int i2 = this.xnq.xnA;
        byte[] cio = this.xnq.xnv.cio();
        oicq.wlogin_sdk.a.g gVar = this.xnq.xnw;
        Object obj = new byte[gVar.xoi];
        if (gVar.xoi > 0) {
            System.arraycopy(gVar.xnh, gVar.xok, obj, 0, gVar.xoi);
        }
        f fVar = new f();
        ao aoVar = new ao();
        Object bM = fVar.bM(cio);
        Object m = aoVar.m(bArr, obj);
        Object obj2 = new byte[(bM.length + m.length)];
        if (cio.length > 0) {
            System.arraycopy(bM, 0, obj2, 0, bM.length);
            length = bM.length + 0;
            i = 1;
        } else {
            length = 0;
            i = 0;
        }
        System.arraycopy(m, 0, obj2, length, m.length);
        a(this.xni, this.xnn, xnj, this.xnq._uin, this.xnk, this.xnl, i2, this.xnm, super.j(obj2, this.xno, i + 1));
        return super.cil();
    }
}
