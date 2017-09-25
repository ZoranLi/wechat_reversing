package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h extends d {
    public h(i iVar) {
        this.xnn = 2064;
        this.xno = 3;
        this.xnq = iVar;
    }

    public final int l(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        int G = super.G(bArr, i + 2);
        super.cim();
        int i3 = i + 5;
        switch (G) {
            case 2:
                int n = fVar.n(bArr, i3, this.xnc - i3);
                if (n >= 0) {
                    this.xnq.xnv = fVar;
                    n = gVar.n(bArr, i3, this.xnc - i3);
                    if (n >= 0) {
                        this.xnq.xnw = gVar;
                        return G;
                    }
                }
                return n;
            case 5:
                super.k(bArr, i3, (this.xnc - i3) - 1);
                return G;
            default:
                k(bArr, i3, (this.xnc - i3) - 1);
                return G;
        }
    }
}
