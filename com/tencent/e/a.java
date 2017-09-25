package com.tencent.e;

public final class a implements com.tencent.e.b.a {
    private g xiZ;
    private boolean xja = true;

    protected a(g gVar) {
        this.xiZ = gVar;
    }

    public final void q(String str, Object obj) {
        if (this.xja) {
            f chd = f.chd();
            if (obj == null) {
                throw new h("TpfServiceCenter|registerService|name or service should not be null");
            }
            synchronized (chd.xjg) {
                chd.xje.put(str, obj);
            }
        }
    }
}
